/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BLLThongBao {
    //Thông báo loại 1 màu xanh da trời
    public static void ThongBaoLoai1(String noidung, String tieude){
        JOptionPane.showMessageDialog(new JFrame(), noidung, tieude, JOptionPane.INFORMATION_MESSAGE);
    }
    //Thông báo loại 2 câu hỏi
    public static void ThongBaoLoai2(String noidung, String tieude){
        JOptionPane.showMessageDialog(new JFrame(), noidung, tieude, JOptionPane.QUESTION_MESSAGE);
    }
    //Thông báo loại 3 màu đỏ eror
    public static void ThongBaoLoai3(String noidung, String tieude){
        JOptionPane.showMessageDialog(new JFrame(), noidung, tieude, JOptionPane.ERROR_MESSAGE);
    }
    //Thông báo loại 4 cảnh báo màu vàng có chấm than
    public static void ThongBaoLoai4(String noidung, String tieude){
        JOptionPane.showMessageDialog(new JFrame(), noidung, tieude, JOptionPane.WARNING_MESSAGE);
    }
    
}
