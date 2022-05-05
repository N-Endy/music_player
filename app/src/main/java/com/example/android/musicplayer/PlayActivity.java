package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    /**
     * Method to get extras from incoming Intent
     */
    private void getIncomingIntent() {
        if(getIntent().hasExtra("songTitle") && getIntent().hasExtra("artisteName")) {
            String songTitle = getIntent().getStringExtra("songTitle");
            String artisteName = getIntent().getStringExtra("artisteName");

            setIncomingIntent(songTitle, artisteName);
        }
    }

    /**
     *
     * @param songTitle song title gotten from Intent
     * @param artisteName artiste name gotten from Intent
     */
    private void setIncomingIntent(String songTitle, String artisteName) {
        // Find and set text on the play_song_title textview
        TextView title = findViewById(R.id.play_song_title);
        title.setText(songTitle);

        // Find and set text on the play_song_artise textview
        TextView name = findViewById(R.id.play_song_artiste);
        name.setText(artisteName);

        // Find and set text on the play_song_artise textview
        ImageView imageView = (ImageView) findViewById(R.id.play_song_image);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int image = bundle.getInt("image");
            imageView.setImageResource(image);
        }
    }
}