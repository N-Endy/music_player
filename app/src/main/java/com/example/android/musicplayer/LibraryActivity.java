package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        // Create an ArrayList of Library objects
        ArrayList<Library> songs = new ArrayList<>();
        songs.add(new Library("Donut", "1.6", R.drawable.mostplay));
        songs.add(new Library("Eclair", "2.0-2.1", R.drawable.mostplay));
        songs.add(new Library("Froyo", "2.2-2.2.3", R.drawable.mostplay));
        songs.add(new Library("GingerBread", "2.3-2.3.7", R.drawable.mostplay));
        songs.add(new Library("Honeycomb", "3.0-3.2.6", R.drawable.mostplay));
        songs.add(new Library("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.mostplay));
        songs.add(new Library("Jelly Bean", "4.1-4.3.1", R.drawable.mostplay));
        songs.add(new Library("KitKat", "4.4-4.4.4", R.drawable.mostplay));
        songs.add(new Library("Lollipop", "5.0-5.1.1", R.drawable.mostplay));
        songs.add(new Library("Marshmallow", "6.0-6.0.1", R.drawable.mostplay));

        // Create an {@link LibraryAdapter}, whose data source is a list of
        // {@link Library}s. The adapter knows how to create list item views for each item
        // in the list.
        LibraryAdapter libraryAdapter = new LibraryAdapter(this, songs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(libraryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                // Create a new intent to open {@link NumbersActivity}
                Intent playSongIntent = new Intent(LibraryActivity.this, PlayActivity.class);
                // Start new activity
                startActivity(playSongIntent);
            }

        });
    }
}