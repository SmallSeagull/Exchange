package com.renxinkeji.exchange.activity.me_activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.renxinkeji.exchange.R;

public class AddPopBottomAnim extends PopupWindow{

    private  View view;
    private View lltAddPay;
    private View lltAddWeChat;
    private View lltAddBankCard;
    private ColorDrawable drawableColor;

    public AddPopBottomAnim(Context context, View.OnClickListener itemsOnClick) {
        this.view = LayoutInflater.from(context).inflate(R.layout.add_bottom_layout, null);

        lltAddPay = view.findViewById(R.id.llt_add_Pay);        //获取添加支付宝的控件
        lltAddWeChat = view.findViewById(R.id.llt_Add_WeChat);  //获取添加微信的控件
        lltAddBankCard = view.findViewById(R.id.llt_Bank_Card); //获取添加银行卡的控件

        lltAddPay.setOnClickListener(itemsOnClick);
        lltAddWeChat.setOnClickListener(itemsOnClick);
        lltAddBankCard.setOnClickListener(itemsOnClick);

        //设置弹出框外可以点击销毁弹出框
        this.setOutsideTouchable(true);
        //设置弹出框点击改变事件监听
        this.view.setOnTouchListener(new View.OnTouchListener() {

            private float y;        //定义手指点击的屏幕的高度
            private int height;     //定义弹出宽框屏幕的高度

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                height = view.findViewById(R.id.Pop_layout_bottom).getTop();    //获取弹出框的高度
                y = event.getY();   //获取手指点击屏幕的高度
                //如果点击的高度大于弹出框的高度，那么就销毁弹出框
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(y>height){
                        dismiss();
                    }
                }

                return true;
            }
        });

        /*设置弹出框窗口的特征*/
        //设置视图
        this.setContentView(this.view);
        //设置弹出窗体的宽高
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        //设置弹出窗体外可点击
        this.setFocusable(true);

        //实例化一个ColorDrawable颜色为半透明
        drawableColor = new ColorDrawable(0xb0000000);
        //设置窗体弹出的背景
        this.setBackgroundDrawable(drawableColor);
        //设置弹窗体的动画从底部向上弹出
        this.setAnimationStyle(R.style.dialog_animation);


    }



}
