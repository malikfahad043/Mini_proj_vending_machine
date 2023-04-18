package com.example.vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private EditText username,password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponent();
        settingUpListners();
    }
    private void settingUpListners() {
        login.setOnClickListener(view -> {
            String u_name = username.getText().toString();
            String u_pass = password.getText().toString();
            SharedPreferences pref = getSharedPreferences("registerAPP",MODE_PRIVATE);
            String s_userName = pref.getString("userName","");
            String s_password = pref.getString("password","");
            if(u_name.equals(s_userName)&&u_pass.equals(s_password)){
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,ProductCRUD.class));
            }
            else{
                Toast.makeText(this, "User name or password are invalid", Toast.LENGTH_SHORT).show();
            }


        });
    }

    private void initComponent() {
        username = findViewById(R.id.u_username);
        password = findViewById(R.id.u_password);
        login = findViewById(R.id.u_login);
    }
}