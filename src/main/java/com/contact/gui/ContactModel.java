package com.contact.gui;

import com.contact.entity.Contact;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class ContactModel extends AbstractTableModel {

    private static final String[] HEADERS = {"id", "givenname", "surname", "phone", "email"};
    private static final String MODEL = "model";
    private final List<Contact> contacts;
    private DefaultTableCellRenderer renderer; 

    public ContactModel(List<Contact> contacts) { 
        this.contacts = contacts; 
//        renderer.setHorizontalAlignment(JLabel.CENTER);
//        this.setDefaultRenderer(renderer);
    }
    @Override
    public int getRowCount() { return contacts.size(); }
    @Override
    public int getColumnCount() { return HEADERS.length; }
    @Override
    public String getColumnName(int col) { return GuiResource.getLabel(MODEL, HEADERS[col]); }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contact c = contacts.get(rowIndex);
        if(columnIndex == 0)  return c.getContactId().toString();
        else if(columnIndex == 1)  return c.getFirstName();
        else if(columnIndex == 2)  return c.getLastName();
        else if(columnIndex == 3)  return c.getPhone();
        else if(columnIndex == 4) return c.getEmail();
        else return "";
    }
}
