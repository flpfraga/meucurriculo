/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InstituicaoEnsinoDAO;
import Model.InstituicaoEnsino;
import View.InstituicaoEnsino.JFrameAlterarInstituicao;
import View.InstituicaoEnsino.JFrameCadastrarInstituicao;

import View.gerenciamento.JFramePainelGerenciamento;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerInstituicaoEnsino extends DefaultController {

    private InstituicaoEnsino instituicaoEnsino;
    private InstituicaoEnsinoDAO instituicaoEnsinoDAO;
    private JFramePainelGerenciamento jFramePainelGerenciamento;

    private JFrameCadastrarInstituicao jFrameCadastrarInstituicao;
    private ControllerCurso controllerCurso;
    private JFrameAlterarInstituicao jFrameAlterarInstituicao;

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

    }

    public void persistir(Frame frame) {
        if (!instituicaoEnsinoDAO.jaExiste(instituicaoEnsino, this)) {
            frame.setVisible(false);
            getInstituicaoEnsinoDAO().persistir(getInstituicaoEnsino(), this);
            instituicaoEnsino = (InstituicaoEnsino) instituicaoEnsinoDAO.set(instituicaoEnsino, this);
            controllerCurso.getjFrameCadastrarCurso().setControllerInstituicaoEnsino(this);
            controllerCurso.getjFrameCadastrarCurso().posCadastroIE();
            controllerCurso.getjFrameCadastrarCurso().setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Instituição já cadastrada", "Erro!", 0);
        }
    }
    public void excluir(Frame frame) {
        frame.setVisible(false);
        if (instituicaoEnsinoDAO.excluir(instituicaoEnsino, this)) {
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "MYCurrículo", 0);
        }
        controllerCurso.getjFrameCadastrarCurso().setControllerInstituicaoEnsino(this);
        controllerCurso.getjFrameCadastrarCurso().setEnabled(true);
    }
    public void selecionar(Frame frame) {
        controllerCurso.getjFrameAlterarCurso().setControllerInstituicaoEnsino(this);
        controllerCurso.getjFrameAlterarCurso().posCadastroIE();
        controllerCurso.getjFrameAlterarCurso().setEnabled(true);
    }

    public void selecionarAlterar(Frame frame) {
        UIManager.put("OptionPane.yesButtonText", "Selecionar");
        UIManager.put("OptionPane.noButtonText", "Alterar");
        int opcao = JOptionPane.showConfirmDialog(null, "Selecione o que deseja fazer", "MYCurrículo", 0);
        instituicaoEnsino = (InstituicaoEnsino) instituicaoEnsinoDAO.set(instituicaoEnsino, this);
        if (opcao == 0) {
            controllerCurso.getjFrameCadastrarCurso().setControllerInstituicaoEnsino(this);
            controllerCurso.getjFrameCadastrarCurso().posCadastroIE();
            controllerCurso.getjFrameCadastrarCurso().setEnabled(true);
        } else if (opcao == 1) {
            frame.setEnabled(false);
            jFrameAlterarInstituicao = new JFrameAlterarInstituicao();
            jFrameAlterarInstituicao.setControllerInstituicaoEnsino(this);
            jFrameAlterarInstituicao.setParametro();
            jFrameAlterarInstituicao.setVisible(true);
        }
    }

    public void set() {
        instituicaoEnsino = (InstituicaoEnsino) instituicaoEnsinoDAO.set(instituicaoEnsino, this);
    }

    public void alterar(Frame frame) {
        frame.setVisible(false);
        instituicaoEnsinoDAO.alterar(instituicaoEnsino, controllerCurso);
        controllerCurso.getjFrameCadastrarCurso().setControllerInstituicaoEnsino(this);
        controllerCurso.getjFrameCadastrarCurso().posCadastroIE();
        controllerCurso.getjFrameCadastrarCurso().setEnabled(true);

    }

    public void voltar(Frame frame) {
        frame.setVisible(false);
        controllerCurso.getjFrameCadastrarCurso().setEnabled(true);
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
