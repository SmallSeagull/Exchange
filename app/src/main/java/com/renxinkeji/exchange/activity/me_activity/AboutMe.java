package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class AboutMe extends BaseActivity implements View.OnClickListener {

    private View imgAboutLeft;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);
        initViewData();
    }

    private void initViewData() {
        imgAboutLeft = findViewById(R.id.img_about_me_left);

        imgAboutLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_about_me_left:
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                break;
        }

    }
}
