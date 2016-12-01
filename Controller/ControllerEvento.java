/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EventoDAO;
import Model.Evento;
import View.Evento.JFrameAlterarEvento;
import View.Evento.JFrameCadastrarEvento;
import View.Evento.JFrameVisualizarEventos;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerEvento extends DefaultController {
    private ControllerUsuario controllerUsuario;
    private Evento evento;
    private JFrameVisualizarEventos jFrameVisualizarEventos;
    private EventoDAO eventoDAO;
    private JFrameCadastrarEvento jFrameCadastrarEvento;
    private JFrameAlterarEvento jFrameAlterarEvento;

    public ControllerEvento() {
        eventoDAO = new EventoDAO();
    }

    public void incluir(Frame frame) {
        frame.setVisible(false);
        jFrameCadastrarEvento = new JFrameCadastrarEvento();
        jFrameCadastrarEvento.setControllerEvento(this);
        jFrameCadastrarEvento.setVisible(true);
    }

    public void mostrar(Frame frame) {
        frame.setVisible(false);
        jFrameVisualizarEventos = new JFrameVisualizarEventos();
        jFrameVisualizarEventos.setControllerEvento(this);
        jFrameVisualizarEventos.setVisible(true);
    }

    public DefaultTableModel atualizar() {
        return eventoDAO.mostrar(evento, this);
    }

    public void setEvento(Frame frame) {
        frame.setVisible(false);
        evento = (Evento) eventoDAO.set(evento, this);
        jFrameAlterarEvento = new JFrameAlterarEvento();
        jFrameAlterarEvento.setControllerEvento(this);
        jFrameAlterarEvento.setParametros();
        jFrameAlterarEvento.setVisible(true);
    }

    public void alterar(Frame frame) {
        if (eventoDAO.jaExiste(evento, this)) {
            JOptionPane.showMessageDialog(null, "Evento já cadastrado", "Erro!", 0);
        } else {
            frame.setVisible(false);
            System.out.println(evento.getId());
            System.out.println(evento.getNome());
            eventoDAO.alterar(evento, this);
            evento.setTipo("");
            jFrameVisualizarEventos.setjTableEvento(atualizar());
            jFrameVisualizarEventos.setControllerEvento(this);
            jFrameVisualizarEventos.setVisible(true);
        }
    }

    public void persistir(Frame frame) {
        frame.setVisible(false);
        eventoDAO.persistir(evento, this);
        jFrameVisualizarEventos.setVisible(true);
    }
    
    public void excluir (Frame frame){
        
    }
    public void voltarPainelEvento(Frame frame){
        frame.setVisible(false);
        jFrameVisualizarEventos.setVisible(true);
    }
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    public ControllerUsuario getControllerUsuario() {
        return controllerUsuario;
    }

    public void setControllerUsuario(ControllerUsuario controllerUsuario) {
        this.controllerUsuario = controllerUsuario;
    }
    public void voltarPainelGerenciarUsuario (Frame frame){
        controllerUsuario.mostrarPainelGerenciar(frame);
    }
}
