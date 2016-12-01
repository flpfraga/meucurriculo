/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
import Model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class CursoDAO extends DefaultDAO{
    Curso curso;

    @Override
    public void persistir(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrar(Object object, DefaultController defaultController) {
        curso = (Curso) object;
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Nome","Tipo","Instituição de Ensino"},0);
        try{
            ps = Persistencia.conexao().prepareStatement("SELECT * from curso");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                dtm.addRow(new Object[]{resultSet.getString("nome"), resultSet.getString("tipo"),resultSet.getInt("idInstituicaoEnsino")});
            }
        }catch(SQLException e){
            defaultController.erroConexaoBD(e);
        }
        return dtm;
    }

    @Override
    public boolean jaExiste(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(Object object, DefaultController defaultController) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
