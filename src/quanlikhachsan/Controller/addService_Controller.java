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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Admin
 */
public class addService_Controller {
    quanlikhachsan.View.addService_View addService_view = new quanlikhachsan.View.addService_View();
    public quanlikhachsan.Controller.useService_Controller useService_controller;

    Connection cnn = ConnectDB.getConnectDB();
    Statement stm = null;
    ResultSet rs = null;
    
    public addService_Controller(String registeredID, String customerID, String customerName) {
        addService_view.txt_registeredID.setText(registeredID);
        addService_view.txt_customerID.setText(customerID);
        addService_view.txt_customerName.setText(customerName);
        String[] listService = getService();
        addService_view.cbb_service.setModel(new DefaultComboBoxModel<>(listService));
        cbb_ServiceListener();
        spn_AmountListener();
        addServiceButtonAL();
    }
    
    public void addServiceButtonAL() {
        addService_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql_getServiceID = "SELECT * FROM dichvu";
                String registeredID = addService_view.txt_registeredID.getText();
                String serviceName = (String) addService_view.cbb_service.getSelectedItem();
                String amount = String.valueOf(addService_view.spn_amount.getValue());
                String serviceID = null;
                System.out.println(serviceName);
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql_getServiceID);
                    boolean flag = false;
                    while(rs.next()) {
                        if(rs.getString(2).equals(serviceName)) {
                            serviceID = rs.getString(1);
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        if(Integer.valueOf(amount) > 0) {
                            String sql_addService = "INSERT INTO dangkidichvu VALUES('" + registeredID + "','" + serviceID + "','"+amount+"')";
                            try {
                                stm = cnn.createStatement();
                                stm.executeUpdate(sql_addService);
                                showMess("Thêm dịch vụ thành công");
                                useService_controller.showServiceUse(registeredID);
                                addService_view.dispose();
                            }catch(Exception ea) {
                                showMess("Lỗi đọc dữ liệu");
                            }
                        }
                        else {
                            showMess("Số lượng phải lớn 0");
                        }
                    }
                    else {
                        showMess("Bạn phải chọn 1 dịch vụ");
                    }
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
            }
        }, addService_view.btn_addService);
    }
    
    public void cbb_ServiceListener() {
        addService_view.addComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from dichvu";
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        if(rs.getString(2).equals((String)addService_view.cbb_service.getSelectedItem())) {
                            addService_view.txt_unitPrice.setText(rs.getString(3));
                            break;
                        }
                    }
                    
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
                int sum = Integer.parseInt(addService_view.txt_unitPrice.getText()) * Integer.parseInt(addService_view.spn_amount.getValue().toString());
                addService_view.txt_sum.setText(String.valueOf(sum));
            }
        }, addService_view.cbb_service);
    }
    
    public void spn_AmountListener() {
       addService_view.addSpinnerListener(new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent e) {
               String sql = "select * from dichvu";
                try {
                    stm = cnn.createStatement();
                    rs = stm.executeQuery(sql);
                    while(rs.next()) {
                        if(rs.getString(2).equals((String)addService_view.cbb_service.getSelectedItem())) {
                            addService_view.txt_unitPrice.setText(rs.getString(3));
                            break;
                        }
                    }
                    
                }catch(Exception ea) {
                    showMess("Lỗi đọc dữ liệu");
                }
                int sum = Integer.parseInt(addService_view.txt_unitPrice.getText()) * Integer.parseInt(addService_view.spn_amount.getValue().toString());
                addService_view.txt_sum.setText(String.valueOf(sum));
           }
       }, addService_view.spn_amount);
    }
    
    public String[] getService() {
        String [] list = null;
        ArrayList<String> listService = new ArrayList();
        listService.add("Chọn dịch vụ");
        String sql = "select * from dichvu";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                listService.add(rs.getString(2));
            }           
        }catch(Exception e) {
            showMess("Lỗi đọc dữ liệu");
        }
        list= listService.toArray(new String[listService.size()]);
        return list;
    }
    
    public void showMess(String str) {
        JOptionPane.showMessageDialog(null, str);
    }
    public static void main(String[] args) {
        new addService_Controller("1", "1", "Hieu");
    }
}
