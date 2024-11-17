/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBC.Dbconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Object[]> Danhsachdouongdagoi(int banId) {
        List<Object[]> danhSachDoUong = new ArrayList<>();

        String sql = "d.MADOUONG, d.TENDOUONG FROM DOUONG d JOIN ORDER_ od ON d.MADOUONG = od.MADOUONG WHERE od.MABAN = ?";

        // Check if the connection is not null
        if (conn == null) {
            System.err.println("Database connection is null.");
            return danhSachDoUong; // Return empty list if the connection is invalid
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set the parameter for the table ID (banId)
            stmt.setInt(1, banId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Retrieve the values from the result set
                    String ma = rs.getString("MADOUONG");
                    String ten = rs.getString("TENDOUONG");

                    // Add the values to the list
                    danhSachDoUong.add(new Object[]{ma, ten});
                }
            }
        } catch (SQLException e) {
            // Log the exception or rethrow it depending on your needs
            e.printStackTrace();
        }

        // Return the list of ordered drinks for the given table
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
    public boolean ThemDouong(String maban, String madouong, String tendouong, float chiphi, float gia) {
        try {
            String sql = "INSERT INTO ORDER_ (MABAN, MADOUONG, TENDOUONG, SOLUONG, TONG) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maban);
            pstmt.setString(2, madouong);
            pstmt.setString(3, tendouong);
            pstmt.setInt(4, soLuong);
            pstmt.setFloat(5, tong);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
}
