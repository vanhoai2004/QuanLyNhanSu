/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.entity;

/**
 *
 * @author Admin
 */
public class ChucVu {
    private String MaChucVu;
    private String MaLuong;
    private String TenChucVu;
    private String MoTa;

    @Override
    public String toString() {
        return null;
    }

    public ChucVu() {
    }

    public ChucVu(String MaChucVu, String MaLuong, String TenChucVu, String MoTa) {
        this.MaChucVu = MaChucVu;
        this.MaLuong = MaLuong;
        this.TenChucVu = TenChucVu;
        this.MoTa = MoTa;
    }
    
    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(String MaLuong) {
        this.MaLuong = MaLuong;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
    
}
