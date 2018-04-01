package chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import chizaitongji.example.com.chizaitongji.Bean.CanteenThumbnail;
import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.R;
import me.yokeyword.fragmentation.SupportFragment;


public class Fragment_RootFirst_SonFirst extends BaseMainFragment {
    protected Activity mActivity;//for communication between acticity
    private List<CanteenThumbnail> canteenThumbnailList = new ArrayList<>();

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
        Log.d(TAG, "on Create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_fragment_rootfirst_firstson, container, false);
        //initView();

        Log.d(TAG, "onCreate View");
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        Log.d(TAG, "on Attach");
    }


}
