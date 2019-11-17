/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DTO;

/**
 *
 * @author bumte
 */
public class DTO_SanhPham {
    String barcode;
    String tenSP;
    boolean trangThai;
    int idLoaiSP;
    int hanBH;
    String ttBaoHanh;
    String ttSanPham;
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

    public int getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(int idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public int getHanBH() {
        return hanBH;
    }

    public void setHanBH(int hanBH) {
        this.hanBH = hanBH;
    }

    public String getTtBaoHanh() {
        return ttBaoHanh;
    }

    public void setTtBaoHanh(String ttBaoHanh) {
        this.ttBaoHanh = ttBaoHanh;
    }

    public String getTtSanPham() {
        return ttSanPham;
    }

    public void setTtSanPham(String ttSanPham) {
        this.ttSanPham = ttSanPham;
    }

    public int getNguoiThem() {
        return nguoiThem;
    }

    public void setNguoiThem(int nguoiThem) {
        this.nguoiThem = nguoiThem;
    }
    
}
