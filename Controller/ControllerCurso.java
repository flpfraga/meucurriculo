/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CursoDAO;
import Model.Curso;
import View.curso.JFrameCadastrarCurso;
import View.curso.JFrameVisualizarCursos;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerCurso extends DefaultController{
    private Curso curso;
    private CursoDAO cursoDAO;
    private ControllerInstituicaoEnsino controllerInstituicaoEnsino;
    private JFrameVisualizarCursos jFrameVisualizarCursos;
    private JFrameCadastrarCurso jFrameCadastrarCurso;

    public ControllerCurso() {
        curso = new Curso();
        cursoDAO = new CursoDAO();
        controllerInstituicaoEnsino = new ControllerInstituicaoEnsino();
        jFrameVisualizarCursos = new JFrameVisualizarCursos();
    }
    
    
    public void incluir(Frame frame) {
        frame.setVisible(false);
        setjFrameCadastrarCurso(new JFrameCadastrarCurso());
        getjFrameCadastrarCurso().setControllerCurso(this);
        getjFrameCadastrarCurso().setControllerInstituicaoEnsino(controllerInstituicaoEnsino);
        getjFrameCadastrarCurso().setVisible(true);
    }

    
    public void mostrar(Frame frame) {
        frame.setVisible(false);
        getjFrameVisualizarCursos().setControllerCurso(this);
        getjFrameVisualizarCursos().setVisible(true);
    }
    public DefaultTableModel atualizar (Frame frame){
        DefaultTableModel dtm  = cursoDAO.mostrar(curso, this);
        setControllerInstituicaoEnsino(new ControllerInstituicaoEnsino());
        dtm = getControllerInstituicaoEnsino().mostrarNome(dtm);
        return dtm;
    }

    @Override
    public void persistir(Frame frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ControllerInstituicaoEnsino getControllerInstituicaoEnsino() {
        return controllerInstituicaoEnsino;
    }

    public void setControllerInstituicaoEnsino(ControllerInstituicaoEnsino controllerInstituicaoEnsino) {
        this.controllerInstituicaoEnsino = controllerInstituicaoEnsino;
    }

    public JFrameCadastrarCurso getjFrameCadastrarCurso() {
        return jFrameCadastrarCurso;
    }

    public JFrameVisualizarCursos getjFrameVisualizarCursos() {
        return jFrameVisualizarCursos;
    }

    public void setjFrameVisualizarCursos(JFrameVisualizarCursos jFrameVisualizarCursos) {
        this.jFrameVisualizarCursos = jFrameVisualizarCursos;
    }

    public void setjFrameCadastrarCurso(JFrameCadastrarCurso jFrameCadastrarCurso) {
        this.jFrameCadastrarCurso = jFrameCadastrarCurso;
    }
    
    
    
}
