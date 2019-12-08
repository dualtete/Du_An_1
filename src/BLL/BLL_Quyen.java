/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_Quyen;
import GUI.TTTaiKhoan;
import GUI.ThongBao;
import static GUI.TTTaiKhoan.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_Quyen {

    public static boolean insertQuyen() {
//       code validate
        DTO.DTO_Quyen q = new DTO_Quyen();
        getComponent(q);
        if (DAO.insert.Quyen(q) > 0) {
            ThongBao.ThongBao("Thêm quyền thành công!", "Thông báo");
            loadBangQuyen();
            return true;
        }
        ThongBao.ThongBao("Thêm quyền thất bại!", "Thông báo");
        return false;
    }

    public static boolean updateQuyen(int id) {
//        code validate
        DTO_Quyen q = new DTO_Quyen();
        q.setMaQuyen(id);
        getComponent(q);
        if (DAO.update.Quyen(q) > 0) {
            ThongBao.ThongBao("Cập nhật thành công!", "Thông báo");
            loadBangQuyen();
            return true;
        }
        ThongBao.ThongBao("Cập nhật thất bại!", "Thông báo");
        return false;
    }
    public static boolean deleteQuyen(JTable tbl){
        int dongXoa[] = tbl.getSelectedRows();
        if (ThongBao.ThongBaoLoai2("Bạn có chắc chắn muốn xóa không?", "Thông báo") != JOptionPane.OK_OPTION) {
            return false;
        }
        for (int i = dongXoa.length - 1; i >= 0; i--) {
            DAO.delete.Quyen(tbl.getValueAt(dongXoa[i], 1).hashCode());
        }
        GUI.ThongBao.ThongBao("Xóa thành công!", "Thông báo");
        return true; 
    }

    public static void setComponent(DTO_Quyen q) {
        txtMoTa.setText(q.getMoTa());
        txtNgaySua.setText(q.getNgaySua());
        txtNgayTao.setText(q.getNgayTao());
        txtNguoiSua.setText(q.getNguoiSua());
        txtNguoiTao.setText(q.getNguoiTao());
        txtTenQuyen.setText(q.getTenQuyen());
    }

    public static void getComponent(DTO_Quyen q) {
        q.setMoTa(txtMoTa.getText());
        q.setNgaySua(txtNgaySua.getText());
        q.setNgayTao(txtNgayTao.getText());
        q.setNguoiSua(txtNguoiSua.getText());
        q.setNguoiTao(txtNguoiTao.getText());
        q.setTenQuyen(txtTenQuyen.getText());
    }

    public static void click() {
        String id = TTTaiKhoan.tblQuyen.getValueAt(TTTaiKhoan.tblQuyen.getSelectedRow(), 1).toString();
        ResultSet rs = DAO.selectByID.Quyen(id);
        try {
            if (rs.next()) {
                //System.out.println(rs.getInt(1));
                DTO_Quyen q = new DTO_Quyen();
                q.setMaQuyen(rs.getInt(1));
                q.setTenQuyen(rs.getString(2));
                q.setMoTa(rs.getString(3));
                q.setNguoiTao(rs.getString(4));
                q.setNgayTao(ChuyenDoi.GetNgay(rs.getDate(5)));
                q.setNgaySua(ChuyenDoi.GetNgay(rs.getDate(6)));
                q.setNguoiSua(rs.getString(7));
                setComponent(q);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi click vào bảng quyền");
        }
    }

    public static void loadBangQuyen() {
        DefaultTableModel tblModel = (DefaultTableModel) TTTaiKhoan.tblQuyen.getModel();
        Object obj[] = new Object[8];
        tblModel.setRowCount(0);
        ResultSet rs = DAO.select.Quyen("");
        try {
            while (rs.next()) {
                obj[0] = TTTaiKhoan.tblQuyen.getRowCount() + 1;
                obj[1] = rs.getInt(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = ChuyenDoi.GetNgay(rs.getDate(5));
                obj[6] = ChuyenDoi.GetNgay(rs.getDate(6));
                obj[7] = rs.getString(7);
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load dữ liệu vào bảng quyền");
        }
    }

    public static void openForm() {
        Date date = new Date();
        txtNgayTao.setText(ChuyenDoi.GetNgay(date));
        txtNguoiTao.setText(DTO.DTO_UserLogin.userName);
        txtNgaySua.setText(ChuyenDoi.GetNgay(date));
        txtNguoiSua.setText(DTO.DTO_UserLogin.userName);

    }
    
}
