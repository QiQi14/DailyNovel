package main.dailynovel.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import main.dailynovel.ItemClickListener;
import main.dailynovel.NovelActivity;
import main.dailynovel.Objects.*;
import main.dailynovel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookcaseItemFragment extends Fragment {
    RecyclerView rvBookcase;
    NovelAdapterVertical adapterVertical;
    List<Novel> novels = new ArrayList<>();

    public BookcaseItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookcase_item, container, false);

        rvBookcase = (RecyclerView) view.findViewById(R.id.rvBookcase);
        LinearLayoutManager vertical = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        rvBookcase.setLayoutManager(vertical);
        rvBookcase.setItemAnimator(new DefaultItemAnimator());
        rvBookcase.addItemDecoration(new DividerItemDecoration(
                rvBookcase.getContext(),
                vertical.getOrientation()
        ));

        adapterVertical = new NovelAdapterVertical(getActivity(), novels, new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), NovelActivity.class);
                startActivity(intent);
            }
        });
        rvBookcase.setAdapter(adapterVertical);

        return view;
    }
}
