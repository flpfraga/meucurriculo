/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import DAO.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felipe Fraga
 */
public class CursoUsuario {

    private int id;
    private int idUsuario;
    private int idCurso;
    private boolean concluido;
    private String dataInicio;
    private String dataTermino;
    private boolean tipoSanduiche;
    private String instituicaoExtra;
    private PreparedStatement ps = null;
    private Scanner scanner = new Scanner(System.in);

    public CursoUsuario() {
        id = 0;
        idCurso = 0;
        concluido = false;
        dataInicio = "";
        dataTermino = "";
        tipoSanduiche = false;
        instituicaoExtra = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public boolean isTipoSanduiche() {
        return tipoSanduiche;
    }

    public void setTipoSanduiche(boolean tipoSanduiche) {
        this.tipoSanduiche = tipoSanduiche;
    }

    public String getInstituicaoExtra() {
        return instituicaoExtra;
    }

    public void setInstituicaoExtra(String instituicaoExtra) {
        this.instituicaoExtra = instituicaoExtra;
    }

}
