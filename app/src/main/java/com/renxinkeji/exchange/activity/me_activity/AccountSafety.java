package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;
import com.renxinkeji.exchange.activity.BaseActivity;

public class AccountSafety extends BaseActivity implements View.OnClickListener{

    private View imgAccountLeft;
    private View lltAccountRealname;
    private View lltAccountLogin;
    private View lltAccountTransation;
    private Intent intent;
    private Intent intentAccount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_safety);
        initViewData();
    }

    private void initViewData() {
        imgAccountLeft = findViewById(R.id.img_account_safety_left);    //返回上一个界面控件
        lltAccountRealname = findViewById(R.id.llt_account_realname);   //获取实名认证控件
        lltAccountLogin = findViewById(R.id.llt_account_reset_login);   //获取重置登录密码控件
        lltAccountTransation = findViewById(R.id.llt_account_reset_transaction);   //获取重置交易密码控件

        imgAccountLeft.setOnClickListener(this);        //返回按钮添加监听
        lltAccountRealname.setOnClickListener(this);    //实名认证添加监听
        lltAccountLogin.setOnClickListener(this);       //重置登录密码添加监听
        lltAccountTransation.setOnClickListener(this);  //获取重置交易密码添加监听
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_account_safety_left:
                //跳转返回界面
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                ToastUtils.show(getApplicationContext(),"点击了返回按钮");
                break;
            case R.id.llt_account_realname:
                //跳转实名认证界面
                intentAccount = new Intent(getApplicationContext(), RealnameIdentification.class);
                startActivityForResult(intentAccount,0x11);

                ToastUtils.show(getApplicationContext(),"您点了实名认证");
                break;
            case R.id.llt_account_reset_login:
                //跳转重置登录密码界面
                intentAccount = new Intent(getApplicationContext(),ResetLoginPassword.class);
                startActivityForResult(intentAccount,0x11);

                ToastUtils.show(getApplicationContext(),"您点了重置登录密码");
                break;
            case R.id.llt_account_reset_transaction:
                //跳转重置交易密码界面

                ToastUtils.show(getApplicationContext(),"重置交易密码");
                break;
        }
    }
}
