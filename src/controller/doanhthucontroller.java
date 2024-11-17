/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBC.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hieus
 */
public class doanhthucontroller {

    private Connection conn;

    public doanhthucontroller() {
        conn = Dbconnection.getInstance().getConnection();
    }

    public ResultSet getHoadon() {
        try {
            // Truy vấn để lấy tất cả dữ liệu từ bảng DOANHTHU
            String sql = "SELECT ID, NGAY, GIO, TONGCHIPHI, TONGTIEN FROM DOANHTHU";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery(); // Trả về ResultSet chứa dữ liệu
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public int getCount() {
        try {
            // Truy vấn để đếm số lượng đơn trong bảng DOANHTHU
            String sql = "SELECT COUNT(*) FROM DOANHTHU";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);  // Trả về số lượng đơn
            }
            return 0;  // Nếu không có dữ liệu, trả về 0
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;  // Nếu có lỗi, trả về 0
        }
    }

    public float getLai() {
        try {
            String sql = "SELECT SUM(TONGTIEN) AS TotalTien, SUM(TONGCHIPHI) AS TotalChiPhi FROM DOANHTHU";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                float totalTien = rs.getFloat("TotalTien");
                float totalChiPhi = rs.getFloat("TotalChiPhi");
                return totalTien - totalChiPhi; // Tính lãi
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
