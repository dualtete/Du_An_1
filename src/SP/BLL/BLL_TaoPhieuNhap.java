/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import BLL.ChuyenDoi;
import SP.DTO.DTO_PhieuNhap;
import DTO.MyComboBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import static SP.GUI.pnlThongTin.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_TaoPhieuNhap {

    public static SP.DTO.DTO_PhieuNhap pn = new DTO_PhieuNhap();

    public static void loadtblNcc_pnlThongTin(String timKiem) {
        DefaultTableModel tblModel = (DefaultTableModel) tblNCC.getModel();
        tblModel.setRowCount(0);
        ResultSet rs = DAO.select.nhaCungCapSort(true, timKiem);
        Object rows[] = new Object[4];
        try {
            while (rs.next()) {
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("IDNCC");
                rows[2] = rs.getString("TenNCC");
                rows[3] = rs.getString("DC");
                tblModel.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_TaoPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setThongTinNCC() {

    }

    public static boolean TaoPhieuNhap() {

        Date date = new Date();
        String idNCC = tblNCC.getValueAt(tblNCC.getSelectedRow(), 1).toString();
        pn.setIDNCC(idNCC);
        pn.setNgayTao(ChuyenDoi.dateTimeString(date));
        pn.setNguoiTao(DTO.DTO_UserLogin.IDTK);
        pn.setTrangThai(0);
        pn.setTongTien(0);
        String idpn = "PN-" + pn.getIDNCC().replace(" ", "").replace("-", "") + pn.getNgayTao().replace(" ", "").replace("/", "").replace(":", "");
        pn.setIDPN(idpn);
        if (SP.DAO.insert.insertPhieuNhap(pn) > 0) {
            return true;
        }
        return false;
    }

}
