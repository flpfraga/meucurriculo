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
public class Endereco {

    private int id;
    private String rua;
    private String bairro;
    private String num;
    private String cidade;
    private String cep;
    private boolean brasil;
    private String paisEstrangeiro;
    private String uf;
    private String comp;
    private Scanner scanner = new Scanner(System.in);
    private PreparedStatement ps = null;

    public Endereco() {
        id = -0;
        rua = "";
        bairro = "";
        num = "";
        cidade = "";
        cep = "";
        brasil = true;
        paisEstrangeiro = "";
        uf = "";
        comp = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isBrasil() {
        return brasil;
    }

    public void setBrasil(boolean brasil) {
        this.brasil = brasil;
    }

    public String getPaisEstrangeiro() {
        return paisEstrangeiro;
    }

    public void setPaisEstrangeiro(String paisEstrangeiro) {
        this.paisEstrangeiro = paisEstrangeiro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public void impENd() {

        System.out.print("Rua: " + rua);

        System.out.print("Nome Bairro: " + bairro);

        System.out.print("Número: " + num);

        System.out.print("Cidade: " + cidade);

        System.out.print("CEP: " + cep);

    }

}
