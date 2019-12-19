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
import java.io.File;
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
        //Cho boder của internal = 0
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
    
    public static pnlHangTonKho TonKho;

    private void FillBan() {
        btnThemLo.setVisible(false);
        btnThemKho.setVisible(true);
        btnVeKho.setVisible(false);
        
        lblTitle.setText("CÁC KHO HIỆN TẠI CỦA CÔNG TY");
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
                    System.out.println(vt);
                    sound.sound_huy.sound(new File("click.wav"));

                }
            }
            );
            scpViTri.add(pnlKhoChua[i]);
        }

        scpViTri.updateUI();

    }

    public void fillLo(String lo) {
        btnThemLo.setVisible(true);
        btnThemKho.setVisible(false);
        btnVeKho.setVisible(true);
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
                    
                    if (TonKho == null) {
                       TonKho = new pnlHangTonKho();
                    }
                   
                   pnlAddpnl.removeAll();
                   pnlAddpnl.add(TonKho).setVisible(true);
                   pnlAddpnl.revalidate();
                   pnlAddpnl.repaint();
                   sound.sound_huy.sound(new File("click.wav"));
                   
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

        pnlAddpnl = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnThemKho = new javax.swing.JButton();
        btnThemLo = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnVeKho = new javax.swing.JButton();
        scpViTri = new javax.swing.JPanel();

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

        pnlAddpnl.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddpnl.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnThemKho.setBackground(new java.awt.Color(0, 102, 153));
        btnThemKho.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThemKho.setText("THÊM KHO");
        btnThemKho.setBorder(null);
        btnThemKho.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanel2.add(btnThemKho);

        btnThemLo.setBackground(new java.awt.Color(0, 102, 153));
        btnThemLo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThemLo.setText("THÊM LÔ");
        btnThemLo.setBorder(null);
        btnThemLo.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanel2.add(btnThemLo);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("CÁC KHO HIỆN TẠI CỦA CÔNG TY");

        btnVeKho.setBackground(new java.awt.Color(255, 255, 255));
        btnVeKho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVeKho.setForeground(new java.awt.Color(204, 102, 0));
        btnVeKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconHuy/icons8_return_16px.png"))); // NOI18N
        btnVeKho.setText("Quay lại");
        btnVeKho.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnVeKho.setContentAreaFilled(false);
        btnVeKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVeKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVeKho, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnVeKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAddpnl.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        scpViTri.setBackground(new java.awt.Color(255, 255, 255));
        scpViTri.setAutoscrolls(true);
        scpViTri.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        scpViTri.setMaximumSize(new java.awt.Dimension(100, 32767));
        scpViTri.setMinimumSize(new java.awt.Dimension(100, 10));
        pnlAddpnl.add(scpViTri, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlAddpnl, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVeKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeKhoActionPerformed
        FillBan();
    }//GEN-LAST:event_btnVeKhoActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        System.out.println(this);
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemKho;
    private javax.swing.JButton btnThemLo;
    private javax.swing.JButton btnVeKho;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAddpnl;
    private javax.swing.JPanel scpViTri;
    // End of variables declaration//GEN-END:variables
}
