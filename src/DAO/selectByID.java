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
public class selectByID {
    public static ResultSet Quyen(String id){
        return DBConnection.getData("select * from QUYEN where IDQuyen = "+id+"");
    }
    public static ResultSet NhanVien(String id){
        return DBConnection.getData("Select * from NHANVIEN where IDNV = '"+id+"'");
    }
    public static ResultSet TaiKhoan(String id){
        return DBConnection.getData("select * from TAIKHOAN where IDTaiKhoan = '"+id+"'");
    }
    public static ResultSet NhaCungCap(String id){
        return DBConnection.getData("select * from NHACUNGCAP where IDNCC = '"+id+"'");
    }
    public static ResultSet ViTri(String id){
        return DBConnection.getData("select * from vitri where IDViTri ='"+id+"'");
    }
}
