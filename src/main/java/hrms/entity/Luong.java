/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.entity;

/**
 *
 * @author Admin
 */
public class Luong {
    private String MaLuong;
    private String MaNV;
    private double LuongCoBan;
    private double PhuCap;
    private double Thuong;

    @Override
    public String toString() {
        return "Luong{" + '}';
    }

    public Luong() {
    }

    public Luong(String MaLuong, String MaNV, double LuongCoBan, double PhuCap, double Thuong) {
        this.MaLuong = MaLuong;
        this.MaNV = MaNV;
        this.LuongCoBan = LuongCoBan;
        this.PhuCap = PhuCap;
        this.Thuong = Thuong;
    }

    public String getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(String MaLuong) {
        this.MaLuong = MaLuong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public double getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public double getPhuCap() {
        return PhuCap;
    }

    public void setPhuCap(double PhuCap) {
        this.PhuCap = PhuCap;
    }

    public double getThuong() {
        return Thuong;
    }

    public void setThuong(double Thuong) {
        this.Thuong = Thuong;
    }
    
    
}
