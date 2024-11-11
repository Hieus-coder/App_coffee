package controller;

import java.sql.*;
import DBC.Dbconnection;

public class accountcontroller {

    private Connection conn;
    private nhansucontroller nhanvien;

    public accountcontroller() {
        conn = Dbconnection.getInstance().getConnection();
    }

    public boolean checkUserCredentials(String TAIKHOAN, String MATKHAU) {
        try {
            String sql = "SELECT * FROM ACCOUNT WHERE TAIKHOAN = ? AND MATKHAU = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, TAIKHOAN);
            pre.setString(2, MATKHAU);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean checkAccountExists(String taikhoan) {
        try {
            // Truy vấn kiểm tra tài khoản đã tồn tại
            String sql = "SELECT COUNT(*) FROM ACCOUNT WHERE TAIKHOAN = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, taikhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  // Nếu có ít nhất 1 tài khoản trùng
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addAccount(String taikhoan, String matkhau, int idNhansu) {
        PreparedStatement pstmt = null;
        try {
            // Chèn tài khoản vào bảng ACCOUNT
            String sql = "INSERT INTO ACCOUNT(TAIKHOAN, MATKHAU, ID_NHAN_SU) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, taikhoan);
            pstmt.setString(2, matkhau);
            pstmt.setInt(3, idNhansu);

            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAdmin(String TAIKHOAN) {
        return "admin".equals(TAIKHOAN);
    }
}
