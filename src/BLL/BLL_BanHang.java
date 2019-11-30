/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.MyComboBox;
import GUI.BanHang;
import GUI.TTTaiKhoan;
import GUI.frmThemHoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLL_BanHang {
    public static void loadDSSanPham(JTable tbl){
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        Object obj[] = new Object[4];
        tblModel.setRowCount(0);
        ResultSet rs = DAO.select.banHangSP();
        try {
            while(rs.next()){
                obj[0] = rs.getString("masp");
                obj[1] = rs.getString("TenSP");
                obj[2] = rs.getString("giale");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void loadDSHoaDon(){
        DefaultTableModel tbModel = (DefaultTableModel) BanHang.tblDSHoaDon.getModel();
        Object obj[] = new Object[6];
        tbModel.setRowCount(0);
        ResultSet rs = DAO.select.dsHoaDon();
        try {
            while(rs.next()){
                obj[0] = rs.getString("IDHD");
                obj[1] = rs.getString("IDNV");
                obj[2] = rs.getString("IDKH");
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("NgayTaoHD"));
                obj[4] = rs.getString("TrangThai");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadCBBNhanVien(JComboBox cbb){
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.removeAllElements();
        String id = TTTaiKhoan.IDNhanVien;
        ResultSet rs = DAO.selectByID.NhanVien(id);
        try {
            while (rs.next()) {
                MyComboBox mycbb = new MyComboBox(rs.getString("IDNV"), rs.getString("HoTen"));
                cbbModel.addElement(mycbb);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load combobox");
        }
    }
}
