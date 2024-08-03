/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.ChucVu;
import hrms.entity.Luong;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LuongDAO extends HRMSDAO<Luong, String> {

    final String INSERT_SQL = "INSERT INTO Luong(MaLuong,LuongCoBan,PhuCap,Thuong) values(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Luong set LuongCoBan=?,PhuCap=?,Thuong=? where MaLuong = ?";
    final String DELETE_SQL = "DELETE from Luong where MaLuong = ?";
    final String SELECT_ALL_SQL = "SELECT * from Luong";
    final String SELECT_BY_ID_SQL = "SELECT * from Luong WHERE MaLuong = ?";

    @Override
    public void insert(Luong entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaLuong(), entity.getLuongCoBan(), entity.getPhuCap(), entity.getThuong());
    }

    @Override
    public void update(Luong entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getLuongCoBan(), entity.getPhuCap(), entity.getThuong(), entity.getMaLuong());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Luong> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Luong selectById(String id) {
        List<Luong> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Luong> selectBySql(String sql, Object... args) {
        List<Luong> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Luong entity = new Luong();
                entity.setMaLuong(rs.getString("MaLuong"));
                entity.setLuongCoBan(rs.getDouble("LuongCoBan"));
                entity.setPhuCap(rs.getDouble("PhuCap"));
                entity.setThuong(rs.getDouble("Thuong"));

                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
