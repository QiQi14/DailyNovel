package main.dailynovel.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import main.dailynovel.ItemClickListener;
import main.dailynovel.NovelActivity;
import main.dailynovel.Objects.Crawler;
import main.dailynovel.Objects.Novel;
import main.dailynovel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortItemFragment extends Fragment {
    RecyclerView rvSort;
    NovelAdapterHorizontal adapterHorizontal;
    int Genre;

    public SortItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sort_item, container, false);
        if (getArguments() != null) {
            Genre = getArguments().getInt("genre");
        }
        Preload novelTask = new Preload(view, this.getActivity());
        novelTask.execute();
        return view;
    }

    class Preload extends AsyncTask<String, Integer, List<String>> {
        View view;
        Activity activity;
        List<Novel> novels = new ArrayList<>();

        public Preload(View view, Activity activity) {
            this.activity = activity;
            this.view = view;

            rvSort = (RecyclerView) view.findViewById(R.id.rvSort);
            GridLayoutManager grid3column = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
            rvSort.setLayoutManager(grid3column);
            rvSort.setItemAnimator(new DefaultItemAnimator());

            try {
                adapterHorizontal = new NovelAdapterHorizontal(getActivity(), novels, new ItemClickListener() {
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

            rvSort.setAdapter(adapterHorizontal);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            novels.clear();
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int i = values[0];

            if(i%3==0) {
                adapterHorizontal.notifyDataSetChanged();
            }
        }

        @Override
        protected List<String> doInBackground(String... strings) {
            for (int i = 0; i < 18; i++) {
                SystemClock.sleep(50);
                try {
                    novels.add(Crawler.getNovelList(1, Genre, i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }
    }
}
