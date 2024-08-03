/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.entity;

import java.util.Date;
import java.sql.Time;
/**
 *
 * @author Admin
 */
public class ChamCong {
    private int MaCC;
    private String MaNV;
    private Date NgayCC;
    private Time ThoiGianVao;
    private Time ThoiGianRa;
    private String ViTriCC;

    @Override
    public String toString(){
        return null;
    }
    
    public ChamCong() {
    }

    public ChamCong(int MaCC, String MaNV, Date NgayCC, Time ThoiGianVao, Time ThoiGianRa, String ViTriCC) {
        this.MaCC = MaCC;
        this.MaNV = MaNV;
        this.NgayCC = NgayCC;
        this.ThoiGianVao = ThoiGianVao;
        this.ThoiGianRa = ThoiGianRa;
        this.ViTriCC = ViTriCC;
    }

    public double getMaCC() {
        return MaCC;
    }

    public void setMaCC(int MaCC) {
        this.MaCC = MaCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayCC() {
        return NgayCC;
    }

    public void setNgayCC(Date NgayCC) {
        this.NgayCC = NgayCC;
    }

    public Time getThoiGianVao() {
        return ThoiGianVao;
    }

    public void setThoiGianVao(Time ThoiGianVao) {
        this.ThoiGianVao = ThoiGianVao;
    }

    public Time getThoiGianRa() {
        return ThoiGianRa;
    }

    public void setThoiGianRa(Time ThoiGianRa) {
        this.ThoiGianRa = ThoiGianRa;
    }

    public String getViTriCC() {
        return ViTriCC;
    }

    public void setViTriCC(String ViTriCC) {
        this.ViTriCC = ViTriCC;
    }

    
    
    
    
    
}
