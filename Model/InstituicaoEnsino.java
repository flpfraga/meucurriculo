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
public class InstituicaoEnsino {

    private int id;
    private String nome;
    private int idEndereco;
    private boolean tipoMedio;
    private boolean tipoSuperior;
    private boolean tipoTecnico;
    private boolean tipoMestrado;
    private boolean tipoDoutorado;
    private boolean tipoPhd;
    private String local;

    public void InstitucaoEnsino() {
        setId(0);
        setNome("");
        setIdEndereco(0);
        setTipoDoutorado(false);
        setTipoMedio(false);
        setTipoTecnico(false);
        setTipoSuperior(false);
        setTipoMestrado(false);
        setTipoPhd(false);
        setLocal("");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public boolean isTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(boolean tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

    public boolean isTipoSuperior() {
        return tipoSuperior;
    }

    public void setTipoSuperior(boolean tipoSuperior) {
        this.tipoSuperior = tipoSuperior;
    }

    public boolean isTipoTecnico() {
        return tipoTecnico;
    }

    public void setTipoTecnico(boolean tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }

    public boolean isTipoMestrado() {
        return tipoMestrado;
    }

    public void setTipoMestrado(boolean tipoMestrado) {
        this.tipoMestrado = tipoMestrado;
    }

    public boolean isTipoDoutorado() {
        return tipoDoutorado;
    }

    public void setTipoDoutorado(boolean tipoDoutorado) {
        this.tipoDoutorado = tipoDoutorado;
    }

    public boolean isTipoPhd() {
        return tipoPhd;
    }

    public void setTipoPhd(boolean tipoPhd) {
        this.tipoPhd = tipoPhd;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}
