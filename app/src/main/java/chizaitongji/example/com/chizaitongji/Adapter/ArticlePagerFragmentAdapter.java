package chizaitongji.example.com.chizaitongji.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond_PagerFirst;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond_PagerSecond;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond_PagerThird;

public class ArticlePagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    public ArticlePagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == FIRST) {
            return Fragment_RootSecond_PagerFirst.newInstance();
        } else if (position == SECOND) {
            return Fragment_RootSecond_PagerSecond.newInstance();
        } else if (position == THIRD) {
            return Fragment_RootSecond_PagerThird.newInstance();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}
