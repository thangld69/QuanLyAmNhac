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
public class NhacSi {

    public static Connection conn = DAL.DataBase.getConnection(); // biến kết nối thông qua DAL
    public static PreparedStatement pst = null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu

    public static void themNS(String maNS, String tenNS) {
        String sql = "INSERT INTO `nhacsi`(`MANS`, `TENNS`) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maNS);
            pst.setString(2, tenNS);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm ca sĩ ''"+maNS+" "+tenNS+"'' thành công","Thông Báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Mã ca sĩ "+maNS+" đã tồn tại","Thông Báo",1);
        }

    }
    // Xóa ca sĩ
    public static void xoaNS(String MANS)
    {
        String sql="delete from nhacsi where MANS='"+MANS+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa nhạc sĩ "+MANS+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"nhạc sĩ "+MANS+" không thể xóa","Thông Báo",1);
        }
    }
    // sửa nhạc sĩ
    public static void suaCS(String MaNS1, String MaNS, String TenNS)
     {
         
        String sql ="update nhacsi set MANS=N'"+MaNS+"', TenNS=N'"+TenNS+"' where MANS='"+MaNS1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã nhạc sĩ "+MaNS+" đã tồn tại","Thông Báo",1);
        }

     }
}
