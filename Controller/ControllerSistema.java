/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.sistema.JFrameBuscar;
import View.sistema.JFrameDescricaoCompleta;
import View.sistema.JFramePrincipal;
import java.awt.Frame;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerSistema {

    private JFramePrincipal jFramePrincipal;
    private ControllerUsuario controllerUsuario;
    private ControllerCursoUsuario controllerCursoUsuario;
    private ControllerProfissao controllerProfissao;
    private JFrameBuscar jFrameBuscar;
    private JFrameDescricaoCompleta jFrameDescricaoCompleta;

    public ControllerSistema() {
        controllerUsuario = new ControllerUsuario();
        controllerCursoUsuario = new ControllerCursoUsuario();
        controllerProfissao = new ControllerProfissao();
        jFrameDescricaoCompleta = new JFrameDescricaoCompleta();
    }

    public void iniciar() {
        jFramePrincipal = new JFramePrincipal();
        jFramePrincipal.setControllerSistema(this);
        jFramePrincipal.setControllerUsuario(controllerUsuario);
        jFramePrincipal.setVisible(true);
    }

    public void iniciar(Frame frame) {
        frame.setVisible(false);
        jFramePrincipal = new JFramePrincipal();
        jFramePrincipal.setControllerSistema(this);
        jFramePrincipal.setVisible(true);
    }

    public void buscar(Frame frame) {
        frame.setVisible(false);
        jFrameBuscar = new JFrameBuscar();
        jFrameBuscar.setControllerSistema(this);
        jFrameBuscar.setControllerProfissao(controllerProfissao);
        jFrameBuscar.setControllerCursoUsuario(controllerCursoUsuario);
        jFrameBuscar.setControllerUsuario(controllerUsuario);
        jFrameBuscar.setVisible(true);
    }

}
