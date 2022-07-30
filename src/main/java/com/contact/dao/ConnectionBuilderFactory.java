package com.contact.dao;


public class ConnectionBuilderFactory {
    public static ConnectionBuilder getConnectionBuilder(){
        return new ConnectionBuilderImpl();
    }
}
