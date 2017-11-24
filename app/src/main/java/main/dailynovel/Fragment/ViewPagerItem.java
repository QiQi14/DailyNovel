package main.dailynovel.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l3umb on 11/23/2017.
 */

public class ViewPagerItem extends FragmentStatePagerAdapter {
    private final List<Fragment> listFragment = new ArrayList<>();

    public ViewPagerItem(FragmentManager fm) {
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
    public void addFragment(Fragment fragment){
        listFragment.add(fragment);
    }

    public void removeFragment(Fragment fragment) {
        listFragment.remove(fragment);
    }
}
