package chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.R;


public class Fragment_RootSecond extends BaseMainFragment {


    // TODO: Rename and change types and number of parameters
    public static Fragment_RootSecond newInstance() {
        Bundle args = new Bundle();
        Fragment_RootSecond fragment = new Fragment_RootSecond();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rootsecond, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(Fragment_RootSecond_Parent.class) == null) {
            loadRootFragment(R.id.fl_second_container, Fragment_RootSecond_Parent.newInstance());
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create

        if (findChildFragment(Fragment_RootSecond_Parent.class) == null) {
            loadRootFragment(R.id.fl_second_container, Fragment_RootSecond_Parent.newInstance());
        }
    }


}
