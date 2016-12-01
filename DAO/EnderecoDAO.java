/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.ControllerEndereco;
import Controller.DefaultController;
import Model.Endereco;
import Model.Evento;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class EnderecoDAO extends DefaultDAO {

    Endereco endereco;

    @Override
    public void persistir(Object object, DefaultController defaultController) {
        endereco = (Endereco) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT INTO endereco (id, rua, bairro, num, cidade, cep, brasil, paisEstrangeiro, uf, comp) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, endereco.getId());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getNum());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getCep());
            ps.setBoolean(7, endereco.isBrasil());
            ps.setString(8, endereco.getPaisEstrangeiro());
            ps.setString(9, endereco.getUf());
            ps.setString(10, endereco.getComp());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    public int retornoId(Endereco endereco, ControllerEndereco controllerEndereco) {

        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco WHERE rua = ? and bairro = ? and num = ? and cidade = ?");
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getBairro());
            ps.setString(3, endereco.getNum());
            ps.setString(4, endereco.getCidade());
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                endereco.setId(resultSet.getInt("id"));
            }
            resultSet.close();
        } catch (SQLException e) {
            controllerEndereco.erroConexaoBD(e);
        }
        return endereco.getId();
    }

    public boolean excluir(Object object, DefaultController defaultController) {
        endereco = (Endereco) object;
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE FROM endereco WHERE id = ?");
            ps.setInt(1, endereco.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    public void alterar(Object object, DefaultController defaultController) {
        endereco = (Endereco) object;
        try {
            ps = Persistencia.conexao().prepareStatement("UPDATE endereco set rua = ?, bairro = ?, num = ?, cidade = ?, cep = ?, brasil = ?, paisEstrangeiro = ?, uf = ?, comp = ? WHERE id = ?");
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getBairro());
            ps.setString(3, endereco.getNum());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getCep());
            ps.setBoolean(6, endereco.isBrasil());
            ps.setString(7, endereco.getPaisEstrangeiro());
            ps.setString(8, endereco.getUf());
            ps.setString(9, endereco.getComp());
            ps.setInt(10, endereco.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    public boolean jaExisteId(int id, ControllerEndereco controllerEndereco) {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();

        } catch (SQLException e) {
            controllerEndereco.erroConexaoBD(e);
        }
        return false;
    }

    public boolean jaExiste(Object object, DefaultController defaultController) {
        endereco = (Endereco) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco WHERE id=?");
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getBairro());
            ps.setString(3, endereco.getCidade());
            ps.setString(4, endereco.getNum());
            ps.setString(5, endereco.getCep());
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    public Endereco set(Object object, DefaultController defaultController) {
        endereco = (Endereco) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco WHERE id = ?");
            ps.setInt(1, endereco.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                endereco.setId(resultSet.getInt("id"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setBairro(resultSet.getString("bairro"));
                endereco.setNum(resultSet.getString("num"));
                endereco.setCidade(resultSet.getString("cidade"));
                endereco.setCep(resultSet.getString("cep"));
                endereco.setBrasil(resultSet.getBoolean("brasil"));
                endereco.setPaisEstrangeiro(resultSet.getString("paisEstrangeiro"));
            }
            resultSet.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return endereco;
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
