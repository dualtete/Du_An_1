/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author bumte
 */
public class select {

    public static ResultSet NhaCungCap(boolean trangThai, String timKiem) {
        String cauLenh = "select * from NHACUNGCAP where TrangThai = '" + trangThai + "' and (IDNCC like N'%" + timKiem + "%' "
                + "or TenNCC like N'%" + timKiem + "%' or LoaiHinh like N'%" + timKiem + "%' "
                + "or NhomNCC like N'%" + timKiem + "%' or SDT like N'%" + timKiem + "%' "
                + "or MSThue like N'%" + timKiem + "%' or NguoiLH like N'%" + timKiem + "%' "
                + "or Email like N'%" + timKiem + "%')";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet nhaCungCapSort(boolean trangThai, String timKiem) {
        String cauLenh = "select * from NHACUNGCAP where TrangThai = '" + trangThai + "' and (IDNCC like N'%" + timKiem + "%' "
                + "or TenNCC like N'%" + timKiem + "%' or DC like N'%" + timKiem + "%')";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet Quyen(String timKiem) {
        return DBConnection.getData("select * from quyen where tenQuyen like N'%" + timKiem + "%'");
    }

    public static ResultSet selectNhanVien(String timKiem) {
        return DBConnection.getData("select * from NHANVIEN where HoTen like N'%" + timKiem + "%'");
    }

    public static ResultSet NhanVien(String timKiem) {
        String cauLenh = "select * from NHANVIEN where TrangThai = 'true' and ( "
                + "IDNV like '%" + timKiem + "%' or HoTen like N'%" + timKiem + "%' "
                + "or SDT like '%" + timKiem + "%' or CMND like '%" + timKiem + "%' "
                + "or Email like '%" + timKiem + "%' or DC like '%" + timKiem + "%')";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet TaiKhoan(String timKiem) {
        String cauLenh = "select * from TAIKHOAN where TrangThai = 'true' and  "
                + "(UserName like '%" + timKiem + "%' )";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet LoaiKH() {
        return DBConnection.getData("select * from LOAIKHACHHANG where TrangThai = 'true'");
    }

    public static ResultSet KhachHang(String timKiem) {
        String cauLenh = "select * from KHACHHANG where TrangThai = 'true' and ( "
                + "IDKH like '%" + timKiem + "%' or HoTen like N'%" + timKiem + "%' "
                + "or SDT like '%" + timKiem + "%' or DC like N'%" + timKiem + "%' "
                + "or Email like '%" + timKiem + "%' or GhiChu like N'%" + timKiem + "%')";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet ViTri() {
        return DBConnection.getData("Select * from vitri");
    }

    public static ResultSet Kho() {
        return DBConnection.getData("select VITRI.IDKho, VITRI.TenKho from VITRI group by VITRI.TenKho, VITRI.IDKho");
    }

    public static ResultSet Lo(String idKho) {
        return DBConnection.getData("select * from VITRI where IDKho = '" + idKho + "'");
    }

}
