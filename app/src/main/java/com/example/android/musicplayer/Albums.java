package com.example.android.musicplayer;

public class Albums {

    // Name of song
    private String mSongTitle;

    // Name of artist
    private String mArtisteName;

    // Drawable resource ID
    private int mImageResourceId;

    /**
     * Create a new Album Object
     *
     * @param vSongTitle is the title of the song
     * @param vArtisteName is the name of the artiste
     * @param image is drawable reference ID
     */
    public Albums(String vSongTitle, String vArtisteName, int image) {
        mSongTitle = vSongTitle;
        mArtisteName = vArtisteName;
        mImageResourceId = image;
    }

    /**
     * Get the title of song
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the name of artiste
     */
    public String getArtisteName() {
        return mArtisteName;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
