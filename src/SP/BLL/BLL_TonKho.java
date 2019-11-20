/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;
import BLL.ChuyenDoi;
import SP.DTO.DTO_HangTonKho;
import static SP.GUI.pnlHangTonKho.*;
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
//    public static void load_DSTonKho_ByViTri(String idViTri){
//        ResultSet rs = DAO.selectByID.ViTri(idViTri);
//        while(){
//            
//        }
//    }
    public static void loadSDDonDatHang(JTable tbl){
        ResultSet rs = SP.DAO.selectBy.View_PhieuNhapDaDat(0);
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object rows[] = new Object[11];
        try {
            while(rs.next()){
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("idncc");
                rows[2] = rs.getString("tenNCC");
                rows[3] = rs.getString("DC");
                rows[4] = rs.getString("SDT");
                rows[5] = rs.getString("nguoiLH");
                rows[6] = rs.getString("IDPN");
                rows[7] = ChuyenDoi.dateTimeString(rs.getTimestamp("NgayTao"));
                rows[8] = rs.getString("username");
                rows[9] = rs.getString("hoten");
                rows[10] = "Đang đợi nhập hàng";
                tblModel.addRow(rows);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_TonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void loadSPTonKho_ByKho(String idViTri, JTable tbl){
        ResultSet rs = SP.DAO.selectBy.HangTonKho_ByIDViTri(idViTri);
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        Object rows[] = new Object[8];
        tblModel.setRowCount(0);
        try {
            while(rs.next()){
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("masp");
                rows[2] = rs.getString("TenSP");
                rows[3]= rs.getInt("soluong");
                tblModel.addRow(rows);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_TonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean nhapHangVaoKho(String idViTri, String maVach){
        
     
        SP.DTO.DTO_HangTonKho htk = new DTO_HangTonKho(txtSeriSP.getText(), txtChiTiet.getText(), idViTri, true);
        if (SP.DAO.update.UpdateHangTonKho(maVach, htk) < 1) {
            
            System.out.println("Chưa nhập vào kho được");
            return false;
        }
        
        System.out.println("Đã nhập vào kho");
        loadDSPSChuaVaoKho();
        loadSPTonKho_ByKho(idViTri, tblHangTonKho);
        return true;
    }
    public static void loadThongTinPhieuNhap(){
        ResultSet rs = SP.DAO.selectBy.view_PhieuNhapByID(idPN);
        try {
            if (rs.next()) {
                lblIDPhieuNhap.setText("(" + idPN + ")");
                lblNgayTao.setText(ChuyenDoi.dateTimeString(rs.getTimestamp("NgayTao")));
                lblSDT.setText(rs.getString("SDT"));
                lblTenNCC.setText(rs.getString("TenNCC"));
                lblTenNV.setText(rs.getString("HoTen"));
                lblTenNguoiLH.setText(rs.getString("NguoiLH"));
                txtDCNCC.setText(rs.getString("dc"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_TonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void loadCTPhieuNhap_viewCTPhieuNhap(JTable tbl, String idPN){
        ResultSet rs = SP.DAO.selectBy.view_CTPhieuNhap(idPN);
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object rows[] = new Object[11];
        try {
            while(rs.next()){
                rows[0] = tblModel.getRowCount() + 1;
                rows[1] = rs.getString("idpn");
                rows[2] = rs.getString("masp");
                rows[3] = rs.getString("TenSP");
                rows[4] = rs.getInt("SoLuong");
                rows[5] = rs.getString("DonVi");
                rows[6] = ChuyenDoi.doubleToString(rs.getDouble("GiaNhap"));
                rows[7] = ChuyenDoi.doubleToString(rs.getDouble("giale"));
                rows[8] = ChuyenDoi.doubleToString(rs.getDouble("giasi"));
                rows[9] = ChuyenDoi.dateTimeString(rs.getTimestamp("NgayThem"));
                rows[10] = rs.getString("NguoiThem");
                
                tblModel.addRow(rows);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_TonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("đã load");
    }
    public static void openPNL(){
        String tenKho = SP.GUI.page_ViTri.vt.getTenKho() + " - " + SP.GUI.page_ViTri.vt.getTenLo();
         lblTenKho.setText(tenKho);
         loadSPTonKho_ByKho(SP.GUI.page_ViTri.vt.getIDViTri(), tblHangTonKho);
    }
    
}
