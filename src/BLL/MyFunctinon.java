/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MyFunctinon {

    public static int countData(String tableName){
        int total = 0;
        Connection c = DAL.DataBase.getConnection();
        Statement st;
        try {
            st = c.createStatement();
            //ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total' FROM casi");
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total' FROM "+tableName);
            while (rs.next()) {                
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyFunctinon.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }

}
