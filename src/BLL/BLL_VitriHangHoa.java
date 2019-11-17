/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_ViTriHangHoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author bumte
 */
public class BLL_VitriHangHoa {

    public static ArrayList<DTO_ViTriHangHoa> getAllKho() {
        ResultSet rs;
        ArrayList<DTO_ViTriHangHoa> kho = null;
        rs = DAO.select.Kho();
        kho = new ArrayList<DTO_ViTriHangHoa>();

        try {
            while (rs.next()) {
                DTO_ViTriHangHoa k = new DTO_ViTriHangHoa(rs.getString(1), rs.getString(2));
                kho.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_VitriHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kho;
    }

    public static ArrayList<DTO_ViTriHangHoa> getAllLo(String idKho) {
        ResultSet rs;
        ArrayList<DTO_ViTriHangHoa> lo = null;
        rs = DAO.select.Lo(idKho);
        lo = new ArrayList<DTO_ViTriHangHoa>();

        try {
            while (rs.next()) {
                DTO_ViTriHangHoa k = new DTO_ViTriHangHoa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                lo.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_VitriHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lo;
    }
//
//    public static boolean insertKho() {
//        // code validate
//
//        DTO_ViTriHangHoa k = new DTO_ViTriHangHoa();
//        getComponent(k);
//        k.setTrangThai(1);
//        if (DAO.insert.KhoHang(k) > 0) {
//            System.out.println("Thêm kho thành công");
//
//            return true;
//        }
//        System.out.println("Thêm kho thất bại");
//        return false;
//
//    }

//    public static void setComponent(DTO_ViTriHangHoa k) {
//        txtGhiCHu.setText(k.getGhiChu());
//        txtIDKho.setText(k.getIDKho());
//        txtIDLo.setText(k.getIDLo());
//        txtTenKho.setText(k.getTenKho());
//        txtTenLo.setText(k.getTenLo());
//        txtTrangThai.setText(String.valueOf(k.getTrangThai()));
//        txtIDViTri.setText(k.getIDViTri());
//    }
//
//    public static void getComponent(DTO_ViTriHangHoa k) {
//        k.setGhiChu(txtGhiCHu.getText());
//        k.setIDKho(txtIDKho.getText());
//        k.setIDLo(txtIDLo.getText());
//        k.setIDViTri(txtIDViTri.getText());
//        k.setTenKho(txtTenKho.getText());
//        k.setTenLo(txtTenLo.getText());
//        k.setTrangThai(Integer.parseInt(txtTrangThai.getText()));
//    }
}
