/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Prabhashi
 */
public class MainInterface extends javax.swing.JFrame {

    final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

//    static Connection connection;
//    static {
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null);
//        } catch (Exception e) {
//        }
//    }
    private String query;
    private PreparedStatement statement;
    private ResultSet result;
//    private ArrayList<javax.swing.JTextField> EditFieldsList = new ArrayList<>();
    private static CardLayout card;
    private final PatientRegistrationPanel patientRegistrationPanel;
    private final PatientInfoPanel patientInfoPanel;
    private final PatientCheckoutPanel patientCheckoutPanel;

    /**
     * Creates new form FrameMain
     */
    public MainInterface() {
        initComponents();
       
        patientRegistrationPanel = new PatientRegistrationPanel();
        jPanelCard.add(patientRegistrationPanel, "jPanelPatientReg");

        patientInfoPanel = new PatientInfoPanel();
        jPanelCard.add(patientInfoPanel, "jPanelPatientInfo");
        
        patientCheckoutPanel = new PatientCheckoutPanel();
        jPanelCard.add(patientCheckoutPanel, "jPanelPatientCheckout");

        card = (CardLayout) jPanelCard.getLayout();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jButtonPatientReg = new javax.swing.JButton();
        jButtonPatientInfo = new javax.swing.JButton();
        jButtonPatientCheckout = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanelCard = new javax.swing.JPanel();
        jPanelDefault = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanelMenu.setAlignmentX(0.0F);
        jPanelMenu.setOpaque(false);

        jButtonPatientReg.setText("Patient Registration");
        jButtonPatientReg.setAlignmentX(0.5F);
        jButtonPatientReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatientRegActionPerformed(evt);
            }
        });

        jButtonPatientInfo.setText("Patient Information");
        jButtonPatientInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatientInfoActionPerformed(evt);
            }
        });

        jButtonPatientCheckout.setText("Patient Checkout");
        jButtonPatientCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatientCheckoutActionPerformed(evt);
            }
        });

        jButton4.setText("Room Information");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Staff Information");

        jButton6.setText("Logout");

        jButton7.setText("Close");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPatientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPatientCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jButtonPatientReg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonPatientReg)
                .addGap(18, 18, 18)
                .addComponent(jButtonPatientInfo)
                .addGap(18, 18, 18)
                .addComponent(jButtonPatientCheckout)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 510));

        jPanelCard.setOpaque(false);
        jPanelCard.setPreferredSize(new java.awt.Dimension(740, 510));
        jPanelCard.setLayout(new java.awt.CardLayout());

        jPanelDefault.setOpaque(false);
        jPanelDefault.setPreferredSize(new java.awt.Dimension(740, 480));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hospital Management System");

        javax.swing.GroupLayout jPanelDefaultLayout = new javax.swing.GroupLayout(jPanelDefault);
        jPanelDefault.setLayout(jPanelDefaultLayout);
        jPanelDefaultLayout.setHorizontalGroup(
            jPanelDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        jPanelDefaultLayout.setVerticalGroup(
            jPanelDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        jPanelCard.add(jPanelDefault, "jPanelDefault");

        getContentPane().add(jPanelCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bkgrnd.jpg"))); // NOI18N
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPatientRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatientRegActionPerformed

        card.show(jPanelCard, "jPanelPatientReg");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {

            query = "select * from patient order by id desc limit 1";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            int id = 0;
            if (result.next()) {
                id = result.getInt("id");
            }
            id = id + 1;
            patientRegistrationPanel.setJTextFieldPatientIDText(Integer.toString(id));
            patientRegistrationPanel.resetFormReg();

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButtonPatientRegActionPerformed

    private void jButtonPatientInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatientInfoActionPerformed

        card.show(jPanelCard, "jPanelPatientInfo");
        patientInfoPanel.resetFormEdit();

        patientInfoPanel.setJFormattedTextFieldEditID("");
        patientInfoPanel.setJComboBoxNameEditIndex(-1);
        patientInfoPanel.setJButtonEditEnable(false);

//        jComboBoxNameEdit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - Select Name - -", "m 2", "tem 3", "em 4" }));
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
            query = "select id,name from patient order by id desc";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();

            ArrayList<String> nameList = new ArrayList<>();
            while (result.next()) {
                String id = Integer.toString(result.getInt("id"));
                nameList.add(result.getString("name")+" - "+id);
            }
            String[] names = nameList.toArray(new String[nameList.size()]);
            patientInfoPanel.setJComboBoxNameEdit(names);
            patientInfoPanel.setJComboBoxNameEditIndex(-1);

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButtonPatientInfoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        CardLayout card = (CardLayout) jPanelCard.getLayout();
//        card.show(jPanelCard, "jPanelPatientReg");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonPatientCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatientCheckoutActionPerformed
        card.show(jPanelCard, "jPanelPatientCheckout");
         patientCheckoutPanel.resetFormEdit();
         patientCheckoutPanel.resetFormCheckout();
//       jButtonSave.setEnabled(false);

        patientCheckoutPanel.setJFormattedTextFieldID("");
//        patientCheckoutPanel.setJComboBoxNameIndex(-1);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null)) {
            query = "select id,name from patient order by id desc";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();

            ArrayList<String> nameList = new ArrayList<>();
            while (result.next()) {
                String id = Integer.toString(result.getInt("id"));
                nameList.add(result.getString("name")+" - "+id);
            }
            String[] names = nameList.toArray(new String[nameList.size()]);
            patientCheckoutPanel.setJComboBoxName(names);
            patientCheckoutPanel.setJComboBoxNameIndex(-1);

        } catch (Exception e) {
            System.out.println(e);
        }

        
    }//GEN-LAST:event_jButtonPatientCheckoutActionPerformed

//    private void resetFormFields(ArrayList<javax.swing.JTextField> fieldsList) {
//        for (javax.swing.JTextField j : fieldsList) {
//            j.setText("");
//        }
//    }
    protected static void setDefaultLayout() {
        card.show(jPanelCard, "jPanelDefault");
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonPatientCheckout;
    private javax.swing.JButton jButtonPatientInfo;
    private javax.swing.JButton jButtonPatientReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBackground;
    private static javax.swing.JPanel jPanelCard;
    private javax.swing.JPanel jPanelDefault;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables
}
