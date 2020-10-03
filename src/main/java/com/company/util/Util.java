package com.company.util;

import com.company.entity.Address;
import com.company.service.ContactService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    private ContactService contactService = new ContactService();

    public void initApp() {

        Address testAddress1 = new Address("TestHouseNumber1", "TestStreet1", "TestCity1", "TestState1", 11111);
        Address testAddress2 = new Address("TestHouseNumber2", "TestStreet2", "TestCity2", "TestState2", 22222);
        Address testAddress3 = new Address("TestHouseNumber3", "TestStreet3", "TestCity3", "TestState3", 33333);

        contactService.createContact("TestName1", "TestLastName1", 1234567890L, testAddress1);
        contactService.createContact("TestName2", "TestLastName2", 2345678901L, testAddress2);
        contactService.createContact("TestName3", "TestLastName3", 3456789012L, testAddress3);
    }

    public static String inputText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }
}
