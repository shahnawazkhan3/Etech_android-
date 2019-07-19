package com.zaaviyah.etech_304_firebase;

class Tb_Artist {


    String ArtistID;
    String ArtistName;
    String ArtistEmail;

    Tb_Artist(){

    }

    public Tb_Artist(String artistID, String artistName, String artistEmail) {
        ArtistID = artistID;
        ArtistName = artistName;
        ArtistEmail = artistEmail;
    }

    public String getArtistID() {
        return ArtistID;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public String getArtistEmail() {
        return ArtistEmail;
    }
}
