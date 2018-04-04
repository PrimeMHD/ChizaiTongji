package chizaitongji.example.com.chizaitongji.Fragment.Fragment_ThirdGroup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.R;


public class Fragment_RootThird_Parent extends BaseMainFragment {


    public Fragment_RootThird_Parent() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CommunityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_RootThird_Parent newInstance() {
        Fragment_RootThird_Parent fragment = new Fragment_RootThird_Parent();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.getToolbar().setTitle("吃在同济");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rootthird_parent, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


}
