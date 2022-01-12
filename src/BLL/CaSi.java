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

    private String anh;
    private String maCS;
    private String tenCS;
    
    public CaSi() {
    }

    public CaSi(String anh, String maCS, String tenCS) {
        this.anh = anh;
        this.maCS = maCS;
        this.tenCS = tenCS;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        CaSi.conn = conn;
    }

    public static PreparedStatement getPst() {
        return pst;
    }

    public static void setPst(PreparedStatement pst) {
        CaSi.pst = pst;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        CaSi.rs = rs;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaCS() {
        return maCS;
    }

    public void setMaCS(String maCS) {
        this.maCS = maCS;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }
    
    

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
