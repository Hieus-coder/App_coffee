/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.bancontroller;
import controller.ordercontroller;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leduc
 */
public class ThanhToan extends javax.swing.JFrame {

    /**
     * Creates new form ThanhToan
     */
    private boolean admin;

    private ordercontroller order;
    private bancontroller ban;
    private Goimon gm;
    private String maban = "";

    public ThanhToan(boolean IsAdmin) {
        this.admin = IsAdmin;
        if (!Dangnhap.isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước!");
            new Dangnhap().setVisible(true);
            this.dispose();
            return;
        }
        initComponents();
        setTitle("Coffee");
        order = new ordercontroller();
        ban = new bancontroller();
        loadData();
    }

    public ThanhToan(String admin) {
        initComponents(); // Gọi hàm khởi tạo giao diện
    }

    // Setter để nhận tên bàn
    public void setTenBan(String tenBan) {
        lbTen.setText(tenBan); // txtTenBan là JTextField hoặc JLabel
    }

    // Setter để nhận ngày đặt
    public void setNgayDat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lbNgaygio.setText(sdf.format(new java.util.Date())); // Hiển thị ngày giờ hiện tại
    }

    // Setter để nhận danh sách món
    public void setDanhSachMon(List<String[]> danhSachMon) {
        DefaultTableModel model = (DefaultTableModel) TabledsMoncuaban.getModel();
        model.setRowCount(0); // Xóa các dòng cũ trong bảng (nếu có)
        for (String[] mon : danhSachMon) {
            model.addRow(mon); // Thêm từng dòng vào bảng
        }
    }

    private void loadData() {
        // Cập nhật tên bàn
        lbTen.setText(ban.getTenBan(maban));

        // Cập nhật ngày giờ hiện tại
        lbNgaygio.setText(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // Lấy danh sách đồ uống từ phương thức Danhsachdouongdagoi của đối tượng order
        List<Object[]> danhSachDoUong = order.Danhsachdouongdagoi(maban);

        // Lấy DefaultTableModel hiện tại của TabledsMoncuaban
        DefaultTableModel model = (DefaultTableModel) TabledsMoncuaban.getModel();

        // Thiết lập tiêu đề cột cho bảng
        String[] columnNames = {"Mã món", "Tên món", "Số lượng", "Giá"};
        model.setColumnIdentifiers(columnNames);

        // Lặp qua danh sách và thêm từng dòng vào bảng
        for (Object[] row : danhSachDoUong) {
            model.addRow(row);  // Thêm dòng mới vào bảng
        }
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabledsMoncuaban = new javax.swing.JTable();
        lbTongtien = new javax.swing.JLabel();
        btnThanhtoan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbNgaygio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");
        jPanel3.add(jLabel1);

        jLabel4.setText("Tên bàn:");

        TabledsMoncuaban.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabledsMoncuaban);

        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày đặt:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DANH SÁCH MÓN ĐÃ GỌI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(544, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNgaygio, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnThanhtoan)))
                        .addGap(17, 17, 17))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(248, 248, 248))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNgaygio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhtoan)
                .addGap(0, 0, 0)
                .addComponent(lbTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        try {
            // Tính tổng chi phí từ jTableHoaDon
            DefaultTableModel model = (DefaultTableModel) TabledsMoncuaban.getModel();
            double tongChiPhi = 0, tongTien = 0;
            String maBan = order.Madouong(lbTen.getText()); // Lấy mã bàn từ giao diện
            System.out.println(lbTen.getText());
            for (int i = 0; i < model.getRowCount(); i++) {
                double gia = Double.parseDouble(model.getValueAt(i, 3).toString());
                int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
                tongTien += gia * soLuong;
            }

            // Tổng tiền (có thể bổ sung thêm logic VAT/khuyến mãi nếu cần)
            // Gọi phương thức lưu vào DOANHTHU
            boolean insertSuccess = order.insertDoanhThu(tongChiPhi, tongTien);
            // Gọi phương thức xóa dữ liệu trong ORDER_ theo MABAN

            boolean deleteSuccess = order.deleteAfterSucess(lbTen.getText());
            if (deleteSuccess) {
                JOptionPane.showMessageDialog(this, "Dữ liệu bàn đã được xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy bàn để xóa!");
            }
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Thanh toán thành công! Dữ liệu đã được lưu vào doanh thu và bàn đã được xóa.");

            // Xóa dữ liệu trên form
            model.setRowCount(0); // Xóa dữ liệu trong bảng
            lbTen.setText(""); // Xóa tên bàn
            lbNgaygio.setText(""); // Xóa ngày đặt
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thanh toán: " + e.getMessage());
        }

    }//GEN-LAST:event_btnThanhtoanActionPerformed

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
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhToan(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabledsMoncuaban;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNgaygio;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbTongtien;
    // End of variables declaration//GEN-END:variables
}
