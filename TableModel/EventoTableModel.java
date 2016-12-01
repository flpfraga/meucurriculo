/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Model.Evento;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Felipe Fraga
 */
public class EventoTableModel extends AbstractTableModel {

    private List<Evento> linhas;
    private String[] colunas = new String[]{"ID", "Nome", "Tipo", "Data", "Duração"};
    private final int nome = 0;
    private final int tipo = 1;
    private final int data = 2;
    private final int duracao = 3;
    private final int id = 4;

    public EventoTableModel() {
        linhas = new ArrayList<Evento>();
    }

    public EventoTableModel(List<Evento> listaUsuario) {
        linhas = new ArrayList<Evento>(listaUsuario);
    }

    public int getRowCount() {
        return linhas.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        // Pega o sócio referente a linha especificada.
        Evento evento = linhas.get(rowIndex);

        switch (columnIndex) {
            case nome:
                return evento.getNome();
            case tipo:
                return evento.getTipo();
            case data:
                return evento.getData();
            case duracao:
                return evento.getDuracaoHoras();
            case id:
                return evento.getId();
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
            case tipo:
                return String.class;
            case data:
                return String.class;
            case duracao:
                return String.class;
            case id:
                return Integer.class;
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    // Retorna o sócio referente a linha especificada

    public Evento getSocio(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

// Adiciona o sócio especificado ao modelo
    public void addEvento(Evento evento) {
        // Adiciona o registro.
        linhas.add(evento);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

// Remove o sócio da linha especificada.
    public void removeSocio(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

// Adiciona uma lista de sócios no final da lista.
    public void addListaDeSocios(List<Evento> socios) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(socios);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + socios.size());
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
