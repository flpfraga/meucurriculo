/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AtividadeExtraDAO;
import Model.AtividadeExtra;
import View.AtividadeExtra.JFrameAlterarAtividadeExtra;
import View.AtividadeExtra.JFrameCadastrarAtividadeExtra;
import View.AtividadeExtra.JFrameVisualizarAtividadeExtra;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Frame;

/**
 *
 * @author User
 */
public class ControllerAtividadeExtra extends DefaultController{
    
    private ControllerUsuario controllerUsuario;
    private AtividadeExtra atividadeExtra;
    private JFrameVisualizarAtividadeExtra jFrameVisualizarAtividadeExtra;
    private AtividadeExtraDAO atividadeExtraDAO;
    private JFrameCadastrarAtividadeExtra jFrameCadastrarAtividadeExtra;
    private JFrameAlterarAtividadeExtra jFrameAlterarAtividadeExtra;
    
    public void alterar(Frame frame) {
        if (atividadeExtraDAO.jaExiste(atividadeExtra, this)) {
            JOptionPane.showMessageDialog(null, "Ativida Extra já cadastrada", "Erro!", 0);
        } else {
            frame.setVisible(false);
            System.out.println(atividadeExtra.getId());
            System.out.println(atividadeExtra.getNome());
            atividadeExtraDAO.alterar(atividadeExtra, this);
            atividadeExtra.setTipo("");
            jFrameVisualizarAtividadeExtra.setjTableAtividadeExtra(atualizar());
            jFrameVisualizarAtividadeExtra.setControllerAtividadeExtra(this);
            jFrameVisualizarAtividadeExtra.setVisible(true);
        }
    }
    
    public DefaultTableModel atualizar() {
        return atividadeExtraDAO.mostrar(atividadeExtra, this);
    }
    
    @Override
    public void incluir(Frame frame) {
        frame.setVisible(false);
        setjFrameCadastrarAtividadeExtra(new JFrameCadastrarAtividadeExtra());
        getjFrameCadastrarAtividadeExtra().setControllerAtividadeExtra(this);
        getjFrameCadastrarAtividadeExtra().setVisible(true);
    }

    @Override
    public void mostrar(Frame frame) {
        frame.setVisible(false);
        setjFrameVisualizarAtividadeExtra(new JFrameVisualizarAtividadeExtra());
        getjFrameVisualizarAtividadeExtra().setControllerAtividadeExtra(this);
        getjFrameVisualizarAtividadeExtra().setVisible(true);
    }

    @Override
    public void persistir(Frame frame) {
        frame.setVisible(false);
        getAtividadeExtraDAO().persistir(getAtividadeExtra(), this);
        getjFrameVisualizarAtividadeExtra().setVisible(true);
    }

    
    public ControllerUsuario getControllerUsuario() {
        return controllerUsuario;
    }
    public void setControllerUsuario(ControllerUsuario controllerUsuario) {
        this.controllerUsuario = controllerUsuario;
    }
    public AtividadeExtra getAtividadeExtra() {
        return atividadeExtra;
    }
    public void setAtividadeExtra(AtividadeExtra atividadeExtra) {
        this.atividadeExtra = atividadeExtra;
    }
    public JFrameVisualizarAtividadeExtra getjFrameVisualizarAtividadeExtra() {
        return jFrameVisualizarAtividadeExtra;
    }
    public void setjFrameVisualizarAtividadeExtra(JFrameVisualizarAtividadeExtra jFrameVisualizarAtividadeExtra) {
        this.jFrameVisualizarAtividadeExtra = jFrameVisualizarAtividadeExtra;
    }
    public AtividadeExtraDAO getAtividadeExtraDAO() {
        return atividadeExtraDAO;
    }
    public void setAtividadeExtraDAO(AtividadeExtraDAO atividadeExtraDAO) {
        this.atividadeExtraDAO = atividadeExtraDAO;
    }
    public JFrameCadastrarAtividadeExtra getjFrameCadastrarAtividadeExtra() {
        return jFrameCadastrarAtividadeExtra;
    }
    public void setjFrameCadastrarAtividadeExtra(JFrameCadastrarAtividadeExtra jFrameCadastrarAtividadeExtra) {
        this.jFrameCadastrarAtividadeExtra = jFrameCadastrarAtividadeExtra;
    }
    public JFrameAlterarAtividadeExtra getjFrameAlterarAtividadeExtra() {
        return jFrameAlterarAtividadeExtra;
    }
    public void setjFrameAlterarAtividadeExtra(JFrameAlterarAtividadeExtra jFrameAlterarAtividadeExtra) {
        this.jFrameAlterarAtividadeExtra = jFrameAlterarAtividadeExtra;
    }
    public void voltarPainelGerenciarUsuario (Frame frame){
        controllerUsuario.mostrarPainelGerenciar(frame);
    }
    public void voltarPainelAtividadeExtra(Frame frame){
        frame.setVisible(false);
        jFrameVisualizarAtividadeExtra.setVisible(true);
    }
    
}
