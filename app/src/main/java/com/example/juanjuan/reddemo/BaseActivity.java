package com.example.juanjuan.reddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.juanjuan.reddemo.collector.ActivityCollector;
import com.example.juanjuan.reddemo.model.LogUtils;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/4.
 */
public class BaseActivity extends AppCompatActivity {
    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏

        Window window=getWindow();
        //  透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
////            window.setFlags(
////                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
////                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);*/
//        }
//        5.0版本及以上
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }*/

        LogUtils.d("ActivityName>>", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
        x.view().inject(this);
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "LKPdbGCVRNag5NhCz3LUrkS9");
    }

    public void finishNotThis(){
        ActivityCollector.finishAllNotThis(this);

    }

    public void finishAll(){
        ActivityCollector.finishAll();
    }
}

