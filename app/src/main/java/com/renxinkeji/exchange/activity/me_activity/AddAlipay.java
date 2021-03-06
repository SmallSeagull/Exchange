package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class AddAlipay extends BaseActivity implements View.OnClickListener {

    private View imgAddalipayLeft;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alipay);
        initViewData();
    }

    private void initViewData() {
        imgAddalipayLeft = findViewById(R.id.img_add_alipay_left);

        imgAddalipayLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_add_alipay_left:
                intent = getIntent();
                setResult(0x12,intent);
                finish();
                break;
        }
    }
}
