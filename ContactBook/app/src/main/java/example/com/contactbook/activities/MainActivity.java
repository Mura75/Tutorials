package example.com.contactbook.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = (ListView)findViewById(R.id.lvContact);

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
