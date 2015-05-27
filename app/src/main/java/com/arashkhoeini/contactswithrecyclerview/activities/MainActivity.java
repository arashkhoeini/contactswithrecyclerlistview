package com.arashkhoeini.contactswithrecyclerview.activities;

import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.arashkhoeini.contactswithrecyclerview.R;
import com.arashkhoeini.contactswithrecyclerview.adapters.ContactsListAdapter;
import com.arashkhoeini.contactswithrecyclerview.models.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {

    RecyclerView vContactsList;
    RecyclerView.LayoutManager vLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vContactsList = (RecyclerView) findViewById(R.id.contacts_list);
        vLayoutManager = new LinearLayoutManager(getApplicationContext());

        vContactsList.setHasFixedSize(false);
        vContactsList.setLayoutManager(vLayoutManager);
        List<Contact> contacts = getUserContacts();
        if(contacts != null){
            vContactsList.setAdapter(new ContactsListAdapter(contacts));
        }

    }

    private List<Contact> getUserContacts() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            int contactIdIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID);
            int nameIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int phoneNumberIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int photoIdIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_ID);
            cursor.moveToFirst();
            List<Contact> contacts = new ArrayList<>();
            Contact c;
            do {
                String idContact = cursor.getString(contactIdIdx);
                String name = cursor.getString(nameIdx);
                String phoneNumber = cursor.getString(phoneNumberIdx);
                c= new Contact(name,phoneNumber);
                contacts.add(c);
            } while (cursor.moveToNext());
            Collections.sort(contacts);
            return contacts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

}
