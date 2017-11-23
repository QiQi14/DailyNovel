package main.dailynovel.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerFragement extends FragmentPagerAdapter{
    private final List<Fragment> listFragment = new ArrayList<>();

    public ViewPagerFragement(FragmentManager fm) {
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
