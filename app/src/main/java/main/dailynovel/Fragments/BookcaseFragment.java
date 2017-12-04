package main.dailynovel.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import main.dailynovel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookcaseFragment extends Fragment {
    ViewPager vpBook;
    BookcaseViewPager vpBookcase;
    TabLayout tlBook;
    int page = 0;

    public BookcaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookcase, container, false);
        vpBook = (ViewPager)view.findViewById(R.id.vpBook);
        tlBook= (TabLayout) view.findViewById(R.id.tlBook);

        vpBookcase = new BookcaseViewPager(getActivity().getSupportFragmentManager());
        switch (page) {
            case 0:
                BookcaseItemFragment item1 = new BookcaseItemFragment();
                vpBookcase.addFragment(item1);
            case 1:
                BookcaseItemFragment item2 = new BookcaseItemFragment();
                vpBookcase.addFragment(item2);
            case 2:
                BookcaseItemFragment item3 = new BookcaseItemFragment();
                vpBookcase.addFragment(item3);
        }

        vpBook.setAdapter(vpBookcase);

        tlBook.setTabGravity(TabLayout.GRAVITY_FILL);
        tlBook.setupWithViewPager(vpBook);
        tlBook.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        return view;
    }
}

class BookcaseViewPager extends FragmentStatePagerAdapter {
    private final List<Fragment> listFragment = new ArrayList<>();

    public BookcaseViewPager(FragmentManager fm) {
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
                return "Đang theo dõi";
            case 1:
                return "Đã tải";
            case 2:
                return "Vừa xem";
        }
        return null;
    }
}
