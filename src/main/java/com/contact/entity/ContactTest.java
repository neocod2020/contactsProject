/*
Example GUI + database using JDBC
from java-course.ru/begin/contact_02/
*/

package com.contact.entity;

import com.contact.gui.ContactFrame;
import java.io.IOException;
import javax.swing.SwingUtilities;


public class ContactTest {
    public static void main(String[] args) throws IOException {
     /*   
        ContactManager cm = new ContactManager();

        Contact c1 = new Contact("Andrey", "Sokolov", "+7-921-890-7766", "ASok@gmail.com");
        Contact c2 = new Contact("Sergey", "Ivanov", "+7-911-880-5522", "SIvk@mail.ru");
        Contact c3 = new Contact("Tatiana", "Semenova", "+7-962-330-6644", "tatk@gmail.com");

        System.out.println("ADD CONTACT ===========================================");
        Long conID_1 = cm.addContact(c1);
        Long conID_2 = cm.addContact(c2);
        Long conID_3 = cm.addContact(c3);
        List<Contact> result = cm.findContacts();
        for (Contact c : result) System.out.println(c);

        System.out.println("UPDATE CONTACT ===========================================");
        Contact c1_change = new Contact("Alexey", "Sokolov", "+7-921-890-7766", "ASok@gmail.com");
        cm.updateContact(c1_change);
        List<Contact> result1 = cm.findContacts();
        for (Contact c : result1) System.out.println(c);

        System.out.println("DELETE CONTACT ===========================================");
        cm.deleteContact(conID_2);
        List<Contact> result2 = cm.findContacts();
        for (Contact c : result2) System.out.println(c);

        System.out.println("GET CONTACT ===========================================");
        Contact c = cm.getContact(conID_3);
        System.out.println(c);
*/
        SwingUtilities.invokeLater(() -> {
            new ContactFrame().setVisible(true);
        });
    }
}
