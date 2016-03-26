package example.com.contactbook.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.contactbook.R;
import example.com.contactbook.database.DatabaseConnector;
import example.com.contactbook.models.Contact;

public class CreateContactActivity extends AppCompatActivity {

    EditText etName, etSurname, etPhone, etEmail, etCity, etAddress;

    Button buttonSave;

    private int contactId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = (EditText)findViewById(R.id.etName);
        etSurname = (EditText)findViewById(R.id.etSurname);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etCity = (EditText)findViewById(R.id.etCity);
        etAddress = (EditText)findViewById(R.id.etAddress);
        buttonSave = (Button)findViewById(R.id.buttonSave);

        Log.d("My_intent", getIntent().getIntExtra("contact_id", 0) + "");

        if (getIntent().hasExtra("contact_id")) {
            contactId = getIntent().getIntExtra("contact_id", -1);
            new ShowContactData().execute();
        }


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CreateOrUpdateContact().execute();
                finish();
            }
        });

    }


    private void showDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(CreateContactActivity.this);
        alert.setMessage("Do You want delete contact")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        new DeleteContact().execute();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_contact_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_delete) {
            showDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class DeleteContact extends AsyncTask<Void, Void, Void> {

        DatabaseConnector connector = new DatabaseConnector(CreateContactActivity.this);

        @Override
        protected Void doInBackground(Void... params) {
            connector.open();
            if (contactId != -1) {
                Contact contact = connector.getContactById(contactId);
                connector.deleteContact(contact);
            }
            connector.close();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (contactId != -1) {
                finish();
            }
            else {
                Toast.makeText(CreateContactActivity.this,
                        "Nothing to delete!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class ShowContactData extends AsyncTask<Void, Void, Void> {
        Contact contact;

        DatabaseConnector connector =
                new DatabaseConnector(CreateContactActivity.this);

        @Override
        protected Void doInBackground(Void... params) {
            connector.open();
            contact = connector.getContactById(contactId);
            Log.d("Contact_info", contact.toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            etName.setText(contact.getName());
            etSurname.setText(contact.getSurname());
            etPhone.setText(contact.getPhone());
            etEmail.setText(contact.getEmail());
            etCity.setText(contact.getCity());
            etAddress.setText(contact.getAddress());
            connector.close();
        }
    }


    private class CreateOrUpdateContact extends AsyncTask<Void, Void, Void> {

        DatabaseConnector connector =
                new DatabaseConnector(CreateContactActivity.this);

        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String city = etCity.getText().toString();
        String address = etAddress.getText().toString();

        @Override
        protected Void doInBackground(Void... params) {
            if (contactId != -1) {
                connector.open();
                Contact contact = connector.getContactById(contactId);
                contact.setName(name);
                contact.setSurname(surname);
                contact.setPhone(phone);
                contact.setEmail(email);
                contact.setCity(city);
                contact.setAddress(address);
                connector.updateContact(contact);
            }
            else {
                connector.open();
                Contact contact = new Contact();
                contact.setName(name);
                contact.setSurname(surname);
                contact.setPhone(phone);
                contact.setEmail(email);
                contact.setCity(city);
                contact.setAddress(address);
                connector.createContact(contact);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            connector.close();
        }
    }

}
