package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class AddBankCard extends BaseActivity implements View.OnClickListener {

    private View imgBankCardLeft;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bank_card);
        initBankCardData();
    }

    private void initBankCardData() {
        imgBankCardLeft = findViewById(R.id.img_add_Bank_card_left);

        imgBankCardLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_add_Bank_card_left:
                intent = getIntent();
                setResult(0x12,intent);
                finish();
                break;
        }

    }


}
