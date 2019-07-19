package com.zaaviyah.etech_304_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddtrctActivity extends AppCompatActivity {

     EditText etname, Rank;
     Button b1add;

     DatabaseReference databaseAddTract;
     FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrct);

        databaseAddTract= FirebaseDatabase.getInstance().getReference("Home").child("Tb_Addtract");

        etname=(EditText) findViewById(R.id.etAddName);
        Rank=(EditText)findViewById(R.id.etAddRanmk);
        b1add=(Button)findViewById(R.id.btAddArtist);


        b1add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Addtrct();
            }
        });


    }

    private void Addtrct() {


        String name =etname.getText().toString();
        String rank =Rank.getText().toString();



        if (!TextUtils.isEmpty(name)){

            String id =databaseAddTract.push().getKey();


            Tb_AddTract tb_addTract = new Tb_AddTract(id,name,rank);

            databaseAddTract.child(id).setValue(tb_addTract);



            Toast.makeText(getApplicationContext(),"Add Data ",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(getApplicationContext(),"Please Enter name ",Toast.LENGTH_LONG).show();
        }

    }

}
