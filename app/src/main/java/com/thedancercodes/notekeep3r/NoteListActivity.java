package com.thedancercodes.notekeep3r;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        
        // Populate the ListView
        initializeDisplayContent();

    }

    private void initializeDisplayContent() {

        // Get a reference to the ListView
        ListView listNotes = findViewById(R.id.list_notes);

        // Get List of all Notes
        List<NoteInfo> notes =  DataManager.getInstance().getNotes();

        // Create Adapter to associate List of Notes with the ListView
        ArrayAdapter<NoteInfo> adapterNotes =
                new ArrayAdapter<NoteInfo>(this, android.R.layout.simple_list_item_1, notes);

        // Associate the Adapter with the ListView.
        listNotes.setAdapter(adapterNotes);


    }

}
