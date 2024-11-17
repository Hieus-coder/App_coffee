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
                float gia = rs.getFloat("GIA");
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
                    float gia = rs.getFloat("GIA");
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

    public void addDouongToTable(String maDouong, String tenDouong, int soLuong, double tongTien, String maBan) {
        String sql = "INSERT INTO TableMondagoi (MaDouong, TenDouong, SoLuong, Tong, MaBan) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maDouong);
            stmt.setString(2, tenDouong);
            stmt.setInt(3, soLuong);
            stmt.setDouble(4, tongTien);
            stmt.setString(5, maBan); // Giả sử 'maBan' là mã bàn hiện tại

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addDrinkToTable(String maBan, String maDouong, int soLuong, double gia) {
        double tongTien = soLuong * gia;

        // Kiểm tra nếu món đồ uống đã có trong bảng ORDER_ của bàn chưa
        String sqlCheck = "SELECT * FROM ORDER_ WHERE MABAN = ? AND MADOUONG = ?";
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
                String sqlInsert = "INSERT INTO ORDER_ (MABAN, MADOUONG, TENDOUONG, SOLUONG, TONGTIEN) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                    stmtInsert.setString(1, maBan);
                    stmtInsert.setString(2, maDouong);
                    stmtInsert.setString(3, getDrinkName(maDouong));  // Lấy tên đồ uống từ cơ sở dữ liệu
                    stmtInsert.setInt(4, soLuong);
                    stmtInsert.setDouble(5, tongTien);
                    stmtInsert.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getIDDouong(String ten) {
        String maDoUong = null;
        String sql = "SELECT MADOUONG FROM DOUONG WHERE TENDOUONG = ?";
        try (Connection conn = Dbconnection.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

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

    public void addDrinkToTable(String maBan, String maDouong, int soLuong, float gia, float chiPhi, String tenDouong) {
        // Tính tổng tiền cho món uống
        float tongTien = soLuong * gia;

        // Kiểm tra xem món đã có trong bảng ORDER_ hay chưa
        String sqlCheck = "SELECT * FROM ORDER_ WHERE MABAN = ? AND MADOUONG = ?";
        PreparedStatement stmtCheck = null;
        ResultSet rs = null;

        try {
            stmtCheck = conn.prepareStatement(sqlCheck);
            stmtCheck.setString(1, maBan);
            stmtCheck.setString(2, maDouong);
            rs = stmtCheck.executeQuery();

            if (rs.next()) {
                // Nếu món đã có, cập nhật số lượng và tổng tiền
                int currentQuantity = rs.getInt("SOLUONG");
                float currentTotal = rs.getFloat("TONGTIEN");

                // Tính số lượng mới và tổng tiền mới
                int newQuantity = currentQuantity + soLuong;
                float newTotal = currentTotal + tongTien;

                // Cập nhật vào bảng ORDER_
                String sqlUpdate = "UPDATE ORDER_ SET SOLUONG = ?, TONGTIEN = ?, CHIPHI = ? WHERE MABAN = ? AND MADOUONG = ?";
                try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                    stmtUpdate.setInt(1, newQuantity);
                    stmtUpdate.setFloat(2, newTotal);
                    stmtUpdate.setFloat(3, chiPhi);  // Cập nhật chi phí
                    stmtUpdate.setString(4, maBan);
                    stmtUpdate.setString(5, maDouong);
                    stmtUpdate.executeUpdate();
                }
            } else {
                // Nếu món chưa có trong bảng ORDER_, thêm mới
                String sqlInsert = "INSERT INTO ORDER_ (MABAN, MADOUONG, CHIPHI, GIA, TENDOUONG, SOLUONG, TONGTIEN) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                    stmtInsert.setString(1, maBan);
                    stmtInsert.setString(2, maDouong);
                    stmtInsert.setFloat(3, chiPhi);  // Thêm chi phí vào cơ sở dữ liệu
                    stmtInsert.setFloat(4, gia);  // Thêm giá vào cơ sở dữ liệu
                    stmtInsert.setString(5, tenDouong);  // Thêm tên đồ uống vào cơ sở dữ liệu
                    stmtInsert.setInt(6, soLuong);
                    stmtInsert.setFloat(7, tongTien);  // Thêm tổng tiền vào cơ sở dữ liệu
                    stmtInsert.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng ResultSet và PreparedStatement trong block finally để tránh rò rỉ kết nối
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmtCheck != null) {
                    stmtCheck.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
