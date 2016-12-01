/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
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

    
    public void excluir(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void alterar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        instituicaoEnsino = (InstituicaoEnsino) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome", "Tipo"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome like ? and tipo"+tipo+" = ?");
            ps.setString(1, instituicaoEnsino.getNome() + "%");
            ps.setBoolean(2, true);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dtm.addRow(new Object[]{resultSet.getString("nome"), resultSet.getString("tipo"+tipo)});
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

    @Override
    public Object set(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
