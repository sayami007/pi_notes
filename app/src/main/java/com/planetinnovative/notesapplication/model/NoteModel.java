package com.planetinnovative.notesapplication.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NoteModel extends RealmObject {

    @PrimaryKey
    private int noteId;
    private String noteTitle;
    private String noteDetail;
    private String notePriority;

    public void setNote(String noteTitle, String noteDetail, String notePriority) {
        this.noteTitle = noteTitle;
        this.noteDetail = noteDetail;
        this.notePriority = notePriority;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteDetail() {
        return noteDetail;
    }

    public String getNotePriority() {
        return notePriority;
    }
}
