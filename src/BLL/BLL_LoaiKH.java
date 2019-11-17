/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTO_LoaiKH;
import static GUI.LoaiKhachHang.*;
import GUI.ThongBao;

/**
 *
 * @author bumte
 */
public class BLL_LoaiKH {

    public static boolean insert() {
        // code validate

        DTO.DTO_LoaiKH loaiKH = new DTO_LoaiKH();
        //loaiKH.setMoTa(txtMoTa1.getText());
        loaiKH.setTenLoai(txtTenLoaiKH.getText());
        loaiKH.setTrangThai(true);
        if (DAO.insert.LoaiKH(loaiKH) > 0) {
            ThongBao.ThongBao("Thêm thành công!", "Thông báo");
            BLL_KhachHang.loadDSLoaiKH();
            return true;
        }
        System.out.println("Thêm loại khách hàng thất bại");
        return false;
    }

}
