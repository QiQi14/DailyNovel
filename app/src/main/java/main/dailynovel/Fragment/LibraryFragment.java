package main.dailynovel.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import main.dailynovel.MainActivity;
import main.dailynovel.NovelAdapterVertical;
import main.dailynovel.Object.Novel;
import main.dailynovel.R;
import main.dailynovel.Search;
import main.dailynovel.Viewpager_slide_Adapter;

/**
 * Created by l3umb on 11/23/2017.
 */

public class LibraryFragment extends Fragment {
    ImageButton btnSearch;
    ViewPager viewPager;
    NovelAdapterVertical novelAdapterVertical;
    MainActivity mainActivity;
    RecyclerView rvVertical,rvHoriz;
    List<Novel> Novellist = new ArrayList<>();
    public void LibraryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_library,null);
        rvVertical = (RecyclerView)view.findViewById(R.id.rvTruyenmoi);
        LinearLayoutManager verticcal = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rvVertical.setLayoutManager(verticcal);
        rvVertical.setItemAnimator(new DefaultItemAnimator());
        rvHoriz = (RecyclerView)view.findViewById(R.id.rvMostView);
        LinearLayoutManager horizon = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        rvHoriz.setLayoutManager(horizon);
        rvHoriz.setItemAnimator(new DefaultItemAnimator());
        Novel novel = new Novel(1,"Bào xuất ngã nhân sinh","BBB","CCC","DDD",1, String.valueOf(R.drawable.rv1));
        Novel novel2 = new Novel(2,"Ngã đích thiên niên nữ quỷ vị hôn thê","BBB","CCC","DDD",1, String.valueOf(R.drawable.rv2));
        Novel novel3 = new Novel(3,"Quần tinh chi đảo hôn lục","BBB","CCC","DDD",1, String.valueOf(R.drawable.rv3));
        Novel novel4 = new Novel(4,"Tây du địa đồ","BBB","CCC","DDD",1, String.valueOf(R.drawable.rv4));
        Novel novel5 = new Novel(5,"Thế giới vũ thần","BBB","CCC","DDD",1, String.valueOf(R.drawable.hinhtest));
        Novellist.add(novel);
        Novellist.add(novel2);
        Novellist.add(novel3);
        Novellist.add(novel4);
        Novellist.add(novel5);

        novelAdapterVertical = new NovelAdapterVertical(getActivity(),Novellist);
        rvVertical.setAdapter(novelAdapterVertical);
        rvHoriz.setAdapter(novelAdapterVertical);
        mainActivity = new MainActivity();
        btnSearch = (ImageButton) view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Search.class);
                startActivity(i);
            }
        });

        viewPager = view.findViewById(R.id.viewpager);
        Viewpager_slide_Adapter viewpagerSlideAdapter = new Viewpager_slide_Adapter(getActivity());
        viewPager.setAdapter(viewpagerSlideAdapter);

        //      AUTO SLIDE
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MytimerTask(),500,5000);

        return view;
    }
    public class MytimerTask extends TimerTask {

        @Override
        public void run() {
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0) {
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
