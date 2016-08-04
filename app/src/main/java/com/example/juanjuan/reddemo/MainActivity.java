package com.example.juanjuan.reddemo;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.juanjuan.reddemo.fragment.DiscoveryFragment;
import com.example.juanjuan.reddemo.fragment.InfoFragment;
import com.example.juanjuan.reddemo.fragment.MineFragment;
import com.example.juanjuan.reddemo.fragment.RedFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * 主界面fragment的切换
 */
public class MainActivity extends AppCompatActivity {

    private DiscoveryFragment homeFragment;
    private RedFragment redFragment;
    private InfoFragment msgFragment;
    //	private ClassFragment classFragment;
    private MineFragment personalFragment;
    private TextView discovery,red,msg,personal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
        resView(1);
       /* //启动fragment
        mFragments=new LinkedList<>();
        Fragment fragment = new DiscoveryFragment();
        mFragments.add(fragment);

        fragment = new RedFragment();
        mFragments.add(fragment);

        fragment = new InfoFragment();
        mFragments.add(fragment);

        fragment = new MineFragment();
        mFragments.add(fragment);

        //显示第一个fragment
        FragmentManager manager = getSupportFragmentManager();
        final android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_fragment_container,mFragments.get(0));
        transaction.commit();

        //RadioButton切换fragment
        RadioGroup tabBar = (RadioGroup) findViewById(R.id.main_tab_bar);
        tabBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment = null;
                FragmentManager manager1 = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction1 = manager1.beginTransaction();
                int index = 0;
                switch (checkedId){
                    case R.id.main_tab_discovery:
                        index = 0;
                        break;
                    case R.id.main_tab_red:
                        index = 1;
                        break;
                    case R.id.main_tab_info:
                        index = 2;
                        break;
                    case R.id.main_tab_mine:
                        index = 3;
                        break;
                }

                //显示
                fragment = mFragments.get(index);
                transaction1.replace(R.id.main_fragment_container,fragment);
                transaction1.commit();

            }
        });*/
    }

    private void initView() {
        discovery = (TextView) findViewById(R.id.main_home);
        discovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifYuJiaZai(1);
            }
        });
        red = (TextView) findViewById(R.id.main_class);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifYuJiaZai(2);
            }
        });
        msg = (TextView) findViewById(R.id.main_message);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifYuJiaZai(3);
            }
        });
        personal = (TextView) findViewById(R.id.main_user);
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifYuJiaZai(4);
            }
        });
    }

    private void ifYuJiaZai(final int i) {
        resView(i);
    }

    private void resView(int i) {
        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        //显示第一个
        homeFragment=new DiscoveryFragment();
        redFragment=new RedFragment();
        msgFragment=new InfoFragment();
        personalFragment=new MineFragment();


        // ll.setVisibility(View.VISIBLE);
        // manager=getFragmentManager();

        // transaction=manager.beginTransaction();
        switch (i){
            case 1:
                //   test_post();
                transaction.replace(R.id.main_fl, homeFragment);
                discovery.setSelected(true);
                red.setSelected(false);
                msg.setSelected(false);
                personal.setSelected(false);
                break;
            case 2:
                transaction.replace(R.id.main_fl, redFragment);
                discovery.setSelected(false);
                red.setSelected(true);
                msg.setSelected(false);
                personal.setSelected(false);
                break;
            case 3:
                transaction.replace(R.id.main_fl, msgFragment);
                discovery.setSelected(false);
                red.setSelected(false);
                msg.setSelected(true);
                personal.setSelected(false);
                break;
            case 4:
                transaction.replace(R.id.main_fl, personalFragment);
                discovery.setSelected(false);
                red.setSelected(false);
                msg.setSelected(false);
                personal.setSelected(true);
                break;
        }
        transaction.commit();
    }
}
