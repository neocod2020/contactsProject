package com.contact.dao;

import com.contact.entity.Contact;
import com.contact.exception.ContactDAOException;

import java.util.List;

/*
* interface to realization functions of contacts storage
* */

public interface ContactDAO {
    public Long addContact(Contact c) throws ContactDAOException;

    public void updateContact(Contact c) throws ContactDAOException;

    public void deleteContact(Long contactId) throws ContactDAOException;

    public Contact getContact(Long contId) throws ContactDAOException;

    public List<Contact> findContacts() throws ContactDAOException;
}
