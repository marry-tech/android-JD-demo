package com.example.mytoyshop.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytoyshop.R;
import com.example.mytoyshop.MainActivity;
import com.example.mytoyshop.MActivity;
import java.io.File;

public class DingdanActivity extends AppCompatActivity {

    private TextView ding_money, ding_buy;
    private EditText u_address, u_name, u_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);

        ding_money = findViewById(R.id.ding_money);
        ding_buy = findViewById(R.id.ding_buy);
        u_address = findViewById(R.id.u_address);
        u_name = findViewById(R.id.u_name);
        u_phone = findViewById(R.id.u_phone);

        Intent intent = getIntent();
        double money = intent.getDoubleExtra("money", 0.0);
        ding_money.setText("合计:￥" + money);

        getUserInfo();

        ding_buy.setOnClickListener(v -> {
            String address = u_address.getText().toString().trim();
            String name = u_name.getText().toString().trim();
            String phone = u_phone.getText().toString().trim();
            SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
            //默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("address",address);
            editor.putString("name",name);
            editor.putString("phone",phone);
            editor.apply();

            delCartAll();
            Toast.makeText(this, "支付中...", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(() -> {
                startActivity(new Intent(this,SuccessActivity.class));
                //overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            },3000);
        });
    }
    private void getUserInfo(){
        File file = new File("/data/data/com.example.mytoyshop/userInfo.xml");
        if (file.exists()){
            SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
            String address = sharedPreferences.getString("address","NOT FOUND");
            String name = sharedPreferences.getString("name","NOT FOUND");
            String phone = sharedPreferences.getString("phone","NOT FOUND");

            u_address.setText(address);
            u_name.setText(name);
            u_phone.setText(phone);
        }
    }

    //删除购物车中选中的商品
    private void delCartAll(){
        CartDBOpenHelper dbOpenHelper = new CartDBOpenHelper(this, 1);;
        //参数依次是表名，以及where条件与约束
        dbOpenHelper.getWritableDatabase().delete(
                "cart",
                "g_check=?",
                new String[]{"true"});
        dbOpenHelper.close();
    }
}
