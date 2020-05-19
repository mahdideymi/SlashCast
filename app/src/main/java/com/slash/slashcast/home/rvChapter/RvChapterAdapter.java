package com.slash.slashcast.home.rvChapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ItemChapterBinding;

import java.util.ArrayList;

public class RvChapterAdapter extends RecyclerView.Adapter<RvChapterAdapter.RvChapterViewHolder> {

    private ArrayList<RvChapterDetail> chapterList;
    private String pic = "https://source.unsplash.com/1600x900/?nature,water";
    private String[] pics = {"https://source.unsplash.com/1600x900/?nature,water"
        , "https://source.unsplash.com/100x100/?face"
        , "https://source.unsplash.com/100x100/?life"
        , "https://source.unsplash.com/100x100/?home"
        , "https://source.unsplash.com/100x100/?water"
        , "https://source.unsplash.com/100x100/?nature"
            , "https://source.unsplash.com/100x100/?home"
            , "https://source.unsplash.com/100x100/?water"
            , "https://source.unsplash.com/100x100/?nature"};
    @NonNull
    @Override
    public RvChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChapterBinding itemChapterBinding =
                DataBindingUtil.inflate(LayoutInflater.from(Application.getContext()),
                        R.layout.item_chapter , parent, false);
        return new RvChapterViewHolder(itemChapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvChapterViewHolder holder, int position) {
        RvChapterDetail model = chapterList.get(position);
        holder.itemChapterBinding.setPost(model);
        Glide.with(Application.getContext())
                .setDefaultRequestOptions(new RequestOptions())
                .load(pics[position])
                .skipMemoryCache(false)
                .placeholder(R.drawable.btn)
                .into(holder.itemChapterBinding.chapterImage);
        if (position % 2 == 0)
            holder.itemChapterBinding.chapterMoneyIcon.setImageDrawable(
                        ContextCompat.getDrawable(Application.getContext(), R.drawable.ic_video)
            );
        else
            holder.itemChapterBinding.chapterMoneyIcon.setImageDrawable(
                        ContextCompat.getDrawable(Application.getContext(), R.drawable.ic_music)
            );

    }

    @Override
    public int getItemCount() {
        return chapterList != null ? chapterList.size() : 0;
    }

    public void setChapterList(ArrayList<RvChapterDetail> chapterList) {
        this.chapterList = chapterList;
        notifyDataSetChanged();
    }

    class RvChapterViewHolder extends RecyclerView.ViewHolder{

        private ItemChapterBinding itemChapterBinding;

        RvChapterViewHolder(@NonNull ItemChapterBinding itemChapterBinding) {
            super(itemChapterBinding.getRoot());

            this.itemChapterBinding = itemChapterBinding;
        }
    }
}
