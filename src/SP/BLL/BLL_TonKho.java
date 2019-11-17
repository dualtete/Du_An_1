/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;
import static SP.GUI.pnlHangTonKho.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bumte
 */
public class BLL_TonKho {
    public static void loadDSPSChuaVaoKho(){
        DefaultTableModel tblModel = (DefaultTableModel) tblChuaVaoKho.getModel();
        tblModel.setRowCount(0);
        Object rows[] = new Object[8];
        ResultSet rs = SP.DAO.selectBy.HangTonKhoByTrangThai(false);
        try {
            while(rs.next()){
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("TenSP");
                rows[2] = rs.getString("SeriSP");
                rows[3] = rs.getString("MaVach");
                rows[4] = rs.getTimestamp("NgayNhap");
                rows[5] = "Chưa vào kho";
                tblModel.addRow(rows);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_TonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
