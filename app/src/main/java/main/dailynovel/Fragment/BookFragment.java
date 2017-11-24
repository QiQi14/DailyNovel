package main.dailynovel.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import main.dailynovel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    ViewPager viewPager;
    ViewPagerItem vpItem;
    TabLayout tabLayout;
    int page = 0;
    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.vpBook);
        tabLayout= (TabLayout) view.findViewById(R.id.tlBook);

        vpItem = new ViewPagerItem(getActivity().getSupportFragmentManager());
        Bundle bundle = new Bundle();
        switch (page) {
            case 0:
                BookItemFragment item1 = new BookItemFragment();
//                bundle.putString("title","Đang theo dõi");
                vpItem.addFragment(item1);
            case 1:
                BookItemFragment item2 = new BookItemFragment();
//                bundle.putString("title","Đã tải");
                vpItem.addFragment(item2);
            case 2:
                BookItemFragment item3 = new BookItemFragment();
//                bundle.putString("title","Vừa xem");
                vpItem.addFragment(item3);
        }

        viewPager.setAdapter(vpItem);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
