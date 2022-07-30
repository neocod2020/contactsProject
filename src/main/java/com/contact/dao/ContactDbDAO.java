package com.contact.dao;

import com.contact.entity.Contact;
import com.contact.exception.ContactDAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ContactDbDAO implements ContactDAO {

    private static final String SELECT = "SELECT contact_id, first_name, last_name, phone, email FROM jc_contact "
            + "ORDER BY first_name, last_name";
    private static final String SELECT_ONE = "SELECT contact_id, first_name, last_name, phone, email FROM jc_contact "
            + "WHERE contact_id=?";
    private static final String INSERT = "INSERT INTO jc_contact (first_name, last_name, phone, email) "
            + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE jc_contact SET first_name=?, last_name=?, phone=?, email=? "
            + "WHERE contact_id=?";
    private static final String DELETE = "DELETE FROM jc_contact WHERE contact_id=?";
    
    private ConnectionBuilder builder = new ConnectionBuilderImpl();
    
    private static  ContactDbDAO newInstance = null;

    public ContactDbDAO() {
        
    }
    
    private Connection getConnection() throws SQLException {
    return builder.getConnection();
    }
    public static  ContactDbDAO newInstance() {
        if(newInstance == null) newInstance = new ContactDbDAO();
            return newInstance;
    }
    
    @Override
    public Long addContact(Contact c) throws ContactDAOException {
        try (Connection conn = getConnection();                
            PreparedStatement pst = conn.prepareStatement(INSERT, new String[]{"contact_id", "first_name"})) {            
            Long contactId = -1L;            
            pst.setString(1, c.getFirstName());
            pst.setString(2, c.getLastName());
            pst.setString(3, c.getPhone());
            pst.setString(4, c.getEmail());           
            pst.executeUpdate();
            // введено, т.к. sqlite jdbc не поддерживает getGeneratedKeys().getLong()
            if(!conn.getClass().toString().contains("sqlite")) {
            ResultSet gk = pst.getGeneratedKeys();            
            if(gk.next()){                
                contactId = gk.getLong("contact_id");                
            }
            gk.close();
            }
            else {
            List<Contact> list = findContacts();
            contactId = Long.valueOf(list.size()) + 1;
            }
            System.out.println("contactId = " + contactId);
            return contactId;
        } catch (Exception ex) {
            throw new ContactDAOException(ex);
        }
    }

    @Override
    public void updateContact(Contact c) throws ContactDAOException {
        try (Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(UPDATE)){            
            pst.setString(1, c.getFirstName());
            pst.setString(2, c.getLastName());
            pst.setString(3, c.getPhone());
            pst.setString(4, c.getEmail());
            pst.setLong(5, c.getContactId());
            pst.executeUpdate();            
        } catch (SQLException ex) {
            throw new ContactDAOException(ex);
        }
        }

    @Override
    public void deleteContact(Long contactId) throws ContactDAOException {
        try (Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(DELETE)){            
            pst.setLong(1, contactId);
            pst.executeUpdate();            
        } catch (SQLException ex) {
            throw new ContactDAOException(ex);
        }
        }

    @Override
    public Contact getContact(Long contId) throws ContactDAOException {
        Contact contact = null;
        try (Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(SELECT_ONE)){
            pst.setLong(1, contId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                contact = fillContact(rs);
            }
            rs.close();
            return contact;
        } catch (SQLException ex) {
            throw new ContactDAOException(ex);
        }
        }

    @Override
    public List<Contact> findContacts() throws ContactDAOException {
        List<Contact> list = new LinkedList<>();
        try (Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(SELECT)){            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(fillContact(rs));
            }
            rs.close();
            return list;
        } catch (SQLException ex) {
            throw new ContactDAOException(ex);
        }
       }

    private Contact fillContact(ResultSet rs) throws SQLException {
        Contact contact = new Contact();
        contact.setContactId(rs.getLong("contact_id"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        contact.setPhone(rs.getString("phone"));
        contact.setEmail(rs.getString("email"));
        return contact;
    }
    
}
