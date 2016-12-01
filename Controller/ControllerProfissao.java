/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProfissaoDAO;
import Model.Profissao;
import View.profissao.JFrameVisualizarProfissao;
import View.profissao.JFrameCadastrarProfissao;
import View.profissao.JFrameAlterarProfissao;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;


public class ControllerProfissao extends DefaultController{
    
    private ControllerUsuario controllerUsuario;
    private Profissao profissao;
    private JFrameVisualizarProfissao jFrameVisualizarProfissao;
    private ProfissaoDAO profissaoDAO;
    private JFrameCadastrarProfissao jFrameCadastrarProfissao;
    private JFrameAlterarProfissao jFrameAlterarProfissao;
    
    public ControllerProfissao() {
        profissaoDAO = new ProfissaoDAO();
    }
    
    @Override
    public void incluir(Frame frame) {
        frame.setVisible(false);
        jFrameCadastrarProfissao = new JFrameCadastrarProfissao();
        jFrameCadastrarProfissao.setControllerProfissao(this);
        jFrameCadastrarProfissao.setVisible(true);
    }
    
    public DefaultTableModel atualizar() {
        return profissaoDAO.mostrar(profissao, this);
    }
    @Override
    public void mostrar(Frame frame) {
        frame.setVisible(false);
        jFrameVisualizarProfissao = new JFrameVisualizarProfissao();
        jFrameVisualizarProfissao.setControllerProfissao(this);
        jFrameVisualizarProfissao.setVisible(true);
    }

    @Override
    public void persistir(Frame frame) {
        frame.setVisible(false);
        profissaoDAO.persistir(profissao, this);
        jFrameVisualizarProfissao.setVisible(true);
    }

    
    
    public ControllerUsuario getControllerUsuario() {
        return controllerUsuario;
    }
    public void setControllerUsuario(ControllerUsuario controllerUsuario) {
        this.controllerUsuario = controllerUsuario;
    }
    public Profissao getProfissao() {
        return profissao;
    }
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
    public JFrameVisualizarProfissao getjFrameVisualizarProfissao() {
        return jFrameVisualizarProfissao;
    }
    public void setjFrameVisualizarProfissao(JFrameVisualizarProfissao jFrameVisualizarProfissao) {
        this.jFrameVisualizarProfissao = jFrameVisualizarProfissao;
    }
    public ProfissaoDAO getProfissaoDAO() {
        return profissaoDAO;
    }
    public void setProfissaoDAO(ProfissaoDAO profissaoDAO) {
        this.profissaoDAO = profissaoDAO;
    }
    public JFrameCadastrarProfissao getjFrameCadastrarProfissao() {
        return jFrameCadastrarProfissao;
    }
    public void setjFrameCadastrarProfissao(JFrameCadastrarProfissao jFrameCadastrarProfissao) {
        this.jFrameCadastrarProfissao = jFrameCadastrarProfissao;
    }
    public JFrameAlterarProfissao getjFrameAlterarProfissao() {
        return jFrameAlterarProfissao;
    }
    public void setjFrameAlterarProfissao(JFrameAlterarProfissao jFrameAlterarProfissao) {
        this.jFrameAlterarProfissao = jFrameAlterarProfissao;
    }
    public void voltarPainelGerenciarUsuario (Frame frame){
        controllerUsuario.mostrarPainelGerenciar(frame);
    }
    
}
