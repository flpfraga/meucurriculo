/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DefaultDAO;
import DAO.UsuarioDAO;
import Model.Endereco;
import Model.Usuario;

import View.usuario.JFrameCadastrarUsuario;
import View.usuario.JFrameGerenciarUsuario;
import View.usuario.JFrameLoginCadastro;

import java.awt.Frame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerUsuario extends DefaultController {
   
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private JFrameLoginCadastro jFrameLoginCadastro;
    private JFrameCadastrarUsuario jFrameCadastrarUsuario;
    private JFrameGerenciarUsuario jFrameGerenciarUsuario;
    private ControllerEndereco controllerEndereco;
    
    public ControllerUsuario(){
        this.usuarioDAO = new UsuarioDAO();
        this.usuario = new Usuario();
        this.jFrameLoginCadastro = new JFrameLoginCadastro();
    }
    public void painelLogin(Frame frame) {
        frame.setVisible(false);
        usuario = new Usuario();
        jFrameLoginCadastro.setControllerUsuario(this);
        jFrameLoginCadastro.setVisible(true);
    }

    public void novoCadastro(Frame frame) {
        jFrameLoginCadastro = (JFrameLoginCadastro) frame;
        if (getUsuarioDAO().jaExiste(usuario, this)) {
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado", "Erro!", 0);
            jFrameLoginCadastro.setNullParametros();
        } else {
            getUsuarioDAO().persistir(usuario, this);
            jFrameLoginCadastro.setVisible(false);
            jFrameCadastrarUsuario = new JFrameCadastrarUsuario();
            jFrameGerenciarUsuario = new JFrameGerenciarUsuario();
            controllerEndereco = new ControllerEndereco();
            jFrameGerenciarUsuario.setControllerEndereco(controllerEndereco);
            controllerEndereco.setJFrameGerenciarUsuario(jFrameGerenciarUsuario);
            jFrameCadastrarUsuario.setControllerEndereco(controllerEndereco);
            jFrameCadastrarUsuario.setControllerUsuario(this);
            jFrameCadastrarUsuario.setParametros();
            jFrameCadastrarUsuario.setVisible(true);
        }
    }

    public void persistir(Frame frame) {
        frame.setVisible(false);
        usuario.setIdEndereco(controllerEndereco.getIdEndereco());
        getUsuarioDAO().alterar(usuario, this);
        jFrameGerenciarUsuario.setControllerUsuario(this);
        jFrameGerenciarUsuario.setControllerEndereco(controllerEndereco);
        jFrameGerenciarUsuario.setVisible(true);
    }

    public void login(Frame frame) {
        if (getUsuarioDAO().verificaCadastro(usuario, this)) {
            frame.setVisible(false);
            jFrameGerenciarUsuario = new JFrameGerenciarUsuario();
            jFrameGerenciarUsuario.setControllerUsuario(this);
            usuario = getUsuarioDAO().set(usuario, controllerEndereco);
            jFrameGerenciarUsuario.setControllerEndereco(controllerEndereco);
            controllerEndereco.setJFrameGerenciarUsuario(jFrameGerenciarUsuario);
            jFrameCadastrarUsuario = new JFrameCadastrarUsuario();
            jFrameGerenciarUsuario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não encontrado", "Erro!-MYCurrículo", 0);
        }

    }

    public void mostrar(Frame frame) {
        frame.setVisible(false);
        usuario = getUsuarioDAO().set(usuario, this);
        jFrameCadastrarUsuario.setControllerUsuario(this);
        jFrameCadastrarUsuario.setParametros();
        jFrameCadastrarUsuario.setEndJaCadastrado();
        jFrameCadastrarUsuario.setVisible(true);
    }

    public void alterar(Frame frame) {
        frame.setVisible(false);
        getUsuarioDAO().alterar(usuario, this);
        jFrameGerenciarUsuario.setVisible(true);
    }

    public String alterarCpf(Frame frame) {
        if (usuario.getSenha().equals(JOptionPane.showInputDialog(null, "Digite sua senha", "Alterar CPF-MYCurrículo", 3))) {
            usuario = getUsuarioDAO().set(usuario, this);
            usuario.setCpf(JOptionPane.showInputDialog(null, "Digite o CPF", "Alterar CPF-MYCurrículo", 3));
            getUsuarioDAO().altearCpf(usuario, this);
        }else{
            JOptionPane.showMessageDialog(null, "Senha inválida","Alterar CPF-MYCurrículo",0 );
        }
        return usuario.getCpf();
    }
    public void mostrarPainelGerenciar(Frame frame){
        frame.setVisible(false);
        jFrameGerenciarUsuario.setVisible(true);
    }

    public void setControllerEndereco(ControllerEndereco controllerEndereco) {
        this.controllerEndereco = controllerEndereco;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void incluir(Frame frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void erroConexaoBD(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

}
