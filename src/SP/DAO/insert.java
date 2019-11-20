/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DAO;

import DAO.DBConnection;
import java.sql.ResultSet;
//import com.sun.corba.se.impl.orbutil.ORBConstants;

/**
 *
 * @author bumte
 */
public class insert {

    public static int insertPhieuNhap(SP.DTO.DTO_PhieuNhap pn) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[PHIEUNHAP] "
                + "           ([IDPN] "
                + "           ,[IDNCC] "
                + "           ,[NgayTao] "
                + "           ,[NguoiTao] "
                + "           ,[TrangThai] "
                + "           ,[TongTien]) "
                + "     VALUES "
                + "           ('" + pn.getIDPN() + "' "
                + "           ,'" + pn.getIDNCC() + "' "
                + "           ,'" + pn.getNgayTao() + "' "
                + "           ," + pn.getNguoiTao() + " "
                + "           ," + pn.getTrangThai() + " "
                + "           ," + pn.getTongTien() + ")";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int insertChiTietPhieuNhap(SP.DTO.DTO_ChiTietPhieuNhap ctpn) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[CT_PHIEUNHAP] "
                + "           ([IDPN] "
                + "           ,[Soluong] "
                + "           ,[DonVi] "
                + "           ,[GiaNhap] "
                + "           ,[GiaSi] "
                + "           ,[GiaLe] "
                + "           ,[TongTien] "
                + "           ,[GhiChu] "
                + "           ,[Barcode] "
                + "           ,[NgayThem] "
                + "           ,[NguoiThem] "
                + "           ,[LanNhap] "
                + "           ,[NguoiNhap] )"
                + "     VALUES "
                + "           ('" + ctpn.getIDPN() + "' "
                + "           ," + ctpn.getSoluong() + " "
                + "           ,N'" + ctpn.getDonVi() + "' "
                + "           ," + ctpn.getGiaNhap() + " "
                + "           ," + ctpn.getGiaSi() + " "
                + "           ," + ctpn.getGiaLe() + " "
                + "           ," + ctpn.getTongTien() + " "
                + "           ,N'" + ctpn.getGhiChu() + "' "
                + "           ,'" + ctpn.getBarcode() + "' "
                + "           ,'" + ctpn.getNgayThem() + "' "
                + "           ,'" + ctpn.getNguoiThem() + "' "
                + "           ," + ctpn.getLanNhap() + " "
                + "           ,'" + ctpn.getNguoiNhap() + "') ";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int ThemSanPham(SP.DTO.DTO_SanPham sp) {
        String cauLenh = "set dateformat dMy INSERT INTO [dbo].[SANPHAM] "
                + "           ([Barcode] "
                + "           ,[TenSP] "
                + "           ,[TrangThai] "
                + "           ,[IDLoaiSP] "
                + "           ,[HangSX] "
                + "           ,[HanBH] "
                + "           ,[ThongTinBH] "
                + "           ,[ThongTinSP] "
                + "           ,[NguoiThem]) "
                + "     VALUES "
                + "           ('" + sp.getBarcode() + "' "
                + "           ,N'" + sp.getTenSP() + "' "
                + "           ,'" + sp.isTrangThai() + "' "
                + "           ," + sp.getIdLoaiSP() + " "
                + "           ,N'" + sp.getHangSX() + "' "
                + "           ," + sp.getHanBH() + " "
                + "           ,N'" + sp.getTTBaoHanh() + "' "
                + "           ,N'" + sp.getTTSanPham() + "' "
                + "           ," + sp.getNguoiThem() + ")";
        return DAO.DBConnection.ExecuteData(cauLenh);
    }

    public static int ThemLoaiSP(String tenLoai, String ghiChu, boolean trangThai) {
        String cauLenh = "INSERT INTO [dbo].[LOAISANPHAM] "
                + "           ([TenLoaiSP] "
                + "           ,[GhiChu] "
                + "           ,[TrangThai]) "
                + "     VALUES "
                + "           (N'" + tenLoai + "' "
                + "           ,N'" + ghiChu + "' "
                + "           ,'" + trangThai + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int NhapSPVaoKho(SP.DTO.DTO_SanPham sp) {
        String cauLenh = "INSERT INTO [dbo].[SANPHAM] "
                + "           ([Barcode] "
                + "           ,[TenSP] "
                + "           ,[TrangThai] "
                + "           ,[IDLoaiSP] "
                + "           ,[HangSX] "
                + "           ,[HanBH] "
                + "           ,[ThongTinBH] "
                + "           ,[ThongTinSP] "
                + "           ,[NguoiThem]) "
                + "     VALUES "
                + "           ('" + sp.getBarcode() + "' "
                + "           ,N'" + sp.getTenSP() + "' "
                + "           ,'" + sp.isTrangThai() + "' "
                + "           ," + sp.getIdLoaiSP() + " "
                + "           ,N'" + sp.getHangSX() + "' "
                + "           ," + sp.getHanBH() + " "
                + "           ,N'" + sp.getTTBaoHanh() + "' "
                + "           ,N'" + sp.getTTSanPham() + "' "
                + "           ," + sp.getNguoiThem() + ")";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int sanPhamTrongKho(SP.DTO.DTO_HangTonKho htk) {
        String cauLenh = "INSERT INTO [dbo].[SANPHAMTRONGKHO] "
                + "           ([MaVach] "
                + "           ,[SeriSP] "
                + "           ,[IDCTPN] "
                + "           ,[ChiTiet] "
                + "           ,[IDViTriHienTai] "
                + "           ,[barcode] "
                + "           ,[giale] "
                + "           ,[Giasi] "
                + "           ,[TrangThai]) "
                + "     VALUES "
                + "           ('" + htk.getMaVach() + "' "
                + "           ,'" + htk.getSeriSP() + "' "
                + "           ," + htk.getIDCTPN() + " "
                + "           ,N'" + htk.getChiTiet() + "' "
                + "           ,'" + htk.getIDViTriHienTai() + "' "
                + "           ,'" + htk.getBarcode() + "' "
                + "           ," + htk.getGiaLe() + " "
                + "           ," + htk.getGiaSi() + " "
                + "           ,'" + htk.isTrangThai() + "')";
        return DBConnection.ExecuteData(cauLenh);
    }

}
