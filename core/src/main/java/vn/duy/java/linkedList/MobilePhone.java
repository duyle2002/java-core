package vn.duy.java.linkedList;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> myContacts = new ArrayList<>();
    private String myNumber;

    public MobilePhone(String number) {
        myNumber = number;
    }

    public boolean addNewContact(Contact contact) {
        for (Contact c : myContacts) {
            if (c.getName().equalsIgnoreCase(contact.getName()) && c.getPhoneNumber().equalsIgnoreCase(contact.getPhoneNumber())) {
                return false;
            }
        }
        this.myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (this.myContacts.contains(oldContact)) {
            this.myContacts.remove(oldContact);
            this.myContacts.add(newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        if (this.myContacts.contains(contact)) {
            this.myContacts.remove(contact);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String number) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (this.myContacts.get(i).getPhoneNumber().trim().equalsIgnoreCase(number.trim())) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        for (Contact contact : this.myContacts) {
            if (contact.getName().trim().equalsIgnoreCase(contactName.trim())) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            System.out.println(String.format("%d. %s -> %s", i, contact, contact.getPhoneNumber()));
        }
    }
}
