package com.contact.business;

import com.contact.dao.ContactDAO;
import com.contact.dao.ContactDAOFactory;
import com.contact.entity.Contact;
import com.contact.exception.ContactBusinessException;
import com.contact.exception.ContactDAOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
*  realizing functions over contacts
* */

public class ContactManager {
    private final ContactDAO dao;

    public ContactManager() {
        dao = ContactDAOFactory.getContactDAO();
    }
    // addContact return ID of a new contact
    public Long addContact(Contact c) throws ContactBusinessException { 
        try { 
            return dao.addContact(c);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }        
    }
    // updateContact
    public void updateContact(Contact c) throws ContactBusinessException { 
        try {
        dao.updateContact(c);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
}
    // remove contact by ID
    public void deleteContact(Long contactId) throws ContactBusinessException { 
        try {
        dao.deleteContact(contactId);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
}
    // get one contact by ID
    public Contact getContact(Long contactId) throws ContactBusinessException { 
        try {
        return dao.getContact(contactId);
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
}
    // get list of contacts
    public List<Contact> findContacts() throws ContactBusinessException { 
        try {
        return dao.findContacts();
        } catch (ContactDAOException ex) {
            throw new ContactBusinessException(ex);
        }
}

}
