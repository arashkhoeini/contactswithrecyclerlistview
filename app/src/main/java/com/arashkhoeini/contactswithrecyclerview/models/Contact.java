package com.arashkhoeini.contactswithrecyclerview.models;

/**
 * Created by arashkhoeini on 5/25/2015 AD.
 */
public class Contact implements Comparable<Contact> {
    String name;
    String number;

    public Contact(){

    }
    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        number =number;
    }



    @Override
    public int compareTo(Contact another) {
        return this.name.compareTo(another.name);
    }
}
