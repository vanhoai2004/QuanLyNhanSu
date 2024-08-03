/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.dao;

import java.util.List;

/**
 *
 * @author Admin
 */
public abstract class HRMSDAO<HRMSType, KeyType> {
    public abstract void insert(HRMSType entity);
    public abstract void update(HRMSType entity);
    public abstract void delete(KeyType id);
    public abstract  List<HRMSType> selectAll();
    public abstract  HRMSType selectById(KeyType id);
    public abstract  List<HRMSType> selectBySql(String sql, Object... args);
    
}
