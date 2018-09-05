package com.renxinkeji.exchange.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;

public class Fragment_thewallet extends Fragment implements View.OnClickListener{

    private View view;
    private View imgWalletLeft;
    private View imgWallerEye;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wallet_page, container, false);
        initViewData();
        return view;

    }

    private void initViewData() {
        imgWalletLeft = view.findViewById(R.id.img_wallet_left);
        imgWallerEye = view.findViewById(R.id.img_wallet_eyes);

        imgWalletLeft.setOnClickListener(this);
        imgWallerEye.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_wallet_left:
                ToastUtils.show(getContext(),"您点击了返回按钮");
                break;
            case R.id.img_wallet_eyes:
                ToastUtils.show(getContext(),"您点击了眼睛按钮");
                break;
        }
    }
}
