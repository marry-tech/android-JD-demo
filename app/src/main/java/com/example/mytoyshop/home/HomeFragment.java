package com.example.mytoyshop.home;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytoyshop.R;
import com.example.mytoyshop.base.BaseFragment;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {

    private ListView lv_home;
    private ImageView ib_top;
    private TextView tv_search_home, tv_message_home;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        lv_home = view.findViewById(R.id.lv_home);
        ib_top = view.findViewById(R.id.ib_top);
        tv_search_home = view.findViewById(R.id.tv_search_home);
        tv_message_home = view.findViewById(R.id.tv_message_home);
        initListener();
        return view;
    }

    public void initData(){
        super.initData();

        ArrayList<Goods> goods = new ArrayList<>();
        //int g_id, int g_photo, String g_name, String g_type, double g_price, int g_sales, String g_shop
        goods.add(new Goods(1,R.drawable.disney2,"迪士尼公主裙","儿童",299.00,9,"迪士尼旗舰店"));
        goods.add(new Goods(2,R.drawable.disney3,"蜘蛛侠手办","漫威",2499.00,99,"迪士尼旗舰店"));
        goods.add(new Goods(3,R.drawable.disney4,"艾莎的珠宝","儿童",159.00,5,"迪士尼旗舰店"));
        goods.add(new Goods(4,R.drawable.barbie_1,"芭比公主","娃娃",379.00,19,"BarBie旗舰店"));
        goods.add(new Goods(5,R.drawable.barbie,"芭比的宫殿","模型",4488.00,18,"BarBie旗舰店"));
        goods.add(new Goods(6,R.drawable.barbie2,"人鱼公主","遥控",5999.00,12,"BarBie旗舰店"));
        goods.add(new Goods(7,R.drawable.ad1,"旋风陀螺","陀螺",188.00,1,"奥迪双钻旗舰店"));
        goods.add(new Goods(8,R.drawable.ad2,"超级飞侠","黄色",99.00,99999999,"奥迪双钻旗舰店"));

        GoodsListAdapter adapter = new GoodsListAdapter(mContext, goods);
        lv_home.setAdapter(adapter);
    }

    private void initListener(){

        ib_top.setOnClickListener(v -> {
            //滑动回到顶部
            lv_home.smoothScrollToPosition(0);
        });

        tv_search_home.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://www.baidu.com"));
            startActivity(intent);
        });

        tv_message_home.setOnClickListener(v -> {
            Toast.makeText(mContext, "进入消息中心！", Toast.LENGTH_SHORT).show();
        });
        
    }
}
