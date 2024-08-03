/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.NhanVien;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends HRMSDAO<NhanVien, String>{
    
    final String INSERT_SQL = "insert into NhanVien(MaNV,MaChucVu,Ten,NgaySinh,DiaChi,SDT,Email,Hinh) values(?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhanVien set MaChucVu= ?,Ten= ?,NgaySinh= ?,DiaChi= ?,SDT= ?,Email= ?,Hinh= ?  where MaNV = ? ";
    final String DELETE_SQL = "DELETE from NhanVien where MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * from NhanVien";
    final String SELECT_BY_ID_SQL = "SELECT * from NhanVien WHERE MaNV = ?";
    
    final String SELECT_EMAIL = "SELECT Email FROM NhanVien where MaNV = ?";
    
    
    
    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaNV(),entity.getMaChucVu(),entity.getTen(),entity.getNgaySinh(),entity.getDiaChi(),entity.getSDT(),entity.getEmail(),entity.getHinh() );
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaChucVu(),entity.getTen(),
        entity.getNgaySinh(),entity.getDiaChi(),
        entity.getSDT(),entity.getEmail(), entity.getHinh(), entity.getMaNV() );
    }

    @Override
    public void delete(String id) {
       JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
     }

    @Override
    public NhanVien selectById(String id) {
       List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
      List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
               NhanVien entity = new NhanVien();
               entity.setMaNV(rs.getString("MaNV"));
               entity.setMaChucVu(rs.getString("MaChucVu"));
               entity.setTen(rs.getString("Ten"));
               entity.setNgaySinh(rs.getDate("NgaySinh"));
               entity.setDiaChi(rs.getString("DiaChi"));
               entity.setSDT(rs.getString("SDT"));
               entity.setEmail(rs.getString("Email"));
               entity.setHinh(rs.getString("Hinh"));
               list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
    
    
    
    
}
