package com.renxinkeji.exchange.activity.me_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;
import com.renxinkeji.exchange.activity.BaseActivity;

public class PersonalData extends BaseActivity implements View.OnClickListener {

    private View imgPersonalLeft;
    private Intent intent;
    private View lltName;
    private View lltUserId;
    private View lltEmail;
    private View lltPhone;
    private View layout;
    private Window window;

    private View tvChangeNickname;
    private LayoutInflater inflater;
    private View view;
    private View etChangeNickname;
    private AlertDialog myAlertDialog;
    private View btn_Positive;
    private View btn_Negative;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_data);
        initViewData();
    }

    private void initViewData() {
        imgPersonalLeft = findViewById(R.id.img_personal_left);//获取返回按钮控件
        lltName = findViewById(R.id.llt_personal_name);//获取昵称控件
        lltUserId = findViewById(R.id.llt_personal_UserId);//获取用户ID
        lltEmail = findViewById(R.id.llt_personal_Email);
        lltPhone = findViewById(R.id.llt_personal_Phone);

        imgPersonalLeft.setOnClickListener(this);
        lltName.setOnClickListener(this);
        lltUserId.setOnClickListener(this);
        lltEmail.setOnClickListener(this);
        lltPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_personal_left:
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                break;
            case R.id.llt_personal_name:

                initAlertDialog();

                break;
            case R.id.llt_personal_UserId:

                break;
            case R.id.llt_personal_Email:

                break;
            case R.id.llt_personal_Phone:

                break;

            case R.id.tv_personal_Login_time:

                break;
            case R.id.tv_personal_Login_IP:

                break;
        }

    }

    private void initAlertDialog() {
        inflater = (LayoutInflater) this.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.personal_alertdialog, null);
        etChangeNickname = view.findViewById(R.id.tv_change_nickname);    //获取用户修改昵称
        btn_Positive = view.findViewById(R.id.btn_Positive);            //获取确认按钮
        btn_Negative = view.findViewById(R.id.btn_Negative);            //获取取消按钮
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);      //设置显示布局
        myAlertDialog = builder.create();
        myAlertDialog.setCancelable(false);
        myAlertDialog.show();

        //确认
        btn_Positive.setOnClickListener(new View.OnClickListener() {

            private String etNickname;

            @Override
            public void onClick(View v) {
                etNickname = etChangeNickname.getContext().toString().trim();

                Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
        //取消
        btn_Negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlertDialog.dismiss();     //关闭弹出框
                Toast.makeText(getApplicationContext(),"您以取消修改",Toast.LENGTH_SHORT).show();
            }
        });



    }


}
