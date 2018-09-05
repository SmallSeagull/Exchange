package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;
import com.renxinkeji.exchange.activity.BaseActivity;

public class RecommendRebate extends BaseActivity implements View.OnClickListener{


    private Intent intent;
    private View imgRecommendLeft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_rebate);
        initViewData();
    }

    private void initViewData() {
        imgRecommendLeft = findViewById(R.id.img_recommend_left);

        imgRecommendLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_recommend_left:
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                break;
            case R.id.tv_title_share:

                break;

        }

    }
}
