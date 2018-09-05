package com.renxinkeji.exchange.Log;

import android.util.Log;

public class LogUtils {

    private static final String TAG ="LogUtils";

    public static void logErr(String errorinformation){
        Log.i(TAG,"errorinformation:"+errorinformation);
    }

}
