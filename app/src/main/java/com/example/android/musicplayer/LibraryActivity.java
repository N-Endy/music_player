package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        // Create an ArrayList of Library objects
        ArrayList<Library> songs = new ArrayList<>();
        songs.add(new Library("Easy On Me", "Adele", R.drawable.adele));
        songs.add(new Library("Jon Bellion", "All Time Low", R.drawable.cover1));
        songs.add(new Library("Chike", "Amen", R.drawable.cover3));
        songs.add(new Library("Novo Amor", "Anchor", R.drawable.novoamor));
        songs.add(new Library("Calum Scott", "Dancing On My Own", R.drawable.cover2));
        songs.add(new Library("Simi", "Duduke", R.drawable.cover1));
        songs.add(new Library("Wizkid", "Essence", R.drawable.wizkid));
        songs.add(new Library("Ladipoe (feat Buju)", "Feeling", R.drawable.cover3));
        songs.add(new Library("Harry Styles", "Watermelon", R.drawable.harry));
        songs.add(new Library("Tems", "Interference", R.drawable.cover1));
        songs.add(new Library("Labrinth", "Jealous", R.drawable.labrinth));
        songs.add(new Library("Joeboy", "Lonely", R.drawable.cover3));
        songs.add(new Library("James Authur", "Naked", R.drawable.cover2));
        songs.add(new Library("Burna Boy", "Onyeka", R.drawable.burna));
        songs.add(new Library("The Weekend", "I Feel It Coming", R.drawable.weekend));
        songs.add(new Library("Travis Greene", "Made A Way", R.drawable.travis));

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
                //Get the clicked view from the
                Library item = (Library) listView.getAdapter().getItem(arg2);
                Log.d("LibraryActivity", "onItemClick: " + item.getArtisteName());

                // Create a new intent to open {@link PlayActivity}
                Intent playSongIntent = new Intent(LibraryActivity.this, PlayActivity.class);
                // Individual items from view
                playSongIntent.putExtra("songTitle", item.getSongTitle());
                playSongIntent.putExtra("artisteName", item.getArtisteName());
                playSongIntent.putExtra("image", item.getImageResourceId());
                // Start new activity
                startActivity(playSongIntent);
            }

        });
    }
}