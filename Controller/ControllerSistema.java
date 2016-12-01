/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.sistema.JFramePrincipal;
import java.awt.Frame;

/**
 *
 * @author Felipe Fraga
 */
public class ControllerSistema {
    
    private JFramePrincipal jFramePrincipal;
    
    
    public void iniciar (){
        jFramePrincipal = new JFramePrincipal();
        jFramePrincipal.setControllerSistema(this);
        jFramePrincipal.setVisible(true);
    }
    public void iniciar (Frame frame){
        frame.setVisible(false);
        jFramePrincipal = new JFramePrincipal();
        jFramePrincipal.setControllerSistema(this);
        jFramePrincipal.setVisible(true);
    }
    
}
