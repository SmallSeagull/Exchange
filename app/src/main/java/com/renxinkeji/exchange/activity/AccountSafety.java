package com.renxinkeji.exchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;

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
        imgAccountLeft = findViewById(R.id.img_account_safety_left);
        lltAccountRealname = findViewById(R.id.llt_account_realname);
        lltAccountLogin = findViewById(R.id.llt_account_reset_login);
        lltAccountTransation = findViewById(R.id.llt_account_reset_transaction);

        imgAccountLeft.setOnClickListener(this);
        lltAccountRealname.setOnClickListener(this);
        lltAccountLogin.setOnClickListener(this);
        lltAccountTransation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_account_safety_left:
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                ToastUtils.show(getApplicationContext(),"点击了返回按钮");
                break;
            case R.id.llt_account_realname:
                intentAccount = new Intent(getApplicationContext(), RealnameIdentification.class);
                startActivityForResult(intentAccount,0x11);

                ToastUtils.show(getApplicationContext(),"您点了实名认证");
                break;
            case R.id.llt_account_reset_login:
                ToastUtils.show(getApplicationContext(),"您点了重置登录密码");
                break;
            case R.id.llt_account_reset_transaction:
                ToastUtils.show(getApplicationContext(),"重置交易密码");
                break;
        }
    }
}
