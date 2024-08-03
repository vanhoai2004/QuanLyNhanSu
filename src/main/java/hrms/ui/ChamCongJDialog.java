/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package hrms.ui;

import hrms.dao.ChamCongDAO;
import hrms.dao.NhanVienDAO;
import hrms.entity.ChamCong;
import hrms.entity.NhanVien;
import hrms.utils.Auth;
import hrms.utils.MsgBox;
import hrms.utils.XImage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.ImageIcon;

/**
 *
 * @author Văn Hoài
 */
public class ChamCongJDialog extends javax.swing.JDialog {

    ChamCongDAO dao = new ChamCongDAO();
    int row = 0;
    NhanVienDAO nvdao = new NhanVienDAO();
    NhanVien listnv = nvdao.selectById(Auth.user.getMaNV());
    /**
     * Creates new form ChamCongJDialog
     */
    public ChamCongJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("HRMS QUẢN LÝ CHẤM CÔNG");
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String date = ft.format(new Date());
        lblNgay.setText(date);
        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblDongHo.setText(format.format(new Date()));
            }
        }).start();
        updateStatus();
        fillTable();
        hinh(listnv);
        setForm();
        if (!Auth.isManager()) {
            tabs.remove(1);
        }
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblCC.getModel();
        model.setRowCount(0);
        try {
            List<ChamCong> list = dao.selectAll();
            for (ChamCong cc : list) {
                Object[] row = {
                    cc.getMaCC(),
                    cc.getMaNV(),
                    cc.getNgayCC(),
                    cc.getThoiGianVao(),
                    cc.getThoiGianRa(),
                    cc.getViTriCC(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            System.out.println(e);
        }
        row = tblCC.getRowCount();
    }

    ChamCong cc = new ChamCong();

    ChamCong getForm() {
        cc.setMaNV(Auth.user.getMaNV());
        cc.setNgayCC(new Date());
        cc.setThoiGianVao(getTGV());
        if (rdoViTri1.isSelected()) {
            cc.setViTriCC(rdoViTri1.getText());
        } else if (rdoViTri2.isSelected()) {
            cc.setViTriCC(rdoViTri2.getText());
        } else {
            cc.setViTriCC(rdoViTri3.getText());
        }
        return cc;
    }

    void setForm() {
        txtMaNV.setText(Auth.user.getMaNV());
    }

    public Time getTGV() {
        Time currentTime = Time.valueOf(lblDongHo.getText());
        Time tgv = currentTime;
        return tgv;
    }

    void updateStatus() {
        boolean edit = this.row >= 0;
        txtMaNV.setEnabled(!edit);  
    }

    void insert() {
        ChamCong cc = getForm();
        try {
            dao.insert(cc);
            this.fillTable();
            MsgBox.alert(this, "Bắt đầu chấm công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Bắt đầu chấm công thất bại!");
            System.out.println(e);
        }
    }


    void update() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String date = ft.format(new Date());
        String id = Auth.user.getMaNV();
        ChamCong cc = dao.selectByNgayCC(date,id);
        cc.setThoiGianRa(Time.valueOf(LocalTime.now()));
        if (rdoViTri1.isSelected()) {
            cc.setViTriCC(rdoViTri1.getText());
        } else if (rdoViTri2.isSelected()) {
            cc.setViTriCC(rdoViTri2.getText());
        } else {
            cc.setViTriCC(rdoViTri3.getText());
        }
        try {
            dao.update(cc);
            this.fillTable();
            getForm();
            MsgBox.alert(this, "Hoàn thành chấm công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Chấm công thất bại!");
            System.out.println(e);
        }
    }

    

    void hinh(NhanVien model) {
        String hinh = model.getHinh();
        if (hinh != null) {
            ImageIcon icon = XImage.read(hinh);
            Image image = icon.getImage();
            ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), image.SCALE_SMOOTH));
            lblHinh.setIcon(icon1);
            lblHinh.setToolTipText(hinh);
        } else {
            lblHinh.setText("No Avatar");
            lblHinh.setIcon(null);
        }

    }
    
    boolean checkNgayCC() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String date = ft.format(new Date());
        String id = Auth.user.getMaNV();
        try {
            ChamCong cc = dao.selectByNgayCC(date,id);
            if (cc.getMaNV().equals(id)) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdoViTri1 = new javax.swing.JRadioButton();
        rdoViTri2 = new javax.swing.JRadioButton();
        rdoViTri3 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        btnThoiGianVao = new javax.swing.JButton();
        btnThoiGianRa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCC = new javax.swing.JTable();
        lblDongHo = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(73, 76, 128));
        jPanel1.setForeground(new java.awt.Color(142, 218, 250));

        tabs.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setText("Hình");
        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(73, 76, 128), null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã NV:");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Vị trí chấm công:");

        buttonGroup1.add(rdoViTri1);
        rdoViTri1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoViTri1.setSelected(true);
        rdoViTri1.setText("35 Nguyễn Văn Linh");

        buttonGroup1.add(rdoViTri2);
        rdoViTri2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoViTri2.setText("345 Điện Biên Phủ");
        rdoViTri2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoViTri2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoViTri3);
        rdoViTri3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoViTri3.setText("43 Xô Viết Nghệ Tĩnh");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(rdoViTri1)
                        .addComponent(rdoViTri2)
                        .addComponent(rdoViTri3)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rdoViTri1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rdoViTri2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(rdoViTri3)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(73, 76, 128), null));

        btnThoiGianVao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThoiGianVao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hrms/icon/Pointer.png"))); // NOI18N
        btnThoiGianVao.setText("Thời Gian Vào");
        btnThoiGianVao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianVaoActionPerformed(evt);
            }
        });

        btnThoiGianRa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThoiGianRa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hrms/icon/Right.png"))); // NOI18N
        btnThoiGianRa.setText("Thời Gian Ra");
        btnThoiGianRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianRaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnThoiGianVao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(btnThoiGianRa)
                .addGap(44, 44, 44))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoiGianRa)
                    .addComponent(btnThoiGianVao))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        tabs.addTab("Chấm Công", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CC", "Mã NV", "Ngày CC", "Thời Gian Vào", "Thời Gian Ra", "Vị Trí CC"
            }
        ));
        jScrollPane1.setViewportView(tblCC);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        tabs.addTab("Danh Sách", jPanel3);

        lblDongHo.setBackground(new java.awt.Color(255, 255, 255));
        lblDongHo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDongHo.setForeground(new java.awt.Color(255, 255, 255));
        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hrms/icon/Alarm.png"))); // NOI18N
        lblDongHo.setText("12:12:12");

        lblNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNgay.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHẤM CÔNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDongHo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoViTri2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoViTri2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoViTri2ActionPerformed

    private void btnThoiGianVaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiGianVaoActionPerformed
        if (!checkNgayCC()) {
            MsgBox.alert(this, "Bạn đã bắt đầu chấm công!");
        }else{
            insert();
        }

    }//GEN-LAST:event_btnThoiGianVaoActionPerformed

    private void btnThoiGianRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiGianRaActionPerformed
        if (!checkNgayCC()) {
            update();
        }else{
            MsgBox.alert(this, "Bạn chưa bắt đầu chấm công!");
        }

    }//GEN-LAST:event_btnThoiGianRaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChamCongJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChamCongJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChamCongJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChamCongJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChamCongJDialog dialog = new ChamCongJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoiGianRa;
    private javax.swing.JButton btnThoiGianVao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JRadioButton rdoViTri1;
    private javax.swing.JRadioButton rdoViTri2;
    private javax.swing.JRadioButton rdoViTri3;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblCC;
    private javax.swing.JTextField txtMaNV;
    // End of variables declaration//GEN-END:variables
}
