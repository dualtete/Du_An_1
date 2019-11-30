/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import BLL.ChuyenDoi;
import DTO.DTO_UserLogin;
import DTO.MyComboBox;
import SP.DTO.DTO_ChiTietPhieuNhap;

import SP.DTO.DTO_HangTonKho;
import static SP.GUI.pnlCT_PhieuNhap.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
        // Kiểm tra trùng mã barcode 

        SP.DTO.DTO_ChiTietPhieuNhap ct = new DTO_ChiTietPhieuNhap();
        getComponent(ct);
        double tongTien = ct.getGiaNhap() * ct.getSoluong();
        ct.setTongTien(tongTien);
        ct.setIDPN(id);
        System.out.println(id + "    " + ct.getBarcode());
        ResultSet checkBarcode = SP.DAO.selectBy.check_Barcode_CTPhieuNhap(id, ct.getBarcode());
        ct.setGhiChu("\n(*" + ChuyenDoi.dateTimeString(new Date()) + "--" + txtGhiChu.getText() + "*)\n");
        try {
            if (!checkBarcode.next()) {
                System.out.println(checkBarcode.next());
                //Nếu chưa có chi tiết phiếu nhập của sản phẩm này thì tạo mới

                if (SP.DAO.insert.insertChiTietPhieuNhap(ct) > 0) {
                    System.out.println("Thêm sản phẩm vào phiếu nhập thành công");
                    loadBangDanhSachSanPham();
                    return true;
                } else {
                    System.out.println("Thêm sản phẩm vào phiếu nhập thất bại");
                    return false;
                }

            } else {

                // nếu đã có sản phẩm trong phiếu nhập rồi thì cập nhật số lượng
                int sl = checkBarcode.getInt("SoLuong") + ct.getSoluong();
                tongTien = (ct.getGiaNhap() * ct.getSoluong()) + checkBarcode.getDouble("tongtien");
                String ngayThem = ChuyenDoi.dateTimeString(new Date());
                String ghiChu = checkBarcode.getString("ghichu");
                ghiChu += "-> " + ngayThem + "-" + ct.getBarcode() + "-" + ct.getGiaNhap() + "-" + ct.getSoluong() + "-" + ct.getNguoiThem() + "\n";
                if (!txtGhiChu.getText().trim().isEmpty()) {
                    ghiChu += ct.getGhiChu();
                }
                System.out.println("Số lượng cập nhật: " + sl);
                System.out.println(tongTien);
                if (SP.DAO.update.update_SL_CTPN(id, ct.getBarcode(), ngayThem, tongTien, ghiChu, sl) <= 0) {
                    System.out.println(ghiChu);
                    System.out.println("Lỗi cập nhật số lượng chi tiết phiếu nhập");
                    return false;
                } else {
                    loadBangDanhSachSanPham();
                    System.out.println("Cập nhât số lượng thành công");
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.out.println("Catch");
        }
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
    public static boolean showThongTinSanPham(String barcode, String idpn) {
        ResultSet rs = SP.DAO.selectBy.Select_SanPham_CTPhieuNhap_ByBarcode(barcode);
        
        try {
            if (rs.next()) {
                for (int i = 0; i < cbbDonViSP.getItemCount(); i++) {
                    if (cbbDonViSP.getItemAt(i).equals(rs.getString("DonVi"))) {
                        cbbDonViSP.setSelectedIndex(i);
                    }
                }
//                txtDonVi.setText(rs.getString("DonVi"));
                txtGiaLeCu.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaLe")));
                txtGiaLeMoi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaLe")));
                txtGiaNhapCu.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaNhap")));
                txtGiaNhapMoi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaNhap")));
                txtGiaSiCu.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaSi")));
                txtGiaSiMoi.setText(ChuyenDoi.doubleToString(rs.getDouble("GiaSi")));
                txtHanBH.setText(String.valueOf(rs.getInt("HanBH")));
                txtHangSX.setText(rs.getString("HangSX"));
                txtGhiChu.setText("");
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
        ResultSet checkbarcode = SP.DAO.selectBy.check_Barcode_CTPhieuNhap(idpn, barcode);
        try {
            if (checkbarcode.next()) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
           return true;
        }
        
    }

    public static boolean InsertSanPhamTrongKho_By_PhieuNhap(String idPN) {
        ResultSet rsCTPN = SP.DAO.selectBy.CTPhieuNhap_By_IDPN(idPN);
        double tongTien = 0;
        String ngayNhap = ChuyenDoi.dateTimeString(new Date());
        int lanNhap = SP.DAO.selectMax.maxLanNhap(idPN) + 1;
        String nguoiNhap = DTO.DTO_UserLogin.userName;
        String viTri = SP.GUI.page_ViTri.vt.getIDViTri();
        System.out.println(viTri);

        int maxIdentity = 0;
        try {
            while (rsCTPN.next()) {
                int sl = rsCTPN.getInt("SoLuong");
                tongTien += rsCTPN.getDouble("GiaNhap") * sl;
                double giasi = rsCTPN.getDouble("Giasi");
                double giale = rsCTPN.getDouble("GiaLe");
                for (int i = 0; i < sl; i++) {
                    maxIdentity = SP.DAO.selectMax.maxIdentityHangTonKho();
                    String mavach = taoMaVach(rsCTPN.getString("barcode"), maxIdentity + 1);
                    String idCTPN = String.valueOf(rsCTPN.getInt("IDCTPhieuNhap"));
                    SP.DTO.DTO_HangTonKho htk = new DTO_HangTonKho(mavach, "ChuaNhap", idCTPN, "", rsCTPN.getString("barcode"), false, giale, giasi);
                    if (SP.DAO.insert.sanPhamTrongKho(htk) < 1) {
                        System.out.println("Chưa nhập được sản phẩm " + rsCTPN.getString("barcode") + " vào kho!");
                        continue;
                    } else {
                        System.out.println("Nhập thành công sản phẩm : " + rsCTPN.getString("barcode") + " Vào kho");
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (SP.DAO.update.UpdateCTPN(ngayNhap, lanNhap, nguoiNhap, viTri, idPN) > 0) {
            System.out.println("Cập nhật ctphieu nhập thành công");
        }

        SP.DAO.update.UpdatePhieuNhap(tongTien, idPN);
        return true;
    }

    public static String taoMaVach(String barcode, int identity) {
        String maVach = "VT-" + barcode + "-" + identity;
        return maVach;
    }

//    public static void loadDonViSP() {
//        ResultSet rs = DAO.select.DonVi_CTPhieuNhap();
//        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbDonViSP.getModel();
//        cbbModel.removeAllElements();
//        cbbModel.addElement("---Thêm Mới---");
//        try {
//            while (rs.next()) {
//                cbbModel.addElement(rs.getString("DonVi"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
public static boolean xoaCTPhieuNhap(int id, int sl){
    ResultSet rsSL = SP.DAO.selectBy.CTPhieuNhap_ByIDCTPhieuNhap(id);
        try {
            if (rsSL.next()) {
                if (rsSL.getInt("Soluong") <= sl) {
                    // Nếu số lượng = 1 thì xóa ct phiếu nhập
                    if (SP.DAO.delete.xoaCTPhieuNhap(id) <= 0) {
                        System.out.println("Chưa xóa được CT phiếu nhập");
                        return false;
                    }
                    
                    
                }else if (rsSL.getInt("Soluong") > sl) {
                    System.out.println(rsSL.getInt("Soluong"));
                    sl = rsSL.getInt("Soluong") - sl;
                    System.out.println(sl);
                    // nếu số lượng lớn hơn 1 thì cập nhật lại số lượng và tổng tiền của chi tiết phiếu nhập
                    double giaNhap = rsSL.getDouble("GiaNhap");
                    
                    double tongTien = rsSL.getDouble("TongTien") - (giaNhap * sl);
                    System.out.println(tongTien);
                    
                    if(SP.DAO.update.update_SL_Gia_CTPhieuNhap(String.valueOf(id),tongTien, sl) <= 0)  {
                        System.out.println("Chưa cập nhật được số lượng");
                        return false;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Đã xóa chi tiết phiêu nhập");
          loadBangDanhSachSanPham();
        return true;
}
    
}
