/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.bancontroller;
import controller.ordercontroller;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
<<<<<<< HEAD

=======
>>>>>>> 2f5d2d00c0bfbe6f8d91d1ec573d4f5b5373c8c3
import javax.swing.table.DefaultTableModel;
import model.quanliban;

import java.util.ArrayList;

/**
 *
 * @author leduc
 */
public class Goimon extends javax.swing.JFrame {

    private boolean admin;
    private bancontroller ban;
    private ordercontroller order;
    private quanliban qlban;
    private String selectedTable = "";
    private String maban = "";

    public Goimon(boolean isAdmin) {
        this.admin = isAdmin;
        btnNhanVien = new javax.swing.JButton();
        btnNhanVien.setVisible(admin);
        initComponents();
        ban = new bancontroller();
        order = new ordercontroller();
        updateLabels();
        updateDouong();
        LoadDataDouongdagoi(maban);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnBan2 = new javax.swing.JButton();
        btnBan1 = new javax.swing.JButton();
        btnBan4 = new javax.swing.JButton();
        btnBan3 = new javax.swing.JButton();
        btnBan5 = new javax.swing.JButton();
        lbBan3 = new javax.swing.JLabel();
        lbBan4 = new javax.swing.JLabel();
        lbBan5 = new javax.swing.JLabel();
        lbBan2 = new javax.swing.JLabel();
        lbBan1 = new javax.swing.JLabel();
        btnBan6 = new javax.swing.JButton();
        lbBan6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMondagoi = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabledsMon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTongtien = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnDangxuat = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnDatban = new javax.swing.JButton();
        btnDatmon = new javax.swing.JButton();
        btnDoanthu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(290, 354));

