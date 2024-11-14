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
    private nhansucontroller ns;
    private accountcontroller tk;
    private Connection conn;

    public QuanLy(boolean isAdmin) {
        this.admin = isAdmin;
        initComponents();
        btnNhanVien.setVisible(admin);
        setTitle("Coffee");
        tk = new accountcontroller();
        ns = new nhansucontroller();
        loadDataToTable();

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
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnDangxuat = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnTrangchu = new javax.swing.JButton();
        btnDatban = new javax.swing.JButton();
        btnDatmon = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        btnDoanhthu = new javax.swing.JButton();
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

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnDangxuat.setText("Đăng xuất");
        BtnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDangxuatActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(255, 102, 102));
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setBorder(null);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnTrangchu.setText("Trang chủ");
        btnTrangchu.setBorder(null);

        btnDatban.setText("Đặt bàn");
        btnDatban.setBorder(null);
        btnDatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatbanActionPerformed(evt);
            }
        });

        btnDatmon.setText("Đặt món");
        btnDatmon.setBorder(null);
        btnDatmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatmonActionPerformed(evt);
            }
        });

        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.setBorder(null);
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        btnDoanhthu.setText("Doanh thu");
        btnDoanhthu.setBorder(null);
        btnDoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhthuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(BtnDangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(71, 71, 71))
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoanhthu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhtoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatmon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrangchu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnTrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatban, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatmon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnDangxuat)
                .addContainerGap())
        );

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

        jLabel3.setText("Quê quán:");

        jLabel4.setText("Chức vụ:");

        jLabel5.setText("Số điện thoại:");

        jLabel6.setText("Giới tính:");

        jLabel1.setText("Năm sinh:");

        jLabel8.setText("ID:");

        txtID.setEnabled(false);

        jLabel9.setText("Họ và Tên:");

        jLabel10.setText("Tài khoản:");

        jLabel11.setText("Mật khẩu:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(242, 242, 242))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(55, 55, 55))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(Boxbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(145, 145, 145))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Boxbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void enableTextFields(boolean enable) {
        txtID.setEditable(enable);
        txtHoten.setEditable(enable);
        txtTaikhoan.setEditable(enable);
        txtMatkhau.setEditable(enable);
        txtNamsinh.setEditable(enable);
        txtGioitinh.setEditable(enable);
        txtChucvu.setEditable(enable);
        txtQuequan.setEditable(enable);
        txtSdt.setEditable(enable);
    }
    private void BtnDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDangxuatActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmed == JOptionPane.YES_OPTION) {
            Dangnhap frm = new Dangnhap();
            frm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtnDangxuatActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnDatmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatmonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatmonActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void btnDoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoanhthuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Themnhanvien them = new Themnhanvien();
        them.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        int selectRow = jTable1.getSelectedRow();
        if (selectRow != -1) {
            try {
                enableTextFields(true);
                updateSelectedRow(selectRow);
                JOptionPane.showMessageDialog(null, "Sửa lỗi thành công.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin nhân viên");
            } finally {
                enableTextFields(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn hàng để sửa");
        }

    }//GEN-LAST:event_btnSuaActionPerformed
    private void updateSelectedRow(int selectRow) throws Exception {
        String hoten = txtHoten.getText().trim();
        String taikhoan = txtTaikhoan.getText().trim();
        char[] matkhau = txtMatkhau.getPassword();
        String mkStr = new String(matkhau).trim();
        String namsinh = txtNamsinh.getText().trim();
        String gt = txtGioitinh.getText().trim();
        String chucvu = txtChucvu.getText().trim();
        String quequan = txtQuequan.getText().trim();
        String sdt = txtSdt.getText().trim();
        if (hoten.isEmpty() || taikhoan.isEmpty() || mkStr.isEmpty() || namsinh.isEmpty() || gt.isEmpty() || chucvu.isEmpty() || quequan.isEmpty() || sdt.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin.");
        }
        String mahoaMkMoi = tk.encodePassword(mkStr);

        jTable1.setValueAt(hoten, selectRow, 1);
        jTable1.setValueAt(taikhoan, selectRow, 2);
        jTable1.setValueAt(mahoaMkMoi, selectRow, 3);
        jTable1.setValueAt(namsinh, selectRow, 4);
        jTable1.setValueAt(gt, selectRow, 5);
        jTable1.setValueAt(chucvu, selectRow, 6);
        jTable1.setValueAt(quequan, selectRow, 7);
        jTable1.setValueAt(sdt, selectRow, 8);
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectRow = jTable1.getSelectedRow();

        if (selectRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa nhân viên này ?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectRow);
            } else {
                JOptionPane.showConfirmDialog(this, "Vui lòng chọn nhân viên để xóa");
            }
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

    private void btnDatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatbanActionPerformed
        // TODO add your handling code here:
        Datban db = new Datban(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        db.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDatbanActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int id = (int) model.getValueAt(i, 0);
            String hoten = model.getValueAt(i, 1).toString();

            int namsinh = (int) model.getValueAt(i, 4);
            String gt = model.getValueAt(i, 5).toString();
            String chucvu = model.getValueAt(i, 6).toString();
            String quequan = model.getValueAt(i, 7).toString();
            String sdt = model.getValueAt(i, 8).toString();

        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKLuuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnKLuuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Boxbtn;
    private javax.swing.JButton BtnDangxuat;
    private javax.swing.JButton btnDatban;
    private javax.swing.JButton btnDatmon;
    private javax.swing.JButton btnDoanhthu;
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTrangchu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JPanel pnMenu;
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
