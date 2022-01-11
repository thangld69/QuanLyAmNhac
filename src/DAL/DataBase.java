/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class DataBase {
    public static Connection c;
    private static String db_url = "jdbc:mysql://localhost:3306/quanlykhoa";
    private static String username = "root";
    private static String password = "";
    

    public static Connection getConnection() throws Exception {
        if (c == null) {
            
            Class.forName("com.mysql.jdbc.Driver");
             
            c = DriverManager.getConnection(db_url, username, password);
        }
        return c;
    }
    
    public static int setData(String sql) throws Exception {
    return DataBase.getConnection().createStatement().executeUpdate(sql);
    }
 
    // Get data From Database
    public static ResultSet getData(String sql) throws Exception {
    ResultSet rs = DataBase.getConnection().createStatement().executeQuery(sql);
    return rs;
    }
}
