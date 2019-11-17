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
}
