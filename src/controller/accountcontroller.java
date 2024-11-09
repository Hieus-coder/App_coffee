package controller;

import java.sql.*;
import DBC.Dbconnection;

public class accountcontroller {

    private Connection conn;

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

    public boolean addAccount(String taikhoan, String matkhau, int idNhansu) {
        ResultSet checkRs = null;
        PreparedStatement checkPstmt = null;
        PreparedStatement pstmt = null;

        try {
            // Kiểm tra sự tồn tại của ID_NHAN_SU trong bảng NHAN_SU
            String checkSql = "SELECT COUNT(*) FROM NHAN_SU WHERE ID_NHAN_SU = ?";
            checkPstmt = conn.prepareStatement(checkSql);
            checkPstmt.setInt(1, idNhansu);
            checkRs = checkPstmt.executeQuery();

            if (checkRs.next() && checkRs.getInt(1) > 0) {
                // ID_NHAN_SU tồn tại, tiếp tục thêm tài khoản
                String sql = "INSERT INTO ACCOUNT(TAIKHOAN, MATKHAU, ID_NHAN_SU) VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, taikhoan);
                pstmt.setString(2, matkhau);
                pstmt.setInt(3, idNhansu);

                int rowAffected = pstmt.executeUpdate();
                return rowAffected > 0;
            } else {
                // Nếu ID_NHAN_SU không tồn tại
                System.out.println("ID nhân viên không tồn tại trong bảng NHAN_SU");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (checkRs != null) {
                    checkRs.close();
                }
                if (checkPstmt != null) {
                    checkPstmt.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAdmin(String TAIKHOAN) {
        return "admin".equals(TAIKHOAN);
    }
}
