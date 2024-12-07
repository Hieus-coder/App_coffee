/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBC.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Douong;

/**
 *
 * @author Hieus
 */
public class douongcontroller {

    private Connection conn;

    public douongcontroller() {
        conn = Dbconnection.getInstance().getConnection();
    }

    //Thêm
    public boolean insert(Douong douong) {
        String query = "INSERT INTO DOUONG (MADOUONG, TENDOUONG, GIA, CHIPHI) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, douong.getMaDouong());
            stmt.setString(2, douong.getTenDouong());
            stmt.setDouble(3, douong.getGia());
            stmt.setDouble(4, douong.getChiphi());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
            return false;
        }
    }
     // Sửa
    public boolean update(Douong douong) {
        String query = "UPDATE DOUONG SET TENDOUONG = ?, GIA = ?, CHIPHI = ? WHERE MADOUONG = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, douong.getTenDouong());
            stmt.setDouble(2, douong.getGia());
            stmt.setDouble(3, douong.getChiphi());
            stmt.setString(4, douong.getMaDouong());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
            return false;
        }
    }
     // Xóa
    public boolean delete(String maDouong) {
        String query = "DELETE FROM DOUONG WHERE MADOUONG = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maDouong);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
            return false;
        }
    }   
    // Lấy tất cả đồ uống
    public List<Douong> getAllDouong() {
        List<Douong> douongs = new ArrayList<>();
        String query = "SELECT * FROM DOUONG";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Douong douong = new Douong();
                douong.setMaDouong(rs.getString("MaDouong"));
                douong.setTenDouong(rs.getString("TenDouong"));
                douong.setGia(rs.getDouble("Gia"));
                douong.setChiphi(rs.getDouble("Chiphi"));

                douongs.add(douong);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
        return douongs;
    }

    // Kiểm tra sự tồn tại của đồ uống
    public boolean isDouongExists(String maDouong) {
        String query = "SELECT COUNT(*) FROM DOUONG WHERE MADOUONG = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maDouong);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi khi kiểm tra món: " + ex.getMessage());
        }
        return false;
    }
    // Phương thức tìm kiếm đồ uống theo tên
    public List<Douong> searchDouongByName(String tenDouong) {
        List<Douong> douongs = new ArrayList<>();
        String query = "SELECT * FROM DOUONG WHERE TENDOUONG LIKE ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + tenDouong + "%"); // Thêm ký tự % để tìm kiếm gần đúng

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Douong douong = new Douong();
                douong.setMaDouong(rs.getString("MaDouong"));
                douong.setTenDouong(rs.getString("TenDouong"));
                douong.setGia(rs.getDouble("Gia"));
                douong.setChiphi(rs.getDouble("Chiphi"));
                douongs.add(douong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return douongs;
    }
}
