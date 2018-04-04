package chizaitongji.example.com.chizaitongji.Activity;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import chizaitongji.example.com.chizaitongji.Fragment.BaseMainFragment;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup.Fragment_RootFirst_Parent;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond_Parent;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_ThirdGroup.Fragment_RootThird;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_FirstGroup.Fragment_RootFirst;
import chizaitongji.example.com.chizaitongji.Fragment.Fragment_SecondGroup.Fragment_RootSecond;
import chizaitongji.example.com.chizaitongji.R;
import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportHelper;

public class MainActivity extends SupportActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseMainFragment.OnBackToFirstListener {
    private static final String TAG = "MainActivity";
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private BottomNavigationBar bottomNavigationBar;
    private FragmentManager fragmentManager;
    private SupportFragment[] mFragments = new SupportFragment[3];
    private Toolbar toolbar;
    int curFragment = FIRST;
    int prePosition = FIRST;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        prePosition = FIRST;
        curFragment = FIRST;
        //fragmentManager = getSupportFragmentManager();

        SupportFragment first_root_Fragment = findFragment(Fragment_RootFirst.class);
        if (first_root_Fragment == null) {
            mFragments[FIRST] = Fragment_RootFirst.newInstance();
            mFragments[SECOND] = Fragment_RootSecond.newInstance();
            mFragments[THIRD] = Fragment_RootThird.newInstance();

            loadMultipleRootFragment(R.id.layFrame, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]
            );
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = first_root_Fragment;
            mFragments[SECOND] = findFragment(Fragment_RootSecond.class);
            mFragments[THIRD] = findFragment(Fragment_RootThird.class);

        }
        initView();


    }


    /*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //BadgeItem badgeItem=new BadgeItem().setBorderWidth(1).setBackgroundColorResource(R.color.colorAccent).setText("2").setHideOnSelect(true);
        //BadgeItem就是去不完的小红点，先暂时留着，需要的时候用
        bottomNavigationBar = findViewById(R.id.bottomNavigationBar);
        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_dashboard_black_24dp, "美食").setActiveColorResource(R.color.colorPrimary))//.setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "资讯").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_notifications_black_24dp, "广场").setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                curFragment = position;
                showHideFragment(mFragments[position], mFragments[prePosition]);
                Log.d("NOW", "switch from" + prePosition + "to" + curFragment);
                SupportHelper.logFragmentStackHierarchy(MainActivity.this, TAG);
                prePosition = position;


            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
                // 如果不在该类别Fragment的主页,则回到主页;
                if (count > 1) {
                    if (currentFragment instanceof Fragment_RootFirst) {
                        currentFragment.popToChild(Fragment_RootFirst_Parent.class, false);
                    } else if (currentFragment instanceof Fragment_RootSecond) {
                        currentFragment.popToChild(Fragment_RootSecond_Parent.class, false);
                    } else if (currentFragment instanceof Fragment_RootThird) {
                        currentFragment.popToChild(Fragment_RootThird.class, false);
                    }
                    return;
                }
// 这里推荐使用EventBus来实现 -> 解耦
                if (count == 1) {
                    //在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
                    //主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                    //EventBusActivityScope.getDefault(MainActivity.this).post(new TabSelectedEvent(position));
                }
            }
        });


    }

    @Override
    public void onBackToFirstFragment() {
        bottomNavigationBar.selectTab(FIRST);
    }

    @Override
    public void onBackPressedSupport() {
        Log.d(TAG, "在这儿按下了back");
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        first_root_Fragment.getmCb().startTurning(2000);      //设置开始轮播以及轮播时间
//    }
//
//    @Override
//    protected void onPause() {
//        if(first_root_Fragment.getmCb()!=null){
//            first_root_Fragment.getmCb().stopTurning();   //停止轮播
//        }
//        super.onPause();
//    }
}
