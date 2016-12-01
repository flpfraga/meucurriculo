/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.ControllerCurso;
import Controller.DefaultController;
import Model.Curso;
import Model.CursoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class CursoUsuarioDAO extends DefaultDAO {

    private CursoUsuario cursoUsuario;

    public void persistir(Object object, DefaultController defaultController) {
        cursoUsuario = (CursoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT into cursousuario (idCurso, idUsuario, concluido, dataInicio, dataTermino, tipoSanduiche, instituicaoExtra) values (?,?,?,?,?,?,?)");
            ps.setInt(1, cursoUsuario.getIdCurso());
            ps.setInt(2, cursoUsuario.getIdUsuario());
            ps.setBoolean(3, cursoUsuario.isConcluido());
            ps.setString(4, cursoUsuario.getDataInicio());
            ps.setString(5, cursoUsuario.getDataTermino());
            ps.setBoolean(6, cursoUsuario.isTipoSanduiche());
            ps.setString(7, cursoUsuario.getInstituicaoExtra());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    
    public boolean excluir(Object object, DefaultController defaultController) {
        cursoUsuario = (CursoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE FROM cursoUsuario WHERE id =?");
            ps.setInt(1, cursoUsuario.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    @Override
    public void alterar(Object object, DefaultController defaultController) {
        cursoUsuario = (CursoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("UPDATE cursousuario set dataInicio = ?, dataTermino = ?, instituicaoExtra = ?, concluido = ?, tipoSanduiche = ?");
            ps.setString(1, cursoUsuario.getDataInicio());
            ps.setString(2, cursoUsuario.getDataTermino());
            ps.setString(3, cursoUsuario.getInstituicaoExtra());
            ps.setBoolean(4, cursoUsuario.isConcluido());
            ps.setBoolean(5, cursoUsuario.isTipoSanduiche());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    public ArrayList busca(int indice, DefaultController defaultController) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ?");
            ps.setInt(1, indice);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ControllerCurso controllerCurso = new ControllerCurso();
                lista.add(controllerCurso.buscarPorId(resultSet.getInt("idCurso")).getNome());
            }

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return lista;
    }

    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        cursoUsuario = (CursoUsuario) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome", "Tipo", "Início"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ?");
            ps.setInt(1, cursoUsuario.getIdUsuario());
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ControllerCurso controllerCurso = new ControllerCurso();
                Curso curso = controllerCurso.buscarPorId(resultSet.getInt("idCurso"));
                dtm.addRow(new String[]{curso.getNome(), curso.getTipo(), resultSet.getString("dataInicio")});
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    public boolean jaExiste(Object object, DefaultController defaultController) {
        cursoUsuario = (CursoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idCurso = ? and idUsuario = ? and dataInicio = ?");
            ps.setInt(1, cursoUsuario.getIdCurso());
            ps.setInt(2, cursoUsuario.getIdUsuario());
            ps.setString(3, cursoUsuario.getDataInicio());
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
        cursoUsuario = (CursoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ? and idCurso = ? and dataInicio = ?");
            ps.setInt(1, cursoUsuario.getIdUsuario());
            ps.setInt(2, cursoUsuario.getIdCurso());
            ps.setString(3, cursoUsuario.getDataInicio());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                cursoUsuario.setId(resultSet.getInt("id"));
                cursoUsuario.setDataTermino(resultSet.getString("dataTermino"));
                cursoUsuario.setConcluido(resultSet.getBoolean("concluido"));
                cursoUsuario.setTipoSanduiche(resultSet.getBoolean("tipoSanduiche"));
                cursoUsuario.setInstituicaoExtra(resultSet.getString("instituicaoExtra"));
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return cursoUsuario;
    }

}
