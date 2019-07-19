package com.zaaviyah.etech_304_firebase;

import android.widget.EditText;

class Tb_AddTract {



    String IdTrack;
    String name ;
    String TrackAdd;


    Tb_AddTract(String id, String name, EditText rank){

    }


    public Tb_AddTract(String idTrack, String name, String trackAdd) {
        IdTrack = idTrack;
        this.name = name;
        TrackAdd = trackAdd;
    }

    public String getIdTrack() {
        return IdTrack;
    }

    public String getName() {
        return name;
    }

    public String getTrackAdd() {
        return TrackAdd;
    }
}
