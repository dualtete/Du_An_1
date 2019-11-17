/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class BLL_Validate {
    public static boolean checkName(JTextField txt, JLabel lbl){
        if(!ChuyenDoi.unAccent(txt.getText()).matches("^[a-zA-Z]{3,50}$")){
            lbl.setText("!");
            return false;
        }else{
            lbl.setText("");
            return true;
        }           
    }
    public static boolean checkEmail(JTextField txt, JLabel lbl){
        if(!txt.getText().matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")){
//            test1@gmail.com.vn --> true
//            123test@gmail.com.vn --> false
//            test2@gmail.com --> true
//            test3-1@gmail.com --> true
//            test4@@gmail.com --> false
//            test5@domain.com --> true
//            test6@gmail --> false
            lbl.setText("!");
            return false;
        }else{
            lbl.setText("");
            return true;
        }
    }
    public static boolean checkMa(JTextField txt, JLabel lbl){
        if(!txt.getText().matches("^[A-Z0-9-]{1,10}$")){
            lbl.setText("!");
            return false;
        }else{
            lbl.setText("");
            return true;
        }
    }
    public static boolean checkSDT(JTextField txt, JLabel lbl){
        if(!txt.getText().matches("^0[0-9\\s.-]{10}$")){
            lbl.setText("!");
            return false;
        }else{
            lbl.setText("");
            return true;
        }
    }
    public static boolean checkCMND(JTextField txt, JLabel lbl){
        if(!txt.getText().matches("^[0-9]{9}$")){
            lbl.setText("!");
            return false;
        }else{
            lbl.setText("");
            return true;
        }
    }
    public static boolean checkNgaySinh(JTextField txt, JLabel lbl){
        if(!txt.getText().matches("^\\d{1,2}-\\d{1,2}-\\d{4}$")){
            lbl.setText("!");
            return false;
        }else{
            lbl.setText("");
            return true;
        }
    }
}

