package view;

import controller.bancontroller;
import DBC.Dbconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieus
 */
public class Datban extends javax.swing.JFrame {

    private Connection conn;
    private bancontroller bc;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of d16e67b (up)
    public Datban(boolean isAdmin) {
        this.admin = isAdmin;

        if (!Dangnhap.isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước!");
            this.dispose();
            new Dangnhap().setVisible(true);
            return;
        }

=======
    public Datban() {
>>>>>>> parent of 52a988d (up menu)
<<<<<<< HEAD
=======
    public Datban() {
>>>>>>> parent of 52a988d (up menu)
=======
    public Datban() {
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of d16e67b (up)
        initComponents();
        setTitle("Coffee");
        
        Dbconnection dbConnection = new Dbconnection();
        this.conn = dbConnection.getConnect(); // Lấy kết nối từ Dbconnection
        this.bc = new bancontroller(conn); 
        loadDataToTable(); 
    }

    int width = 210;
    int height = 900;

    void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnMenu.setSize(i, height);
//                    try {
//                        Thread.sleep(0,1);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Datban.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            }
        }).start();
    }

    void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnMenu.setSize(i, height);
//                    try {
//                        Thread.sleep(0,1);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Datban.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            }
        }).start();
    }

    /*width: 210
    height: 900*/
    private void loadDataToTable() {
        try {
            ResultSet rs = bc.getAllBan();
            DefaultTableModel model = new DefaultTableModel(new String[]{"Mã bàn", "Tên Bàn", "Trạng Thái"}, 0);

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("MABAN"), rs.getString("TENBAN"), rs.getString("TRANGTHAI")});
            }
            jTable1.setModel(model); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
<<<<<<< HEAD
<<<<<<< HEAD
        jLabel2 = new javax.swing.JLabel();
<<<<<<< HEAD
        BtnDangxuat = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
=======
        jLabel3 = new javax.swing.JLabel();
>>>>>>> parent of 52a988d (up menu)
<<<<<<< HEAD
=======
        jLabel3 = new javax.swing.JLabel();
>>>>>>> parent of 52a988d (up menu)
=======
        BtnDangxuat = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnTrangchu = new javax.swing.JButton();
        btnDatban = new javax.swing.JButton();
        btnDatmon = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        btnDoanthu = new javax.swing.JButton();
>>>>>>> parent of de04fe8 (up)
=======
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of d16e67b (up)
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnDatban = new javax.swing.JButton();
        BtnHuyban = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of d16e67b (up)
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
        btnTrangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangchuActionPerformed(evt);
            }
        });

        btnDatban.setText("Đặt bàn");
        btnDatban.setBorder(null);

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

        btnDoanthu.setText("Doanh thu");
        btnDoanthu.setBorder(null);
        btnDoanthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanthuActionPerformed(evt);
            }
        });
=======
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("heelo");
>>>>>>> parent of 52a988d (up menu)
=======
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("heelo");
>>>>>>> parent of 52a988d (up menu)

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of d16e67b (up)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(BtnDangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addComponent(btnTrangchu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDoanthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
<<<<<<< HEAD
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
<<<<<<< HEAD
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
>>>>>>> parent of 52a988d (up menu)
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of d16e67b (up)
                .addGap(176, 176, 176)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 52a988d (up menu)
=======
=======
>>>>>>> parent of d16e67b (up)
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of de04fe8 (up)
=======
>>>>>>> parent of 52a988d (up menu)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(jLabel5)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of d16e67b (up)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addGap(53, 53, 53)
                .addComponent(btnTrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> parent of de04fe8 (up)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatban, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatmon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoanthu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnDangxuat)
                .addContainerGap())
=======
<<<<<<< HEAD
=======
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of d16e67b (up)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of 52a988d (up menu)
=======
=======
>>>>>>> parent of d16e67b (up)
>>>>>>> parent of 52a988d (up menu)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTable1);

        BtnDatban.setText("Đặt bàn");
        BtnDatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDatbanActionPerformed(evt);
            }
        });

        BtnHuyban.setText("Hủy bàn");
        BtnHuyban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHuybanActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Coffee");

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDatban)
                        .addGap(121, 121, 121)
                        .addComponent(BtnHuyban)
                        .addGap(161, 161, 161))))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHuyban)
                    .addComponent(BtnDatban))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        closeMenu();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        openMenu();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void BtnHuybanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHuybanActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            String maBan = jTable1.getValueAt(selectedRow, 0).toString(); 
            String newStatus = "Trống"; 
            boolean success = bc.updateBanStatus(maBan, newStatus);
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this, "Đặt hủy thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi hủy bàn!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bàn để hủy!");
        }
    }//GEN-LAST:event_BtnHuybanActionPerformed

    private void BtnDatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDatbanActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            String maBan = jTable1.getValueAt(selectedRow, 0).toString(); 
            String newStatus = "Đã đặt"; 
            boolean success = bc.updateBanStatus(maBan, newStatus);
            if (success) {
                loadDataToTable();
                JOptionPane.showMessageDialog(this, "Đặt bàn thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi đặt bàn!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bàn để đặt!");
        }
    }//GEN-LAST:event_BtnDatbanActionPerformed

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of d16e67b (up)
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

<<<<<<< HEAD
=======
    /**
     * @param args the command line arguments
     */
>>>>>>> parent of 52a988d (up menu)
<<<<<<< HEAD
=======
    /**
     * @param args the command line arguments
     */
>>>>>>> parent of 52a988d (up menu)
=======
    private void btnDatmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatmonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatmonActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void btnDoanthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoanthuActionPerformed

    private void btnTrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangchuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangchuActionPerformed

>>>>>>> parent of de04fe8 (up)
=======
    /**
     * @param args the command line arguments
     */
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of d16e67b (up)
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
            java.util.logging.Logger.getLogger(Datban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datban().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDatban;
    private javax.swing.JButton BtnHuyban;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private javax.swing.JButton btnDatban;
    private javax.swing.JButton btnDatmon;
    private javax.swing.JButton btnDoanthu;
>>>>>>> parent of de04fe8 (up)
=======
>>>>>>> parent of d16e67b (up)
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnTrangchu;
    private javax.swing.JLabel jLabel1;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel2;
=======
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
>>>>>>> parent of 52a988d (up menu)
<<<<<<< HEAD
=======
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of de04fe8 (up)
=======
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
>>>>>>> parent of 52a988d (up menu)
=======
>>>>>>> parent of d16e67b (up)
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMenu;
    // End of variables declaration//GEN-END:variables

}
