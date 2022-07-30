package com.contact.dao;

import com.contact.exception.ContactDAOException;

public class ContactDAOFactory {
    public static ContactDAO getContactDAO()  {        
        return ContactDbDAO.newInstance();
    }
}
