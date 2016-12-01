/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import DAO.Persistencia;

import View.curso.JFrameVisualizarCursos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felipe Fraga
 */
public class Curso {

    private int id;
    private int idInstituicaoEnsino;
    private String nome;
    private String tipo;
    private String nomeInstituicao;
    Scanner scanner = new Scanner(System.in);
    private PreparedStatement ps = null;

    public Curso() {
        id = 0;
        idInstituicaoEnsino = 0;
        nome = "";
        tipo = "";
        nomeInstituicao = "";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstituicaoEnsino() {
        return idInstituicaoEnsino;
    }

    public void setIdInstituicaoEnsino(int idInstituicaoEnsino) {
        this.idInstituicaoEnsino = idInstituicaoEnsino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

}
