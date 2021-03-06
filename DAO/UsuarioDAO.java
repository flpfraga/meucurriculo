/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.ControllerUsuario;
import Controller.DefaultController;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class UsuarioDAO extends DefaultDAO {

    Usuario usuario;
    public UsuarioDAO(){
        usuario = new Usuario();
    }
    public void persistir(Object object, DefaultController defaultController) {
        usuario = (Usuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT INTO usuario (id, cpf, senha) values (?,?,?)");
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getSenha());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    public void excluir(Object object, DefaultController defaultController) {
        usuario = (Usuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE from usuario WHERE cpf = ?");
            ps.setString(1, usuario.getCpf());
            ps.executeUpdate();
            System.out.println("Cadastro excluido com sucesso");
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }

    }

    public void alterar(Object object, DefaultController defaultController) {
        usuario = (Usuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("UPDATE usuario set nome = ?, email = ?, sexo = ?, rg = ?, dataNascimento = ?, nomeMae = ?, nomePai = ?, idEndereco = ? WHERE cpf = ?");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSexo());
            ps.setString(4, usuario.getRg());
            ps.setString(5, usuario.getDataNascimento());
            ps.setString(6, usuario.getNomeMae());
            ps.setString(7, usuario.getNomePai());
            ps.setInt(8, usuario.getIdEndereco());
            ps.setString(9, usuario.getCpf());

            ps.executeUpdate();

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }


    public boolean jaExiste(Object object, DefaultController defaultController) {
        usuario = (Usuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, usuario.getCpf());
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

    public boolean verificaCadastro(Usuario usuario, ControllerUsuario controllerUsuario) {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ? and senha = ?");
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getSenha());
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                resultSet.close();
                return true;
            }
            resultSet.close();
        } catch (SQLException e) {
            controllerUsuario.erroConexaoBD(e);
        }
        return false;
    }
    public void altearCpf(Usuario usuario, DefaultController defaultController){
        try {
            ps = Persistencia.conexao().prepareStatement("UPDATE usuario set cpf = ? WHERE id = ?");
            ps.setString(1, usuario.getCpf());
            ps.setInt(2, usuario.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }
    public Usuario set(Object object, DefaultController defaultController) {
        usuario = (Usuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, usuario.getCpf());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSexo(resultSet.getString("sexo"));
                usuario.setRg(resultSet.getString("rg"));
                usuario.setDataNascimento(resultSet.getString("dataNascimento"));
                usuario.setNomePai(resultSet.getString("nomePai"));
                usuario.setNomeMae(resultSet.getString("nomeMae"));
                usuario.setIdEndereco(resultSet.getInt("idEndereco"));
                usuario.setNomeInstituicaoEM(resultSet.getString("nomeInstituicaoEM"));
            }

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return usuario;
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
