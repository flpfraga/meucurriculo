/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EnderecoDAO;
import Model.Endereco;
import View.endereco.JFrameEndereco;
import View.usuario.JFrameGerenciarUsuario;
import java.awt.Frame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerEndereco  extends DefaultController{

    private JFrameEndereco jFrameEndereco = new JFrameEndereco();
    private JFrameGerenciarUsuario jFrameGerenciarUsuario;
    private Endereco endereco = new Endereco();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private ControllerUsuario controllerUsuario;

    public void novoCadastro(Frame frame){
        frame.setVisible(false);
        jFrameEndereco.setController(this);
        jFrameEndereco.setVisible(true);
    }
    public void persistir(Frame frame) {
        enderecoDAO.persistir(endereco, this);
        controllerUsuario.setControllerEndereco(this);
        controllerUsuario.persistir(frame);
        
    }
    public void mostrar(Frame frame) {
        frame.setVisible(false);
        endereco.setId(controllerUsuario.getUsuario().getId());
        endereco = enderecoDAO.set(endereco, this);
        jFrameEndereco.setController(this);
        jFrameEndereco.setParametros();
        jFrameEndereco.setEndJaCadastrado();
        jFrameEndereco.setVisible(true);
    }
    public void alterar (Frame frame){
        frame.setVisible(false);
        enderecoDAO.alterar(endereco, this);
        jFrameGerenciarUsuario.setControllerEndereco(this);
        jFrameGerenciarUsuario.setVisible(true);
    }
    public void mostrarPainelGerenciar(Frame frame){
        controllerUsuario.mostrarPainelGerenciar(frame);
    }
    public void setControllerUsuario(ControllerUsuario controllerUsuario){
        this.controllerUsuario = controllerUsuario;
    }
    public void setJFrameGerenciarUsuario(JFrameGerenciarUsuario jFrameGerenciarUsuario){
        this.jFrameGerenciarUsuario = jFrameGerenciarUsuario;
    }
     public void setEndereco(Endereco endereco){
         this.endereco = endereco;
     }
     
     public Endereco getEndereco(){
         return this.endereco;
     }
    public int getIdEndereco (){
        return enderecoDAO.retornoId(endereco, this);
    }
    
    public int confirmaInformacoes(){
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma os dados informados?", "MYCurrículo", 2);
        return opcao;
    }

    @Override
    public void incluir(Frame frame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
