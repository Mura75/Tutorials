package example.com.contactbook.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import example.com.contactbook.models.Contact;

/**
 * Created by Murager on 19.03.2016.
 */
public class DatabaseConnector {

    private static final String CONTACT_DATABASE = "ContactDatabase";
    private static final String CONTACT_TABLE= "Contacts";
    private static int DATABASE_VERSION = 1;

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String ADDRESS = "address";

    private static final String CREATE_DATABASE =
            "CREATE TABLE if not exists " + CONTACT_TABLE +
            "(" + ID + " integer primary key autoincrement," +
            NAME + " TEXT," +
            SURNAME + " TEXT, " +
            PHONE + " TEXT, " +
            EMAIL + " TEXT, " +
            CITY + " TEXT, " +
            ADDRESS + " TEXT);";

    private SQLiteDatabase database;

    private DatabaseHelper helper;

    public DatabaseConnector(Context context) {

        helper = new DatabaseHelper(context,
                CONTACT_DATABASE,
                null,
                DATABASE_VERSION);
    }

    public void createContact(Contact contact) {
        ContentValues newValue = new ContentValues();

        newValue.put(NAME, contact.getName());
        newValue.put(SURNAME, contact.getSurname());
        newValue.put(PHONE, contact.getPhone());
        newValue.put(EMAIL, contact.getEmail());
        newValue.put(CITY, contact.getCity());
        newValue.put(ADDRESS, contact.getAddress());

        open();
        database.insert(CONTACT_TABLE, null, newValue);
        close();
    }

    public void updateContact(Contact contact) {
        ContentValues updateValue = new ContentValues();

        updateValue.put(NAME, contact.getName());
        updateValue.put(SURNAME, contact.getEmail());
        updateValue.put(PHONE, contact.getPhone());
        updateValue.put(EMAIL, contact.getEmail());
        updateValue.put(CITY, contact.getCity());
        updateValue.put(ADDRESS, contact.getAddress());

        open();
        database.update(CONTACT_TABLE,
                updateValue,
                ID + "=" + contact.getId(),
                null);
        close();
    }

    public void deleteContact(Contact contact) {
        open();
        database.delete(CONTACT_TABLE,
                ID + "=?",
                new String[]{String.valueOf(contact.getId())});
        close();
    }


    public Contact getContactById(int id) {
        open();
        Contact contact = null;
        String[] columns = new String[]{ID, NAME, SURNAME,
                                        PHONE, EMAIL, CITY, ADDRESS};

        Cursor cursor = database.query(CONTACT_TABLE,
                columns,
                ID + "=?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        contact = new Contact();
        contact.setId(cursor.getInt(0));
        contact.setName(cursor.getString(1));
        contact.setSurname(cursor.getString(2));
        contact.setPhone(cursor.getString(3));
        contact.setEmail(cursor.getString(4));
        contact.setCity(cursor.getString(5));
        contact.setAddress(cursor.getString(6));

        return contact;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + CONTACT_TABLE;
        Cursor cursor = database.rawQuery(selectQuery, null);
        open();
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setSurname(cursor.getString(2));
            contact.setPhone(cursor.getString(3));
            contact.setEmail(cursor.getString(4));
            contact.setCity(cursor.getString(5));
            contact.setAddress(cursor.getString(6));
            contactList.add(contact);
        }

        return contactList;
    }

    public void open() {
        database = helper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            database.close();
        }
    }

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context,
                              String name,
                              SQLiteDatabase.CursorFactory factory,
                              int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DATABASE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,
                              int oldVersion,
                              int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + CONTACT_TABLE);
            onCreate(db);
        }
    }
}
