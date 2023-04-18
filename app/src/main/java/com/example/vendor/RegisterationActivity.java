package com.example.vendor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterationActivity extends AppCompatActivity {

    private EditText username,password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        initComponent();
        settingUpListners();
    }

    private void settingUpListners() {
        register.setOnClickListener(view -> {
            String u_name = username.getText().toString();
            String u_pass = password.getText().toString();
            SharedPreferences pref = getSharedPreferences("registerAPP",MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("userName",u_name);
            editor.putString("password",u_pass);
            editor.apply();
            startActivity(new Intent(RegisterationActivity.this,LoginActivity.class));
        });
    }

    private void initComponent() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
    }
}