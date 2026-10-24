package com.example.mytoyshop.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytoyshop.R;
import com.example.mytoyshop.base.BaseFragment;

public class ShoujiS extends BaseFragment {
    private GridView gridview_jd_r1;
    private TextView tv_jd_commr1;
    private String[] imagenames6 = {"电子狗","遥控坦克","遥控直升机","乐高盆景","小猪佩奇","小熊玩偶"};
    private int[] ids6 = {R.drawable.dog
            ,R.drawable.tanke,R.drawable.yaokongfeiji,
            R.drawable.legao2,R.drawable.pig,R.drawable.bear};

    @Override
    public View initView() {
        //初始化界面
        View view = View.inflate(mContext, R.layout.type_grid,null);
        gridview_jd_r1 = view.findViewById(R.id.gridview_jd_r1);
        tv_jd_commr1 = view.findViewById(R.id.tv_jd_commr1);
        gridview_jd_r1.setAdapter(new HomeAdapter6());
        return view;
    }
    public void initData(){
        super.initData();
    }
    //显示gridview内容
    public class HomeAdapter6 extends BaseAdapter {
        @Override
        public int getCount() {
            return imagenames6.length;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            tv_jd_commr1.setText("爆款推荐");
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.type_grid_item1, null);
            ImageView iv_icon = (ImageView) view.findViewById(R.id.ic_icon);
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(imagenames6[position]);
            iv_icon.setImageResource(ids6[position]);
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
