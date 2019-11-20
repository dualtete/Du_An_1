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
    String barcode;
    String IDViTriHienTai;
    boolean trangThai;
    double giaLe;
    double giaSi;

    public double getGiaLe() {
        return giaLe;
    }

    public void setGiaLe(double giaLe) {
        this.giaLe = giaLe;
    }

    public double getGiaSi() {
        return giaSi;
    }

    public void setGiaSi(double giaSi) {
        this.giaSi = giaSi;
    }

    public DTO_HangTonKho(String maVach, String seriSP, String IDCTPN, String chiTiet, String barcode, boolean trangThai, double giaLe, double giaSi) {
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
        this.chiTiet = chiTiet;
        this.barcode = barcode;
        this.trangThai = trangThai;
        this.giaLe = giaLe;
        this.giaSi = giaSi;
    }

    public DTO_HangTonKho(String maVach, String seriSP, String IDCTPN, String chiTiet, String barcode, boolean trangThai) {
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
        this.chiTiet = chiTiet;
        this.barcode = barcode;
        this.trangThai = trangThai;
    }

    public DTO_HangTonKho(int idHangTonKho) {
        this.idHangTonKho = idHangTonKho;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach, String seriSP) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
        this.seriSP = seriSP;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach, String seriSP, String IDCTPN) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach, String seriSP, String IDCTPN, String chiTiet) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
        this.chiTiet = chiTiet;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach, String seriSP, String IDCTPN, String chiTiet, String barcode) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
        this.chiTiet = chiTiet;
        this.barcode = barcode;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach, String seriSP, String IDCTPN, String chiTiet, String barcode, String IDViTriHienTai) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
        this.chiTiet = chiTiet;
        this.barcode = barcode;
        this.IDViTriHienTai = IDViTriHienTai;
    }

    public DTO_HangTonKho(int idHangTonKho, String maVach, String seriSP, String IDCTPN, String chiTiet, String barcode, String IDViTriHienTai, boolean trangThai) {
        this.idHangTonKho = idHangTonKho;
        this.maVach = maVach;
        this.seriSP = seriSP;
        this.IDCTPN = IDCTPN;
        this.chiTiet = chiTiet;
        this.barcode = barcode;
        this.IDViTriHienTai = IDViTriHienTai;
        this.trangThai = trangThai;
    }

    public DTO_HangTonKho(String seriSP, String chiTiet, String IDViTriHienTai, boolean trangThai) {
        this.seriSP = seriSP;
        this.chiTiet = chiTiet;
        this.IDViTriHienTai = IDViTriHienTai;
        this.trangThai = trangThai;
    }

    

    
    

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

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
