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
public class HangTonKho {

    public static ResultSet hangTonKho_SL_Barcode() {
        String cauLenh = "select TenSP, masp, count(masp) as sl from hangtonkho "
                + "group by TenSP, masp";
        return DBConnection.getData(cauLenh);
    }
    public static ResultSet chiTietSPTonKho(String barcode){
        String cauLenh = "select * from hangtonkho where masp = '"+barcode+"'";
        return DBConnection.getData(cauLenh);
    }
}
