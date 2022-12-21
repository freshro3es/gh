/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gh;

import com.mycompany.gh.db.PartDB;
import com.mycompany.gh.db.PartOrderDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Игорь
 */
public class AdminJFrame extends javax.swing.JFrame {
    
    DefaultTableModel partTableModel;
    DefaultTableModel partOrderTableModel;

    /**
     * Creates new form mainJFrame
     */
    public AdminJFrame() {
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

        javax.swing.JTabbedPane jTabbedPane1 = new javax.swing.JTabbedPane();
        main = new javax.swing.JPanel();
        tonAuto = new javax.swing.JLabel();
        expertMechanicsLabel = new javax.swing.JTextArea();
        marketYearsLabel = new javax.swing.JTextArea();
        guaranteesLabel = new javax.swing.JTextArea();
        newRecords = new javax.swing.JPanel();
        partsOrder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partsOrderTable = new javax.swing.JTable();
        deleteOrderButton = new javax.swing.JButton();
        partOrderLabel = new javax.swing.JLabel();
        updateOrderButton = new javax.swing.JButton();
        addPartOrderButton = new javax.swing.JButton();
        partsDB = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        partsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        addPartButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        attendance = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        profile = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ТонАвто ИС");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tonAuto.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        tonAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tonAuto.setText("TonAuto");
        tonAuto.setBorder(new javax.swing.border.MatteBorder(null));
        tonAuto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        expertMechanicsLabel.setEditable(false);
        expertMechanicsLabel.setColumns(20);
        expertMechanicsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        expertMechanicsLabel.setRows(5);
        expertMechanicsLabel.setText("ОПЫТНЫЕ МАСТЕРА\n\nРегулярное повышение квалификации, \nобучение и современное оборудование \nпозволяют нам обеспечить высокое \nкачество исполнения любых работ по \nремонту автомобиля.");
        expertMechanicsLabel.setMargin(new java.awt.Insets(3, 10, 3, 10));

        marketYearsLabel.setEditable(false);
        marketYearsLabel.setColumns(20);
        marketYearsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        marketYearsLabel.setRows(5);
        marketYearsLabel.setText("24 ГОДА НА РЫНКЕ\n\nЗа такой срок мы накопили огромный\nопыт в ремонте и обслуживании ино-\nмарок, автомобилей отечественного \nпроизводства и микроавтобусов.");
        marketYearsLabel.setAutoscrolls(false);
        marketYearsLabel.setMargin(new java.awt.Insets(3, 10, 3, 10));

        guaranteesLabel.setEditable(false);
        guaranteesLabel.setColumns(20);
        guaranteesLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        guaranteesLabel.setRows(5);
        guaranteesLabel.setText("ГАРАНТИЯ НА РЕМОНТ\nИ ЗАПЧАСТИ\n\nНа выполненные работы и запчасти мы \nпредоставляем гарантию до 1 года.");
        guaranteesLabel.setAutoscrolls(false);
        guaranteesLabel.setMargin(new java.awt.Insets(3, 10, 3, 10));

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(marketYearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guaranteesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tonAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expertMechanicsLabel))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(tonAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marketYearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guaranteesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expertMechanicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        jTabbedPane1.addTab("Главная", main);

        javax.swing.GroupLayout newRecordsLayout = new javax.swing.GroupLayout(newRecords);
        newRecords.setLayout(newRecordsLayout);
        newRecordsLayout.setHorizontalGroup(
            newRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        newRecordsLayout.setVerticalGroup(
            newRecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Новые записи", newRecords);

        partsOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Название", "Тип", "Цена", "Количество", "Заказ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(partsOrderTable);

        deleteOrderButton.setText("Удалить деталь");
        deleteOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderButtonActionPerformed(evt);
            }
        });

        partOrderLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        partOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partOrderLabel.setText("Заказ деталей");

