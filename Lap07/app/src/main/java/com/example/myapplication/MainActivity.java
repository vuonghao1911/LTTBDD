package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    AdapterList adapterList ;
    List<Contact> contacts;
    EditText editText;
    Button btnAdd;
    Button btnRemove;
    DatabaseHandler db;
    Contact contactItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

             db = new DatabaseHandler(this);



        editText = (EditText) findViewById(R.id.ideditext);
        btnAdd = (Button) findViewById(R.id.idbtnAdd);
        btnRemove = (Button) findViewById(R.id.idbtnRemove);

        // Reading all contacts

         contacts = db.getAllContacts();



        listView = findViewById(R.id.idListCon);
        adapterList = new AdapterList(this,contacts,R.layout.list_adapter);
        listView.setAdapter(adapterList);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact(editText.getText().toString());
                db.addContact(contact);
               renderList();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contactItem = contacts.get(i);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteContact(contactItem);
                renderList();

                Toast.makeText(getApplication(),"Ban Da Xoa "+contactItem.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }
    private  void renderList(){
        contacts.clear();
        contacts= db.getAllContacts();
        adapterList.setContacts(contacts);
        adapterList.notifyDataSetChanged();
    }


}
