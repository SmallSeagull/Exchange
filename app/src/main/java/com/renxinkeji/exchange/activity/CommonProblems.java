package com.renxinkeji.exchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;

public class CommonProblems extends BaseActivity implements View.OnClickListener {

    private View imgCommonLeft;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_problems);
        initViewData();
    }

    private void initViewData() {
        imgCommonLeft = findViewById(R.id.img_Common_Problems_left);

        imgCommonLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Common_Problems_left:
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                break;
        }
    }
}
