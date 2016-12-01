/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DefaultController;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe Fraga
 */
public abstract class DefaultDAO {
    public DefaultController defaultController;
    
    public PreparedStatement ps = null;
    public abstract void persistir(Object object, DefaultController defaultController);
    
    public abstract void excluir(Object object, DefaultController defaultController);
    public abstract void alterar(Object object, DefaultController defaultController);
    public abstract DefaultTableModel mostrar(Object object, DefaultController defaultController);
    public abstract boolean jaExiste(Object object, DefaultController defaultController);
    public abstract Object set(Object object, DefaultController defaultController);
    
}
