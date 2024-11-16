package view;

import DBC.Dbconnection;
import controller.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.quanlymodel;

/**
 *
 * @author Hieus
 */
public class QuanLy extends javax.swing.JFrame {

    private boolean admin;
    private Datban ban;
    private nhansucontroller ns;
    private accountcontroller tk;
    private Connection conn;
    private boolean isEditing = false;

    public QuanLy(boolean isAdmin) {
        this.admin = isAdmin;
        initComponents();
        setTitle("Coffee");
        tk = new accountcontroller();
        ns = new nhansucontroller();
        loadDataToTable();
        enableTextFields(false);

    }

    private void loadDataToTable() {
        ResultSet rs = null;
        Connection conn = Dbconnection.getInstance().getConnection();
        try {

            String sql = "SELECT NS.ID_NHAN_SU, NS.HO_VA_TEN, AC.TAIKHOAN, AC.MATKHAU, NS.NAM_SINH, NS.GIOI_TINH, NS.CHUC_VU, NS.QUE_QUAN, NS.SO_DIEN_THOAI FROM ACCOUNT AC JOIN NHAN_SU NS ON AC.ID_NHAN_SU = NS.ID_NHAN_SU";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"ID", "Họ và Tên", "Tài Khoản", "Mật Khẩu", "Năm Sinh",
                        "Giới Tính", "Chức Vụ", "Quê Quán", "Số Điện Thoại"}, 0
            );
            jTable1.setDefaultEditor(Object.class, null);
            while (rs.next()) {
                String password = rs.getString("MATKHAU");
                String encodedPassword = (password != null) ? tk.encodePassword(password) : "N/A";

                model.addRow(new Object[]{
                    rs.getInt("ID_NHAN_SU"),
                    rs.getString("HO_VA_TEN"),
                    rs.getString("TAIKHOAN"),
                    encodedPassword,
                    rs.getInt("NAM_SINH"),
                    rs.getString("GIOI_TINH"),
                    rs.getString("CHUC_VU"),
                    rs.getString("QUE_QUAN"),
                    rs.getString("SO_DIEN_THOAI")
                });
            }
            jTable1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deletefield() {
        txtID.setText("");
        txtHoten.setText("");
        txtGioitinh.setText("");
        txtQuequan.setText("");
        txtNamsinh.setText("");
        txtChucvu.setText("");
        txtSdt.setText("");
        txtTaikhoan.setText("");
        txtMatkhau.setText("");
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        Boxbtn = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKLuu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNamsinh = new javax.swing.JTextField();
        txtQuequan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtChucvu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGioitinh = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTaikhoan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMatkhau = new javax.swing.JPasswordField();
        pnMenu3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        BtnDangxuat3 = new javax.swing.JButton();
        btnNhanVien3 = new javax.swing.JButton();
        btnDatban3 = new javax.swing.JButton();
        btnDatmon3 = new javax.swing.JButton();
        btnDoanthu2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        label1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        label1.setText("Quản lý nhân sự");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKLuu.setText("K.Lưu");
        btnKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BoxbtnLayout = new javax.swing.GroupLayout(Boxbtn);
        Boxbtn.setLayout(BoxbtnLayout);
        BoxbtnLayout.setHorizontalGroup(
            BoxbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BoxbtnLayout.createSequentialGroup()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKLuu))
        );
        BoxbtnLayout.setVerticalGroup(
            BoxbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoxbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(BoxbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnKLuu)))
        );

        txtNamsinh.setEditable(false);

        txtQuequan.setEditable(false);

        jLabel3.setText("Quê quán:");

        jLabel4.setText("Chức vụ:");

        txtChucvu.setEditable(false);

        jLabel5.setText("Số điện thoại:");

        txtSdt.setEditable(false);

        jLabel6.setText("Giới tính:");

        txtGioitinh.setEditable(false);

        txtHoten.setEditable(false);

        jLabel1.setText("Năm sinh:");

        jLabel8.setText("ID:");

        txtID.setEditable(false);

        jLabel9.setText("Họ và Tên:");

        jLabel10.setText("Tài khoản:");

        txtTaikhoan.setEditable(false);

        jLabel11.setText("Mật khẩu:");

        txtMatkhau.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGioitinh))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtQuequan))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(txtNamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChucvu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTaikhoan)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatkhau))
                            .addComponent(txtSdt))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(2, 2, 2)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(197, 197, 197)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addGap(187, 187, 187))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(Boxbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(90, 90, 90)))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(Boxbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)))
        );

        pnMenu3.setBackground(new java.awt.Color(74, 48, 34));
        pnMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnDangxuat3.setText("Đăng xuất");
        BtnDangxuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDangxuat3ActionPerformed(evt);
            }
        });

        btnNhanVien3.setBackground(new java.awt.Color(255, 102, 102));
        btnNhanVien3.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien3.setText("Nhân viên");
        btnNhanVien3.setBorder(null);
        btnNhanVien3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVien3ActionPerformed(evt);
            }
        });

        btnDatban3.setBackground(new java.awt.Color(74, 48, 34));
        btnDatban3.setForeground(new java.awt.Color(255, 255, 255));
        btnDatban3.setText("Đặt bàn");
        btnDatban3.setBorder(null);
        btnDatban3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatban3ActionPerformed(evt);
            }
        });

        btnDatmon3.setBackground(new java.awt.Color(74, 48, 34));
        btnDatmon3.setForeground(new java.awt.Color(255, 255, 255));
        btnDatmon3.setText("Đặt món");
        btnDatmon3.setBorder(null);
        btnDatmon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatmon3ActionPerformed(evt);
            }
        });

        btnDoanthu2.setBackground(new java.awt.Color(74, 48, 34));
        btnDoanthu2.setForeground(new java.awt.Color(255, 255, 255));
        btnDoanthu2.setText("Doanh thu");
        btnDoanthu2.setBorder(null);
        btnDoanthu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanthu2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Name");

        javax.swing.GroupLayout pnMenu3Layout = new javax.swing.GroupLayout(pnMenu3);
        pnMenu3.setLayout(pnMenu3Layout);
        pnMenu3Layout.setHorizontalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addGroup(pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMenu3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnMenu3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(BtnDangxuat3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
            .addComponent(btnDoanthu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatmon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatban3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMenu3Layout.setVerticalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(49, 49, 49)
                .addComponent(btnDatban3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatmon3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanthu2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(BtnDangxuat3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void enableTextFields(boolean enable) {
        txtHoten.setEditable(enable);
        txtTaikhoan.setEditable(enable);
        txtMatkhau.setEditable(enable);
        txtNamsinh.setEditable(enable);
        txtGioitinh.setEditable(enable);
        txtChucvu.setEditable(enable);
        txtQuequan.setEditable(enable);
        txtSdt.setEditable(enable);
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Themnhanvien them = new Themnhanvien();
        them.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectRow = jTable1.getSelectedRow();

        if (selectRow != -1) {
            isEditing = !isEditing;
            if (isEditing) {
                enableTextFields(true);
            } else {
                enableTextFields(false);
            }
            int id = Integer.parseInt(txtID.getText());
            String Ten = txtHoten.getText();
            String taikhoan = txtTaikhoan.getText();
            char[] mk = txtMatkhau.getPassword();
            String mkStr = String.valueOf(mk);
            int namsinh = Integer.parseInt(txtNamsinh.getText());
            String gt = txtGioitinh.getText();
            String chucvu = txtChucvu.getText();
            String quequan = txtQuequan.getText();
            String sdt = txtSdt.getText();
            if (Ten.isEmpty() || taikhoan.isEmpty() || mkStr.isEmpty() || gt.isEmpty() || chucvu.isEmpty() || quequan.isEmpty() || sdt.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            }

            if (ns.checkEmployeeExists(id)) {
                // Tạo đối tượng Employee để cập nhật thông tin nhân viên
                quanlymodel employee = new quanlymodel(id, Ten, gt, namsinh, chucvu, quequan, sdt);

                // Cập nhật tài khoản và thông tin nhân viên
                boolean checkAccount = tk.editAccount(taikhoan, mkStr, id);
                boolean checkTtnv = ns.updateEmployee(employee);
                if (checkTtnv && checkAccount) {
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nhân viên với ID này không tồn tại.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn hàng để sửa");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectRow = jTable1.getSelectedRow();
        if (selectRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xóa.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int idNhanSu = (int) jTable1.getValueAt(selectRow, 0);
        if (ns.deleteEmployee(idNhanSu)) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(selectRow);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            deletefield();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên.");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow(); // Lấy hàng được chọn

        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn và điền vào các text field
            Object idObj = jTable1.getValueAt(selectedRow, 0);
            Object hoVaTenObj = jTable1.getValueAt(selectedRow, 1);
            Object taiKhoanObj = jTable1.getValueAt(selectedRow, 2);
            Object matKhauObj = jTable1.getValueAt(selectedRow, 3);
            Object namSinhObj = jTable1.getValueAt(selectedRow, 4);
            Object gioiTinhObj = jTable1.getValueAt(selectedRow, 5);
            Object chucVuObj = jTable1.getValueAt(selectedRow, 6);
            Object queQuanObj = jTable1.getValueAt(selectedRow, 7);
            Object soDienThoaiObj = jTable1.getValueAt(selectedRow, 8);
            // Điền dữ liệu vào các text field (giả sử bạn đã tạo các text field này)
            if (idObj != null) {
                txtID.setText(idObj.toString());
            }
            if (hoVaTenObj != null) {
                txtHoten.setText(hoVaTenObj.toString());
            }
            if (taiKhoanObj != null) {
                txtTaikhoan.setText(taiKhoanObj.toString());
            }
            if (matKhauObj != null) {
                txtMatkhau.setText(matKhauObj.toString());
            }
            if (namSinhObj != null) {
                txtNamsinh.setText(namSinhObj.toString());
            }
            if (gioiTinhObj != null) {
                txtGioitinh.setText(gioiTinhObj.toString());
            }
            if (chucVuObj != null) {
                txtChucvu.setText(chucVuObj.toString());
            }
            if (queQuanObj != null) {
                txtQuequan.setText(queQuanObj.toString());
            }
            if (soDienThoaiObj != null) {
                txtSdt.setText(soDienThoaiObj.toString());
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        int selectRow = jTable1.getSelectedRow();
        if (selectRow != -1 && isEditing) { // Kiểm tra nếu có hàng được chọn và đang ở trạng thái chỉnh sửa
            // Lấy ID nhân viên từ bảng
            int id_nhan_su = Integer.parseInt(jTable1.getValueAt(selectRow, 0).toString());

            // Lấy thông tin từ các trường nhập
            String Ten = txtHoten.getText();
            String taikhoan = txtTaikhoan.getText();
            char[] mk = txtMatkhau.getPassword();
            String mkStr = String.valueOf(mk);
            int namsinh = Integer.parseInt(txtNamsinh.getText());
            String gt = txtGioitinh.getText();
            String chucvu = txtChucvu.getText();
            String quequan = txtQuequan.getText();
            String sdt = txtSdt.getText();

            // Kiểm tra nếu các trường nhập còn trống
            if (Ten.isEmpty() || taikhoan.isEmpty() || mkStr.isEmpty() || gt.isEmpty() || chucvu.isEmpty() || quequan.isEmpty() || sdt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            // Cập nhật thông tin tài khoản
            boolean checkAccount = tk.editAccount(taikhoan, mkStr, id_nhan_su);

            // Cập nhật thông tin nhân viên
            quanlymodel employee = new quanlymodel(id_nhan_su, Ten, gt, namsinh, chucvu, quequan, sdt);
            boolean checkTtnv = ns.updateEmployee(employee);

            // Kiểm tra kết quả cập nhật
            if (checkAccount && checkTtnv) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadDataToTable(); // Cập nhật lại dữ liệu trong bảng
                enableTextFields(false); // Vô hiệu hóa các trường nhập sau khi lưu
                isEditing = false; // Đặt lại cờ chỉnh sửa
                deletefield();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại. Vui lòng thử lại.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            deletefield();
            enableTextFields(false);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKLuuActionPerformed
        // TODO add your handling code here:
        enableTextFields(false);
        deletefield();
    }//GEN-LAST:event_btnKLuuActionPerformed

    private void BtnDangxuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDangxuat3ActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(this,
            "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmed == JOptionPane.YES_OPTION) {
            Dangnhap frm = new Dangnhap();
            frm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtnDangxuat3ActionPerformed

    private void btnNhanVien3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVien3ActionPerformed
        // TODO add your handling code here:
        QuanLy ql = new QuanLy(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        ql.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnNhanVien3ActionPerformed

    private void btnDatban3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatban3ActionPerformed
        // TODO add your handling code here:
        Datban db = new Datban(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        db.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDatban3ActionPerformed

    private void btnDatmon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatmon3ActionPerformed
        // TODO add your handling code here:
        Goimon gm = new Goimon(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        gm.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDatmon3ActionPerformed

    private void btnDoanthu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanthu2ActionPerformed
        // TODO add your handling code here:
        Doanhthu dt = new Doanhthu(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        dt.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDoanthu2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Boxbtn;
    private javax.swing.JButton BtnDangxuat3;
    private javax.swing.JButton btnDatban3;
    private javax.swing.JButton btnDatmon3;
    private javax.swing.JButton btnDoanthu2;
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhanVien3;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JPanel pnMenu3;
    private javax.swing.JTextField txtChucvu;
    private javax.swing.JTextField txtGioitinh;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtNamsinh;
    private javax.swing.JTextField txtQuequan;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTaikhoan;
    // End of variables declaration//GEN-END:variables
}
