package com.example.mytoyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;

import android.os.Message;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import com.example.mytoyshop.Dao.UserDao;

public class MainActivity2 extends AppCompatActivity {
    private Button Btnregister;
    private Button Btnlogin;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout);
        initView();
        initView1();

    }

    private void initView1() {
        Btnregister = (Button)findViewById(R.id.btn_login2 );
        Btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        Btnlogin = (Button)findViewById(R.id.btn_login);
        Btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,UserMainActivity3.class);
                startActivity(intent);
            }
        });

    }




}


