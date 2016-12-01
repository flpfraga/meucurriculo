/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
import Model.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class EventoDAO extends DefaultDAO {

    Evento evento;

    public void persistir(Object object, DefaultController defaultController) {
        evento = (Evento) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT INTO evento (id, nome, tipo, data, nomeTrabalho, idUsuario, duracao, local) values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, evento.getId());
            ps.setString(2, evento.getNome());
            ps.setString(3, evento.getTipo());
            ps.setString(4, evento.getData());
            ps.setString(5, evento.getNomeTrabalho());
            ps.setInt(6, evento.getIdUsuario());
            ps.setString(7, evento.getDuracaoHoras());
            ps.setString(8, evento.getLocal());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    
    public boolean excluir(Object object, DefaultController defaultController) {
        evento = (Evento) object;
        try{
            ps = Persistencia.conexao().prepareStatement("DELETE FROM evento WHERE id = ?");
            ps.setInt(1, evento.getId());
            ps.execute();
            return true;
       } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return false;
    }

    
    public void alterar(Object object, DefaultController defaultController) {
        evento = (Evento) object;
        System.out.println(evento.getId());
        System.out.println(evento.getNome());
        try{
            ps = Persistencia.conexao().prepareStatement("UPDATE evento set nome = ?, tipo = ?, data = ?, nomeTrabalho = ?, duracao = ?, local = ? WHERE id = ?");
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getTipo());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getNomeTrabalho());
            ps.setString(5, evento.getDuracaoHoras());
            ps.setString(6, evento.getLocal());
            ps.setInt(7, evento.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            defaultController.erroConexaoBD(e);
        }
    }

    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        evento = (Evento) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome", "Tipo", "Data", "Duração"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from evento WHERE idUsuario = ? and tipo like ?");
            ps.setInt(1, evento.getIdUsuario());
            ps.setString(2, evento.getTipo() + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dtm.addRow(new Object[]{resultSet.getString("nome"), resultSet.getString("tipo"), resultSet.getString("data"), resultSet.getString("duracao")});
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        evento = (Evento) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from evento WHERE idUsuario = ? and tipo = ? and  data = ? and nome = ?");
            ps.setInt(1, evento.getIdUsuario());
            ps.setString(2, evento.getTipo());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getNome());
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
        evento = (Evento) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from evento WHERE idUsuario = ? and tipo = ? and  data = ? and nome = ?");
            ps.setInt(1, evento.getIdUsuario());
            ps.setString(2, evento.getTipo());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getNome());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                evento.setId(resultSet.getInt("id"));
                evento.setNomeTrabalho(resultSet.getString("nomeTrabalho"));
                evento.setDuracaoHoras(resultSet.getString("duracao"));
                evento.setLocal(resultSet.getString("local"));

            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return evento;
    }

}
