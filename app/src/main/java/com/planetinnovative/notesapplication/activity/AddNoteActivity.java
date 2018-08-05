package com.planetinnovative.notesapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.planetinnovative.notesapplication.R;
import com.planetinnovative.notesapplication.model.NoteModel;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNoteTitle, etNoteDetail;
    private RadioButton radioHigh, radioLow;
    private Button btnAddNote;

    private String noteTitle, noteDetail, notePriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etNoteTitle = findViewById(R.id.etNoteTitle);
        etNoteDetail = findViewById(R.id.etNoteDetail);
        radioHigh = findViewById(R.id.radioHigh);
        radioLow = findViewById(R.id.radioLow);
        btnAddNote = findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        noteTitle = etNoteTitle.getText().toString();
        noteDetail = etNoteDetail.getText().toString();
        if (radioHigh.isChecked())
            notePriority = "High";
        else
            notePriority = "Low";

        //Realm Initilization
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm mReal = Realm.getInstance(config);

        //Storing
        mReal.beginTransaction();
        NoteModel model = mReal.createObject(NoteModel.class, new Random().nextInt());
        model.setNote(noteTitle, noteDetail, notePriority);
        mReal.commitTransaction();

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
