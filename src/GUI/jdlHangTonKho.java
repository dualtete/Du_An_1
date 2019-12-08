/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DBConnection;

/**
 *
 * @author bumte
 */
public class jdlHangTonKho extends javax.swing.JDialog {

    /**
     * Creates new form jdlSanPham
     */
    public jdlHangTonKho(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DBConnection conn = new DBConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhMucTonKho = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHangTonKho = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        pnlTimKiem = new javax.swing.JPanel();
        txtTiemKiemDSSP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnlTimKiem1 = new javax.swing.JPanel();
        txtTimKiemCTSP = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lblTenSanPham = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDanhMucTonKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDanhMucTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Barcode", "Tên sản phẩm", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhMucTonKho.setRowHeight(30);
        tblDanhMucTonKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucTonKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhMucTonKho);
        if (tblDanhMucTonKho.getColumnModel().getColumnCount() > 0) {
            tblDanhMucTonKho.getColumnModel().getColumn(0).setMinWidth(50);
            tblDanhMucTonKho.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDanhMucTonKho.getColumnModel().getColumn(0).setMaxWidth(50);
            tblDanhMucTonKho.getColumnModel().getColumn(1).setMinWidth(140);
            tblDanhMucTonKho.getColumnModel().getColumn(1).setPreferredWidth(140);
            tblDanhMucTonKho.getColumnModel().getColumn(1).setMaxWidth(140);
            tblDanhMucTonKho.getColumnModel().getColumn(3).setMinWidth(70);
            tblDanhMucTonKho.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblDanhMucTonKho.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Danh mục sản phẩm");

        tblHangTonKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHangTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "IMEI/SKU", "Hãng SX", "Tên nhà cung cấp", "Ngày nhập", "Hạn tồn kho", "Giá nhập", "Giá cũ", "Giá mới"
            }
        ));
        tblHangTonKho.setRowHeight(30);
        jScrollPane2.setViewportView(tblHangTonKho);
        if (tblHangTonKho.getColumnModel().getColumnCount() > 0) {
            tblHangTonKho.getColumnModel().getColumn(0).setMinWidth(50);
            tblHangTonKho.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblHangTonKho.getColumnModel().getColumn(0).setMaxWidth(50);
            tblHangTonKho.getColumnModel().getColumn(1).setMinWidth(130);
            tblHangTonKho.getColumnModel().getColumn(1).setPreferredWidth(130);
            tblHangTonKho.getColumnModel().getColumn(1).setMaxWidth(130);
            tblHangTonKho.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblHangTonKho.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblHangTonKho.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblHangTonKho.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlTimKiem.setLayout(new javax.swing.BoxLayout(pnlTimKiem, javax.swing.BoxLayout.LINE_AXIS));

        txtTiemKiemDSSP.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtTiemKiemDSSP.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTiemKiemDSSP.setText("yătiíđìồgfdgd");
        txtTiemKiemDSSP.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));
        txtTiemKiemDSSP.setCaretColor(new java.awt.Color(51, 102, 255));
        txtTiemKiemDSSP.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlTimKiem.add(txtTiemKiemDSSP);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconHuy/icons8_search_20px.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.setPreferredSize(new java.awt.Dimension(51, 40));
        pnlTimKiem.add(jButton1);

        pnlTimKiem1.setBackground(new java.awt.Color(255, 255, 255));
        pnlTimKiem1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0))));
        pnlTimKiem1.setLayout(new javax.swing.BoxLayout(pnlTimKiem1, javax.swing.BoxLayout.LINE_AXIS));

        txtTimKiemCTSP.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtTimKiemCTSP.setText("123123123");
        txtTimKiemCTSP.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));
        txtTimKiemCTSP.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlTimKiem1.add(txtTimKiemCTSP);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconHuy/icons8_search_20px.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.setPreferredSize(new java.awt.Dimension(51, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlTimKiem1.add(jButton2);

        lblTenSanPham.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTenSanPham.setForeground(new java.awt.Color(0, 102, 204));
        lblTenSanPham.setText("Ti vi sam sung hiện có ()");
        lblTenSanPham.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblTenSanPhamAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblTenSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTenSanPhamMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÀNG TỒN KHO");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BLL.BLL_HangTonKho.open();
    }//GEN-LAST:event_formWindowOpened

    private void lblTenSanPhamAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblTenSanPhamAncestorAdded

    }//GEN-LAST:event_lblTenSanPhamAncestorAdded

    private void lblTenSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenSanPhamMouseClicked

    }//GEN-LAST:event_lblTenSanPhamMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblDanhMucTonKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucTonKhoMouseClicked
        if (tblDanhMucTonKho.getSelectedRowCount() >= 1) {
            String str = tblDanhMucTonKho.getValueAt(tblDanhMucTonKho.getSelectedRow(), 2).toString();
            lblTenSanPham.setText(str);
            String barcode = tblDanhMucTonKho.getValueAt(tblDanhMucTonKho.getSelectedRow(), 1).toString();
            BLL.BLL_HangTonKho.loadHangTonKHo(barcode, tblHangTonKho);
        }
    }//GEN-LAST:event_tblDanhMucTonKhoMouseClicked

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
            java.util.logging.Logger.getLogger(jdlHangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlHangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlHangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlHangTonKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdlHangTonKho dialog = new jdlHangTonKho(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTenSanPham;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JPanel pnlTimKiem1;
    public static javax.swing.JTable tblDanhMucTonKho;
    public static javax.swing.JTable tblHangTonKho;
    private javax.swing.JTextField txtTiemKiemDSSP;
    private javax.swing.JTextField txtTimKiemCTSP;
    // End of variables declaration//GEN-END:variables
}
