/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ViTri.tblNhaCungCap;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Admin
 */
public class DSNhaCungCap extends javax.swing.JInternalFrame {

    /**
     * Creates new form DaiLy
     */
    public DSNhaCungCap() {
        initComponents();
        tblNhaCungCap.getTableHeader().setDefaultRenderer(new ViTri.HeaderColor());
        tblNhaCungCap.getTableHeader().setReorderingAllowed(true);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDaiLy = new javax.swing.JPanel();
        pnlTieuDe = new javax.swing.JPanel();
        lblThongTin = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        csbNhaCungCap = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1430, 910));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        pnlDaiLy.setBackground(new java.awt.Color(255, 255, 255));

        pnlTieuDe.setBackground(new java.awt.Color(255, 255, 255));
        pnlTieuDe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 153)));
        pnlTieuDe.setForeground(new java.awt.Color(0, 102, 153));
        pnlTieuDe.setPreferredSize(new java.awt.Dimension(449, 50));

        lblThongTin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblThongTin.setForeground(new java.awt.Color(0, 102, 153));
        lblThongTin.setText("DANH SÁCH NHÀ CUNG CẤP");

        btnPrev.setBackground(new java.awt.Color(255, 255, 255));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_arrows_long_left_50px_1.png"))); // NOI18N
        btnPrev.setBorder(null);
        btnPrev.setBorderPainted(false);
        btnPrev.setContentAreaFilled(false);
        btnPrev.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_arrows_long_left_50px_6.png"))); // NOI18N

        javax.swing.GroupLayout pnlTieuDeLayout = new javax.swing.GroupLayout(pnlTieuDe);
        pnlTieuDe.setLayout(pnlTieuDeLayout);
        pnlTieuDeLayout.setHorizontalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTieuDeLayout.setVerticalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDeLayout.createSequentialGroup()
                .addGroup(pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID NHÀ CUNG CẤP", "TÊN NHÀ CUNG CẤP", "LOẠI HÌNH", "ĐỊA CHỈ", "NHÓM NHÀ CUNG CẤP", "SĐT", "MÃ SỐ THUẾ", "NGƯỜI LIÊN HỆ", "EMAIL", "TRANG WEB", "TÀI KHOẢN NGÂN HÀNG", "TÊN NGÂN HÀNG", "NGÀY THÊM", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhaCungCap.setRowHeight(25);
        tblNhaCungCap.getTableHeader().setReorderingAllowed(false);
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMousePressed(evt);
            }
        });
        csbNhaCungCap.setViewportView(tblNhaCungCap);

        javax.swing.GroupLayout pnlDaiLyLayout = new javax.swing.GroupLayout(pnlDaiLy);
        pnlDaiLy.setLayout(pnlDaiLyLayout);
        pnlDaiLyLayout.setHorizontalGroup(
            pnlDaiLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
            .addComponent(csbNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
        );
        pnlDaiLyLayout.setVerticalGroup(
            pnlDaiLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaiLyLayout.createSequentialGroup()
                .addComponent(pnlTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(csbNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDaiLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDaiLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
//        if (evt.getClickCount() == 2) {
//            jdlAddNhaCungCap jdl = new jdlAddNhaCungCap(new JFrame(), true);
//            jdlAddNhaCungCap.btnThem.setEnabled(false);
//            jdlAddNhaCungCap.txtIDNCC.setEditable(false);
//            BLL.BLL_NhaCungCap.click();
//            jdl.setVisible(true);
//
//        }
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void tblNhaCungCapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMousePressed
        //        if (tblNhanVien1.getRowCount() <= 0) {
            //            return;
            //        }
        //        BLL.BLL_NhanVien.click();
    }//GEN-LAST:event_tblNhaCungCapMousePressed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        BLL.BLL_NhaCungCap.loadBangNCC1();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrev;
    private javax.swing.JScrollPane csbNhaCungCap;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JPanel pnlDaiLy;
    private javax.swing.JPanel pnlTieuDe;
    public static javax.swing.JTable tblNhaCungCap;
    // End of variables declaration//GEN-END:variables
}
