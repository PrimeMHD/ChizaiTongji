package chizaitongji.example.com.chizaitongji.Fragment;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import chizaitongji.example.com.chizaitongji.Activity.MainActivity;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup.Fragment_RootFirst;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportHelper;

public class BaseMainFragment extends SupportFragment {
    protected OnBackToFirstListener _mBackToFirstListener;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        if (context instanceof OnBackToFirstListener) {
            _mBackToFirstListener = (OnBackToFirstListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBackToFirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _mBackToFirstListener = null;
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        Log.d("now", "on back press");
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
            Log.d("NOW_pop", getChildFragmentManager().getBackStackEntryCount() + "");
        } else {
            Log.d("NOW", getChildFragmentManager().getBackStackEntryCount() + "");
            if (this instanceof Fragment_RootFirst) {   // 如果是 第一个Fragment 则退出app
                _mActivity.finish();
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener.onBackToFirstFragment();
            }
        }
        return true;
    }

    public interface OnBackToFirstListener {
        void onBackToFirstFragment();
    }
}
