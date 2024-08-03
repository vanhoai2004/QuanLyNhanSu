/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.ChucVu;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Admin
 */
public class ChucVuDAO extends HRMSDAO<ChucVu, String>{
    final String INSERT_SQL = "INSERT INTO ChucVu(MaChucVu,MaLuong,TenChucVu,MoTa) values(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChucVu set MaLuong=?,TenChucVu=?,MoTa=? where MaChucVu = ?";
    final String DELETE_SQL = "DELETE from ChucVu where MaChucVu = ?";
    final String SELECT_ALL_SQL = "SELECT * from ChucVu";
    final String SELECT_BY_ID_SQL = "SELECT * from ChucVu WHERE MaChucVu = ?";


    @Override
    public void insert(ChucVu entity) {
          JdbcHelper.update(INSERT_SQL, entity.getMaChucVu(),entity.getMaLuong() ,entity.getTenChucVu(),entity.getMoTa());
                
    }

    @Override
    public void update(ChucVu entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaLuong() , entity.getTenChucVu(), entity.getMoTa(),entity.getMaChucVu());
    }

    @Override
    public void delete(String id) {
       JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ChucVu> selectAll() {
      return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChucVu selectById(String id) {
         List<ChucVu> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChucVu> selectBySql(String sql, Object... args) {
       List<ChucVu> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChucVu entity = new ChucVu();
                entity.setMaChucVu(rs.getString("MaChucVu"));
                entity.setMaLuong(rs.getString("MaLuong"));
                entity.setTenChucVu(rs.getString("TenChucVu"));
                entity.setMoTa(rs.getString("MoTa"));
            

                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

   
}
