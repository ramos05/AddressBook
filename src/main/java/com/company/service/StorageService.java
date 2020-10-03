package com.company.service;

import com.company.entity.Contact;
import com.company.util.Storage;

public class StorageService {

    public void saveContact(Contact contact) {
        int emptySlotIndex = getFirstEmptySlotIndex();

        Storage.contacts[emptySlotIndex] = contact;
    }

    public Contact[] getAllContact() {
        return Storage.contacts;
    }

    public Contact getByFirstName(String firstName) {
        Contact contact = Storage.contacts[getContactIndexByFirstName(firstName)];

        return contact;
    }

    public void updateContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.getFirstName());

        Storage.contacts[index] = contact;
    }


    public void deleteContact(Contact contact) {
        int index = getContactIndexByFirstName(contact.getFirstName());

        Storage.contacts[index] = null;
    }

    private int getFirstEmptySlotIndex() {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i] == null) {
                index = i;
                break;
            }
        }

        return index;
    }

    private int getContactIndexByFirstName(String firstName) {
        int index = 0;

        for (int i = 0; i < Storage.contacts.length; i++) {
            if (Storage.contacts[i].getFirstName().equals(firstName)) {
                index = i;
                break;
            }
        }

        return index;
    }

}
