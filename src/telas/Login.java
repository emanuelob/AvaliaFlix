
package telas;

//import javax.swing.JTextField;

import classes.Usuario;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        addFocusListenerToTextField();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        panelCover1 = new componentes.PanelCover();
        login = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        iconUser = new javax.swing.JLabel();
        iconPassword = new javax.swing.JLabel();
        registrarConta = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();
        iconLogin = new javax.swing.JLabel();
        refIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AvaliaFilx");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagensProj/clapperboard.png")).getImage());
        setMaximumSize(new java.awt.Dimension(1000, 685));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        panelCover1.setBackground(new java.awt.Color(255, 255, 255));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensProj/logo.png"))); // NOI18N

        user.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        user.setForeground(new java.awt.Color(102, 102, 102));
        user.setText("user");
        user.setToolTipText("");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensProj/user.png"))); // NOI18N

        iconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensProj/senha.png"))); // NOI18N

        registrarConta.setBackground(new java.awt.Color(255, 255, 255));
        registrarConta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        registrarConta.setForeground(new java.awt.Color(255, 255, 255));
        registrarConta.setText("Ainda não possui conta?");

        registrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        registrar.setForeground(new java.awt.Color(64, 123, 255));
        registrar.setText("Registre-se");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        entrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        entrar.setForeground(new java.awt.Color(64, 123, 255));
        entrar.setText("Entrar");
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        senha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        senha.setForeground(new java.awt.Color(102, 102, 102));
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCover1Layout = new javax.swing.GroupLayout(panelCover1);
        panelCover1.setLayout(panelCover1Layout);
        panelCover1Layout.setHorizontalGroup(
            panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCover1Layout.createSequentialGroup()
                .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCover1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(logo))
                    .addGroup(panelCover1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(login))
                    .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCover1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(registrarConta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                            .addComponent(registrar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCover1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(iconUser)
                                .addComponent(iconPassword))
                            .addGap(18, 18, 18)
                            .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(senha))))
                    .addGroup(panelCover1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(entrar)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        panelCover1Layout.setVerticalGroup(
            panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCover1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addGap(38, 38, 38)
                .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(user))
                .addGap(34, 34, 34)
                .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senha))
                .addGap(27, 27, 27)
                .addComponent(entrar)
                .addGap(30, 30, 30)
                .addGroup(panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registrarConta)
                    .addComponent(registrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensProj/LoginMenor.png"))); // NOI18N

        refIcon.setText("<a href=\"https://storyset.com/home\">Home illustrations by Storyset</a>");

        bg.setLayer(panelCover1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(iconLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(refIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(panelCover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(refIcon)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconLogin)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCover1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(iconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed
    
    private void addFocusListenerToTextField() {
            user.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (user.getText().equals("user")) {
                    user.setText("");
            }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (user.getText().isEmpty()) {
                    user.setText("user");
            }
            }
        });
    }
        
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // TODO add your handling code here:
        CadastrarUsuario obj = new CadastrarUsuario();
        obj.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_registrarActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
        String usuario = user.getText();
        char[] senhaChars = senha.getPassword();
        String senha = new String(senhaChars);
        
        Usuario objUsuario = new Usuario();

        if (objUsuario.realizarLogin(usuario, senha)) {
            Menu objMenu = new Menu();
            objMenu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos. Por favor, tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_entrarActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel iconLogin;
    private javax.swing.JLabel iconPassword;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel login;
    private javax.swing.JLabel logo;
    private componentes.PanelCover panelCover1;
    private javax.swing.JLabel refIcon;
    private javax.swing.JButton registrar;
    private javax.swing.JLabel registrarConta;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
