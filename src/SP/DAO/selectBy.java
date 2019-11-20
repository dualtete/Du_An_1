/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DAO;

import DAO.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author bumte
 */
public class selectBy {

    public static ResultSet SanPham_CTPhieuNhap_ByIDPN_LanNhap(String IDPN, int lanNhap) {
        String cauLenh = "select * from SANPHAM join CT_PHIEUNHAP on SANPHAM.Barcode = CT_PHIEUNHAP.Barcode "
                + "where CT_PHIEUNHAP.IDPN = N'" + IDPN + "' and (LanNhap = " + lanNhap + ")";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet Select_SanPham_CTPhieuNhap_ByBarcode(String barcode) {
        String cauLenh = "select top 1 * from SANPHAM  FULL OUTER JOIN CT_PHIEUNHAP  on SANPHAM.Barcode = CT_PHIEUNHAP.Barcode "
                + "FULL OUTER JOIN LOAISANPHAM on LOAISANPHAM.IDLoaiSP = SANPHAM.IDLoaiSP "
                + "where SANPHAM.Barcode = '" + barcode + "' "
                + "order by NgayNhap desc";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet checkBarcodeSanPham(String barcode) {
        String cauLenh = "select * from SanPham where barcode = '" + barcode + "' and (trangthai = 'true')";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet selectLoaiSPByTen(String ten) {
        String cauLenh = "select * from loaiSanPham where tenLoaiSP = N'" + ten + "'";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet PhieuNhapByTrangThai(int TrangThai) {
        return DBConnection.getData("select * from ShowPhieuNhap where TrangThaiPhieNhap = " + TrangThai + "");
    }

    public static ResultSet PhieuNhapByIDPhieuNhap(String idPN) {
        return DBConnection.getData("select * from ShowPhieuNhap where IDPhieuNhap = '" + idPN + "'");
    }

    public static ResultSet CTPhieuNhap_By_IDPN(String idPN) {
        return DBConnection.getData("select * from CT_PhieuNhap where IDPN = '" + idPN + "' ");
    }

    public static ResultSet HangTonKhoByPN_TrangThai(String IDPN, boolean TrangThai) {
        String cauLenh = "select * from HangTonKhoByPhieuNhap where idphieunhap = '" + IDPN + "' and (trangthaitk = '" + TrangThai + "')";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet HangTonKhoByTrangThai(boolean trangThai) {
        String cauLenh = "select * from HangTonKhoByPhieuNhap where trangthaitk = '" + trangThai + "'";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet HangTonKho_ByIDViTri(String id) {
        String cauLenh = "SELECT [TenSP] "
                + "      ,[HangSX] "
                + "      ,[TenLoaiSP] "
                + "      ,[masp] "
                + "      ,[giasi] "
                + "      ,[giale] "
                + "	  , COUNT(masp) as soluong "
                + "  FROM [dbo].[hangtonkho] "
                + "   where idvitrihientai = '" + id + "' "
                + "  group by [TenSP] "
                + "      ,[HangSX] "
                + "      ,[TenLoaiSP] "
                + "      ,[masp] "
                + "      ,[giasi] "
                + "      ,[giale] ";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet View_PhieuNhapDaDat(int trangThai) {
        String cauLenh = "select * from view_phieuNhapdadat where trangthai = " + trangThai + "";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet view_PhieuNhapByID(String id) {
        String cauLenh = "select * from view_phieuNhapdadat where idpn = '" + id + "'";
        return DBConnection.getData(cauLenh);
    }

    public static ResultSet view_CTPhieuNhap(String idPN) {
        String cauLenh = "select * from view_CTPhieuNhap where IDPN = '" + idPN + "'";
        return DBConnection.getData(cauLenh);
    }
}
