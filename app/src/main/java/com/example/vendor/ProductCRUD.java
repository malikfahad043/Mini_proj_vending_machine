package com.example.vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductCRUD extends AppCompatActivity {

    private EditText p_name,p_quantity,p_price;
    private ImageView p_img;
    private Button addProduct,listProduct;
    private ArrayList<Product> products;
    public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_crud);
        products = new ArrayList<>();
        initComponents();
        settingUpListners();
    }

    private void settingUpListners() {
        addProduct.setOnClickListener(view -> {
            Product p = new Product();
            p.setName(p_name.getText().toString());
            p.setQuantity(Integer.parseInt(p_quantity.getText().toString()));
            p.setPrice(Integer.parseInt(p_price.getText().toString()));
            p.setImageID(p_img.getId());
            products.add(p);
            Toast.makeText(this, "add successfully", Toast.LENGTH_SHORT).show();

        });
        listProduct.setOnClickListener(view -> {
            Intent i = new Intent(ProductCRUD.this,ProductList.class);
            i.putExtra("prdList",products);
            startActivity(i);

        });

    }

    private void initComponents() {
        p_name  = findViewById(R.id.prdName);
        p_quantity  = findViewById(R.id.prdquantity);
        p_price  = findViewById(R.id.prdprice);
        p_img = findViewById(R.id.prdimg);
        addProduct = findViewById(R.id.add);
        listProduct = findViewById(R.id.productList);
    }
}