package com.example.juanjuan.reddemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.juanjuan.reddemo.GuideActivity;
import com.example.juanjuan.reddemo.MainActivity;

import java.util.List;

/**
 * Created by juanjuan on 2016/7/29.
 */
public class WelcomeAdapter extends PagerAdapter{
    //引导页列表
    List<ImageView> data;
    Context context;
    public WelcomeAdapter(Context context, List<ImageView> data) {
        this.context = context;
        this.data=data;
    }

    //总页数
    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }
    //初始化postion当前页


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(data.get(position));
        if (position == data.size()-1){
            data.get(position).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (context, MainActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        return data.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    //销毁position位置的界面

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(data.get(position));
    }
}
