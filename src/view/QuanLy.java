package view;

import DBC.Dbconnection;
import controller.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.nhansumodel;

/**
 *
 * @author Hieus
 */
public class QuanLy extends javax.swing.JFrame {

    private boolean admin;
    private bancontroller ban;
    private nhansucontroller ns;
    private accountcontroller tk;
    private Connection conn;
    private boolean isEditing = false;

    public QuanLy(boolean isAdmin) {
        this.admin = isAdmin;

        if (!Dangnhap.isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước!");
            this.dispose();
            new Dangnhap().setVisible(true);
            return;
        }
        initComponents();
        setTitle("Coffee");
        tk = new accountcontroller();
        ns = new nhansucontroller();
        ban = new bancontroller();
        displayLoggedInUser();
        loadDataToTable();
        enableTextFields(false);

    }

    private void displayLoggedInUser() {
        String username = accountcontroller.loggedInUsername;
        if (username != null) {
            txtUser.setText("" + username);
        } else {
            txtUser.setText("NULL22");
        }
    }

    private void loadDataToTable() {
        Connection conn = Dbconnection.getInstance().getConnection();
        try {
            ResultSet rs = ns.getAll();
            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"ID", "Họ và Tên", "Tài Khoản", "Mật Khẩu", "Năm Sinh",
                        "Giới Tính", "Chức Vụ", "Quê Quán", "Số Điện Thoại"}, 0
            );
            jTable1.setDefaultEditor(Object.class, null);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("ID_NHAN_SU"),
                    rs.getString("HO_VA_TEN"),
                    rs.getString("TAIKHOAN"),
                    rs.getString("MATKHAU"),
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
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnMenu3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        BtnDangxuat3 = new javax.swing.JButton();
        btnNhanVien3 = new javax.swing.JButton();
        btnDatban3 = new javax.swing.JButton();
        btnDatmon3 = new javax.swing.JButton();
        btnDoanthu2 = new javax.swing.JButton();
        txtUser = new javax.swing.JLabel();
        btnDouong = new javax.swing.JButton();

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

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                .addComponent(btnKLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuequan)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTaikhoan)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatkhau))
                    .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.TRAILING)))
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
                .addGap(18, 18, 18)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel2.setText("Nhập mã:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/reload.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(24, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boxbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Boxbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pnMenu3.setBackground(new java.awt.Color(74, 48, 34));
        pnMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnDangxuat3.setText("Đăng xuất");
        BtnDangxuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDangxuat3ActionPerformed(evt);
            }
        });

        btnNhanVien3.setBackground(new java.awt.Color(202, 174, 136));
        btnNhanVien3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnNhanVien3.setForeground(new java.awt.Color(146, 73, 0));
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

        txtUser.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUser.setText("Name");

        btnDouong.setBackground(new java.awt.Color(74, 48, 34));
        btnDouong.setForeground(new java.awt.Color(255, 255, 255));
        btnDouong.setText("Đồ uống");
        btnDouong.setBorder(null);
        btnDouong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDouongActionPerformed(evt);
            }
        });

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
            .addComponent(btnDatmon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatban3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnDoanthu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDouong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMenu3Layout.setVerticalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(49, 49, 49)
                .addComponent(btnDatban3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatmon3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanthu2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDouong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void enableTextFields(boolean enable) {
        txtHoten.setEditable(enable);
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
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            Object idObj = jTable1.getValueAt(selectedRow, 0);
            Object hoVaTenObj = jTable1.getValueAt(selectedRow, 1);
            Object taiKhoanObj = jTable1.getValueAt(selectedRow, 2);
            Object matKhauObj = jTable1.getValueAt(selectedRow, 3);
            Object namSinhObj = jTable1.getValueAt(selectedRow, 4);
            Object gioiTinhObj = jTable1.getValueAt(selectedRow, 5);
            Object chucVuObj = jTable1.getValueAt(selectedRow, 6);
            Object queQuanObj = jTable1.getValueAt(selectedRow, 7);
            Object soDienThoaiObj = jTable1.getValueAt(selectedRow, 8);
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
        if (selectRow != -1 && isEditing) {
            int id_nhan_su = Integer.parseInt(jTable1.getValueAt(selectRow, 0).toString());

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
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            boolean checkAccount = tk.editAccount(taikhoan, mkStr, id_nhan_su);

            nhansumodel employee = new nhansumodel(id_nhan_su, Ten, gt, namsinh, chucvu, quequan, sdt);
            boolean checkTtnv = ns.updateEmployee(employee);

            if (checkAccount && checkTtnv) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadDataToTable();
                enableTextFields(false);
                isEditing = false;
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
        QuanLy ql = new QuanLy(admin);
        ql.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNhanVien3ActionPerformed

    private void btnDatban3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatban3ActionPerformed
        // TODO add your handling code here:
        Datban db = new Datban(admin);
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDatban3ActionPerformed

    private void btnDatmon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatmon3ActionPerformed
        boolean hasBanDaDat = ban.isAnyBanDaDat();
        if (!hasBanDaDat) {
            JOptionPane.showMessageDialog(this, "Không có bàn nào đang được đặt. Vui lòng đặt bàn trước!");
            return;
        }

        Goimon goiMonUI = new Goimon(admin);
        goiMonUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDatmon3ActionPerformed

    private void btnDoanthu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanthu2ActionPerformed
        // TODO add your handling code here:
        Doanhthu dt = new Doanhthu(admin);
        dt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDoanthu2ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã ID để tìm kiếm.");
            QuanLy ql = new QuanLy(admin);
            ql.setVisible(true);
            this.dispose();
            return;
        }
        try {
            int id = Integer.parseInt(keyword);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            jTable1.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, id, 0));
            deletefield();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID phải là một số nguyên.");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnDouongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDouongActionPerformed
        // TODO add your handling code here:
        QlyDouong form = new QlyDouong(admin);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDouongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                QuanLy ql = new QuanLy(admin);
        ql.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btnDouong;
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhanVien3;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
