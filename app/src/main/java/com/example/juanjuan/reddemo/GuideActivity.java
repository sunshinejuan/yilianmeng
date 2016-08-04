package com.example.juanjuan.reddemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.juanjuan.reddemo.adapter.WelcomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */
public class GuideActivity extends AppCompatActivity {

    private ViewPager mPager;
    private WelcomeAdapter mAdapter;
    private LinearLayout mLayout;

    //定义数组存放view
    List<ImageView> data;
    int [] image = {R.mipmap.a,R.mipmap.b,R.mipmap.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        //添加圆点
        mLayout = (LinearLayout) findViewById(R.id.lin_id);
        for (int i = 0; i < image.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(40, 40));
            imageView.setPadding(10,0,10,0);
            if (i==0){
                imageView.setImageResource(R.mipmap.page_now);
            }else{
                imageView.setImageResource(R.mipmap.page);
            }
            imageView.setTag(i);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    mPager.setCurrentItem(pos);
                }
            });
            mLayout.addView(imageView);
        }
        //实例化ViewPager
        mPager = (ViewPager) findViewById(R.id.mPager);
        data = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            ImageView images = new ImageView(this);
            images.setImageResource(image[i]);
            images.setScaleType(ImageView.ScaleType.CENTER_CROP);
            data.add(images);
        }
        mAdapter = new WelcomeAdapter(GuideActivity.this,data);
        mPager.setAdapter(mAdapter);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mLayout.getChildCount(); i++) {
                    ImageView image = (ImageView) mLayout.getChildAt(i);
                    if ( i==position){
                        image.setImageResource(R.mipmap.page_now);
                    }else{
                        image.setImageResource(R.mipmap.page);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
