/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlikhachsan.View;

import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author BVKieu
 */
public class Customer_View extends javax.swing.JFrame {

    public Customer_View() {
        try {
            javax.swing.UIManager.setLookAndFeel(new NimbusLookAndFeel());            
        } catch (Exception e) {
        }
        setTitle("Quản lí khách hàng");
        initComponents();
        setLocation(400, 150);
        setVisible(true);
        setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addActionListener(ActionListener al, JButton btn) {
        btn.addActionListener(al);
    }
    
    public void txt_ActionListener(KeyListener kl, JTextField txt){
        txt.addKeyListener(kl);
    }
    public void columnTitleListener( MouseAdapter ma, JTableHeader tb){
        tb.addMouseListener(ma);              
    }
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_customerName = new javax.swing.JTextField();
        txt_customerIDcard = new javax.swing.JTextField();
        txt_customerAddress = new javax.swing.JTextField();
        txt_customerPhoneNumber = new javax.swing.JTextField();
        txt_customerEmail = new javax.swing.JTextField();
        txt_customerNote = new javax.swing.JTextField();
        cbb_customerSex = new javax.swing.JComboBox<>();
        btn_addCustomer = new javax.swing.JButton();
        btn_resetCustomer = new javax.swing.JButton();
        cbb_customerNationality = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        txt_searchCustomer = new javax.swing.JTextField();
        btn_showAllCustomer = new javax.swing.JButton();
        btn_fixCustomer = new javax.swing.JButton();
        btn_deleteCustomer = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lí khách hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel2.setText("Tên khách hàng: *");

        jLabel3.setText("Số CMND/Hộ chiếu: *");

        jLabel4.setText("Giới tính: *");

        jLabel5.setText("Địa chỉ: *");

        jLabel6.setText("Số điện thoại: *");

        jLabel7.setText("Quốc tịch: *");

        jLabel8.setText("Email:");

        jLabel9.setText("Ghi chú:");

        cbb_customerSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        btn_addCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_20px.png"))); // NOI18N
        btn_addCustomer.setText("Thêm");
        btn_addCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCustomerActionPerformed(evt);
            }
        });

        btn_resetCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_undo_alt_16px.png"))); // NOI18N
        btn_resetCustomer.setText("Nhập lại");

        cbb_customerNationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vietnamese", "Afghan", "Albanian", "Algerian", "Argentine", "Argentinian", "Australian", "Austrian", "Bangladeshi", "Belgian", "Bolivian", "Batswana", "Brazilian", "Bulgarian", "Cambodian", "Cameroonian", "Canadian", "Chilean", "Chinese", "Colombian", "Costa Rican", "Croatian", "Cuban", "Czech", "Danish", "Dominican", "Ecuadorian", "Egyptian", "Salvadorian", "English", "Estonian", "Ethiopian", "Fijian", "Finnish", "French", "German", "Ghanaian", "Greek", "Guatemalan", "Haitian", "Honduran", "Hungarian", "Icelandic", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Jamaican", "Japanese", "Jordanian", "Kenyan", "Kuwaiti", "Lao", "Latvian", "Lebanese", "Libyan", "Lithuanian", "Malagasy", "Malaysian", "Malian", "Maltese", "Mexican", "Mongolian", "Moroccan", "Mozambican", "Namibian", "Nepalese", "Dutch", "New Zealand", "Nicaraguan", "Nigerian", "Norwegian", "Pakistani", "Panamanian", "Paraguayan", "Peruvian", "Philippine", "Polish", "Portuguese", "Romanian", "Russian", "Saudi", "Scottish", "Senegalese", "Serbian", "Singaporean", "Slovak", "South African", "Korean", "Spanish", "Sri Lankan", "Sudanese", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajikistani", "Thai", "Tongan", "Tunisian", "Turkish", "Ukrainian", "Emirati", "British", "American", "Uruguayan", "Venezuelan", "Welsh", "Zambian", "Zimbabwean" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_customerEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_customerNationality, javax.swing.GroupLayout.Alignment.LEADING, 0, 178, Short.MAX_VALUE)
                            .addComponent(txt_customerPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_customerAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_customerSex, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_customerIDcard, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_customerName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_customerNote))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_addCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_resetCustomer)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_customerIDcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbb_customerSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_customerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_customerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbb_customerNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_customerNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_resetCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addCustomer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Số CMND/Hộ chiếu", "Giới tính", "Địa chỉ", "Số điện thoại", "Quốc tịch", "Email", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        txt_searchCustomer.setToolTipText("Tìm tên khách hàng");
        txt_searchCustomer.setName(""); // NOI18N

        btn_showAllCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list.png"))); // NOI18N
        btn_showAllCustomer.setText("Danh sách khách hàng");

        btn_fixCustomer.setForeground(new java.awt.Color(255, 0, 0));
        btn_fixCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_maintenance_16px.png"))); // NOI18N
        btn_fixCustomer.setText("Sửa");

        btn_deleteCustomer.setForeground(new java.awt.Color(255, 0, 0));
        btn_deleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_trash_16px.png"))); // NOI18N
        btn_deleteCustomer.setText("Xóa");

        jLabel10.setText("Tìm kiếm tên:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_searchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btn_fixCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btn_deleteCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btn_showAllCustomer)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_searchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_showAllCustomer)
                        .addComponent(jLabel10)
                        .addComponent(btn_deleteCustomer))
                    .addComponent(btn_fixCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_addCustomer;
    public javax.swing.JButton btn_deleteCustomer;
    public javax.swing.JButton btn_fixCustomer;
    public javax.swing.JButton btn_resetCustomer;
    public javax.swing.JButton btn_showAllCustomer;
    public javax.swing.JComboBox<String> cbb_customerNationality;
    public javax.swing.JComboBox<String> cbb_customerSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableCustomer;
    public javax.swing.JTextField txt_customerAddress;
    public javax.swing.JTextField txt_customerEmail;
    public javax.swing.JTextField txt_customerIDcard;
    public javax.swing.JTextField txt_customerName;
    public javax.swing.JTextField txt_customerNote;
    public javax.swing.JTextField txt_customerPhoneNumber;
    public javax.swing.JTextField txt_searchCustomer;
    // End of variables declaration//GEN-END:variables
}
