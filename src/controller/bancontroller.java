package controller;

import DBC.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
