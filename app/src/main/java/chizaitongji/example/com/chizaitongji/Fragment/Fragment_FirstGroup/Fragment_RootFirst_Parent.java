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
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Adapter.BannerImageLoader;
import chizaitongji.example.com.chizaitongji.Bean.Notification;
import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.Fragment.WebVeiwFragment;
import chizaitongji.example.com.chizaitongji.R;
import chizaitongji.example.com.chizaitongji.Utils.JsonUtil;
import chizaitongji.example.com.chizaitongji.Widgets.ImageViewHolder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Mi HD on 2018/2/7.
 */

public class Fragment_RootFirst_Parent extends BaseMainFragment {
    protected Activity mActivity;
    private static final String TAG = "Fragment_RootFirst_Parent";


    private List<Integer> mImageList = new ArrayList<>();//ConvenientBanner用的图片存在这里
    private int[] mImages = {R.drawable.cb1, R.drawable.cb2, R.drawable.cb3, R.drawable.cb4};
    private static final List<String> imageURLs = new ArrayList<String>(Arrays.asList(
            "http://mp.weixin.qq.com/s/VxxvWsie_idG8VoEJQYtxQ",
            "http://mp.weixin.qq.com/s/vGlJvjQaXuiSKUW1PaaUXg",
            "http://mp.weixin.qq.com/s/NXfWrbZlP2Kaaa0DovYlBA",
            "http://mp.weixin.qq.com/s/qP2QITkK4g0pFukOxLv14A"
    ));

    private List<Notification> notificationList;
    private Banner mCb;
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
        mCb = (Banner) v.findViewById(R.id.banner);
        initCBDatas();
        mCb.setImages(mImageList)
                .setImageLoader(new BannerImageLoader())
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        WebVeiwFragment webVeiwFragment = WebVeiwFragment.newInstance(imageURLs.get(position));
                        start(webVeiwFragment);
                    }
                }).start();


        imageView_nav1 = (ImageView) v.findViewById(R.id.imageView_nav1);
        imageView_nav2 = (ImageView) v.findViewById(R.id.imageView_nav2);
        imageView_nav3 = (ImageView) v.findViewById(R.id.imageView_nav3);
        imageView_nav4 = (ImageView) v.findViewById(R.id.imageView_nav4);
        initCBListener();
        setImageOnClick();
        ViewFlipper vf = (ViewFlipper) v.findViewById(R.id.marquee_view);
        View addToVF;
        TextView notice;
        notificationList = new JsonUtil().getNotifications(mContext);
        for (Notification notification : notificationList) {
            addToVF = View.inflate(mContext, R.layout.noticelayout, null);
            notice = addToVF.findViewById(R.id.textView_notice);
            notice.setText(notification.getNote());
            vf.addView(addToVF);
        }

        return v;
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mActivity = activity;
//        Log.d(TAG,"on Attach");
//    }



    public void initCBListener() {
        if (mCb == null)
            Log.d("temp", "cb is null");
//        mCb.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                //Toast.makeText(MainActivity.this,"点击了条目"+position,Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public void initCBDatas() {

        for (int i = 0; i < mImages.length; i++) {
            mImageList.add(mImages[i]);
        }
//        if (mCb == null || mImageList == null)
//            Log.d("temp", "cb is null");
//        mCb.setPages(new CBViewHolderCreator<ImageViewHolder>() {
//            @Override
//            public ImageViewHolder createHolder() {
//                return new ImageViewHolder();
//            }
//        }, mImageList)
//                .setPageIndicator(new int[]{R.drawable.ponit_normal, R.drawable.point_select}) //设置两个点作为指示器
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL); //设置指示器的方向水平居中
//
//        mCb.setCanLoop(true);

    }

    public void setImageOnClick() {
        imageView_nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_RootFirst_SonFirst fragment = Fragment_RootFirst_SonFirst.newInstance();
                start(fragment);
            }
        });
        imageView_nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_RootFirst_SonSecond fragment = Fragment_RootFirst_SonSecond.newInstance();
                start(fragment);
            }
        });
        imageView_nav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_RootFirst_SonThird fragment = Fragment_RootFirst_SonThird.newInstance();
                start(fragment);
            }
        });
        imageView_nav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_RootFirst_SonFourth fragment = Fragment_RootFirst_SonFourth.newInstance();
                start(fragment);
            }
        });
    }


}
