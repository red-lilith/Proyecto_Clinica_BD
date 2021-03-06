/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.JOptionPane;
import Controlador.*;
import Logica.*;

/**
 *
 * @author ennuikibun
 */
public class LogIn extends javax.swing.JFrame {

    Empleado_Control empleado_control;
    Vista_Control vista_control;
    
    public LogIn(Vista_Control vista) {
        super("Clínica X || Iniciar Sesión");
        initComponents();
	setLocationRelativeTo(null);
	setSize(280,455);
	setResizable(false);	
	setVisible(true);
        
        empleado_control = new Empleado_Control();
        vista_control = vista;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo_label = new javax.swing.JLabel();
        login_button = new javax.swing.JButton();
        user_label = new javax.swing.JLabel();
        pasword_label = new javax.swing.JLabel();
        user_field = new javax.swing.JTextField();
        pass_field = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(116, 165, 170));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/imgs/logo_.png"))); // NOI18N
        jPanel1.add(logo_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 270));

        login_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/imgs/login_.png"))); // NOI18N
        login_button.setBorderPainted(false);
        login_button.setContentAreaFilled(false);
        login_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_button.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/imgs/loginpressed_.png"))); // NOI18N
        login_button.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/imgs/loginselected_.png"))); // NOI18N
        login_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                login_buttonMousePressed(evt);
            }
        });
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(login_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 80, 80));

        user_label.setFont(new java.awt.Font("TakaoPGothic", 1, 15)); // NOI18N
        user_label.setForeground(new java.awt.Color(227, 227, 227));
        user_label.setText("Usuario");
        user_label.setToolTipText("");
        jPanel1.add(user_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 306, -1, 30));

        pasword_label.setFont(new java.awt.Font("TakaoPGothic", 1, 15)); // NOI18N
        pasword_label.setForeground(new java.awt.Color(227, 227, 227));
        pasword_label.setText("Contraseña");
        jPanel1.add(pasword_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 346, -1, 30));

        user_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(user_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, -1));

        pass_field.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        pass_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(pass_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_login_buttonActionPerformed

    private void user_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_fieldActionPerformed

    private void login_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMousePressed
        Empleado empleado = new Empleado();
        String user = user_field.getText();
        String pass = pass_field.getText();
        
        if(!user.isEmpty() && !pass.isEmpty()){
            int res = empleado_control.loguearEmpleado(user, pass);
            if(res != 0){
                if(user.equals("admin")){ //para el administrador
                    setVisible(false);
                    vista_control.mostrarVentana("admin");
                    vista_control.setUsuario(user);
		    vista_control.setIdActual(res);
                  
                }
                else{ 
                    setVisible(false);
                    vista_control.mostrarVentana("general");
                    vista_control.setUsuario(user);
		    vista_control.setIdActual(res);
                }
            }else
                    JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña son Incorrectos.", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        else
           JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "ALERTA!", JOptionPane.WARNING_MESSAGE);
 
    }//GEN-LAST:event_login_buttonMousePressed

    private void pass_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_fieldActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_button;
    private javax.swing.JLabel logo_label;
    private javax.swing.JPasswordField pass_field;
    private javax.swing.JLabel pasword_label;
    private javax.swing.JTextField user_field;
    private javax.swing.JLabel user_label;
    // End of variables declaration//GEN-END:variables
}
