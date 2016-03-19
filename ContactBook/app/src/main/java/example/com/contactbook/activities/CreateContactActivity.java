package example.com.contactbook.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import example.com.contactbook.R;
import example.com.contactbook.database.DatabaseConnector;
import example.com.contactbook.models.Contact;

public class CreateContactActivity extends AppCompatActivity {

    EditText etName, etSurname, etPhone, etEmail, etCity, etAddress;

    Button buttonSave;

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

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CreateContact().execute();
                finish();
            }
        });
    }


    private class CreateContact
            extends AsyncTask<Void, Void, Void> {

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
            connector.open();
            Contact contact = new Contact();
            contact.setName(name);
            contact.setSurname(surname);
            contact.setPhone(phone);
            contact.setEmail(email);
            contact.setCity(city);
            contact.setAddress(address);
            connector.createContact(contact);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            connector.close();
        }
    }
}
