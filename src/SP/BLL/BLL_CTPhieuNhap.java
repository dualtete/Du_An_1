/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import BLL.ChuyenDoi;
import DTO.DTO_UserLogin;
import SP.DTO.DTO_ChiTietPhieuNhap;
import SP.DTO.DTO_HangTonKho;
import static SP.GUI.pnlCT_PhieuNhap.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_CTPhieuNhap {
    //Hiện thông tin của phiếu nhập và nhà cung cấp trong page_PhieuNhap

    public static void setThongTinPhieuNhap(String id) {
        System.out.println(id);
        ResultSet rs = SP.DAO.selectBy.PhieuNhapByIDPhieuNhap(id);
        String thongTinPhieuNhap = "";
        try {
            if (rs.next()) {
                System.out.println(rs.getString("IDPhieuNhap"));
                thongTinPhieuNhap += "Mã phiếu nhập:     " + rs.getString("IDPhieuNhap") + "\n";
                thongTinPhieuNhap += "Mã nhà cung cấp:   " + rs.getString("MaNCC") + "\n";
                thongTinPhieuNhap += "Tên nhà cung cấp : " + rs.getString("tenNCC") + "\n";
                thongTinPhieuNhap += "Ngày tạo:          " + ChuyenDoi.dateTimeString(rs.getTimestamp("NgayTaoPhieuNhap")) + "\n";
                thongTinPhieuNhap += "Người liên hệ:     " + rs.getString("NguoiLH") + "\n";
                thongTinPhieuNhap += "SDT:               " + rs.getString("SDTNCC") + "\n";
                thongTinPhieuNhap += "Email:             " + rs.getString("emailNCC") + "\n";
                thongTinPhieuNhap += "Địa chỉ:           " + rs.getString("DCNCC") + "\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        }
        System.out.println(thongTinPhieuNhap);
        txtThongTinDonDatHang.setText(thongTinPhieuNhap);
    }
    // insert chi tiết phiếu nhập theo mã phiếu nhập

    public static boolean insertCTPhieuNhap(String id) {

        SP.DTO.DTO_ChiTietPhieuNhap ct = new DTO_ChiTietPhieuNhap();
        getComponent(ct);
        double tongTien = ct.getGiaNhap() * ct.getSoluong();
        ct.setTongTien(tongTien);
        ct.setIDPN(id);
        if (SP.DAO.insert.insertChiTietPhieuNhap(ct) > 0) {
            System.out.println("Thêm sản phẩm vào phiếu nhập thành công");
            loadBangDanhSachSanPham();
            return true;
        }
        System.out.println("Thêm sp thất bại");
        return false;
    }

    public static void getComponent(SP.DTO.DTO_ChiTietPhieuNhap ct) {
        ct.setBarcode(txtBarcode.getText());
        ct.setDonVi(txtDonVi.getText());
        ct.setGhiChu(txtGhiChu.getText());
        ct.setGiaLe(ChuyenDoi.stringToDouble(txtGiaLeMoi.getText()));
        ct.setGiaNhap(ChuyenDoi.stringToDouble(txtGiaNhapMoi.getText()));
        ct.setGiaSi(ChuyenDoi.stringToDouble(txtGiaSiMoi.getText()));
        ct.setLanNhap(0);
//        ct.setNgayNhap("");
        ct.setNgayThem(ChuyenDoi.dateTimeString(new Date()));
        ct.setNguoiNhap("");
        ct.setNguoiThem(DTO_UserLogin.userName);
        ct.setSoluong(Integer.parseInt(spnSL.getValue().toString()));

        //THiếu tổng tiền
        // thiếu ngày nhập
        //Thiếu mã phiếu nhập
        //Thiếu mã vị trí
    }

    // lấy các phiếu nhập có trạng thái bằng 0 vào bảng danh sách sản phẩm trong page_PhieuNhap

    public static void loadBangDanhSachSanPham() {
        DefaultTableModel tblModel = (DefaultTableModel) tblDSSanPham.getModel();
        tblModel.setRowCount(0);
        ResultSet rs = SP.DAO.selectBy.SanPham_CTPhieuNhap_ByIDPN_LanNhap(SP.BLL.BLL_TaoPhieuNhap.pn.getIDPN(), 0);
        Object obj[] = new Object[5];

        try {
            while (rs.next()) {
                obj[0] = tblModel.getRowCount() + 1;
                obj[1] = rs.getString("Barcode");
                obj[2] = rs.getInt("IDCTPhieuNhap");
                obj[3] = rs.getString("TenSP");
                obj[4] = rs.getInt("SoLuong");
                tblModel.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // hiện thông tin sản phẩm vào các component

    public static boolean showThongTinSanPham(String barcode) {
        ResultSet rs = SP.DAO.selectBy.Select_SanPham_CTPhieuNhap_ByBarcode(barcode);
        try {
            if (rs.next()) {
                txtDonVi.setText(rs.getString("DonVi"));
                txtGiaLeCu.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaLe")));
                txtGiaLeMoi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaLe")));
                txtGiaNhapCu.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaNhap")));
                txtGiaNhapMoi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaNhap")));
                txtGiaSiCu.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaSi")));
                txtGiaSiMoi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaSi")));
                txtHanBH.setText(String.valueOf(rs.getInt("HanBH")));
                txtHangSX.setText(rs.getString("HangSX"));
                txtLoaiSP.setText(rs.getString("TenLoaiSP"));
                txtTTSP.setText(rs.getString("ThongTinSp"));
                txtTenSP.setText(rs.getString("TenSP"));
                String tb = rs.getTimestamp("NgayNhap") == null ? "Sản phẩm chưa được nhập lần nào" : "Lần nhập gần đây nhất vào ngày: "
                        + ChuyenDoi.dateTimeString(rs.getTimestamp("NgayNhap"));
                lblThongBaoNgayNhapGanDay.setText(tb);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean InsertSanPhamTrongKho_By_PhieuNhap(String idPN) {
        ResultSet rsCTPN = SP.DAO.selectBy.CTPhieuNhap_By_IDPN(idPN);
        double tongTien = 0;
        String ngayNhap = ChuyenDoi.dateTimeString(new Date());
        int lanNhap = SP.DAO.selectMax.maxLanNhap(idPN) + 1;
        String nguoiNhap = DTO.DTO_UserLogin.userName;
        String viTri = DTO.DTO_UserLogin.viTri;
        SP.DAO.update.UpdateCTPN(ngayNhap, lanNhap, nguoiNhap, viTri, idPN);

        int maxIdentity = 0 ;
        try {
            while (rsCTPN.next()) {
                int sl = rsCTPN.getInt("SoLuong");
                tongTien += rsCTPN.getDouble("GiaNhap") * sl;
                for (int i = 0; i < sl; i++) {
                    maxIdentity = SP.DAO.selectMax.maxIdentityHangTonKho();
                    String mavach = taoMaVach(viTri, rsCTPN.getString("barcode"), maxIdentity + 1);
                    SP.DTO.DTO_HangTonKho htk = new DTO_HangTonKho();

                    htk.setChiTiet("");
                    htk.setIDCTPN(String.valueOf(rsCTPN.getInt("IDCTPhieuNhap")));
                    htk.setIDViTriHienTai(viTri);
                    htk.setIdHangTonKho(maxIdentity);
                    htk.setMaVach(mavach);
                    htk.setSeriSP("Chua Nhap");
                    htk.setTrangThai(false);

                    if (SP.DAO.insert.sanPhamTrongKho(htk) < 1) {
                        System.out.println("Chưa nhập được sản phẩm " + rsCTPN.getString("barcode") + " vào kho!");
                        continue;
                    }else{
                        System.out.println("Nhập thành công sản phẩm : " + rsCTPN.getString("barcode") + " Vào kho");
                    }
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        SP.DAO.update.UpdatePhieuNhap(tongTien, idPN);
        return true;
    }

    public static String taoMaVach(String idViTri, String barcode, int identity) {
        String maVach = "VT-" + idViTri + barcode + "-" + identity;
        return maVach;
    }
}
