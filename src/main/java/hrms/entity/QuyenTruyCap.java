/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.entity;

/**
 *
 * @author Admin
 */
public class QuyenTruyCap {
    private String MaTC;
    private String MatKhau;
    private String Quyen;
    private String MaNV;

    @Override
    public String toString() {
        return "QuyenTruyCap{" + '}';
    }

    public QuyenTruyCap() {
    }

    public QuyenTruyCap(String MaTC, String MatKhau, String Quyen, String MaNV) {
        this.MaTC = MaTC;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
        this.MaNV = MaNV;
    }

    public String getMaTC() {
        return MaTC;
    }

    public void setMaTC(String MaTC) {
        this.MaTC = MaTC;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
}
