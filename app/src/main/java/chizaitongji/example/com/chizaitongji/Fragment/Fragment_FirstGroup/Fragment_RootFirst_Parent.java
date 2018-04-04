package chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.R;
import chizaitongji.example.com.chizaitongji.Widgets.ImageViewHolder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Mi HD on 2018/2/7.
 */

public class Fragment_RootFirst_Parent extends BaseMainFragment {
    protected Activity mActivity;
    private static final String TAG = "Fragment_RootFirst_Parent";


    private List<Integer> mImageList = new ArrayList<>();//ConvenientBanner用的图片存在这里
    private int[] mImages = {R.drawable.beer};
    private ConvenientBanner mCb;
    private ImageView imageView_nav1, imageView_nav2, imageView_nav3, imageView_nav4;


    public static Fragment_RootFirst_Parent newInstance() {
        Bundle args = new Bundle();
        Fragment_RootFirst_Parent fragment = new Fragment_RootFirst_Parent();
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_fragment_rootfirst_parent, container, false);
        mCb = (ConvenientBanner) v.findViewById(R.id.convenientBanner);
        imageView_nav1 = (ImageView) v.findViewById(R.id.imageView_nav1);
        imageView_nav2 = (ImageView) v.findViewById(R.id.imageView_nav2);
        imageView_nav3 = (ImageView) v.findViewById(R.id.imageView_nav3);
        imageView_nav4 = (ImageView) v.findViewById(R.id.imageView_nav4);
        initCBDatas();
        initCBListener();
        setImageOnClick();


        return v;
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mActivity = activity;
//        Log.d(TAG,"on Attach");
//    }


    public ConvenientBanner getmCb() {
        return mCb;
    }

    public void initCBListener() {
        if (mCb == null)
            Log.d("temp", "cb is null");
        mCb.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(MainActivity.this,"点击了条目"+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initCBDatas() {

        for (int i = 0; i < 1; i++) {
            mImageList.add(mImages[i]);
        }
        if (mCb == null || mImageList == null)
            Log.d("temp", "cb is null");
        mCb.setPages(new CBViewHolderCreator<ImageViewHolder>() {
            @Override
            public ImageViewHolder createHolder() {
                return new ImageViewHolder();
            }
        }, mImageList)
                .setPageIndicator(new int[]{R.drawable.ponit_normal, R.drawable.point_select}) //设置两个点作为指示器
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL); //设置指示器的方向水平居中

        mCb.setCanLoop(true);
    }

    public void setImageOnClick() {
        imageView_nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_RootFirst_SonFirst fragment = Fragment_RootFirst_SonFirst.newInstance();
                start(fragment);
            }
        });
    }


}
