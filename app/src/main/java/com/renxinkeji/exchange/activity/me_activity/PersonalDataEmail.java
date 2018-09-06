package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class PersonalDataEmail extends BaseActivity implements View.OnClickListener {

    private View imgEmailLeft;
    private Intent intentPersonal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_email);

        initEmailData();
    }

    private void initEmailData() {
        imgEmailLeft = findViewById(R.id.img_Email_left);

        imgEmailLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Email_left:
                //返回个人资料界面
                intentPersonal = getIntent();
                setResult(0x13,intentPersonal);
                finish();
                break;
        }
    }
}
