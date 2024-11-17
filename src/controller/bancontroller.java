package controller;

import DBC.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class bancontroller {

    private Connection conn;

    public bancontroller() {
        conn = Dbconnection.getInstance().getConnection();
    }

    public ResultSet getAllBan() {
        try {
            String sql = "SELECT * FROM BAN";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // Thêm danh sách trạng thái của từng bàn

    public boolean[] Trangthai() {
        boolean[] trangThaiBans = new boolean[6]; // Giả sử có 6 bàn
        try {
            String sql = "SELECT MABAN, TRANGTHAI FROM BAN";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int index = 0; // Dùng để lưu trạng thái cho từng bàn
            while (rs.next()) {
                String maBan = rs.getString("MABAN");
                String trangthai = rs.getString("TRANGTHAI");
                // Kiểm tra trạng thái của bàn và lưu vào mảng
                if ("Trống".equals(trangthai)) {
                    trangThaiBans[index] = true; // Bàn trống
                } else {
                    trangThaiBans[index] = false; // Bàn không trống
                }
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console để gỡ lỗi
        }

        return trangThaiBans;
    }

    public boolean updateBanStatus(String maBan, String trangThai) {
        try {
            String sql = "UPDATE BAN SET TRANGTHAI = ? WHERE MABAN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trangThai);
            pstmt.setString(2, maBan);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
