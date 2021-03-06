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

public class CategoryActivity extends AppCompatActivity {
    ViewPager vpCategory;
    TabLayout tlCategory;
    CategoryViewPager categoryViewPager;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //Hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        vpCategory = (ViewPager) findViewById(R.id.vpCategory);
        tlCategory = (TabLayout) findViewById(R.id.tlCategory);

        categoryViewPager = new CategoryViewPager(getSupportFragmentManager());
        switch (page) {
            case 0:
                SortItemFragment item1 = new SortItemFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("genre", 2);
                item1.setArguments(bundle);
                categoryViewPager.addFragment(item1);
            case 1:
                SortItemFragment item2 = new SortItemFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("genre", 4);
                item2.setArguments(bundle1);
                categoryViewPager.addFragment(item2);
            case 2:
                SortItemFragment item3 = new SortItemFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("genre", 10);
                item3.setArguments(bundle2);
                categoryViewPager.addFragment(item3);
            case 3:
                SortItemFragment item4 = new SortItemFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("genre", 3);
                item4.setArguments(bundle3);
                categoryViewPager.addFragment(item4);
            case 4:
                SortItemFragment item5 = new SortItemFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putInt("genre", 7);
                item5.setArguments(bundle4);
                categoryViewPager.addFragment(item5);
            case 5:
                SortItemFragment item6 = new SortItemFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putInt("genre", 1);
                item6.setArguments(bundle5);
                categoryViewPager.addFragment(item6);
            case 6:
                SortItemFragment item7 = new SortItemFragment();
                Bundle bundle6 = new Bundle();
                bundle6.putInt("genre", 12);
                item7.setArguments(bundle6);
                categoryViewPager.addFragment(item7);
            case 7:
                SortItemFragment item8 = new SortItemFragment();
                Bundle bundle7 = new Bundle();
                bundle7.putInt("genre", 6);
                item8.setArguments(bundle7);
                categoryViewPager.addFragment(item8);
        }

        vpCategory.setAdapter(categoryViewPager);
        vpCategory.setOffscreenPageLimit(3);

        tlCategory.setTabGravity(TabLayout.GRAVITY_FILL);
        tlCategory.setupWithViewPager(vpCategory);
        tlCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

class CategoryViewPager extends FragmentStatePagerAdapter {
    private final List<Fragment> listFragment = new ArrayList<>();

    public CategoryViewPager(FragmentManager fm) {
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
                return "Huyền Huyễn";
            case 1:
                return "Khoa Huyễn";
            case 2:
                return "Du Hí";
            case 3:
                return "Đô Thị";
            case 4:
                return "Lịch Sử";
            case 5:
                return "Tiên Hiệp";
            case 6:
                return "Linh Dị";
            case 7:
                return "Võ Hiệp";
        }
        return null;
    }
}
