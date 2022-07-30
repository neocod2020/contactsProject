package com.contact.gui;

import com.contact.entity.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditContactDialog extends JDialog implements ActionListener {
    
    private static final String DIALOG = "dialog";
    private static final String C_GIVEN = "givenname";
    private static final String C_SURNAME = "surname";
    private static final String C_PHONE = "phone";
    private static final String C_EMAIL = "email";
    // buttons headers
    private static final String SAVE = "SAVE";
    private static final String CANCEL = "CANCEL";
    // отступ
    private static final int PAD = 10;
    // ширина метки
    private static final int W_L = 100;
    // ширина поля для ввода
    private static final int W_T = 300;
    // ширина кнопки
    private static final int W_B = 120;
    // высота элемента - общая
    private static final int H_B = 25;
    // fields to input data
    private final JTextPane textFirstName = new JTextPane();
    private final JTextPane textLastName = new JTextPane();
    private final JTextPane textPhone = new JTextPane();
    private final JTextPane textEmail = new JTextPane();

    private Long contactId = null;
    private boolean save = false;

    public EditContactDialog() { this(null); }

    public EditContactDialog(Contact contact) {
        // remove layout - will use absolute coordinates
        setLayout(null);
        buildFields();
        initFields(contact);
        buildButtons();
        setModal(true);
        setResizable(true);
        setBounds(300, 300, 450, 200);
        setVisible(true);
    }
    // set labels and fields of input at the form
    private void buildFields() {
        // label for First name
        JLabel lblFirstName = new JLabel(GuiResource.getLabel(DIALOG, C_GIVEN)+":");
        // alignment by right side
        lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        // set coordinates
        lblFirstName.setBounds(PAD, 0 * H_B + PAD, W_L, H_B);
        // put onto form
        add(lblFirstName);
        // set coordinates of the form
        textFirstName.setBounds(new Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B));
        // make border for the form
        textFirstName.setBorder(BorderFactory.createEtchedBorder());
        add(textFirstName);

        // label for last name
        JLabel lblLastName = new JLabel(GuiResource.getLabel(DIALOG, C_SURNAME)+":");
        // alignment by right side
        lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        // set coordinates
        lblLastName.setBounds(PAD, 1 * H_B + PAD, W_L, H_B);
        // put onto form
        add(lblLastName);
        // set coordinates of the form
        textLastName.setBounds(new Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B));
        // make border for the form
        textLastName.setBorder(BorderFactory.createEtchedBorder());
        add(textLastName);

        // label for phone number
        JLabel lblPhone = new JLabel(GuiResource.getLabel(DIALOG, C_PHONE)+":");
        // alignment by right side
        lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
        // set coordinates
        lblPhone.setBounds(PAD, 2 * H_B + PAD, W_L, H_B);
        // put onto form
        add(lblPhone);
        // set coordinates of the form
        textPhone.setBounds(new Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B));
        // make border for the form
        textPhone.setBorder(BorderFactory.createEtchedBorder());
        
        add(textPhone);

        // label for email
        JLabel lblEmail = new JLabel(GuiResource.getLabel(DIALOG, C_EMAIL)+":");
        // alignment by right side
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        // set coordinates
        lblEmail.setBounds(PAD, 3 * H_B + PAD, W_L, H_B);
        // put onto form
        add(lblEmail);
        // set coordinates of the form
        textEmail.setBounds(new Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B));
        // make border for the form
        textEmail.setBorder(BorderFactory.createEtchedBorder());
        add(textEmail);
    }
    // fill fields by contact
    private void initFields(Contact c) {
        if (c != null) {
            contactId = c.getContactId();
            textFirstName.setText(c.getFirstName());
            textLastName.setText(c.getLastName());
            textPhone.setText(c.getPhone());
            textEmail.setText(c.getEmail());
        }
    }
    // put buttons onto the form
    private void buildButtons() {
        JButton btnSave = new JButton("SAVE");
        btnSave.setActionCommand(SAVE);
        btnSave.addActionListener(this);
        btnSave.setBounds(new Rectangle(PAD, 5 * H_B + PAD, W_B, H_B));
        add(btnSave);
        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        btnCancel.setBounds(new Rectangle(W_B + 2 * PAD, 5 * H_B + PAD, W_B, H_B));
        add(btnCancel);
    }
    // read button push
    public void actionPerformed(ActionEvent ae){
        String action = ae.getActionCommand();
        // if SAVE pushed
        save = action.equals(SAVE);
        // close the form
        setVisible(false);
    }
    public Contact getContact() {
        Contact c = new Contact(contactId, textFirstName.getText(), textLastName.getText(), textPhone.getText(),
                textEmail.getText());
        return c;
    }

    public boolean isSave() { return save; }
}
