/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_CTHoaDon;
import DTO.DTO_HoaDon;
import DTO.DTO_KhachHang;
import DTO.MyComboBox;
import GUI.ThongBao;
import GUI.jdlAddKhachHang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static GUI.page_BanHang.*;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class BLL_BanHang {

    public static DTO.DTO_HoaDon hd;
    public static DTO.DTO_CTHoaDon ct;

//    public static void loadDSSanPham(JTable tbl) {
//        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
//        Object obj[] = new Object[4];
//        tblModel.setRowCount(0);
//        ResultSet rs = DAO.select.banHangSP();
//        try {
//            while (rs.next()) {
//                obj[0] = rs.getString("masp");
//                obj[1] = rs.getString("TenSP");
//                obj[2] = rs.getString("giale");
//                tblModel.addRow(obj);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BLL_BanHang.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void loadDSHoaDon() {
//        DefaultTableModel tbModel = (DefaultTableModel) BanHang.tblDSHoaDon.getModel();
//        Object obj[] = new Object[6];
//        tbModel.setRowCount(0);
//        ResultSet rs = DAO.select.dsHoaDon();
//        try {
//            while (rs.next()) {
//                obj[0] = rs.getString("IDHD");
//                obj[1] = rs.getString("IDNV");
//                obj[2] = rs.getString("IDKH");
//                obj[3] = ChuyenDoi.GetNgay(rs.getDate("NgayTaoHD"));
//                obj[4] = rs.getString("TrangThai");
//                tbModel.addRow(obj);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BLL_BanHang.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void loadCBBNhanVien(JComboBox cbb) {
//        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
//        cbbModel.removeAllElements();
//        String id = TTTaiKhoan.IDNhanVien;
//        ResultSet rs = DAO.selectBy.NhanVien(id);
//        try {
//            while (rs.next()) {
//                MyComboBox mycbb = new MyComboBox(rs.getString("IDNV"), rs.getString("HoTen"));
//                cbbModel.addElement(mycbb);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Lỗi load combobox");
//        }
//    }
    //-----------------------------------------------------------------------------------------------
    public static boolean showThongTinKhachHang(String tt) {
        ResultSet rs = DAO.selectBy.KhachHang_By_SDT_ID(tt);
        DTO.DTO_KhachHang kh = new DTO_KhachHang();
        try {
            if (rs.next()) {
                kh.setDC(rs.getString("DC"));
                kh.setEmail(rs.getString("email"));
                kh.setGhiChu(rs.getString("ghichu"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setIDKH(rs.getString("IDKH"));
                kh.setIDLoaiKH(String.valueOf(rs.getInt("IDLoaiKH")));
                kh.setIDTK(rs.getInt("IDTK"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setNgayThem(rs.getDate("NgayThem"));
                kh.setSDT(rs.getString("SDT"));
                kh.setTrangThai(rs.getBoolean("TrangThai"));
                setComponentTTKH(kh);
                return true;
            } else {
                ThongBao.ThongBao("Chưa có thông tin khách hàng", "Thông báo");
                return false;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBao("Chưa có thông tin khách hàng", "Thông báo");
            return false;
        }
    }

    public static void setComponentTTKH(DTO_KhachHang kh) {

        txtDC.setText(kh.getDC());
        txtEmail.setText(kh.getEmail());
        txtIDKH.setText(kh.getIDKH());
        txtNgaySinh.setDate(kh.getNgaySinh());
        txtSDT.setText(kh.getSDT());
        txtTenKH.setText(kh.getHoTen());
        radNam.setSelected(kh.isGioiTinh());
        radNu.setSelected(kh.isGioiTinh());
    }

    public static void showThongTinBaoHanh() {
        ResultSet rs = DAO.select.BHKhachHang(true);
        String thongTin = "CÁC GÓI ĐANG ĐƯỢC ÁP DỤNG\n";
        try {
            while (rs.next()) {
                thongTin += "***************************\n";
                thongTin += "Gói bảo hành: " + rs.getString("IDBHKH") + "\n";
                thongTin += "Thời gian bảo hành: " + String.valueOf(rs.getInt("ThoiGian")) + rs.getString("DonVi") + "\n";
                thongTin += "Chính sách: " + rs.getString("ChinhSach") + "\n";

            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtCacGoiBaoHanh.setText(thongTin);

    }

    public static boolean layThongTinSP(String maVach) {
        ResultSet rs = SP.DAO.selectBy.LayHangTonKho(maVach);
        try {
            if (rs.next()) {
                txtBarcode.setText(rs.getString("masp"));
                txtGiaBan.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaLe")));
                txtGiamGia.setText("0");
                txtTenSP.setText(rs.getString("TenSP"));
                txtThongTinSanPham.setText(rs.getString("ThongTinSP"));
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public static void loadThongTinHangTonKho(String id) {
        int sl = 1;
        String barcode = "";
        DefaultTableModel tblModel = (DefaultTableModel) tblHoaDon.getModel();

        DefaultTableModel tblCTModel = (DefaultTableModel) tblCTHoaDon.getModel();
        Object ctHoaDon[] = new Object[4];
        //Bảng hiển thị ra màn hình tblmodel

        //Bảng không hiển thị tblmodel1
        ResultSet rs = SP.DAO.selectBy.LayHangTonKho(id);
        Object rows[] = new Object[10];
        try {
            if (rs.next()) {
                // them vào bảng chi tiết hóa đơn
                if (tblCTModel.getRowCount() > 0) {
                    for (int i = 0; i < tblCTHoaDon.getRowCount(); i++) {
                        System.out.println(tblCTHoaDon.getValueAt(i, 2).toString());
                        System.out.println(id);
                        if (tblCTHoaDon.getValueAt(i, 2).toString().trim().equals(id.trim())) {
                            GUI.ThongBao.ThongBao("Sản phẩm đã có trong hoá đơn!", "Thông báo!");
                            return;
                        }
                    }
                }
                ctHoaDon[0] = rs.getString("masp");
                ctHoaDon[1] = rs.getInt("IDCTPN");
                ctHoaDon[2] = rs.getString("MaVach");
                tblCTModel.addRow(ctHoaDon);

                if (tblModel.getRowCount() > 0) {
                    for (int i = 0; i < tblModel.getRowCount(); i++) {
                        double giaCu = ChuyenDoi.stringToDouble(tblHoaDon.getValueAt(i, 2).toString());
                        if (rs.getString("masp").equals(tblHoaDon.getValueAt(i, 6).toString()) && ChuyenDoi.stringToDouble(txtGiaBan.getText()) == giaCu
                                && rs.getInt("IDCTPN") == Integer.parseInt(tblHoaDon.getValueAt(i, 9).toString().trim())) {
                            sl = Integer.parseInt(tblHoaDon.getValueAt(i, 3).toString());
                            sl++;
                            double tongTien = ChuyenDoi.stringToDouble(tblHoaDon.getValueAt(i, 4).toString());
                            tongTien += ChuyenDoi.stringToDouble(txtGiaBan.getText());
                            tblHoaDon.setValueAt(sl, i, 3);
                            tblHoaDon.setValueAt(ChuyenDoi.doubleToString(tongTien), i, 4);
                            return;
                        }
                    }
                }
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("tenSp");
                rows[2] = txtGiaBan.getText();
                rows[3] = sl;
                rows[4] = ChuyenDoi.doubleToString(ChuyenDoi.stringToDouble(txtGiaBan.getText()) * sl);
                rows[5] = cbb.getSelectedItem();
                rows[6] = rs.getString("masp");
                rows[7] = rs.getString("MaVach");
                rows[8] = rs.getString("seriSP");
                rows[9] = rs.getString("IDCTPN");
                tblModel.addRow(rows);
                //System.out.println("Đã thêm mới");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void setTongTien() {
        double tongTien = 0;
        for (int i = 0; i < tblHoaDon.getRowCount(); i++) {
            double tien = ChuyenDoi.stringToDouble(tblHoaDon.getValueAt(i, 4).toString());
            tongTien += tien;
        }
        lblTongTien.setText(ChuyenDoi.doubleToString(tongTien) + "đ");
    }

    public static boolean thanhToan() {

        if (!luuHoaDon(true)) {
            return false;
        }

        if (SP.DAO.update.updateHoaDon(hd.getIdHoaDon()) <= 0) {
            return false;
        }
        
        
        
        for (int i = 0; i < tblCTHoaDon.getRowCount(); i++) {
            String maVach = tblCTHoaDon.getValueAt(i, 2).toString();
            DAO.delete.xoaHangTonKho(maVach);
            
            
        }
        
        
        
        
        
        
        DefaultTableModel hdmode = (DefaultTableModel) tblHoaDon.getModel();
        DefaultTableModel ctMode = (DefaultTableModel) tblCTHoaDon.getModel();
        hdmode.setRowCount(0);
        ctMode.setRowCount(0);

        return true;

    }

    public static boolean luuHoaDon(boolean trangThai) {
        hd = new DTO_HoaDon();
        ct = new DTO_CTHoaDon();
        String idhd = taoIDHD();
        hd.setIdHoaDon(idhd);
        hd.setIdKH(txtIDKH.getText().trim());
        hd.setIdTK(DTO.DTO_UserLogin.IDTK);
        hd.setNgayTaoHD(new Date());
        hd.setTongTien(ChuyenDoi.stringToDouble(lblTongTien.getText()));
        hd.setTrangThai(trangThai);

        System.out.println(hd.getIdHoaDon() + "-" + hd.getIdKH() + "-" + hd.getIdTK() + "-" + hd.getNgayTaoHD() + "-" + hd.getTongTien());
        if (DAO.insert.ThemHoaDon(hd) <= 0) {
            if (txtSDT.getText().length() == 0) {
                GUI.ThongBao.ThongBao("Bạn chưa thêm thông tin khách hàng!", "Thông báo!");
                return false;
            }
            GUI.ThongBao.ThongBao("Hoá đơn chưa đầy đủ thông tin!", "Thông báo!");
            System.out.println("Chưa tạo được hóa đơn");
            return false;
        }

        int rows = tblHoaDon.getRowCount();
        System.out.println(rows);
        for (int i = 0; i < rows; i++) {
            ct.setBarcode(tblHoaDon.getValueAt(i, 6).toString());
            ct.setDonGia(ChuyenDoi.stringToDouble(tblHoaDon.getValueAt(i, 2).toString()));
            ct.setGhiChu("");
            ct.setIdBH(tblHoaDon.getValueAt(i, 5).toString());
            String idCT = hd.getIdHoaDon() + "-" + (i + 1);
            ct.setIdCTHD(idCT);
            ct.setIdCTPhieuNhap(tblHoaDon.getValueAt(i, 9).toString());
            ct.setIdHD(hd.getIdHoaDon());
            ct.setSl(Integer.parseInt(tblHoaDon.getValueAt(i, 3).toString()));
           
            double tongTien = ct.getDonGia() * ct.getSl();
            ct.setThanhTien(tongTien);
            System.out.println(ct.getBarcode() + "-" + ct.getGhiChu() + "-" + ct.getIdBH() + "-" + ct.getIdCTHD() + "-"
                    + ct.getIdCTPhieuNhap() + "-" + ct.getIdHD() + "-" + ct.getDonGia() + "-" + ct.getSl() + "-" + ct.getThanhTien());
            if (DAO.insert.ThemCTHoaDon(ct) <= 0) {
                System.out.println("Lỗi thêm chi tiết hóa đơn");
                return false;
            }
        }

        return true;

    }

    public static String taoIDHD() {
        ResultSet rs = DAO.select.LayTop1IDHD();
        String ngayHienTai = ChuyenDoi.GetNgay(new Date()).replace("/", "");
        int id = 1;
        String idMoiTao = "HD-" + ngayHienTai + "-" + "0001";
        try {
            if (rs.next()) {
                String str = rs.getString("IDHD");
                String ngay = str.split("-")[1].trim();
                if (ngay.equals(ngayHienTai)) {
                    id = Integer.parseInt(str.split("-")[2].trim());
                    id+= 2;
                }

                idMoiTao = "HD-" + ngayHienTai + "-" + ChuyenDoi.taoChuoiCacSo0(id, 4);

            }
        } catch (SQLException ex) {
            System.out.println("Lỗi lấy mã hóa đơn!");

        }
        return idMoiTao;
    }

    public static boolean xoaSanPham(String id) {
        DefaultTableModel tblCT = (DefaultTableModel) tblCTHoaDon.getModel();
        DefaultTableModel tblHD = (DefaultTableModel) tblHoaDon.getModel();
        for (int i = 0; i < tblCTHoaDon.getRowCount(); i++) {
            if (tblCTHoaDon.getValueAt(i, 2).toString().equals(id)) {
                String barcode = tblCT.getValueAt(i, 0).toString();
                tblCT.removeRow(i);

                for (int j = 0; j < tblHD.getRowCount(); j++) {
                    int sl = (int) tblHD.getValueAt(j, 3);
                    
                    
                    
                    if (sl == 1 && tblHD.getValueAt(j, 6).toString().equals(barcode) ) {
                        tblHD.removeRow(j);
                        return true;
                    }
                    if (tblHD.getValueAt(j, 6).toString().equals(barcode)) {
                        sl--;
                        tblHD.setValueAt(sl, j, 6);
                        return true;
                    }
                }

            }

        }
        return false;
    }

    public static void open() {
        showThongTinBaoHanh();
    }
}
