package quanlikhachsan.View;


import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main_View extends javax.swing.JFrame {

    /**
     * Creates new form Main_Frame
     */
    public Main_View() {        
        try {
            javax.swing.UIManager.setLookAndFeel(new NimbusLookAndFeel());            
        } catch (Exception e) {
        }
        setTitle("Khách sạn HKH");
        initComponents();
        setLocation(500, 150);
        setVisible(true);
        setResizable(false);
        
    }

    public void addActionListener(ActionListener al, JButton btn) {
        btn.addActionListener(al); 
    }
    
    public void LabelListener(MouseListener ml, JLabel lb){
        lb.addMouseListener(ml);
    }
    
    
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb_userName = new javax.swing.JLabel();
        lb_logout = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_Statistical = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_listCustomer = new javax.swing.JButton();
        btn_listRoom = new javax.swing.JButton();
        btn_service = new javax.swing.JButton();
        btn_staff = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_bookRoom = new javax.swing.JButton();
        btn_useService = new javax.swing.JButton();
        btn_checkIn = new javax.swing.JButton();
        btn_checkOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Khách sạn PCH");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lb_userName.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        lb_userName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_logout.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_logout.setText("Đăng xuất");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê"));

        btn_Statistical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/statistic.png"))); // NOI18N
        btn_Statistical.setText("Thống kê doanh thu");
        btn_Statistical.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Statistical.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Statistical)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Statistical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh mục"));

        btn_listCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CustomerInfo.png"))); // NOI18N
        btn_listCustomer.setText("Khách hàng");
        btn_listCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_listCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_listRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rooms.png"))); // NOI18N
        btn_listRoom.setText("Phòng");
        btn_listRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_listRoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/foods.png"))); // NOI18N
        btn_service.setText("Dịch vụ");
        btn_service.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_service.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_staff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        btn_staff.setText("Nhân viên");
        btn_staff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_staff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_listCustomer)
                .addGap(18, 18, 18)
                .addComponent(btn_listRoom)
                .addGap(18, 18, 18)
                .addComponent(btn_service)
                .addGap(18, 18, 18)
                .addComponent(btn_staff)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_listCustomer)
                    .addComponent(btn_listRoom)
                    .addComponent(btn_service)
                    .addComponent(btn_staff))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giao dịch"));

        btn_bookRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bookingRooms.png"))); // NOI18N
        btn_bookRoom.setText("Đặt phòng");
        btn_bookRoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_bookRoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_useService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/useService.png"))); // NOI18N
        btn_useService.setText("Sử dụng dịch vụ");
        btn_useService.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_useService.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_checkIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/checkIn1.png"))); // NOI18N
        btn_checkIn.setText("Nhận Phòng");
        btn_checkIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_checkIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_checkOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Checkout&Payment.png"))); // NOI18N
        btn_checkOut.setText("Trả  Phòng");
        btn_checkOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_checkOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_bookRoom)
                .addGap(18, 18, 18)
                .addComponent(btn_checkIn)
                .addGap(18, 18, 18)
                .addComponent(btn_useService)
                .addGap(18, 18, 18)
                .addComponent(btn_checkOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_bookRoom)
                    .addComponent(btn_checkIn)
                    .addComponent(btn_useService)
                    .addComponent(btn_checkOut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(604, 604, 604))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_hotel_building_70px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_logout)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 909, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_logout)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Statistical;
    public javax.swing.JButton btn_bookRoom;
    public javax.swing.JButton btn_checkIn;
    public javax.swing.JButton btn_checkOut;
    public javax.swing.JButton btn_listCustomer;
    public javax.swing.JButton btn_listRoom;
    public javax.swing.JButton btn_service;
    public javax.swing.JButton btn_staff;
    public javax.swing.JButton btn_useService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lb_logout;
    public javax.swing.JLabel lb_userName;
    // End of variables declaration//GEN-END:variables

}
