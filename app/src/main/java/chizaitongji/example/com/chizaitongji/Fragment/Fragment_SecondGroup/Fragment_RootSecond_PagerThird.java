package chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import chizaitongji.example.com.chizaitongji.Adapter.ArticleThumbnailAdapter;
import chizaitongji.example.com.chizaitongji.Bean.ArticleThumbnail;
import chizaitongji.example.com.chizaitongji.Fragment.WebVeiwFragment;
import chizaitongji.example.com.chizaitongji.Listener.OnItemClickListener;
import chizaitongji.example.com.chizaitongji.R;
import chizaitongji.example.com.chizaitongji.Utils.JsonUtil;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment_RootSecond_PagerThird extends SupportFragment {

    protected Context mContext;
    private static final String TAG = "Fragment_RootSecond_PagerThird";

    public Fragment_RootSecond_PagerThird() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment_RootSecond_PagerThird newInstance() {
        Fragment_RootSecond_PagerThird fragment = new Fragment_RootSecond_PagerThird();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_rootsecond_pagerthird, container, false);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


}
