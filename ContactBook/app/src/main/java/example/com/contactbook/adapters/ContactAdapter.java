package example.com.contactbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import example.com.contactbook.R;
import example.com.contactbook.models.Contact;

/**
 * Created by Murager on 19.03.2016.
 */
public class ContactAdapter extends BaseAdapter {

    Context context;

    List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        View rowView = LayoutInflater
                .from(context)
                .inflate(R.layout.contact_item_row,
                        parent,
                        false);


        TextView tvName =
                (TextView)rowView.findViewById(R.id.tvName);

        TextView tvPhone =
                (TextView)rowView.findViewById(R.id.tvPhone);

        Contact contact = contactList.get(position);

        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());

        return rowView;
    }
}
