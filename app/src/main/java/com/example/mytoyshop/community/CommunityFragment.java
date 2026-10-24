package com.example.mytoyshop.community;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mytoyshop.base.BaseFragment;
import com.example.mytoyshop.home.Goods;
import com.example.mytoyshop.R;

import java.util.ArrayList;

public class CommunityFragment extends BaseFragment {

    private ListView shop_list;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_community, null);
        shop_list = view.findViewById(R.id.shop_list);
        return view;
    }

    public void initData(){
        super.initData();
        ArrayList<Shop> shops = new ArrayList<>();
        Goods s1_goods1 = new Goods(R.drawable.disney2,"迪士尼公主裙",2599.00);
        Goods s1_goods2 = new Goods(R.drawable.disney3,"蜘蛛侠手办",3999.00);
        Goods s1_goods3 = new Goods(R.drawable.disney4,"艾莎的珠宝",4999.00);
        shops.add(new Shop(R.drawable.logo4,"迪士尼旗舰店",s1_goods1,s1_goods2,s1_goods3));

        Goods s2_goods1 = new Goods(R.drawable.barbie_1,"芭比公主",259.00);
        Goods s2_goods2 = new Goods(R.drawable.barbie,"芭比的宫殿",239.00);
        Goods s2_goods3 = new Goods(R.drawable.barbie2,"人鱼公主",6999.00);
        shops.add(new Shop(R.drawable.logo6,"BarBie旗舰店",s2_goods1,s2_goods2,s2_goods3));

        ShopListAdapter adapter = new ShopListAdapter(mContext, shops);
        shop_list.setAdapter(adapter);
    }
}
