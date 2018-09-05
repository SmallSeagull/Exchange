package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;
import com.renxinkeji.exchange.activity.ActivityCollector;
import com.renxinkeji.exchange.activity.BaseActivity;

public class SetPage extends BaseActivity {

    private View setBtnExit;
    private View setLeft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_set_page);
        initViewData();
    }

    private void initViewData() {
        setBtnExit = findViewById(R.id.set_btn_exit);
        setLeft = findViewById(R.id.img_set_left);

        setBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();             //关闭所有活动并退出
                //杀掉当前进程
//                android.os.Process.killProcess(android.os.Process.myPid());

                ToastUtils.show(getApplicationContext(),"您点击了退出登录");
            }
        });

        setLeft.setOnClickListener(new View.OnClickListener() {

            private Intent intent;

            @Override
            public void onClick(View v) {
                intent = getIntent();
                setResult(0x10,intent);
                finish();
            }
        });


    }
}
