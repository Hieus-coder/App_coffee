package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bancontroller {
    private Connection conn;
    
    public bancontroller(Connection conn) {
        this.conn = conn;
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

    public boolean updateBanStatus(String maBan, String trangThai) {
        try {
            String sql = "UPDATE BAN SET TRANGTHAI = ? WHERE MABAN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trangThai);
            pstmt.setString(2, maBan);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; // Trả về false nếu có lỗi
        }
    }
}
