/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Admin
 */
public class BanHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form Add
     */
    public BanHang() {
        initComponents();
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

        pnlAdd = new javax.swing.JPanel();
        tbpMatHang = new javax.swing.JTabbedPane();
        pnlHangHoa = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSanPham1 = new javax.swing.JLabel();
        lblSanPham2 = new javax.swing.JLabel();
        lblSanPham3 = new javax.swing.JLabel();
        lblSanPham4 = new javax.swing.JLabel();
        lblSanPham5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSanPham6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblSanPham7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSanPham8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblSanPham9 = new javax.swing.JLabel();
        lblSanPham10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTamTinh = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        pnlTieuDe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1430, 910));

        pnlAdd.setBackground(new java.awt.Color(255, 255, 255));
        pnlAdd.setPreferredSize(new java.awt.Dimension(960, 780));

        tbpMatHang.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        pnlHangHoa.setBackground(new java.awt.Color(255, 255, 255));
        pnlHangHoa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlHangHoa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("750,000");
        pnlHangHoa.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 30, 70, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("12,750,000");
        pnlHangHoa.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("1,750,000");
        pnlHangHoa.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 70, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("3,750,000");
        pnlHangHoa.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 70, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("12,750,000");
        pnlHangHoa.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 240, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("12,750,000");
        pnlHangHoa.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        lblSanPham1.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3_1.jpg"))); // NOI18N
        lblSanPham1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 202, 178));

        lblSanPham2.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        lblSanPham2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 178));

        lblSanPham3.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        lblSanPham3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 202, 178));

        lblSanPham4.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7.jpg"))); // NOI18N
        lblSanPham4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 202, 178));

        lblSanPham5.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9.jpg"))); // NOI18N
        lblSanPham5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 202, 178));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("12,750,000");
        pnlHangHoa.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("BÌNH LỌC NƯỚC KARON");
        jLabel2.setToolTipText("");
        pnlHangHoa.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 210, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("12,750,000");
        pnlHangHoa.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("750,000");
        pnlHangHoa.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("MÁY XAY SINH TỐ PANASONIC");
        jLabel8.setToolTipText("");
        pnlHangHoa.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("TỦ LẠNH TOSHIBA");
        jLabel9.setToolTipText("");
        pnlHangHoa.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setText("MÁY GIẶT PANASONIC");
        jLabel10.setToolTipText("");
        pnlHangHoa.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("BÌNH NÓNG LẠNH FERROLL");
        jLabel11.setToolTipText("");
        pnlHangHoa.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, -1, -1));

        lblSanPham6.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bep-tu-midea-mi-b2118dh-17-300x300_1.jpg"))); // NOI18N
        lblSanPham6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 178));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("BẾP ĐIỆN MEDISA");
        jLabel12.setToolTipText("");
        pnlHangHoa.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        lblSanPham7.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.jpg"))); // NOI18N
        lblSanPham7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 202, 178));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("MACBOOK AIR");
        jLabel13.setToolTipText("");
        pnlHangHoa.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        lblSanPham8.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8.jpg"))); // NOI18N
        lblSanPham8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 202, 178));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 153));
        jLabel14.setText("NỒI CƠM ĐIỆN SAWACO");
        jLabel14.setToolTipText("");
        pnlHangHoa.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 153));
        jLabel17.setText("LOA KẸO KÉO BEAT BOX");
        jLabel17.setToolTipText("");
        pnlHangHoa.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, -1, -1));

        lblSanPham9.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/10.jpg"))); // NOI18N
        lblSanPham9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 202, 178));

        lblSanPham10.setBackground(new java.awt.Color(0, 0, 255));
        lblSanPham10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.jpg"))); // NOI18N
        lblSanPham10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlHangHoa.add(lblSanPham10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 240, 202, 178));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("MÁY LẠNH HAVAWA");
        jLabel18.setToolTipText("");
        pnlHangHoa.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 420, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("12,750,000");
        pnlHangHoa.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        tbpMatHang.addTab("SẢN PHẨM", pnlHangHoa);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1415, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        tbpMatHang.addTab("SẢN PHẨM BÁN CHẠY", jPanel1);

        btnTamTinh.setBackground(new java.awt.Color(255, 204, 51));
        btnTamTinh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnTamTinh.setForeground(new java.awt.Color(255, 255, 255));
        btnTamTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_duration_finance_50px.png"))); // NOI18N
        btnTamTinh.setText("TẠM TÍNH");
        btnTamTinh.setBorder(null);

        btnThanhToan.setBackground(new java.awt.Color(255, 0, 51));
        btnThanhToan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_shopping_cart_50px.png"))); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.setBorder(null);

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("Cái này e test thử thôi á");

        pnlTieuDe.setBackground(new java.awt.Color(255, 255, 255));
        pnlTieuDe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 153)));
        pnlTieuDe.setForeground(new java.awt.Color(0, 102, 153));
        pnlTieuDe.setPreferredSize(new java.awt.Dimension(404, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("DANH SÁCH CÁC MẶT HÀNG");

        javax.swing.GroupLayout pnlTieuDeLayout = new javax.swing.GroupLayout(pnlTieuDe);
        pnlTieuDe.setLayout(pnlTieuDeLayout);
        pnlTieuDeLayout.setHorizontalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTieuDeLayout.setVerticalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jLabel23.setBackground(new java.awt.Color(255, 255, 51));
        jLabel23.setText("jLabel23");
        jLabel23.setOpaque(true);

        javax.swing.GroupLayout pnlAddLayout = new javax.swing.GroupLayout(pnlAdd);
        pnlAdd.setLayout(pnlAddLayout);
        pnlAddLayout.setHorizontalGroup(
            pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
            .addComponent(tbpMatHang)
            .addGroup(pnlAddLayout.createSequentialGroup()
                .addGroup(pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddLayout.createSequentialGroup()
                        .addGap(1092, 1092, 1092)
                        .addComponent(btnTamTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddLayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(398, 398, 398)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlAddLayout.createSequentialGroup()
                .addGap(519, 519, 519)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAddLayout.setVerticalGroup(
            pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddLayout.createSequentialGroup()
                .addComponent(pnlTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnTamTinh)
                .addGap(18, 18, 18)
                .addGroup(pnlAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel22))
                    .addComponent(btnThanhToan))
                .addGap(36, 36, 36)
                .addComponent(tbpMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTamTinh;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSanPham1;
    private javax.swing.JLabel lblSanPham10;
    private javax.swing.JLabel lblSanPham2;
    private javax.swing.JLabel lblSanPham3;
    private javax.swing.JLabel lblSanPham4;
    private javax.swing.JLabel lblSanPham5;
    private javax.swing.JLabel lblSanPham6;
    private javax.swing.JLabel lblSanPham7;
    private javax.swing.JLabel lblSanPham8;
    private javax.swing.JLabel lblSanPham9;
    private javax.swing.JPanel pnlAdd;
    private javax.swing.JPanel pnlHangHoa;
    private javax.swing.JPanel pnlTieuDe;
    private javax.swing.JTabbedPane tbpMatHang;
    // End of variables declaration//GEN-END:variables
}
