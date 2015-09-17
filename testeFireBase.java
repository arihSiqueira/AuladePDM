package com.example.aluno.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final TextView resultArea = (TextView) findViewById(R.id.result);

        Firebase myFirebaseRef = new Firebase("https://gowithit.firebaseio.com/");

        myFirebaseRef.child("name").addValueEventListener(new ValueEventListener() {
            StringBuilder finalResult = new StringBuilder();

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                finalResult.append(snapshot.getValue());
                resultArea.setText(finalResult);


                //System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

    }
