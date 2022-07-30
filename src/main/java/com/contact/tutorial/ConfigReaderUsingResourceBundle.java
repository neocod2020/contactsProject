/*

*/

package com.contact.tutorial;

import java.util.Enumeration;
import java.util.ResourceBundle;


public class ConfigReaderUsingResourceBundle {
    public static void main(String[] args) {
        ResourceBundle resBundle = 
             //   ResourceBundle.getBundle("C:\\NBProjects\\contacts\\src\\main\\java\\contact\\tutorial\\tutorial.properties");
    //    ResourceBundle.getBundle("C:/NBProjects/contacts/src/main/java/contact/tutorial/tutorial");
        ResourceBundle.getBundle("contact/gui/ContactResources");
        
        Enumeration<String> keys = resBundle.getKeys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            String value = resBundle.getString(key);
            System.out.println(key + ": " + value);
        }
    }
}
