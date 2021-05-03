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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CheckIn_Controller {
    quanlikhachsan.View.CheckIn_View checkIn_View = new quanlikhachsan.View.CheckIn_View();
    DefaultTableModel dtm = (DefaultTableModel) checkIn_View.tableBookedRoom.getModel();
    Statement stm = null;
    ResultSet rs = null;
    Connection cnn = ConnectDB.getConnectDB();
    
    public CheckIn_Controller() {
        showAll();
        CheckInButtonAl();
        cancelBookedRoomAL();
    }
    
    public void CheckInButtonAl() {
        checkIn_View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int selectedRow = checkIn_View.tableBookedRoom.getSelectedRow();
                    String roomID = (String) dtm.getValueAt(selectedRow, 7);
                    String sql = "UPDATE phong set trangthai = N'Đang sử dụng' where maphong='" + roomID + "'";
                    try {
                        stm = cnn.createStatement();
                        stm.executeUpdate(sql);
                        showMess("Nhận phòng thành công!");
                        showAll();
                    } catch (Exception e) {
                        showMess("Lỗi đọc dữ liệu từ SQL Server!");
                    }                    
                } catch (Exception e) {
                    showMess("Bạn phải chọn 1 phòng để nhận!");
                }
            }
        }, checkIn_View.btn_checkIn);
    }
    
    public void cancelBookedRoomAL() {
        checkIn_View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = checkIn_View.tableBookedRoom.getSelectedRow();
                    String roomId = (String)dtm.getValueAt(selectedRow, 7);
                    String registeredID = (String) dtm.getValueAt(selectedRow, 0);
                    String sql1 = "DELETE FROM dangkiphong WHERE maphong ='" + roomId + "'";
                    String sql2 = "UPDATE phong set trangthai=N'Trống' WHERE maphong='" + roomId + "'";
                    try {
                        stm = cnn.createStatement();
                        stm.executeUpdate(sql1);
                        stm.executeUpdate(sql2);
                        decrease_RoomCount(registeredID);
                        showMess("Hủy phòng " + roomId + " thành công");
                        showAll();
                    }catch(Exception ea) {
                        showMess("Lỗi đọc dữ liệu");
                    }
                }catch(Exception ea2) {
                    showMess("Bạn phải chọn 1 hàng");
                }
            }
        }, checkIn_View.btn_cancelBookedRoom);
    }
    
    public void decrease_RoomCount(String registeredID) {
        int roomCount = 0;
        String sql = "select * from phieudangki where maPDK = '" +registeredID+ "'";
        stm = null;
        rs = null;
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                roomCount = Integer.parseInt(rs.getString(7));
            }
            roomCount -= 1;
            String sql_updateRoomCount = "UPDATE phieudangki set soluongphong='"+roomCount+"' WHERE mapdk ='"+registeredID+"'";
            try {
                stm = cnn.createStatement();
                stm.executeUpdate(sql_updateRoomCount);
            }catch(Exception ea) {
                showMess("Lỗi đọc dữ liệu");
            }
        }catch(Exception e) {
            showMess("Lỗi đọc dữ liệu");
        }
    }
    
    public void showAll() {
        dtm.setRowCount(0);
        String sql = "select dkp.maPDK, kh.makh, kh.tenkh, kh.soCMND, kh.sdt, pdk.ngayden, pdk.ngaydi, dkp.maphong, p.trangthai, pdk.chuthich\n" +
                        "from phieudangki pdk, dangkiphong dkp, khachhang kh, phong p\n" +
                        "where pdk.maPDK = dkp.maPDK and dkp.maphong = p.maphong and kh.makh = pdk.maKH and p.trangthai = N'Đã đặt' and pdk.chuthich != N'Đã thanh toán'";
        stm = null;
        rs = null;
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                dtm.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9), rs.getString(10)
                });
            }
        }catch(Exception e) {
            showMess("Lỗi đọc dữ liệu");
        }
    }
    
    public void showMess(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
    public static void main(String[] args) {
        new CheckIn_Controller();
    }
}