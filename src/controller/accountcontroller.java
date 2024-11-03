package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class accountcontroller {

    private Connection conn;

    // Constructor nhận vào đối tượng Connection
    public accountcontroller(Connection conn) {
        this.conn = conn;
    }

    // Phương thức kiểm tra tài khoản và mật khẩu
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
}
