/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelolapengeluaran;

import java.sql.SQLException;
import java.util.List;
import kelolapengeluaran.config.Config;
import kelolapengeluaran.dao.KategoriPengeluaranDAO;
import kelolapengeluaran.model.KategoriPengeluaran;

/**
 *
 * @author Lenovo
 */
public class DeleteCategory extends javax.swing.JFrame {
    private final KategoriPengeluaranDAO kategoriPengeluaranDAO;

    /**
     * Creates new form DeleteCategory
     */
    public DeleteCategory() {
        initComponents();
        try {
            kategoriPengeluaranDAO = new KategoriPengeluaranDAO(Config.configDB());
            loadCategories();
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing category data access object", e);
        }
    }
    
    private void loadCategories() {
        List<KategoriPengeluaran> categories = kategoriPengeluaranDAO.getAllCategories();
        categories.forEach((category) -> {
            ComboBoxCategory.addItem(category.getId() + ": " + category.getNama());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitle = new javax.swing.JLabel();
        ComboBoxCategory = new javax.swing.JComboBox<>();
        LabelDeleteCategory = new javax.swing.JLabel();
        ButtonHapus = new javax.swing.JButton();
        ButtonKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("KATEGORI PENGELUARAN");

        ComboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCategoryActionPerformed(evt);
            }
        });

        LabelDeleteCategory.setText("Hapus Kategori Pengeluaran");

        ButtonHapus.setBackground(new java.awt.Color(255, 102, 102));
        ButtonHapus.setForeground(new java.awt.Color(255, 255, 255));
        ButtonHapus.setText("Hapus");
        ButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHapusActionPerformed(evt);
            }
        });

        ButtonKembali.setBackground(new java.awt.Color(153, 153, 153));
        ButtonKembali.setText("Kembali");
        ButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(LabelDeleteCategory)
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitle)
                .addGap(18, 18, 18)
                .addComponent(LabelDeleteCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxCategoryActionPerformed

    private void ButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonKembaliActionPerformed
        new ViewCategories().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonKembaliActionPerformed

    private void ButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHapusActionPerformed
        String selectedItem = ComboBoxCategory.getSelectedItem().toString();
        int categoryId = Integer.parseInt(selectedItem.split(":")[0].trim());
        kategoriPengeluaranDAO.deleteCategory(categoryId);
        javax.swing.JOptionPane.showMessageDialog(this, "Kategori berhasil dihapus!");
        ComboBoxCategory.removeAllItems();
        loadCategories();
    }//GEN-LAST:event_ButtonHapusActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonHapus;
    private javax.swing.JButton ButtonKembali;
    private javax.swing.JComboBox<String> ComboBoxCategory;
    private javax.swing.JLabel LabelDeleteCategory;
    private javax.swing.JLabel LabelTitle;
    // End of variables declaration//GEN-END:variables
}
