/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CaSi {

    public static Connection conn = DAL.DataBase.getConnection(); // biến kết nối thông qua DAL
    public static PreparedStatement pst = null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    //private String 
    

    public static void themCS(String maCS, String tenCS) {
        String sql = "INSERT INTO `casi`(`MACS`, `TENCS`) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maCS);
            pst.setString(2, tenCS);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm ca sĩ ''"+maCS+" "+tenCS+"'' thành công","Thông Báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Mã ca sĩ "+maCS+" đã tồn tại","Thông Báo",1);
        }

    }
    // Xóa ca sĩ
    public static void xoaCS(String MaCS)
    {
        String sql="delete from casi where MACS='"+MaCS+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa ca sĩ "+MaCS+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ca sĩ "+MaCS+" không thể xóa","Thông Báo",1);
        }
    }
    // sửa ca sĩ
    public static void suaCS(String MaCS1, String MaCS, String TenCS)
     {
         
        String sql ="update casi set MACS=N'"+MaCS+"', TenCS=N'"+TenCS+"' where MACS='"+MaCS1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã ca sĩ "+MaCS+" đã tồn tại","Thông Báo",1);
        }

     }
}
