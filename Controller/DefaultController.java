/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DefaultDAO;
import java.awt.Frame;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public abstract class DefaultController {
    private ControllerEndereco controllerEndereco;
    public abstract void incluir(Frame frame);

    public abstract void mostrar(Frame frame);
    
    public abstract void persistir(Frame frame);
    
    public void erroConexaoBD(SQLException e){
        JOptionPane.showMessageDialog(null,"Erro no sistema " +e, "Erro! - MYCurriculo",0);
    }
    public int confirmaInformacoes() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma os dados informados?", "MYCurrículo", 2);
        return opcao;
    }
}
