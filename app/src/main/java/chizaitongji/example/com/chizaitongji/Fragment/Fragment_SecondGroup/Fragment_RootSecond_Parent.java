package chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.R;


public class Fragment_RootSecond_Parent extends BaseMainFragment {
    protected Activity mActivity;


    public Fragment_RootSecond_Parent() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragment_RootSecond_Parent newInstance() {
        Fragment_RootSecond_Parent fragment = new Fragment_RootSecond_Parent();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment_rootsecond_parent, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }


}
