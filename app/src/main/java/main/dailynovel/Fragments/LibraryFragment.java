package main.dailynovel.Fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import main.dailynovel.CategoryActivity;
import main.dailynovel.ChartActivity;
import main.dailynovel.FilterActivity;
import main.dailynovel.ItemClickListener;
import main.dailynovel.MainActivity;
import main.dailynovel.NovelActivity;
import main.dailynovel.Objects.*;
import main.dailynovel.R;
import main.dailynovel.RSSActivity;
import main.dailynovel.SearchActivity;
import main.dailynovel.SlideViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryFragment extends Fragment {
    ImageButton imbSearch;
    Button btnFilter, btnChart, btnCategory, btnNews;
    RecyclerView rvRecentUpdate, rvMostView;
    ViewPager vpSlide;
    NovelAdapterVertical adapterVertical;
    NovelAdapterHorizontal adapterHorizontal;
    MainActivity mainActivity;

    public LibraryFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        mainActivity = new MainActivity();

        imbSearch = (ImageButton) view.findViewById(R.id.imbSearch);
        imbSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SearchActivity.class);
                startActivity(i);
            }
        });

        btnFilter = (Button) view.findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FilterActivity.class);
                startActivity(intent);
            }
        });

        btnCategory = (Button) view.findViewById(R.id.btnCategory);
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryActivity.class);
                startActivity(intent);
            }
        });

        btnChart = (Button) view.findViewById(R.id.btnChart);
        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChartActivity.class);
                startActivity(intent);
            }
        });

        btnNews = (Button) view.findViewById(R.id.btnNews);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RSSActivity.class);
                startActivity(intent);
            }
        });

        //Slide Adapter
        vpSlide = view.findViewById(R.id.vpSlide);
        SlideViewPager adapter = new SlideViewPager(getActivity());
        vpSlide.setAdapter(adapter);
        //Carousel timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MytimerTask(),500,5000);

        Preload novelTask = new Preload(view, this.getActivity());
        Log.d("taskfinish", "Task start");
        novelTask.execute();
        return view;
    }

    public class MytimerTask extends TimerTask {
        @Override
        public void run() {
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(vpSlide.getCurrentItem()==0) {
                        vpSlide.setCurrentItem(1, true);
                    }else if(vpSlide.getCurrentItem()==1){
                        vpSlide.setCurrentItem(2, true);
                    }else {
                        vpSlide.setCurrentItem(0, true);
                    }
                }
            });
        }
    }

    class Preload extends AsyncTask<String, Integer, List<String>>{
        View view;
        Activity activity;
        List<Novel> novels = new ArrayList<>();

        public Preload(View view, Activity activity) {
            this.activity = activity;
            this.view = view;

            rvMostView = (RecyclerView)view.findViewById(R.id.rvMostView);
            LinearLayoutManager vertical = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
            rvMostView.setLayoutManager(vertical);
            rvMostView.setItemAnimator(new DefaultItemAnimator());
            rvMostView.addItemDecoration(new DividerItemDecoration(
                    rvMostView.getContext(),
                    vertical.getOrientation()
            ));
            rvMostView.setNestedScrollingEnabled(false);

            rvRecentUpdate = (RecyclerView)view.findViewById(R.id.rvRecentUpdate);
            LinearLayoutManager horizontal = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
            rvRecentUpdate.setLayoutManager(horizontal);
            rvRecentUpdate.setItemAnimator(new DefaultItemAnimator());

            try {
                adapterHorizontal = new NovelAdapterHorizontal(getActivity(), novels, new ItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent = new Intent(getActivity(), NovelActivity.class);
                        intent.putExtra("Object", novels.get(position));
                        startActivity(intent);
                    }
                });
                adapterVertical = new NovelAdapterVertical(getActivity(), novels, new ItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent = new Intent(getActivity(), NovelActivity.class);
                        intent.putExtra("Object", novels.get(position));
                        startActivity(intent);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            rvRecentUpdate.setAdapter(adapterHorizontal);
            rvMostView.setAdapter(adapterVertical);
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            adapterHorizontal.notifyDataSetChanged();
            adapterVertical.notifyDataSetChanged();
        }

        @Override
        protected List<String> doInBackground(String... strings) {
            for (int i = 1; i < 8; i++) {
                try {
                    novels.add(Crawler.getNovelList(1, 0, i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SystemClock.sleep(50);
                publishProgress(i);
            }
            return null;
        }
    }
}
