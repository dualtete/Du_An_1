/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.GUI;

import static SP.GUI.pnlThongTin.tblNCC;
import java.awt.Component;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author bumte
 */
public class page_Main_NhapHang extends javax.swing.JInternalFrame {

    public static pnlCT_PhieuNhap pnlCTPhieuNhap;
    public static pnlThongTin ThongTin;
   
//    public static page_NhapTheo_NCC formThemSP = new page_NhapTheo_NCC();

    /**
     * Creates new form itnMainDatHang
     */
    public page_Main_NhapHang() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

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

        chfFile = new javax.swing.JFileChooser();
        jfileTest = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        pnlAddPnl = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        mniTaoPhieuNhap_NCC = new javax.swing.JMenuItem();
        mniDonDatHang = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mniNhapSPExcel = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        chfFile.setApproveButtonText("Chọn");
        chfFile.setApproveButtonToolTipText("Chọn file excel");
        chfFile.setBackground(java.awt.Color.black);
        chfFile.setDialogTitle("Chọn file excel");
        chfFile.setMinimumSize(new java.awt.Dimension(704, 397));
        chfFile.setPreferredSize(new java.awt.Dimension(704, 500));

        jfileTest.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jfileTest.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setResizable(true);
        setMinimumSize(new java.awt.Dimension(1325, 883));
        setPreferredSize(new java.awt.Dimension(1325, 883));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlAddPnl.setLayout(new java.awt.BorderLayout());
        jPanel1.add(pnlAddPnl, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 51, 204));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(313, 45));

        jMenu1.setBackground(new java.awt.Color(0, 153, 255));
        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("Đơn đặt hàng");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenu4.setText("Tạo mới");

        mniTaoPhieuNhap_NCC.setText("Tạo hóa đơn với nhà cung cấp");
        mniTaoPhieuNhap_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTaoPhieuNhap_NCCActionPerformed(evt);
            }
        });
        jMenu4.add(mniTaoPhieuNhap_NCC);

        jMenu1.add(jMenu4);

        mniDonDatHang.setText("Đơn đã đặt");
        mniDonDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDonDatHangActionPerformed(evt);
            }
        });
        jMenu1.add(mniDonDatHang);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Nhập hàng");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem3.setText("Nhập với đơn đặt hàng");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        mniNhapSPExcel.setText("Nhập hàng bằng Excel");
        mniNhapSPExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNhapSPExcelActionPerformed(evt);
            }
        });
        jMenu2.add(mniNhapSPExcel);

        jMenuItem7.setText("Xuất file nhập mẫu");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("QL Đơn nhập hàng");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem5.setText("Đơn đã nhập");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Đơn đã đặt hàng");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Sản phẩm");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenu6.setText("Danh mục sản phẩm");

        jMenuItem1.setText("Thêm mới");
        jMenu6.add(jMenuItem1);

        jMenuItem4.setText("Sản phẩm hiện có");
        jMenu6.add(jMenuItem4);

        jMenu5.add(jMenu6);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniNhapSPExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNhapSPExcelActionPerformed
        if (SP.BLL.BLL_SanPham.importSPByXlSX() == -1) {
            return;
        }
    }//GEN-LAST:event_mniNhapSPExcelActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        File t = SP.BLL.BLL_SanPham.selectFile(jfileTest);
        if (t != null) {
            if (SP.BLL.BLL_SanPham.saveLogo(t)) {
                System.out.println("Coppy file thành công");
                return;
            }

        }

        System.out.println("Copy lỗi");

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        ThongTin = new pnlThongTin();
        pnlAddPnl.add(ThongTin).setVisible(true);
        pnlAddPnl.revalidate();
        pnlAddPnl.repaint();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved


    }//GEN-LAST:event_formAncestorRemoved

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded

    }//GEN-LAST:event_formAncestorAdded

    private void mniTaoPhieuNhap_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTaoPhieuNhap_NCCActionPerformed
        if (tblNCC.getSelectedRowCount() != 1) {
            System.out.println("Cần chọn nhà cung cấp");
            return;
        }

        pnlCTPhieuNhap = new pnlCT_PhieuNhap();
        SP.BLL.BLL_TaoPhieuNhap.TaoPhieuNhap();
        pnlAddPnl.removeAll();
        pnlAddPnl.add(pnlCTPhieuNhap).setVisible(true);
        pnlAddPnl.revalidate();
        pnlAddPnl.repaint();


    }//GEN-LAST:event_mniTaoPhieuNhap_NCCActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

       

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void mniDonDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDonDatHangActionPerformed
   
    }//GEN-LAST:event_mniDonDatHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JFileChooser chfFile;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFileChooser jfileTest;
    private javax.swing.JMenuItem mniDonDatHang;
    private javax.swing.JMenuItem mniNhapSPExcel;
    private javax.swing.JMenuItem mniTaoPhieuNhap_NCC;
    public static javax.swing.JPanel pnlAddPnl;
    // End of variables declaration//GEN-END:variables
}
