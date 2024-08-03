/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhiemVu {
    private String MaNhiemVu;
    private String TenNhiemVu;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private String MoTa;
    private String MaCV;

    @Override
    public String toString() {
        return "NhiemVu{" + '}';
    }

    public NhiemVu() {
    }

    public NhiemVu(String MaNhiemVu, String TenNhiemVu, Date NgayBatDau, Date NgayKetThuc, String MoTa, String MaCV) {
        this.MaNhiemVu = MaNhiemVu;
        this.TenNhiemVu = TenNhiemVu;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.MoTa = MoTa;
        this.MaCV = MaCV;
    }

    public String getMaNhiemVu() {
        return MaNhiemVu;
    }

    public void setMaNhiemVu(String MaNhiemVu) {
        this.MaNhiemVu = MaNhiemVu;
    }

    public String getTenNhiemVu() {
        return TenNhiemVu;
    }

    public void setTenNhiemVu(String TenNhiemVu) {
        this.TenNhiemVu = TenNhiemVu;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }
    
}
