/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_NhanVien;
import GUI.TTTaiKhoan;
import GUI.ThongBao;
import GUI.jdlAddNhanVien;
import static GUI.jdlAddNhanVien.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_NhanVien {

    public static void setComponent(DTO.DTO_NhanVien nv) {
        txtCMND.setText(nv.getCMND());
        txtDC.setText(nv.getDC());
        txtEmail.setText(nv.getEmail());
        txtHoTen.setText(nv.getHoTen());
        txtKiQuy.setText(ChuyenDoi.doubleToString(nv.getKiQuy()));
        txtLuong.setText(ChuyenDoi.doubleToString(nv.getLuong()));
        jdlAddNhanVien.txtMaNV.setText(nv.getIDNV());
        radNu.setSelected(!nv.isGioiTinh());
        radNam.setSelected(nv.isGioiTinh());
        txtNgaySinh.setDate(nv.getNgaySinh());
        txtNgayCap.setDate(nv.getNgayCap());
        txtNoiCapCMND.setText(nv.getNoiCap());
        txtSDT.setText(nv.getSDT());
        lblHinhAnh.setToolTipText(nv.getHinhAnh());
        if (nv.getHinhAnh() != null) {
            jdlAddNhanVien.lblHinhAnh.setIcon(readLogo(nv.getHinhAnh()));
        }
    }

    public static void getComponent(DTO.DTO_NhanVien nv) {
        nv.setCMND(txtCMND.getText().replace(" ", ""));
        nv.setDC(txtDC.getText());
        nv.setEmail(txtEmail.getText());
        nv.setGioiTinh(radNam.isSelected());
        nv.setHoTen(txtHoTen.getText());
        nv.setIDNV(jdlAddNhanVien.txtMaNV.getText());
        nv.setKiQuy(ChuyenDoi.stringToDouble(txtKiQuy.getText()));
        nv.setLuong(ChuyenDoi.stringToDouble(txtLuong.getText()));
        nv.setNgayCap(txtNgayCap.getDate());
        nv.setNgaySinh(txtNgaySinh.getDate());
        nv.setNoiCap(txtNoiCapCMND.getText());
        nv.setSDT(txtSDT.getText().replace("-", ""));
        nv.setHinhAnh(jdlAddNhanVien.lblHinhAnh.getToolTipText());
    }

    public static void loadBangNV(String timKiem) {
        DefaultTableModel tblModel = (DefaultTableModel) TTTaiKhoan.tblNhanVien.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[17];
        ResultSet rs = DAO.select.NhanVien(timKiem);
        try {
            while (rs.next()) {
                obj[0] = tblModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = ChuyenDoi.GetNgay(rs.getDate(5));
                obj[6] = rs.getString(6);
                obj[7] = ChuyenDoi.GetNgay(rs.getDate(7));
                obj[8] = rs.getBoolean(8) ? "Nam" : "Nữ";
                obj[9] = rs.getString(9);
                obj[10] = rs.getString(10);
                obj[11] = rs.getString(11);
                obj[12] = ChuyenDoi.GetNgay(rs.getDate(12));
                obj[13] = ChuyenDoi.doubleToString(rs.getDouble(13));
                obj[14] = rs.getBoolean(14) ? "Đang làm việc" : "Nghỉ làm";
                obj[15] = ChuyenDoi.doubleToString(rs.getDouble(15));
                obj[16] = rs.getString(16);
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi load dữ liệu vào bảng nhân viên");
        }
    }

    public static boolean insert() {
//        code validate
        if (!kiemTra("MaNV")) {
            ThongBao.ThongBao("Mã nhân viên là số và bao gồm 5 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("hoVaTen")) {
            ThongBao.ThongBao("Họ tên gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("SDT")) {
            ThongBao.ThongBao("Phải đủ 10 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("cmnd")) {
            ThongBao.ThongBao("Phải đủ 9 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaycapcm")) {
            ThongBao.ThongBao("Ngày cấp phải bé hơn ngày hiện tại!", "Thông báo!");
            return false;
        }
        if (!kiemTra("noicap")) {
            ThongBao.ThongBao("Không được bỏ trống!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaysinh")) {
            ThongBao.ThongBao("Phải lớn hơn 18 tuổi!", "Thông báo!");
            return false;
        }
        if (!kiemTra("email")) {
            ThongBao.ThongBao("Sai định dạng email!", "Thông báo!");
            return false;
        }
        if (!kiemTra("diachi")) {
            ThongBao.ThongBao("Địa chỉ gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        ResultSet rsMail = DAO.selectByID.emailNhanVien(txtEmail.getText());
        try {
            if (rsMail.next()) {
                lblTBEmail.setText("!");
                GUI.ThongBao.ThongBao("Email đã được sử dụng!", "Thông báo");
                return false;

            }
        } catch (SQLException ex) {

        }
        
        DTO.DTO_NhanVien nv = new DTO_NhanVien();
        getComponent(nv);
        Date date = new Date();
        nv.setNgayVaoLam(ChuyenDoi.GetNgay(date));
        nv.setNguoiTao(DTO.DTO_UserLogin.userName);
        if (DAO.insert.NhanVien(nv) > 0) {
            GUI.ThongBao.ThongBao("Thêm nhân viên thành công!", "Thông báo");
            TTTaiKhoan.IDNhanVien = txtMaNV.getText();
            loadBangNV("");
            return true;
        }
        GUI.ThongBao.ThongBao("Thêm nhân viên thất bại!", "Thông báo");
        return false;
    }

    public static void click() {
        String id = TTTaiKhoan.tblNhanVien.getValueAt(TTTaiKhoan.tblNhanVien.getSelectedRow(), 1).toString();
        ResultSet rs = DAO.selectBy.NhanVien(id);
        try {
            if (rs.next()) {
                DTO_NhanVien nv = new DTO_NhanVien();
                nv.setIDNV(rs.getString("IDNV"));
                nv.setCMND(rs.getString("CMND"));
                nv.setDC(rs.getString("DC"));
                nv.setEmail(rs.getString("Email"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setHinhAnh(rs.getString("HinhAnh"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setKiQuy(rs.getDouble("TienKiQuy"));
                nv.setLuong(rs.getDouble("Luong"));
                nv.setNgayCap(rs.getDate("NgayCapCMND"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setNgayVaoLam(ChuyenDoi.GetNgay(rs.getDate("NgayVaoLam")));
                nv.setNguoiTao(rs.getString("NguoiTao"));
                nv.setNoiCap(rs.getString("NoiCapCMND"));
                nv.setSDT(rs.getString("SDT"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                setComponent(nv);

            }
        } catch (SQLException ex) {
            GUI.ThongBao.ThongBao("Lỗi khi click vào bảng nhân viên!", "Thông báo");
        }
    }

    public static boolean update() {
//        code validate
        if (!kiemTra("MaNV")) {
            ThongBao.ThongBao("Mã nhân viên là số và bao gồm 5 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("hoVaTen")) {
            ThongBao.ThongBao("Họ tên gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("SDT")) {
            ThongBao.ThongBao("Phải đủ 10 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("cmnd")) {
            ThongBao.ThongBao("Phải đủ 9 kí tự!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaycapcm")) {
            ThongBao.ThongBao("Ngày cấp phải bé hơn ngày hiện tại!", "Thông báo!");
            return false;
        }
        if (!kiemTra("noicap")) {
            ThongBao.ThongBao("Không được bỏ trống!", "Thông báo!");
            return false;
        }
        if (!kiemTra("ngaysinh")) {
            ThongBao.ThongBao("Phải lớn hơn hoặc bằng 18 tuổi!", "Thông báo!");
            return false;
        }
        if (!kiemTra("email")) {
            ThongBao.ThongBao("Sai định dạng email!", "Thông báo!");
            return false;
        }
        if (!kiemTra("diachi")) {
            ThongBao.ThongBao("Địa chỉ gồm 5 đến 50 kí tự!", "Thông báo!");
            return false;
        }
        ResultSet rsMail = DAO.selectByID.emailNhanVien(txtEmail.getText());
        try {
            if (rsMail.next()) {
                lblTBEmail.setText("!");
                GUI.ThongBao.ThongBao("Email đã được sử dụng!", "Thông báo");
                return false;

            }
        } catch (SQLException ex) {

        }
        DTO_NhanVien nv = new DTO_NhanVien();
        getComponent(nv);
        if (DAO.update.NhanVien(nv) > 0) {
            GUI.ThongBao.ThongBao("Cập nhật thành công!", "Thông báo");
            loadBangNV("");
            return true;
        }
        GUI.ThongBao.ThongBao("Cập nhật thất bại!", "Thông báo");
        return false;
    }

    public static void refresh() {
        jdlAddNhanVien.txtMaNV.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtNgayCap.setEnabled(true);
        txtNoiCapCMND.setText("");
        txtNgaySinh.setEnabled(true);
        txtEmail.setText("");
        txtDC.setText("");
        txtLuong.setText("");
        txtKiQuy.setText("");
    }

    //Kiem tra trước khi thêm
    public static boolean kiemTra(String component) {
        boolean kt = true;
        switch (component) {
            case "MaNV":
                if (!jdlAddNhanVien.txtMaNV.getText().matches("^[a-zA-Z0-9]{5}$")) {
                    jdlAddNhanVien.lblMaNV.setText("!");
                    kt = false;
                    break;
                }
                jdlAddNhanVien.lblMaNV.setText("");
                kt = true;
                break;
            case "hoVaTen":
                try {
                    String hoten = ChuyenDoi.unAccent(txtHoTen.getText());
                    if (!hoten.matches("^[a-zA-Z\\s+]{5,50}$")) {
                        jdlAddNhanVien.lblTBHoTen.setText("!");
                        kt = false;
                        break;
                    }
                } catch (Exception e) {
                    kt = false;
                    break;
                }
                kt = true;
                jdlAddNhanVien.lblTBHoTen.setText("");
                break;
            case "SDT":
                if (jdlAddNhanVien.txtSDT.getText().length() < 10) {
                    kt = false;
                    lblTBSDT.setText("!");
                    break;
                } else {
                    lblTBSDT.setText("");
                    kt = true;
                    break;
                }
            case "cmnd":
                if (jdlAddNhanVien.txtCMND.getText().length() < 9) {
                    kt = false;
                    lblTBCMND.setText("!");
                    break;
                } else {
                    lblTBCMND.setText("");
                    kt = true;
                    break;
                }
            case "ngaycapcm":
                Date ngaycap = txtNgayCap.getDate();
                Date date = new Date();
                if (date.before(ngaycap)) {
                    kt = false;
                    lblTBNgayCap.setText("!");
                    break;
                }
                lblTBNgayCap.setText("");
                kt = true;
                break;
            case "noicap":
                if (txtNoiCapCMND.getText().length() == 0) {
                    kt = false;
                    lblTBNoiCap.setText("!");
                    break;
                }
                lblTBNoiCap.setText("");
                kt = true;
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
            case"email":
                String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
                if(!txtEmail.getText().matches(regex)){
                    lblTBEmail.setText("!");
                    kt = false;
                    break;
                }
                kt = true;
                lblTBEmail.setText("");
                break;
            case "diachi":
                try {
                    String diachi = ChuyenDoi.unAccent(txtDC.getText());
                    if (!diachi.matches("^[a-zA-Z0-9\\s+]{5,100}$")) {
                        jdlAddNhanVien.lblTBDC.setText("!");
                        kt = false;
                        break;
                    }
                } catch (Exception e) {
                    kt = false;
                    break;
                }
                kt = true;
                jdlAddNhanVien.lblTBDC.setText("");
                break;    
        }
        return kt;
    }

    public static boolean saveLogo(File file) {
        File dir = new File("logosNhanVien");
        //Tạo thư mục nếu chưa tồn tại
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            //Copy vào thư mục logosNhanVien (đè lên nếu đã tồn tại)
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("logosNhanVien", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static void selectImage() {
        if (jdlAddNhanVien.fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            File FILE = jdlAddNhanVien.fileChooser.getSelectedFile();
            if (!FILE.getName().matches(".+(\\.png|\\.jpg|\\.gif)$")) {
                GUI.ThongBao.ThongBao("Đây không phải hình ảnh!", "Thông báo");
                return;
            }
            if (saveLogo(FILE)) {
                //Hiển thị hình lên form
                jdlAddNhanVien.lblHinhAnh.setIcon(readLogo(FILE.getName()));
                jdlAddNhanVien.lblHinhAnh.setToolTipText(FILE.getName());
            }
        }
    }

    public static boolean delete(JTable tbl) {
        int dongXoa[] = tbl.getSelectedRows();
        if (ThongBao.ThongBaoLoai2("Bạn có chắc chắn muốn xóa không?", "Thông báo") != JOptionPane.OK_OPTION) {
            return false;
        }
        for (int i = dongXoa.length - 1; i >= 0; i--) {
            String id = tbl.getValueAt(dongXoa[i], 2).toString();
            DAO.delete.xoaNhanVien(tbl.getValueAt(dongXoa[i], 1).toString());
        }
        GUI.ThongBao.ThongBao("Xóa thành công!", "Thông báo");
        return true;
    }
}
