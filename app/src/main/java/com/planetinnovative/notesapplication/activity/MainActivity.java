package com.planetinnovative.notesapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.planetinnovative.notesapplication.R;
import com.planetinnovative.notesapplication.adapter.NoteCustomAdapter;
import com.planetinnovative.notesapplication.app.Constant;
import com.planetinnovative.notesapplication.model.NoteModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<NoteModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("CREATE");
        data = new ArrayList<>();
        recyclerView = findViewById(R.id.notesRecycler);

        //Initialize
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm mReal = Realm.getInstance(config);

        //Get All data
        RealmResults<NoteModel> realmData = mReal.where(NoteModel.class).findAll();
        for (int i = 0; i < realmData.size(); i++) {
            data.add(realmData.get(i));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new NoteCustomAdapter(getApplicationContext(), data));
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Resume");
    }


    @Override
    protected void onPause() {
        System.out.println("PAuse");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("STOP");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        data = new ArrayList<>();
        //Initialize
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm mReal = Realm.getInstance(config);

        //Get All data
        RealmResults<NoteModel> realmData = mReal.where(NoteModel.class).findAll();
        for (int i = 0; i < realmData.size(); i++) {
            data.add(realmData.get(i));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new NoteCustomAdapter(getApplicationContext(), data));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addNote) {
            Intent intent = new Intent(getApplicationContext(), AddNoteActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }


    @Override
    protected void onDestroy() {
        System.out.println("DESTROy");
        super.onDestroy();
    }
}
