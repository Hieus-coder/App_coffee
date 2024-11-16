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
            String sql = "SELECT * FROM DOANHTHU";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}   
