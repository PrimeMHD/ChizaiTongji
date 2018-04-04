package chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup;

import android.content.Context;
import android.os.Bundle;
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

import static chizaitongji.example.com.chizaitongji.Utils.JsonUtil.ArticleType.INFORM_ARTICLE;
import static chizaitongji.example.com.chizaitongji.Utils.JsonUtil.ArticleType.RECOMMAND_ARTICLE;

public class Fragment_RootSecond_PagerFirst extends SupportFragment {

    protected Context mContext;
    private static final String TAG = "Fragment_RootSecond_PagerFirst";
    private List<ArticleThumbnail> articleThumbnailList;

    public Fragment_RootSecond_PagerFirst() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment_RootSecond_PagerFirst newInstance() {
        Fragment_RootSecond_PagerFirst fragment = new Fragment_RootSecond_PagerFirst();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG,"on Create");
        initArticleThumbnailList();
    }

    private void initArticleThumbnailList() {
        articleThumbnailList = new JsonUtil().getArticles(mContext, RECOMMAND_ARTICLE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_fragment_rootsecond_pagerfirst, container, false);
        RecyclerView recyclerView1 = (RecyclerView) v.findViewById(R.id.recyclerview_articlethumbnail_1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView1.setLayoutManager(layoutManager);
        final ArticleThumbnailAdapter adapter = new ArticleThumbnailAdapter(articleThumbnailList);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                WebVeiwFragment webVeiwFragment = WebVeiwFragment.newInstance(adapter.getItem(position).getArticleURL());
                ((SupportFragment) getParentFragment()).start(webVeiwFragment);

            }
        });
        recyclerView1.setAdapter(adapter);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


}
