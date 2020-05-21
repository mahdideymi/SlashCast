package com.slash.slashcast.home.rvSubject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slash.slashcast.Application;
import com.slash.slashcast.R;
import com.slash.slashcast.customControls.CustomTextViewHeavy;
import com.slash.slashcast.home.rvChapter.RvChapterAdapter;

import java.util.ArrayList;

public class RvSubjectAdapter extends RecyclerView.Adapter<RvSubjectAdapter.RvSubjectViewHolder> {

    private ArrayList<RvSubjectModel> list;

    public RvSubjectAdapter() {
    }

    public void setList (ArrayList<RvSubjectModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RvSubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Application.getContext())
                    .inflate(R.layout.item_subject , parent , false);
        return new RvSubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvSubjectViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(Application.getContext()
                , RecyclerView.HORIZONTAL, false));
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setAdapter(new RvChapterAdapter(list.get(position).getChapterList()));

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


    class RvSubjectViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        CustomTextViewHeavy textView;

        RvSubjectViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.subjectRv);
            textView = itemView.findViewById(R.id.subjectTitle);
        }
    }
}
