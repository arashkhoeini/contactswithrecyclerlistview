package com.arashkhoeini.contactswithrecyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arashkhoeini.contactswithrecyclerview.R;
import com.arashkhoeini.contactswithrecyclerview.models.Contact;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by arashkhoeini on 5/27/2015 AD.
 */
public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ViewHolder> {

    List<Contact> contacts ;

    public ContactsListAdapter(List<Contact> contacts){
        this.contacts = contacts;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView vName;
        TextView vNumber;

        public ViewHolder(View v,TextView vName, TextView vNumber){
            super(v);
            this.vName = vName;
            this.vNumber = vNumber;

        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item,parent,false);
        TextView vName = (TextView) v.findViewById(R.id.contacts_list_name);
        TextView vNumber = (TextView) v.findViewById(R.id.contacts_list_number);


        return new ViewHolder(v,vName,vNumber);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.vName.setText(contacts.get(position).getName());
        holder.vNumber.setText(contacts.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


}
