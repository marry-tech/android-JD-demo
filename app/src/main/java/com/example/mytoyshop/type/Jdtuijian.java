package com.example.mytoyshop.type;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mytoyshop.base.BaseFragment;
import com.example.mytoyshop.home.Goods;
import com.example.mytoyshop.home.GoodsListAdapter;
import com.example.mytoyshop.R;

import java.util.ArrayList;

public class Jdtuijian extends BaseFragment {

    private GoodsListAdapter goodsListAdapter,goodsListAdapter2,goodsListAdapter3,
            goodsListAdapter4,goodsListAdapter5,goodsListAdapter6;
    private ArrayList<Goods> goodsList,goodsList2,goodsList3,goodsList4,
            goodsList5,goodsList6;
    private ListView type_list;
    private GridView gridview_jd_r1;
    private TextView tv_jd_commr1;
    private String[] imagenames1 = {"LeGo","BarBie","漫威","贝亲","奥斯双钻", "变形金刚"};
    private int[] ids1 = {R.drawable.legao,R.drawable.barbie2,R.drawable.disney3,
            R.drawable.beiqin,R.drawable.ad1,R.drawable.transform};

    @Override
    public View initView() {
        //初始化界面
        View view = View.inflate(mContext, R.layout.type_grid,null);
        gridview_jd_r1 = view.findViewById(R.id.gridview_jd_r1);
        tv_jd_commr1 = view.findViewById(R.id.tv_jd_commr1);
        type_list = view.findViewById(R.id.type_list);
        gridview_jd_r1.setAdapter(new HomeAdapter1());

        GridListener();

        return view;
    }
    public void initData(){
        super.initData();
        goodsList = new ArrayList<>();
        //int g_id, int g_photo, String g_name, String g_type, double g_price, int g_sales, String g_shop

        goodsList.add(new Goods(9,R.drawable.lego1,"乐高模型1","母婴",779.00,2800,"乐高自营旗舰店"));
        goodsList.add(new Goods(10,R.drawable.legao,"乐高模型2","青少年",829.00,21000,"乐高旗舰店"));
        goodsList.add(new Goods(11,R.drawable.legao2,"乐高模型3","成人",789.00,3000,"乐高旗舰店"));

        goodsList2 = new ArrayList<>();
        goodsList2.add(new Goods(12,R.drawable.barbie_1,"芭比公主的衣柜","儿童",289.00,14000,"BarBie旗舰店"));
        goodsList2.add(new Goods(13,R.drawable.barbie,"芭比公主","母婴",209.00,18000,"Barbie旗舰店"));
        goodsList2.add(new Goods(14,R.drawable.barbie2,"人鱼公主","儿童 女性向",499.00,9000,"Barbie旗舰店"));

        goodsList3 = new ArrayList<>();
        goodsList3.add(new Goods(15,R.drawable.disney2,"迪士尼公主裙","儿童",330.00,390000,"迪士尼旗舰店"));
        goodsList3.add(new Goods(16,R.drawable.disney3,"蜘蛛侠","模型",669.00,18000,"迪士尼旗舰店"));
        goodsList3.add(new Goods(17,R.drawable.disney4,"爱莎公主珠宝盒","儿童",399.00,10000,"迪士尼旗舰店"));

        goodsList4 = new ArrayList<>();
        goodsList4.add(new Goods(18,R.drawable.danzhuguidao,"儿童弹珠轨道","轨道",2199.00,30000,"弹珠旗舰店"));
        goodsList4.add(new Goods(19,R.drawable.chuzhi,"垂直门帘","弹珠",2498.00,21000,"弹珠旗舰店"));
        goodsList4.add(new Goods(20,R.drawable.gunqiushu,"轨道树","儿童益智",286.00,31000,"弹珠旗舰店"));

        goodsList5 = new ArrayList<>();
        goodsList5.add(new Goods(21,R.drawable.ertngyaoling,"儿童摇铃","母婴",199.00,5300,"曼哈顿旗舰店"));

        goodsList6 = new ArrayList<>();
        goodsList6.add(new Goods(22,R.drawable.ad1,"旋风陀螺","蓝色",299.00,9000,"奥迪双钻旗舰店"));
        goodsList6.add(new Goods(23,R.drawable.ad2,"超级飞侠","黄色",249.00,999,"奥迪双钻旗舰店"));
        goodsList6.add(new Goods(24,R.drawable.ad3,"果宝特攻","橙子",65.00,5,"奥迪双钻旗舰店"));
        goodsList6.add(new Goods(25,R.drawable.ad4,"遥控圣战车（MI）10","蓝色 ",379.00,19,"奥迪双钻旗舰店"));
        goodsList6.add(new Goods(26,R.drawable.ad5,"炎龙枪","红色",48.00,18,"奥迪双钻旗舰店"));

    }
    //显示gridview内容
    public class HomeAdapter1 extends BaseAdapter {
        @Override
        public int getCount() {
            return imagenames1.length;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            tv_jd_commr1.setText("常用分类");
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.type_grid_item1, null);
            ImageView iv_icon = (ImageView) view.findViewById(R.id.ic_icon);
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(imagenames1[position]);
            iv_icon.setImageResource(ids1[position]);
            return view;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
    //监听GridView点击事件
    private void GridListener(){
        gridview_jd_r1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position + 1;// id是从0开始的，所以需要+1
                switch (index){
                    case 1:
                        //实例化适配器
                        goodsListAdapter = new GoodsListAdapter(mContext,goodsList);
                        type_list.setAdapter(goodsListAdapter);
                        type_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                int indexs = position + 1;
                                if (indexs == 1){
                                   Intent intent;
                                    intent = new Intent(mContext,ChatActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                        break;
                    case 2:
                        goodsListAdapter2 = new GoodsListAdapter(mContext,goodsList2);
                        type_list.setAdapter(goodsListAdapter2);
                        break;
                    case 3:
                        goodsListAdapter3 = new GoodsListAdapter(mContext,goodsList3);
                        type_list.setAdapter(goodsListAdapter3);
                        break;
                    case 4:
                        goodsListAdapter4 = new GoodsListAdapter(mContext,goodsList4);
                        type_list.setAdapter(goodsListAdapter4);
                        break;
                    case 5:
                        goodsListAdapter5 = new GoodsListAdapter(mContext,goodsList5);
                        type_list.setAdapter(goodsListAdapter5);
                        break;
                    case 6:
                        goodsListAdapter6 = new GoodsListAdapter(mContext,goodsList6);
                        type_list.setAdapter(goodsListAdapter6);
                        break;
                        default:
                            break;
                }
                //Toast.makeText(getActivity(), "你按下了选项：" + index, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
