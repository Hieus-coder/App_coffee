/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leduc
 */
public class Douong {
    private String maDouong;
    private String tenDouong;
    private double gia;
    private double chiphi;

    // Constructor không tham số
    public Douong() {
    }

    // Constructor có tham số
    public Douong(String maDouong, String tenDouong, double gia, double chiphi) {
        this.maDouong = maDouong;
        this.tenDouong = tenDouong;
        this.gia = gia;
        this.chiphi = chiphi;
    }

    // Getter và Setter
    public String getMaDouong() {
        return maDouong;
    }

    public void setMaDouong(String maDouong) {
        this.maDouong = maDouong;
    }

    public String getTenDouong() {
        return tenDouong;
    }public void setTenDouong(String tenDouong) {
        this.tenDouong = tenDouong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getChiphi() {
        return chiphi;
    }

    public void setChiphi(double chiphi) {
        this.chiphi = chiphi;
    }
}
