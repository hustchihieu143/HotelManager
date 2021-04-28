/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlikhachsan.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class fixRoom_Controller {
    quanlikhachsan.Controller.Room_Controller room_controller;
    quanlikhachsan.View.fixRoom_View fixRoom_view = new quanlikhachsan.View.fixRoom_View();
    Connection cnn = ConnectDB.getConnectDB();
    Statement stm = null;
    ResultSet rs = null;
    
    public fixRoom_Controller(String st1, String st2, String st3, String st4, String st5, String st6) {
        fixRoom_view.txt_roomID.setText(st1);
        fixRoom_view.cbb_typeRoom.setSelectedItem(st2);
        fixRoom_view.cbb_kindRoom.setSelectedItem(st3);
        fixRoom_view.txt_priceRoom.setText(st4);
        fixRoom_view.cbb_statusRoom.setSelectedItem(st5);
        fixRoom_view.txt_noteRoom.setText(st6);
        updateButtonAl();
    }
    
    public void updateButtonAl() {
        fixRoom_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quanlikhachsan.Model.Room_Model room = new quanlikhachsan.Model.Room_Model();
                try {
                    room.roomID = fixRoom_view.txt_roomID.getText();
                    room.type_Room = (String) fixRoom_view.cbb_typeRoom.getSelectedItem();
                    room.kind_Room = (String) fixRoom_view.cbb_kindRoom.getSelectedItem();
                    room.price_Room = Integer.parseInt(fixRoom_view.txt_priceRoom.getText());
                    room.status_Room = (String) fixRoom_view.cbb_statusRoom.getSelectedItem();
                    room.note_Room = fixRoom_view.txt_noteRoom.getText();
                    updateData(room.roomID, room.type_Room, room.kind_Room, String.valueOf(room.price_Room), room.status_Room, room.note_Room);
                    fixRoom_view.dispose();
                    room_controller.showAll();
                }catch(Exception ea) {
                    
                }
            }
        }, fixRoom_view.btn_updateRoom);
    }
    
    public void updateData(String maphong, String loaiphong, String kieuphong, String giaphong, String trangthai, String mota) {
        stm = null;
        rs = null;
        String sql = "UPDATE phong set loaiphong=N'" + loaiphong + "',kieuphong=N'" + kieuphong + "',giaphong='" + giaphong + "',trangthai=N'"
                + trangthai + "',mota=N'" + mota + "' where maphong='" + maphong + "'";
        
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
            showMess("Cập nhật thành công");
        }catch(Exception e) {
            showMess("Phòng đã tồn tại");
        }
    }
    
    public void showMess(String st) {
        JOptionPane.showMessageDialog(null, st);
    }
}
