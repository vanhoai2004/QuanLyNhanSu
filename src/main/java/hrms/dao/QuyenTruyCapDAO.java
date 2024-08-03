/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.QuyenTruyCap;
import hrms.utils.Auth;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuyenTruyCapDAO extends HRMSDAO<QuyenTruyCap, String>{

    
    final String INSERT_SQL = "INSERT INTO QuyenTruyCap(MaTC,MatKhau,Quyen,MaNV) values(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE QuyenTruyCap set MatKhau=?,Quyen=?,MaNV=? where MaTC = ?";
    final String DELETE_SQL = "DELETE from QuyenTruyCap where MaTC = ?";
    final String SELECT_ALL_SQL = "SELECT * from QuyenTruyCap";
    final String SELECT_BY_ID_SQL = "SELECT * from QuyenTruyCap WHERE MaTC = ?";
    
    
    
    @Override
    public void insert(QuyenTruyCap entity) {
    JdbcHelper.update(INSERT_SQL, entity.getMaTC(),
            entity.getMatKhau(),entity.getQuyen(), entity.getMaNV());    
    }

    @Override
    public void update(QuyenTruyCap entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMatKhau(),entity.getQuyen(),Auth.user.getMaNV(),entity.getMaTC()); 
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<QuyenTruyCap> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public QuyenTruyCap selectById(String id){
       List<QuyenTruyCap> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuyenTruyCap> selectBySql(String sql, Object... args) {
    
      List<QuyenTruyCap> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
               QuyenTruyCap entity = new QuyenTruyCap();
               entity.setMaTC(rs.getString("MaTC"));
               entity.setMatKhau(rs.getString("MatKhau"));
               entity.setQuyen(rs.getString("Quyen"));
               entity.setMaNV(rs.getString("MaNV"));
               list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
