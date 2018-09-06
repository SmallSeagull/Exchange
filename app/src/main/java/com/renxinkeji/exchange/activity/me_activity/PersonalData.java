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
    private Intent intentme;
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
    private Intent intent1;
    private Intent intentEmail;

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
        lltEmail = findViewById(R.id.llt_personal_Email);   //获取邮箱
        lltPhone = findViewById(R.id.llt_personal_Phone);   //获取手机

        imgPersonalLeft.setOnClickListener(this);           //返回控件添加监听
        lltName.setOnClickListener(this);                   //昵称控件添加监听
        lltUserId.setOnClickListener(this);                 //用户ID控件添加监听
        lltEmail.setOnClickListener(this);                  //邮箱控件添加监听
        lltPhone.setOnClickListener(this);                  //手机控件添加监听
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_personal_left:
                //返回个人资料界面
                intentme = getIntent();
                setResult(0x10,intentme);
                finish();
                break;
            case R.id.llt_personal_name:
                //弹出修改昵称弹窗
                initAlertDialog();

                break;
            case R.id.llt_personal_UserId:

                break;
            case R.id.llt_personal_Email:
                //跳转到邮箱活动
                intentEmail = new Intent(getApplicationContext(),PersonalDataEmail.class);
                startActivityForResult(intentEmail,0x13);
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
