package com.slash.slashcast.home.rvProducer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ItemProducerBinding;

import java.util.ArrayList;

public class RvProducerAdapter extends RecyclerView.Adapter<RvProducerAdapter.RvProducerViewHolder> {

    private ArrayList<RvProducerModel> list;

    public void setList(ArrayList<RvProducerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RvProducerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProducerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(Application.getContext()),
                R.layout.item_producer, parent, false);
        return new RvProducerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvProducerViewHolder holder, int position) {
        RvProducerModel model = list.get(position);
        holder.binding.setProducer(model);
        Glide.with(Application.getContext())
                .load(model.getImg())
                .placeholder(R.drawable.btn)
                .skipMemoryCache(false)
                .into(holder.binding.producerImg);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class RvProducerViewHolder extends RecyclerView.ViewHolder {

        ItemProducerBinding binding;

        RvProducerViewHolder(@NonNull ItemProducerBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
