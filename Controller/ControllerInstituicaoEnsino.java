/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InstituicaoEnsinoDAO;
import Model.InstituicaoEnsino;
import View.InstituicaoEnsino.JFrameCadastrarInstituicao;
import View.InstituicaoEnsino.JFrameMostraInstituicoes;
import View.gerenciamento.JFramePainelGerenciamento;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerInstituicaoEnsino extends DefaultController {

    private InstituicaoEnsino instituicaoEnsino;
    private InstituicaoEnsinoDAO instituicaoEnsinoDAO;
    private JFramePainelGerenciamento jFramePainelGerenciamento;
    private JFrameMostraInstituicoes jFrameMostraInstituicoes;
    private JFrameCadastrarInstituicao jFrameCadastrarInstituicao; 
    private ControllerCurso controllerCurso;
    
    public ControllerInstituicaoEnsino() {
        instituicaoEnsino = new InstituicaoEnsino();
        instituicaoEnsinoDAO = new InstituicaoEnsinoDAO();
    }

    public void incluir(Frame frame) {
        frame.setEnabled(false);
        jFrameCadastrarInstituicao = new JFrameCadastrarInstituicao();
        jFrameCadastrarInstituicao.setControllerInstituicaoEnsino(this);
        jFrameCadastrarInstituicao.setVisible(true);
    }

    public DefaultTableModel atualizar() {
        return getInstituicaoEnsinoDAO().mostrar(instituicaoEnsino, this);
    }

    public void mostrar(Frame frame) {
        jFrameMostraInstituicoes = new JFrameMostraInstituicoes();
        jFrameMostraInstituicoes.setjTableIE(getInstituicaoEnsinoDAO().mostrar(getInstituicaoEnsino(), this));
        jFrameMostraInstituicoes.setVisible(true);
    }

    public void persistir(Frame frame) {
        if (!instituicaoEnsinoDAO.jaExiste(instituicaoEnsino, this)) {
            frame.setVisible(false);
            getInstituicaoEnsinoDAO().persistir(getInstituicaoEnsino(), this);
            controllerCurso.getjFrameCadastrarCurso().setControllerInstituicaoEnsino(this);
            controllerCurso.getjFrameCadastrarCurso().setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Instituição já cadastrada", "Erro!", 0);
        }
    }

    public InstituicaoEnsino getIntituicaoEnsino() {
        return getInstituicaoEnsino();
    }

    public void setInstituicaoEnsino(InstituicaoEnsino intituicaoEnsino) {
        this.instituicaoEnsino = intituicaoEnsino;
    }

    public DefaultTableModel mostrarNome(DefaultTableModel dtm) {
        dtm = getInstituicaoEnsinoDAO().mostrarNome(this, dtm);
        return dtm;
    }

    public InstituicaoEnsino getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public InstituicaoEnsinoDAO getInstituicaoEnsinoDAO() {
        return instituicaoEnsinoDAO;
    }

    public void setInstituicaoEnsinoDAO(InstituicaoEnsinoDAO instituicaoEnsinoDAO) {
        this.instituicaoEnsinoDAO = instituicaoEnsinoDAO;
    }

    public ControllerCurso getControllerCurso() {
        return controllerCurso;
    }

    public void setControllerCurso(ControllerCurso controllerCurso) {
        this.controllerCurso = controllerCurso;
    }
}
