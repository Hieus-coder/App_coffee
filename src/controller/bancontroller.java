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

    public boolean[] Trangthai() {
        boolean[] trangThaiBans = new boolean[6];
        try {
            String sql = "SELECT MABAN, TRANGTHAI FROM BAN";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int index = 0;
            while (rs.next()) {
                String maBan = rs.getString("MABAN");
                String trangthai = rs.getString("TRANGTHAI");
                if ("Trống".equals(trangthai)) {
                    trangThaiBans[index] = true;
                } else {
                    trangThaiBans[index] = false;
                }
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trangThaiBans;
    }

    public boolean updateBanStatus(String maBan, String trangThai) {
        if (!"Trống".equals(trangThai) && !"Không trống".equals(trangThai)) {
            System.err.println("Giá trị trạng thái không hợp lệ: " + trangThai);
            return false;
        }
        try {
            String sql = "UPDATE BAN SET TRANGTHAI = ? WHERE MABAN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, trangThai);
            pstmt.setString(2, maBan);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String getTenBan(String id) {
        String tenBan = "";
        String sql = "SELECT TENBAN FROM BAN WHERE MABAN = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tenBan = rs.getString("TENBAN");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenBan;
    }
}
