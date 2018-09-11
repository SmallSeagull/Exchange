package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class ResetLoginPassword extends BaseActivity {


    private View imgResetloginPsLeft;
    private View lltModification;
    private View lltConfirmPs;
    private View tvSendCode;
    private View btnSetLogin;

    private Intent intentReset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_login_password);

        initViewDate();
    }

    private void initViewDate() {

        imgResetloginPsLeft = findViewById(R.id.img_reset_login_Ps_left);   //获取返回控件
        lltModification = findViewById(R.id.llt_reset_login_Ps);            //获取修改密码控件
        lltConfirmPs = findViewById(R.id.llt_Confirm_reset_login_Ps);       //获取确认修改密码控件
        tvSendCode = findViewById(R.id.tv_send_code);                   //获取发送验证码控件
        btnSetLogin = findViewById(R.id.btn_Set_login_Ps);              //获取设置控件

        imgResetloginPsLeft.setOnClickListener(new ResetPsOnClickListener());   //返回按钮添加监听
//        lltModification.setOnClickListener(new ResetPsOnClickListener());       //修改密码添加监听
//        lltConfirmPs.setOnClickListener(new ResetPsOnClickListener());          //确认修改添加监听
//        tvSendCode.setOnClickListener(new ResetPsOnClickListener());            //发送验证码添加监听
//        btnSetLogin.setOnClickListener(new ResetPsOnClickListener());           //设置控件添加监听



    }


    class ResetPsOnClickListener implements View.OnClickListener{

        ;

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_reset_login_Ps_left:

                    intentReset = getIntent();
                    setResult(0x11,intentReset);
                    finish();

                    break;
                case R.id.llt_reset_login_Ps:

                    break;
                case R.id.llt_Confirm_reset_login_Ps:

                    break;
                case R.id.tv_send_code:

                    break;
                case R.id.btn_Set_login_Ps:

                    break;
            }
        }
    }



}
