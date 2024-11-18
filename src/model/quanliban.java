/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author leduc
 */
public class quanliban {
 

    private String tenBan;  
    private List<String> danhSachDoUong;
    private HashMap<Integer, List<Object[]>> danhSachBan = new HashMap<>();
    // Constructor
    public quanliban(String tenBan) {
        this.tenBan = tenBan;
        this.danhSachDoUong = new ArrayList<>();
    }
    
    public List<Object[]> Danhsachdouongdagoi(int banSo) {
        return danhSachBan.get(banSo);
    }
    public void themDoUong(int banSo, Object[] doUong) {
        danhSachBan.get(banSo).add(doUong);
    }

    public void themDoUong(String doUong) {
        danhSachDoUong.add(doUong);
    }

    public List<String> getDanhSachDoUong() {
        return danhSachDoUong;
    }

    public String getTenBan() {
        return tenBan;
    }
}
