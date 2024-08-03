/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.ChucVu;
import hrms.entity.NhiemVu;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhiemVuDAO extends HRMSDAO<NhiemVu, String> {

    final String INSERT_SQL = "INSERT INTO NhiemVu(MaNhiemVu,TenNhiemVu,NgayBatDau,NgayKetThuc,MoTa,MaCV) values(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhiemVu set TenNhiemVu=?,NgayBatDau=?,NgayKetThuc=?,MoTa=?,MaCV=? where MaNhiemVu = ?";
    final String DELETE_SQL = "DELETE from NhiemVu where MaNhiemVu = ?";
    final String SELECT_ALL_SQL = "SELECT * from NhiemVu";
    final String SELECT_BY_ID_SQL = "SELECT * from NhiemVu WHERE MaNhiemVu = ?";
    
    final String SELECT_BY_MaCV_SQL = "SELECT * from NhiemVu WHERE MaCV = ?";

    @Override
    public void insert(NhiemVu entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaNhiemVu(), entity.getTenNhiemVu(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getMoTa(), entity.getMaCV());
    }

    @Override
    public void update(NhiemVu entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenNhiemVu(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getMoTa(), entity.getMaCV(), entity.getMaNhiemVu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhiemVu> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhiemVu selectById(String id) {
        List<NhiemVu> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhiemVu> selectBySql(String sql, Object... args) {
        List<NhiemVu> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhiemVu entity = new NhiemVu();
                entity.setMaNhiemVu(rs.getString("MaNhiemVu"));
                entity.setTenNhiemVu(rs.getString("TenNhiemVu"));
                entity.setNgayBatDau(rs.getDate("NgayBatDau"));
                entity.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setMaCV(rs.getString("MaCV"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
//    public NhiemVu selectByMaCV(String id) {
//        List<NhiemVu> list = selectBySql(SELECT_BY_MaCV_SQL, id);
//        if (list.isEmpty()) {
//            System.out.println("Lỗi");
//            return null;
//        }
//        return list.get(0);
//    }
    
     public List<NhiemVu> selectByMaCV(String maCV) {
        return selectBySql(SELECT_BY_MaCV_SQL,maCV);
    }

}
