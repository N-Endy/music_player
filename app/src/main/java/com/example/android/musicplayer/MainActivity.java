package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the album category
        CardView albums = findViewById(R.id.home_album);

        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the albums View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open {@link NumbersActivity}
                Intent albumsIntent = new Intent(MainActivity.this, AlbumActivity.class);
                // Start new activity
                startActivity(albumsIntent);
            }
        });

        // Find the View that shows the library category
        CardView songs = findViewById(R.id.home_library);

        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the songs View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open {@link NumbersActivity}
                Intent songsIntent = new Intent(MainActivity.this, LibraryActivity.class);
                // Start new activity
                startActivity(songsIntent);
            }
        });

    }
}