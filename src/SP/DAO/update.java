/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.DAO;

import BLL.ChuyenDoi;
import DAO.DBConnection;
import java.util.Date;

/**
 *
 * @author bumte
 */
public class update {

    public static int UpdatePhieuNhap(double tongTien, String IDPN) {
        String cauLenh = "UPDATE [dbo].[PHIEUNHAP] "
                + "   SET [TrangThai] = 1 "
                + "      ,[TongTien] = " + tongTien
                + " "
                + " WHERE IDPN = '" + IDPN + "'";
        return DBConnection.ExecuteData(cauLenh);

    }

    public static int UpdateCTPN(String ngayNhap, int lanNhap, String nguoiNhap, String viTri, String IDPN) {
        String cauLenh = "set dateformat dMy UPDATE [dbo].[CT_PHIEUNHAP] "
                + "   SET [NgayNhap] = '" + ngayNhap + "' "
                + "      ,[LanNhap] = " + lanNhap + " "
                + "      ,[NguoiNhap] = '" + nguoiNhap + "' "
                + "      ,[IDViTri] = '" + viTri + "' "
                + " WHERE IDPN = '" + IDPN + "'";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int update_SL_CTPN(String idPN, String barcode, String ngayThem, double tongTien,String ghiChu, int sl) {
        String cauLenh = "update CT_PHIEUNHAP set Soluong = "+sl+" , NgayThem = '" + ngayThem + "' "
                + ", TongTien = " + tongTien + " , GhiChu = N'"+ghiChu+"' where IDPN = '" + idPN + "' and (Barcode = '" + barcode + "' )";
        return DBConnection.ExecuteData(cauLenh);
    }
    public static int update_SL_Gia_CTPhieuNhap(String idctpn, double tongTien, int soLuong){
        String cauLenh = "update CT_PhieuNhap set SoLuong = "+soLuong+" , TongTien = "+tongTien+" where IDCTPhieuNhap = "+idctpn+"";
        return DBConnection.ExecuteData(cauLenh);
    }

    public static int UpdateHangTonKho(String mavach, SP.DTO.DTO_HangTonKho htk) {
        String cauLenh = "set dateformat dMy UPDATE [dbo].[SANPHAMTRONGKHO] "
                + "   SET [SeriSP] = '" + mavach + "' "
                + "      ,[ChiTiet] = N'" + htk.getChiTiet() + "' "
                + "      ,[IDViTriHienTai] = '" + htk.getIDViTriHienTai() + "' "
                + "      ,[TrangThai] = '" + htk.isTrangThai() + "' "
                + "      ,[NgayVaoKho] = '" + ChuyenDoi.dateTimeString(new Date()) + "' "
                + " WHERE MaVach = '" + mavach + "' or SeriSP = '" + mavach + "'";
        return DBConnection.ExecuteData(cauLenh);
    }
}
