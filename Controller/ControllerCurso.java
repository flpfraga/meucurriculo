/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CursoDAO;
import Model.Curso;
import View.curso.JFrameAlterarCurso;
import View.curso.JFrameBuscarCurso;
import View.curso.JFrameCadastrarCurso;
import View.curso.JFrameVisualizarCursos;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerCurso extends DefaultController {

    private Curso curso;
    private CursoDAO cursoDAO;
    private ControllerInstituicaoEnsino controllerInstituicaoEnsino;
    private JFrameVisualizarCursos jFrameVisualizarCursos;
    private JFrameCadastrarCurso jFrameCadastrarCurso;
    private ControllerGerenciamento controllerGerenciamento;
    private JFrameBuscarCurso jFrameBuscarCurso;
    private ControllerCursoUsuario controllerCursoUsuario;
    private JFrameAlterarCurso jFrameAlterarCurso;

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

    public void adicionar(Frame frame) {

    }

    public void buscar(Frame frame) {
        frame.setVisible(false);
        jFrameBuscarCurso = new JFrameBuscarCurso();
        jFrameBuscarCurso.setControllerCurso(this);
        jFrameBuscarCurso.setControllerCursoUsuario(controllerCursoUsuario);
        jFrameBuscarCurso.setVisible(true);
    }

    public Curso buscarPorId(int indice) {
        return cursoDAO.buscar(indice, this);
    }

    public void set(Object object, Frame frame) {
        curso = (Curso) object;
        curso = (Curso) cursoDAO.set(curso, this);
    }

    public void mostrar(Frame frame) {
        frame.setVisible(false);
        getjFrameVisualizarCursos().setControllerCurso(this);
        getjFrameVisualizarCursos().setVisible(true);
    }

    public DefaultTableModel atualizar(Frame frame) {
        DefaultTableModel dtm = getCursoDAO().mostrar(getCurso(), this);
        setControllerInstituicaoEnsino(new ControllerInstituicaoEnsino());
        dtm = getControllerInstituicaoEnsino().mostrarNome(dtm);
        return dtm;
    }

    public void persistir(Frame frame) {
        if (!curso.getTipo().equals(controllerInstituicaoEnsino.getInstituicaoEnsinoDAO().getTipo())) {
            JOptionPane.showMessageDialog(null, "Selecione uma instituição de ensino do mesmo tipo do Curso", "ERR0!-MYCurrículo", 0);
        } else if (cursoDAO.jaExiste(curso, this)) {
            JOptionPane.showMessageDialog(null, "Curso já cadastrado", "ERR0!-MYCurrículo", 0);
        } else {
            frame.setVisible(false);
            cursoDAO.persistir(curso, this);
            curso = new Curso();
            jFrameVisualizarCursos.buscar();
            jFrameVisualizarCursos.setVisible(true);
        }
    }

    public void voltar(Frame frame) {
        frame.setVisible(false);
        jFrameVisualizarCursos.setControllerCurso(this);
        jFrameVisualizarCursos.setVisible(true);
    }

    public void voltarPainelGerenciamento(Frame frame) {
        frame.setVisible(false);
        controllerGerenciamento.getjFramePainelGerenciamento().setControllerCurso(this);
        controllerGerenciamento.getjFramePainelGerenciamento().setVisible(true);
    }

    public void alterarCurso(Frame frame) {
        frame.setVisible(false);
        setjFrameAlterarCurso(new JFrameAlterarCurso());
        getjFrameAlterarCurso().setControllerCurso(this);
        getjFrameAlterarCurso().setControllerInstituicaoEnsino(controllerInstituicaoEnsino);
        getjFrameAlterarCurso().setParametros();
        getjFrameAlterarCurso().setVisible(true);
    }

    public void alterar(Frame frame) {
        cursoDAO.alterar(curso, this);
        voltar(frame);
    }

    public void excluir(Frame frame) {
        if (cursoDAO.excluir(curso, this)) {
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "MYCurrículo", 0);
        }
        mostrar(frame);
    }
    public void excluirVarios(int idIE){
        cursoDAO.excluirPorIdIE(idIE, this);
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public CursoDAO getCursoDAO() {
        return cursoDAO;
    }

    public void setCursoDAO(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public ControllerGerenciamento getControllerGerenciamento() {
        return controllerGerenciamento;
    }

    public void setControllerGerenciamento(ControllerGerenciamento controllerGerenciamento) {
        this.controllerGerenciamento = controllerGerenciamento;
    }

    public ControllerCursoUsuario getControllerCursoUsuario() {
        return controllerCursoUsuario;
    }

    public void setControllerCursoUsuario(ControllerCursoUsuario controllerCursoUsuario) {
        this.controllerCursoUsuario = controllerCursoUsuario;
    }

    public JFrameAlterarCurso getjFrameAlterarCurso() {
        return jFrameAlterarCurso;
    }

    public void setjFrameAlterarCurso(JFrameAlterarCurso jFrameAlterarCurso) {
        this.jFrameAlterarCurso = jFrameAlterarCurso;
    }

}
