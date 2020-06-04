package com.slash.slashcast.profile.rvProfile;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.customControls.CustomTextViewLight;
import com.slash.slashcast.customControls.CustomTextViewMedium;

import java.util.List;

public class RvProfileAdapter extends RecyclerView.Adapter<RvProfileAdapter.ProfileViewHolder> {

    private List<RvProfileModel> list;

    public RvProfileAdapter(List<RvProfileModel> list) {
        this.list = list;
    }

    public void setList(List<RvProfileModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Application.getContext()).inflate(
                R.layout.item_profile, parent, false
        );
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        RvProfileModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.author.setText(model.getAuthorName());
        holder.time.setText(model.getTime());
        holder.price.setText(model.getPrice());

        Glide.with(Application.getContext())
                .load(model.getPic())
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(false)
                .into(holder.pic);

        Glide.with(Application.getContext())
                .load(model.getAuthorPic())
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(false)
                .into(holder.authorPic);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        CustomTextViewMedium title;
        CustomTextViewLight author, time, price;
        ImageView pic, authorPic;

        ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.itemProfileTime);
            title = itemView.findViewById(R.id.itemProfileTitle);
            author = itemView.findViewById(R.id.itemProfileAuthorName);
            price = itemView.findViewById(R.id.itemProfilePrice);

            pic = itemView.findViewById(R.id.itemProfilePic);
            authorPic = itemView.findViewById(R.id.itemProfileAuthor);
        }
    }
}
