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
public class DTO_PhieuNhap {

    String IDPN;
    String IDNCC;
    String NgayTao;
    int NguoiTao;
    int TrangThai;
    double TongTien;

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getIDPN() {
        return IDPN;
    }

    public void setIDPN(String IDPN) {
        this.IDPN = IDPN;
    }

    public String getIDNCC() {
        return IDNCC;
    }

    public void setIDNCC(String IDNCC) {
        this.IDNCC = IDNCC;
    }

    

    public int getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(int NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
