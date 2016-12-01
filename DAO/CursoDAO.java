/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
import Model.Curso;
import Model.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class CursoDAO extends DefaultDAO {

    Curso curso;

    @Override
    public void persistir(Object object, DefaultController defaultController) {
        curso = (Curso) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT into curso (nome, idInstituicaoEnsino, tipo, id) values (?,?,?,?)");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getIdInstituicaoEnsino());
            ps.setString(3, curso.getTipo());
            ps.setInt(4, curso.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public boolean excluir(Object object, DefaultController defaultController) {
        curso = (Curso) object;
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE FROM curso WHERE id = ?");
            ps.setInt(1, curso.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    public void excluirPorIdIE (int idIE, DefaultController defaultController){
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE * FROM curso WHERE idInstituicaoEnsino = ?");
            ps.setInt(1, idIE);
            ps.execute();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }
    public void alterar(Object object, DefaultController defaultController) {
        curso = (Curso) object;
        try {
            ps = Persistencia.conexao().prepareStatement("UPDATE curso set nome = ?, idInstituicaoEnsino = ?, tipo = ? WHERE id = ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getIdInstituicaoEnsino());
            ps.setString(3, curso.getTipo());
            ps.setInt(4, curso.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        curso = (Curso) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome", "Tipo", "Instituição de Ensino"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from curso WHERE nome like ? or tipo like ?");
            ps.setString(1, curso.getNome() + "%");
            ps.setString(2, curso.getTipo() + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dtm.addRow(new Object[]{resultSet.getString("nome"), resultSet.getString("tipo"), resultSet.getInt("idInstituicaoEnsino")});
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    public Curso buscar(int indice, DefaultController defaultController) {
        Curso curso = new Curso();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from curso WHERE id = ?");
            ps.setInt(1, indice);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                curso.setNome(resultSet.getString("nome"));
                curso.setTipo(resultSet.getString("tipo"));

            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return curso;
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        curso = (Curso) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from curso WHERE nome = ? and idInstituicaoEnsino = ? and tipo = ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getIdInstituicaoEnsino());
            ps.setString(3, curso.getTipo());
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
        curso = (Curso) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from curso WHERE nome = ? and tipo = ?");
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getTipo());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                curso.setId(resultSet.getInt("id"));
                curso.setIdInstituicaoEnsino(resultSet.getInt("idInstituicaoEnsino"));
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return curso;
    }

}
