package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("songTitle") && getIntent().hasExtra("artisteName")) {
            String songTitle = getIntent().getStringExtra("songTitle");
            String artisteName = getIntent().getStringExtra("artisteName");

            setIncomingIntent(songTitle, artisteName);
        }
    }

    private void setIncomingIntent(String songTitle, String artisteName) {
        TextView title = findViewById(R.id.play_song_title);
        title.setText(songTitle);
        TextView name = findViewById(R.id.play_song_artiste);
        name.setText(artisteName);
    }
}