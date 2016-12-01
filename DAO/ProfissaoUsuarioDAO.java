/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProfissaoUsuario;
import Controller.DefaultController;
import Model.Evento;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ProfissaoUsuarioDAO extends DefaultDAO{
    
    ProfissaoUsuario profissaoUsuario;

    @Override
    public void persistir(Object object, DefaultController defaultController) {
        profissaoUsuario = (ProfissaoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT INTO profissaousuario (id, idProfissao, idUsuario, localAtuação, emAtividade, dataInicio, dataTermino) values (?,?,?,?,?,?,?)");
            ps.setInt(1, profissaoUsuario.getId());
            ps.setInt(2, profissaoUsuario.getIdProfissao());
            ps.setInt(3, profissaoUsuario.getIdUsuario());
            ps.setString(4, profissaoUsuario.getLocalAtuacao());
            ps.setBoolean(5, profissaoUsuario.isEmAtividade());
            ps.setString(6, profissaoUsuario.getDataInicio());
            ps.setString(7, profissaoUsuario.getDataTermino());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public void excluir(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Object object, DefaultController defaultController) {
        profissaoUsuario = (ProfissaoUsuario) object;
        System.out.println(profissaoUsuario.getId());
        try{
            ps = Persistencia.conexao().prepareStatement("UPDATE profissaoUsuario set localAtuação = ?, emAtividade = ?, dataInicio = ?, dataTermino = ? WHERE id = ?");
            ps.setString(1, profissaoUsuario.getLocalAtuacao());
            ps.setBoolean(2, profissaoUsuario.isEmAtividade());
            ps.setString(3, profissaoUsuario.getDataInicio());
            ps.setString(4, profissaoUsuario.getDataTermino());
            ps.setInt(5, profissaoUsuario.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            defaultController.erroConexaoBD(e);
        }
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        profissaoUsuario = (ProfissaoUsuario) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Tipo", "Local Atuação", "Em Atividade", "Data Inicio", "Data Termino"}, 0);
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from profissaoUsuario WHERE idUsuario = ? and idProfissao like ?");
            ps.setInt(1, profissaoUsuario.getIdUsuario());
            ps.setInt(2, profissaoUsuario.getIdProfissao());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dtm.addRow(new Object[]{resultSet.getString("tipo"), resultSet.getString("localAtuação"), resultSet.getString("emAtividade"), resultSet.getString("dataInicio"), resultSet.getString("dataTermino")});
            }
        } catch (SQLException e) {
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        profissaoUsuario = (ProfissaoUsuario) object;
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * from profissaoUsuario WHERE idUsuario = ? and localAtuação = ? and emAtividade = ? and dataInicio = ? and dataTermino = ?");
            ps.setInt(1, profissaoUsuario.getIdUsuario());
            ps.setString(2, profissaoUsuario.getLocalAtuacao());
            ps.setBoolean(3, profissaoUsuario.isEmAtividade());
            ps.setString(4, profissaoUsuario.getDataInicio());
            ps.setString(5, profissaoUsuario.getDataTermino());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
