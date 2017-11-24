package main.dailynovel.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import main.dailynovel.R;

/**
 * Created by l3umb on 11/23/2017.
 */

public class BookItemFragment extends Fragment {
    String title = "aa";
    public BookItemFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookitem, container, false);
        TextView txt1 = (TextView)view.findViewById(R.id.txt1);
        txt1.setText(title);
        return view;
    }

    public String toString() {
        return title;
    }
}
