/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author bumte
 */
public class delete {
    public static int Quyen(int id){
        return DBConnection.ExecuteData("delete QUYEN where IDQuyen = "+id+"");
    }
    public static int TaiKhoan(int id){
        return DBConnection.ExecuteData("delete TaiKhoan where IDTaiKhoan = "+id+"");
    }
    public static int xoaNhanVien(String id) {
        return DBConnection.ExecuteData("set dateformat dMy update NHANVIEN set TrangThai = 'fasle' where IDNV = '" + id + "'");
    }
    public static int xoaKhachHang(String id) {
        return DBConnection.ExecuteData("set dateformat dMy update KHACHHANG set TrangThai = 'false' where IDKH = '" + id + "'");
    }
    public static int xoaNCC(String id) {
        return DBConnection.ExecuteData("set dateformat dMy update NHACUNGCAP set TrangThai = 'false' where IDNCC = '" + id + "'");
    }
}
