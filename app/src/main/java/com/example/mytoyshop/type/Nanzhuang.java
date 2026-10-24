package com.example.mytoyshop.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytoyshop.base.BaseFragment;
import com.example.mytoyshop.R;

public class Nanzhuang extends BaseFragment {
    private GridView gridview_jd_r1;
    private TextView tv_jd_commr1;
    private String[] imagenames4 = {"奥特曼","铠甲勇士","漫威","水枪","泡泡机","卡牌"};
    private int[] ids4 = {R.drawable.aoteman,R.drawable.kajiayongshi,R.drawable.disney4,
            R.drawable.shuiqiang,R.drawable.paopaoji,R.drawable.tudouhiadao};

    @Override
    public View initView() {
        //初始化界面
        View view = View.inflate(mContext, R.layout.type_grid,null);
        gridview_jd_r1 = view.findViewById(R.id.gridview_jd_r1);
        tv_jd_commr1 = view.findViewById(R.id.tv_jd_commr1);
        gridview_jd_r1.setAdapter(new HomeAdapter4());
        return view;
    }
    public void initData(){
        super.initData();
    }
    //显示gridview内容
    public class HomeAdapter4 extends BaseAdapter {
        @Override
        public int getCount() {
            return imagenames4.length;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            tv_jd_commr1.setText("专场推荐");
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.type_grid_item1, null);
            ImageView iv_icon = (ImageView) view.findViewById(R.id.ic_icon);
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(imagenames4[position]);
            iv_icon.setImageResource(ids4[position]);
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
}
