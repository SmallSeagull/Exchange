package com.renxinkeji.exchange.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;

public class Fragment_trading extends Fragment implements View.OnClickListener{

    private View view;
    private View trading_buy_in;
    private View trading_sell_out;
    private LayoutInflater inflater;
    private View viewbuy;
    private View tvExchangePassword;
    private View btnNegative;
    private View btnPosition;
    private AlertDialog.Builder builder;
    private AlertDialog mAlertDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trading_page, container, false);
        initTitleData();
        return view;

    }

    private void initTitleData() {
        trading_buy_in = view.findViewById(R.id.trading_view_in);
        trading_sell_out = view.findViewById(R.id.trading_view_out);

        trading_buy_in.setOnClickListener(this);
        trading_sell_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.trading_view_in:
                trading_buy_in.setEnabled(false);
                trading_buy_in.setPressed(false);
                trading_sell_out.setEnabled(true);  //未点击的颜色
                //弹出交易密码弹框
                initAlertDialog();
                ToastUtils.show(getContext(),"您点击了买入");
                break;
            case R.id.trading_view_out:
                trading_buy_in.setEnabled(true);
                trading_sell_out.setEnabled(false); //点击了的颜色
                ToastUtils.show(getContext(),"您点击了卖出");
                break;
        }

    }

    private void initAlertDialog() {
        inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewbuy = inflater.inflate(R.layout.buying_alertdialog, null);

        tvExchangePassword = viewbuy.findViewById(R.id.tv_Exchange_password);   //获取输入密码文本框
        btnNegative = viewbuy.findViewById(R.id.btn_Negative);          //获取取消按钮
        btnPosition = viewbuy.findViewById(R.id.btn_Positive);          //获取确定按钮
        builder = new AlertDialog.Builder(getContext());
        builder.setView(viewbuy);       //设置显示布局

        mAlertDialog = builder.create();
        mAlertDialog.setCancelable(false);
        mAlertDialog.show();


        btnPosition.setOnClickListener(new View.OnClickListener() {

            private String tvExchange_password;

            @Override
            public void onClick(View v) {
                tvExchange_password = tvExchangePassword.getContext().toString().trim();
                Toast.makeText(getContext(),"买入成功",Toast.LENGTH_SHORT).show();
            }
        });

        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
                Toast.makeText(getContext(),"买入取消",Toast.LENGTH_SHORT).show();
            }
        });



    }


}
