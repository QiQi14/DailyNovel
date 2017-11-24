package main.dailynovel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import main.dailynovel.Object.Novel;

/**
 * Created by l3umb on 11/23/2017.
 */

public class NovelAdapterVertical extends RecyclerView.Adapter<NovelHolderVertical>{

    List<Novel> Novellist;
    Context context;

    public NovelAdapterVertical(Context context, List<Novel> Novellist) {
        this.context = context;
        this.Novellist = Novellist;
    }
    @Override
    public NovelHolderVertical onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizon,null);
        NovelHolderVertical holderVertical = new NovelHolderVertical(view);
        return holderVertical;
    }

    @Override
    public void onBindViewHolder(NovelHolderVertical holder, int position) {
        holder.imgCover.setImageResource(Integer.parseInt(Novellist.get(position).getNovelCover()));
        holder.txtTitle.setText(Novellist.get(position).getNovelName());
    }

    @Override
    public int getItemCount() {
        return Novellist.size();
    }
}
