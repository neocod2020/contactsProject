package com.contact.gui;

import com.contact.config.GlobalConfig;
import java.util.Locale;
import java.util.PropertyResourceBundle;


public class GuiResource {
 //  private static final String RESOURCES = "C:\\NBProjects\\contacts\\src\\main\\java\\contact\\gui\\ContactResources.properties";
    private static final String RESOURCES = "contact/gui/ContactResources";
    
    private static final String LANGUAGE = "language";
    
    private static PropertyResourceBundle components = null;
    
    public static void initComponentResources(){
//        String lang = GlobalConfig.getProperty(LANGUAGE);
//        if(lang != null) components = 
//                (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES, new Locale(lang));
//        else
        components = (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES);
    }
    public static String getLabel(String formId, String componentId){
        initComponentResources();
        return components.getString(formId + "." + componentId);
    }

    public static String getRESOURCES() {
        return RESOURCES;
    }
    
    
}
