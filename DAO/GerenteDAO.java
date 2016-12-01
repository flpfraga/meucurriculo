/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
import Controller.ControllerGerenciamento;
import Model.Endereco;
import Model.Gerente;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class GerenteDAO extends DefaultDAO {
    
    private Gerente gerente;
    
    
    public void persistir(Object object, DefaultController defaultController) {
        gerente  = (Gerente) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT INTO gerente (id, login, senha) values (?,?,?)");
            ps.setInt(1, gerente.getId());
            ps.setString(2, gerente.getLogin());
            ps.setString(3, gerente.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    public boolean verificaCadastro (Object object, DefaultController defaultController){
        gerente = (Gerente) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM gerente WHERE login = ? and senha = ?");
            ps.setString(1, gerente.getLogin());
            ps.setString(2, gerente.getSenha());
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                resultSet.close();
                return true;
            }
            resultSet.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }
    public boolean excluir(Object object, DefaultController defaultController) {
        gerente = (Gerente) object;
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE FROM gerente WHERE id = ?");
            ps.setInt(1, gerente.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    @Override
    public void alterar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
