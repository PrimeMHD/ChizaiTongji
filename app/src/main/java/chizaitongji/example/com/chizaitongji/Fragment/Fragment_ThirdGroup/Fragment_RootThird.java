package chizaitongji.example.com.chizaitongji.Fragment.Fragment_ThirdGroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
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
        Fragment_RootThird fragment = new Fragment_RootThird();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rootthird, container, false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }


}
