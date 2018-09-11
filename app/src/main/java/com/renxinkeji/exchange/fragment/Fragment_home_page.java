package com.renxinkeji.exchange.fragment;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.me_activity.PersonalDataEmail;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Fragment_home_page extends Fragment implements OnBannerListener {

    private View view;
    //初始化轮播图数据
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private MyImageLoader myImageLoader;
    private Banner mBanner;
    private View tvRMZ;
    private View tvUSDT;
    private View tvBTC;
    private View tvETH;
    private View tvYYB;
    private ViewPager viewPageHome;
    private LayoutInflater layoutInflater;
    private View RMZlyt;
    private View USDTlyt;
    private View BTClyt;
    private View ETHlyt;
    private View YYBlyt;
    private ArrayList<View> homeViewlist;
    private View homeCursor;
    private int CursorWidth;
    private DisplayMetrics Dm;
    private int widthPixels;
    private int offset;
    private int number = 0;     //划标滑到的当前页数
    private Transformation transformation;
    private Matrix matrix;
    private PageHomeAdapter pageHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_page, container, false);

        initData();             //数据初始化
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

        //初始化滑动布局空控件，tab栏的控件
        tvRMZ = view.findViewById(R.id.tv_home_RMZ);
        tvUSDT = view.findViewById(R.id.tv_home_USDT);
        tvBTC = view.findViewById(R.id.tv_home_BTC);
        tvETH = view.findViewById(R.id.tv_home_ETH);
        tvYYB = view.findViewById(R.id.tv_home_yingyongban);

        viewPageHome = view.findViewById(R.id.viewPage_Home);   //获取home页的ViewPage

        layoutInflater = getLayoutInflater();       //获取页面布局管理器


        RMZlyt = layoutInflater.inflate(R.layout.rmz_layout, null); //获取RMZ页面
        USDTlyt = layoutInflater.inflate(R.layout.usdt_layout, null);   //获取USDT页面
        BTClyt = layoutInflater.inflate(R.layout.btc_layout, null);     //获取BTC页面
        ETHlyt = layoutInflater.inflate(R.layout.eth_layout, null);     //获取ETH页面
        YYBlyt = layoutInflater.inflate(R.layout.yyb_layout, null);     //获取应用版页面

        /*将tab栏对应显示的页面添加到ArrayList中*/

        homeViewlist = new ArrayList<>();   //添加页面集合
        //将页面添加到集合中
        homeViewlist.add(RMZlyt);
        homeViewlist.add(USDTlyt);
        homeViewlist.add(BTClyt);
        homeViewlist.add(ETHlyt);
        homeViewlist.add(YYBlyt);

        /*初始化图片指示器的位置*/
        initHomeCursorPosition();

        /*设置适配器*/
        pageHomeAdapter = new PageHomeAdapter(homeViewlist);
        viewPageHome.setAdapter(pageHomeAdapter);       //给ViewPage设置适配器

        /*设置当前页面*/
        viewPageHome.setCurrentItem(0);
        /*监听页面改变*/
        viewPageHome.setOnPageChangeListener(new NewHomePageChangeListener());

        /*tab页面监听*/
        tvRMZ.setOnClickListener(new TabHomeOnClickListener(0));
        tvUSDT.setOnClickListener(new TabHomeOnClickListener(1));
        tvBTC.setOnClickListener(new TabHomeOnClickListener(2));
        tvETH.setOnClickListener(new TabHomeOnClickListener(3));
        tvYYB.setOnClickListener(new TabHomeOnClickListener(4));





    }

    /*初始化指示图标数据*/
    private void initHomeCursorPosition() {

        homeCursor = view.findViewById(R.id.view_home_cursor);  //获取滑动指示控件
        CursorWidth = homeCursor.getWidth();    //获取滑动游标的宽度
        Dm = new DisplayMetrics();      //初始化DisplayMetrics对象
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(Dm);  //将当前窗口信息放到DisplayMetrics中
        widthPixels = Dm.widthPixels;   //获取分辨率的宽度

        offset = (widthPixels / homeViewlist.size() - CursorWidth) / 2;//计算偏移量【保证滑动条在tab栏标签下的正中间】

        transformation = new Transformation();
        matrix = transformation.getMatrix();
        matrix.postTranslate(offset, 0);
        homeCursor.setTag(matrix);      //滑动控件设置移动的位置

    }


    /*页面改变监听*/
    public class NewHomePageChangeListener implements ViewPager.OnPageChangeListener{

        int one = offset * 2 +CursorWidth;     //页卡1到页卡2偏移量
        int two = one * 2;                      //页卡1到页卡3的偏移量
        int three = one * 3;                    //页卡1到页卡4的偏移量
        int four = one * 4;                     //页卡1到页卡5的偏移量



        @Override
        public void onPageSelected(int i) {
            Animation animation = null;
            switch (i){
                case 0:
                    if(number == 1){
                        animation = new TranslateAnimation(one, 0, 0, 0);
                    } else if(number == 2){
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    } else if(number == 3){
                        animation = new TranslateAnimation(three, 0, 0, 0);
                    } else if(number == 4){
                        animation = new TranslateAnimation(four,0,0,0);
                    }
                    break;
                case 1:
                    if(number == 0){
                        animation = new TranslateAnimation(offset,one,0,0);
                    } else if(number == 2){
                        animation = new TranslateAnimation(two,one,0,0);
                    } else if(number == 3){
                        animation = new TranslateAnimation(three,one,0,0);
                    } else if(number == 4){
                        animation = new TranslateAnimation(four,one,0,0);
                    }

                    break;
                case 2:
                    if(number == 0){
                        animation = new TranslateAnimation(offset,two,0,0);
                    } else if(number == 1){
                        animation = new TranslateAnimation(one,two,0,0);
                    } else if(number == 3){
                        animation = new TranslateAnimation(three,two,0,0);
                    } else if(number == 4){
                        animation = new TranslateAnimation(four,two,0,0);

                    }

                    break;
                case 3:
                    if(number == 0){
                        animation = new TranslateAnimation(offset,three,0,0);
                    } else if(number == 1){
                        animation = new TranslateAnimation(one,three,0,0);
                    } else if(number == 2){
                        animation = new TranslateAnimation(two,three,0,0);
                    } else if(number == 4){
                        animation = new TranslateAnimation(four,three,0,0);
                    }

                    break;
                case 4:
                    if(number == 0){
                        animation = new TranslateAnimation(offset,four,0,0);
                    } else if(number == 1){
                        animation = new TranslateAnimation(one,four,0,0);
                    } else if(number == 2){
                        animation = new TranslateAnimation(two,four,0,0);
                    } else if(number == 3){
                        animation = new TranslateAnimation(three,four,0,0);
                    }

                    break;

            }

            number = i;
            animation.setFillAfter(true);   //true: 图片停在动画结束的位置
            animation.setDuration(200);     //设置滑动的时间
            homeCursor.startAnimation(animation);  //开启动画

        }

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }


        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }


    /*Tab栏添加监听*/
    public class TabHomeOnClickListener implements View.OnClickListener{

        private int num;
        public TabHomeOnClickListener(int index){
            num = index;
        }

        @Override
        public void onClick(View v) {
            viewPageHome.setCurrentItem(num);
        }
    }


    /*给ViewPage页面设置适配器*/
    private class PageHomeAdapter extends PagerAdapter {

        public List<View> homeViewlist; //初始化一个list集合

        public PageHomeAdapter(ArrayList<View> homeViewlist) {

            this.homeViewlist = homeViewlist;

        }


        @Override
        public int getCount() {
            //返回要滑东view的个数
            return homeViewlist.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //从当前container指定的位置删除 position 的view
            container.removeView(homeViewlist.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //实例化：将当前视图添加到container中去，并返回当前View 传送key
            container.addView(homeViewlist.get(position));
            return homeViewlist.get(position);
        }
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
