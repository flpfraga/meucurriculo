/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.Menu.alterarUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Scanner scanner = new Scanner(System.in);
    private PreparedStatement ps = null;

    public Usuario() {
        this.cpf = "";
        this.dataNascimento = "";
        this.email = "";
        this.id = 0;
        this.idEndereco = 0;
        this.nome = "";
        this.nomeMae = "";
        this.nomePai = "";
        this.rg = "";
        this.senha = "";
        this.sexo = "";
        this.nomeInstituicaoEM = "";
    }

    public void cadastrarLogin() {
        System.out.println("Cadastro Inicial");
        System.out.print("CPF: ");
        this.cpf = scanner.next();
        System.out.print("senha: ");
        this.senha = scanner.next();
        persistirLogin();
    }

    public boolean verificaLogin() {
        System.out.println("Login");
        System.out.print("CPF: ");
        this.cpf = scanner.next();
        System.out.print("senha: ");
        this.senha = scanner.next();
        return verificaCadastro();

    }

    public void cadastrarDadosPessoais() {

        System.out.print("Nome: ");
        this.nome = scanner.next();
        System.out.print("Data de nascimento: ");
        this.dataNascimento = scanner.next();
        System.out.print("RG: ");
        this.rg = scanner.next();
        System.out.print("Sexo: ");
        this.setSexo(scanner.next());
        System.out.print("Nome da Mãe: ");
        this.nomeMae = scanner.next();
        System.out.print("Nome do Pai: ");
        this.nomePai = scanner.next();
        System.out.print("Email: ");
        this.email = scanner.next();
        Endereco end = new Endereco();
        end.cadastrar();
        setIdEndereco(end.retornoId());
        persistir();

    }

    public boolean jaExiste() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, this.cpf);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de verificação" + e);
        }
        return false;
    }

    public boolean verificaCadastro() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ? and senha = ?");
            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                resultSet.close();
                return true;
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de verificação" + e);
        }
        return false;
    }

    public boolean jaExisteId() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de verificação" + e);
        }
        return false;
    }

    public void persistirLogin() {
        if (!jaExiste()) {
            try {
                ps = Persistencia.conexao().prepareStatement("INSERT INTO usuario (id, cpf, senha) values (?,?,?)");
                ps.setInt(1, getId());
                ps.setString(2, cpf);
                ps.setString(3, senha);
                ps.executeUpdate();
                System.out.println("Aluno inserido com sucesso");
            } catch (SQLException e) {
                System.out.println("não foi possível execultar o comando sql para inserir" + e);
            }
        } else {
            System.out.println("CPF já cadastrado");
        }
    }

    public void persistir() {

        try {
            ps = Persistencia.conexao().prepareStatement("UPDATE usuario set nome = ?, email = ?, sexo = ?, rg = ?, dataNascimento = ?, nomeMae = ?, nomePai = ?, idEndereco = ? WHERE cpf = ?");
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, getSexo());
            ps.setString(4, rg);
            ps.setString(5, dataNascimento);
            ps.setString(6, nomeMae);
            ps.setString(7, nomePai);
            ps.setInt(8, idEndereco);
            ps.setString(9, cpf);

            ps.executeUpdate();
            System.out.println("Usuario inserido com sucesso");
        } catch (SQLException e) {

            System.out.println("não foi possível execultar o comando sql para inserir" + e);
        }
    }

    public void imprimirComEndereco() {
        Endereco end = new Endereco();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>();
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

                end.setId(resultSet.getInt("idEndereco"));
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
            end.imprimirPorId();
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void imprimirPorCpf() {
        try {
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
            System.out.println(saida.size());
            for (Object o : saida) {
                System.out.print(o);

            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void imprimirAll() {
        Endereco end = new Endereco();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>();
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
                saida.add(resultSet.getInt("id")+"; ");
                saida.add(resultSet.getString("nome")+"; ");
                saida.add(resultSet.getString("email")+"; ");
                saida.add(resultSet.getString("sexo")+"; ");
                saida.add(resultSet.getString("rg")+"; ");
                saida.add(resultSet.getString("cpf")+"; ");
                saida.add(resultSet.getString("dataNascimento")+"; ");
                saida.add(resultSet.getString("nomePai")+"; ");
                saida.add(resultSet.getString("nomeMae")+"; ");
                end.setId(resultSet.getInt("idEndereco"));
                saida.add("\n");
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.println(o);
            }
            end.imprimirPorId();
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void setUsuario() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setId(resultSet.getInt("id"));
            setEmail(resultSet.getString("email"));
            setNome(resultSet.getString("nome"));
            setCpf(resultSet.getString("cpf"));
            setSexo(resultSet.getString("sexo"));
            setRg(resultSet.getString("rg"));
            setDataNascimento(resultSet.getString("dataNascimento"));
            setNomePai(resultSet.getString("nomePai"));
            setNomeMae(resultSet.getString("nomeMae"));
            setIdEndereco(resultSet.getInt("idEndereco"));
            setNomeInstituicaoEM(resultSet.getString("nomeInstituicaoEM"));

        } catch (Exception e) {
            System.out.println("Não foi possível execultar o comando sql" + e);
        }
    }

    public void alterar() throws Exception {
        imprimirPorCpf();
        if (jaExiste()) {
            int opcao = 0;
            do {
                Menu.alterarUsuario();
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        nome = scanner.next();
                        break;
                    case 2:
                        System.out.print("Novo CPF: ");
                        cpf = scanner.next();
                        break;
                    case 3:
                        System.out.print("Novo RG:");
                        rg = scanner.next();
                        break;
                    case 4:
                        System.out.print("Nome do Pai:");
                        nomePai = scanner.next();
                        break;
                    case 5:
                        System.out.print("Nome do Mãe:");
                        nomeMae = scanner.next();
                        break;
                    case 6:
                        System.out.print("Data de nascimento:");
                        dataNascimento = scanner.next();
                        break;
                    case 7:
                        Endereco end = new Endereco();
                        end.setId(getIdEndereco());
                        end.alterar();
                        break;
                    case 8:
                        System.out.println("Digite a antiga senha: ");
                        String aux = scanner.next();
                        if (!aux.equals(senha)) {
                            System.out.println("Senha inválida");
                        } else {
                            System.out.println("Digite a nova senha");
                            setSenha(scanner.next());
                            System.out.println("Senha alterada com sucesso");
                        }
                        break;
                    case 9:
                        System.out.print("Sexo");
                        sexo = scanner.next();
                        break;
                    case 10:
                        System.out.print("Novo Email: ");
                        email = scanner.next();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } while (opcao != 0);

            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE usuario set nome = ?, cpf = ?, rg = ?, nomePai = ?, nomeMae = ?, dataNascimento = ?, senha = ?, sexo = ?, email = ? WHERE id = ?");
                ps.setString(1, nome);
                ps.setString(2, cpf);
                ps.setString(3, rg);
                ps.setString(4, nomePai);
                ps.setString(5, nomeMae);
                ps.setString(6, dataNascimento);
                ps.setString(7, senha);
                ps.setString(8, sexo);
                ps.setString(9, email);
                ps.setInt(10, id);
                ps.execute();
                System.out.println("Alterado com sucesso");

            } catch (SQLException e) {
                System.out.println("Não foi possível execultar o comando sql de alterar" + e);
            }
        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }
    }

    public void persistirNomeInstituicaoEM() throws Exception {

        if (jaExiste()) {
            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE usuario set nomeInstituicaoEM = ? WHERE cpf = ?");
                ps.setString(1, getNomeInstituicaoEM());
                ps.setString(2, cpf);
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Não foi possível execultar o comando sql de alterar" + e);
            }
        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }
    }

    public void excluir() {
        if (jaExiste()) {
            Endereco end = new Endereco();
            setUsuario();
            System.out.println("id endereço: " + getIdEndereco());
            end.setId(getIdEndereco());
            try {
                ps = Persistencia.conexao().prepareStatement("DELETE from usuario WHERE cpf = ?");
                ps.setString(1, this.cpf);
                ps.executeUpdate();
                System.out.println("Cadastro excluido com sucesso");
            } catch (SQLException e) {
                System.out.println("Não foi possível executar o comando sql de exclusão" + e);
            }
            end.excluir();
        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }
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

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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
}
