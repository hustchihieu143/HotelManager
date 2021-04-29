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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import quanlikhachsan.Model.service_Model;

/**
 *
 * @author Admin
 */
public class service_Controller {
    quanlikhachsan.View.service_View service_view = new quanlikhachsan.View.service_View();
    Connection cnn = ConnectDB.getConnectDB();
    DefaultTableModel dtm = (DefaultTableModel) service_view.tableService.getModel();
    Statement stm = null;
    ResultSet rs = null;
    boolean switchSort = true;
    
    public service_Controller() {
        showAllService();
        addButtonAl();
        deleteButtonAl();
    }
    
    public void addButtonAl() {
        service_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    service_Model service = new service_Model();
                    service.service_Name = service_view.txt_serviceName.getText();
                    service.service_Price = Integer.parseInt(service_view.txt_servicePrice.getText());
                    service.service_Note = service_view.txt_serviceNote.getText();                
                    if(checkExists(service.service_Name)) {
                        showMess("Dịch vụ đã tồn tại");
                    }
                    else {
                        insert_into_database(service.service_Name, service.service_Price, service.service_Note);
                        showAllService();
                    }
                }catch(Exception ea) {
                    showMess("Bạn phải nhập đầy đủ thông tin");
                }
                
            }
            
        }, service_view.btn_addService);
    }
    
    public void deleteButtonAl() {
        service_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int deleteRow = service_view.tableService.getSelectedRow();
                    String s = (String) dtm.getValueAt(deleteRow, 0);
                    String nameService = (String) dtm.getValueAt(deleteRow, 1);
                    int choose = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dịch vụ " + nameService + "?");
                    stm = null;
                    rs = null;
                    if(choose == 0) {
                        String sql = "delete from dichvu where maDV = '"+ s +"'";
                        stm = cnn.createStatement();
                        stm.executeUpdate(sql);
                        showMess("Xóa thành công");
                        showAllService();
                    }
                }catch(Exception ea) {
                    showMess("Bạn phải chọn 1 hàng");
                }
            }
        }, service_view.btn_deleteService);
    }
    
    public void insert_into_database(String name, int price, String note) {
        String sql = "INSERT INTO dichvu(tenDV,giaDV,ghichu) VALUES(N'" + name + "','" + price + "',N'" + note + "')";
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
            showMess("Thêm thành công");
        } catch (Exception e) {
            showMess("Lỗi đọc dữ liệu từ SQL Server!");
        }
    }

    
    public boolean checkExists(String nameService) {
        stm = null;
        rs = null;
        String sql = "select * from dichvu";
        boolean flag = false;
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                if(nameService.equals(rs.getString(2))) {
                    return true;
                }
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
    
    
    public void showMess(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }
    
    public void showAllService() {
        dtm.setRowCount(0);
        String sql = "SELECT * FROM dichvu";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }
        } catch (Exception e) {
            showMess("Lỗi đọc dữ liệu từ SQL Server!");
        }
    }
    
    public static void main(String[] args) {
        new service_Controller();
    }
}
