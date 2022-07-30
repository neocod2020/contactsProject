package com.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionBuilderImpl implements ConnectionBuilder {
    
    final static String PATH =
            "C:\\NBProjects\\contacts\\src\\main\\resources\\database\\",  
         //   "\\resources\\database\\",
            NAME_DB = "contacts.db", 
            TB_NAME = "jc_contact";    

    public ConnectionBuilderImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            
            System.out.println("ConnectionBuilderImpl: Class.forName(\"org.sqlite.JDBC\") not founded");
            Logger.getLogger(ConnectionBuilderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + PATH + NAME_DB);
    }
    
}
