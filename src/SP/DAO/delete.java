/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DAO;

import DAO.DBConnection;

/**
 *
 * @author bumte
 */
public class delete {

    public static int delPhieuNhap_CTPhieuNhap(String idPN) {
        return DBConnection.ExecuteData("exec sp_XoaPhieuNhap_CTPhieuNhap '" + idPN + "'");
    }
}