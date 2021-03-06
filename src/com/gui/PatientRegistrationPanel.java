/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Prabhashi
 */
public class PatientRegistrationPanel extends javax.swing.JPanel {

    private final NumberFormat format = NumberFormat.getInstance(Locale.US);
    final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private String query;
    private PreparedStatement statement;
    private ResultSet result;

    private String roomType;
    private String roomNo;
    private double roomPrice;
    private boolean isAvailable;
    private int roomId;

//    protected int id;
//    protected String name;
//    protected int age;
    public void patientReg() {
        if (jFormattedTextFieldRegDate.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the registration date!");
//        TODO check if the reg date entered make sense
        } else if (jTextFieldName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the name!");
        } else if (jFormattedTextFieldAge.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the age!");
        } else if (jListRooms.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a room!");
        } else {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
                roomNo = jListRooms.getSelectedValue().toString();
                query = "Select * from room where room_no=?";
                statement = connection.prepareStatement(query);
                statement.setString(1, roomNo);
                result = statement.executeQuery();
                
                if(result.next()){
                    roomId = result.getInt("id");
                }

                query = "Insert into Patient(register_date, name, gender, age, phone_no, address, disease, comments, room_id) values (?,?,?,?,?,?,?,?,?)";
                statement = connection.prepareStatement(query);

//                Date date = new SimpleDateFormat("yyyy/MM/dd").parse(jFormattedTextFieldRegDate.getText());
                Date date = dateFormat.parse(jFormattedTextFieldRegDate.getText());

                java.sql.Date regDate = new java.sql.Date(date.getTime());
                statement.setDate(1, regDate);

                statement.setString(2, jTextFieldName.getText());

                String gender = jComboBoxGender.getSelectedItem().toString();
                statement.setString(3, gender);

                statement.setString(4, jFormattedTextFieldAge.getText());
                statement.setString(5, jFormattedTextFieldPhoneNo.getText());
                statement.setString(6, jTextAreaAddress.getText());
                statement.setString(7, jTextFieldDisease.getText());
                statement.setString(8, jTextAreaComments.getText());
                statement.setInt(9, roomId);

                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registration was successful!");

                query = "Update room set is_available=0 where room_no=?";
                statement = connection.prepareStatement(query);
                statement.setString(1, roomNo);
                
                statement.executeUpdate();
                
                resetFormReg();
                MainInterface.setDefaultLayout();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Creates new form Patient
     */
    public PatientRegistrationPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextFieldPatientID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldRegDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldAge = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldPhoneNo = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldDisease = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComments = new javax.swing.JTextArea();
        jButtonSave = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldPrice = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListRooms = new javax.swing.JList();
        jComboBoxRoomType = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel2.setText("Patient ID :");

        jTextFieldPatientID.setEnabled(false);

        jLabel3.setText("Register Date :");

        jFormattedTextFieldRegDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFormattedTextFieldRegDate.setText(dateFormat.format(new java.sql.Date(System.currentTimeMillis())));

        jLabel4.setText("Name :");

        jLabel5.setText("Gender :");

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "Other" }));

        jLabel7.setText("Age :");

        jFormattedTextFieldAge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel8.setText("Phone no. :");

        jFormattedTextFieldPhoneNo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel9.setText("Address :");

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setLineWrap(true);
        jTextAreaAddress.setRows(5);
        jTextAreaAddress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jLabel12.setText("Disease :");

        jLabel11.setText("Comments :");

        jTextAreaComments.setColumns(20);
        jTextAreaComments.setLineWrap(true);
        jTextAreaComments.setRows(5);
        jTextAreaComments.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaComments);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel6.setText("Price (per day) Rs :");

        jFormattedTextFieldPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldPrice.setEnabled(false);

        jLabel1.setText("Room Type :");

        jListRooms.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRooms.setToolTipText("");
        jListRooms.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListRoomsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListRooms);

        jComboBoxRoomType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Medium", "VIP" }));
        jComboBoxRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoomTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(jFormattedTextFieldPrice))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(jComboBoxRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPatientID)
                            .addComponent(jTextFieldName)
                            .addComponent(jComboBoxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDisease)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jFormattedTextFieldAge)
                            .addComponent(jFormattedTextFieldPhoneNo)
                            .addComponent(jFormattedTextFieldRegDate))))
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jFormattedTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jFormattedTextFieldPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonCancel))
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        patientReg();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        resetFormReg();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        resetFormReg();
        MainInterface.setDefaultLayout();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jComboBoxRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoomTypeActionPerformed
        roomType = jComboBoxRoomType.getSelectedItem().toString();
        addModelToJList(roomType);
    }//GEN-LAST:event_jComboBoxRoomTypeActionPerformed

    private void jListRoomsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListRoomsValueChanged
        if (!evt.getValueIsAdjusting()) { // To perform actions when value adjusting is over

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
                if (jListRooms.getSelectedIndex() != -1) {
                    roomNo = jListRooms.getSelectedValue().toString();
                    query = "Select * from room where room_no=?";
                    statement = connection.prepareStatement(query);
                    statement.setString(1, roomNo);
                    result = statement.executeQuery();

                    if (result.next()) {
                        roomPrice = result.getDouble("price");
                        isAvailable = result.getBoolean("is_available");
                    }
                    jFormattedTextFieldPrice.setText(format.format(roomPrice));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }//GEN-LAST:event_jListRoomsValueChanged

    public void addModelToJList(String item) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
            query = "Select * from room where room_type=? and is_available=1";
            statement = connection.prepareStatement(query);
            statement.setString(1, item);
            result = statement.executeQuery();

            String roomNum;
            DefaultListModel model = new DefaultListModel();

            while (result.next()) {
                roomNum = result.getString("room_no");
                model.addElement(roomNum);
            }

            jListRooms.setModel(model);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void resetFormReg() {
        jFormattedTextFieldRegDate.setText(dateFormat.format(new java.sql.Date(System.currentTimeMillis())));
        jTextFieldName.setText("");
        jComboBoxGender.setSelectedIndex(0);

        jFormattedTextFieldAge.setText("");
        jFormattedTextFieldAge.setValue(null);

        jFormattedTextFieldPhoneNo.setText("");
        jFormattedTextFieldPhoneNo.setValue(null);

        jTextAreaAddress.setText("");
        jTextFieldDisease.setText("");
        jTextAreaComments.setText("");

        jComboBoxRoomType.setSelectedIndex(0);
        roomType = jComboBoxRoomType.getSelectedItem().toString();
        addModelToJList(roomType);
        jFormattedTextFieldPrice.setText("");
    }

    public void setJTextFieldPatientIDText(String id) {
        jTextFieldPatientID.setText(id);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxGender;
    private javax.swing.JComboBox jComboBoxRoomType;
    private javax.swing.JFormattedTextField jFormattedTextFieldAge;
    private javax.swing.JFormattedTextField jFormattedTextFieldPhoneNo;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrice;
    private javax.swing.JFormattedTextField jFormattedTextFieldRegDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListRooms;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextArea jTextAreaComments;
    private javax.swing.JTextField jTextFieldDisease;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPatientID;
    // End of variables declaration//GEN-END:variables
}
