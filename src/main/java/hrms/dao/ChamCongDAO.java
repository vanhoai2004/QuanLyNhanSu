/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import hrms.entity.ChamCong;
import hrms.entity.QuyenTruyCap;
import hrms.utils.Auth;
import hrms.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChamCongDAO extends HRMSDAO<ChamCong, Integer> {

    final String INSERT_SQL = "INSERT INTO ChamCong(MaNV,NgayCC,ThoiGianVao,ThoiGianRa,ViTriCC) values(?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChamCong set ThoiGianRa=?,ViTriCC=? WHERE NgayCC = ? and MaNV =?";
    final String DELETE_SQL = "DELETE from ChamCong where MaCC = ?";
    
    
    final String SELECT_ALL_SQL = "SELECT  MaCC,MaNV,NgayCC,ThoiGianVao,ThoiGianRa, "
            + "datediff(hour,ThoiGianVao,ThoiGianRa) as 'TongThoiGian',ViTriCC FROM ChamCong";
    final String SELECT_BY_ID_SQL = "SELECT MaCC,MaNV,NgayCC,ThoiGianVao,ThoiGianRa, "
            + "datediff(hour,ThoiGianVao,ThoiGianRa) as 'TongThoiGian',ViTriCC from ChamCong WHERE MaCC = ?";

    final String SELECT_ALL_BY_NGAYCC ="SELECT * from ChamCong WHERE NgayCC = ? and MaNV =?";
    
    @Override
    public void insert(ChamCong entity) {
        JdbcHelper.update(INSERT_SQL, 
                entity.getMaNV(), entity.getNgayCC(), entity.getThoiGianVao(), entity.getThoiGianRa(), entity.getViTriCC());
    }

    @Override

    public void update(ChamCong entity) {
        JdbcHelper.update(UPDATE_SQL,   entity.getThoiGianRa(), entity.getViTriCC(), entity.getNgayCC(),entity.getMaNV());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);

    }

    @Override
    public List<ChamCong> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChamCong selectById(Integer id) {
        List<ChamCong> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChamCong> selectBySql(String sql, Object... args) {
        List<ChamCong> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChamCong entity = new ChamCong();
                entity.setMaCC(rs.getInt("MaCC"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayCC(rs.getDate("NgayCC"));
                entity.setThoiGianVao(rs.getTime("ThoiGianVao"));
                entity.setThoiGianRa(rs.getTime("ThoiGianRa"));
                entity.setViTriCC(rs.getString("ViTriCC"));

                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
    public ChamCong selectByNgayCC(String date,String id) {
        List<ChamCong> list = selectBySql(SELECT_ALL_BY_NGAYCC, date,id);
        if (list.isEmpty()) {
            System.out.println("Lỗi");
            return null;
        }
        return list.get(0);
    }
    
//    public List<ChamCong> selectByNgayCC(Date date) {
//        return selectBySql(SELECT_ALL_BY_NGAYCC,date);
//    }

    

}
