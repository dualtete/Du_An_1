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
public class DTO_HangTonKho {
    int idHangTonKho;
    String maVach;
    String seriSP;
    String IDCTPN;
    String chiTiet;
    String IDViTriHienTai;
    boolean trangThai;

    public int getIdHangTonKho() {
        return idHangTonKho;
    }

    public void setIdHangTonKho(int idHangTonKho) {
        this.idHangTonKho = idHangTonKho;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getSeriSP() {
        return seriSP;
    }

    public void setSeriSP(String seriSP) {
        this.seriSP = seriSP;
    }

    public String getIDCTPN() {
        return IDCTPN;
    }

    public void setIDCTPN(String IDCTPN) {
        this.IDCTPN = IDCTPN;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public String getIDViTriHienTai() {
        return IDViTriHienTai;
    }

    public void setIDViTriHienTai(String IDViTriHienTai) {
        this.IDViTriHienTai = IDViTriHienTai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
