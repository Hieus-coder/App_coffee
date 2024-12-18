/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.bancontroller;
import controller.douongcontroller;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Douong;

/**
 *
 * @author leduc
 */
public class QlyDouong extends javax.swing.JFrame {

    /**
     * Creates new form QlyDouong
     */
    private static boolean admin;
    private bancontroller ban;
    private douongcontroller douong;
    public QlyDouong(boolean _admin) {
        
        if (!Dangnhap.isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước!");
            this.dispose();
            new Dangnhap().setVisible(true);
            return;
        }
        setTitle("Coffee");
        this.admin = _admin;
        initComponents();
        ban = new bancontroller();
        douong = new douongcontroller();
        loadDouong();
    }
    public void loadDouong() {
        List<Douong> douongList = douong.getAllDouong();
        
        // Tạo model cho JTable
        String[] columnNames = {"Mã Đồ Uống", "Tên Đồ Uống", "Giá (VND)", "Chi Phí (VND)"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        // Thêm dữ liệu vào model
        for (Douong douong : douongList) {
            model.addRow(new Object[]{
                douong.getMaDouong(),
                douong.getTenDouong(),
                douong.getGia(),
                douong.getChiphi()
            });
        }
        // Đặt model cho JTable
        jTable1.setModel(model);
        lockTxt();
    }
    private void lockTxt() {
        txtMadouong.setEditable(false);
        txtTendouong.setEditable(false);
        txtGia.setEditable(false);
        txtGianhaplieu.setEditable(false);
    }
    private void unlockTxt(){
        txtMadouong.setEditable(true);
        txtTendouong.setEditable(true);
        txtGia.setEditable(true);
        txtGianhaplieu.setEditable(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        pnMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnDangxuat = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnDatban = new javax.swing.JButton();
        btnDatmon = new javax.swing.JButton();
        btnDoanthu = new javax.swing.JButton();
        txtUser = new javax.swing.JLabel();
        btnDouong = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKluu = new javax.swing.JButton();
        txtMadouong = new javax.swing.JTextField();
        txtTendouong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtGianhaplieu = new javax.swing.JTextField();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        jTextField5.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMenu.setBackground(new java.awt.Color(74, 48, 34));
        pnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnDangxuat.setText("Đăng xuất");
        BtnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDangxuatActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(74, 48, 34));
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

        txtUser.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUser.setText("Name");

        btnDouong.setBackground(new java.awt.Color(202, 174, 136));
        btnDouong.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnDouong.setForeground(new java.awt.Color(146, 73, 0));
        btnDouong.setText("Đồ uống");
        btnDouong.setBorder(null);
        btnDouong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDouongActionPerformed(evt);
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
                .addGap(56, 56, 56))
            .addComponent(btnDoanthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDouong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(btnDatban, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatmon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanthu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDouong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnDangxuat)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ ĐỒ UỐNG");

        jLabel3.setText("Mã đồ uống:");

        jLabel4.setText("Tên đồ uống:");

        jLabel5.setText("Giá:");

        jLabel6.setText("Giá nhập liệu:");

        jLabel7.setText("Tìm kiếm:");

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

        btnKluu.setText("Không lưu");
        btnKluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKluuActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(226, 226, 226))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKluu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMadouong, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTendouong, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGianhaplieu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMadouong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTendouong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGianhaplieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnKluu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        Datban db = new Datban(admin);
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDatbanActionPerformed

    private void btnDatmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatmonActionPerformed
        boolean hasBanDaDat = ban.isAnyBanDaDat();
        if (!hasBanDaDat) {
            JOptionPane.showMessageDialog(this, "Không có bàn nào đang được đặt. Vui lòng đặt bàn trước!");
            return;
        }

        Goimon goiMonUI = new Goimon(admin);
        goiMonUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDatmonActionPerformed

    private void btnDoanthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanthuActionPerformed
        // TODO add your handling code here:
        Doanhthu dt = new Doanhthu(admin);
        dt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDoanthuActionPerformed

    private void btnDouongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDouongActionPerformed
        // TODO add your handling code here:
        QlyDouong form = new QlyDouong(admin);
        form.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnDouongActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable1.getSelectedRow();
        if(rowIndex >= 0){
            txtMadouong.setText(jTable1.getValueAt(rowIndex, 0).toString());
            txtTendouong.setText(jTable1.getValueAt(rowIndex, 1).toString());
            txtGia.setText(jTable1.getValueAt(rowIndex, 2).toString());
            txtGianhaplieu.setText(jTable1.getValueAt(rowIndex, 3).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String maDouong = txtMadouong.getText().trim();
        String tenDouong = txtTendouong.getText().trim();
        
        try {
            double gia = Double.parseDouble(txtGia.getText().trim());
            double chiphi = Double.parseDouble(txtGianhaplieu.getText().trim());
            
            Douong updatedDouong = new Douong();
            updatedDouong.setMaDouong(maDouong);
            updatedDouong.setTenDouong(tenDouong);
            updatedDouong.setGia(gia);
            updatedDouong.setChiphi(chiphi);

            if (douong.isDouongExists(maDouong)) {
                // Cập nhật món
                boolean success = douong.update(updatedDouong);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Cập nhật món thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDouong();
                } else {
                    JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật món!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Thêm mới món
                boolean success = douong.insert(updatedDouong);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Thêm món thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDouong();
                } else {
                    JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm món!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị hợp lệ cho giá và chi phí!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        txtMadouong.setText("");
        txtTendouong.setText("");
        txtGia.setText("");
        txtGianhaplieu.setText("");
        unlockTxt();
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        unlockTxt();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnKluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKluuActionPerformed
        // TODO add your handling code here:
        txtMadouong.setText("");
        txtTendouong.setText("");
        txtGia.setText("");
        txtGianhaplieu.setText("");
        lockTxt();
    }//GEN-LAST:event_btnKluuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn món cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String madouong = jTable1.getValueAt(selectedRow, 0).toString();
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa món này?","Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            boolean success = douong.delete(madouong); 
            if (success) {
                JOptionPane.showMessageDialog(this, "Món đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDouong();  // Tải lại danh sách món sau khi xóa thành công
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xóa món!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String tenDouong = txtTim.getText().trim(); // Lấy tên đồ uống từ ô tìm kiếm

        if (tenDouong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đồ uống cần tìm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tìm kiếm đồ uống theo tên
        List<Douong> douongList = douong.searchDouongByName(tenDouong);

        // Tạo model cho JTable
        String[] columnNames = {"Mã Đồ Uống", "Tên Đồ Uống", "Giá (VND)", "Chi Phí (VND)"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Thêm dữ liệu vào model
        for (Douong douong : douongList) {
            model.addRow(new Object[]{
                douong.getMaDouong(),
                douong.getTenDouong(),
                douong.getGia(),
                douong.getChiphi()
            });
        }

        // Đặt model cho JTable
        jTable1.setModel(model);
    }//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(QlyDouong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyDouong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyDouong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyDouong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyDouong(admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDangxuat;
    private javax.swing.JButton btnDatban;
    private javax.swing.JButton btnDatmon;
    private javax.swing.JButton btnDoanthu;
    private javax.swing.JButton btnDouong;
    private javax.swing.JButton btnKluu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGianhaplieu;
    private javax.swing.JTextField txtMadouong;
    private javax.swing.JTextField txtTendouong;
    private javax.swing.JTextField txtTim;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
