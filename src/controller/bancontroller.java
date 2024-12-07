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

    public boolean isAnyBanDaDat() {
        String sql = "SELECT COUNT(*) AS SoLuong FROM BAN WHERE TRANGTHAI = N'Đã đặt'";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("SoLuong") > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTrangThai(String maBan) {
        String sql = "SELECT TRANGTHAI FROM BAN WHERE MABAN = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maBan);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("TRANGTHAI");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public boolean datBan(String maBan) {
        return updateBanStatus(maBan, "Đã đặt");
    }

    public boolean updateBanStatus(String maBan, String trangThai) {
        if (!"Trống".equals(trangThai) && !"Đã đặt".equals(trangThai)) {
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

    public String getID(String tenBan) {
        String sql = "SELECT MABAN FROM BAN WHERE TENBAN = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tenBan);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("MABAN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteOrdersByBan(String maBan) {
        String sql = "DELETE FROM [ORDER_] WHERE MABAN = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maBan);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có dòng bị xóa
        } catch (SQLException ex) {
            System.out.println("Lỗi khi xóa order: " + ex.getMessage());
            return false;
        }
    }

}
