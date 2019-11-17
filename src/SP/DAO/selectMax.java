/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DAO;

import DAO.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author bumte
 */
public class selectMax {

    public static int maxLanNhap(String IDPN) {
        String cauLenh = "select max(LanNhap) as lanNhap from CT_PHIEUNHAP   where IDPN = '" + IDPN + "'";
        ResultSet rs = DBConnection.getData(cauLenh);
        try {
            if (rs.next()) {
                return rs.getInt("lanNhap");
            }
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(selectMax.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    public static int maxIdentityHangTonKho() {
        String cauLenh = "select Max(id) maxid from sanphamtrongkho";
        ResultSet rs = DBConnection.getData(cauLenh);
        try {
            if (rs.next()) {
                return rs.getInt("maxid");
            }
            return 0;
        } catch (SQLException ex) {
//            Logger.getLogger(selectMax.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
