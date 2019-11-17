/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author bumte
 */
public class DTO_ViTriHangHoa {

    String IDViTri;
    String IDKho;
    String TenKho;
    String IDLo;
    String tenLo;
    String GhiChu;
    int trangThai;

    public DTO_ViTriHangHoa() {
    }

    public DTO_ViTriHangHoa(String IDViTri, String IDKho, String TenKho, String IDLo, String tenLo, String GhiChu, int trangThai) {
        this.IDViTri = IDViTri;
        this.IDKho = IDKho;
        this.TenKho = TenKho;
        this.IDLo = IDLo;
        this.tenLo = tenLo;
        this.GhiChu = GhiChu;
        this.trangThai = trangThai;
    }

    public String getTenLo() {
        return tenLo;
    }

    public void setTenLo(String tenLo) {
        this.tenLo = tenLo;
    }

    public DTO_ViTriHangHoa(String IDKho, String TenKho) {
        this.IDKho = IDKho;
        this.TenKho = TenKho;
    }

    public DTO_ViTriHangHoa(String IDViTri, String IDKho, String TenKho, int trangThai) {
        this.IDViTri = IDViTri;
        this.IDKho = IDKho;
        this.TenKho = TenKho;
        this.trangThai = trangThai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public DTO_ViTriHangHoa(String IDViTri, String IDKho, String TenKho, String IDLo, String GhiChu, int trangThai) {
        this.IDViTri = IDViTri;
        this.IDKho = IDKho;
        this.TenKho = TenKho;
        this.IDLo = IDLo;
        this.GhiChu = GhiChu;
        this.trangThai = trangThai;
    }

    public DTO_ViTriHangHoa(String IDViTri, String IDKho, String TenKho, String IDLo, String GhiChu) {
        this.IDViTri = IDViTri;
        this.IDKho = IDKho;
        this.TenKho = TenKho;
        this.IDLo = IDLo;
        this.GhiChu = GhiChu;
    }

    public DTO_ViTriHangHoa(String IDViTri, String IDKho, String TenKho, String IDLo) {
        this.IDViTri = IDViTri;
        this.IDKho = IDKho;
        this.TenKho = TenKho;
        this.IDLo = IDLo;
    }

    public DTO_ViTriHangHoa(String IDViTri, String IDKho, String TenKho) {
        this.IDViTri = IDViTri;
        this.IDKho = IDKho;
        this.TenKho = TenKho;
    }

    public DTO_ViTriHangHoa(String IDViTri) {
        this.IDViTri = IDViTri;
    }

    public String getIDViTri() {
        return IDViTri;
    }

    public void setIDViTri(String IDViTri) {
        this.IDViTri = IDViTri;
    }

    public String getIDKho() {
        return IDKho;
    }

    public void setIDKho(String IDKho) {
        this.IDKho = IDKho;
    }

    public String getTenKho() {
        return TenKho;
    }

    public void setTenKho(String TenKho) {
        this.TenKho = TenKho;
    }

    public String getIDLo() {
        return IDLo;
    }

    public void setIDLo(String IDLo) {
        this.IDLo = IDLo;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}
