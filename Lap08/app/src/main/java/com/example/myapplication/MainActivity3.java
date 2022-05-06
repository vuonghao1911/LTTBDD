package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity3 extends AppCompatActivity {

    private Button btnRe;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPass;
    private EditText edtRePass;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnRe = findViewById(R.id.idRes);
        edtEmail = findViewById(R.id.idEmail);
        edtName = findViewById(R.id.idName);
        edtPass = findViewById(R.id.idPass);
        edtRePass = findViewById(R.id.idRePass);

        mAuth = FirebaseAuth.getInstance();

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (validData()){
                   String name = edtName.getText().toString();
                   String email = edtEmail.getText().toString();
                   String pass = edtPass.getText().toString();
                   String rePass = edtRePass.getText().toString();
                   mAuth.createUserWithEmailAndPassword(email,pass).
                   addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){
                               String uid = mAuth.getCurrentUser().getUid();
                               User user = new User(name,email,pass);
                               FirebaseFirestore db = FirebaseFirestore.getInstance();
                               db.collection("User").document(uid).set(user);

                               Toast.makeText(getApplication(),"Dang Ky Thanh Cong",Toast.LENGTH_LONG).show();
                               Intent i = new Intent(MainActivity3.this,MainActivity.class);
                               startActivity(i);
                               Log.d(TAG,"thanh cong") ;

                           }else {
                               Toast.makeText(getApplication(),"That Bai",Toast.LENGTH_LONG).show();
                               Log.d(TAG, "onComplete: " + task.getException().getLocalizedMessage());
                           }
                       }
                   });
               }
            }
        });

    }

    private boolean validData() {
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        String rePass = edtRePass.getText().toString();

        if (name.isEmpty()||name.length()<=0){
            Toast.makeText(getApplication(),"Ten Khong Duoc Trong",Toast.LENGTH_LONG).show();
            return false;
        }
        if (email.isEmpty()||email.length()<=0){
            Toast.makeText(getApplication(),"Email Khong Duoc Trong",Toast.LENGTH_LONG).show();
            return false;
        }
        if (pass.isEmpty()||pass.length()<=0){
            Toast.makeText(getApplication(),"Mat Khau Khong Duoc Trong",Toast.LENGTH_LONG).show();
            return false;
        }
        if (rePass.isEmpty()||rePass.length()<=0){
            Toast.makeText(getApplication(),"Mat Khau Nhap Lai Khong Duoc Trong",Toast.LENGTH_LONG).show();
            return false;
        }
        if (rePass.isEmpty()||rePass.length()<=0){
            Toast.makeText(getApplication(),"Mat Khau Nhap Lai Khong Duoc Trong",Toast.LENGTH_LONG).show();
            return false;
        }
        if (!pass.equals(rePass)){
            Toast.makeText(getApplication(),"Mat Khau Khong Khop",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}