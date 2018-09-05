package com.renxinkeji.exchange.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.renxinkeji.exchange.Log.LogUtils;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //打印出当前实例的类名
        Log.i("BaseActivity",getClass().getSimpleName());
        ActivityCollector.addActivity(this);            //将当前正在创建的活动添加到活动管理器中

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);         //将一个马上销毁的活动从活动管理器中移除
    }
}
