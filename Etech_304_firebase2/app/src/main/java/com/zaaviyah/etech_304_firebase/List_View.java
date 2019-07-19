package com.zaaviyah.etech_304_firebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class List_View extends ArrayAdapter <Tb_Artist> {

    private Activity context;
    List<Tb_Artist> artists;



    public List_View(Activity context, List<Tb_Artist> artists) {

        super(context, R.layout.list_view, artists);
        this.context = context;
        this.artists = artists;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        LayoutInflater infalater =context.getLayoutInflater();


        View listView  =infalater.inflate(R.layout.list_view,null,true);

        TextView tvname =(TextView)listView.findViewById(R.id.tvname);
        TextView tvspone =(TextView)listView.findViewById(R.id.tvspone);


        //Tb_artist table


        Tb_Artist artist = artists.get(position);

        tvname.setText(artist.getArtistName());
        tvspone.setText(artist.getArtistEmail());
        // name
        //

         return listView;

    }
}
