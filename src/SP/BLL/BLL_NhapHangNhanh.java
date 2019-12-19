/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import static SP.GUI.pnlHangTonKho.*;

import BLL.ChuyenDoi;
import DTO.DTO_NhaCungCap;
import GUI.ThongBao;
import SP.DTO.DTO_ChiTietPhieuNhap;
import SP.DTO.DTO_HangTonKho;
import SP.DTO.DTO_PhieuNhap;
import SP.DTO.DTO_SanPham;
import SP.GUI.jdlXoaCTPhieuNhap;
import SP.GUI.page_ViTri;
import SP.GUI.pnlHangTonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.DATA_CONVERSION;

/**
 *
 * @author bumte
 */
public class BLL_NhapHangNhanh {

    public static DTO.DTO_NhaCungCap ncc = new DTO_NhaCungCap();
    public static SP.DTO.DTO_PhieuNhap pn = new DTO_PhieuNhap();
    public static SP.DTO.DTO_ChiTietPhieuNhap ct = new DTO_ChiTietPhieuNhap();
    public static SP.DTO.DTO_SanPham sp = new DTO_SanPham();
    
    public static DefaultTableModel tblDanhMucSPModel = (DefaultTableModel) tblDanhMucSanPham.getModel();
    public static DefaultTableModel tblCTSPModel = (DefaultTableModel) tblCTSanPham.getModel();
    public static DefaultTableModel tblHeThong = (DefaultTableModel) tblHangTonKhoHide.getModel();
    public static int maxID = 0;
    public static double tongTien = 0;

