package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

public class CollectionWay extends BaseActivity implements View.OnClickListener {

    private View imgCollectionWayLeft;
    private Intent intent;              //接收我的界面数据intent
    private View imgCollectionWayplus;
    private Intent intentAdd;           //收款界面数据intent
    public View view;
    private AddPopBottomAnim addPopBottomAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_way);
        initViewData();
    }

    private void initViewData() {
        imgCollectionWayLeft = findViewById(R.id.img_Collection_way_left);  //获取返回控件
        imgCollectionWayplus = findViewById(R.id.img_Collection_way_plus);

        imgCollectionWayLeft.setOnClickListener(this);  //给返回控件添加监听
        imgCollectionWayplus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_Collection_way_left:
                intent = getIntent();
                setResult(0x10,intent);
                finish();
                break;

            case R.id.img_Collection_way_plus:

                showPopFormBottom(view);

                break;

        }
    }

    public void showPopFormBottom(View view) {
        //给底部划出动画布局添加监听
        addPopBottomAnim = new AddPopBottomAnim(this,onClickListener);
        /*设置弹出框的显示位置是从parent布局底部弹出,同时获得父布局中的点击显示弹窗的控件*/
        addPopBottomAnim.showAtLocation(findViewById(R.id.img_Collection_way_plus), Gravity.CENTER,0,0);

    }
    private View.OnClickListener onClickListener = new View.OnClickListener(){


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.llt_add_Pay:
                    intentAdd = new Intent(getApplicationContext(),AddAlipay.class);    //跳转添加支付宝界面活动
                    startActivityForResult(intentAdd,0x12);

                    Log.i("zhang","点击了支付宝");
                    break;
                case R.id.llt_Add_WeChat:

                    Log.i("zhang","点击了微信");
                    break;
                case R.id.llt_Bank_Card:
                    intentAdd = new Intent(getApplicationContext(),AddBankCard.class);  //跳转添加银行卡界面活动
                    startActivityForResult(intentAdd,0x12);

                    Log.i("zhang","点击了银行卡");
                    break;
            }
        }
    };


}
