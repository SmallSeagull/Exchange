package com.renxinkeji.exchange.activity.me_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class ForgetLoginPassword extends BaseActivity {

    private View viewResetPhone;
    private View tvAuthCode;
    private View viewResetPassword;
    private View viewResetConfirmPassword;
    private View btnReset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_login_password);

        initViewDate();
    }

    private void initViewDate() {

        viewResetPhone = findViewById(R.id.view_reset_phone);    //获取手机号控件
        tvAuthCode = findViewById(R.id.tv_reset_auth_code);      //获取验证码控件
        viewResetPassword = findViewById(R.id.view_reset_password); //获取重置密码控件
        viewResetConfirmPassword = findViewById(R.id.view_confirm_reset_password);  //获取确密码控件
        btnReset = findViewById(R.id.btn_register);     //获取确认修改按钮控件

//        viewResetPhone.setOnClickListener(new ResetPsOnClickListener());   //手机号添加监听
//        tvAuthCode.setOnClickListener(new ResetPsOnClickListener());        //验证码添加监听
//        viewResetPassword.setOnClickListener(new ResetPsOnClickListener()); //重置登录密码添加监听
//        viewResetConfirmPassword.setOnClickListener(new ResetPsOnClickListener());  //确认密码添加监听
//        btnReset.setOnClickListener(new ResetPsOnClickListener());      //确认修改添加监听


    }


    class ResetPsOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.view_reset_phone:

                    break;
                case R.id.tv_reset_auth_code:

                    break;
                case R.id.view_reset_password:

                    break;
                case R.id.view_confirm_reset_password:

                    break;
            }
        }
    }



}
