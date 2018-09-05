package com.renxinkeji.exchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;

public class RealnameIdentification extends BaseActivity implements View.OnClickListener {

    private View imgRealnameSubmitLeft;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realname_submit_audit);
        initViewData();
    }

    private void initViewData() {
        imgRealnameSubmitLeft = findViewById(R.id.img_Realname_submit_left);

        imgRealnameSubmitLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Realname_submit_left:
                intent = getIntent();
                setResult(0x11,intent);
                finish();
                break;
        }
    }
}
