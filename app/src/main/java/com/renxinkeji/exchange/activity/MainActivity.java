package com.renxinkeji.exchange.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.Toast.ToastUtils;
import com.renxinkeji.exchange.fragment.Fragment_bonus;
import com.renxinkeji.exchange.fragment.Fragment_home_page;
import com.renxinkeji.exchange.fragment.Fragment_my;
import com.renxinkeji.exchange.fragment.Fragment_thewallet;
import com.renxinkeji.exchange.fragment.Fragment_trading;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private FragmentManager manager;

    private Fragment_home_page Frag_home_page;
    private Fragment_trading Frag_trading_page;
    private Fragment_bonus Frag_bonus_page;
    private Fragment_thewallet Frag_wallet_page;
    private Fragment_my Frag_my_page;

    private FragmentTransaction beginTransaction;

    private View llthome;
    private View llttrading;
    private View lltbonus;
    private View lltwallet;
    private View lltme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取fragment的管理者,进行切换fragment
        manager = getSupportFragmentManager();
        initData();
        setStatus();
        //默认显示首页布局
        llthome.performClick();

    }
    /*
    * 开始
    * */
    @Override
    protected void onStart() {
        super.onStart();

    }



    private void initData() {
        llthome = findViewById(R.id.llt_home);
        llttrading = findViewById(R.id.llt_trading);
        lltbonus = findViewById(R.id.llt_bonus);
        lltwallet = findViewById(R.id.llt_wallet);
        lltme = findViewById(R.id.llt_me);

        llthome.setOnClickListener(this);
        llttrading.setOnClickListener(this);
        lltbonus.setOnClickListener(this);
        lltwallet.setOnClickListener(this);
        lltme.setOnClickListener(this);
    }



    private void setSelected(){
        llthome.setSelected(false);

        llttrading.setSelected(false);
        lltbonus.setSelected(false);
        lltwallet.setSelected(false);
        lltme.setSelected(false);
    }

    /*
    * 隐藏所以的Fragment
    * */
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(Frag_home_page != null)fragmentTransaction.hide(Frag_home_page);
        if(Frag_trading_page != null)fragmentTransaction.hide(Frag_trading_page);
        if(Frag_bonus_page != null)fragmentTransaction.hide(Frag_bonus_page);
        if(Frag_wallet_page != null)fragmentTransaction.hide(Frag_wallet_page);
        if(Frag_my_page != null)fragmentTransaction.hide(Frag_my_page);
    }



    @Override
    public void onClick(View v) {
        beginTransaction = manager.beginTransaction();
        hideAllFragment(beginTransaction);
        switch (v.getId()){
            case R.id.llt_home:
                setSelected();
                llthome.setSelected(true);
                if(Frag_home_page == null){
                    Frag_home_page = new Fragment_home_page();
                    beginTransaction.add(R.id.fragment_page,Frag_home_page);
                }else {
                    beginTransaction.show(Frag_home_page);
                }
                break;
            case R.id.llt_trading:
                setSelected();
                llttrading.setSelected(true);
                if(Frag_trading_page==null){
                    Frag_trading_page = new Fragment_trading();
                    beginTransaction.add(R.id.fragment_page,Frag_trading_page);
                }else {
                    beginTransaction.show(Frag_trading_page);
                }

                break;
            case R.id.llt_bonus:
                setSelected();
                lltbonus.setSelected(true);
                if(Frag_bonus_page==null){
                    Frag_bonus_page = new Fragment_bonus();
                    beginTransaction.add(R.id.fragment_page,Frag_bonus_page);
                }else {
                    beginTransaction.show(Frag_bonus_page);
                }
                break;
            case R.id.llt_wallet:
                setSelected();
                lltwallet.setSelected(true);
                if(Frag_wallet_page==null){
                    Frag_wallet_page = new Fragment_thewallet();
                    beginTransaction.add(R.id.fragment_page,Frag_wallet_page);
                }else {
                    beginTransaction.show(Frag_wallet_page);
                }

                break;
            case R.id.llt_me:
                setSelected();
                lltme.setSelected(true);
                if(Frag_my_page==null){
                    Frag_my_page = new Fragment_my();
                    beginTransaction.add(R.id.fragment_page,Frag_my_page);
                }else {
                    beginTransaction.show(Frag_my_page);
                }

                break;
        }
        beginTransaction.commit();

    }


    /*
     * 暂停
     * */
    @Override
    protected void onPause() {
        super.onPause();

    }
    /*
     * 运行
     * */

    @Override
    protected void onResume() {
        super.onResume();

    }
    /*
     * 销毁
     * */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
        ToastUtils.show(getApplicationContext(),"您关闭了这个活动");
    }


    public void setStatus() {
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
}
