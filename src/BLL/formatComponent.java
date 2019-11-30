/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import javax.swing.JTextField;

/**
 *
 * @author bumte
 */
public class formatComponent {
    public static void money(JTextField txt){
        txt.setText(ChuyenDoi.doubleToString(ChuyenDoi.stringToDouble(txt.getText())));
   }
}
