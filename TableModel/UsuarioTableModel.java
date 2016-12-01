/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> linhas;
    private String[] colunas = new String[]{"ID","Nome", "CPF", "Email"};
    private final int nome = 0;
    private final int cpf = 1;
    private final int email = 2;
    private final int id = 3;
    

    public UsuarioTableModel() {
        linhas = new ArrayList<Usuario>();
    }

    public UsuarioTableModel(List<Usuario> listaUsuario) {
        linhas = new ArrayList<Usuario>(listaUsuario);
    }

    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        // Pega o sócio referente a linha especificada.
        Usuario usuario = linhas.get(rowIndex);

        switch (columnIndex) {
            case nome:
                return usuario.getNome();
            case cpf:
                return usuario.getCpf();
            case email:
                return usuario.getEmail();
            case id:
                return usuario.getId();
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case nome:
                return String.class;
            case cpf:
                return String.class;
            case email:
                return String.class;
            case id:
                return Integer.class;
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
}
