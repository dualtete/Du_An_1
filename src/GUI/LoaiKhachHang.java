/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author bumte
 */
public class LoaiKhachHang extends javax.swing.JDialog {

    /**
     * Creates new form LoaiKhachHang
     */
    public LoaiKhachHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //Thêm loại khách hàng

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTenLoaiKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThem1 = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtIDKH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTenLoaiKH.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(txtTenLoaiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 35, 295, 40));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 23, 127, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnThem1.setBackground(new java.awt.Color(0, 102, 153));
        btnThem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThem1.setForeground(new java.awt.Color(255, 255, 255));
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_50px.png"))); // NOI18N
        btnThem1.setText("THÊM");
        btnThem1.setBorder(null);
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem1);

        btnSua.setBackground(new java.awt.Color(0, 102, 153));
        btnSua.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_maintenance_50px.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXoa.setBackground(new java.awt.Color(0, 102, 153));
        btnXoa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_50px.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setBorder(null);
        jPanel2.add(btnXoa);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 620, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("TÊN LOẠI KHÁCH HÀNG");
        jLabel19.setMaximumSize(new java.awt.Dimension(115, 16));
        jLabel19.setMinimumSize(new java.awt.Dimension(115, 16));
        jLabel19.setPreferredSize(new java.awt.Dimension(115, 16));
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 30));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("MÔ TẢ");
        jLabel20.setMaximumSize(new java.awt.Dimension(115, 16));
        jLabel20.setMinimumSize(new java.awt.Dimension(115, 16));
        jLabel20.setPreferredSize(new java.awt.Dimension(115, 16));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtIDKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIDKH.setForeground(new java.awt.Color(0, 0, 0));
        txtIDKH.setBorder(new javax.swing.border.MatteBorder(null));
        txtIDKH.setMinimumSize(new java.awt.Dimension(2, 17));
        jPanel1.add(txtIDKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        if (!BLL.BLL_LoaiKH.insert()) {
            return;
        }
        this.dispose();
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //txtMoTa1.setEditable(true);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(LoaiKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoaiKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoaiKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoaiKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoaiKhachHang dialog = new LoaiKhachHang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField txtIDKH;
    public static javax.swing.JTextField txtTenLoaiKH;
    // End of variables declaration//GEN-END:variables
}
