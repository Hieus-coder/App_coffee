package controller;

import model.quanlymodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NhansuController {
    private Connection conn;

    public NhansuController(Connection conn) {
        this.conn = conn;
    }

    // Method to retrieve all employees
    public ResultSet getAll() {
        try {
            String sql = "SELECT * FROM NHAN_SU"; // Thay bằng tên bảng thực tế của bạn
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery(); // Trả về ResultSet
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Method to retrieve an employee by ID
    public quanlymodel getEmployeeById(int id) {
        quanlymodel employee = null;
        try {
            String sql = "SELECT * FROM NHAN_SU WHERE ID = ?"; // Sửa tên bảng cho đúng
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = new quanlymodel(
                    rs.getInt("ID"),
                    rs.getString("HO_VA_TEN"),
                    rs.getString("GIOI_TINH"),
                    rs.getInt("NAM_SINH"),
                    rs.getString("CHUC_VU"),
                    rs.getString("QUE_QUAN"),
                    rs.getString("SO_DIEN_THOAI")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    // Method to update employee details
    public boolean updateEmployee(quanlymodel employee) {
        try {
            String sql = "UPDATE NHAN_SU SET,ID = ?, HO_VA_TEN = ?, GIOI_TINH = ?, NAM_SINH = ?, CHUC_VU = ?, QUE_QUAN = ?, SO_DIEN_THOAI = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employee.getHO_VA_TEN());
            pstmt.setString(2, employee.getGIOI_TINH());
            pstmt.setInt(3, employee.getNAM_SINH());
            pstmt.setString(4, employee.getCHUC_VU());
            pstmt.setString(5, employee.getQUE_QUAN());
            pstmt.setString(6, employee.getSO_DIEN_THOAI());
            pstmt.setInt(7, employee.getid());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; 
        }
    }

    // Method to add a new employee
    public boolean addEmployee(quanlymodel employee) {
        try {
            String sql = "INSERT INTO NHAN_SU (HO_VA_TEN, GIOI_TINH, NAM_SINH, CHUC_VU, QUE_QUAN, SO_DIEN_THOAI) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employee.getHO_VA_TEN());
            pstmt.setString(2, employee.getGIOI_TINH());
            pstmt.setInt(3, employee.getNAM_SINH());
            pstmt.setString(4, employee.getCHUC_VU());
            pstmt.setString(5, employee.getQUE_QUAN());
            pstmt.setString(6, employee.getSO_DIEN_THOAI());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; 
        }
    }

    public int getMaxId() throws SQLException {
        String query = "SELECT MAX(ID) FROM NHAN_SU";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    // Method to delete an employee by ID
    public boolean deleteEmployee(int id) {
        try {
            String sql = "DELETE FROM NHAN_SU WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; 
        }
    }
}
