/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
import javax.swing.table.DefaultTableModel;
import Controller.DefaultController;
import Model.AtividadeExtra;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author User
 */
public class AtividadeExtraDAO extends DefaultDAO{
    
    AtividadeExtra atividadeExtra;
    @Override
    public void persistir(Object object, DefaultController defaultController) {
        atividadeExtra = (AtividadeExtra) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT into atividadeextra (id, idUsuario, nome, tipo, data, duracaoHoras) values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, atividadeExtra.getId());
            ps.setInt(2, atividadeExtra.getIdUsuario());
            ps.setString(3, atividadeExtra.getNome());
            ps.setString(4, atividadeExtra.getTipo());
            ps.setString(5, atividadeExtra.getData());
            ps.setInt(6, atividadeExtra.getDuracaoHoras());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public void excluir(Object object, DefaultController defaultController) {
        
    }

    @Override
    public void alterar(Object object, DefaultController defaultController) {
        atividadeExtra = (AtividadeExtra) object;
        System.out.println(atividadeExtra.getId());
        System.out.println(atividadeExtra.getNome());
        try{
            ps = Persistencia.conexao().prepareStatement("UPDATE atividadeextra set nome = ?, tipo = ?, data = ?, duracaoHoras = ? WHERE id = ?");
            ps.setString(1, atividadeExtra.getNome());
            ps.setString(2, atividadeExtra.getTipo());
            ps.setString(3, atividadeExtra.getData());
            ps.setInt(4, atividadeExtra.getDuracaoHoras());
            ps.executeUpdate();
        }catch (SQLException e){
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        atividadeExtra = (AtividadeExtra) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome", "Tipo", "Data", "Duração"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from atividadeextra WHERE idUsuario = ? and tipo like ?");
            ps.setInt(1, atividadeExtra.getIdUsuario());
            ps.setString(2, atividadeExtra.getTipo() + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dtm.addRow(new Object[]{resultSet.getString("nome"), resultSet.getString("tipo"), resultSet.getString("data"), resultSet.getInt("duracaoHoras")});
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        atividadeExtra = (AtividadeExtra) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from atividadeextra WHERE idUsuario = ? and tipo = ? and nome = ? and data = ?");
            ps.setInt(1, atividadeExtra.getIdUsuario());
            ps.setString(2, atividadeExtra.getTipo());
            ps.setString(3, atividadeExtra.getNome());
            ps.setString(4, atividadeExtra.getData());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    @Override
    public Object set(Object object, DefaultController defaultController) {
        atividadeExtra = (AtividadeExtra) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from atividadeextra WHERE idUsuario = ? and tipo = ? and  data = ? and nome = ?");
            ps.setInt(1, atividadeExtra.getIdUsuario());
            ps.setString(2, atividadeExtra.getTipo());
            ps.setString(3, atividadeExtra.getData());
            ps.setString(4, atividadeExtra.getNome());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                atividadeExtra.setId(resultSet.getInt("id"));
                atividadeExtra.setDuracaoHoras(resultSet.getInt("duracao"));
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return atividadeExtra;
    }
    
}
