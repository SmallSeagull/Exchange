package com.renxinkeji.exchange.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.MainActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Fragment_home_page extends Fragment implements OnBannerListener{

    private View view;
    //初始化轮播图数据
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private MyImageLoader myImageLoader;
    private Banner mBanner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_page,container,false);

        initData();
        initView();
        return view;

    }

    private void initData() {
        //初始化轮播图数据
        myImageLoader = new MyImageLoader();
        mBanner = view.findViewById(R.id.banner);
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add(R.mipmap.ic_home_backgrou);
        imagePath.add(R.drawable.beibei2);
        imagePath.add(R.drawable.beibei3);
        imagePath.add(R.drawable.beibei4);
        imageTitle.add("链接未来");
        imageTitle.add("链接全球");
        imageTitle.add("链接城市");
        imageTitle.add("链接你我");
    }

    private void initView() {

        //设置轮播样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(myImageLoader);
        //设置轮播的动画效果
        mBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        //轮播图的文字
        mBanner.setBannerTitles(imageTitle);
        //设置轮播间隔时间
        mBanner.setDelayTime(2500);
        //设置是否自动轮播，默认是true
        mBanner.isAutoPlay(true);
        //设置指示器的位置，居中显示
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片的加载地址
        mBanner.setImages(imagePath).setOnBannerListener(this).start();


    }


    /*
     * 轮播图的监听
     * */
    @Override
    public void OnBannerClick(int position) {

    }
    /*
     * 图片加载类
     * */
    public class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

}
