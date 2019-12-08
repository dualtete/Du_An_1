/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_TaiKhoan;
import DTO.MyComboBox;
import GUI.TTTaiKhoan;
import GUI.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_TaiKhoan {
    public static void setComponent(DTO_TaiKhoan tk){
        
    }
    
    public static boolean insert() {
//        code validate

        DTO.DTO_TaiKhoan tk = new DTO_TaiKhoan();
        DTO.MyComboBox mb = (DTO.MyComboBox) TTTaiKhoan.cbbQuyen.getSelectedItem();
        tk.setIDQuyen(mb.MaString());
        DTO.MyComboBox mbb = (DTO.MyComboBox) TTTaiKhoan.cbbMaNhanVien.getSelectedItem();
        tk.setIDNV(mbb.MaString());
        Date date = new Date();
        tk.setNgaylap(ChuyenDoi.GetNgay(date));
        tk.setNguoiLap(DTO.DTO_UserLogin.userName);
        tk.setPass(String.valueOf(TTTaiKhoan.txtPass.getPassword()));
        tk.setTrangThai(true);
        tk.setUserName(TTTaiKhoan.txtTenDN.getText());
        if (DAO.insert.TaiKhoan(tk) > 0) {
            GUI.ThongBao.ThongBao("Tạo tài khoản thành công!", "Thông báo");
            loadBangTaiKhoan();
            return true;
        }
        ThongBao.ThongBao("Tạo tài khoản thất bại!", "Thông báo");
        return false;
    }
   
    public static void loadBangTaiKhoan(){
        DefaultTableModel tblModel = (DefaultTableModel) TTTaiKhoan.tblTaiKhoan.getModel();
        tblModel.setRowCount(0);
        Object row[] = new Object[9];
        ResultSet rs = DAO.select.TaiKhoan("");
        try {
            while(rs.next()){
                row[0] = tblModel.getRowCount() + 1;
                row[1] = rs.getInt(1);
                row[2] = rs.getString(2);
                row[3] = rs.getString(3);
                row[4] = ChuyenDoi.GetNgay(rs.getDate(4));
                row[5] = rs.getString(5);
                row[6] = rs.getInt(6);
                row[7] = rs.getBoolean(7)?"Đang hoạt động" : "Dừng hoạt động";
                row[8]= rs.getString(8);
                tblModel.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load dữ liệu vào bảng tài khoản");
        }
    }
    public static void loadCBBQuyen() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) TTTaiKhoan.cbbQuyen.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.select.Quyen("");
        try {
            while (rs.next()) {
                Object ma = rs.getInt("IDQuyen");
                Object ten = rs.getString("TenQuyen");
                DTO.MyComboBox mb = new MyComboBox(ma,ten);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi đổ dữ liệu vào cbb Quyền");
        }
    }
    
    public static void loadCBBNhanVien(){
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) TTTaiKhoan.cbbMaNhanVien.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.select.selectNhanVien("");
        try {
            while(rs.next()){
                Object ma = rs.getString("IDNV");
                Object ten = (rs.getString("HoTen") + " (" + ChuyenDoi.GetNgay(rs.getDate("NgaySinh")) + ")");
                DTO.MyComboBox mb = new MyComboBox(ma, ten);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi đổ dữ liệu vào cbbNhanVien");
        }
    }
    public static void refresh(){
        
    }
    public static void click(){
        String id = TTTaiKhoan.tblTaiKhoan.getValueAt(TTTaiKhoan.tblTaiKhoan.getSelectedRow(), 1).toString();
        ResultSet rs = DAO.selectBy.TaiKhoan(id);
        try {
            if(rs.next()){
                DTO_TaiKhoan tk = new DTO_TaiKhoan();
                tk.setIDTK(rs.getInt("IDTaiKhoan"));
                tk.setUserName(rs.getString("UserName"));
                tk.setPass(rs.getString("PassWords"));
                tk.setNgaylap(ChuyenDoi.GetNgay(rs.getDate("NgayLap")));
                tk.setIDNV(rs.getString("IDNV"));
                tk.setIDQuyen(rs.getString("IDQuyen"));
                tk.setNguoiLap(rs.getString("NguoiLap"));
                tk.setTrangThai(rs.getBoolean("TrangThai"));
            }
        } catch (SQLException ex) {
            ThongBao.ThongBao("Lỗi click vào bảng tài khoản!", "Thông báo");
        }
    }
    
}
