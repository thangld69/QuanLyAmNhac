/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DataBase {

    public static Connection getConnection(){
        
          Connection con = null;
          
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_am_nhac?useUnicode=true&characterEncoding=UTF-8", "root", "");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
