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

    //mock
    private String[] pics = {"https://source.unsplash.com/100x100/?nature,water"
            , "https://source.unsplash.com/100x100/?face"
            , "https://source.unsplash.com/100x100/?life"
            , "https://source.unsplash.com/100x100/?home"
            , "https://source.unsplash.com/100x100/?water"
            , "https://source.unsplash.com/100x100/?nature" };

    private String[] pics1 = {"https://source.unsplash.com/100x100/?energy"
            , "https://source.unsplash.com/100x100/?style"
            , "https://source.unsplash.com/100x100/?fashion"
            , "https://source.unsplash.com/100x100/?shirt"
            , "https://source.unsplash.com/100x100/?friends"
            , "https://source.unsplash.com/100x100/?free" };

    private String[] pics2 = {"https://source.unsplash.com/100x100/?mom"
            , "https://source.unsplash.com/100x100/?dad"
            , "https://source.unsplash.com/100x100/?old"
            , "https://source.unsplash.com/100x100/?art"
            , "https://source.unsplash.com/100x100/?people"
            , "https://source.unsplash.com/100x100/?city" };

    private String[] pics3 = {"https://source.unsplash.com/100x100/?country"
            , "https://source.unsplash.com/100x100/?ronaldo"
            , "https://source.unsplash.com/100x100/?messi"
            , "https://source.unsplash.com/100x100/?iran"
            , "https://source.unsplash.com/100x100/?computer"
            , "https://source.unsplash.com/100x100/?it" };



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
        switch (position){
            case 0:
                holder.recyclerView.setAdapter(new RvChapterAdapter(list.get(position).getChapterList(), pics));
                break;
            case 1:
                holder.recyclerView.setAdapter(new RvChapterAdapter(list.get(position).getChapterList(), pics1));
                break;
            case 2:
                holder.recyclerView.setAdapter(new RvChapterAdapter(list.get(position).getChapterList(), pics2));
                break;
            case 3:
                holder.recyclerView.setAdapter(new RvChapterAdapter(list.get(position).getChapterList(), pics3));
                break;
            default:
                break;
        }

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
