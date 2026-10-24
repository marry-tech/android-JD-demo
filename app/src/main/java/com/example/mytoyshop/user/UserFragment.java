package com.example.mytoyshop.user;

import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.mytoyshop.base.BaseFragment;
import com.example.mytoyshop.R;

public class UserFragment extends BaseFragment {

    private GridView user_tools;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_user, null);
        user_tools = view.findViewById(R.id.user_tools);
        return view;
    }

    public void initData(){
        super.initData();
        int[] icons = {R.drawable.tools1,R.drawable.tools2,R.drawable.tools3,R.drawable.tools4,
                R.drawable.tools5,R.drawable.tools6,R.drawable.tools7,R.drawable.tools8,
                R.drawable.tools9,R.drawable.tools10,R.drawable.tools11,R.drawable.tools12};
        String[] names = {"客户服务","寄件服务","主题换肤","闲置换钱",
                "问医生","有奖晒单","发票服务", "VIP会员",
                "二手回收","我的预约","我的拼购","小程序"};
        user_tools.setAdapter(new UserToolsAdapter(mContext, icons, names));
    }
}
