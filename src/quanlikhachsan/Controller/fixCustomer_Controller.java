package quanlikhachsan.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class fixCustomer_Controller {

    quanlikhachsan.Controller.Customer_Controller customer_Controller;
    quanlikhachsan.View.fixCustomer_View fixCustomer_view = new quanlikhachsan.View.fixCustomer_View();
    Connection cnn = ConnectDB.getConnectDB();
    Statement stm = null;
    ResultSet rs = null;

    public fixCustomer_Controller(int id, String name, String idCard, String sex, String address, String phoneNumber,
            String nationality, String email, String note) {
        updateButtonAL(idCard);        
        fixCustomer_view.txt_customerID.setText(String.valueOf(id));
        fixCustomer_view.txt_customerName.setText(name);
        fixCustomer_view.txt_customerIDcard.setText(idCard);
        fixCustomer_view.cbb_customerSex.setSelectedItem(sex);
        fixCustomer_view.txt_customerAddress.setText(address);
        fixCustomer_view.txt_customerPhoneNumber.setText(phoneNumber);
        fixCustomer_view.cbb_customerNationality.setSelectedItem(nationality);
        fixCustomer_view.txt_customerEmail.setText(email);
        fixCustomer_view.txt_customerNote.setText(note);

    }

    public void updateButtonAL(String idcard1st) {
        fixCustomer_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                quanlikhachsan.Model.Customer_Model customer = new quanlikhachsan.Model.Customer_Model();
                try {
                    customer.customer_ID = Integer.parseInt(fixCustomer_view.txt_customerID.getText());
                    customer.customer_Name = fixCustomer_view.txt_customerName.getText();
                    customer.customer_IDCard = fixCustomer_view.txt_customerIDcard.getText();
                    customer.customer_Sex = (String) fixCustomer_view.cbb_customerSex.getSelectedItem();
                    customer.customer_Address = fixCustomer_view.txt_customerAddress.getText();
                    customer.customer_PhoneNumber = fixCustomer_view.txt_customerPhoneNumber.getText();
                    customer.customer_Nationality = (String) fixCustomer_view.cbb_customerNationality.getSelectedItem();
                    customer.customer_Email = fixCustomer_view.txt_customerEmail.getText();
                    customer.customer_Note = fixCustomer_view.txt_customerNote.getText();
                    if (!check_exist(customer.customer_IDCard, idcard1st)) {
                        update_Data(customer.customer_ID, customer.customer_Name, customer.customer_IDCard, customer.customer_Sex,
                                customer.customer_Address, customer.customer_PhoneNumber, customer.customer_Nationality, customer.customer_Email, customer.customer_Note);
                        fixCustomer_view.dispose();

                        customer_Controller.showAllCustomer();
                        //customer_Controller.hello();

                    } else {
                        showMess("Số CMND/Hộ chiếu đã được đăng kí!");
                    }
                } catch (Exception e) {
                   showMess("Lỗi đọc dữ liệu từ SQL Server!");
                }
            }
        }, fixCustomer_view.btn_updateCustomer);
    }

    public boolean check_exist(String idcard, String idcard1st) {  // neu so cmt nhap vao ma trung vs cmt da co thi false
        boolean flag = false;
        String sql = "SELECT*FROM khachhang";
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(3).equals(idcard)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            showMess("Lỗi đọc dữ liệu từ SQL Server!");
        }
//        if (idcard.equals(idcard1st)) {  // neu trung
//            flag = false;    
//        }
        return flag;

    }

    public void update_Data(int id, String name, String idCard, String sex,
            String address, String phoneNumber, String nationality, String email, String note) {
        String sql = "UPDATE khachhang set tenkh=N'" + name + "',soCMND='" + idCard + "',gioitinh=N'" + sex + "',diachi=N'"
                + address + "',sdt='" + phoneNumber + "',quoctich=N'" + nationality + "', email = '" + email + "', ghichu = N'" + note + "' where makh='" + id + "'";
        try {
            stm = cnn.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } catch (Exception e) {
            showMess("Lỗi đọc dữ liệu từ SQL Server!");
        }

    }

    public void showMess(String st) {
        JOptionPane.showMessageDialog(null, st);
    }
}
