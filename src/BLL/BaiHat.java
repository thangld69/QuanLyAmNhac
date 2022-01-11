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
public class BaiHat {

    public static Connection conn = DAL.DataBase.getConnection(); // biến kết nối thông qua DAL
    public static PreparedStatement pst = null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu

    public static void themBH(String maBH, String tenBH ,String namST,String maNS) {
        String sql = "INSERT INTO `baihat`(`MABH`, `TENBH`, `NAMST`, `MANS`) VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBH);
            pst.setString(2, tenBH);
            pst.setString(3, namST);
            pst.setString(4, maNS);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm bài hát ''"+maBH+" "+tenBH+"'' thành công","Thông Báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Mã bài hát "+maBH+" đã tồn tại","Thông Báo",1);
        }

    }
    // Xóa ca sĩ
    public static void xoaBH(String MaBH)
    {
        String sql="delete from baihat where MABH='"+MaBH+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa bài hát "+MaBH+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Bài hát "+MaBH+" không thể xóa","Thông Báo",1);
        }
    }
    // sửa ca sĩ
    public static void suaBH(String maBH1, String maBH, String tenBH,String namST,String maNS)
     {
         
        String sql ="update baihat set MABH=N'"+maBH+"', TENBH=N'"+tenBH+"', NAMST=N'"+namST+"', maNS=N'"+maNS+"' where MABH='"+maBH1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã bài hát "+maBH+" đã tồn tại","Thông Báo",1);
        }

     }
}
