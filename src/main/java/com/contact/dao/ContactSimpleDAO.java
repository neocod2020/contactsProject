package com.contact.dao;

import com.contact.entity.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactSimpleDAO implements ContactDAO {

    private final List<Contact> contacts = new ArrayList<Contact>();

    public ContactSimpleDAO() {
        addContact(new Contact("Andrey", "Sokolov", "+7-921-890-7766", "ASok@gmail.com"));
        addContact(new Contact("Sergey", "Ivanov", "+7-911-880-5522", "SIvk@mail.ru"));
        addContact(new Contact("Tatiana", "Semenova", "+7-962-330-6644", "tatk@gmail.com"));
    }

    public Long addContact(Contact c) {
        Long id = generateContactId();
        c.setContactId(id);
        contacts.add(c);
        return id;
    }

    public void updateContact(Contact c) {
        Contact oldContact = getContact(c.getContactId());
        if (oldContact != null) {
            oldContact.setFirstName(c.getFirstName());
            oldContact.setLastName(c.getLastName());
            oldContact.setPhone(c.getPhone());
            oldContact.setEmail(c.getEmail());
        }
    }

    public void deleteContact(Long contactId) {
        for (Iterator<Contact> iterator = contacts.iterator(); iterator.hasNext();) {
            Contact cont = iterator.next();
            if (cont.getContactId().equals(contactId)) iterator.remove();
        }
    }

    public Contact getContact(Long contId) {
        for (Contact c : contacts)
            if (c.getContactId().equals(contId)) return c;
        return null;
    }

    public List<Contact> findContacts() { return contacts; }

    private Long generateContactId(){
        Long contactId = Math.round(Math.random()*1000 + System.currentTimeMillis());
        while (getContact(contactId) != null)
            contactId = Math.round(Math.random()*1000 + System.currentTimeMillis());
            return contactId;
    }
}
