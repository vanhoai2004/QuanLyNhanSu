/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.ChucVu;
import hrms.entity.CongViec;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CongViecDAO extends HRMSDAO<CongViec, String> {

    final String INSERT_SQL = "INSERT INTO CongViec(MaCV,TenCV,MoTa,MaNV) values(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CongViec set TenCV=?,MoTa=?,MaNV=? where MaCV = ?";
    final String DELETE_SQL = "DELETE from CongViec where MaCV = ?";
    final String SELECT_ALL_SQL = "SELECT * from CongViec";
    final String SELECT_BY_ID_SQL = "SELECT * from CongViec WHERE MaCV = ?";

    @Override
    public void insert(CongViec entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaCV(), entity.getTenCV(), entity.getMoTa(), entity.getMaNV());

    }

    @Override
    public void update(CongViec entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenCV(), entity.getMoTa(), entity.getMaNV(), entity.getMaCV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<CongViec> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public CongViec selectById(String id) {
        List<CongViec> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CongViec> selectBySql(String sql, Object... args) {
        List<CongViec> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                CongViec entity = new CongViec();
                entity.setMaCV(rs.getString("MaCV"));
                entity.setTenCV(rs.getString("TenCV"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setMaNV(rs.getString("MaNV"));

                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
