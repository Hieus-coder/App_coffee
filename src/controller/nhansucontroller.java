package controller;

import DBC.Dbconnection;
import model.nhansumodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class nhansucontroller {

    private Connection conn;
    private accountcontroller account;

    public nhansucontroller() {
        conn = Dbconnection.getInstance().getConnection();
    }

    // Method to retrieve all employees
    public ResultSet getAll() {
        try {
            String sql = """
            SELECT NS.ID_NHAN_SU, NS.HO_VA_TEN, A.TAIKHOAN, A.MATKHAU, 
                   NS.NAM_SINH, NS.GIOI_TINH, A.CHUC_VU, NS.QUE_QUAN, NS.SO_DIEN_THOAI
            FROM NHAN_SU NS
            LEFT JOIN ACCOUNT A ON NS.ID_NHAN_SU = A.ID_NHAN_SU""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery(); // Trả về ResultSet chứa dữ liệu từ JOIN
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean checkEmployeeExists(int id_nhan_su) {
        String sql = "SELECT COUNT(*) FROM NHAN_SU WHERE ID_NHAN_SU = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nhan_su);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to retrieve an employee by ID
    public nhansumodel getEmployeeById(int id) {
        nhansumodel employee = null;
        try {
            String sql = "SELECT * FROM NHAN_SU WHERE ID = ?"; // Sửa tên bảng cho đúng
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = new nhansumodel(
                        rs.getInt("ID_NHAN_VIEN"),
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
    public boolean updateEmployee(nhansumodel employee) {
        try {
            String sql = "UPDATE NHAN_SU SET HO_VA_TEN = ?, GIOI_TINH = ?, NAM_SINH = ?, CHUC_VU = ?, QUE_QUAN = ?, SO_DIEN_THOAI = ? WHERE ID_NHAN_SU = ?";
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

    public int getIDNhanvien() {
        int idNV = -1;  // Giá trị mặc định nếu không tìm thấy ID_NHAN_SU
        String sql = "SELECT MAX(ID_NHAN_SU) FROM NHAN_SU";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                idNV = rs.getInt(1);  // Lấy giá trị MAX(ID_NHAN_SU) từ kết quả truy vấn
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idNV;
    }

    public boolean addEmployee(nhansumodel employee) {
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        try {
            // Chèn nhân viên vào bảng NHAN_SU
            String sql = "INSERT INTO NHAN_SU (HO_VA_TEN, GIOI_TINH, NAM_SINH, CHUC_VU, QUE_QUAN, SO_DIEN_THOAI) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, employee.getHO_VA_TEN());
            pstmt.setString(2, employee.getGIOI_TINH());
            pstmt.setInt(3, employee.getNAM_SINH());
            pstmt.setString(4, employee.getCHUC_VU());
            pstmt.setString(5, employee.getQUE_QUAN());
            pstmt.setString(6, employee.getSO_DIEN_THOAI());

            int rowAffected = pstmt.executeUpdate(); // Thực thi câu lệnh INSERT
            if (rowAffected > 0) {
                // Lấy ID của nhân viên vừa được thêm vào
                generatedKeys = pstmt.getGeneratedKeys();  // Đảm bảo gọi getGeneratedKeys sau executeUpdate
                if (generatedKeys.next()) {
                    int idNhansu = generatedKeys.getInt(1);  // Lấy ID của nhân viên

                    // Không chèn tài khoản mặc định vào bảng ACCOUNT nữa
                    return true; // Trả về true nếu nhân viên được thêm thành công
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Method to delete an employee by ID
    public boolean deleteEmployee(int id) {
        try {
            // Xóa bản ghi trong bảng ACCOUNT liên quan đến nhân viên
            String deleteAccountSql = "DELETE FROM ACCOUNT WHERE ID_NHAN_SU = ?";
            PreparedStatement pstmtAccount = conn.prepareStatement(deleteAccountSql);
            pstmtAccount.setInt(1, id);
            pstmtAccount.executeUpdate();
            pstmtAccount.close();

            // Sau đó xóa bản ghi trong bảng NHAN_SU
            String deleteEmployeeSql = "DELETE FROM NHAN_SU WHERE ID_NHAN_SU = ?";
            PreparedStatement pstmtEmployee = conn.prepareStatement(deleteEmployeeSql);
            pstmtEmployee.setInt(1, id);

            int rowsAffected = pstmtEmployee.executeUpdate();
            pstmtEmployee.close();

            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Statement createStatement() throws SQLException {
        return this.conn.createStatement();
    }
}
