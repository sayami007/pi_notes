package com.planetinnovative.notesapplication.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.planetinnovative.notesapplication.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNoteTitle, tvNoteDetail, tvNotePriority;

    public NoteViewHolder(View itemView) {
        super(itemView);
        tvNoteTitle = itemView.findViewById(R.id.tvNoteTitle);
        tvNoteDetail = itemView.findViewById(R.id.tvNoteDetail);
        tvNotePriority = itemView.findViewById(R.id.tvNotePriority);
    }
}
