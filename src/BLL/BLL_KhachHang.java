/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_KhachHang;
import DTO.MyComboBox;
import GUI.KhachHang;
import GUI.ThongBao;
import GUI.jdlAddKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static GUI.jdlAddKhachHang.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class BLL_KhachHang {

    public static void setComponent(DTO.DTO_KhachHang kh) {
        jdlAddKhachHang.txtDC.setText(kh.getDC());
        txtEmail.setText(kh.getEmail());
        txtGhiChu.setText(kh.getGhiChu());
        txtHoTen1.setText(kh.getHoTen());
        radNu.setSelected(!kh.isGioiTinh());
        radNam.setSelected(kh.isGioiTinh());
        txtIDKhachHang.setText(kh.getIDKH());
        txtNgaySinh.setDate(kh.getNgaySinh());
        txtNgayThem.setDate(kh.getNgayThem());
        txtNguoiTao.setText(String.valueOf(kh.getIDTK()));
        txtSDT.setText(kh.getSDT());

    }

    public static void getComponent(DTO.DTO_KhachHang kh) {
        kh.setDC(txtDC.getText());
        kh.setEmail(txtEmail.getText());
        kh.setGhiChu(txtGhiChu.getText());
        kh.setGioiTinh(radNam.isSelected());
        kh.setHoTen(txtHoTen1.getText());
        kh.setIDKH(txtIDKhachHang.getText());
        DTO.MyComboBox mb = (DTO.MyComboBox) jdlAddKhachHang.cbbLoaiKH.getSelectedItem();
        kh.setIDLoaiKH(mb.MaString());
        kh.setIDTK(Integer.parseInt(txtNguoiTao.getText()));
        kh.setNgaySinh(txtNgaySinh.getDate());
        kh.setNgayThem(txtNgayThem.getDate());
        kh.setSDT(txtSDT.getText().replace("-", ""));

    }

    public static void click() {
        String id = KhachHang.tblKhachHang.getValueAt(KhachHang.tblKhachHang.getSelectedRow(), 1).toString();
        ResultSet rs = DAO.selectByID.KhachHang(id);
        try {
            if (rs.next()) {
                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setIDKH(rs.getString("IDKH"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setSDT(rs.getString("SDT"));
                kh.setDC(rs.getString("DC"));
                kh.setEmail(rs.getString("Email"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setNgayThem(rs.getDate("NgayThem"));
                kh.setIDTK(rs.getInt("IDTK"));
                kh.setGhiChu(rs.getString("GhiChu"));
                setComponent(kh);

            }
        } catch (SQLException ex) {
            GUI.ThongBao.ThongBao("Lỗi khi click vào bảng nhân viên!", "Thông báo");
        }
    }

    public static void loadDSLoaiKH() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) jdlAddKhachHang.cbbLoaiKH.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.select.LoaiKH();
        try {
            while (rs.next()) {
                DTO.MyComboBox cbbBox = new MyComboBox(rs.getInt(1), rs.getString(2));
                cbbModel.addElement(cbbBox);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load danh sách loại khách hàng");
        }
    }

    public static boolean insert() {
        // code validate       
        if (!kiemTra("makh")) {
            ThongBao.ThongBao("Mã khách hàng bao gồm 5 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("hovaten")) {
            ThongBao.ThongBao("Họ tên gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("sdt")) {
            ThongBao.ThongBao("Phải đủ 10 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("diachi")) {
            ThongBao.ThongBao("Địa chỉ gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("email")) {
            ThongBao.ThongBao("Sai định dạng email!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaysinh")) {
            ThongBao.ThongBao("Phải lớn hơn hoặc bằng 18 tuổi!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaythem")) {
            ThongBao.ThongBao("Ngày thêm phải là ngày hiện tại!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ghichu")) {
            ThongBao.ThongBao("Có thể không nhập!", "Thông báo!");
            return false;
        }
        ResultSet rsMail = DAO.selectByID.emailKhachHang(txtEmail.getText());
        try {
            if (rsMail.next()) {
                lblTBEmail.setText("!");
                GUI.ThongBao.ThongBao("Email đã được sử dụng!", "Thông báo");
                return false;

            }
        } catch (SQLException ex) {

        }

        DTO.DTO_KhachHang kh = new DTO_KhachHang();
        getComponent(kh);
        kh.setTrangThai(true);
        if (DAO.insert.KhachHang(kh) > 0) {
            GUI.ThongBao.ThongBao("Thêm khách hàng thành công!", "Thông báo");
            loadDSKhachHang("");
            return true;
        }
        GUI.ThongBao.ThongBao("Thêm khách hàng thất bại!", "Thông báo");
        return false;

    }

    //Kiem tra trước khi thêm
    public static boolean kiemTra(String component) {
        boolean kt = true;
        switch (component) {
            case "makh":
                if (!jdlAddKhachHang.txtIDKhachHang.getText().matches("^[a-zA-Z0-9]{5}$")) {
                    jdlAddKhachHang.lblTDMaKH.setText("!");
                    kt = false;
                    break;
                }
                lblTDMaKH.setText("");
                kt = true;
                break;
            case "hovaten":
                try {
                    String hoten = ChuyenDoi.unAccent(txtHoTen1.getText());
                    if (!hoten.matches("^[a-zA-Z\\s+]{5,50}$")) {
                        lblTBHoTen1.setText("!");
                        kt = false;
                        break;
                    }
                } catch (Exception e) {
                    kt = false;
                    break;
                }
                kt = true;
                lblTBHoTen1.setText("");
                break;
            case "sdt":
                if (txtSDT.getText().length() < 10) {
                    kt = false;
                    lblTBSDT.setText("!");
                    break;
                } else {
                    lblTBSDT.setText("");
                    kt = true;
                    break;
                }
            case "diachi":
                String diachi = txtDC.getText();
                if (diachi.length() < 5) {
                    kt = false;
                    lblTBDC.setText("!");
                    break;
                } else {
                    lblTBDC.setText("");
                    kt = true;
                    break;
                }
            case "email":
                String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
                if (!txtEmail.getText().matches(regex)) {
                    lblTBEmail.setText("!");
                    kt = false;
                    break;
                }
                kt = true;
                lblTBEmail.setText("");
                break;
            case "ngaysinh":
                try {
                    Date toDay = new Date();
                    if (ChuyenDoi.soSanhDate(ChuyenDoi.GetNgay(txtNgaySinh.getDate()), ChuyenDoi.GetNgay(toDay)).getYears() < 17) {
                        kt = false;
                        break;
                    }
                } catch (Exception e) {
                    kt = false;
                    break;
                }
                kt = true;
                break;
            case "ngaythem":
                Date ngaycap = txtNgayThem.getDate();
                Date date = new Date();
                if (date.equals(ngaycap)) {
                    kt = false;
                    lblTBNgayThem.setText("!");
                    break;
                }
                lblTBNgayThem.setText("");
                kt = true;
                break;
        }
        return kt;
    }

    public static boolean update(String idkh) {
        //code validate
        if (!kiemTra("makh")) {
            ThongBao.ThongBao("Mã khách hàng bao gồm 5 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("hovaten")) {
            ThongBao.ThongBao("Họ tên gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("sdt")) {
            ThongBao.ThongBao("Phải đủ 10 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("diachi")) {
            ThongBao.ThongBao("Địa chỉ gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("email")) {
            ThongBao.ThongBao("Sai định dạng email!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaysinh")) {
            ThongBao.ThongBao("Phải lớn hơn hoặc bằng 18 tuổi!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaythem")) {
            ThongBao.ThongBao("Ngày thêm phải là ngày hiện tại!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ghichu")) {
            ThongBao.ThongBao("Có thể không nhập!", "Thông báo!");
            return false;
        }
        ResultSet rsMail = DAO.selectByID.emailKhachHang(txtEmail.getText());
        try {
            if (rsMail.next()) {
                if (!rsMail.getString("IDKH").equals(idkh)) {
                    lblTBEmail.setText("!");
                    GUI.ThongBao.ThongBao("Email đã được sử dụng!", "Thông báo");
                    return false;

                }
            }
        } catch (SQLException ex) {

        }

        DTO_KhachHang kh = new DTO_KhachHang();
        getComponent(kh);
        if (DAO.update.KhachHang(kh) > 0) {
            GUI.ThongBao.ThongBao("Cập nhật thông tin khách hàng thành công!", "Thông báo!");
            loadDSKhachHang("");
            return true;
        }
        System.out.println("Sửa thất bại");
        return false;

    }

    public static void loadDSKhachHang(String timKiem) {
        DefaultTableModel tblModel = (DefaultTableModel) KhachHang.tblKhachHang.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[12];
        ResultSet rs = DAO.select.KhachHang(timKiem);
        try {
            while (rs.next()) {
                obj[0] = tblModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getInt(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = rs.getString(6);
                obj[7] = ChuyenDoi.GetNgay(rs.getDate("NgaySinh"));
                obj[8] = rs.getBoolean(8) ? "Nam" : "Nữ";
                obj[9] = rs.getString(9);
                obj[10] = rs.getInt(12);
                tblModel.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void windowOpened() {
        loadDSKhachHang("");
        loadDSLoaiKH();
        txtNguoiTao.setEditable(false);
        txtNguoiTao.setText(String.valueOf(DTO.DTO_UserLogin.IDTK));
        Date date = new Date();
        txtNgayThem.setEnabled(false);
    }

    public static boolean delete(JTable tbl) {
        int dongXoa[] = tbl.getSelectedRows();
        if (ThongBao.ThongBaoLoai2("Bạn có chắc chắn muốn xóa không?", "Thông báo") != JOptionPane.OK_OPTION) {
            return false;
        }
        for (int i = dongXoa.length - 1; i >= 0; i--) {
            String id = tbl.getValueAt(dongXoa[i], 2).toString();
            DAO.delete.xoaKhachHang(tbl.getValueAt(dongXoa[i], 1).toString());
        }
        GUI.ThongBao.ThongBao("Xóa thành công!", "Thông báo");
        return true;
    }
}
