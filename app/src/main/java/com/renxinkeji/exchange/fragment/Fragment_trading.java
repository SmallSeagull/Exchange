package com.renxinkeji.exchange.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment_Trading_Buyin fragmentTradingBuy;
    private Fragment_Trading_Sellout fragmentTradingSellout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trading_page, container, false);
        //获取fragment的管理者，进行切换买入卖出的fragment
        manager = getActivity().getSupportFragmentManager();
        initTitleData();

        trading_buy_in.performClick();  //默认显示买入页面
        return view;

    }

    private void initTitleData() {
        trading_buy_in = view.findViewById(R.id.trading_view_in);
        trading_sell_out = view.findViewById(R.id.trading_view_out);

        /*获取买入，卖出的布局控件*/

        trading_buy_in.setOnClickListener(this);
        trading_sell_out.setOnClickListener(this);
    }

    /*隐藏买入卖出fragment*/
    public void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fragmentTradingBuy!=null)fragmentTransaction.hide(fragmentTradingBuy);
        if(fragmentTradingSellout!=null)fragmentTransaction.hide(fragmentTradingSellout);
    }


    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();   //fragment管理执行者
        hideAllFragment(transaction);       //隐藏买入卖出的fragment
        switch ((v.getId())){
            case R.id.trading_view_in:
                if (fragmentTradingBuy == null){
                    fragmentTradingBuy = new Fragment_Trading_Buyin();
                    transaction.add(R.id.fragment_Trading,fragmentTradingBuy);//引入买入fragment
                }else {
                    transaction.show(fragmentTradingBuy);
                }
                /*标题栏买入按钮默认显示灰色，点击后变色*/
                trading_buy_in.setEnabled(false);
                trading_buy_in.setPressed(false);
                trading_sell_out.setEnabled(true);  //未点击的颜色

//                ToastUtils.show(getContext(),"您点击了买入");
                break;
            case R.id.trading_view_out:
                if(fragmentTradingSellout == null){
                    fragmentTradingSellout = new Fragment_Trading_Sellout();
                    transaction.add(R.id.fragment_Trading,fragmentTradingSellout);//引入卖出fragment
                }else {
                    transaction.show(fragmentTradingSellout);
                }

                /*卖出按钮默认显示深蓝色，点击后显示灰色，卖出按钮显示回面默认颜色*/
                trading_buy_in.setEnabled(true);
                trading_sell_out.setEnabled(false); //点击了的颜色
                ToastUtils.show(getContext(),"您点击了卖出");
                break;
        }
        transaction.commit();

    }




}
