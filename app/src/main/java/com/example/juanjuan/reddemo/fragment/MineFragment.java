package com.example.juanjuan.reddemo.fragment;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.juanjuan.reddemo.R;
import com.example.juanjuan.reddemo.adapter.DiscoveryAdapter;
import com.example.juanjuan.reddemo.view.ImageCycleView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
   /* //上拉加载下拉刷新的实现
    private PullToRefreshListView mPullToRefreshListView;
    private ILoadingLayout mILoadingLayout;
    View view;
    //listView的实现
    private ListView discovery_listView;
    private List<String> data = new ArrayList<>();
    private DiscoveryAdapter mDiscoveryAdapter;

    //顶部轮播图的实现
    private ImageCycleView mCycleView;
    private ArrayList<String> urlList_image = new ArrayList<>();*/
    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       /* initView();
        mILoadingLayout = mPullToRefreshListView.getLoadingLayoutProxy(true,false);
        initLoading();
        //对listView中的内容进行解析
//        listViewJson();
        //解析banner图
        bannerJson();*/
       View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_mine,container,false);
        return view;
    }

    //对banner图的url进行解析并赋值
    private void bannerJson() {
        //可以利用xutils解析并使用gson
    }
    //对banner进行监听
    private ImageCycleView.ImageCycleViewListener mListener = new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void displayImage(String imageURL, ImageView imageView) {
        }

        @Override
        public void onImageClick(int position, View imageView) {
        //TODO:单击图片处理监听
        }
    };

    //加载
   /* private void initLoading() {
        mILoadingLayout.setLastUpdatedLabel("加载更多...");
        mILoadingLayout.setReleaseLabel("松开立即刷新...");
        mILoadingLayout.setRefreshingLabel("加载中...");
        String time = DateUtils.formatDateTime(getContext(),System.currentTimeMillis(),
                DateUtils.FORMAT_ABBREV_ALL|DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_SHOW_TIME);
        mPullToRefreshListView.getLoadingLayoutProxy().setLastUpdatedLabel(time);
    }

    private void initView() {
         view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_mine,null);
        mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.host_listView);
        mPullToRefreshListView.getRefreshableView().setSelector(android.R.color.transparent);
        discovery_listView = mPullToRefreshListView.getRefreshableView();
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.discovery_top_banner,null);
        mCycleView = (ImageCycleView) view2.findViewById(R.id.cycle_image);
        discovery_listView.addHeaderView(view2);

        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //调用解析数据的方法

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }
*/
}
