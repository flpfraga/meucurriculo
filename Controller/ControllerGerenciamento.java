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
        setjFrameLoginGerenciamento(new JFrameLoginGerenciamento());
        getjFrameLoginGerenciamento().setControllerGerenciamento(this);
        getjFrameLoginGerenciamento().setVisible(true);
    }
    
    public void setGerente(Gerente gerente){
        this.gerente = gerente;
    }
    
    public void login (Frame frame){
         if (getGerenteDAO().verificaCadastro(getGerente(), this)){
             frame.setVisible(false);
             setjFramePainelGerenciamento(new JFramePainelGerenciamento());
             getjFramePainelGerenciamento().setControllerGerenciamento(this);
             getjFramePainelGerenciamento().setVisible(true);
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

    
    public void persistir(Frame frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Gerente getGerente() {
        return gerente;
    }

    public GerenteDAO getGerenteDAO() {
        return gerenteDAO;
    }

    public void setGerenteDAO(GerenteDAO gerenteDAO) {
        this.gerenteDAO = gerenteDAO;
    }

    public JFrameLoginGerenciamento getjFrameLoginGerenciamento() {
        return jFrameLoginGerenciamento;
    }

    public void setjFrameLoginGerenciamento(JFrameLoginGerenciamento jFrameLoginGerenciamento) {
        this.jFrameLoginGerenciamento = jFrameLoginGerenciamento;
    }

    public JFramePainelGerenciamento getjFramePainelGerenciamento() {
        return jFramePainelGerenciamento;
    }

    public void setjFramePainelGerenciamento(JFramePainelGerenciamento jFramePainelGerenciamento) {
        this.jFramePainelGerenciamento = jFramePainelGerenciamento;
    }
}
