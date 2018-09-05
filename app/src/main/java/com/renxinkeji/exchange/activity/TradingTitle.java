package com.renxinkeji.exchange.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;

public class TradingTitle extends LinearLayout implements View.OnClickListener{


    private View trading_buy_in;
    private View trading_sell_out;

    public TradingTitle(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.trading_title, this);
        initViewData();

    }

    private void initViewData() {
        trading_buy_in = findViewById(R.id.trading_view_in);
        trading_sell_out = findViewById(R.id.trading_view_out);

        trading_buy_in.setOnClickListener(this);
        trading_sell_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.trading_view_in:
                ToastUtils.show(getContext(),"您点击了买入");
                break;
            case R.id.trading_view_out:
                ToastUtils.show(getContext(),"您点击了卖出");
                break;
        }
    }
}
