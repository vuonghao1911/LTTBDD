package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView ;
    AdapterListCon adapterList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_con);

        DatabaseHandler db = new DatabaseHandler(this);

//        // Inserting Contacts
//      Log.d("Insert: ", "Inserting ..");
//      db.addContact(new Contact("Ravi", "9100000000"));
//       db.addContact(new Contact("Srinivas", "9199999999"));
//       db.addContact(new Contact("Tommy", "9522222222"));
//       db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        listView = findViewById(R.id.idListCon);
        adapterList = new AdapterListCon(this,contacts,R.layout.custom_list_con);
        listView.setAdapter(adapterList);
    }
}
