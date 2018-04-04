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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Adapter.CanteenConcreteAdapter;
import chizaitongji.example.com.chizaitongji.Adapter.CanteenThumbnailAdapter;
import chizaitongji.example.com.chizaitongji.Bean.CanteenThumbnail;
import chizaitongji.example.com.chizaitongji.Bean.SubCanteenInfo;
import chizaitongji.example.com.chizaitongji.Fragment.BaseBackFragment;
import chizaitongji.example.com.chizaitongji.R;
import chizaitongji.example.com.chizaitongji.Utils.EnumPack;
import chizaitongji.example.com.chizaitongji.Utils.JsonUtil;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment_RootFirst_SonFirst_CanteenInfo extends BaseBackFragment {

    protected Context mContext;//for communication between acticity
    EnumPack.CanteenName mCanteenName;
    private List<SubCanteenInfo> subCanteenInfoList;

    private static final String TAG = "Fragment_RootFirst_SonFirst_CanteenInfo";


    public static Fragment_RootFirst_SonFirst_CanteenInfo newInstance(EnumPack.CanteenName canteenName) {
        Fragment_RootFirst_SonFirst_CanteenInfo fragment = new Fragment_RootFirst_SonFirst_CanteenInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.mCanteenName = canteenName;
        return fragment;
    }


    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity mainActivity = (MainActivity) mContext;
        switch (mCanteenName) {
            case XIBEI:
                mainActivity.getToolbar().setTitle("走近西北食堂");
                break;
            case XUEYUAN:
                mainActivity.getToolbar().setTitle("走近学苑");
                break;
            case XIYUAN:
                mainActivity.getToolbar().setTitle("走近西苑");
                break;
            case BEIYUAN:
                mainActivity.getToolbar().setTitle("走近北苑");
                break;
            case SANHAOWU:
                mainActivity.getToolbar().setTitle("走近三好坞");
                break;
            default:

        }
        mainActivity.getToolbar().setTitle("美食大本营");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.layout_fragment_rootfirst_firstson_son, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_canteen_concrete);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        CanteenConcreteAdapter adapter = new CanteenConcreteAdapter(subCanteenInfoList);
        recyclerView.setAdapter(adapter);
        ImageView imageView_CanteenConcretePic1 = (ImageView) v.findViewById(R.id.imageView_CanteenConcretePic1);
        ImageView imageView_CanteenConcretePic2 = (ImageView) v.findViewById(R.id.imageView_CanteenConcretePic2);
        ImageView imageView_CanteenConcretePic3 = (ImageView) v.findViewById(R.id.imageView_CanteenConcretePic3);

        TextView textView_CanteenConcreteBerief = (TextView) v.findViewById(R.id.textView_CanteenConcreteBerief);
        switch (mCanteenName) {
            case XIBEI:
                textView_CanteenConcreteBerief.setText(mContext.getResources().getString(R.string.xibeibrief));
                imageView_CanteenConcretePic1.setImageResource(R.drawable.xibei1);
                imageView_CanteenConcretePic2.setImageResource(R.drawable.xibei2);
                imageView_CanteenConcretePic3.setImageResource(R.drawable.xibei3);
                break;
            case XUEYUAN:
                textView_CanteenConcreteBerief.setText(mContext.getResources().getString(R.string.xueyuanbrief));
                imageView_CanteenConcretePic1.setImageResource(R.drawable.xueyuan1);
                imageView_CanteenConcretePic2.setImageResource(R.drawable.xueyuan2);
                imageView_CanteenConcretePic3.setImageResource(R.drawable.xueyuan3);

                break;
            case XIYUAN:
                textView_CanteenConcreteBerief.setText(mContext.getResources().getString(R.string.xiyuanbrief));
                imageView_CanteenConcretePic1.setImageResource(R.drawable.xiyuan1);
                imageView_CanteenConcretePic2.setImageResource(R.drawable.xiyuan2);
                imageView_CanteenConcretePic3.setImageResource(R.drawable.xiyuan3);

                break;
            case BEIYUAN:
                textView_CanteenConcreteBerief.setText(mContext.getResources().getString(R.string.beiyuanbrief));
                imageView_CanteenConcretePic1.setImageResource(R.drawable.beiyuan1);
                imageView_CanteenConcretePic2.setImageResource(R.drawable.beiyuan2);
                imageView_CanteenConcretePic3.setImageResource(R.drawable.beiyuan3);
                break;
            case SANHAOWU:
                textView_CanteenConcreteBerief.setText(mContext.getResources().getString(R.string.sanhaowubrief));
                imageView_CanteenConcretePic1.setImageResource(R.drawable.sanhaowu1);
                imageView_CanteenConcretePic2.setImageResource(R.drawable.sanhaowu2);
                imageView_CanteenConcretePic3.setImageResource(R.drawable.sanhaowu3);
                break;
            default:

        }
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        initSubCanteenInfoList();
        //Log.d(TAG, "on Attach");
    }

    private void initSubCanteenInfoList() {
        subCanteenInfoList = new JsonUtil().getSubCanteenInfos(mContext, mCanteenName);
        Log.d("NOW", subCanteenInfoList.size() + "");
        Log.d("NOW", subCanteenInfoList.get(0).getSubCanteenName() + "");

    }


}