        updateOrderButton.setText("Обновить");
        updateOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOrderButtonActionPerformed(evt);
            }
        });

        addPartOrderButton.setText("Добавить деталь");
        addPartOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPartOrderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout partsOrderLayout = new javax.swing.GroupLayout(partsOrder);
        partsOrder.setLayout(partsOrderLayout);
        partsOrderLayout.setHorizontalGroup(
            partsOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partsOrderLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(partsOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partsOrderLayout.createSequentialGroup()
                        .addGroup(partsOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addComponent(partOrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78))
                    .addGroup(partsOrderLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(updateOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPartOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        partsOrderLayout.setVerticalGroup(
            partsOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partsOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(partOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partsOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPartOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Заказ деталей", partsOrder);

        partsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Название", "Тип", "Цена", "Количество", "Заказ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(partsTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Склад деталей");

        updateButton.setText("Обновить");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addPartButton.setText("Добавить деталь");
        addPartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPartButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Удалить деталь");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout partsDBLayout = new javax.swing.GroupLayout(partsDB);
        partsDB.setLayout(partsDBLayout);
        partsDBLayout.setHorizontalGroup(
            partsDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partsDBLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(partsDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partsDBLayout.createSequentialGroup()
                        .addGroup(partsDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78))
                    .addGroup(partsDBLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPartButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        partsDBLayout.setVerticalGroup(
            partsDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partsDBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(partsDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Склад деталей", partsDB);

        javax.swing.GroupLayout attendanceLayout = new javax.swing.GroupLayout(attendance);
        attendance.setLayout(attendanceLayout);
        attendanceLayout.setHorizontalGroup(
            attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        attendanceLayout.setVerticalGroup(
            attendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Посещаемость", attendance);

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Админ-панель", adminPanel);

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Профиль", profile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addPartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()==addPartButton) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AddPartJFrame().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_addPartButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()==updateButton) {
            PartDB parts = new PartDB();
            Object[][] array = null;
            System.out.println("getting data...");
            try {
                array = parts.getData();
            } catch (SQLException ex) {
                Logger.getLogger(AdminJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("got data...");
            partTableModel = new DefaultTableModel();
            Object[] columnsHeader = new String[] {"Название", "Тип", "Цена", "Количество", "Заказ"};
            partTableModel.setColumnIdentifiers(columnsHeader);
            for (int i = 0; i < array.length; i++)
            partTableModel.addRow(array[i]);
            partsTable.setModel(partTableModel);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()==deleteButton) {
            int idx = partsTable.getSelectedRow();
            String[] param = new String[5]; 
            for (int i = 0; i < 5; i++) {
                param[i] = (String) partsTable.getValueAt(idx, i);
            }
            partTableModel.removeRow(idx);
            PartDB parts = new PartDB();
            parts.deleteData(param);
            System.out.println("return to main form");
            
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void deleteOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()==deleteOrderButton) {
            System.out.println("delet button pressed...");
            int idx = partsOrderTable.getSelectedRow();
            System.out.println(idx);
            String[] param = new String[5];
            System.out.println("initialisated");
            for (int i = 0; i < 5; i++) {
                System.out.println("cycle: " + i);
                param[i] = (String) partsOrderTable.getValueAt(idx, i);
            }
            partOrderTableModel.removeRow(idx);
            PartOrderDB parts = new PartOrderDB();
            parts.deleteData(param);
            System.out.println("return to main form");
            
        }
    }//GEN-LAST:event_deleteOrderButtonActionPerformed

    private void updateOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOrderButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()==updateOrderButton) {
            PartOrderDB parts = new PartOrderDB();
            Object[][] array = null;
            System.out.println("getting data...");
            try {
                array = parts.getData();
            } catch (SQLException ex) {
                Logger.getLogger(AdminJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("got data...");
            partOrderTableModel = new DefaultTableModel();
            Object[] columnsHeader = new String[] {"Название", "Тип", "Цена", "Количество", "Заказ"};
            partOrderTableModel.setColumnIdentifiers(columnsHeader);
            for (int i = 0; i < array.length; i++)
            partOrderTableModel.addRow(array[i]);
            partsOrderTable.setModel(partOrderTableModel);
        }
    }//GEN-LAST:event_updateOrderButtonActionPerformed

    private void addPartOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartOrderButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource()==addPartOrderButton) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AddPartOrderJFrame().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_addPartOrderButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPartButton;
    private javax.swing.JButton addPartOrderButton;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPanel attendance;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteOrderButton;
    private javax.swing.JTextArea expertMechanicsLabel;
    private javax.swing.JTextArea guaranteesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel main;
    private javax.swing.JTextArea marketYearsLabel;
    private javax.swing.JPanel newRecords;
    private javax.swing.JLabel partOrderLabel;
    private javax.swing.JPanel partsDB;
    private javax.swing.JPanel partsOrder;
    private javax.swing.JTable partsOrderTable;
    private javax.swing.JTable partsTable;
    private javax.swing.JPanel profile;
    private javax.swing.JLabel tonAuto;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateOrderButton;
    // End of variables declaration//GEN-END:variables
}
