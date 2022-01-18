package com.ghassan;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber, ArrayList<Contact> myContact) {
        this.myNumber = myNumber;
        this.myContact = myContact;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("This contact is already exists");
            return false;
        } else {
            myContact.add(contact);
            System.out.println("The new contact is added successfully");
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }
        this.myContact.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.myContact.remove(contact);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    public void printContacts() {
        for (int i = 0; i < this.myContact.size(); i++) {
            System.out.println((i + 1) + "." + this.myContact.get(i).getName() + " -> " + this.myContact.get(i).getPhoneNumber());
        }
    }

    private int findContact(Contact contact) {
        return this.myContact.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContact.size(); i++) {
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
}
