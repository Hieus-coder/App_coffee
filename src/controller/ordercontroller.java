/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBC.Dbconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieus
 */
public class ordercontroller {

    private Connection conn;

    public ordercontroller() {
        this.conn = Dbconnection.getInstance().getConnection();
    }

    public List<Object[]> Danhsachdouong() {
        List<Object[]> danhSachDoUong = new ArrayList<>();
        String sql = "SELECT TENDOUONG, GIA FROM DOUONG";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String ten = rs.getNString("TENDOUONG");
                double gia = rs.getDouble("GIA");
                danhSachDoUong.add(new Object[]{ten, gia});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachDoUong;
    }

    public String Madouong(String ten) {
        String maDoUong = null;
        try {
            String sql = "SELECT MADOUONG FROM DOUONG WHERE TENDOUONG = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ten);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                maDoUong = rs.getString("MADOUONG");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maDoUong;
    }

    public List<Object[]> Danhsachdouongdagoi(String maban) {
        List<Object[]> danhSachDoUong = new ArrayList<>();
        String sql = "SELECT MADOUONG, TENDOUONG, SOLUONG, GIA FROM ORDER_ WHERE MABAN = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maban); // Thiết lập mã bàn
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String madouong = rs.getString("MADOUONG");
                    String tendouong = rs.getString("TENDOUONG");
                    int soluong = rs.getInt("SOLUONG");
                    double gia = rs.getDouble("GIA");
                    danhSachDoUong.add(new Object[]{madouong, tendouong, soluong, gia});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachDoUong;
    }

    public List<Object[]> getDanhSachMonCuaBan(String maBan) {
        List<Object[]> danhSachMon = new ArrayList<>();
        String query = "SELECT MADOUONG, TENDOUONG, SOLUONG, GIA * SOLUONG AS TONGTIEN FROM ORDER_ WHERE MABAN = ?";
        if (!setGia()) {
            System.out.println("Cập nhật giá thất bại, tiếp tục lấy danh sách món...");
        }
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maBan);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maDouong = rs.getString("MADOUONG");
                String tenDouong = rs.getString("TENDOUONG");
                int soLuong = rs.getInt("SOLUONG");
                double tongTien = rs.getDouble("TONGTIEN");

                // Thêm dữ liệu vào danh sách dưới dạng mảng Object[]
                danhSachMon.add(new Object[]{maDouong, tenDouong, soLuong, tongTien});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSachMon;
    }

