/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_NhaCungCap;
import GUI.DSNhaCungCap;
import GUI.ViTri;
import static GUI.jdlAddNhaCungCap.*;
import GUI.jdlAddNhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_NhaCungCap {

    public static void setComponent(DTO.DTO_NhaCungCap ncc) {
        /*
         Gán giá trị của đối tương nhà cung cấp vào các component
         */
        jdlAddNhaCungCap.txtDiaChi.setText(ncc.getDC());
        txtEmail.setText(ncc.getEmail());
        txtGhiChu.setText(ncc.getGhiChu());
        txtKhoa.setText(ncc.getID());
        txtLoaiHinh.setText(ncc.getLoaiHinh());
        txtMSThue.setText(ncc.getMSThue());
        txtTenNCC.setText(ncc.getTenNCC());
        txtNguoiLH.setText(ncc.getNguoiLH());
        txtNhomNCC.setText(ncc.getNhomNCC());
        txtSDT.setText(ncc.getSDT());
        txtTKBank.setText(ncc.getTKNganHang());
        txtTenBank.setText(ncc.getTenNH());
        txtTrangWeb.setText(ncc.getTrangWeb());
        txtNgayThem.setText(ncc.getNgayThem());
    }

    public static void getComponent(DTO.DTO_NhaCungCap ncc, boolean trangThai) {
        /*
         lấy giá tri từ các component gán vào đối tượng nhà cung cấp
         */
        ncc.setDC(txtDiaChi.getText());
        ncc.setEmail(txtEmail.getText());
        ncc.setID(txtKhoa.getText());
        ncc.setLoaiHinh(txtLoaiHinh.getText());
        ncc.setMSThue(txtMSThue.getText());
        ncc.setNguoiLH(txtNguoiLH.getText());
        ncc.setNhomNCC(txtNhomNCC.getText());
        ncc.setSDT(txtSDT.getText().replace("-", ""));
        ncc.setTKNganHang(txtTKBank.getText());
        ncc.setTenNCC(txtTenNCC.getText());
        ncc.setTenNH(txtTenBank.getText());
        ncc.setTrangThai(trangThai);
        ncc.setTrangWeb(txtTrangWeb.getText());
        ncc.setNgayThem(txtNgayThem.getText());
        ncc.setGhiChu(txtGhiChu.getText());
    }

    public static boolean insert() {
        /*
         Thêm code validate;
         */
        //Tạo ra một đối tượng mới
        DTO.DTO_NhaCungCap ncc = new DTO_NhaCungCap();
        //lấy dữ liệu từ các component gán vào đối tượng mới tạo
        getComponent(ncc, true);
        //Thêm nhà cung cấp theo các dữ liệu dược ghi trong đối tượng ncc
        if (DAO.insert.NhaCungCap(ncc) > 0) {
            GUI.ThongBao.ThongBao("Thêm nhà cung cấp mới thành công!", "Thông báo");
            loadBangNCC();
            return true;
        }
        GUI.ThongBao.ThongBao("Thêm nhà cung cấp thất bại!", "Thông báo");
        return false;
    }
    
    public static boolean update() {
        /*
         thêm code validate
         */
        //Tạo ra một đối tượng mới
        DTO_NhaCungCap ncc = new DTO_NhaCungCap();
        //lấy dữ liệu từ các component gán vào đối tượng mới tạo
        getComponent(ncc, true);
        //cập nhật nhà cung cấp theo các dữ liệu dược ghi trong đối tượng ncc
        if (DAO.update.NhaCungCap(ncc) > 0) {
            GUI.ThongBao.ThongBao("Cập nhật thành công!", "Thông báo");
            loadBangNCC();
            return true;
        }
        GUI.ThongBao.ThongBao("Cập nhật thất bại!", "Thông báo");
        return false;

    }

    public static void loadBangNCC() {
        DefaultTableModel tbModel = (DefaultTableModel) ViTri.tblNhaCungCap.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[15];
        ResultSet rs = DAO.select.NhaCungCap(true, "");
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() +1;
                obj[1] = rs.getString("IDNCC");
                obj[2] = rs.getString("TenNCC");
                obj[3] = rs.getString("LoaiHinh");
                obj[4] = rs.getString("DC");
                obj[5] = rs.getString("NhomNCC");
                obj[6] = rs.getString("SDT");
                obj[7] = rs.getString("MSThue");
                obj[8] = rs.getString("NguoiLH");
                obj[9] = rs.getString("Email");
                obj[10] = rs.getString("TrangWeb");
                obj[11] = rs.getString("TKNganHang");
                obj[12] = rs.getString("TenNganHang");
                obj[13] = ChuyenDoi.GetNgay(rs.getDate("NgayThem"));
                obj[14] = rs.getString("TrangThai");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load dữ liệu vào bảng nhà cung cấp");
        }
    }
    public static void loadBangNCC1() {
        DefaultTableModel tbModel = (DefaultTableModel) DSNhaCungCap.tblNhaCungCap.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[15];
        ResultSet rs = DAO.select.NhaCungCap(true, "");
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() +1;
                obj[1] = rs.getString("IDNCC");
                obj[2] = rs.getString("TenNCC");
                obj[3] = rs.getString("LoaiHinh");
                obj[4] = rs.getString("DC");
                obj[5] = rs.getString("NhomNCC");
                obj[6] = rs.getString("SDT");
                obj[7] = rs.getString("MSThue");
                obj[8] = rs.getString("NguoiLH");
                obj[9] = rs.getString("Email");
                obj[10] = rs.getString("TrangWeb");
                obj[11] = rs.getString("TKNganHang");
                obj[12] = rs.getString("TenNganHang");
                obj[13] = rs.getDate(15);
                obj[14] = rs.getString("GhiChu");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load dữ liệu vào bảng nhà cung cấp");
        }
    }
    public static void click(){
        String id = ViTri.tblNhaCungCap.getValueAt(ViTri.tblNhaCungCap.getSelectedRow(), 1).toString();
        ResultSet rs = DAO.selectByID.NhaCungCap(id);
        try {
            if(rs.next()){
                DTO_NhaCungCap ncc = new DTO_NhaCungCap();
                ncc.setID(rs.getString("IDNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setLoaiHinh(rs.getString("LoaiHinh"));
                ncc.setDC(rs.getString("DC"));
                ncc.setNhomNCC(rs.getString("NhomNCC"));
                ncc.setSDT(rs.getString("SDT"));
                ncc.setMSThue(rs.getString("MSThue"));
                ncc.setNguoiLH(rs.getString("NguoiLH"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setTrangWeb(rs.getString("TrangWeb"));
                ncc.setTKNganHang(rs.getString("TKNganHang"));
                ncc.setTenNH(rs.getString("TenNganHang"));
                ncc.setNgayThem(ChuyenDoi.GetNgay(rs.getDate("NgayThem")));
                ncc.setGhiChu(rs.getString("GhiChu"));
                setComponent(ncc);
            }
        } catch (SQLException ex) {
            GUI.ThongBao.ThongBao("Lỗi click vào bảng nhà cung cấp", "Thông báo");
        }
    }
    
}
