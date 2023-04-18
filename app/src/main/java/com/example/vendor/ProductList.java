package com.example.vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vendor.MyAdaptor;
import com.example.vendor.Product;
import com.example.vendor.ProductCRUD;
import com.example.vendor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    FloatingActionButton addProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ListView listView = findViewById(R.id.listview);
        Intent i = getIntent();
        ArrayList<Product> list = i.getParcelableArrayListExtra("prdList");
        MyAdaptor adapter = new MyAdaptor(this,list);
        listView.setAdapter(adapter);
        addProduct = findViewById(R.id.addProduct);
        addProduct.setOnClickListener(view -> {
            startActivity(new Intent(ProductList.this, ProductCRUD.class));
        });
    }
}






