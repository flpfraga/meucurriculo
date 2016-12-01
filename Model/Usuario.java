/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import DAO.Persistencia;

import Controller.ControllerUsuario;
import View.sistema.JFrameBuscar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felipe Fraga
 */
public class Usuario {

    private int id;
    private String email;
    private String senha;
    private String nome;
    private String sexo;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String nomePai;
    private String nomeMae;
    private int idEndereco;
    private String nomeInstituicaoEM;
    private ControllerUsuario controllerUsuario;

    public Usuario() {
        this.cpf = "";
        this.dataNascimento = "";
        this.email = "";
        this.id = 0;
        this.nome = "";
        this.nomeMae = "";
        this.nomePai = "";
        this.rg = "";
        this.senha = "";
        this.sexo = "";
        this.nomeInstituicaoEM = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeInstituicaoEM() {
        return nomeInstituicaoEM;
    }

    public void setNomeInstituicaoEM(String nomeInstituicaoEM) {
        this.nomeInstituicaoEM = nomeInstituicaoEM;
    }

    public void impUsu() {
        System.out.println("nome " + nome);
        System.out.println("Id endereco " + idEndereco);
        System.out.println("cpf " + cpf);
    }
}
