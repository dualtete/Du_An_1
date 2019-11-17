/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author bumte
 */
public class page_ViTri extends javax.swing.JInternalFrame {

    /**
     * Creates new form page_ViTri
     */
    public page_ViTri() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        FillBan();
    }
    public static Color defaulColor = new Color(51, 204, 255);
    public static Color hoverColor = new Color(0, 187, 249);
    public static Color selectColor = new Color(204, 204, 204);
    public static JButton btnThem;
    public static ArrayList<DTO.DTO_ViTriHangHoa> kho;
    public static DTO.DTO_ViTriHangHoa vt;

    private void FillBan() {
        lblTitle.setText("Các kho hiện tại của Vi Tuấn");
        scpViTri.removeAll();
        kho = BLL.BLL_VitriHangHoa.getAllKho();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlKhoChua = new JPanel[kho.size()];
        JLabel[] lblHinh = new JLabel[kho.size()];
        JLabel[] lblTen = new JLabel[kho.size()];
        JLabel[] lblSoLo = new JLabel[kho.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < kho.size(); i++) {
            checkclick.add(i, false);
            pnlKhoChua[i] = new javax.swing.JPanel();
            lblHinh[i] = new javax.swing.JLabel();
            lblTen[i] = new javax.swing.JLabel();
            lblHinh[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));

            lblHinh[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            lblTen[i].setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblTen[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTen[i].setText(kho.get(i).getTenKho());

            pnlKhoChua[i].add(lblHinh[i], java.awt.BorderLayout.PAGE_START);
            pnlKhoChua[i].add(lblTen[i], java.awt.BorderLayout.CENTER);
            pnlKhoChua[i].setLayout(new java.awt.BorderLayout());
            pnlKhoChua[i].setBackground(defaulColor);
            pnlKhoChua[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlKhoChua[i]);
            pnlKhoChua[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHinh[i], javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTen[i], javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(30, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblHinh[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTen[i])
                            .addContainerGap(10, Short.MAX_VALUE))
            );

            int j = i;
            pnlKhoChua[j].addMouseListener(new MouseAdapter() {

//                @Override
//                public void mousePressed(MouseEvent e) {
//                    
//                    if (checkclick.get(j)) {
//                        checkclick.set(j, false);
//                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                        e.getComponent().setBackground(defaulColor);
//
//                        pnlKhoChua[j].addMouseListener(new MouseAdapter() {
//
//                            @Override
//                            public void mousePressed(MouseEvent e) {
//                                if (e.getClickCount() == 2) {
//
//                                    if (checkclick.get(j)) {
//                                        checkclick.set(j, false);
//                                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                                        e.getComponent().setBackground(defaulColor);
//                                    } else {
//                                        checkclick.set(j, true);
//                                        e.getComponent().setBackground(selectColor);
//                                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png")));
//                                        for (int k = 0; k < kho.size(); k++) {
//                                            if (k != j) {
//                                                checkclick.set(k, false);
//                                                pnlKhoChua[k].setBackground(defaulColor);
//                                                lblHinh[k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//
//                            //hover
//                            @Override
//
//                            public void mouseEntered(MouseEvent e) {
//                                if (checkclick.get(j)) {
//                                    return;
//                                }
//                                lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_2.png")));
//                                e.getComponent().setBackground(hoverColor);
//                            }
//
//                            @Override
//                            public void mouseExited(MouseEvent e) {
//                                if (checkclick.get(j)) {
//                                    lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png")));
//                                    e.getComponent().setBackground(selectColor);
//                                } else {
//                                    lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                                    e.getComponent().setBackground(defaulColor);
//                                }
//                            }
//                        }
//                        );
//
//                    } else {
//                        checkclick.set(j, true);
//                        e.getComponent().setBackground(selectColor);
//                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png")));
//                        for (int k = 0; k < kho.size(); k++) {
//                            if (k != j) {
//                                checkclick.set(k, false);
//                                pnlKhoChua[k].setBackground(defaulColor);
//                                lblHinh[k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                            }
//                        }
//                    }
//
//                }
                //hover
                @Override

                public void mouseEntered(MouseEvent e) {
                    if (checkclick.get(j)) {
                        return;
                    }

                    lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_2.png")));
                    e.getComponent().setBackground(hoverColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png")));
                        e.getComponent().setBackground(selectColor);
                    } else {
                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
                        e.getComponent().setBackground(defaulColor);
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    lblTitle.setText("Các lô trong kho " + kho.get(j).getTenKho());
                    fillLo(kho.get(j).getIDKho());
                    vt = kho.get(j);

                }
            }
            );
            scpViTri.add(pnlKhoChua[i]);
        }

        scpViTri.updateUI();

    }

    public void fillLo(String lo) {

        scpViTri.removeAll();
        ArrayList<DTO.DTO_ViTriHangHoa> kho = BLL.BLL_VitriHangHoa.getAllLo(lo);
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlKhoChua = new JPanel[kho.size()];
        JLabel[] lblHinh = new JLabel[kho.size()];
        JLabel[] lblTen = new JLabel[kho.size()];
        JLabel[] lblSoLo = new JLabel[kho.size()];

        int i = 0;
        final int fu = i;

        for (i = 0; i < kho.size(); i++) {
            checkclick.add(i, false);
            pnlKhoChua[i] = new javax.swing.JPanel();
            lblHinh[i] = new javax.swing.JLabel();
            lblTen[i] = new javax.swing.JLabel();
            switch (kho.get(i).getTrangThai()) {
                case 1:
                    lblHinh[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_lift_cart_here_60px.png"))); // NOI18N
                    break;
                case 2:
                    lblHinh[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_2.png"))); // NOI18N
                    break;
                case 3:
                    lblHinh[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png"))); // NOI18N
                    break;
                default:
                    break;
            }

            lblHinh[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            lblTen[i].setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblTen[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTen[i].setText(kho.get(i).getTenLo());

            pnlKhoChua[i].add(lblHinh[i], java.awt.BorderLayout.PAGE_START);
            pnlKhoChua[i].add(lblTen[i], java.awt.BorderLayout.CENTER);
            pnlKhoChua[i].setLayout(new java.awt.BorderLayout());
            pnlKhoChua[i].setBackground(defaulColor);
            pnlKhoChua[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlKhoChua[i]);
            pnlKhoChua[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHinh[i], javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTen[i], javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(30, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblHinh[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTen[i])
                            .addContainerGap(10, Short.MAX_VALUE))
            );

            int j = i;
            pnlKhoChua[j].addMouseListener(new MouseAdapter() {

//                @Override
//                public void mousePressed(MouseEvent e) {
//                    if (e.getClickCount() == 2) {
//
//                        if (checkclick.get(j)) {
//                            checkclick.set(j, false);
//                            lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                            e.getComponent().setBackground(defaulColor);
//                        } else {
//                            checkclick.set(j, true);
//                            e.getComponent().setBackground(selectColor);
//                            lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png")));
//                            for (int k = 0; k < kho.size(); k++) {
//                                if (k != j) {
//                                    checkclick.set(k, false);
//                                    pnlKhoChua[k].setBackground(defaulColor);
//                                    lblHinh[k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_1.png")));
//                                }
//                            }
//                        }
//                    }
//                }
                //hover
                @Override

                public void mouseEntered(MouseEvent e) {
                    if (checkclick.get(j)) {
                        return;
                    }
                    lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_lift_cart_here_60px_1.png")));
                    e.getComponent().setBackground(hoverColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_warehouse_filled_50px_3.png")));
                        e.getComponent().setBackground(selectColor);
                    } else {
                        lblHinh[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_lift_cart_here_60px.png")));
                        e.getComponent().setBackground(defaulColor);
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    vt = kho.get(j);

                    jdlNhapHang.main = new page_Main_NhapHang();
                    jdlNhapHang.dtpMainDatHang.removeAll();
                    jdlNhapHang.dtpMainDatHang.add(jdlNhapHang.main).setVisible(true);
                }
            }
            );
            scpViTri.add(pnlKhoChua[i]);
        }

        scpViTri.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scpViTri = new javax.swing.JPanel();
        btnVeKho = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scpViTri.setBackground(new java.awt.Color(255, 255, 255));
        scpViTri.setAutoscrolls(true);
        scpViTri.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        scpViTri.setMaximumSize(new java.awt.Dimension(100, 32767));
        scpViTri.setMinimumSize(new java.awt.Dimension(100, 10));

        btnVeKho.setBackground(new java.awt.Color(255, 255, 255));
        btnVeKho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVeKho.setForeground(new java.awt.Color(204, 102, 0));
        btnVeKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_circled_left_48px.png"))); // NOI18N
        btnVeKho.setContentAreaFilled(false);
        btnVeKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVeKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeKhoActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Các kho hiện tại của Vi Tuấn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpViTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVeKho, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(293, 293, 293)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 314, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVeKho, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scpViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVeKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeKhoActionPerformed
        FillBan();
    }//GEN-LAST:event_btnVeKhoActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        System.out.println(this);
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVeKho;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel scpViTri;
    // End of variables declaration//GEN-END:variables
}
