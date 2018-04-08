package chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Fragment.BaseBackFragment;
import chizaitongji.example.com.chizaitongji.R;

public class Fragment_RootFirst_SonSecond extends BaseBackFragment {
    private Context mContext;

    public Fragment_RootFirst_SonSecond() {
        // Required empty public constructor
    }


    public static Fragment_RootFirst_SonSecond newInstance() {
        Fragment_RootFirst_SonSecond fragment = new Fragment_RootFirst_SonSecond();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.layout_fragment_rootfirst_secondson, container, false);
        return v;

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.getToolbar().setTitle("名厨在校园");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;

    }

}
