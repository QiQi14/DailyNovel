package main.dailynovel;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by l3umb on 11/23/2017.
 */

public class NovelHolderVertical extends ViewHolder {
    ImageView imgCover;
    TextView txtTitle;
    public NovelHolderVertical(View itemView) {
        super(itemView);
        imgCover = (ImageView)itemView.findViewById(R.id.imgCover);
        txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
    }
}
