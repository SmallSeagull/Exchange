package com.renxinkeji.exchange.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renxinkeji.exchange.R;

public class Fragment_Trading_Sellout extends Fragment implements View.OnClickListener {


    private View viewsell;
    private View btnTradingSell;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewsell = inflater.inflate(R.layout.trading_sell, container, false);
        initViewData();

        return viewsell;
    }

    private void initViewData() {
        btnTradingSell = viewsell.findViewById(R.id.btn_trading_Sell);

        btnTradingSell.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_trading_Sell:

                break;
        }
    }
}
