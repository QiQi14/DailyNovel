package main.dailynovel.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

import main.dailynovel.MainActivity;
import main.dailynovel.R;
import main.dailynovel.Search;
import main.dailynovel.Viewpager_slide_Adapter;

/**
 * Created by l3umb on 11/23/2017.
 */

public class LibraryFragment extends Fragment {
    ImageButton btnSearch;
    ViewPager viewPager;
    MainActivity mainActivity;
    public void LibraryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_library,null);
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
