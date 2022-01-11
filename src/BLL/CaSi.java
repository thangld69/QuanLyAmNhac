/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class CaSi {
     public static Connection conn = DAL.DataBase.getConnection(); // biến kết nối thông qua DAL
    public static PreparedStatement pst =null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    
}
