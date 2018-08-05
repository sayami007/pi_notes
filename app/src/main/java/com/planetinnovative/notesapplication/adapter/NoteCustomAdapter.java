package com.planetinnovative.notesapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.planetinnovative.notesapplication.R;
import com.planetinnovative.notesapplication.model.NoteModel;
import com.planetinnovative.notesapplication.viewHolder.NoteViewHolder;

import java.util.ArrayList;

public class NoteCustomAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<NoteModel> data;

    public NoteCustomAdapter(Context ctx, ArrayList<NoteModel> data) {
        this.inflater = LayoutInflater.from(ctx);
        this.data = data;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_note_ui, parent, false);
        NoteViewHolder holder = new NoteViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.tvNoteTitle.setText(data.get(position).getNoteTitle());
        holder.tvNoteDetail.setText(data.get(position).getNoteDetail());
        if (data.get(position).getNotePriority().equals("High"))
            holder.tvNotePriority.setText("H");
        else
            holder.tvNotePriority.setText("L");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
