package example.com.contactbook.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import example.com.contactbook.R;
import example.com.contactbook.adapters.ContactAdapter;
import example.com.contactbook.database.DatabaseConnector;
import example.com.contactbook.models.Contact;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;

    List<Contact> contactList;

    ContactAdapter contactAdapter;

    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = (ListView)findViewById(R.id.lvContact);

        fabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateContactActivity.class);
                startActivity(intent);
            }
        });


        //ListView Item click
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contactList.get(position);
                Intent intent = new Intent(MainActivity.this, CreateContactActivity.class);
                intent.putExtra("contact_id", contact.getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        new GetAllUsers().execute();
    }

    private class GetAllUsers
            extends AsyncTask<Void, Void, Void> {

        DatabaseConnector connector =
                new DatabaseConnector(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            connector.open();
            contactList = connector.getAllContacts();
            Log.d("All_my_contancts", contactList.toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            contactAdapter = new
                    ContactAdapter(MainActivity.this,
                                   contactList);
            lvContact.setAdapter(contactAdapter);
            connector.close();
        }
    }
}
