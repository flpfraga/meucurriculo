/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.CursoUsuario;

import Controller.ControllerCurso;
import Controller.ControllerCursoUsuario;

/**
 *
 * @author Felipe Fraga
 */
public class JFrameCadastrarCursoUsuario extends javax.swing.JFrame {

    private ControllerCursoUsuario controllerCursoUsuario;
    private ControllerCurso controllerCurso;

    /**
     * Creates new form JFrameCadastrarCursoUsuario
     */
    public JFrameCadastrarCursoUsuario() {
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldInicio = new javax.swing.JTextField();
        jRadioButtonConcluido = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTermino = new javax.swing.JTextField();
        jRadioButtonTipoSandu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldInstiExtra = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setText("Curso do Usuario");

        jLabel2.setText("Nome:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Início:");

        jRadioButtonConcluido.setText("Já Concluido");
        jRadioButtonConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConcluidoActionPerformed(evt);
            }
        });

        jLabel5.setText("Termino:");
        jLabel5.setVisible(false);

        jTextFieldTermino.setVisible(false);

        jRadioButtonTipoSandu.setText("Realizado em mais de uma Instituição (Sanduiche)");
        jRadioButtonTipoSandu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTipoSanduActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome da Instituição:");
        jLabel6.setVisible(false);

        jTextFieldInstiExtra.setVisible(false);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");

        jLabelNome.setText("Nome");

        jLabelTipo.setText("Tipo");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jButtonSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldInicio))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                            .addGap(18, 18, 18)
                                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelTipo)
                                                .addComponent(jLabelNome)))
                                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                            .addGap(141, 141, 141)
                                            .addComponent(jLabel1))
                                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jRadioButtonConcluido)))
                                    .addGap(49, 49, 49)))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jRadioButtonTipoSandu)
                                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldTermino)))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldInstiExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 90, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 302, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNome))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelTipo))
                .addGap(24, 24, 24)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonConcluido)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonTipoSandu)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldInstiExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButtonVoltar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConcluidoActionPerformed
        if (jRadioButtonConcluido.isSelected()) {
            jLabel5.setVisible(true);
            jTextFieldTermino.setVisible(true);
        } else {
            jLabel5.setVisible(false);
            jTextFieldTermino.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButtonConcluidoActionPerformed

    private void jRadioButtonTipoSanduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTipoSanduActionPerformed
        if (jRadioButtonTipoSandu.isSelected()) {
            jLabel6.setVisible(true);
            jTextFieldInstiExtra.setVisible(true);
        } else {
            jLabel6.setVisible(false);
            jTextFieldInstiExtra.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButtonTipoSanduActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        int opcao = controllerCursoUsuario.confirmaInformacoes();
        if (opcao == 0) {
            controllerCursoUsuario.getCursoUsuario().setConcluido(jRadioButtonConcluido.isSelected());
            controllerCursoUsuario.getCursoUsuario().setTipoSanduiche(jRadioButtonTipoSandu.isSelected());
            controllerCursoUsuario.getCursoUsuario().setDataInicio(jTextFieldInicio.getText());
            controllerCursoUsuario.getCursoUsuario().setDataTermino(jTextFieldTermino.getText());
            controllerCursoUsuario.getCursoUsuario().setInstituicaoExtra(jTextFieldInstiExtra.getText());
            controllerCursoUsuario.persistir(this);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameCadastrarCursoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastrarCursoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastrarCursoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastrarCursoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCadastrarCursoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JRadioButton jRadioButtonConcluido;
    private javax.swing.JRadioButton jRadioButtonTipoSandu;
    private javax.swing.JTextField jTextFieldInicio;
    private javax.swing.JTextField jTextFieldInstiExtra;
    private javax.swing.JTextField jTextFieldTermino;
    // End of variables declaration//GEN-END:variables

    public ControllerCursoUsuario getControllerCursoUsuario() {
        return controllerCursoUsuario;
    }

    public void setControllerCursoUsuario(ControllerCursoUsuario controllerCursoUsuario) {
        this.controllerCursoUsuario = controllerCursoUsuario;
    }

    public ControllerCurso getControllerCurso() {
        return controllerCurso;
    }

    public void setControllerCurso(ControllerCurso controllerCurso) {
        this.controllerCurso = controllerCurso;
    }

    public void setParametros() {
        jLabelNome.setText(controllerCurso.getCurso().getNome());
        jLabelTipo.setText(controllerCurso.getCurso().getTipo());
        jTextFieldInicio.setText(controllerCursoUsuario.getCursoUsuario().getDataInicio());
        jTextFieldTermino.setText(controllerCursoUsuario.getCursoUsuario().getDataTermino());
        jTextFieldInstiExtra.setText(controllerCursoUsuario.getCursoUsuario().getInstituicaoExtra());
        jRadioButtonConcluido.setSelected(controllerCursoUsuario.getCursoUsuario().isConcluido());
        jRadioButtonTipoSandu.setSelected(controllerCursoUsuario.getCursoUsuario().isTipoSanduiche());

    }
}
