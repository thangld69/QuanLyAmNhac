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
public class TTBieuDien {

    public static Connection conn = DAL.DataBase.getConnection(); // biến kết nối thông qua DAL
    public static PreparedStatement pst = null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu

    public static void themBD(String maBD, String maCS ,String maBH,String ngayBD,String diaDiem) {
        String sql = "INSERT INTO `thongtinbieudien`(`MABD`, `MACS`, `MABH`, `NGAYBD`, `DIADIEM`) VALUES (?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, maBD);
            pst.setString(2, maCS);
            pst.setString(3, maBH);
            pst.setString(4, ngayBD);
            pst.setString(5, diaDiem);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm thông tin biểu diễn ''"+maBD+" "+maCS+"'' thành công","Thông Báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Mã biểu diễn "+maBD+" đã tồn tại","Thông Báo",1);
        }

    }
    // Xóa ca sĩ
    public static void xoaBD(String maBD)
    {
        String sql="delete from thongtinbieudien where MABD='"+maBD+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa thông tin "+maBD+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã biểu diễn "+maBD+" không thể xóa","Thông Báo",1);
        }
    }
    // sửa ca sĩ
    public static void suaBD(String maBD1, String maBD, String maCS,String maBH,String ngayBD,String diaDiem)
     {
         
        String sql ="update thongtinbieudien set MABD=N'"+maBD+"', MACS=N'"+maCS+"', MABH=N'"+maBH+"', NGAYBD=N'"+ngayBD+"', DIADIEM=N'"+diaDiem+"' where MABD='"+maBD1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã"+maBD+" đã tồn tại","Thông Báo",1);
        }

     }
}
