/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hrms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Văn Hoài
 */
public class JdbcHelper {
     private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl ="jdbc:sqlserver://localhost:1433;databaseName=HRMS;";
    private static String user ="sa";
    private static String pass = "30112004";
    /*
    *Nap driver
    */
    
    static {
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException ex) {
            System.out.println(" Class.forName(driver)");
            throw new RuntimeException(ex);
        }
    }
    
    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException{
        Connection connection = (Connection) DriverManager.getConnection(dburl,user,pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++){
            pstmt.setObject(i+1,args[i]);
        }
        return pstmt;
}
    
    public static int update(String sql, Object... args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
            return stmt.executeUpdate();
            } finally{
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    
    }
    
    
    public static ResultSet query(String sql,Object... args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("ResultSet"+e.toString());
            throw new RuntimeException(e);
        }
    }
    
    
    public static Object value(String sql, Object... args){
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
}
