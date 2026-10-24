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

public class JdShoping extends BaseFragment {

    private GridView gridview_jd_r1;
    private TextView tv_jd_commr1;
    private String[] imagenames2 = {"漫威","乐高","小猪佩奇","大黄蜂","迪士尼公主", "贝亲"};
    private int[] ids2 = {R.drawable.disney3,R.drawable.legao,R.drawable.peiqi,
            R.drawable.dahuangfeng,R.drawable.gognzhu,R.drawable.beiqin};

    @Override
    public View initView() {
        //初始化界面
        View view = View.inflate(mContext, R.layout.type_grid,null);
        gridview_jd_r1 = view.findViewById(R.id.gridview_jd_r1);
        tv_jd_commr1 = view.findViewById(R.id.tv_jd_commr1);
        gridview_jd_r1.setAdapter(new HomeAdapter2());
        return view;
    }
    public void initData(){
        super.initData();
    }
    //显示gridview内容
    public class HomeAdapter2 extends BaseAdapter {
        @Override
        public int getCount() {
            return imagenames2.length;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            tv_jd_commr1.setText("日用百货");
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.type_grid_item1, null);
            ImageView iv_icon = view.findViewById(R.id.ic_icon);
            TextView tv_name = view.findViewById(R.id.tv_name);
            tv_name.setText(imagenames2[position]);
            iv_icon.setImageResource(ids2[position]);
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
