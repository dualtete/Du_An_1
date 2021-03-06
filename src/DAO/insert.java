/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BLL.ChuyenDoi;
import DTO.DTO_HoaDon;
import com.sun.javafx.sg.prism.NGAmbientLight;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bumte
 */
public class insert {

    public static int NhaCungCap(DTO.DTO_NhaCungCap ncc) {
        String cauLenh = " set dateformat dMy INSERT INTO [dbo].[NHACUNGCAP] "
                + "           ([IDNCC] "
                + "           ,[TenNCC] "
                + "           ,[LoaiHinh] "
                + "           ,[DC] "
                + "           ,[NhomNCC] "
                + "           ,[SDT] "
                + "           ,[MSThue] "
                + "           ,[NguoiLH] "
                + "           ,[Email] "
                + "           ,[GhiChu] "
                + "           ,[TrangWeb] "
                + "           ,[TKNganHang] "
                + "           ,[TenNganHang] "
                + "           ,[TrangThai] "
                + "           ,[NgayThem]) "
                + "     VALUES "
                + "           ('" + ncc.getID() + "' "
                + "           ,N'" + ncc.getTenNCC() + "' "
                + "           ,N'" + ncc.getLoaiHinh() + "' "
                + "           ,N'" + ncc.getDC() + "' "
                + "           ,N'" + ncc.getNhomNCC() + "' "
                + "           ,'" + ncc.getSDT() + "' "
                + "           ,'" + ncc.getMSThue() + "' "
                + "           ,N'" + ncc.getNguoiLH() + "' "
                + "           ,'" + ncc.getEmail() + "' "
                + "           ,N'" + ncc.getGhiChu() + "' "
                + "           ,'" + ncc.getTrangWeb() + "' "
                + "           ,'" + ncc.getTKNganHang() + "' "
                + "           ,N'" + ncc.getTenNH() + "' "
                + "           ,'true' "
                + "           ,'" + ncc.getNgayThem() + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int Quyen(DTO.DTO_Quyen quyen) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[QUYEN] "
                + "           ([TenQuyen] "
                + "           ,[MoTa] "
                + "           ,[NguoiTao] "
                + "           ,[NgayTao] "
                + "           ,[NgaySua] "
                + "           ,[NguoiSua]) "
                + "     VALUES "
                + "           (N'" + quyen.getTenQuyen() + "' "
                + "           ,N'" + quyen.getMoTa() + "' "
                + "           ,'" + quyen.getNguoiTao() + "' "
                + "           ,'" + quyen.getNgayTao() + "' "
                + "           ,'" + quyen.getNgaySua() + "' "
                + "           ,'" + quyen.getNguoiSua() + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int NhanVien(DTO.DTO_NhanVien nv) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[NHANVIEN] "
                + "           ([IDNV] "
                + "           ,[HoTen] "
                + "           ,[SDT] "
                + "           ,[CMND] "
                + "           ,[NgayCapCMND] "
                + "           ,[NoiCapCMND] "
                + "           ,[NgaySinh] "
                + "           ,[GioiTinh] "
                + "           ,[HinhAnh] "
                + "           ,[Email] "
                + "           ,[DC] "
                + "           ,[NgayVaoLam] "
                + "           ,[Luong] "
                + "           ,[TrangThai] "
                + "           ,[TienKiQuy] "
                + "           ,[NguoiTao]) "
                + "     VALUES "
                + "           (N'" + nv.getIDNV() + "'"
                + "           ,N'" + nv.getHoTen() + "'"
                + "           ,'" + nv.getSDT() + "' "
                + "           ,'" + nv.getCMND() + "' "
                + "           ,'" + BLL.ChuyenDoi.GetNgay(nv.getNgayCap()) + "' "
                + "           ,N'" + nv.getNoiCap() + "' "
                + "           ,'" + BLL.ChuyenDoi.GetNgay(nv.getNgaySinh()) + "' "
                + "           ,'" + nv.isGioiTinh() + "' "
                + "           ,N'" + nv.getHinhAnh() + "' "
                + "           ,'" + nv.getEmail() + "' "
                + "           ,N'" + nv.getDC() + "' "
                + "           ,'" + nv.getNgayVaoLam() + "' "
                + "           ," + nv.getLuong() + " "
                + "           ,'true' "
                + "           ," + nv.getKiQuy() + " "
                + "           ,N'" + nv.getNguoiTao() + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int TaiKhoan(DTO.DTO_TaiKhoan tk) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[TAIKHOAN] "
                + "           ([UserName] "
                + "           ,[PassWords] "
                + "           ,[NgayLap] "
                + "           ,[IDNV] "
                + "           ,[IDQuyen] "
                + "           ,[TrangThai] "
                + "           ,[NguoiLap]) "
                + "     VALUES "
                + "           ('" + tk.getUserName() + "' "
                + "           ,'" + tk.getPass() + "' "
                + "           ,'" + tk.getNgaylap() + "' "
                + "           ,'" + tk.getIDNV() + "' "
                + "           ,'" + tk.getIDQuyen() + "' "
                + "           ,'" + tk.isTrangThai() + "' "
                + "           ,'" + tk.getNguoiLap() + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int KhachHang(DTO.DTO_KhachHang kh) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[KHACHHANG] "
                + "           ([IDKH] "
                + "           ,[HoTen] "
                + "           ,[IDLoaiKH] "
                + "           ,[SDT] "
                + "           ,[DC] "
                + "           ,[Email] "
                + "           ,[NgaySinh] "
                + "           ,[GioiTinh] "
                + "           ,[GhiChu] "
                + "           ,[TrangThai] "
                + "           ,[IDTK]) "
                + "     VALUES "
                + "           ('" + kh.getIDKH() + "' "
                + "           ,N'" + kh.getHoTen() + "' "
                + "           ,'" + kh.getIDLoaiKH() + "' "
                + "           ,'" + kh.getSDT() + "' "
                + "           ,N'" + kh.getDC() + "' "
                + "           ,'" + kh.getEmail() + "' "
                + "           ,'" + BLL.ChuyenDoi.GetNgay(kh.getNgaySinh()) + "' "
                + "           ,'" + kh.isGioiTinh() + "' "
                + "           ,N'" + kh.getGhiChu() + "' "
                + "           ,'" + kh.isTrangThai() + "' "
                + "           ," + kh.getIDTK() + ")";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int LoaiKH(DTO.DTO_LoaiKH loaiKH) {
        String cauLenh = "INSERT INTO [dbo].[LOAIKHACHHANG] "
                + "           ([TenLoaiKH] "
                + "           ,[GhiChu] "
                + "           ,[TrangThai]) "
                + "     VALUES "
                + "           (N'" + loaiKH.getTenLoai() + "' "
                + "           ,N'" + loaiKH.getMoTa() + "' "
                + "           ,'true')";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int ThemHoaDon(DTO.DTO_HoaDon hd) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[HOADON] "
                + "           ([IDHD] "
                + "           ,[NgayTaoHD] "
                + "           ,[IDKH] "
                + "           ,[TrangThai] "
                + "           ,[IDTK] "
                + "           ,[TongTien]) "
                + "     VALUES "
                + "           ('" + hd.getIdHoaDon() + "' "
                + "           ,'" + ChuyenDoi.dateTimeString(hd.getNgayTaoHD()) + "' "
                + "           ,'" + hd.getIdKH() + "' "
                + "           ,'" + hd.isTrangThai() + "' "
                + "           ," + hd.getIdTK() + " "
                + "           ," + hd.getTongTien() + ")";
        System.out.println(cauLenh);
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int ThemCTHoaDon(DTO.DTO_CTHoaDon cthd) {
        String cauLenh = "INSERT INTO [dbo].[CT_HOADON] "
                + "           ([IDCTHoaDon] "
                + "           ,[IDHD] "
                + "           ,[IDCTPhieuNhap] "
                + "           ,[Barcode] "
                + "           ,[SoLuong] "
                + "           ,[DonGia] "
                + "           ,[ThanhTien] "
                + "           ,[IDBH] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           ('" + cthd.getIdCTHD() + "' "
                + "           ,'" + cthd.getIdHD() + "' "
                + "           ,'" + cthd.getIdCTPhieuNhap() + "' "
                + "           ,'" + cthd.getBarcode() + "' "
                + "           ," + cthd.getSl() + " "
                + "           ," + cthd.getDonGia() + " "
                + "           ," + cthd.getThanhTien() + " "
                + "           ,'" + cthd.getIdBH() + "' "               
                + "           ,N'" + cthd.getGhiChu() + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

}
