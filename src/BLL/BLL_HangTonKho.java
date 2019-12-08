/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static GUI.jdlHangTonKho.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_HangTonKho {

    public static void loadDangMucHangTonKho(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object rows[] = new Object[4];
        ResultSet rs = DAO.HangTonKho.hangTonKho_SL_Barcode();
        try {
            while (rs.next()) {
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("masp");
                rows[2] = rs.getString("TenSP");
                rows[3] = rs.getInt("SL");
                tblModel.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_HangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadHangTonKHo(String id, JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object rows[] = new Object[9];
        ResultSet rs = DAO.HangTonKho.chiTietSPTonKho(id);
        try {
            while (rs.next()) {
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("MaVach");
                rows[2] = rs.getString("HangSX");
                rows[3] = rs.getString("TenNCC");
                rows[4] = ChuyenDoi.dateTimeString(rs.getTimestamp("NgayNhap"));
                rows[5] = "Còn 6 tháng";
                rows[6] = ChuyenDoi.doubleToString(rs.getDouble("GiaNhap"));
                rows[7] = ChuyenDoi.doubleToString(rs.getDouble("GiaLeCu"));
                rows[8] = ChuyenDoi.doubleToString(rs.getDouble("GiaLe"));
                tblModel.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_HangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void open() {

        loadDangMucHangTonKho(tblDanhMucTonKho);
    }
}
