/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CursoUsuarioDAO;
import Model.CursoUsuario;
import View.CursoUsuario.JFrameAlterarCursoUsuario;
import View.CursoUsuario.JFrameCadastrarCursoUsuario;
import View.CursoUsuario.JFrameVisualizarCursoUsuario;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerCursoUsuario extends DefaultController{
    
    private CursoUsuario cursoUsuario;
    private CursoUsuarioDAO cursoUsuarioDAO;
    private JFrameVisualizarCursoUsuario jFrameVisualizarCursoUsuario;
    private ControllerCurso controllerCurso;
    private JFrameCadastrarCursoUsuario jFrameCadastrarCursoUsuario;
    private JFrameAlterarCursoUsuario jFrameAlterarCursoUsuario;
     
    public ControllerCursoUsuario() {
        cursoUsuario = new CursoUsuario();
        cursoUsuarioDAO = new CursoUsuarioDAO();
        controllerCurso = new ControllerCurso();
        jFrameVisualizarCursoUsuario = new JFrameVisualizarCursoUsuario();
        jFrameCadastrarCursoUsuario = new JFrameCadastrarCursoUsuario();
        jFrameAlterarCursoUsuario = new JFrameAlterarCursoUsuario();
    }
    public void incluir(Frame frame) {
        frame.setVisible(false);
        cursoUsuario.setIdCurso(controllerCurso.getCurso().getId());
        jFrameCadastrarCursoUsuario.setControllerCursoUsuario(this);
        jFrameCadastrarCursoUsuario.setControllerCurso(controllerCurso);
        jFrameCadastrarCursoUsuario.setParametros();
        jFrameCadastrarCursoUsuario.setVisible(true);
    }

    
    public void mostrar(Frame frame) {
        frame.setVisible(false);
        cursoUsuario = new CursoUsuario();
        jFrameVisualizarCursoUsuario.setControllerCursoUsuario(this);
        jFrameVisualizarCursoUsuario.setControllerCurso(getControllerCurso());
        jFrameVisualizarCursoUsuario.setjTableCursoUsuario(cursoUsuarioDAO.mostrar(cursoUsuario, this));
        jFrameVisualizarCursoUsuario.setVisible(true);
    }

    
    public void persistir(Frame frame) {
        if (cursoUsuarioDAO.jaExiste(cursoUsuario, this)){
            JOptionPane.showMessageDialog(null, "Curso já cadastrado", "Erro!-MYCurrículo", 0);
        }else{
            frame.setVisible(false);
            cursoUsuarioDAO.persistir(cursoUsuario, this);
            mostrar(frame);
        }
    }
    public void alterarCurso(Frame frame){
        frame.setVisible(false);
        cursoUsuario.setIdCurso(controllerCurso.getCurso().getId());
        cursoUsuario = (CursoUsuario) cursoUsuarioDAO.set(cursoUsuario, this);
        jFrameAlterarCursoUsuario.setControllerCursoUsuario(this);
        jFrameAlterarCursoUsuario.setControllerCurso(controllerCurso);
        jFrameAlterarCursoUsuario.setParametros();
        jFrameAlterarCursoUsuario.setVisible(true);
    }
    public void excluir (Frame frame){
        if (cursoUsuarioDAO.excluir(cursoUsuario, this)){
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "MYCurrículo", 0);
        }
        mostrar(frame);
    }
    public void alterar (Frame frame){
            frame.setVisible(false);
            cursoUsuarioDAO.alterar(cursoUsuario, this);
            mostrar(frame);
    }
    public ArrayList busca(int indice, DefaultController defaultController){
        return cursoUsuarioDAO.busca(indice, defaultController);
    }
    public CursoUsuario getCursoUsuario() {
        return cursoUsuario;
    }

    public void setCursoUsuario(CursoUsuario cursoUsuario) {
        this.cursoUsuario = cursoUsuario;
    }

    public CursoUsuarioDAO getCursoUsuarioDAO() {
        return cursoUsuarioDAO;
    }

    public void setCursoUsuarioDAO(CursoUsuarioDAO cursoUsuarioDAO) {
        this.cursoUsuarioDAO = cursoUsuarioDAO;
    }

    public ControllerCurso getControllerCurso() {
        return controllerCurso;
    }

    public void setControllerCurso(ControllerCurso controllerCurso) {
        this.controllerCurso = controllerCurso;
    }
    
}
