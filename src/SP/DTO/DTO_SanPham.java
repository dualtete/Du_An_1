/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DTO;

import java.util.Date;

/**
 *
 * @author bumte
 */
public class DTO_SanPham {
    String barcode;
    String tenSP;
    boolean trangThai;
    String idLoaiSP;
    String hangSX;
    int hanBH;
    String TTBaoHanh;
    String TTSanPham;
    Date ngayThem;
    int nguoiThem;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(String idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public int getHanBH() {
        return hanBH;
    }

    public void setHanBH(int hanBH) {
        this.hanBH = hanBH;
    }

    public String getTTBaoHanh() {
        return TTBaoHanh;
    }

    public void setTTBaoHanh(String TTBaoHanh) {
        this.TTBaoHanh = TTBaoHanh;
    }

    public String getTTSanPham() {
        return TTSanPham;
    }

    public void setTTSanPham(String TTSanPham) {
        this.TTSanPham = TTSanPham;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public int getNguoiThem() {
        return nguoiThem;
    }

    public void setNguoiThem(int nguoiThem) {
        this.nguoiThem = nguoiThem;
    }
    
}
