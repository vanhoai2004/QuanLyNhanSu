/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Văn Hoài
 */
public class ThongKeDAO {
     private List<Object[]> getListofArray(String sql, String[] cols, Object...args){
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     
    public List<Object[]> getBangLuong(Integer thang){
        String sql = "{call sp_BangLuong(?)}";
        String[] cols = {"MaNV", "Ten", "TenChucVu", "LuongCoBan", "PhuCap","Thuong","TongSoNgayCC", "TongLuong"};
        return getListofArray(sql, cols, thang);
    }
    
    public List<Object[]> getTop5NV(Integer thang){
        String sql = "{call sp_Top5NhanVienXuatSac(?)}";
        String[] cols = {"MaNV", "Ten", "Email", "SDT", "DiaChi","TenChucVu","SoNgayLamTrongThang"};
        return getListofArray(sql, cols, thang);
    }
    
    public List<Object[]> getCongViec( ){
        String sql = "{call sp_CongViec()}";
        String[] cols = {"MaNV", "TenCV", "TenNhiemVu", "NgayBatDau", "NgayKetThuc","MoTa"};
        return getListofArray(sql, cols);
    }
    
    
    
    
}
