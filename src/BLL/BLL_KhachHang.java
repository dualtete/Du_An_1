/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_KhachHang;
import DTO.MyComboBox;
import GUI.KhachHang;
import GUI.jdlAddKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static GUI.jdlAddKhachHang.*;

/**
 *
 * @author Admin
 */
public class BLL_KhachHang {
    public static void setComponent(DTO.DTO_KhachHang kh){
        jdlAddKhachHang.txtDC.setText(kh.getDC());
        txtEmail.setText(kh.getEmail());
        txtGhiChu.setText(kh.getGhiChu());
        txtHoTen1.setText(kh.getHoTen());
        txtIDKhachHang.setText(kh.getIDKH());
        txtNgaySinh.setText(kh.getNgaySinh());
        txtNgayThem.setText(kh.getNgayThem());
        txtNguoiTao.setText(String.valueOf(kh.getIDTK()));
        txtSDT.setText(kh.getSDT());
        
        
    }
    public static void getComponent(DTO.DTO_KhachHang kh){
        kh.setDC(txtDC.getText());
        kh.setEmail(txtEmail.getText());
        kh.setGhiChu(txtGhiChu.getText());
        kh.setGioiTinh(radNam.isSelected());
        kh.setHoTen(txtHoTen1.getText());
        kh.setIDKH(txtIDKhachHang.getText());
        DTO.MyComboBox mb = (DTO.MyComboBox)jdlAddKhachHang.cbbLoaiKH.getSelectedItem();
        kh.setIDLoaiKH(mb.MaString());
        kh.setIDTK(Integer.parseInt(txtNguoiTao.getText()));
        kh.setNgaySinh(txtNgaySinh.getText());
        kh.setNgayThem(txtNgayThem.getText());
        kh.setSDT(txtSDT.getText().replace("-", ""));
       
    }
    public static void loadDSLoaiKH(){
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) jdlAddKhachHang.cbbLoaiKH.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.select.LoaiKH();
        try {
            while(rs.next()){
                DTO.MyComboBox cbbBox = new MyComboBox(rs.getInt(1), rs.getString(2));
                cbbModel.addElement(cbbBox);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load danh sách loại khách hàng");
        }
    }
    public static boolean insert(){
        // code validate       
        
        
        DTO.DTO_KhachHang kh = new DTO_KhachHang();
        getComponent(kh);
        kh.setTrangThai(true);
        if (DAO.insert.KhachHang(kh) > 0) {
            System.out.println("Thêm khách hàng thành công");
            loadDSKhachHang("");
            return true;
        }
        System.out.println("Thêm khách hàng thất bại ");
        return false;
                
    }
    public static boolean update(){
        //code validate
        
        
        DTO_KhachHang kh = new DTO_KhachHang();
        getComponent(kh);
        if (DAO.update.KhachHang(kh) > 0) {
            System.out.println("Cập nhật thông tin khách hàng thành công!");
            loadDSKhachHang("");
            return true;
        }
        System.out.println("Sửa thất bại");
        return false;
        
        
    }
    public static void loadDSKhachHang(String timKiem){
        DefaultTableModel tblModel = (DefaultTableModel) KhachHang.tblKhachHang.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[12];
        ResultSet rs = DAO.select.KhachHang(timKiem);
        try {
            while(rs.next()){
                obj[0] = tblModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getInt(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                obj[7] = ChuyenDoi.GetNgay(rs.getDate("NgaySinh"));
                obj[8] = rs.getBoolean(8)? "Nam" : "Nữ";
                obj[9] = rs.getString(9);
                obj[10] = ChuyenDoi.GetNgay(rs.getDate(11));
                obj[11] = rs.getInt(12);
                tblModel.addRow(obj);
                
            }} catch (SQLException ex) {
            Logger.getLogger(BLL_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void windowOpened(){
        loadDSKhachHang("");
        loadDSLoaiKH();
        txtNguoiTao.setEditable(false);
        txtNguoiTao.setText(String.valueOf(DTO.DTO_UserLogin.IDTK));
        Date date = new Date();
        txtNgayThem.setEditable(false);
        txtNgayThem.setText(ChuyenDoi.GetNgay(date));
    }
}
