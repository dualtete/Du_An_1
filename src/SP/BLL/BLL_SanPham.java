/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP.BLL;

import BLL.ChuyenDoi;
import SP.DTO.DTO_SanPham;
import SP.GUI.page_Main_NhapHang;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static SP.GUI.page_Main_NhapHang.*;
import SP.GUI.pnlDanhSachSPExecel;
import javax.swing.JColorChooser;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.util.CellAddress;
import static SP.GUI.pnlDanhSachSPExecel.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bumte
 */
public class BLL_SanPham {

    public static pnlDanhSachSPExecel pnlDSSP = new pnlDanhSachSPExecel();

    public static int importSPByXlSX() {
        DefaultTableModel tblModel = (DefaultTableModel) tblDSSPFromExcel.getModel();
        DefaultTableModel tblLoiSP = (DefaultTableModel) tblLoi.getModel();
        tblLoiSP.setRowCount(0);
        tblModel.setRowCount(0);
        try {
            File file = selectFile(chfFile);
            if (file == null) {
                return -1;
            }
            if (!file.getName().matches(".+(\\.xlsx)$")) {
                System.out.println("Không phai file excel");
                return -1;
            }
            FileInputStream fis = new FileInputStream(file);

            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

            // Return first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator<Row> itr = mySheet.iterator();

            // Iterating over Excel file in Java
            while (itr.hasNext()) {
                Row row = itr.next();
                if (row.getRowNum() < 10) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();
                Object obj[] = new Object[8];
                int i = 0;
                boolean flag = true;
                if (row.getRowNum() >= 10) {
                    obj[0] = tblModel.getRowCount() + 1;

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        System.out.println(cell + "\t");
                        if (cell.toString().trim().isEmpty()) {
                            System.out.println("Hết");
                            page_Main_NhapHang.pnlAddPnl.add(pnlDSSP).setVisible(true);
                            page_Main_NhapHang.pnlAddPnl.revalidate();
                            page_Main_NhapHang.pnlAddPnl.repaint();
                            return 4;

                        }

                        switch (cell.getColumnIndex()) {
                            case 0:// Mã sản phẩm

                                obj[0] = cell.getStringCellValue();
                                if (obj[0].toString().trim().isEmpty()) {
                                    flag = false;
                                    obj[7] = "Lỗi để trống ";
                                    break;
                                }
                                ResultSet rsBarcode = SP.DAO.selectBy.checkBarcodeSanPham(obj[0].toString().trim());
                                if (rsBarcode.next()) {
                                    flag = false;
                                    obj[7] = "Lỗi trùng mã ";
                                    break;
                                }
                                // Code validate

                                System.out.print(cell.getStringCellValue() + "\t");

                                break;
                            case 1:// Tên sản phẩm
                                obj[1] = cell.getStringCellValue();
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case 2:// Loại sản phẩm
                                obj[2] = cell.getStringCellValue();

                                // code validate
                                //Nếu tên loại sản phẩm đã có thì lấy mã loại sản phâm 
                                ResultSet rsIDLoaiSP = SP.DAO.selectBy.selectLoaiSPByTen(obj[2].toString().trim());
                                if (rsIDLoaiSP.next()) {
                                    obj[2] = rsIDLoaiSP.getInt(1);
                                    System.out.print(obj[2] + "\t");
                                    break;
                                } else {
                                    //Nếu chưa có tên loại sản phẩm thì thêm mới và lấy ra mã
                                    if (SP.DAO.insert.ThemLoaiSP(obj[2].toString().trim(), "", true) > 0) {
                                        rsIDLoaiSP = SP.DAO.selectBy.selectLoaiSPByTen(obj[2].toString().trim());
                                        obj[2] = rsIDLoaiSP.getInt(1);
                                        System.out.print(obj[2] + "\t");
                                        break;
                                    } else {
                                        flag = false;
                                        System.out.println("Chưa thêm mới được mã loại sản phẩm");
                                    }
                                }

                                break;
                            case 3:// Hãng sản xuất
                                obj[3] = cell.getStringCellValue();
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case 4://Hạn bảo hành(Tháng)

                                obj[4] = cell.getNumericCellValue();
//                                if ((int)obj[4] < 0) {
//                                    flag = false;
//                                    break;
//                                }

                                System.out.print(cell.getNumericCellValue() + "\t");
                                break;
                            case 5:// Thông tin bảo hành
                                obj[5] = cell.getStringCellValue();
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case 6: // Thông tin sản phẩm
                                obj[6] = cell.getStringCellValue();
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;

                            default:

                        }

//                    System.out.print(cell.getStringCellValue() + "\t");
//                        switch (cell.getCellType()) {
//                            case STRING:
//                                obj[i] = cell.getStringCellValue();
//                                System.out.print(cell.getStringCellValue() + "\t");
//                                i++;
//                                break;
//
//                            case NUMERIC:
//                                obj[i] = cell.getNumericCellValue();
//                                System.out.print(cell.getNumericCellValue() + "\t");
//                                i++;
//                                break;
//                            case BOOLEAN:
//                                obj[i] = cell.getBooleanCellValue();
//                                System.out.print(cell.getBooleanCellValue() + "\t");
//                                i++;
//                                break;
//                            default:
//
//                        }
                    }
                    System.out.println("");

                }
                if (flag) {
                    tblModel.addRow(obj);
                } else {
                    tblLoiSP.addRow(obj);
                }

            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        return 1;
    }

    public static File selectFile(JFileChooser file) {
        File FILE = null;
        if (file.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            FILE = file.getSelectedFile();
//            

        }
        return FILE;
    }

    public static boolean exportExcel(JTable tbl, File file) {

        try {
            FileOutputStream out = new FileOutputStream(file + "\\sanphamloi.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("sheet tạm");
            int rowCount = 0;
            for (int i = 0; i < tbl.getRowCount(); i++) {
                Row row = sheet.createRow(++rowCount);
                int columncount = 0;
                for (int j = 0; j < tbl.getColumnCount(); j++) {
                    Cell cell = row.createCell(++columncount);
//                    cell.setCellValue(tbl.getValueAt(i, j).toString());

                    if (tbl.getValueAt(i, j) instanceof String) {
                        cell.setCellValue((String) tbl.getValueAt(i, j));
                    } else if (tbl.getValueAt(i, j) instanceof Boolean) {
                        cell.setCellValue((Boolean) tbl.getValueAt(i, j));
                    } else if (tbl.getValueAt(i, j) instanceof Date) {
                        cell.setCellValue((Date) tbl.getValueAt(i, j));
                    } else if (tbl.getValueAt(i, j) instanceof Double) {
                        cell.setCellValue((Double) tbl.getValueAt(i, j));
                    }
                }
            }

            workbook.write(out);
            out.close();
            System.out.println("Tạo file excel thành công!");

//        try {
//            FileWriter out = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(out);
//            for (int i = 0; i < tbl.getRowCount(); i++) {
//                for (int j = 0; j < excel.tblDS.getColumnCount(); j++) {
//                    bw.write(excel.tblDS.getValueAt(i, j).toString());
//                    bw.write("\t");
//                }
//                bw.write("\n");
//            }
//            bw.close();
//            return true;
//        } catch (IOException ex) {
//            return false;
//        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BLL_SanPham.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {

            Logger.getLogger(BLL_SanPham.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean NhapSPVaoKho() {
        
        for (int i = 0; i < tblDSSPFromExcel.getRowCount(); i++) {

            SP.DTO.DTO_SanPham sp = new DTO_SanPham();
            sp.setBarcode(tblDSSPFromExcel.getValueAt(i, 0).toString());
            int thang = (int) ChuyenDoi.stringToDouble(tblDSSPFromExcel.getValueAt(i, 4).toString());
            sp.setHanBH(thang);
            sp.setHangSX(tblDSSPFromExcel.getValueAt(i, 3).toString());
            sp.setIdLoaiSP(tblDSSPFromExcel.getValueAt(i, 2).toString());
            sp.setNguoiThem(DTO.DTO_UserLogin.IDTK);
            sp.setTTBaoHanh(tblDSSPFromExcel.getValueAt(i, 5).toString());
            sp.setTTSanPham(tblDSSPFromExcel.getValueAt(i, 6).toString());
            sp.setTenSP(tblDSSPFromExcel.getValueAt(i, 1).toString());
            sp.setTrangThai(true);
            if (SP.DAO.insert.NhapSPVaoKho(sp) <= 0) {
                System.out.println("Lỗi thêm sản phẩm vào kho");

            } else {

            }

        }
        return true;
    }
     public static boolean saveLogo(File file) {
        
        // Tạo thư mục nếu chưa tồn tại      
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }

//        File newFile = new File(dir);
         
        
         File oldFile = new File("document\\Mau_DanhSachSP.xlsx") ;
         File newFile = new File(file,oldFile.getName());
        try {
            // Copy vào thư mục logos (đè nếu đã tồn tại)   
            
             Path source = Paths.get(oldFile.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            
//            Path destination = Paths.get(newfile.getAbsolutePath());
////            Path destination = Paths.get(file.getAbsolutePath());
//            Path  source = Paths.get(oldFile.getAbsolutePath()).getFileName();
//            
            System.out.println(source);
            System.out.println(destination);
//            
//            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    
}
