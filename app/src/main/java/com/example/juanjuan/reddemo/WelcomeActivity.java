package com.example.juanjuan.reddemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends Activity implements Runnable{

    //判断是否第一次使用
    private boolean isFirstUse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            //读取SharedPerfreshences中需要的数据
            SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_PRIVATE);
            isFirstUse = preferences.getBoolean("isFirstUse",true);
            //如果用户不是第一次使用则直接调到显示界面，否则跳转到引导界面
            if (isFirstUse){
                startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
            }else{
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            }
            finish();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstUse",false);
            editor.commit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