    public List<Object[]> getDataFromDatabaseForTable(String maBan) {
        List<Object[]> douongs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDER_ WHERE MABAN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maBan);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Sửa lỗi trong dòng này để khởi tạo mảng đúng cách
                Object[] douong = new Object[]{
                    rs.getString("MaDouong"),
                    rs.getString("TenDouong"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("Tong")
                };
                douongs.add(douong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return douongs;
    }

    public DefaultTableModel displayOrderForTable(String maBan) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã đồ uống", "Tên đồ uống", "Số lượng", "Tổng tiền"}, 0);

        String sql = "SELECT * FROM ORDER_ WHERE MABAN = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maBan);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("MADOUONG"),
                        rs.getString("TENDOUONG"),
                        rs.getInt("SOLUONG"),
                        rs.getDouble("TONGTIEN")
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    private boolean setGia() {
        String query = "UPDATE o "
                + "SET o.GIA = d.GIA "
                + "FROM ORDER_ o "
                + "INNER JOIN DOUONG d ON o.MADOUONG = d.MADOUONG";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Thực thi câu lệnh UPDATE
            int rowsUpdated = stmt.executeUpdate();

            // Kiểm tra xem có hàng nào được cập nhật không
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật giá thành công: " + rowsUpdated + " hàng.");
                return true;
            } else {
                System.out.println("Không có hàng nào cần cập nhật.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getDrinkName(String maDouong) {
        String tenDouong = "";
        String sql = "SELECT TENDOUONG FROM DOUONG WHERE MADOUONG = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maDouong);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tenDouong = rs.getString("TENDOUONG");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenDouong;
    }

    public boolean addDrinkToTable(String maBan, String maDouong, String tendouong, int soLuong, double gia, double chiphi) {
        double tongTien = soLuong * gia;

        // Kiểm tra nếu món đồ uống đã có trong bảng ORDER_ của bàn chưa
        String sqlCheck = "SELECT SOLUONG, TONGTIEN FROM ORDER_ WHERE MABAN = ? AND MADOUONG = ?";
        try (PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck)) {
            stmtCheck.setString(1, maBan);
            stmtCheck.setString(2, maDouong);

            ResultSet rs = stmtCheck.executeQuery();
            if (rs.next()) {
                // Món đã tồn tại, cập nhật số lượng và tổng tiền
                int currentQuantity = rs.getInt("SOLUONG");
                double currentTotal = rs.getDouble("TONGTIEN");

                int newQuantity = currentQuantity + soLuong;  // Cập nhật số lượng
                double newTotal = currentTotal + tongTien;    // Cập nhật tổng tiền

                // Cập nhật vào cơ sở dữ liệu
                String sqlUpdate = "UPDATE ORDER_ SET SOLUONG = ?, TONGTIEN = ? WHERE MABAN = ? AND MADOUONG = ?";
                try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                    stmtUpdate.setInt(1, newQuantity);
                    stmtUpdate.setDouble(2, newTotal);
                    stmtUpdate.setString(3, maBan);
                    stmtUpdate.setString(4, maDouong);
                    stmtUpdate.executeUpdate();
                }
            } else {
                // Món chưa có trong bảng, thêm mới
                String sqlInsert = "INSERT INTO ORDER_ (MABAN, MADOUONG, TENDOUONG, SOLUONG, TONGTIEN, CHIPHI) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                    stmtInsert.setString(1, maBan);
                    stmtInsert.setString(2, maDouong);
                    stmtInsert.setString(3, tendouong);
                    stmtInsert.setInt(4, soLuong);
                    stmtInsert.setDouble(5, tongTien);
                    stmtInsert.setDouble(6, chiphi);
                    stmtInsert.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm hoặc cập nhật món đồ uống: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public double tongtienban(String maban) {
        double totalAmount = 0;  // Khai báo biến totalAmount và gán giá trị mặc định là 0

        // Truy vấn SQL để tính tổng tiền
        String sql = "SELECT SUM(SOLUONG * GIA) AS TotalAmount FROM ORDER_ WHERE MABAN = ?";

        // Kết nối cơ sở dữ liệu
        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, maban);  // Gán giá trị cho tham số maban

            // Thực thi truy vấn và lấy kết quả
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                totalAmount = rs.getDouble("TotalAmount");  // Lấy giá trị tổng tiền
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalAmount;  // Trả về tổng tiền
    }

    public boolean deleteFromDatabase(String maBan, String maDoUong) {
        String sql = "DELETE FROM ORDER_ WHERE MABAN = ? AND MADOUONG = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            // Đặt tham số vào câu lệnh SQL
            pst.setString(1, maBan);
            pst.setString(2, maDoUong);

            // Thực thi câu lệnh xóa
            int rowsAffected = pst.executeUpdate();

            // Kiểm tra số dòng bị ảnh hưởng (xóa thành công sẽ trả về > 0 dòng)
            if (rowsAffected > 0) {
                System.out.println("Dữ liệu đã được xóa thành công.");
            } else {
                System.out.println("Không có dữ liệu nào được xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();  // In lỗi ra console nếu có lỗi

        }
        return false;
    }

    public boolean insertDoanhThu(double tongChiPhi, double tongTien) {
        try {
            String insertDoanhThuSql = "INSERT INTO DOANHTHU (TONGCHIPHI, TONGTIEN) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertDoanhThuSql);
            ps.setDouble(1, tongChiPhi);
            ps.setDouble(2, tongTien);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public double getChiPhi(String maDoUong) {
        double chiPhi = 0;
        String query = "SELECT CHIPHI FROM DOUONG WHERE MADOUONG = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maDoUong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                chiPhi = rs.getDouble("CHIPHI");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiPhi;
    }

    public boolean deleteAfterSucess(String maban) {
        String deleteSql = "DELETE FROM ORDER_ WHERE MABAN = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {

            pstmt.setString(1, maban);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu xóa thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Trả về false nếu lỗi
        }
    }

}
