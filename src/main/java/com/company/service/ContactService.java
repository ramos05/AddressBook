package com.company.service;

import com.company.entity.Address;
import com.company.entity.Contact;

import java.io.IOException;

import static com.company.util.Util.inputText;

public class ContactService {
    private StorageService storageService = new StorageService();

    public void createContact(String firstName, String lastName, long phoneNumber, Address address) {
        Contact contact = new Contact(firstName, lastName, phoneNumber, address);

        saveContact(contact);
    }

    public void saveContact(Contact contact) {
        storageService.saveContact(contact);
    }

    public Contact getContactByFirstName(String firstName) {

        return storageService.getByFirstName(firstName);
    }

    public Contact[] getAllContacts() {
        return storageService.getAllContact();
    }

    public void updateContact(Contact contact) {

        storageService.updateContact(contact);
    }

    public void deleteContact(Contact contact) {

        storageService.deleteContact(contact);
    }

    public void inputContact() throws IOException {

        System.out.println("Введите имя             ");
        String firstName = inputText();

        System.out.println("Введите фамилию         ");
        String lastName = inputText();

        System.out.println("Введите номер телефона  ");
        long phoneNumber = Long.parseLong(inputText());

        System.out.println("Адрес-------------------");
        System.out.println("Введите номер дома      ");
        String houseNumber = inputText();

        System.out.println("Введите улицу           ");
        String streetName = inputText();

        System.out.println("Введите город           ");
        String cityName = inputText();

        System.out.println("Введите штат            ");
        String stateName = inputText();

        System.out.println("Введите зип-код         ");
        int zipCode = Integer.parseInt(inputText());

        Contact contact = new Contact(firstName, lastName, phoneNumber, new Address(houseNumber, streetName, cityName, stateName, zipCode));

        saveContact(contact);
    }

    public void printContact(Contact contact) {
        System.out.println("=========================================================================================");
        System.out.println("Имя                     " + contact.getFirstName());
        System.out.println("Фамилия                 " + contact.getLastName());
        System.out.println("Номер телефона          " + contact.getPhoneNumber());
        System.out.println("Адрес ===================================================================================");
        System.out.println("Номер дома              " + contact.getAddress().getHouseNumber());
        System.out.println("Улица                   " + contact.getAddress().getStreetName());
        System.out.println("Город                   " + contact.getAddress().getCityName());
        System.out.println("Штат                    " + contact.getAddress().getStateName());
        System.out.println("Зип-код                 " + contact.getAddress().getZipCode());
        System.out.println("=========================================================================================");
    }

    public void printContacts(Contact[] contacts) {
        for (Contact contact : contacts) {
            if (contact != null) {
                printContact(contact);
            }
        }
    }
}
