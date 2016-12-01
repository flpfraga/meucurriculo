/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.endereco;

import Model.Endereco;
import DAO.Persistencia;
import Controller.ControllerEndereco;
import Controller.ControllerUsuario;
import Controller.DefaultController;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Fraga
 */
public class JFrameEndereco extends javax.swing.JFrame {

    ControllerEndereco controllerEndereco;
    boolean endJaCadastrado = false;

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
        jLabel7 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFramePreenher.setVisible(true);

        jLabel1.setText("Rua: ");

        jLabel2.setText("Bairro: ");

        jLabel3.setText("Nº:");

        jLabel4.setText("Comp:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("CEP:");

        jLabel8.setText("UF:");

        jRadioButtonBrasil.setText("Brasil");
        jRadioButtonBrasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBrasilActionPerformed(evt);
            }
        });

        jRadioButtonPais.setText("Outro país:");
        jRadioButtonPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPaisActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Endereço");

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFramePreenherLayout = new javax.swing.GroupLayout(jInternalFramePreenher.getContentPane());
        jInternalFramePreenher.getContentPane().setLayout(jInternalFramePreenherLayout);
        jInternalFramePreenherLayout.setHorizontalGroup(
            jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar))
                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel7))
                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonExcluir)
                                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                                .addComponent(jRadioButtonBrasil)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButtonPais)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                                .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldComp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                                                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel8))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFramePreenherLayout.createSequentialGroup()
                                                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel6)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 71, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFramePreenherLayout.setVerticalGroup(
            jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFramePreenherLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonBrasil)
                            .addComponent(jRadioButtonPais)
                            .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jButtonSalvar)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFramePreenherLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jInternalFramePreenherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonVoltar)
                            .addComponent(jButtonExcluir))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFramePreenher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFramePreenher)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonBrasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBrasilActionPerformed

        if (jRadioButtonPais.isSelected()) {
            jRadioButtonPais.setSelected(false);

        }
        jTextFieldPais.setVisible(false);
        jTextFieldPais.setText("");

    }//GEN-LAST:event_jRadioButtonBrasilActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        int opcao = controllerEndereco.confirmaInformacoes();
        if (opcao == 0) {
            boolean brasil = jRadioButtonBrasil.isEnabled();
            Endereco endereco = controllerEndereco.getEndereco();
            endereco.setRua(jTextFieldRua.getText());
            endereco.setBairro(jTextFieldBairro.getText());
            endereco.setNum(jTextFieldNum.getText());
            endereco.setCidade(jTextFieldCidade.getText());
            endereco.setCep(jTextFieldCep.getText());
            endereco.setPaisEstrangeiro(jTextFieldPais.getText());
            endereco.setUf(jTextFieldUf.getText());
            endereco.setComp(jTextFieldComp.getText());
            endereco.setBrasil(brasil);
            controllerEndereco.setEndereco(endereco);
            if (endJaCadastrado) {
                controllerEndereco.alterar(this);
                
            } else {
                controllerEndereco.persistir(this);
                endJaCadastrado = true;
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jRadioButtonPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPaisActionPerformed

        if (jRadioButtonBrasil.isSelected()) {
            jRadioButtonBrasil.setSelected(false);
        }
        jTextFieldPais.setVisible(true);
    }//GEN-LAST:event_jRadioButtonPaisActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
            controllerEndereco.mostrarPainelGerenciar(this);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        controllerEndereco.excluir(this);
    }//GEN-LAST:event_jButtonExcluirActionPerformed
    public void setController(DefaultController defaultController) {
        this.controllerEndereco = (ControllerEndereco) defaultController;
    }

    public void setParametros() {
        Endereco endereco = controllerEndereco.getEndereco();
        jTextFieldBairro.setText(endereco.getBairro());
        jTextFieldRua.setText(endereco.getRua());
        jTextFieldCidade.setText(endereco.getCidade());
        jTextFieldCep.setText(endereco.getCep());
        jTextFieldNum.setText(endereco.getNum());
        jTextFieldPais.setText(endereco.getPaisEstrangeiro());
        jTextFieldUf.setText(endereco.getUf());
        jTextFieldComp.setText(endereco.getComp());
    }
    public void setEndJaCadastrado(){
        endJaCadastrado = true;
    }
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
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JInternalFrame jInternalFramePreenher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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