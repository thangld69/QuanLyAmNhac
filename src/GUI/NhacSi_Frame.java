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
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class NhacSi_Frame extends javax.swing.JInternalFrame {

    /**
     * Creates new form CaSi_Frame
     */
    public static String sql = "Select * From NHACSI";
    public static String maNS; // biến tạm lưu lại MaSV tại dòng có con trỏ chuột click

    public NhacSi_Frame() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        //countCaSi.setText("Số lượng ca sĩ : " + Integer.toString(MyFunctinon.countData("CASI")));
        loadTable.loadData(sql, jtbNhacSi);
        loadNS();

    }

    public void loadNS() {
        loadTable.loadData(sql, jtbNhacSi);
        this.countNhacSi.setText("Tổng số nhạc sĩ: " + this.jtbNhacSi.getRowCount());
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
        jtbNhacSi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtMaNS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTenNS = new javax.swing.JTextField();
        countNhacSi = new javax.swing.JLabel();
        btnXoaTrang = new com.k33ptoo.components.KButton();
        btnThem = new com.k33ptoo.components.KButton();
        btnSua = new com.k33ptoo.components.KButton();
        btnXoa = new com.k33ptoo.components.KButton();

        setPreferredSize(new java.awt.Dimension(920, 490));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 204, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nhạc Sĩ");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_micro_36px.png"))); // NOI18N
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_micro_36px.png"))); // NOI18N
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jtbNhacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbNhacSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNhacSiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNhacSi);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 880, 172));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã nhạc sĩ ");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 178, 10));

        txtMaNS.setBackground(new java.awt.Color(153, 204, 255));
        txtMaNS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaNS.setBorder(null);
        txtMaNS.setOpaque(false);
        kGradientPanel1.add(txtMaNS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 180, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên nhạc sĩ");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 178, 10));

        txtTenNS.setBackground(new java.awt.Color(153, 204, 255));
        txtTenNS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenNS.setBorder(null);
        txtTenNS.setOpaque(false);
        kGradientPanel1.add(txtTenNS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 180, 20));

        countNhacSi.setText("Số Lượng nhạc Sĩ");
        kGradientPanel1.add(countNhacSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

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
        kGradientPanel1.add(btnXoaTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 100, 40));

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
        kGradientPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 100, 40));

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnSua.setkHoverStartColor(new java.awt.Color(204, 204, 0));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 100, 40));

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
        kGradientPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 100, 40));

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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (txtMaNS.getText().length() == 0 || this.txtTenNS.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông Báo", 1);
        } else {
            NhacSi.themNS(txtMaNS.getText(), this.txtTenNS.getText());
        }
        loadNS();
    }//GEN-LAST:event_btnThemActionPerformed

    private void jtbNhacSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNhacSiMouseClicked
        // TODO add your handling code here:
        try {
            int row = this.jtbNhacSi.getSelectedRow(); // lấy dòng tại con trỏ chuột
            String IDrow = (this.jtbNhacSi.getModel().getValueAt(row, 0)).toString();// Lấy giá trị tại con trỏ chuột theo kiểu string
            //String gioiTinh = (this.jtbCaSi.getModel().getValueAt(row,4)).toString();// Lấy giá trị Giới Tính theo kiểu string
            String sql1 = "select * from nhacsi where MANS=N'" + IDrow + "'";
            ResultSet rs = loadTable.showTextField(sql1);
            // đọc dữ liệu tại dòng "IDrow"
            if (rs.next()) // nếu có dữ liệu
            {
                maNS = rs.getString("MaNS");
                txtMaNS.setText(rs.getString("MaNS"));
                this.txtTenNS.setText(rs.getString("TenNS"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jtbNhacSiMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (txtMaNS.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhạc sĩ cần xóa", "Thông Báo", 1);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhạc sĩ " + maNS + " không?", "Thông Báo", 2) == 0) {
                NhacSi.xoaNS(maNS);
                txtMaNS.setText("");
                txtTenNS.setText("");
            }
            loadNS();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        // TODO add your handling code here:
        txtMaNS.setText("");
        txtTenNS.setText("");
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (txtMaNS.getText().length() == 0 || this.txtTenNS.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông Báo", 1);
        } else {
            NhacSi.suaCS(maNS, this.txtMaNS.getText(), this.txtTenNS.getText());
            loadNS();
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnSua;
    private com.k33ptoo.components.KButton btnThem;
    private com.k33ptoo.components.KButton btnXoa;
    private com.k33ptoo.components.KButton btnXoaTrang;
    public static javax.swing.JLabel countNhacSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jtbNhacSi;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtMaNS;
    private javax.swing.JTextField txtTenNS;
    // End of variables declaration//GEN-END:variables
}
