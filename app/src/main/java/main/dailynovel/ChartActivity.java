package main.dailynovel;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import main.dailynovel.Fragments.*;


public class ChartActivity extends AppCompatActivity {
    ViewPager vpChart;
    TabLayout tlChart;
    ChartViewPager chartViewPager;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //Hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        vpChart = (ViewPager) findViewById(R.id.vpChart);
        tlChart= (TabLayout) findViewById(R.id.tlChart);

        chartViewPager = new ChartViewPager(getSupportFragmentManager());
        switch (page) {
            case 0:
                SortItemFragment item1 = new SortItemFragment();
                chartViewPager.addFragment(item1);
            case 1:
                SortItemFragment item2 = new SortItemFragment();
                chartViewPager.addFragment(item2);
            case 2:
                SortItemFragment item3 = new SortItemFragment();
                chartViewPager.addFragment(item3);
        }

        vpChart.setAdapter(chartViewPager);

        tlChart.setTabGravity(TabLayout.GRAVITY_FILL);
        tlChart.setupWithViewPager(vpChart);
        tlChart.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
    }
}

class ChartViewPager extends FragmentStatePagerAdapter {
    private final List<Fragment> listFragment = new ArrayList<>();

    public ChartViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    public void addFragment(Fragment fragment){
        listFragment.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "TOP XEM NHIỀU";
            case 1:
                return "TOP YÊU THÍCH";
            case 2:
                return "TOP THEO DÕI";
        }
        return null;
    }
}
