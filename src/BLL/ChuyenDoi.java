package BLL;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ta Huy
 */
public class ChuyenDoi {

    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public static Date string(String ngay) {

        try {
            return df.parse(ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi Chuyển ngày!");
            
        }
        return null;
    }

    public static String GetNgay(Date date) {
        return df.format(date);
    }

    public static String doubleToString(double so) {

        return NumberFormat.getNumberInstance().format(so);
    }

    public static double stringToDouble(String chu) {
        try {
            return NumberFormat.getNumberInstance().parse(chu).doubleValue();
        } catch (ParseException ex) {
            System.out.println("lỗi chuyển số");
            return 0;
        }
    }

    public static String so(String chu, int len) {
        String so = chu;
        if (!chu.matches("^[0-9]*$") || chu.length() > len) {
            so = chu.substring(0, chu.length() - 1);
        }
        return so;
    }

    public static Period soSanhDate(String startDate, String endDate) {
        /*
         *starDate & endDate : dd/MM/yyyy
         */
        String beginSplit[] = startDate.split("/");
        String endDateSplit[] = endDate.split("/");
        LocalDate start = LocalDate.of(Integer.parseInt(beginSplit[2]), Integer.parseInt(beginSplit[1]), Integer.parseInt(beginSplit[0]));
        LocalDate end = LocalDate.of(Integer.parseInt(endDateSplit[2]), Integer.parseInt(endDateSplit[1]), Integer.parseInt(endDateSplit[0]));
        Period diffirent = Period.between(start, end);
        /*
         *use diffirent.getYears(getDay...)
         */
        return diffirent;
    }

    public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
    }
    
    
   

 
// Hàm lấy ngày và giờ
    public static String dateTimeString(Date date) {
        try {
            Timestamp ts = new Timestamp(date.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return formatter.format(ts);
        } catch (Exception e) {
            return null;
        }

    }
    
    // Tạo chuỗi các chữ số 000...
    public static String taoChuoiCacSo0(int so, int len){
        String str = "";
        len = len - String.valueOf(so).length();
        for (int i = 0; i < len; i++) {
            str += "0";
        }
        return str + so;
    }
    
}
