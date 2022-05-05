package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

    public class LibraryAdapter extends ArrayAdapter<Library> {

        private static final String LOG_TAG = LibraryAdapter.class.getSimpleName();

        /**
         * This is our own custom constructor (it doesn't mirror a superclass constructor).
         * The context is used to inflate the layout file, and the list is the data we want
         * to populate into the lists.
         *
         * @param context The current context. Used to inflate the layout file.
         * @param songs   A List of AndroidFlavor objects to display in a list
         */
        public LibraryAdapter(Activity context, ArrayList<Library> songs) {
            // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
            // the second argument is used when the ArrayAdapter is populating a single TextView.
            // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
            // going to use this second argument, so it can be any value. Here, we used 0.
            super(context, 0, songs);
        }

        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         *
         * @param position    The position in the list of data that should be displayed in the
         *                    list item view.
         * @param convertView The recycled view to populate.
         * @param parent      The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.activity_library, parent, false);
            }

            // Get the {@link AndroidFlavor} object located at this position in the list
            Library currentLibrary = getItem(position);

            // Find the TextView in the activity_library.xml layout with the ID song_title
            TextView songTitleView = (TextView) listItemView.findViewById(R.id.song_title);
            // Get the version name from the current Library object and
            // set this text on the name TextView
            songTitleView.setText(currentLibrary.getSongTitle());

            // Find the TextView in the activity_library.xml layout with the ID artiste_name
            TextView artisteNameView = (TextView) listItemView.findViewById(R.id.artiste_name);
            // Get the version number from the current Library object and
            // set this text on the artiste TextView
            artisteNameView.setText(currentLibrary.getArtisteName());

            // Find the ImageView in the activity_library.xml layout with the ID song_icon
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.song_icon);
            // Get the image resource ID from the current Library object and
            // set the image to iconView
            iconView.setImageResource(currentLibrary.getImageResourceId());

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }
}
