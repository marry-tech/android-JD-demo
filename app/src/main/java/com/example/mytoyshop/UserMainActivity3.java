package com.example.mytoyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytoyshop.home.HomeFragment;

public class UserMainActivity3 extends AppCompatActivity {
   private Button BtnJoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin_main);
        initView();
    }

    private void initView() {
        BtnJoin = (Button)findViewById(R.id.btn_login5);
        BtnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserMainActivity3.this, MActivity.class);
                startActivity(intent);
            }
        });
    }


    }
