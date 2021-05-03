/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlikhachsan.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import quanlikhachsan.View.bookRoom_View;

/**
 *
 * @author Admin
 */
public class bookRoom_Controller {
    quanlikhachsan.View.bookRoom_View bookRoom_view = new quanlikhachsan.View.bookRoom_View();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    DefaultTableModel dtmCustomerTable = (DefaultTableModel) bookRoom_view.tableCustomer.getModel();
    DefaultTableModel dtmRoomTable = (DefaultTableModel) bookRoom_view.tableRoomReady.getModel();
    
    Connection cnn = quanlikhachsan.Controller.ConnectDB.getConnectDB();
    Statement stm = null;
    ResultSet rs = null;
    
    public bookRoom_Controller() {
        showCustomer();
        showEmptyRoom();
        selectedRowCustomerAL();
        addRoomInforButtonAL();
        dayStartSelectedAL();
        dayEndSelectedAL();
        bookRoomButtonAL();
        showAllRoom();
        txt_searchNameCustomer();
        txt_SearchCardId();
        txt_SearchPhoneNumber();
        cbb_typeRoomAL();
        cbb_kindRoomAL();
    }
    
    
    public void bookRoomButtonAL() {
        bookRoom_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    quanlikhachsan.Model.BookRoom_Model bookRoom_model = new quanlikhachsan.Model.BookRoom_Model();
                    bookRoom_model.Customer_ID = Integer.parseInt(bookRoom_view.txt_CustomerID.getText());
                    bookRoom_model.dateStart = sdf.format(bookRoom_view.dc_startDate.getDate());
                    bookRoom_model.dateEnd = sdf.format(bookRoom_view.dc_endDate.getDate());
                    bookRoom_model.dayCount = Integer.parseInt(bookRoom_view.txt_dayCount.getText());
                    bookRoom_model.personCount = Integer.parseInt(bookRoom_view.txt_personCount.getText());
                    bookRoom_model.roomCount = roomCount(bookRoom_view.txt_room.getText()).length;
                    bookRoom_model.prepay = Integer.parseInt(bookRoom_view.txt_prepay.getText());
                    bookRoom_model.note = bookRoom_view.txt_note.getText();
                    if (check_null(bookRoom_view.txt_CustomerID.getText(), sdf.format(bookRoom_view.dc_startDate.getDate()),
                            sdf.format(bookRoom_view.dc_endDate.getDate()), bookRoom_view.txt_dayCount.getText(), bookRoom_view.txt_room.getText())) {
                        showMess("Bạn phải nhập đầy đủ thông tin!");
                    } else {
                        insert_bookRoomInfor_into_database(bookRoom_model.Customer_ID, bookRoom_model.dateStart, bookRoom_model.dateEnd,
                                bookRoom_model.dayCount, bookRoom_model.personCount, roomCount(bookRoom_view.txt_room.getText()),
                                bookRoom_model.prepay, bookRoom_model.note);
                   
                    }
                    dtmRoomTable.setRowCount(0);
                    showEmptyRoom();
                } catch (Exception e) {
                    showMess("Bạn phải nhập đầy đủ thông tin!");
                }
            }
        }, bookRoom_view.btn_bookRoom);
    }
    
    public void insert_bookRoomInfor_into_database(int makh, String ngayden, String ngaydi, int songay, int songuoi,
            String[] roomArray, int tratruoc, String chuthich) {
        String sql = "INSERT INTO phieudangki(maKH,ngayden,ngaydi,songay,songuoi,soluongphong, tratruoc, chuthich)"
                + "VALUES('" + makh + "','" + ngayden + "','" + ngaydi + "','" + songay + "','" + songuoi + "','" + roomArray.length + "','" + tratruoc + "',N'" + chuthich + "')";
        stm = null;
        rs = null;
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
            
            String sql1 = "SELECT*FROM phieudangki where makh ='" + makh + "'";
            stm = null;
            rs = null;
            try {
                stm = cnn.createStatement();
                rs = stm.executeQuery(sql1);
                String registeredID = "";
                while(rs.next()) {
                    registeredID = rs.getString(1);
                }
                insert_into_registerRoom(registeredID, roomArray);
                insert_into_bill(registeredID);
                
            }catch(Exception ea1) {
                
            }
        }catch(Exception ea) {
            
        }
    }
    
    public void insert_into_registerRoom(String registeredID, String[] roomArray) {
        System.out.println("registeredID = " + registeredID);
        System.out.println("RoomArray = " + roomArray.toString());
        for (int i = 0; i < roomArray.length; i++) {
            String sql = "INSERT INTO dangkiphong VALUES('" + registeredID + "','" + roomArray[i] + "') ";
            try {
                stm = cnn.createStatement();
                stm.executeUpdate(sql);
                update_RoomStatus(roomArray[i]);

            } catch (Exception e) {
            }
        }
    }
    
    public void insert_into_bill(String registeredID) {
        String sql = "INSERT INTO hoadon(mapdk) VALUES('" + registeredID + "')";
        stm = null;
        rs = null;
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
        }catch(Exception e) {
            
        }
    }
    
    public void update_RoomStatus(String roomID) {
        String sql = "UPDATE phong SET trangthai=N'Đã đặt' WHERE maphong ='" + roomID + "'";
        stm = null;
        rs = null;
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
            showMess("Đặt phòng thành công phòng " + roomID);
        }catch(Exception e) {
            showMess("Lỗi đọc dữ liệu từ SQL Server!");
        }
    }
    
    public String[] roomCount(String st) {
        String[] roomArray = null;
        if (!st.contains(",")) {
            roomArray = st.split(" ");
        } else {
            roomArray = st.split(",");
        }
        return roomArray;
    }
    
    public void selectedRowCustomerAL() {
        bookRoom_view.SelectedRowListener((ListSelectionEvent lse) -> {
            try {
                int selectedRow = bookRoom_view.tableCustomer.getSelectedRow();
                bookRoom_view.txt_CustomerID.setText((String) dtmCustomerTable.getValueAt(selectedRow, 0));
            } catch (Exception e) {
            }
        }, bookRoom_view.tableCustomer);
    }
    
    public void dayStartSelectedAL() {
        bookRoom_view.addCalendarListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(bookRoom_view.dc_startDate.getDate().compareTo(java.sql.Date.valueOf(java.time.LocalDate.now())) == -1) {
                    showMess("Ngày đến phải lớn hơn hoặc bằng ngày hiện tại!");
                    bookRoom_view.dc_startDate.setDate(null);
                }
            }
        }, bookRoom_view.dc_startDate);
    }
    
    public void dayEndSelectedAL() {
        bookRoom_view.addCalendarListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    long tmp = (long) ((bookRoom_view.dc_endDate.getDate().getTime() - bookRoom_view.dc_startDate.getDate().getTime())) / (24 * 60 * 60 * 1000);
                    if (tmp > 0) {
                        bookRoom_view.txt_dayCount.setText(String.valueOf(tmp));
                    } else {
                        showMess("Thời gian đặt phòng ít nhất 1 ngày");
                        bookRoom_view.dc_endDate.setDate(null);
                    }
                } catch (Exception e) {
                }
            }
        }, bookRoom_view.dc_endDate);
    }
    
    public void cbb_typeRoomAL() {   // loai phong: thuong or vip
        bookRoom_view.addComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKindRoom = (String) bookRoom_view.cbb_kindRoom.getSelectedItem();
                String sql = "select * from phong where trangthai = N'Trống' ";
                stm = null;
                rs = null;
                String str = (String) bookRoom_view.cbb_typeRoom.getSelectedItem();
                if(selectedKindRoom != null) sql = "select * from phong where trangthai = N'Trống' and kieuphong = N'" + selectedKindRoom + "' ";
                else sql = "select * from phong where trangthai = N'Trống' ";
                dtmRoomTable.setRowCount(0);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        if(rs.getString(2).equals(str)) {
                            dtmRoomTable.addRow(new Object[] {
                                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                            });
                        }
                    }
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
            }
        }, bookRoom_view.cbb_typeRoom);
    }
    public void cbb_kindRoomAL() {   // kieu phong: don or doi
        bookRoom_view.addComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) bookRoom_view.cbb_kindRoom.getSelectedItem();
                String selectedTypeRoom = (String) bookRoom_view.cbb_typeRoom.getSelectedItem();
                String sql;
                if(selectedTypeRoom != null) sql = "select * from phong where trangthai = N'Trống' and loaiphong = N'" + selectedTypeRoom + "' ";
                else sql = "select * from phong where trangthai = N'Trống' ";
                stm = null;
                rs = null;
                System.out.println(str);
                dtmRoomTable.setRowCount(0);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        if(rs.getString(3).equals(str)) {
                            dtmRoomTable.addRow(new Object[] {
                                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                            });
                        }
                    }
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
            }
        }, bookRoom_view.cbb_kindRoom);
    }
    
    public void showAllRoom() {
        bookRoom_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from phong";
                stm = null;
                rs = null;
                dtmRoomTable.setRowCount(0);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        dtmRoomTable.addRow(new Object[] {
                            rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
                        });
                    }
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
            }
        }, bookRoom_view.btn_showAllRoom);
    }
    
    public void addRoomInforButtonAL() {
        bookRoom_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRows[] = bookRoom_view.tableRoomReady.getSelectedRows();
                try {
                    
                    List<String> listRoom = new ArrayList();
                    for(int i = 0; i < selectedRows.length; i++) {
                        listRoom.add((String)dtmRoomTable.getValueAt(selectedRows[i], 0));
                    }
                    if(!listRoom.isEmpty()) {
                        String result = "";
                        for(int i = 0; i < listRoom.size(); i++) {
                            if(i == listRoom.size()-1) result += listRoom.get(i);
                            else result += listRoom.get(i) + ",";
                        }
                        bookRoom_view.txt_room.setText(result);
                    }
                    else {
                        showMess("Bạn phải chọn 1 hàng");
                    }
                }catch(Exception ea) {
                    showMess("Bạn phải chọn 1 hàng");
                }
            }
        }, bookRoom_view.btn_addRoomInfor);
    }
    
    public void txt_searchNameCustomer() {
        bookRoom_view.txt_Listener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String str = bookRoom_view.txt_searchName.getText();
                String sql = "select * from khachhang";
                stm = null;
                rs = null;
                dtmCustomerTable.setRowCount(0);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    
                    while(rs.next()) {
                        if(rs.getString(2).contains(str)) {
                            dtmCustomerTable.addRow(new Object[] {
                                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6)
                            });
                        }
                    }
                }catch(Exception ea) {
                    
                }
            }
        }, bookRoom_view.txt_searchName);
    }
    
    public void txt_SearchCardId() {
        bookRoom_view.txt_Listener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String sql = "select * from khachhang";
                stm = null;
                rs = null;
                String str = bookRoom_view.txt_searchIDCard.getText();
                dtmCustomerTable.setRowCount(0);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        if(rs.getString(3).contains(str)) {
                            dtmCustomerTable.addRow(new Object[] {
                                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6)
                            });
                        }
                    }
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
            }
        }, bookRoom_view.txt_searchIDCard);
    }
    
    public void txt_SearchPhoneNumber() {
        bookRoom_view.txt_Listener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String sql = "select * from khachhang";
                stm = null;
                rs = null;
                String str = bookRoom_view.txt_searchPhoneNumber.getText();
                dtmCustomerTable.setRowCount(0);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        if(rs.getString(6).contains(str)) {
                            dtmCustomerTable.addRow(new Object[] {
                                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6)
                            });
                        }
                    }
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
            }
        }, bookRoom_view.txt_searchIDCard);
    }
    
    public boolean check_null(String customerID, String dateStart, String dateEnd, String personCount, String room) {
        boolean flag = false;
        if (customerID.isEmpty() || dateStart.isEmpty() || dateEnd.isEmpty() || personCount.isEmpty() || room.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    
    public void showCustomer() {
        String sql = "select * from khachhang";
        stm = null;
        rs = null;
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                dtmCustomerTable.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(6)
                });
            }
        }catch(Exception e) {
            showMess("Lỗi đọc dữ liệu");
        }
    }
    public void showEmptyRoom() {
        stm = null;
        rs = null;
        String sql = "select * from phong where trangthai = N'Trống'";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                dtmRoomTable.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
                     });
            }
        }catch(Exception ea) {
            System.out.println(ea.getMessage());
        }
    }
    
    public void showMess(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
    
    public static void main(String[] args) {
        new bookRoom_Controller();
    }
    
    
}
