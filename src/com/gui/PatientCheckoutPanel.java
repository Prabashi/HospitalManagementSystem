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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Prabhashi
 */
public class PatientCheckoutPanel extends javax.swing.JPanel {

    final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private String query;
    private PreparedStatement statement;
    private ResultSet result;

    private Date date;
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phoneNo;
    private String address;
    private String disease;
    private String comments;
    private float totalPrice;
    private String status;
    private Date checkoutDate;
//    private int price;

    /**
     * Creates new form PatientCheckoutPanel
     */
    public PatientCheckoutPanel() {
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

        jButtonDiscard = new javax.swing.JButton();
        jComboBoxGenderEdit = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxName = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldNameEdit = new javax.swing.JTextField();
        jFormattedTextFieldRegDateEdit = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jFormattedTextFieldAgeEdit = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jFormattedTextFieldID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaAddressEdit = new javax.swing.JTextArea();
        jFormattedTextFieldPhoneNoEdit = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaCommentsEdit = new javax.swing.JTextArea();
        jButtonSearchPatient = new javax.swing.JButton();
        jTextFieldDiseaseEdit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldCheckoutDate = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldTotalPrice = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaStatus = new javax.swing.JTextArea();
        jButtonPrint = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Checkout", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jButtonDiscard.setText("Discard Changes");
        jButtonDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiscardActionPerformed(evt);
            }
        });

        jComboBoxGenderEdit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Male", "Female", "Other" }));
        jComboBoxGenderEdit.setEnabled(false);

        jLabel16.setText("Phone No :");

        jLabel14.setText("Age :");

        jLabel25.setText("Registered Date :");

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jComboBoxName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNameItemStateChanged(evt);
            }
        });
        jComboBoxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNameActionPerformed(evt);
            }
        });
        jComboBoxName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxNameKeyReleased(evt);
            }
        });

        jLabel20.setText("Disease :");

        jTextFieldNameEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNameEdit.setEnabled(false);

        jFormattedTextFieldRegDateEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFormattedTextFieldRegDateEdit.setEnabled(false);
        jFormattedTextFieldRegDateEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldRegDateEditActionPerformed(evt);
            }
        });

        jLabel13.setText("Name :");

        jFormattedTextFieldAgeEdit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldAgeEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFormattedTextFieldAgeEdit.setEnabled(false);

        jLabel10.setText("Patient Name :");

        jLabel15.setText("Gender :");

        jFormattedTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldIDKeyReleased(evt);
            }
        });

        jTextAreaAddressEdit.setColumns(20);
        jTextAreaAddressEdit.setLineWrap(true);
        jTextAreaAddressEdit.setRows(5);
        jTextAreaAddressEdit.setWrapStyleWord(true);
        jTextAreaAddressEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextAreaAddressEdit.setEnabled(false);
        jScrollPane3.setViewportView(jTextAreaAddressEdit);

        jFormattedTextFieldPhoneNoEdit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldPhoneNoEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jFormattedTextFieldPhoneNoEdit.setEnabled(false);

        jLabel6.setText("Patient ID :");

        jLabel21.setText("Comments :");

        jLabel17.setText("Address :");

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jTextAreaCommentsEdit.setColumns(20);
        jTextAreaCommentsEdit.setLineWrap(true);
        jTextAreaCommentsEdit.setRows(5);
        jTextAreaCommentsEdit.setWrapStyleWord(true);
        jTextAreaCommentsEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextAreaCommentsEdit.setEnabled(false);
        jScrollPane4.setViewportView(jTextAreaCommentsEdit);

        jButtonSearchPatient.setText("Search");
        jButtonSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchPatientActionPerformed(evt);
            }
        });

        jTextFieldDiseaseEdit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDiseaseEdit.setEnabled(false);

        jLabel1.setText("Checkout Date :");

        jFormattedTextFieldCheckoutDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFormattedTextFieldCheckoutDate.setText(dateFormat.format(new java.sql.Date(System.currentTimeMillis())));

        jLabel2.setText("Total Price :");

        jFormattedTextFieldTotalPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel3.setText("Status :");

        jTextAreaStatus.setColumns(20);
        jTextAreaStatus.setRows(5);
        jScrollPane1.setViewportView(jTextAreaStatus);

        jButtonPrint.setText("Print");
        jButtonPrint.setEnabled(false);
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonSearchPatient)
                        .addGap(0, 103, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButtonPrint)
                                .addGap(36, 36, 36)
                                .addComponent(jButtonDiscard))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldPhoneNoEdit)
                                    .addComponent(jComboBoxGenderEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldAgeEdit)
                                    .addComponent(jScrollPane4)
                                    .addComponent(jFormattedTextFieldRegDateEdit)
                                    .addComponent(jTextFieldNameEdit)
                                    .addComponent(jTextFieldDiseaseEdit))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButtonCancel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jFormattedTextFieldTotalPrice)
                            .addComponent(jFormattedTextFieldCheckoutDate))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jFormattedTextFieldRegDateEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jFormattedTextFieldAgeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxGenderEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jFormattedTextFieldPhoneNoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldCheckoutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDiseaseEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextFieldTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSave)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDiscard)
                        .addComponent(jButtonCancel))
                    .addComponent(jButtonPrint))
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiscardActionPerformed
//  set new fields' values to null
        resetFormCheckout();
    }//GEN-LAST:event_jButtonDiscardActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
