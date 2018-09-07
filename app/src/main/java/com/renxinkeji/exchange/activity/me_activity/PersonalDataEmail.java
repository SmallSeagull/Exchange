package com.renxinkeji.exchange.activity.me_activity;

import android.content.Intent;
import android.opengl.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

import com.renxinkeji.exchange.R;
import com.renxinkeji.exchange.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PersonalDataEmail extends BaseActivity implements View.OnClickListener {

    private View imgEmailLeft;              //获取返回邮箱界面
    private Intent intentPersonal;
    private View tvEmailConfirm;            //获取确认邮箱的TextView控件
    private View tvEmailChange;             //获取修改邮箱的TextView控件
    private View tvChangeSuccess;           //获取邮箱成功的TextView控件
    private ViewPager viewPageEmail;        //获取容器ViewPage
    private LayoutInflater inflater;
    private View emailConfirm;              //邮箱确认界面
    private View emailChange;               //邮箱修修改界面
    private View emailSuccess;              //邮箱获取成功界面
    private ArrayList<View> viewList;       //定义一个存放引入布局的集合
    private NewPagerAdapter pagerAdapter;
    private View viewCursor;

    private DisplayMetrics dm;

    private int cursor_Width = 0;                //获取滑动条的宽度
    private int s_width;
    private int offset = 0;     //屏幕分成的份数，单个份数宽度去掉游标的宽度剩下的长度/2就是offset的宽度
    private int number = 0;     //当前页码编号
    private Transformation transformation;
    private android.graphics.Matrix matrix;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_email);

        initEmailData();


    }

    private void initEmailData() {
        imgEmailLeft = findViewById(R.id.img_Email_left);   //获取返回控件
        /*初始化tab栏的控件数据*/
        tvEmailConfirm = findViewById(R.id.tv_Email_confirm);   //获取邮箱确认控件
        tvEmailChange = findViewById(R.id.tv_Email_change);     //获取修改邮箱控件
        tvChangeSuccess = findViewById(R.id.tv_Email_change_success);   //获取修改成功控件

        /*初始化ViewPage添加的页面*/
        viewPageEmail = findViewById(R.id.viewPage_Email);      //获取ViewPage控件


        inflater = getLayoutInflater();                         //获取ViewPage页面管理器
        emailConfirm = inflater.inflate(R.layout.view_email_confirm, null);     //获取邮箱确认页面
        emailChange = inflater.inflate(R.layout.view_email_change, null);       //获取邮箱修改页面
        emailSuccess = inflater.inflate(R.layout.view_email_change_success, null);  //获取邮箱修改成功页面



        /*将分页显示的View装入数组中*/
        viewList = new ArrayList<>();
        viewList.add(emailConfirm);
        viewList.add(emailChange);
        viewList.add(emailSuccess);

        /*初始化指示器位置*/
        initCursorPosition();

        /*设置适配器*/
        pagerAdapter = new NewPagerAdapter(viewList);
        viewPageEmail.setAdapter(pagerAdapter);

        /*设置当前页*/
        viewPageEmail.setCurrentItem(0);
        /*监听页面改变*/
        viewPageEmail.setOnPageChangeListener(new NewPageChangeListener());

        /*tab页面监听*/
        tvEmailConfirm.setOnClickListener(new TabOnClickListener(0));
        tvEmailChange.setOnClickListener(new TabOnClickListener(1));
        tvChangeSuccess.setOnClickListener(new TabOnClickListener(2));

        //给返回控件设置监听
        imgEmailLeft.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Email_left:
                //返回个人资料界面
                intentPersonal = getIntent();
                setResult(0x13,intentPersonal);
                finish();
                break;


        }
    }

    /*初始化指示器位置*/
    private void initCursorPosition() {

        viewCursor = findViewById(R.id.view_cursor);        //获取滑动条控件
        cursor_Width = viewCursor.getWidth();                //获取滑动条的宽度
        dm = new DisplayMetrics();            //初始化DisplayMEtrics对象
        getWindowManager().getDefaultDisplay().getMetrics(dm);  //将当前窗口信息放入DisplayMetrucs类中
        s_width = dm.widthPixels;       //获取分辨率宽度

        offset = (s_width / viewList.size() - cursor_Width) / 2;     //计算偏移量(保证滑动条在tab下正中间)

        transformation = new Transformation();

        matrix = transformation.getMatrix();
        matrix.postTranslate(offset,0);
        viewCursor.setTag(matrix);

    }

    /*页面改变监听器*/

    public class NewPageChangeListener implements ViewPager.OnPageChangeListener{

        int one = offset * 2 +cursor_Width;     //页卡1到页卡2偏移量
        int two = one * 2;                      //页卡1到页卡3的量
        int three =one+one;



        @Override
        public void onPageSelected(int i) {
            Animation animation = null;
            switch (i){
                case 0:
                    if(number == 1){
                        animation = new TranslateAnimation(one, 0, 0, 0);
                        Log.i("zhang", String.valueOf(i));
                    }
                    else if(number == 2){
                        animation = new TranslateAnimation(two,0,0,0);
                    }
                    break;
                case 1:
                    if(number == 0){
                        animation = new TranslateAnimation(offset,one,0,0);
                        Log.i("zhang", String.valueOf(i));
                    }else if(number == 2){
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }
                    break;
                case 2:
                    if(number == 0){
                        animation = new TranslateAnimation(offset, two, 0, 0);
                        Log.i("zhang", String.valueOf(i));
                    }
                    else if(number == 1){
                        animation = new TranslateAnimation(one,two,0,0);
                        Log.i("zhang", String.valueOf(i));
                    }

            }

            number = i;
            animation.setFillAfter(true);      //True：图片停在动画结束位置
            animation.setDuration(300);
            viewCursor.startAnimation(animation);


        }

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

    /*tab页面点击监听*/
    public class TabOnClickListener implements View.OnClickListener{

        private int num;

        public TabOnClickListener(int index){
            num = index;
        }

        @Override
        public void onClick(View v) {

            viewPageEmail.setCurrentItem(num);


        }
    }


    /*设置ViewPage的适配器*/

    private class NewPagerAdapter extends PagerAdapter{

        public List<View> viewList;
        public NewPagerAdapter(ArrayList<View> viewList) {
            this.viewList = viewList;
        }


        @Override
        public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public int getCount() {
            //返回要滑动view的个数
            return viewList.size();
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //从当前container中删除指定位置（position）的view

            container.removeView(viewList.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //实例化：将当前视图添加到container中，并返回当前View（传送key)
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
    }



}
