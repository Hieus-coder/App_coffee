package controller;

import java.sql.*;
import DBC.Dbconnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class accountcontroller {

    private Connection conn;
    public static String loggedInUsername = null;

    public accountcontroller() {
        conn = Dbconnection.getInstance().getConnection();
    }

    public String getPasswordFromDatabase(String username) {
        String encodedPassword = null;
        String query = "SELECT MATKHAU FROM ACCOUNT WHERE TAIKHOAN = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                encodedPassword = resultSet.getString("MATKHAU");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return encodedPassword;
    }
    
    public boolean checkUserCredentials(String TAIKHOAN, String MATKHAU) {
        try {
            String sql = "SELECT * FROM ACCOUNT WHERE TAIKHOAN = ? AND MATKHAU = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, TAIKHOAN);
            pre.setString(2, MATKHAU);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                loggedInUsername = rs.getString("TAIKHOAN"); 
                System.out.println("Username: " + loggedInUsername);
                return true; 
            } else {
                return false; 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean checkAccountExists(String taikhoan) {
        try {
            String sql = "SELECT COUNT(*) FROM ACCOUNT WHERE TAIKHOAN = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, taikhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean getAccount(String tk, String mk) {
        try {
            String sql = "SELECT TAIKHOAN, MATKHAU FROM ACCOUNT";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                tk = rs.getString("TAIKHOAN");
                mk = rs.getString("MATKHAU");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String hashPassword(String password) {
        if (password == null) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b)); // Chuyển đổi byte sang hex
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String encodePassword(String password) {
        if (password == null) {
            return null; 
        }
        StringBuilder encoded = new StringBuilder();
        for (char c : password.toCharArray()) {
            encoded.append((char) (c + 1));
        }
        return encoded.toString();
    }

    public String decodePassword(String encodedPassword) {
        if (encodedPassword == null) {
            return null;
        }
        StringBuilder decoded = new StringBuilder();
        for (char c : encodedPassword.toCharArray()) {
            decoded.append((char) (c - 1));
        }
        return decoded.toString();
    }

    public boolean checkLogin(String username, String password) {
        String encodedPasswordFromDb = getPasswordFromDatabase(username);
        if (encodedPasswordFromDb != null) {
            String decodedPassword = decodePassword(encodedPasswordFromDb);
            if (password.equals(decodedPassword)) {
                loggedInUsername = username; 
                return true;
            }
        }
        loggedInUsername = null; 
        return false;
    }

    public boolean addAccount(String taikhoan, String matkhau, int idNhansu, String chucvu) {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO ACCOUNT(TAIKHOAN, MATKHAU, ID_NHAN_SU, CHUC_VU) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, taikhoan);
            pstmt.setString(2, matkhau);
            pstmt.setInt(3, idNhansu);
            pstmt.setString(4, chucvu);

            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editAccount(String taikhoan, String matkhau, int id_nhan_su) {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE ACCOUNT SET TAIKHOAN = ?, MATKHAU = ? WHERE ID_NHAN_SU = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, taikhoan);
            pstmt.setString(2, matkhau);
            pstmt.setInt(3, id_nhan_su);
            int rowAffected = pstmt.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAdmin(String TAIKHOAN) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT ns.CHUC_VU "
                    + "FROM ACCOUNT a "
                    + "JOIN NHAN_SU ns ON a.ID_NHAN_SU = ns.ID_NHAN_SU "
                    + "WHERE a.TAIKHOAN = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, TAIKHOAN);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String chucVu = rs.getString("CHUC_VU");
                return "Quản lý".equalsIgnoreCase(chucVu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
