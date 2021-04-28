package quanlikhachsan.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login_Controller {

    quanlikhachsan.View.Login_View view = new quanlikhachsan.View.Login_View();
    Connection cnn = ConnectDB.getConnectDB();

    public Login_Controller() {
        loginButtonAL();
    }

    public void loginButtonAL() {
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!view.txt_userName.getText().isEmpty() && !view.txt_password.getText().isEmpty()) {
                    String string1 = view.txt_userName.getText();
                    String string2 = view.txt_password.getText();

                    Statement stm = null;
                    ResultSet rs = null;
                    String sql = "select*from users";
                    boolean flag = false;
                    try {
                        stm = cnn.createStatement();
                        rs = stm.executeQuery(sql);
                        while (rs.next()) {
                            if (string1.equals(rs.getString(2)) && string2.equals(rs.getString(3))) {
                                flag = true;
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login_Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        new Main_Controller(string1);
                        view.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, tên đăng nhập hoặc mật khẩu không đúng");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập tên đăng nhập và mật khẩu");
                }
            }
        }, view.loginButton);
    }

        
    public static void main(String[] args) {
        new Login_Controller();
    }

}
