/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import BLL.ChuyenDoi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_PhieuNhap {

//    public static void loadDSPhieuNhap(int trangThai) {
//        DefaultTableModel tblModel = (DefaultTableModel) tblPhieuNhap.getModel();
//        tblModel.setRowCount(0);
//        ResultSet rs = SP.DAO.selectBy.PhieuNhapByTrangThai(trangThai);
//        Object row[] = new Object[13];
//        try {
//            while (rs.next()) {
//                row[1] = rs.getString("IDPhieuNhap");
//                row[2] = ChuyenDoi.dateTimeString(rs.getTimestamp("NgayTaoPhieuNhap"));
//                int tt = rs.getInt("TrangThaiPhieNhap");
//                row[3] = tt == 0 ? "Chưa nhập vào kho" : tt == 1 ? "Nhập một phần" : tt == 2 ? "đã nhập" : "";
//                row[4] = ChuyenDoi.doubleToString(rs.getDouble("TongTienPhieuNhap"));
//                row[5] = rs.getString("MaNCC");
//                row[6] = rs.getString("tenNCC");
//                row[7] = rs.getString("DCNCC");
//                row[8] = rs.getString("SDTNCC");
//                row[9] = rs.getString("NguoiLH");
//                row[10] = rs.getString("emailNCC");
//                row[11] = rs.getString("username");
//                row[12] = rs.getString("tenNV");
//                tblModel.addRow(row);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BLL_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
