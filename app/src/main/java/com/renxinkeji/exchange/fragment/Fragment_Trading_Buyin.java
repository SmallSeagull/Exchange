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

import static com.renxinkeji.exchange.R.layout.buying_alertdialog;

public class Fragment_Trading_Buyin extends Fragment implements View.OnClickListener {


    private View viewbuy;
    private View btnTradingBuyin;
    private LayoutInflater inflater;
    private View view;
    private View tvExchangePassword;
    private View btn_Positive;
    private View btn_Negative;
    private AlertDialog.Builder builder;
    private AlertDialog myAlertDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewbuy = inflater.inflate(R.layout.trading_buying, container, false);

        initViewData();
        return viewbuy;
    }

    private void initViewData() {
        btnTradingBuyin = viewbuy.findViewById(R.id.btn_trading_buy_in);

        btnTradingBuyin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_trading_buy_in:

                //弹出交易密码弹框


                initAlertDialog();

                Toast.makeText(getContext(),"你点击了买入按钮",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void initAlertDialog() {

        builder = new AlertDialog.Builder(getContext());
        inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.buying_alertdialog, null);

        tvExchangePassword = view.findViewById(R.id.tv_Exchange_password); //获取输入交易密码
        btn_Positive = view.findViewById(R.id.btn_Positive);            //获取确认按钮
        btn_Negative = view.findViewById(R.id.btn_Negative);            //获取取消按钮


        builder.setView(view);      //设置显示布局
        myAlertDialog = builder.create();
        myAlertDialog.setCancelable(false);
        myAlertDialog.show();

        //确认
        btn_Positive.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {



                btn_Positive.setEnabled(false);
                Setselected();
                btn_Positive.setSelected(true);

                Toast.makeText(getContext(),"修改成功",Toast.LENGTH_SHORT).show();
            }
            /**/
            private void Setselected() {
                btn_Positive.setSelected(false);
            }
        });
        //取消
        btn_Negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAlertDialog.dismiss();     //关闭弹出框
                Toast.makeText(getContext(),"您以取消修改",Toast.LENGTH_SHORT).show();
            }
        });

    }



}

