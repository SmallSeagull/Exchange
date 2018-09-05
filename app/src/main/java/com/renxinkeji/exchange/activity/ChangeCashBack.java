package com.renxinkeji.exchange.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renxinkeji.exchange.R;

public class ChangeCashBack extends BaseActivity implements View.OnClickListener {

    private View imgChangeCashBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_cash_back);
        initDataView();
    }

    private void initDataView() {
        imgChangeCashBack = findViewById(R.id.img_Change_cash_back_left);

        imgChangeCashBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Change_cash_back_left:

                break;
        }

    }
}
