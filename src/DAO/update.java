/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BLL.ChuyenDoi;
import java.util.Date;

/**
 *
 * @author bumte
 */
public class update {

    public static int NhaCungCap(DTO.DTO_NhaCungCap ncc) {
        String cauLenh = "set dateformat dMy UPDATE [dbo].[NHACUNGCAP] "
                + "   SET [IDNCC] = '" + ncc.getID() + "' "
                + "      ,[TenNCC] = N'" + ncc.getTenNCC() + "' "
                + "      ,[LoaiHinh] = N'" + ncc.getLoaiHinh() + "' "
                + "      ,[DC] = N'" + ncc.getDC() + "' "
                + "      ,[NhomNCC] = N'" + ncc.getNhomNCC() + "' "
                + "      ,[SDT] = '" + ncc.getSDT() + "' "
                + "      ,[MSThue] = '" + ncc.getMSThue() + "' "
                + "      ,[NguoiLH] = N'" + ncc.getNguoiLH() + "' "
                + "      ,[Email] = '" + ncc.getEmail() + "' "
                + "      ,[GhiChu] = N'" + ncc.getGhiChu() + "' "
                + "      ,[TrangWeb] = '" + ncc.getTrangWeb() + "' "
                + "      ,[TKNganHang] = '" + ncc.getTKNganHang() + "' "
                + "      ,[TenNganHang] = N'" + ncc.getTenNH() + "' "
                + "      ,[TrangThai] = 'True' "
                + "	  ,[NgayThem] = '" + ncc.getNgayThem() + "' "
                + " WHERE IDNCC = '" + ncc.getID() + "'";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int Quyen(DTO.DTO_Quyen q) {
        Date date = new Date();
        String cauLenh = "Set dateformat dMy UPDATE [dbo].[QUYEN] "
                + "   SET [TenQuyen] = N'" + q.getTenQuyen() + "' "
                + "      ,[MoTa] = N'" + q.getMoTa() + "' "
                + "      ,[NgaySua] = '" + BLL.ChuyenDoi.GetNgay(date) + "' "
                + "      ,[NguoiSua] = N'" + DTO.DTO_UserLogin.userName + "' "
                + " WHERE IDQuyen = " + q.getMaQuyen() + "";
        return DBConnection.ExecuteData(cauLenh);
    }
    //Update trước khi in hoá đơn 
    public static int udinHoaDon(String id) {
        String cauLenh = "UPDATE [dbo].[HOADON]  "
                + "   SET [TrangThai] = 'true'  "
                + " WHERE IDHD = '"+id+"'";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int NhanVien(DTO.DTO_NhanVien nv) {
        String cauLenh = "set dateformat dMy UPDATE [dbo].[NHANVIEN] "
                + "   SET [HoTen] = N'" + nv.getHoTen() + "' "
                + "      ,[SDT] = '" + nv.getSDT() + "' "
                + "      ,[CMND] = '" + nv.getCMND() + "' "
                + "      ,[NgayCapCMND] = '" + BLL.ChuyenDoi.GetNgay(nv.getNgayCap()) + "' "
                + "      ,[NoiCapCMND] = N'" + nv.getNoiCap() + "' "
                + "      ,[NgaySinh] = '" + BLL.ChuyenDoi.GetNgay(nv.getNgaySinh()) + "' "
                + "      ,[GioiTinh] = '" + nv.isGioiTinh() + "' "
                + "      ,[HinhAnh] = N'" + nv.getHinhAnh() + "' "
                + "      ,[Email] = '" + nv.getEmail() + "' "
                + "      ,[DC] = N'" + nv.getDC()+ "' "
                + "      ,[Luong] = " + nv.getLuong() + " "
                + "      ,[TienKiQuy] = " + nv.getKiQuy() + " "
                + " WHERE IDNV = '" + nv.getIDNV() + "'";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int KhachHang(DTO.DTO_KhachHang kh) {
        String cauLenh = "set dateformat dMy UPDATE [dbo].[KHACHHANG] "
                + "   SET IDKH = '" + kh.getIDKH() + "' "
                + "	  ,[HoTen] = N'" + kh.getHoTen() + "' "
                + "      ,[IDLoaiKH] = '" + kh.getIDLoaiKH() + "' "
                + "      ,[SDT] = '" + kh.getSDT() + "' "
                + "      ,[DC] = N'" + kh.getDC() + "' "
                + "      ,[Email] = '" + kh.getEmail() + "' "
                + "      ,[NgaySinh] ='" + BLL.ChuyenDoi.GetNgay(kh.getNgaySinh()) + "' "
                + "      ,[GioiTinh] = '" + kh.isGioiTinh() + "' "
                + "      ,[GhiChu] = N'" + kh.getGhiChu() + "' "
                + "      ,[NgayThem] = '" + BLL.ChuyenDoi.GetNgay(kh.getNgayThem()) + "' "
                + "      ,[IDTK] = '" + kh.getIDTK() + "' "
                + " WHERE IDKH = '" + kh.getIDKH() + "'";
        return DBConnection.ExecuteData(cauLenh);
    }
}
