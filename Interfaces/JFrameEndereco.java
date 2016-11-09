/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Endereco;
import Classes.Persistencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Fraga
 */
public class JFrameEndereco extends javax.swing.JFrame {

    Endereco endereco = new Endereco();
    private PreparedStatement ps = null;

    public JFrameEndereco() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFramePreenher = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldComp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCep = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldUf = new javax.swing.JTextField();
        jRadioButtonBrasil = new javax.swing.JRadioButton();
        jRadioButtonPais = new javax.swing.JRadioButton();
        jTextFieldPais = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        endereco.setEndereco();
        jInternalFramePreenher.setVisible(true);

        jLabel1.setText("Rua: ");

        jLabel2.setText("Bairro: ");

        jLabel3.setText("Nº:");

        jTextFieldRua.setText(endereco.getRua());

        jTextFieldBairro.setText(endereco.getBairro());

        jTextFieldNum.setText(""+endereco.getNum());

        jLabel4.setText("Comp:");

        jLabel5.setText("Cidade:");

        jTextFieldCep.setText(endereco.getCep());

        jLabel6.setText("CEP:");

        jTextFieldCidade.setText(endereco.getCidade());

        jLabel8.setText("UF:");

        if (endereco.isBrasil()){
            jRadioButtonBrasil.setEnabled(true);
        }
        jRadioButtonBrasil.setText("Brasil");
        jRadioButtonBrasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBrasilActionPerformed(evt);
            }
        });

        if (!endereco.getPaisEstrangeiro().equals("")){
            jRadioButtonPais.setEnabled(true);
        }
        jRadioButtonPais.setText("Outro país:");
        jRadioButtonPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPaisActionPerformed(evt);
            }
        });

        if (!endereco.getPaisEstrangeiro().equals("")){
            jTextFieldPais.setText(endereco.getPaisEstrangeiro());
            jTextFieldPais.setVisible(true);
        }

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFramePreenherLayout = new javax.swing.GroupLayout(jInternalFramePreenher.getContentPane());
        jInternalFramePreenher.getContentPane().setLayout(jInternalFramePreenherLayout);
        jInternalFramePreenherLayout.setHorizontalGroup(
            jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18))
                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFramePreenherLayout.createSequentialGroup()
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)))
                            .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFramePreenherLayout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addGap(16, 16, 16)))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldComp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFramePreenherLayout.createSequentialGroup()
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                .addComponent(jRadioButtonPais)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jRadioButtonBrasil))
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
        );
        jInternalFramePreenherLayout.setVerticalGroup(
            jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonBrasil)
                    .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPais)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFramePreenher)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFramePreenher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 403, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonBrasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBrasilActionPerformed
        if (jRadioButtonPais.getVerifyInputWhenFocusTarget()) {
            jRadioButtonPais.setEnabled(false);
            jTextFieldPais.setVisible(false);

        }
    }//GEN-LAST:event_jRadioButtonBrasilActionPerformed

    private void jRadioButtonPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPaisActionPerformed
        if (jRadioButtonBrasil.getVerifyInputWhenFocusTarget()) {
            jRadioButtonBrasil.setEnabled(false);
            jTextFieldPais.setVisible(true);
        }
    }//GEN-LAST:event_jRadioButtonPaisActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        int aux = JOptionPane.showConfirmDialog(null, "Deseja Salvar as Alterações?", "Meu Curriculo", 0, 3);
        if (aux == 1) {
            try {
                ps = Persistencia.conexao().prepareStatement("Insert into endereco (id, rua, bairro, num, cidade, cep, brasil, paisEstrangeiro) values (?,?,?,?,?,?,?,?)");
                ps.setInt(1, endereco.getId());
                ps.setString(2, jTextFieldRua.getText());
                ps.setString(3, jTextFieldBairro.getText());
                ps.setInt(4, Integer.parseInt(jTextFieldNum.getText()));
                ps.setString(5, jTextFieldCidade.getText());
                ps.setString(6, jTextFieldCep.getText());
                ps.setBoolean(7, jRadioButtonBrasil.getVerifyInputWhenFocusTarget());
                ps.setString(8, jTextFieldPais.getText());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Endereço salvo!", "Meu Curriculo - Sucesso!", -1);
            } catch (SQLException e) {
                System.out.println("Não foi possível execultar o comando sql para inserir" + e);
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JInternalFrame jInternalFramePreenher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButtonBrasil;
    private javax.swing.JRadioButton jRadioButtonPais;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComp;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldUf;
    // End of variables declaration//GEN-END:variables
}
