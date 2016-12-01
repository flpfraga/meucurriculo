/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProfissaoDAO;
import DAO.ProfissaoUsuarioDAO;
import Model.Profissao;
import Model.ProfissaoUsuario;
import View.profissao.JFrameAlterarProfissao;
import View.profissao.JFrameCadastrarProfissao;
import View.profissao.JFrameVisualizarProfissao;
import java.awt.Frame;

/**
 *
 * @author User
 */
public class ControllerProfissaoUsuario extends DefaultController{
    
    private ControllerUsuario controllerUsuario;
    private Profissao profissao;
    private ProfissaoUsuario profissaoUsuario;
    private JFrameVisualizarProfissao jFrameVisualizarProfissao;
    private ProfissaoDAO profissaoDAO;
    private ProfissaoUsuarioDAO profissaoUsuarioDAO;
    private JFrameCadastrarProfissao jFrameCadastrarProfissao;
    private JFrameAlterarProfissao jFrameAlterarProfissao;
    
    @Override
    public void incluir(Frame frame) {
        frame.setVisible(false);
        setjFrameCadastrarProfissao(new JFrameCadastrarProfissao());
        getjFrameCadastrarProfissao().setControllerProfissao(getjFrameCadastrarProfissao());
        getjFrameCadastrarProfissao().setVisible(true);
    }

    @Override
    public void mostrar(Frame frame) {
        frame.setVisible(false);
        setjFrameVisualizarProfissao(new JFrameVisualizarProfissao());
        getjFrameVisualizarProfissao().setControllerProfissao(getjFrameCadastrarProfissao());
        getjFrameVisualizarProfissao().setVisible(true);
    }

    @Override
    public void persistir(Frame frame) {
        frame.setVisible(false);
        getProfissaoUsuarioDAO().persistir(getProfissaoUsuario(), this);
        getjFrameVisualizarProfissao().setVisible(true);
    }
    public void voltarPainelProfissao(Frame frame){
        frame.setVisible(false);
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
    public ProfissaoUsuario getProfissaoUsuario() {
        return profissaoUsuario;
    }
    public void setProfissaoUsuario(ProfissaoUsuario profissaoUsuario) {
        this.profissaoUsuario = profissaoUsuario;
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
    public ProfissaoUsuarioDAO getProfissaoUsuarioDAO() {
        return profissaoUsuarioDAO;
    }
    public void setProfissaoUsuarioDAO(ProfissaoUsuarioDAO profissaoUsuarioDAO) {
        this.profissaoUsuarioDAO = profissaoUsuarioDAO;
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
    
}
