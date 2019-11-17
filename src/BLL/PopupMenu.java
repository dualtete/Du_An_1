/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author Admin
 */
public class PopupMenu {
    public void popupTable(){
        //Create popupMenu
        JPopupMenu popupMenu = new JPopupMenu();
        //Create menuItem
        JMenuItem menuItem = new JMenuItem("Sửa");
        JMenuItem menuItem1 = new JMenuItem("Xóa");
        JMenuItem menuItem2 = new JMenuItem("Thoát");
        //Show thứ cần đến khi chọn vào Sửa
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Quang Huy", "Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //Add các menuItem vào popupMenu
        popupMenu.add(menuItem);
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        //tblHome.setComponentPopupMenu(popupMenu);
    }
}
