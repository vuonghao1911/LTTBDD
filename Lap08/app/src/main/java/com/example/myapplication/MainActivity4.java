package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity4 extends AppCompatActivity {
    private TextView tvUser;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvUser = findViewById(R.id.idUserName);

    db = FirebaseFirestore.getInstance();
        Intent i = getIntent();
        String uid = i.getStringExtra("uid");

        db.collection("User").document(uid).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!= null){
                    Log.d(TAG,error.getMessage());
                }
                String name = value.getString("name");
                tvUser.setText(name);
                Log.d(TAG,value.getData().toString());
            }
        });



    }
}