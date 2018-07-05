package com.example.android.musicstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by klaudia on 05/05/18.
 */

class SongAdapter extends ArrayAdapter<Song> {

    private static class ViewHolder {
        private TextView authorTextView;
        private TextView titleTextView;
    }

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        ViewHolder holder;

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.library_list_item, parent, false);
            holder = new ViewHolder();
            holder.authorTextView = (TextView) listItemView.findViewById(R.id.author);
            holder.titleTextView = (TextView) listItemView.findViewById(R.id.title);
            listItemView.setTag(holder);
        }
        else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Song currentWord = getItem(position);

        holder.authorTextView.setText(currentWord.getAuthor());
        holder.titleTextView.setText(currentWord.getTitle());

        return listItemView;
    }
}