        btnBan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png"))); // NOI18N
        btnBan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan2ActionPerformed(evt);
            }
        });

        btnBan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png"))); // NOI18N
        btnBan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan1ActionPerformed(evt);
            }
        });

        btnBan4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png"))); // NOI18N
        btnBan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan4ActionPerformed(evt);
            }
        });

        btnBan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png"))); // NOI18N
        btnBan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan3ActionPerformed(evt);
            }
        });

        btnBan5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png"))); // NOI18N
        btnBan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan5ActionPerformed(evt);
            }
        });

        lbBan3.setText("BÀN 3");

        lbBan4.setText("BÀN 4");

        lbBan5.setText("BÀN 5");

        lbBan2.setText("BÀN 2");

        lbBan1.setText("BÀN 1");

        btnBan6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png"))); // NOI18N
        btnBan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan6ActionPerformed(evt);
            }
        });

        lbBan6.setText("BÀN 6");

        jLabel3.setText("Lưu ý:  + Chữ màu đỏ là bàn đã được ngồi");

        jLabel10.setText("+ Chữ màu xanh là bàn còn trống");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lbBan5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(lbBan6)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBan5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBan6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lbBan3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbBan4)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbBan1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbBan2)
                        .addGap(40, 40, 40)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBan1)
                    .addComponent(btnBan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbBan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBan3)
                    .addComponent(btnBan4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBan4)
                    .addComponent(lbBan3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBan5)
                    .addComponent(btnBan6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBan5)
                    .addComponent(lbBan6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnThanhtoan.setText("Thanh Toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        TableMondagoi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TableMondagoi);

        TabledsMon.setModel(new javax.swing.table.DefaultTableModel(
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
        TabledsMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabledsMonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabledsMon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH MÓN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("DANH SÁCH MÓN ĐÃ GỌI");

        lbTongtien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(211, 211, 211)
                                .addComponent(btnThanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(137, 137, 137))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnThem)
                        .addGap(26, 26, 26)
                        .addComponent(btnXoa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnThanhtoan)))
                .addGap(16, 16, 16))
        );

        pnMenu.setBackground(new java.awt.Color(74, 48, 34));
        pnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnDangxuat.setText("Đăng xuất");
        BtnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDangxuatActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(255, 102, 102));
        btnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setBorder(null);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnDatban.setBackground(new java.awt.Color(74, 48, 34));
        btnDatban.setForeground(new java.awt.Color(255, 255, 255));
        btnDatban.setText("Đặt bàn");
        btnDatban.setBorder(null);
        btnDatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatbanActionPerformed(evt);
            }
        });

        btnDatmon.setBackground(new java.awt.Color(74, 48, 34));
        btnDatmon.setForeground(new java.awt.Color(255, 255, 255));
        btnDatmon.setText("Đặt món");
        btnDatmon.setBorder(null);
        btnDatmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatmonActionPerformed(evt);
            }
        });

        btnDoanthu.setBackground(new java.awt.Color(74, 48, 34));
        btnDoanthu.setForeground(new java.awt.Color(255, 255, 255));
        btnDoanthu.setText("Doanh thu");
        btnDoanthu.setBorder(null);
        btnDoanthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanthuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDoanthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(BtnDangxuat)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(btnDatban, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatmon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanthu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnDangxuat)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public String getMaban() {
        return maban;
    }
    private void updateLabels() {
        JLabel[] lbBans = {lbBan1, lbBan2, lbBan3, lbBan4, lbBan5, lbBan6};
        boolean[] trangthaiBans = ban.Trangthai(); // Lấy trạng thái của từng bàn
        // Kiểm tra trạng thái của từng bàn và thay đổi màu sắc cho từng JLabel tương ứng
        for (int i = 0; i < lbBans.length; i++) {
            if (trangthaiBans[i]) {
                lbBans[i].setForeground(Color.GREEN); // Bàn trống
            } else {
                lbBans[i].setForeground(Color.RED); // Bàn có khách
            }
        }
    }

    public void updateDouong() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Tên đồ uống", "Giá tiền"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa bất kỳ ô nào trong bảng
            }
        };
        List<Object[]> douonglist = order.Danhsachdouong();

        if (douonglist != null) {
            for (Object[] douong : douonglist) {
                model.addRow(douong);
            }
        } else {
            System.out.println("Khong the lay danh sach do uong");
        }
        TabledsMon.setModel(model);
    }

    private void LoadDataDouongdagoi(String maBan) {
        DefaultTableModel modelMon = (DefaultTableModel) TableMondagoi.getModel();
        modelMon.setRowCount(0);
        
        // Lấy danh sách món của bàn từ cơ sở dữ liệu
        List<Object[]> danhSachMon = order.getDanhSachMonCuaBan(maBan);

        // Thêm dữ liệu vào bảng
        for (Object[] mon : danhSachMon) {
            modelMon.addRow(mon);
        }
        // setHeader
        String[] columnNames = {"Mã đồ uống", "Tên đồ uống", "Số lượng", "Tổng tiền"};
        modelMon.setColumnIdentifiers(columnNames);
        // Gán lại model cho bảng (không thực sự cần thiết nếu model không thay đổi)
        TableMondagoi.setModel(modelMon);
        updateTotalAmountLabel();
    }
    private void deleteSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) TableMondagoi.getModel();
        int selectedRow = TableMondagoi.getSelectedRow(); // Lấy dòng được chọn

        if (selectedRow != -1) {
            // Lấy giá trị của MABAN và MADOUONG từ dòng được chọn
            String maBan = selectedTable;  // Giả sử cột đầu tiên là MABAN
            String maDoUong = (String) model.getValueAt(selectedRow, 0);  // Giả sử cột thứ 2 là MADOUONG

            // Kiểm tra lại dữ liệu trước khi xóa
            if (maBan != null && maDoUong != null) {
                // Xóa dữ liệu trong cơ sở dữ liệu
                boolean isDeleted = order.deleteFromDatabase(maBan, maDoUong);  // Giả sử phương thức return true/false

                if (isDeleted) {
                    // Xóa dòng trong bảng chỉ khi xóa thành công trong cơ sở dữ liệu
                    model.removeRow(selectedRow);

                    // Làm mới lại dữ liệu sau khi xóa
                    LoadDataDouongdagoi(maBan);

                    // Cập nhật tổng tiền (nếu cần thiết)
                    updateTotalAmountLabel();
                } 
            } else {
                JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ, không thể xóa.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.");
        }
    }


    
    private void handleBanSelection(String maBan) {
        selectedTable = maBan;  // Cập nhật bàn đã chọn
        LoadDataDouongdagoi(selectedTable);  // Tải dữ liệu tương ứng
        
    }

    private void updateTotalAmountLabel() {
        double totalAmount = calculateTotalAmount();
        lbTongtien.setText("Thành tiền:" + totalAmount +"đ");
    }
    private double calculateTotalAmount() { 
        double totalAmount = 0;
        DefaultTableModel model = (DefaultTableModel) TableMondagoi.getModel(); 
        int rowCount = model.getRowCount(); 
        for (int i = 0; i < rowCount; i++) { 
            double tongtien = (double) model.getValueAt(i, 3);
            totalAmount += tongtien; 
        }
        return totalAmount; 
    }
    
    private void btnBan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan6ActionPerformed
        handleBanSelection("B06");
        
    }//GEN-LAST:event_btnBan6ActionPerformed

    private void btnBan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan5ActionPerformed
        
        handleBanSelection("B05");

       
    }//GEN-LAST:event_btnBan5ActionPerformed

    private void btnBan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan3ActionPerformed
    
        handleBanSelection("B03");

        // Gọi phương thức tính tổng tiền từ cơ sở dữ liệu
        
    }//GEN-LAST:event_btnBan3ActionPerformed

    private void btnBan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan4ActionPerformed
        
        handleBanSelection("B04");

        // Gọi phương thức tính tổng tiền từ cơ sở dữ liệu
        
    }//GEN-LAST:event_btnBan4ActionPerformed

    private void btnBan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan1ActionPerformed
        
        handleBanSelection("B01");

        
    }//GEN-LAST:event_btnBan1ActionPerformed

    private void btnBan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan2ActionPerformed
        handleBanSelection("B02");

       
    }//GEN-LAST:event_btnBan2ActionPerformed

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
        QuanLy ql = new QuanLy(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        ql.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnDatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatbanActionPerformed
        // TODO add your handling code here:
        Datban db = new Datban(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        db.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDatbanActionPerformed

    private void btnDatmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatmonActionPerformed
        // TODO add your handling code here:
        Goimon gm = new Goimon(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        gm.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDatmonActionPerformed

    private void btnDoanthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanthuActionPerformed
        // TODO add your handling code here:
        Doanhthu dt = new Doanhthu(admin); // Truyền tham số admin vào để giữ nguyên quyền truy cập
        dt.setVisible(true); // Hiển thị trang QuanLy
        this.dispose(); // Đóng trang hiện tại
    }//GEN-LAST:event_btnDoanthuActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // Lấy thông tin tên bàn
        String tenBan = ban.getTenBan(selectedTable);

        // Lấy danh sách món từ JTable
        DefaultTableModel model = (DefaultTableModel) TableMondagoi.getModel();
        List<String[]> danhSachMon = new ArrayList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            String maMon = model.getValueAt(i, 0).toString();
            String tenMon = model.getValueAt(i, 1).toString();
            String soLuong = model.getValueAt(i, 2).toString();
            String gia = model.getValueAt(i, 3).toString();
            danhSachMon.add(new String[]{maMon, tenMon, soLuong, gia});
        }

        // Mở giao diện ThanhToan và truyền dữ liệu qua setter
        ThanhToan thanhToanForm = new ThanhToan(admin);
        thanhToanForm.setTenBan(tenBan);            // Truyền tên bàn
        thanhToanForm.setNgayDat();                // Truyền ngày đặt
        thanhToanForm.setDanhSachMon(danhSachMon); // Truyền danh sách món
        thanhToanForm.setVisible(true);
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void TabledsMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabledsMonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_TabledsMonMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int selectedRow = TabledsMon.getSelectedRow();
        if (selectedRow != -1) {
            String tendouong = TabledsMon.getValueAt(selectedRow, 0).toString();
            String madouong = order.Madouong(tendouong);
            double gia = (double) TabledsMon.getValueAt(selectedRow, 1);
            int soluong = 1;
            double tongtien = gia * soluong;
            String maBan = selectedTable;
            double chiPhi = 0;

            boolean isUpdated = order.addDrinkToTable(maBan, madouong, tendouong, soluong, gia, chiPhi);

            LoadDataDouongdagoi(maBan);
            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Số lượng món đã được cập nhật!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Món mới đã được thêm!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn món trước khi thêm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        deleteSelectedRow();
    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Goimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Goimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Goimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Goimon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Goimon(true).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDangxuat;
    private javax.swing.JTable TableMondagoi;
    private javax.swing.JTable TabledsMon;
    private javax.swing.JButton btnBan1;
    private javax.swing.JButton btnBan2;
    private javax.swing.JButton btnBan3;
    private javax.swing.JButton btnBan4;
    private javax.swing.JButton btnBan5;
    private javax.swing.JButton btnBan6;
    private javax.swing.JButton btnDatban;
    private javax.swing.JButton btnDatmon;
    private javax.swing.JButton btnDoanthu;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBan1;
    private javax.swing.JLabel lbBan2;
    private javax.swing.JLabel lbBan3;
    private javax.swing.JLabel lbBan4;
    private javax.swing.JLabel lbBan5;
    private javax.swing.JLabel lbBan6;
    private javax.swing.JLabel lbTongtien;
    private javax.swing.JPanel pnMenu;
    // End of variables declaration//GEN-END:variables

}