//  set new fields' values to null & close card
        resetFormCheckout();
        MainInterface.setDefaultLayout();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jComboBoxNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNameItemStateChanged

    }//GEN-LAST:event_jComboBoxNameItemStateChanged

    private void jComboBoxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNameActionPerformed

        //TODO reset and disable fields if changed
        //        resetFormEdit();
        //        jTextFieldNameEdit.setEnabled(false);
        //        jFormattedTextFieldAgeEdit.setEnabled(false);
        //        jComboBoxGenderEdit.setEnabled(false);
        //        jFormattedTextFieldPhoneNoEdit.setEnabled(false);
        //        jTextAreaAddressEdit.setEnabled(false);
        //        jTextFieldDiseaseEdit.setEnabled(false);
        //        jTextAreaCommentsEdit.setEnabled(false);
        //        jButtonEdit.setEnabled(false);
        //        String name = jComboBoxNameEdit.get
        if (jComboBoxName.getSelectedIndex() != -1) {
            String nameSelected = jComboBoxName.getSelectedItem().toString();

            String[] values = nameSelected.split(" - ");
            name = values[0];
            String id = values[1];
            jFormattedTextFieldID.setText(id);
        }
    }//GEN-LAST:event_jComboBoxNameActionPerformed

    private void jComboBoxNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxNameKeyReleased

    }//GEN-LAST:event_jComboBoxNameKeyReleased

    private void jFormattedTextFieldRegDateEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldRegDateEditActionPerformed

    }//GEN-LAST:event_jFormattedTextFieldRegDateEditActionPerformed

    private void jFormattedTextFieldIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldIDKeyReleased
        String val = jFormattedTextFieldID.getText();

        //        TODO Fix bug: reset is done even if an arrow key is pressed
        resetFormEdit();

        if (isPositiveInteger(val)) {
            id = Integer.parseInt(jFormattedTextFieldID.getText());
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
                query = "select * from patient where id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                result = statement.executeQuery();

                if (result.next()) {
                    name = result.getString("name");
                    jComboBoxName.setSelectedItem(name);
                } else {
                    jComboBoxName.setSelectedIndex(-1);
                }

            } catch (Exception e) {

            }
        } else {
            jComboBoxName.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jFormattedTextFieldIDKeyReleased

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
//       dialog box if any of the fields are empty

        if (jFormattedTextFieldCheckoutDate.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the Checkout Date !");

        } else if (jFormattedTextFieldTotalPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the Total Price !");

        } else if (jTextAreaStatus.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the Status !");

        } else {
//           TODO Save new fields' value to the database 
            id = Integer.parseInt(jFormattedTextFieldID.getText());

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
                query = "Update Patient set checkout_date=?, total_price=?, status=? where id=?";
                statement = connection.prepareStatement(query);

                checkoutDate = dateFormat.parse(jFormattedTextFieldCheckoutDate.getText());
                java.sql.Date checkDate = new java.sql.Date(checkoutDate.getTime());

                totalPrice = Float.parseFloat(jFormattedTextFieldTotalPrice.getText());
                status = jTextAreaStatus.getText();

                statement.setDate(1, checkDate);
                statement.setFloat(2, totalPrice);
                statement.setString(3, status);
                statement.setInt(4, id);

                statement.executeUpdate();

            } catch (Exception ex) {
                System.out.println(ex);
            }

            //      Enable Print button
            jButtonPrint.setEnabled(true);
        }


    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchPatientActionPerformed
        if (jFormattedTextFieldID.getText().equals("")) {
            if (jComboBoxName.getSelectedIndex() == -1) {
                jButtonSave.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Enter Patient ID or Name!");
            } else {
                //if Name is selected and id is not selected
                String nameSelected = jComboBoxName.getSelectedItem().toString();
                String[] values = nameSelected.split(" - ");
                name = values[0];
                id = Integer.parseInt(values[1]);
                setFieldValues("select * from patient where id = ?", id);

            }
        } else {
            //if id is selected
            id = Integer.parseInt(jFormattedTextFieldID.getText());
            setFieldValues("select * from patient where id = ?", id);
        }
    }//GEN-LAST:event_jButtonSearchPatientActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        // TODO Print code
    }//GEN-LAST:event_jButtonPrintActionPerformed
    private void setFieldValues(String query, Object val) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {

            statement = connection.prepareStatement(query);
            if (val instanceof Integer) {
                int i;
                i = (int) val;
                statement.setInt(1, i);
            } else if (val instanceof String) {
                String str = (String) val;
                statement.setString(1, str);
            }

            result = statement.executeQuery();

            if (result.next()) {

                date = result.getDate("register_date");
                id = result.getInt("id");
                name = result.getString("name");
                gender = result.getString("gender");
                age = result.getInt("age");
                phoneNo = result.getString("phone_no");
                address = result.getString("address");
                disease = result.getString("disease");
                comments = result.getString("comments");

                jFormattedTextFieldID.setText(Integer.toString(id));
                jFormattedTextFieldRegDateEdit.setText(dateFormat.format(date));
                jTextFieldNameEdit.setText(name);
                jFormattedTextFieldAgeEdit.setText(Integer.toString(age));
                jComboBoxGenderEdit.setSelectedItem(gender);
                jFormattedTextFieldPhoneNoEdit.setText(phoneNo);
                jTextAreaAddressEdit.setText(address);
                jTextFieldDiseaseEdit.setText(disease);
                jTextAreaCommentsEdit.setText(comments);
                jComboBoxName.setSelectedItem(name);

//                jButtonSave.setEnabled(true);
            } else {
//                jButtonSave.setEnabled(false);
                if (val instanceof Integer) {
                    JOptionPane.showMessageDialog(null, "Invalid Patient ID !");

                } else if (val instanceof String) {
                    JOptionPane.showMessageDialog(null, "Invalid Patient Name !");

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean isPositiveInteger(String str) {
        if (str.equals("")) {
            return false;
        }
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c > '9' || c < '0') {
                return false;
            }
        }
        return true;
    }

    public void resetFormCheckout() {
        jFormattedTextFieldCheckoutDate.setText(dateFormat.format(new java.sql.Date(System.currentTimeMillis())));
        jFormattedTextFieldTotalPrice.setText("");
        jTextAreaStatus.setText("");

    }

    public void resetFormEdit() {
        jFormattedTextFieldRegDateEdit.setText("");
        jTextFieldNameEdit.setText("");
        jFormattedTextFieldAgeEdit.setText("");
        jComboBoxGenderEdit.setSelectedIndex(0);
        jFormattedTextFieldPhoneNoEdit.setText("");
        jTextAreaAddressEdit.setText("");
        jTextFieldDiseaseEdit.setText("");
        jTextAreaCommentsEdit.setText("");
//        jComboBoxNameEdit.setSelectedItem(name);
    }

    public void setJFormattedTextFieldID(String text) {
        jFormattedTextFieldID.setText(text);
    }

    public void setJComboBoxNameIndex(int index) {
        jComboBoxName.setSelectedIndex(index);
    }

    public void setJComboBoxName(String[] names) {
        jComboBoxName.setModel(new javax.swing.DefaultComboBoxModel(names));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDiscard;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearchPatient;
    private javax.swing.JComboBox jComboBoxGenderEdit;
    private javax.swing.JComboBox jComboBoxName;
    private javax.swing.JFormattedTextField jFormattedTextFieldAgeEdit;
    private javax.swing.JFormattedTextField jFormattedTextFieldCheckoutDate;
    private javax.swing.JTextField jFormattedTextFieldID;
    private javax.swing.JFormattedTextField jFormattedTextFieldPhoneNoEdit;
    private javax.swing.JFormattedTextField jFormattedTextFieldRegDateEdit;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaAddressEdit;
    private javax.swing.JTextArea jTextAreaCommentsEdit;
    private javax.swing.JTextArea jTextAreaStatus;
    private javax.swing.JTextField jTextFieldDiseaseEdit;
    private javax.swing.JTextField jTextFieldNameEdit;
    // End of variables declaration//GEN-END:variables
}
