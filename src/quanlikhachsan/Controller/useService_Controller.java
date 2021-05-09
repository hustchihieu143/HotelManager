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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class useService_Controller {
    quanlikhachsan.View.useService_View useService_view = new quanlikhachsan.View.useService_View();
    DefaultTableModel dtmCustomer = (DefaultTableModel) useService_view.tableCustomer.getModel();
    DefaultTableModel dtmService = (DefaultTableModel) useService_view.tableService.getModel();

    Connection cnn = ConnectDB.getConnectDB();
    Statement stm = null;
    ResultSet rs = null;
    
    public useService_Controller() {
        showAlCustomer();
        selectedRowCustomerAL();
        addServiceButtonAL();
    }
    
    public void addServiceButtonAL() {
        useService_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = useService_view.tableCustomer.getSelectedRow();
                    String registeredID = (String)dtmCustomer.getValueAt(selectedRow, 0);
                    String customerID = (String) dtmCustomer.getValueAt(selectedRow, 1);
                    String customerName = (String) dtmCustomer.getValueAt(selectedRow, 2);
                    quanlikhachsan.Controller.addService_Controller addService_controller = new addService_Controller(registeredID, customerID, customerName);
                    addService_controller.useService_controller = useService_Controller.this;
                }catch(Exception ea) {
                    showMess("Bạn phải chọn 1 hàng");
                }
            }
        }, useService_view.btn_addService);
    }
    
    public void selectedRowCustomerAL() {
        useService_view.SelectedRowListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    int selectedRow = useService_view.tableCustomer.getSelectedRow();
                    String registeredID = (String) dtmCustomer.getValueAt(selectedRow, 0);
                    showServiceUse(registeredID);
                } catch (Exception e) {
                }

            }
        }, useService_view.tableCustomer);
    }

    public void showServiceUse(String registeredID) {
        dtmService.setRowCount(0);
        String sql = "SELECT tenDV, soluong, giaDV\n"
                + "FROM dichvu dv, dangkidichvu dkdv\n"
                + "WHERE dv.madv = dkdv.maDV and dkdv.maPDK = '" + registeredID + "'";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                int amount = Integer.valueOf(rs.getString(2));
                int unitPrice = Integer.valueOf(rs.getString(3));
                total += thanhtien(amount, unitPrice);
                dtmService.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), thanhtien(amount, unitPrice)});
            }
            useService_view.txt_sum.setText(String.valueOf(total));
        } catch (Exception e) {
            showMess("Lỗi đọc dữ liệu từ SQL Server!");
        }
    }
    
    public int thanhtien(int amount, int unitPrice) {
        return amount * unitPrice;
    }
    
    public void showAlCustomer() {
        dtmCustomer.setRowCount(0);
        String sql = "SELECT DISTINCT pdk.maPDK, pdk.maKH, tenkh, socmnd, sdt\n"
                + "FROM phong p, phieudangki pdk, DangKiphong dkp, khachhang kh\n"
                + "WHERE p.maphong = dkp.maphong and pdk.maPDK = dkp.maPDK and kh.makh = pdk.maKH and p.trangthai = N'Đang sử dụng' and pdk.chuthich !=N'Đã thanh toán'";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                dtmCustomer.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
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
        new useService_Controller();
    }
}
