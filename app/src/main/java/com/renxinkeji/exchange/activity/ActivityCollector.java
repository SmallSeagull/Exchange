package com.renxinkeji.exchange.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();    //声明一个管理活动的集合

    public static void addActivity(Activity activity){
        activities.add(activity);       //添加当前活动到集合中
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);    //移除集合中的活动
    }

    //关闭所有活动
    public static void finishAll(){
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }




}
