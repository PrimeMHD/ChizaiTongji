package chizaitongji.example.com.chizaitongji.Fragment.Fragment_ThirdGroup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond_Parent;
import chizaitongji.example.com.chizaitongji.R;
import me.yokeyword.fragmentation.SupportFragment;


public class Fragment_RootThird extends BaseMainFragment {


    public Fragment_RootThird() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CommunityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_RootThird newInstance() {
        Bundle args = new Bundle();
        Fragment_RootThird fragment = new Fragment_RootThird();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rootthird, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(Fragment_RootThird_Parent.class) == null) {
            loadRootFragment(R.id.fl_third_container, Fragment_RootThird_Parent.newInstance());
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create

        if (findChildFragment(Fragment_RootThird_Parent.class) == null) {
            loadRootFragment(R.id.fl_third_container, Fragment_RootThird_Parent.newInstance());
        }
    }


}
