/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.accountcontroller;
import controller.bancontroller;
import controller.doanhthucontroller;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hieus
 */
public class Doanhthu extends javax.swing.JFrame {

    /**
     * Creates new form Doanhthu
     */
    private boolean admin;
    private doanhthucontroller Dt;
    private bancontroller ban;

    public Doanhthu(boolean isAdmin) {
        this.admin = isAdmin;
        if (!Dangnhap.isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước!");
            this.dispose();
            new Dangnhap().setVisible(true);
            return;
        }
        initComponents();
        setTitle("Coffee");
        Dt = new doanhthucontroller();
        btnNhanVien.setVisible(admin);
        btnDouong.setVisible(admin);
        ban = new bancontroller();
        displayLoggedInUser();
        loadDataToTable();

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
        try {
            ResultSet rs = Dt.getHoadon();
            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"ID", "NGAY", "GIO", "TONGCHIPHI", "TONGTIEN"}, 0
            );

            // Biến để tính tổng
            float totalChiphi = 0;
            float totalTien = 0;
            float lai = Dt.getLai();
            int count = Dt.getCount();
            // Duyệt qua các hàng và thêm vào bảng
            while (rs.next()) {
                float chiphi = rs.getFloat("TONGCHIPHI");
                float tien = rs.getFloat("TONGTIEN");

                totalChiphi += chiphi;
                totalTien += tien;

                model.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getDate("NGAY"),
                    rs.getTime("GIO"),
                    chiphi,
                    tien
                });
            }

            jTable1.setModel(model);

            txtSodon.setText("" + count);
            txtChiphi.setText("" + totalChiphi);
            txtLai.setText("" + lai);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportTableToExcel(JTable table, String filePath) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Doanh Thu");

            TableModel model = table.getModel();

            // Tạo tiêu đề cột
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(model.getColumnName(col));
            }

            // Thêm dữ liệu từ JTable vào file Excel
            for (int row = 0; row < model.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = excelRow.createCell(col);

                    // Kiểm tra kiểu dữ liệu và gán giá trị
                    Object value = model.getValueAt(row, col);
                    if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Float || value instanceof Double) {
                        cell.setCellValue(Double.parseDouble(value.toString()));
                    } else if (value instanceof java.util.Date) {
                        cell.setCellValue(value.toString());
                    } else {
                        cell.setCellValue(value != null ? value.toString() : "");
                    }
                }
            }

            // Ghi dữ liệu ra file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();
            System.out.println("Xuất file Excel thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xuất file Excel.");
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
        label1 = new java.awt.Label();
        txtSodon = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        txtChiphi = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        txtLai = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnXuatfile = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(202, 174, 136));

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

        btnDoanthu.setBackground(new java.awt.Color(202, 174, 136));
        btnDoanthu.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnDoanthu.setForeground(new java.awt.Color(146, 73, 0));
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

        btnDouong.setBackground(new java.awt.Color(74, 48, 34));
        btnDouong.setForeground(new java.awt.Color(255, 255, 255));
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
            .addComponent(btnDatmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDouong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnDoanthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel1.setBackground(new java.awt.Color(146, 73, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 100));

        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Số đơn");

        txtSodon.setAlignment(java.awt.Label.CENTER);
        txtSodon.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        txtSodon.setForeground(new java.awt.Color(255, 255, 255));
        txtSodon.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(46, Short.MAX_VALUE)
                    .addComponent(txtSodon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(txtSodon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)))
        );

        jPanel2.setBackground(new java.awt.Color(136, 100, 81));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 100));

        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Chi phí");

        txtChiphi.setAlignment(java.awt.Label.CENTER);
        txtChiphi.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        txtChiphi.setForeground(new java.awt.Color(255, 255, 255));
        txtChiphi.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(77, Short.MAX_VALUE)
                    .addComponent(txtChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(57, 57, 57)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(txtChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel3.setBackground(new java.awt.Color(202, 174, 136));

        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Lãi thu");

        txtLai.setAlignment(java.awt.Label.CENTER);
        txtLai.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        txtLai.setForeground(new java.awt.Color(255, 255, 255));
        txtLai.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(txtLai, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
        jScrollPane1.setViewportView(jTable1);

        btnXuatfile.setLabel("Xuất file");
        btnXuatfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXuatfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(btnXuatfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
        QuanLy ql = new QuanLy(admin);
        ql.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNhanVienActionPerformed

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

    private void btnDatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatbanActionPerformed
        // TODO add your handling code here:
        Datban db = new Datban(admin);
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDatbanActionPerformed

    private void btnXuatfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatfileActionPerformed
        // TODO add your handling code here:
        // Sử dụng JFileChooser để chọn nơi lưu file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            // Đảm bảo file có phần mở rộng .xlsx
            if (!filePath.endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            // Gọi hàm xuất file Excel
            exportTableToExcel(jTable1, filePath);

            // Thông báo sau khi xuất file thành công
            JOptionPane.showMessageDialog(this, "Xuất file Excel thành công tại: " + filePath);
        }
    }//GEN-LAST:event_btnXuatfileActionPerformed

    private void btnDouongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDouongActionPerformed
        // TODO add your handling code here:
        QlyDouong form = new QlyDouong(admin);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDouongActionPerformed

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
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doanhthu(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDangxuat;
    private javax.swing.JButton btnDatban;
    private javax.swing.JButton btnDatmon;
    private javax.swing.JButton btnDoanthu;
    private javax.swing.JButton btnDouong;
    private javax.swing.JButton btnNhanVien;
    private java.awt.Button btnXuatfile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JPanel pnMenu;
    private java.awt.Label txtChiphi;
    private java.awt.Label txtLai;
    private java.awt.Label txtSodon;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
