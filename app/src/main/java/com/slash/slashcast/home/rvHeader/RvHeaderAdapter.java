package com.slash.slashcast.home.rvHeader;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ItemHeaderHomeBinding;

import java.util.ArrayList;

public class RvHeaderAdapter extends RecyclerView.Adapter<RvHeaderAdapter.RvHeaderViewHolder> {

    private ArrayList<RvHeaderModel> list;

    public RvHeaderAdapter(ArrayList<RvHeaderModel> list) {
        this.list = list;
    }

    public RvHeaderAdapter() {

    }

    public void setList (ArrayList<RvHeaderModel> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RvHeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHeaderHomeBinding item = DataBindingUtil.inflate(LayoutInflater.from(Application.getContext()),
                R.layout.item_header_home, parent, false);
        return new RvHeaderViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHeaderViewHolder holder, int position) {
        RvHeaderModel model = list.get(position);
        holder.itemHeaderHomeBinding.setHeader(model);
        Glide.with(Application.getContext())
                .load(model.getPic())
                .placeholder(R.drawable.btn)
                .skipMemoryCache(false)
                .into(holder.itemHeaderHomeBinding.itemHeaderImg);

        Glide.with(Application.getContext())
                .load(model.getProfilePic())
                .placeholder(R.drawable.btn)
                .skipMemoryCache(false)
                .into(holder.itemHeaderHomeBinding.itemHeaderProfileSrc);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class RvHeaderViewHolder extends RecyclerView.ViewHolder{

        ItemHeaderHomeBinding itemHeaderHomeBinding;
        RvHeaderViewHolder(@NonNull ItemHeaderHomeBinding itemView) {
            super(itemView.getRoot());
            this.itemHeaderHomeBinding = itemView;
        }
    }
}
