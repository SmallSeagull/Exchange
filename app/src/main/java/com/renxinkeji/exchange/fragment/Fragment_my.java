package com.renxinkeji.exchange.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.me_activity.AboutMe;
import com.renxinkeji.exchange.activity.me_activity.AccountSafety;
import com.renxinkeji.exchange.activity.me_activity.CommonProblems;
import com.renxinkeji.exchange.activity.me_activity.PersonalData;
import com.renxinkeji.exchange.activity.me_activity.RecommendRebate;
import com.renxinkeji.exchange.activity.me_activity.SetPage;


public class Fragment_my extends Fragment implements View.OnClickListener{

    private View view;
    private Intent intent;
    private View imgmeSet;              //声明标题设置控件
    private View lltAccountSafety;      //声明账户安全控件
    private View lltMeRecommend;        //声明推荐返佣控件
    private View lltPersonalData;
    private View lltCommon;
    private View lltAbout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.me_page, container, false);   //引入我的页面布局

        initViewData();         //初始化我的界面数据
        return view;
    }

    private void initViewData() {
        //获取  我的  界面的控件
        imgmeSet = view.findViewById(R.id.img_me_set);  //获取设置按钮
        lltPersonalData = view.findViewById(R.id.llt_me_personal); //获取个人资料控件
        lltAccountSafety = view.findViewById(R.id.llt_me_account_safety); //获取账户安全控件
        lltMeRecommend = view.findViewById(R.id.llt_me_recommend); //获取推荐返佣控件
        lltCommon = view.findViewById(R.id.llt_me_common);         //获取常见问题控件
        lltAbout = view.findViewById(R.id.llt_me_about);           //关于我们控件

        imgmeSet.setOnClickListener(this);                      //设置按钮添加监听
        lltPersonalData.setOnClickListener(this);               //个人资料添加监听
        lltAccountSafety.setOnClickListener(this);              //账户安全添加监听
        lltMeRecommend.setOnClickListener(this);                //推荐返佣添加监听
        lltCommon.setOnClickListener(this);                     //常见问题添加监听
        lltAbout.setOnClickListener(this);                      //关于我们添加监听
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //设置控件
            case R.id.img_me_set:
                intent = new Intent(getActivity(), SetPage.class);
                startActivityForResult(intent,0x10);

                break;
            //个人资料控件
            case R.id.llt_me_personal:
                intent = new Intent(getActivity(), PersonalData.class);
                startActivityForResult(intent,0x10);
                break;
            //账户安全控件
            case R.id.llt_me_account_safety:
                intent = new Intent(getActivity(),AccountSafety.class);
                startActivityForResult(intent,0x10);

                break;
            //推荐返佣控件
            case R.id.llt_me_recommend:
                intent = new Intent(getActivity(), RecommendRebate.class);
                startActivityForResult(intent,0x10);

                break;
            //常见问题控件
            case R.id.llt_me_common:
                intent = new Intent(getActivity(), CommonProblems.class);
                startActivityForResult(intent,0x10);

                break;
            //关于我们控件
            case R.id.llt_me_about:
                intent = new Intent(getActivity(), AboutMe.class);
                startActivityForResult(intent,0x10);

                break;
        }

    }
}