    public static boolean LayTTNCC(String idNCC) {
        ResultSet rs = DAO.selectBy.NhaCungCap(idNCC);
        try {
            if (rs.next()) {
                ncc.setDC(rs.getString("DC"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setGhiChu(rs.getString("GhiChu"));
                ncc.setID(rs.getString("IDNCC"));
                ncc.setLoaiHinh(rs.getString("loaiHinh"));
                ncc.setMSThue(rs.getString("MSThue"));
                ncc.setNgayThem(ChuyenDoi.GetNgay(rs.getDate("ngayThem")));
                ncc.setNguoiLH(rs.getString("NguoiLH"));
                ncc.setNhomNCC(rs.getString("NhomNCC"));
                ncc.setSDT(rs.getString("SDT"));
                ncc.setTKNganHang(rs.getString("TKNganHang"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setTenNH(rs.getString("TenNganHang"));
                ncc.setTrangThai(rs.getBoolean("TrangThai"));
                ncc.setTrangWeb(rs.getString("TrangWeb"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_NhapHangNhanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean layTTSP(String barcode) {
        ResultSet rs = SP.DAO.selectBy.checkBarcodeSanPham(barcode);
        try {
            if (rs.next()) {
                sp.setBarcode(barcode);
                sp.setHanBH(rs.getInt("HanBH"));
                sp.setHangSX(rs.getString("HangSX"));
                sp.setIdLoaiSP(String.valueOf(rs.getInt("idLoaiSP")));
                sp.setNgayThem(rs.getTimestamp("NgayThem"));
                sp.setNguoiThem(rs.getInt("NguoiThem"));
                sp.setTTBaoHanh(rs.getString("ThongTinBH"));
                sp.setTTSanPham(rs.getString("ThongTinSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi lấy thông tin sản phẩm");
            return false;
        }

        return false;

    }

    public static boolean LayGiaSP(String barcode) {
        ResultSet rs = SP.DAO.selectBy.Select_SanPham_CTPhieuNhap_ByBarcode(barcode);
        try {
            if (rs.next()) {
                txtGiaNhap.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaNhap")));
                txtGiaSi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaSi")));
                txtGiaLe.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaLe")));
                return true;
            }
        } catch (SQLException ex) {

        }
        txtGiaNhap.setText("SP Chưa được nhập");
        txtGiaSi.setText("SP Chưa được nhập");
        txtGiaLe.setText("SP Chưa được nhập");
        return false;
    }

    public static boolean luuVaoBangDanhMucSanPhan(String barcode, String tenSP, String maVach, double giaNhap, double giaSi, double giaLe) {

        if (tblHangTonKhoHide.getRowCount() > 0) {
            maxID = ((int) tblHangTonKhoHide.getValueAt(tblHangTonKhoHide.getRowCount() - 1, 1)) + 1;
        }
        
        Object rows[] = new Object[10];
        int sl = 1;
        if (!luuVaoBangChiTietSP(maVach, tenSP, giaNhap, giaSi, giaLe,barcode)) {
            return false;
        }
        if (tblDanhMucSPModel.getRowCount() > 0) {
            for (int i = 0; i < tblDanhMucSPModel.getRowCount(); i++) {
                if (tblDanhMucSPModel.getValueAt(i, 1).toString().trim().equals(barcode)) {
                    sl = (int) tblDanhMucSPModel.getValueAt(i, 3);
                    sl++;
                    tblDanhMucSPModel.setValueAt(sl, i, 3);
                    return true;
                }
            }
        }
        rows[0] = tblDanhMucSPModel.getRowCount() + 1;
        rows[1] = barcode;
        rows[2] = tenSP;
        rows[3] = sl;
        rows[4] = txtGiaNhap.getText();
        rows[5] = txtGiaSi.getText();
        rows[6] = txtGiaLe.getText();
        tblDanhMucSPModel.addRow(rows);

        return true;
    }

    public static boolean luuVaoBangChiTietSP(String maVach, String tenSP, double giaNhap, double giaSi, double giaLe, String barcode) {
        if (!kiemTraMaVach(maVach)) {
            return false;
        }

        Object rows[] = new Object[7];
        rows[0] = tblCTSPModel.getRowCount() + 1;
        rows[1] = maVach;
        rows[2] = tenSP;
        rows[3] = ChuyenDoi.doubleToString(giaNhap);
        rows[4] = ChuyenDoi.doubleToString(giaSi);
        rows[5] = ChuyenDoi.doubleToString(giaLe);
        rows[6] = barcode;
        tblCTSPModel.addRow(rows);
        tongTien += giaNhap;
        lblTongTien.setText(ChuyenDoi.doubleToString(tongTien));
        Object rowsHide[] = new Object[3];

        rowsHide[0] = txtSKU.getText();
        rowsHide[1] = maxID;
        SP.BLL.BLL_NhapHangNhanh.tblHeThong.addRow(rowsHide);
        return true;
    }

    public static void layDuLieuHeThong() {
        Object rows[] = new Object[3];
        tblHeThong.setRowCount(0);
        ResultSet rs = SP.DAO.selectBy.HangTonKhoTrue();
        try {
            while (rs.next()) {
                rows[0] = rs.getString("MaVach");
                rows[1] = rs.getInt("ID");
                tblHeThong.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_NhapHangNhanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String taoMaVach(String barcode, String idVT) {
        maxID = ((int) tblHangTonKhoHide.getValueAt(tblHangTonKhoHide.getRowCount() - 1, 1)) + 1;
        String maVach = "VT-" + idVT + "-" + barcode + "-" + (maxID);
        return maVach;
    }

    public static boolean kiemTraMaVach(String maVach) {
        if (tblCTSPModel.getRowCount() > 0) {
            for (int i = 0; i < tblCTSPModel.getRowCount(); i++) {
                if (tblCTSPModel.getValueAt(i, 1).toString().equals(maVach)) {
                    return false;
                }
            }
        }
        if (tblDanhMucSPModel.getRowCount() > 0) {
            for (int i = 0; i < tblDanhMucSPModel.getRowCount(); i++) {
                if (tblDanhMucSPModel.getValueAt(i, 1).toString().equals(maVach)) {
                    return false;
                }
            }
        }

        if (tblHeThong.getRowCount() > 0) {
            for (int i = 0; i < tblHeThong.getRowCount(); i++) {
                if (tblHeThong.getValueAt(i, 0).toString().equals(maVach)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean check() {
        if (cbbNCC.getSelectedIndex() == 0) {
            ThongBao.ThongBao("Chưa chọn nhà cung cấp", "Thông báo");
            return false;
        }
        if (tblCTSPModel.getRowCount() == 0) {
            System.out.println("Chưa nhập sản phẩm");
            return false;
        }

        return true;
    }

    public static boolean NhapHang(boolean trangThai) {
        if (!check()) {
            return false;
        }
        DTO_PhieuNhap pn = new DTO_PhieuNhap();
        DTO_ChiTietPhieuNhap ct = new DTO_ChiTietPhieuNhap();
        pn.setIDNCC(ncc.getID());
        pn.setIDPN("PN-" + ncc.getID() + ChuyenDoi.dateTimeString(new Date()).replace("/", "").replace(":", ""));
        pn.setNgayTao(ChuyenDoi.dateTimeString(new Date()));
        pn.setNguoiTao(DTO.DTO_UserLogin.IDTK);
        pn.setTongTien(ChuyenDoi.stringToDouble(lblTongTien.getText().replace("đ", "")));
        pn.setTrangThai(0);
        if (SP.DAO.insert.insertPhieuNhap(pn) <= 0) {
            System.out.println("Lỗi! Chưa tạo được phiếu nhập");
            return false;
        }
        for (int i = 0; i < tblDanhMucSPModel.getRowCount(); i++) {
            ct.setBarcode(sp.getBarcode());
            ct.setDonVi("Cái");
            ct.setGhiChu("Nhập nhanh");
            ct.setGiaLe(ChuyenDoi.stringToDouble(tblDanhMucSPModel.getValueAt(i, 5).toString()));
            ct.setGiaNhap(ChuyenDoi.stringToDouble(tblDanhMucSPModel.getValueAt(i, 3).toString()));
            ct.setGiaSi(ChuyenDoi.stringToDouble(tblDanhMucSPModel.getValueAt(i, 4).toString()));
            ct.setIDPN(pn.getIDPN());
            ct.setIDViTri(page_ViTri.vt.getIDViTri());
            ct.setLanNhap(1);
            ct.setNgayNhap(ChuyenDoi.dateTimeString(new Date()));
            ct.setNgayThem(ChuyenDoi.dateTimeString(new Date()));
            ct.setNguoiNhap(DTO.DTO_UserLogin.userName);
            ct.setNguoiThem(DTO.DTO_UserLogin.userName);
            ct.setSoluong(Integer.parseInt(tblDanhMucSPModel.getValueAt(i, 3).toString()));
            ct.setTongTien(ct.getSoluong() * ct.getGiaNhap());
            if (SP.DAO.insert.insertChiTietPhieuNhap(ct) <= 0) {
                System.out.println("Lỗi! thêm Ct phiếu nhập");
                if (SP.DAO.delete.delPhieuNhap_CTPhieuNhap(pn.getIDPN()) > 0) {
                    System.out.println("Đã xóa ct phiếu nhập và phiếu nhập ");
                }
                return false;
            }           
            
        }
        
        for (int i = 0; i < tblCTSPModel.getRowCount(); i++) {
            String barcode = tblCTSPModel.getValueAt(i, 6).toString();
            System.out.println(barcode);
            ResultSet rs = SP.DAO.selectBy.check_Barcode_CTPhieuNhap(pn.getIDPN(), barcode );
            int IDCTPN = 0;
            String maVach = tblCTSPModel.getValueAt(i, 1).toString();
            String seriSP = tblCTSPModel.getValueAt(i, 1).toString();
            double giaLe = ChuyenDoi.stringToDouble(tblCTSPModel.getValueAt(i, 5).toString());
            double giaSi = ChuyenDoi.stringToDouble(tblCTSPModel.getValueAt(i, 4).toString());
            try {
                if (rs.next()) {
                    IDCTPN = rs.getInt("IDCTPhieuNhap");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BLL_NhapHangNhanh.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            SP.DTO.DTO_HangTonKho htk = new DTO_HangTonKho(maVach, seriSP,String.valueOf(IDCTPN),"",barcode,ct.getIDViTri() ,true, giaLe, giaSi);
            if (SP.DAO.insert.sanPhamTrongKho(htk) <= 0) {
                System.out.println("Lỗi thêm vào bảng tồn kho");
                if (SP.DAO.delete.xoaSPTonKho_ByIDPN(pn.getIDPN()) > 0) {
                    System.out.println("Đã xóa các sản phẩm vừa thêm vào bảng hàng tồn kho");
                }else{
                    System.out.println("Lỗi! xóa các sản phẩm vừa thêm vào bảng hàng tồn kho");
                }
                
                if (SP.DAO.delete.delPhieuNhap_CTPhieuNhap(pn.getIDPN()) > 0) {
                     System.out.println("Đã xóa các phiếu nhập và chi tiết phiếu nhập vừa thêm");
                }else{
                    System.out.println("Lỗi! xóa các phiếu nhập và chi tiết phiếu nhập vừa thêm");
                }
                
                
                return false;
            }
            
        }
        
        return true;

    }

}
