package com.contact.exception;


public class ContactDAOException extends Exception {

    public ContactDAOException() {
    }

    public ContactDAOException(String message) {
        super(message);
    }

    public ContactDAOException(Throwable cause) {
        super(cause);
    }

    public ContactDAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
