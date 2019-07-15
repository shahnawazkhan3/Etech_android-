package com.zaaviyah.etech_304_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button b1DDartis,b2Register ,b3forgetpass;
    EditText etATISname;
    Spinner spGeneric;

    private FirebaseAuth auth;

    DatabaseReference databaseArtists,databaseProduct;

     List<Tb_Artist> artists;

     ListView lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //store data instance
        artists=new ArrayList<>();


        etATISname= (EditText)findViewById(R.id.etName);
        b1DDartis =(Button) findViewById(R.id.btAddArtist);
        spGeneric=(Spinner) findViewById(R.id.spone);
        lists=(ListView)findViewById(R.id.listone) ;



        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("Home").child("tb_artist");
        databaseProduct = FirebaseDatabase.getInstance().getReference("Home").child("tb_product");

        b1DDartis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addArtist();
            }
        });


    }

    private void addArtist() {

        String name = etATISname.getText().toString();
        String genre = spGeneric.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Tb_Artist artist = new Tb_Artist(id,name,genre);

            //Saving the Artist
            databaseArtists.child(name).setValue(artist);

            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();



        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                artists.clear();


                for( DataSnapshot postSnapshot : dataSnapshot.getChildren()){


                    //getting artist
                    Tb_Artist artist = postSnapshot.getValue(Tb_Artist.class);
                    //adding artist to the list
                    artists.add(artist);
                }
                // HERE CODE LITe

                List_View listAdptor =new List_View(MainActivity.this,artists);
                lists.setAdapter(listAdptor);
                

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.d("artist ","fail");
            }
        });
    }
}
