/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Menu;
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

    public void cadastrar() {
        System.out.println("Cadastrar Endereço");
        System.out.print("Rua: ");
        setRua(scanner.next());
        System.out.print("Nome Bairro: ");
        setBairro(scanner.next());
        System.out.print("Número: ");
        setNum(scanner.next());
        System.out.print("Cidade: ");
        setCidade(scanner.next());
        System.out.print("CEP: ");
        setCep(scanner.next());
        System.out.print("Endereço internacional? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            setBrasil(false);
            System.out.println("País: ");
            setPaisEstrangeiro(scanner.next());
        }
        persistir();
    }

    public void persistir() {
        try {
            ps = Persistencia.conexao().prepareStatement("Insert into endereco (id, rua, bairro, num, cidade, cep, brasil, paisEstrangeiro) values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, getId());
            ps.setString(2, rua);
            ps.setString(3, bairro);
            ps.setString(4, num);
            ps.setString(5, cidade);
            ps.setString(6, cep);
            ps.setBoolean(7, brasil);
            ps.setString(8, paisEstrangeiro);

            ps.executeUpdate();
            ps.close();
            System.out.println("Endereço inserido com sucesso");
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql para inserir" + e);
        }
    }

    public int retornoId() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco WHERE rua = ? and bairro = ? and num = ? and cidade = ?");
            ps.setString(1, rua);
            ps.setString(2, bairro);
            ps.setString(3, num);
            ps.setString(4, cidade);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            resultSet.next();
            setId(resultSet.getInt("id"));

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }
        return getId();
    }

    public void imprimirAll() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código; ");
            saida.add("Rua; ");
            saida.add("Bairro; ");
            saida.add("Número; ");
            saida.add("Cidade; ");
            saida.add("Cep; ");
            saida.add("País; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id") + "; ");
                saida.add(resultSet.getString("rua") + "; ");
                saida.add(resultSet.getString("bairro") + "; ");
                saida.add(resultSet.getInt("num") + "; ");
                saida.add(resultSet.getString("cidade") + "; ");
                saida.add(resultSet.getInt("cep") + "; ");
                if (resultSet.getBoolean("brasil")) {
                    saida.add("Brasil; ");
                } else {
                    saida.add(resultSet.getString("paisEstrangeiro") + "; ");
                }
                saida.add("\n");
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void imprimirPorId() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM endereco WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Endereço\n");
            saida.add("Código; ");
            saida.add("Rua; ");
            saida.add("Bairro; ");
            saida.add("Número; ");
            saida.add("Cidade; ");
            saida.add("Cep; ");
            saida.add("País; ");
            saida.add("\n");
            resultSet.next();
            saida.add(resultSet.getInt("id") + "; ");
            saida.add(resultSet.getString("rua") + "; ");
            saida.add(resultSet.getString("bairro") + "; ");
            saida.add(resultSet.getInt("num") + "; ");
            saida.add(resultSet.getString("cidade") + "; ");
            saida.add(resultSet.getInt("cep") + "; ");
            if (resultSet.getBoolean("brasil")) {
                saida.add("Brasil; ");
            } else {
                saida.add(resultSet.getString("paisEstrangeiro"));
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }
    }

    public void alterar() throws Exception {
        
    
    }

    public void setEndereco() {

    }

    public void setEndereco(String rua, String bairro, String num, String cidade, String cep, String pais, boolean brasil) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.num = num;
        this.cep = cep;
        this.paisEstrangeiro = pais;
        this.brasil = brasil;

    }

    public void excluir() {
        //if (jaExisteId()) {
        try {
            ps = Persistencia.conexao().prepareStatement("DELETE from endereco WHERE id = ?");
            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não foi possível executar o comando sql de exclusão" + e);
        }
        //} else {
        //  System.out.println("Endereço não encontrado");
        // }
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
    
    public void impENd(){
        
        System.out.print("Rua: " + rua);
        
        System.out.print("Nome Bairro: " + bairro);
        
        System.out.print("Número: " + num);
        
        System.out.print("Cidade: " + cidade);
        
        System.out.print("CEP: " + cep);
        
    }

}
