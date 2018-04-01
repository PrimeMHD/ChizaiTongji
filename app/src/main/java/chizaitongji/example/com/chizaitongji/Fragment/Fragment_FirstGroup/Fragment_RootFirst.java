package chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.R;

/**
 * Created by Mi HD on 2018/2/7.
 */

public class Fragment_RootFirst extends BaseMainFragment {


    public static Fragment_RootFirst newInstance() {
        Bundle args = new Bundle();
        Fragment_RootFirst fragment = new Fragment_RootFirst();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rootfirst, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(Fragment_RootFirst_Parent.class) == null) {

            loadRootFragment(R.id.fl_first_container, Fragment_RootFirst_Parent.newInstance(), true, true);

        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create
        if (findChildFragment(Fragment_RootFirst_Parent.class) == null) {
            loadRootFragment(R.id.fl_first_container, Fragment_RootFirst_Parent.newInstance());

        }
    }

}
