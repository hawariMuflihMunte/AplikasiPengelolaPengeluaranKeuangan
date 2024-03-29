package kelolapengeluaran;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import kelolapengeluaran.config.Config;
import kelolapengeluaran.dao.KategoriPengeluaranDAO;
import kelolapengeluaran.dao.TransaksiPengeluaranDAO;
import kelolapengeluaran.model.KategoriPengeluaran;
import kelolapengeluaran.model.TransaksiPengeluaran;

/**
 *
 * @author Lenovo
 */
public class AddTransaction extends javax.swing.JFrame {
    private TransaksiPengeluaranDAO transaksiPengeluaranDAO;
    private KategoriPengeluaranDAO kategoriPengeluaranDAO;
    private int selectedCategoryId;

    /**
     * Creates new form AddTransaction
     */
    public AddTransaction() {
        initComponents();
        try {
            transaksiPengeluaranDAO = new TransaksiPengeluaranDAO(Config.configDB());
            kategoriPengeluaranDAO = new KategoriPengeluaranDAO(Config.configDB());
            loadCategories();
        } catch (SQLException e) {
            e.printStackTrace();
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
        ButtonKembali = new javax.swing.JButton();
        LabelTambahDataTransaksi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaDeskripsi = new javax.swing.JTextArea();
        LabelDeskripsi = new javax.swing.JLabel();
        ComboBoxCategory = new javax.swing.JComboBox<>();
        LabelKategori = new javax.swing.JLabel();
        TextFieldJumlah = new javax.swing.JTextField();
        LabelJumlah = new javax.swing.JLabel();
        CheckBoxToday = new javax.swing.JCheckBox();
        TextFieldDate = new javax.swing.JTextField();
        LabelDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ButtonTambah = new javax.swing.JButton();
        LinkLabelToAddCategory = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("TRANSAKSI PENGELUARAN");

        ButtonKembali.setBackground(new java.awt.Color(153, 153, 153));
        ButtonKembali.setText("Kembali");
        ButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonKembaliActionPerformed(evt);
            }
        });

        LabelTambahDataTransaksi.setText("Tambah Data Transaksi");

        TextAreaDeskripsi.setColumns(20);
        TextAreaDeskripsi.setRows(5);
        jScrollPane1.setViewportView(TextAreaDeskripsi);

        LabelDeskripsi.setText("Deskripsi");

        LabelKategori.setText("Kategori");

        TextFieldJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldJumlahKeyTyped(evt);
            }
        });

        LabelJumlah.setText("Jumlah");

        CheckBoxToday.setText("Hari ini ?");
        CheckBoxToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxTodayActionPerformed(evt);
            }
        });

        LabelDate.setText("Tanggal");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 2, 13)); // NOI18N
        jLabel1.setText("[tahun][bulan][tanggal]. Contoh: 2024-12-31");

        ButtonTambah.setBackground(new java.awt.Color(102, 102, 255));
        ButtonTambah.setForeground(new java.awt.Color(255, 255, 255));
        ButtonTambah.setText("Tambah");
        ButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahActionPerformed(evt);
            }
        });

        LinkLabelToAddCategory.setFont(new java.awt.Font("Trebuchet MS", 2, 13)); // NOI18N
        LinkLabelToAddCategory.setText("Kategori tidak ada? tambah kategori");
        LinkLabelToAddCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LinkLabelToAddCategoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(ButtonKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(LabelDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldJumlah)
                    .addComponent(LabelJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckBoxToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldDate)
                    .addComponent(LabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelTambahDataTransaksi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LinkLabelToAddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitle)
                .addGap(18, 18, 18)
                .addComponent(LabelTambahDataTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBoxToday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelJumlah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelKategori)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LinkLabelToAddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelDeskripsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonKembaliActionPerformed
        new ViewTransactions().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonKembaliActionPerformed

    private void CheckBoxTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxTodayActionPerformed
        if (CheckBoxToday.isSelected()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            TextFieldDate.setText(dateFormat.format(new Date()));
            TextFieldDate.setEditable(false);
        } else {
            TextFieldDate.setText("");
            TextFieldDate.setEditable(true);
        }
    }//GEN-LAST:event_CheckBoxTodayActionPerformed

    private void TextFieldJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldJumlahKeyTyped
        char c = evt.getKeyChar();
        
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_TextFieldJumlahKeyTyped

    private void ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahActionPerformed
        String tanggal = TextFieldDate.getText();
        Double jumlah = Double.parseDouble(TextFieldJumlah.getText());
        String deskripsi = TextAreaDeskripsi.getText();
        String[] selectedCategory = ComboBoxCategory.getSelectedItem().toString().split(":");
        int id_kategori = Integer.parseInt(selectedCategory[0]);
        
        TransaksiPengeluaran transaksi;
        transaksi = new TransaksiPengeluaran(
            0,
            tanggal,
            jumlah,
            id_kategori,
            deskripsi
        );
        
        transaksiPengeluaranDAO.addTransaction(transaksi);
        javax.swing.JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan!");
        resetForm();
    }//GEN-LAST:event_ButtonTambahActionPerformed

    private void LinkLabelToAddCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LinkLabelToAddCategoryMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Takin Ingin Keluar dan menambahkan data kategoti?\nData saat ini akan terhapus!", "Warning", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            new AddCategory().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LinkLabelToAddCategoryMouseClicked

    private void resetForm() {
        TextFieldDate.setText("");
        TextFieldJumlah.setText("");
        TextAreaDeskripsi.setText("");
        ComboBoxCategory.setSelectedIndex(0);
        CheckBoxToday.setSelected(false);

        TextFieldDate.setEditable(!CheckBoxToday.isSelected());
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
            java.util.logging.Logger.getLogger(AddTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonKembali;
    private javax.swing.JButton ButtonTambah;
    private javax.swing.JCheckBox CheckBoxToday;
    private javax.swing.JComboBox<String> ComboBoxCategory;
    private javax.swing.JLabel LabelDate;
    private javax.swing.JLabel LabelDeskripsi;
    private javax.swing.JLabel LabelJumlah;
    private javax.swing.JLabel LabelKategori;
    private javax.swing.JLabel LabelTambahDataTransaksi;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JLabel LinkLabelToAddCategory;
    private javax.swing.JTextArea TextAreaDeskripsi;
    private javax.swing.JTextField TextFieldDate;
    private javax.swing.JTextField TextFieldJumlah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
