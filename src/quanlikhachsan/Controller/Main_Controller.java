package quanlikhachsan.Controller;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quanlikhachsan.View.Room_View;

public class Main_Controller {

    public static void main(String[] args) {
        new Main_Controller("admin");
    }

    quanlikhachsan.View.Main_View main_view = new quanlikhachsan.View.Main_View();
    Connection cnn = ConnectDB.getConnectDB();

    public Main_Controller(String userName) {
        main_view.lb_userName.setText(userName);
        listRoomButtonAL();
        listCustomerButtonAL();
        serviceButtonAL();
        bookRoomButtonAL();
        checkInButtonAL();
        useServiceButtonAL();
        logOutLabelAL();
        staffButtonAL();
        checkOutButtonAL();
        statisticalButtonAL();
      
    }

    public void listRoomButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (main_view.lb_userName.getText().equals("admin")) {
                    new quanlikhachsan.Controller.Room_Controller();
                } else {
                    showMess("Chỉ admin mới có quyền truy cập");
                }
            }
        }, main_view.btn_listRoom);
    }

    public void listCustomerButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Customer_Controller();
            }
        }, main_view.btn_listCustomer);
    }

    public void bookRoomButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new quanlikhachsan.Controller.bookRoom_Controller();
            }
        }, main_view.btn_bookRoom);
    }

    public void serviceButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new service_Controller();
            }
        }, main_view.btn_service);
    }

    public void checkInButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CheckIn_Controller();
            }
        }, main_view.btn_checkIn);
    }

    public void useServiceButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               // new useService_Controller();
            }
        }, main_view.btn_useService);
    }

    public void staffButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (main_view.lb_userName.getText().equals("admin")) {
                    //new quanlikhachsan.Controller.Staff_Controller();
                } else {
                    showMess("Chỉ admin mới có quyền truy cập");
                }
            }
        }, main_view.btn_staff);
    }

    public void checkOutButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //new CheckOut_Controller(main_view.lb_userName.getText());
            }
        }, main_view.btn_checkOut);
    }

    public void statisticalButtonAL() {
        main_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //new Statistical_Controller();
            }
        }, main_view.btn_Statistical);
    }

    public void showMess(String st) {
        JOptionPane.showMessageDialog(null, st);
    }

    public void logOutLabelAL() {
        main_view.LabelListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                main_view.dispose();
                new Login_Controller();
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                main_view.lb_logout.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                main_view.lb_logout.setForeground(Color.BLACK);
            }
        }, main_view.lb_logout);
    }
   

}
