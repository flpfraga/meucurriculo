
package DAO;

import Controller.DefaultController;
import Model.Profissao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ProfissaoDAO extends DefaultDAO {

    Profissao profissao;

    public void persistir(Object object, DefaultController defaultController) {
        profissao = (Profissao) object;
        try {
            ps = Classes.Persistencia.conexao().prepareStatement("INSERT into profissao (id, tipo) values (?, ?)");
            ps.setInt(1, profissao.getId());
            ps.setString(2, profissao.getTipo());
            ps.executeUpdate();
            System.out.println("Profissao cadastrada com sucesso");
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public void excluir(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void alterar(Object object, DefaultController defaultController) {
        profissao = (Profissao) object;
        System.out.println(profissao.getId());
        System.out.println(profissao.getTipo());
        try{
            ps = Persistencia.conexao().prepareStatement("UPDATE profissao set tipo = ? WHERE id = ?");
            ps.setString(1, profissao.getTipo());
            ps.setInt(7, profissao.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        profissao = (Profissao) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from profissao WHERE id = ? and tipo = ? ");
            ps.setInt(1, profissao.getId());
            ps.setString(2, profissao.getTipo());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    
    public Object set(Object object, DefaultController defaultController) {
        profissao = (Profissao) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from profissao WHERE id = ?");
            ps.setInt(1, profissao.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                profissao.setTipo(resultSet.getString("tipo"));
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return profissao;
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

