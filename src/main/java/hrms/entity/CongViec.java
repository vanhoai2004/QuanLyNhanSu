/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.entity;

/**
 *
 * @author Admin
 */
public class CongViec {
    private String MaCV;
    private String TenCV;
    private String MoTa;
    private String MaNV;

    @Override
    public String toString() {
        return null;
    }

    public CongViec() {
    }

    public CongViec(String MaCV, String TenCV, String MoTa, String MaNV) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
        this.MoTa = MoTa;
        this.MaNV = MaNV;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    
}
