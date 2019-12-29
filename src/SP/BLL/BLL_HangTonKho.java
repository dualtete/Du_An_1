/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import DAO.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static SP.GUI.pnlHangTonKho.tblHangTonKhoBV;

/**
 *
 * @author bumte
 */
public class BLL_HangTonKho {

    public static void hangTonKhoTheoViTri(String idVT) {
        String cauLenh = "select TenSP, masp, COUNT(masp) as sl from  hangtonkho  "
                + "where IDViTriHienTai = '"+idVT+"' "
                + "group by TenSP, masp";
        ResultSet rs = DBConnection.getData(cauLenh);
        DefaultTableModel tblModel = ( DefaultTableModel )  tblHangTonKhoBV.getModel();
        tblModel.setRowCount(0);
        Object rows[] = new Object[5];
        
        try {
            while(rs.next()){
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("masp");
                rows[2] = rs.getString("TenSP");
                rows[3] = rs.getInt("sl");
                tblModel.addRow(rows);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_HangTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
