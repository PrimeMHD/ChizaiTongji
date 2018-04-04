package chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Adapter.ArticlePagerFragmentAdapter;
import chizaitongji.example.com.chizaitongji.Adapter.ArticleThumbnailAdapter;
import chizaitongji.example.com.chizaitongji.Adapter.CanteenThumbnailAdapter;
import chizaitongji.example.com.chizaitongji.Bean.ArticleThumbnail;
import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.Fragment.WebVeiwFragment;
import chizaitongji.example.com.chizaitongji.Listener.OnItemClickListener;
import chizaitongji.example.com.chizaitongji.R;
import chizaitongji.example.com.chizaitongji.Utils.JsonUtil;
import me.yokeyword.fragmentation.SupportFragment;


public class Fragment_RootSecond_Parent extends SupportFragment {
    protected Context mContext;
    private static final String TAG = "Fragment_RootSecond_Parent";
    private TabLayout mTab;
    private ViewPager mViewPager;


    // TODO: Rename and change types and number of parameters
    public static Fragment_RootSecond_Parent newInstance() {
        Fragment_RootSecond_Parent fragment = new Fragment_RootSecond_Parent();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.getToolbar().setTitle("吃在同济");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rootsecond_parent, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mViewPager.setAdapter(new ArticlePagerFragmentAdapter(getChildFragmentManager(),
                getString(R.string.recommend), getString(R.string.inform), getString(R.string.contributes)));
        mTab.setupWithViewPager(mViewPager);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
