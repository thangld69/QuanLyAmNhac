/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.MyFunctinon;
import BLL.loadTable;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import BLL.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class CaSi_Frame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CaSi_Frame
     */
    public static String sql = "Select * From CASI";
    public static String maCS; // biến tạm lưu lại MaCS tại dòng có con trỏ chuột click
    public static String duongdananh = "C:\\Users\\DELL\\Desktop\\HK1_2021\\java\\DA_CK\\QuanLyAmNhac\\src\\imgApp\\no_image.jpg";
    int vitri = -1;
    public ArrayList<CaSi> al_CaSi = new ArrayList<>();

    public CaSi_Frame() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        //countCaSi.setText("Số lượng ca sĩ : " + Integer.toString(MyFunctinon.countData("CASI")));
        loadTable.loadData(sql, jtbCaSi);
        loadCaSi();
        //hienThiDanhSach();

    }

    //
    public static void luufile() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(txtMaCS.getText() + ".txt");
        String text = duongdananh;
        byte[] luu = text.getBytes();
        fos.write(luu);
        System.out.println("Luu thanh cong");
    }

    public static void docfile() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(txtMaCS.getText() + ".txt");
        int c;
        while ((c = fis.read()) != -1) {

            System.out.print((char) c);
        }
    }
    //

    public void hienThiDanhSach() {
        ArrayList<CaSi> dSCS = getDSCS();
        DefaultTableModel model = (DefaultTableModel) jtbCaSi.getModel();
        model.setColumnIdentifiers(new Object[]{
            "MACS", "TENCS"
        });
        Object[] row = new Object[7];
        for (int i = 0; i < dSCS.size(); i++) {
            row[0] = dSCS.get(i).getMaCS();
            row[1] = dSCS.get(i).getTenCS();
            model.addRow(row);
        }
    }

    public ArrayList<CaSi> getDSCS() {
        ArrayList<CaSi> listCS = new ArrayList<>();
        try {
            Connection conn = DAL.DataBase.getConnection();
            String sql = "Select * from casi"; //lay du lieu
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CaSi cs = new CaSi();
                cs.setMaCS(rs.getString(1));
                cs.setTenCS(rs.getString(2));
                listCS.add(cs);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCS;
    }

    public void fillArrayListToTable() {

        DefaultTableModel model = (DefaultTableModel) jtbCaSi.getModel();
        model.setRowCount(0);
        /* for(NhanVien nv : arrnhanvien)
         {
         model.addRow(new Object[]{nv.getManv(),nv.getHoten(),nv.getTuoi(),nv.getEmail(),nv.getLuong() });
      
         }
         */
        for (CaSi cs : al_CaSi) {
            Vector vec = new Vector();
            vec.add(cs.getMaCS());
            vec.add(cs.getTenCS());
            vec.add(cs.getAnh());
            model.addRow(vec);
        }

    }

    public void filltocontroll(int vitri) {
        txtMaCS.setText(al_CaSi.get(vitri).getMaCS());
        txtTenCS.setText(al_CaSi.get(vitri).getTenCS());
//        txtemail.setText(arrnhanvien.get(vitri).getEmail());
//        txttuoi.setText(String.valueOf(arrnhanvien.get(vitri).getTuoi()));
//        txtluong.setText(String.valueOf(arrnhanvien.get(vitri).getLuong()));
        lblAnh.setIcon(ResizeImage(String.valueOf(al_CaSi.get(vitri).getAnh())));

    }

    public void fillDaTaToArrayList() {
        CaSi cs = new CaSi();
        cs.setMaCS(txtMaCS.getText());
        cs.setTenCS(txtTenCS.getText());
        cs.setAnh(duongdananh);
        al_CaSi.add(cs);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void clean() {
        txtMaCS.setText("");
        txtTK.setText("");
        txtTenCS.setText("");

    }

    public void loadCaSi() {
        loadTable.loadData(sql, jtbCaSi);
        this.countCaSi.setText("Tổng số ca sĩ: " + this.jtbCaSi.getRowCount());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCaSi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtMaCS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTenCS = new javax.swing.JTextField();
        countCaSi = new javax.swing.JLabel();
        btnLamMoi = new com.k33ptoo.components.KButton();
        btnThem = new com.k33ptoo.components.KButton();
        btnSua = new com.k33ptoo.components.KButton();
        btnXoa = new com.k33ptoo.components.KButton();
        lblAnh = new javax.swing.JLabel();
        btnTim = new com.k33ptoo.components.KButton();
        txtTK = new javax.swing.JTextField();
        btnChonAnh = new com.k33ptoo.components.KButton();
        btnXoaTrang = new com.k33ptoo.components.KButton();
        btnSX = new com.k33ptoo.components.KButton();

        setPreferredSize(new java.awt.Dimension(920, 490));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 204, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("CA SĨ");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_micro_36px.png"))); // NOI18N
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 36, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_micro_36px.png"))); // NOI18N
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 36, -1, -1));

        jtbCaSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbCaSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCaSiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCaSi);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 880, 172));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã ca sĩ ");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 178, 10));

        txtMaCS.setBackground(new java.awt.Color(153, 204, 255));
        txtMaCS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaCS.setBorder(null);
        txtMaCS.setOpaque(false);
        kGradientPanel1.add(txtMaCS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 180, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên ca sĩ");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 178, 10));

        txtTenCS.setBackground(new java.awt.Color(153, 204, 255));
        txtTenCS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenCS.setBorder(null);
        txtTenCS.setOpaque(false);
        kGradientPanel1.add(txtTenCS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 180, 20));

        countCaSi.setText("Số Lượng Ca Sĩ");
        kGradientPanel1.add(countCaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        btnLamMoi.setText("Tải Lại");
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLamMoi.setkEndColor(new java.awt.Color(153, 153, 153));
        btnLamMoi.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnLamMoi.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnLamMoi.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnLamMoi.setkStartColor(new java.awt.Color(0, 102, 102));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 100, 40));

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setkHoverEndColor(new java.awt.Color(0, 204, 102));
        btnThem.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnThem.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        btnThem.setkStartColor(new java.awt.Color(0, 51, 204));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 100, 40));

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnSua.setkHoverStartColor(new java.awt.Color(204, 204, 0));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 100, 40));

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setkEndColor(new java.awt.Color(255, 51, 0));
        btnXoa.setkHoverEndColor(new java.awt.Color(255, 51, 51));
        btnXoa.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnXoa.setkHoverStartColor(new java.awt.Color(255, 102, 0));
        btnXoa.setkStartColor(new java.awt.Color(255, 51, 51));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 100, 40));

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgApp/no_image.jpg"))); // NOI18N
        lblAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kGradientPanel1.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 180, 130));

        btnTim.setText("Tìm");
        btnTim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTim.setkEndColor(new java.awt.Color(0, 153, 153));
        btnTim.setkHoverEndColor(new java.awt.Color(102, 255, 102));
        btnTim.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnTim.setkHoverStartColor(new java.awt.Color(255, 102, 153));
        btnTim.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnTim.setkStartColor(new java.awt.Color(0, 102, 102));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 70, 30));

        txtTK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        kGradientPanel1.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 180, 30));

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChonAnh.setkEndColor(new java.awt.Color(0, 153, 153));
        btnChonAnh.setkHoverEndColor(new java.awt.Color(102, 255, 102));
        btnChonAnh.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnChonAnh.setkHoverStartColor(new java.awt.Color(255, 102, 153));
        btnChonAnh.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnChonAnh.setkStartColor(new java.awt.Color(0, 102, 102));
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 80, 40));

        btnXoaTrang.setText("Xóa Trắng");
        btnXoaTrang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaTrang.setkEndColor(new java.awt.Color(153, 153, 153));
        btnXoaTrang.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnXoaTrang.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnXoaTrang.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnXoaTrang.setkStartColor(new java.awt.Color(153, 153, 153));
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnXoaTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 100, 40));

        btnSX.setText("Sắp Xếp");
        btnSX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSX.setkEndColor(new java.awt.Color(153, 153, 153));
        btnSX.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnSX.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnSX.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnSX.setkStartColor(new java.awt.Color(0, 102, 102));
        btnSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        String temp = "";
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (this.txtMaCS.getText().length() == 0 || this.txtTenCS.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông Báo", 1);
        } else {
            CaSi.themCS(this.txtMaCS.getText(), this.txtTenCS.getText());
            temp = duongdananh;
            try {
                //            fillDaTaToArrayList();
//            fillArrayListToTable();
                luufile();
                docfile();
            } catch (IOException ex) {
                Logger.getLogger(CaSi_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //hienThiDanhSach();
        loadCaSi();
    }//GEN-LAST:event_btnThemActionPerformed
    int co = 0;
    private void jtbCaSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCaSiMouseClicked
        // TODO add your handling code here:
        try {
            int row = this.jtbCaSi.getSelectedRow(); // lấy dòng tại con trỏ chuột
            String IDrow = (this.jtbCaSi.getModel().getValueAt(row, 0)).toString();// Lấy giá trị tại con trỏ chuột theo kiểu string
            //String gioiTinh = (this.jtbCaSi.getModel().getValueAt(row,4)).toString();// Lấy giá trị Giới Tính theo kiểu string
            String sql1 = "select * from CASI where MACS=N'" + IDrow + "'";
            ResultSet rs = loadTable.showTextField(sql1);
            // đọc dữ liệu tại dòng "IDrow"
            if (rs.next()) // nếu có dữ liệu
            {
                maCS = rs.getString("MaCS");
                this.txtMaCS.setText(rs.getString("MaCS"));
                this.txtTenCS.setText(rs.getString("TenCS"));

                //String file = new docfile();
//                lblAnh.setIcon(ResizeImage(String.valueOf(rs.getString("URL"))));
                lblAnh.setIcon(ResizeImage(String.valueOf(temp)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jtbCaSiMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (this.txtMaCS.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ca sĩ cần xóa", "Thông Báo", 1);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ca sĩ " + maCS + " không?", "Thông Báo", 2) == 0) {
                CaSi.xoaCS(maCS);
                txtMaCS.setText("");
                txtTenCS.setText("");
            }
            loadCaSi();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        loadCaSi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (this.txtMaCS.getText().length() == 0 || this.txtTenCS.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông Báo", 1);
        } else {
            CaSi.suaCS(maCS, this.txtMaCS.getText(), this.txtTenCS.getText());
            loadCaSi();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        if (txtTK.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã ca sĩ cần tìm", "Thông Báo", 1);
        } else {
            String sql = "SELECT * FROM casi WHERE MACS = '" + txtTK.getText() + "'";;

            loadTable.loadData(sql, jtbCaSi);
            this.countCaSi.setText("Tổng số ca sĩ: " + this.jtbCaSi.getRowCount());
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    private void btnSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM casi ORDER BY MACS"; //lay du lieu
        loadTable.loadData(sql, jtbCaSi);
    }//GEN-LAST:event_btnSXActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnChonAnh;
    private com.k33ptoo.components.KButton btnLamMoi;
    private com.k33ptoo.components.KButton btnSX;
    private com.k33ptoo.components.KButton btnSua;
    private com.k33ptoo.components.KButton btnThem;
    private com.k33ptoo.components.KButton btnTim;
    private com.k33ptoo.components.KButton btnXoa;
    private com.k33ptoo.components.KButton btnXoaTrang;
    public static javax.swing.JLabel countCaSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jtbCaSi;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAnh;
    public static javax.swing.JTextField txtMaCS;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenCS;
    // End of variables declaration//GEN-END:variables
}
