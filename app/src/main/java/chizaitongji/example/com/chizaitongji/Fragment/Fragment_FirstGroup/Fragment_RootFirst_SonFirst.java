package chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Adapter.CanteenThumbnailAdapter;
import chizaitongji.example.com.chizaitongji.Bean.CanteenThumbnail;
import chizaitongji.example.com.chizaitongji.Fragment.BaseBackFragment;
import chizaitongji.example.com.chizaitongji.Fragment.WebVeiwFragment;
import chizaitongji.example.com.chizaitongji.Listener.OnItemClickListener;
import chizaitongji.example.com.chizaitongji.R;
import chizaitongji.example.com.chizaitongji.Utils.EnumPack;
import chizaitongji.example.com.chizaitongji.Utils.JsonUtil;
import me.yokeyword.fragmentation.SupportFragment;


public class Fragment_RootFirst_SonFirst extends BaseBackFragment {
    protected Context mContext;//for communication between acticity

    private List<CanteenThumbnail> canteenThumbnailList;

    private static final String TAG = "Fragment_RootFirst_SonFirst";


    public Fragment_RootFirst_SonFirst() {
        // Required empty public constructor
    }


    public static Fragment_RootFirst_SonFirst newInstance() {
        Fragment_RootFirst_SonFirst fragment = new Fragment_RootFirst_SonFirst();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initCanteenThumbnailList();
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.getToolbar().setTitle("美食大本营");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_fragment_rootfirst_firstson, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_canteenthumbnail);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        CanteenThumbnailAdapter adapter = new CanteenThumbnailAdapter(canteenThumbnailList);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                EnumPack.CanteenName canteenName;
                switch (position) {
                    case 0:
                        canteenName = EnumPack.CanteenName.XUEYUAN;
                        break;
                    case 1:
                        canteenName = EnumPack.CanteenName.BEIYUAN;
                        break;
                    case 2:
                        canteenName = EnumPack.CanteenName.XIBEI;
                        break;
                    case 3:
                        canteenName = EnumPack.CanteenName.XIYUAN;
                        break;
                    case 4:
                        canteenName = EnumPack.CanteenName.SANHAOWU;
                        break;
                    default:
                        canteenName = EnumPack.CanteenName.XUEYUAN;
                }
                if (position == 5) {
                    WebVeiwFragment webVeiwFragment = WebVeiwFragment.newInstance(mContext.getResources().getString(R.string.ALLCANTEENINFO_URL));
                    start(webVeiwFragment);
                } else {
                    Fragment_RootFirst_SonFirst_CanteenInfo fragment_rootFirst_sonFirst_canteenInfo =
                            Fragment_RootFirst_SonFirst_CanteenInfo.newInstance(canteenName);
                    start(fragment_rootFirst_sonFirst_canteenInfo);
                }


            }
        });
        recyclerView.setAdapter(adapter);
        //initView();
        //Log.d(TAG, "onCreate View");
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.getToolbar().setTitle("美食大本营");
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        initCanteenThumbnailList();
        //Log.d(TAG, "on Attach");
    }

    private void initCanteenThumbnailList() {
        canteenThumbnailList = new JsonUtil().getCanteenThumbnails(mContext);
        int view_id;
        for (CanteenThumbnail canteenThumbnail : canteenThumbnailList) {
            view_id = getResources().getIdentifier(canteenThumbnail.getImageIdString(), "drawable", mContext.getPackageName());
            canteenThumbnail.setImageId(view_id);
        }

    }



}
