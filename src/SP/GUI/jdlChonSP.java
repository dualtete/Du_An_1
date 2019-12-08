/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.GUI;

import GUI.ViTri.HeaderColor;
import static SP.GUI.pnlCT_PhieuNhap.spnSL;
import static SP.GUI.pnlCT_PhieuNhap.txtBarcode;
import static SP.GUI.pnlCT_PhieuNhap.txtGiaLeMoi;
import static SP.GUI.pnlCT_PhieuNhap.txtGiaNhapMoi;
import static SP.GUI.pnlCT_PhieuNhap.txtGiaSiMoi;

/**
 *
 * @author bumte
 */
public class jdlChonSP extends javax.swing.JDialog {

    /**
     * Creates new form jdlChonSP
     */
    public jdlChonSP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tblSP.getTableHeader().setDefaultRenderer(new HeaderColor());
        tblSP.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "BARCODE", "TÊN SẢN PHẨM", "Trạng thái", "ID loại sả phẩm", "HÃNG SẢN XUẤT", "BẢO HÀNH(Tháng)", "TT Bảo hành", "TT Sản phẩm", "Ngày thêm", "ID tài khoản thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);
        if (tblSP.getColumnModel().getColumnCount() > 0) {
            tblSP.getColumnModel().getColumn(0).setMinWidth(20);
            tblSP.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblSP.getColumnModel().getColumn(0).setMaxWidth(50);
            tblSP.getColumnModel().getColumn(1).setMinWidth(100);
            tblSP.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblSP.getColumnModel().getColumn(1).setMaxWidth(150);
            tblSP.getColumnModel().getColumn(2).setMinWidth(350);
            tblSP.getColumnModel().getColumn(2).setPreferredWidth(350);
            tblSP.getColumnModel().getColumn(2).setMaxWidth(350);
            tblSP.getColumnModel().getColumn(3).setMinWidth(0);
            tblSP.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblSP.getColumnModel().getColumn(3).setMaxWidth(0);
            tblSP.getColumnModel().getColumn(4).setMinWidth(0);
            tblSP.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblSP.getColumnModel().getColumn(4).setMaxWidth(0);
            tblSP.getColumnModel().getColumn(5).setMinWidth(100);
            tblSP.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblSP.getColumnModel().getColumn(5).setMaxWidth(200);
            tblSP.getColumnModel().getColumn(6).setMinWidth(50);
            tblSP.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblSP.getColumnModel().getColumn(6).setMaxWidth(200);
            tblSP.getColumnModel().getColumn(7).setMinWidth(0);
            tblSP.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblSP.getColumnModel().getColumn(7).setMaxWidth(0);
            tblSP.getColumnModel().getColumn(8).setMinWidth(0);
            tblSP.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblSP.getColumnModel().getColumn(8).setMaxWidth(0);
            tblSP.getColumnModel().getColumn(9).setMinWidth(0);
            tblSP.getColumnModel().getColumn(9).setPreferredWidth(0);
            tblSP.getColumnModel().getColumn(9).setMaxWidth(0);
            tblSP.getColumnModel().getColumn(10).setMinWidth(0);
            tblSP.getColumnModel().getColumn(10).setPreferredWidth(0);
            tblSP.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        btnTimKiem1.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTimKiem1.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_50px_1.png"))); // NOI18N
        btnTimKiem1.setBorder(null);
        btnTimKiem1.setBorderPainted(false);
        btnTimKiem1.setContentAreaFilled(false);
        btnTimKiem1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_50px_2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimKiem1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTimKiem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SP.BLL.BLL_SanPham.loadDSanPham(tblSP, "");
    }//GEN-LAST:event_formWindowOpened

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        SP.BLL.BLL_SanPham.loadDSanPham(tblSP, txtTimKiem.getText());
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        if (tblSP.getSelectedRowCount() == 1 && evt.getClickCount() == 2) {
            String barcode = tblSP.getValueAt(tblSP.getSelectedRow(), 1).toString();
            txtBarcode.setText(barcode);
            boolean checkbarcode = SP.BLL.BLL_CTPhieuNhap.showThongTinSanPham(txtBarcode.getText(), SP.BLL.BLL_TaoPhieuNhap.pn.getIDPN());
            if (!checkbarcode) {
                txtGiaLeMoi.setEditable(false);
                txtGiaSiMoi.setEditable(false);
                txtGiaNhapMoi.setEditable(false);

            }
            spnSL.requestFocus(true);
            this.dispose();
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        
    }//GEN-LAST:event_txtTimKiemFocusLost

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
            java.util.logging.Logger.getLogger(jdlChonSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlChonSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlChonSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlChonSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdlChonSP dialog = new jdlChonSP(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
