package com.example.mytoyshop;
import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;

import android.os.Message;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Switch;
import android.widget.Toast;

import com.example.mytoyshop.Dao.UserDao;

import com.example.mytoyshop.cart.CartDBOpenHelper;
import com.example.mytoyshop.home.HomeFragment;
import com.example.mytoyshop.po.User;
import com.example.mytoyshop.utils.DBHelper;

public class RegisterActivity extends AppCompatActivity {
    private EditText mEtName;
    private EditText mEtCode;
    private EditText mEtadress;
    private EditText mEtphone;
    private Button BtnRegister;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register);
        initView();


    }

    private void initView() {
        mEtName  = (EditText) findViewById(R.id.et_username);

        mEtCode =(EditText) findViewById(R.id.et_password);

        mEtphone =(EditText) findViewById(R.id.et_phone);

        mEtadress =(EditText) findViewById(R.id.et_adress);
        BtnRegister = (Button)findViewById(R.id.btn_login2);
        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(RegisterActivity.this, HomeFragment.class);
                startActivity(intent);



            }
        });





    }


}


