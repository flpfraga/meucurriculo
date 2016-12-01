/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GerenteDAO;
import DAO.DefaultDAO;
import Model.Gerente;
import View.gerenciamento.JFrameLoginGerenciamento;
import View.gerenciamento.JFramePainelGerenciamento;
import View.usuario.JFrameCadastrarUsuario;
import View.usuario.JFrameGerenciarUsuario;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerGerenciamento extends DefaultController{
    private Gerente gerente;
    private GerenteDAO gerenteDAO = new GerenteDAO();
    private JFrameLoginGerenciamento jFrameLoginGerenciamento;
    private JFramePainelGerenciamento jFramePainelGerenciamento;
    
    public void painelLogin (Frame frame){
        frame.setVisible(false);
        jFrameLoginGerenciamento = new JFrameLoginGerenciamento();
        jFrameLoginGerenciamento.setControllerGerenciamento(this);
        jFrameLoginGerenciamento.setVisible(true);
    }
    
    public void setGerente(Gerente gerente){
        this.gerente = gerente;
    }
    
    public void login (Frame frame){
         if (gerenteDAO.verificaCadastro(gerente, this)){
             frame.setVisible(false);
             jFramePainelGerenciamento = new JFramePainelGerenciamento();
             jFramePainelGerenciamento.setControllerGerenciamento(this);
             jFramePainelGerenciamento.setVisible(true);
         } else {
            JOptionPane.showMessageDialog(null, "Cadastro não encontrado", "Erro!-MYCurrículo", 0);
        }
    }
    @Override
    public void incluir(Frame frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void mostrar(Frame frame) {
        frame.setVisible(false);
    }

    @Override
    public void persistir(Frame frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
