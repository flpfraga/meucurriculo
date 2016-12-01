/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.ControllerCurso;
import Controller.DefaultController;
import Model.Endereco;
import Model.InstituicaoEnsino;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class InstituicaoEnsinoDAO extends DefaultDAO {

    private InstituicaoEnsino instituicaoEnsino;
    private String tipo;
    
    public void persistir(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        try{
            ps = Persistencia.conexao().prepareStatement("INSERT into instituicaoensino (id, nome, local, tipo"+tipo+") values (?,?,?,?)");
            ps.setInt(1, instituicaoEnsino.getId());
            ps.setString(2, instituicaoEnsino.getNome());
            ps.setString(3, instituicaoEnsino.getLocal());
            ps.setBoolean(4, true);
            ps.execute();
            ps.close();
        }catch(SQLException e){
            defaultController.erroConexaoBD(e);
        }
    }

    
    public boolean excluir(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE FROM instituicaoEnsino WHERE id = ?");
            ps.setInt(1, instituicaoEnsino.getId());
            ps.execute();
            ControllerCurso controllerCurso = new ControllerCurso();
            controllerCurso.excluirVarios(instituicaoEnsino.getId());
            return true;
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    
    public void alterar(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        try{
            ps = Persistencia.conexao().prepareStatement("UPDATE instituicaoensino set nome = ?, local = ?, tipoMedio = ?, tipoTecnico = ?, tipoSuperior = ?, tipoMestrado = ?, tipoDoutorado = ?, tipoPhd = ? WHERE id = ?");
            ps.setString(1, instituicaoEnsino.getNome());
            ps.setString(2, instituicaoEnsino.getLocal());
            ps.setBoolean(3, instituicaoEnsino.isTipoMedio());
            ps.setBoolean(4, instituicaoEnsino.isTipoTecnico());
            ps.setBoolean(5, instituicaoEnsino.isTipoSuperior());
            ps.setBoolean(6, instituicaoEnsino.isTipoMestrado());
            ps.setBoolean(7, instituicaoEnsino.isTipoDoutorado());
            ps.setBoolean(8, instituicaoEnsino.isTipoPhd());
            ps.setInt(9, instituicaoEnsino.getId());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            defaultController.erroConexaoBD(e);
        }
    }

    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome", "Local"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome like ? and tipo"+tipo+" = ?");
            ps.setString(1, instituicaoEnsino.getNome() + "%");
            ps.setBoolean(2, true);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dtm.addRow(new Object[]{resultSet.getString("nome"), resultSet.getString("local")});
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    public DefaultTableModel mostrarNome(DefaultController defaultController, DefaultTableModel dtm) {
        
        int tam = dtm.getRowCount();
        for (int c = 0; c < tam; c++) {
            try {
                ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE id = ?");
                ps.setInt(1, (int) dtm.getValueAt(c, 2));

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    dtm.setValueAt(resultSet.getString("nome"),c,2);
                }
            } catch (SQLException e) {
                defaultController.erroConexaoBD(e);
            }
        }

        return dtm;
    }

    public boolean jaExiste(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome = ?");
            ps.setString(1, instituicaoEnsino.getNome());
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
    public Object set(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome like ? and tipo"+tipo+" = ?");
            ps.setString(1, instituicaoEnsino.getNome() + "%");
            ps.setBoolean(2, true);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                instituicaoEnsino.setId(resultSet.getInt("id"));
                instituicaoEnsino.setNome(resultSet.getString("nome"));
                instituicaoEnsino.setLocal(resultSet.getString("local"));
                instituicaoEnsino.setTipoMedio(resultSet.getBoolean("tipoMedio"));
                instituicaoEnsino.setTipoTecnico(resultSet.getBoolean("tipoTecnico"));
                instituicaoEnsino.setTipoSuperior(resultSet.getBoolean("tipoSuperior"));
                instituicaoEnsino.setTipoMestrado(resultSet.getBoolean("tipoMestrado"));
                instituicaoEnsino.setTipoDoutorado(resultSet.getBoolean("tipoDoutorado"));
                instituicaoEnsino.setTipoPhd(resultSet.getBoolean("tipoPhd"));
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return instituicaoEnsino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
