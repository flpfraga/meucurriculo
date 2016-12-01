/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Menu;
import DAO.Persistencia;

import Controller.ControllerUsuario;
import View.usuario.JFrameBuscarUsuario;

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

    public void setUsuario(String dataNascimento, String email, String nome, String nomePai, String nomeMae, String rg, String sexo) {

        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.rg = rg;
        this.sexo = sexo;

    }

    public void imprimirComEndereco() {
       /* Endereco end = new Endereco();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>();
            saida.add("Dados do usuario \n");
            saida.add("Código; ");
            saida.add("Nome; ");
            saida.add("Email; ");
            saida.add("Sexo; ");
            saida.add("RG; ");
            saida.add("CPF; ");
            saida.add("Data de nascimento; ");
            saida.add("Pai; ");
            saida.add("Mãe; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id") + "; ");
                saida.add(resultSet.getString("nome") + "; ");
                saida.add(resultSet.getString("email") + "; ");
                saida.add(resultSet.getString("sexo") + "; ");
                saida.add(resultSet.getString("rg") + "; ");
                saida.add(resultSet.getString("cpf") + "; ");
                saida.add(resultSet.getString("dataNascimento") + "; ");
                saida.add(resultSet.getString("nomePai") + "; ");
                saida.add(resultSet.getString("nomeMae") + "; ");
                saida.add("\n");
                end.setId(resultSet.getInt("idEndereco"));
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
            end.imprimirPorId();
        } catch (SQLException e) {
            controllerUsuario.erroConexaoBD(e);
        }
*/
    }

    public void imprimirPorCpf() {
      /*  try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>(20);
            saida.add("Código; ");
            saida.add("Nome; ");
            saida.add("Email; ");
            saida.add("Sexo; ");
            saida.add("RG; ");
            saida.add("CPF; ");
            saida.add("Data de nascimento; ");
            saida.add("Pai; ");
            saida.add("Mãe; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id") + "; ");
                saida.add(resultSet.getString("nome") + "; ");
                saida.add(resultSet.getString("email") + "; ");
                saida.add(resultSet.getString("sexo") + "; ");
                saida.add(resultSet.getString("rg") + "; ");
                saida.add(resultSet.getString("cpf") + "; ");
                saida.add(resultSet.getString("dataNascimento") + "; ");
                saida.add(resultSet.getString("nomePai") + "; ");
                saida.add(resultSet.getString("nomeMae") + "; ");
                saida.add("\n");
            }
            resultSet.close();

            for (Object o : saida) {
                System.out.print(o);

            }
        } catch (SQLException e) {
            controllerUsuario.erroConexaoBD(e);
        }
*/
    }

    public void imprimirAll() {

        JFrameBuscarUsuario jfMostrarDadosPessoais = new JFrameBuscarUsuario();
        jfMostrarDadosPessoais.setVisible(true);

    }

    public void setUsuario() {
        
    }

    public void persistirNomeInstituicaoEM() throws Exception {
/*
        if (jaExiste()) {
            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE usuario set nomeInstituicaoEM = ? WHERE cpf = ?");
                ps.setString(1, getNomeInstituicaoEM());
                ps.setString(2, cpf);
                ps.execute();

            } catch (SQLException e) {
                controllerUsuario.erroConexaoBD(e);
            }
        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }
*/
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
    public void impUsu(){
        System.out.println("nome " + nome);
        System.out.println("Id endereco "+ idEndereco);
        System.out.println("cpf " + cpf);
    }
}
