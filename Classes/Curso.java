/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.Menu.alterarUsuario;
import static Classes.Menu.cadastrarTipoCurso;
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
    Scanner scanner = new Scanner(System.in);
    private PreparedStatement ps = null;

    public Curso() {
        id = 0;
        idInstituicaoEnsino = 0;
        nome = "";
        tipo = "";
    }

    public void cadastrar() {

        System.out.print("Nome do Curso:");
        setNome(scanner.next());
        int opcao = 0;
        do {
            try {
                cadastrarTipoCurso();
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        setTipo("Tecnico");
                        System.out.println("Escolhido Curso do tipo técnico!");
                        opcao = 0;
                        break;
                    case 2:
                        setTipo("Superior");
                        System.out.println("Escolhido Curso do tipo superior!");
                        opcao = 0;
                        break;
                    case 3:
                        setTipo("Mestrado");
                        System.out.println("Escolhido Curso do tipo mestrado!");
                        opcao = 0;
                        break;
                    case 4:
                        setTipo("Doutorado");
                        System.out.println("Escolhido Curso do tipo doutorado!");
                        opcao = 0;
                        break;
                    case 5:
                        setTipo("Phd");
                        System.out.println("Escolhido Curso do tipo PHD!");
                        opcao = 0;
                        break;
                    default:
                        System.out.println("Opcão Inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        } while (opcao != 0);
        System.out.println("Cadastrar Instituição de Ensino");
        InstituicaoEnsino ie = new InstituicaoEnsino();
        System.out.println("Digite o nome da Instituição do Curso");
        ie.setNome(scanner.next());
        ie.buscar(tipo);
        System.out.println("Instituição já cadastrada? Tecle: 1 Sim 2 Não");
        if (!scanner.next().equals("1")) {
            ie.cadastrar();
            ie.setInstituicaoEnsino();
            setIdInstituicaoEnsino(ie.getId());
        } else {
            System.out.print("Insira o código da Instituição de Ensino desejada: ");
            setIdInstituicaoEnsino(scanner.nextInt());
        }
        persistir();
    }

    public boolean jaExiste() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso WHERE nome = ? and idInstituicaoEnsino = ? and tipo = ?");
            ps.setString(1, this.getNome());
            ps.setInt(2, this.getIdInstituicaoEnsino());
            ps.setString(3, tipo);
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

    public boolean jaExisteId() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso WHERE id = ?");
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

    public void persistir() {
        if (!jaExiste()) {
            try {
                ps = Persistencia.conexao().prepareStatement("INSERT into curso (id, nome, idInstituicaoEnsino, tipo) values (?,?,?,?)");
                ps.setInt(1, this.getId());
                ps.setString(2, this.getNome());
                ps.setInt(3, this.getIdInstituicaoEnsino());
                ps.setString(4, this.getTipo());
                ps.executeUpdate();
                System.out.println("Curso cadastrado com sucesso!");
            } catch (Exception e) {
                System.out.println("não foi possível execultar o comando sql para inserir" + e);
            }

        } else {
            System.out.println("Curso já cadastrado");
        }
    }

    public void imprimirComIE() {
        InstituicaoEnsino ie = new InstituicaoEnsino();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código; ");
            saida.add("Nome; ");
            saida.add("Tipo; ");
            saida.add("Instituição de Ensino; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id")+ "; ");
                saida.add(resultSet.getString("nome")+ "; ");
                saida.add(resultSet.getString("tipo")+ "; ");
                ie.setId(resultSet.getInt("idInstituicaoEnsino"));
                ie.setInstituicaoEnsinoId();
                saida.add(ie.getNome());
                saida.add("\n");
            }
            resultSet.close();
            for (Object o: saida){
                System.out.print(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca curso" + e);
        }

    }
    public void imprimirAll() {
        InstituicaoEnsino ie = new InstituicaoEnsino();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código");
            saida.add("Nome");
            saida.add("Tipo");
            saida.add("-1");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id"));
                saida.add(resultSet.getString("nome"));
                saida.add(resultSet.getString("tipo"));
                saida.add("-1");
                saida.add(resultSet.getInt("idInstituicaoEnsino"));
            }
            resultSet.close();
            for (int c = 0; c < saida.size(); c++) {
                if (saida.get(c).equals("-1")) {
                    c++;
                    ie.imprimirPorId((int) saida.get(c));
                    System.out.println("");
                } else {
                    System.out.print(saida.get(c));
                }
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void imprimir() {
        InstituicaoEnsino ie = new InstituicaoEnsino();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso WHERE idInstituicaoEnsino = ? and tipo = ?");
            ps.setInt(1, idInstituicaoEnsino);
            ps.setString(2, tipo);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código; ");
            saida.add("Nome; ");
            saida.add("Tipo; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id") + "; ");
                saida.add(resultSet.getString("nome") + "; ");
                saida.add(resultSet.getString("tipo") + "; ");
                saida.add("\n");
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.println(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void alterar() throws Exception {
        imprimirComIE();
        System.out.println("Digite o código do curso a ser alterado");
        setId(scanner.nextInt());
        setCurso();
        if (jaExisteId()) {
            int opcao = 0;
            do {
                Menu.alterarCurso();
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        nome = scanner.next();
                        break;
                    case 2:
                        int opcao2;
                        do {
                            try {
                                cadastrarTipoCurso();
                                opcao2 = scanner.nextInt();
                                switch (opcao2) {
                                    case 1:
                                        setTipo("Tecnico");
                                        System.out.println("Escolhido Curso do tipo técnico!");
                                        opcao = 0;
                                        break;
                                    case 2:
                                        setTipo("Superior");
                                        System.out.println("Escolhido Curso do tipo superior!");
                                        opcao = 0;
                                        break;
                                    case 3:
                                        setTipo("Mestrado");
                                        System.out.println("Escolhido Curso do tipo mestrado!");
                                        opcao = 0;
                                        break;
                                    case 4:
                                        setTipo("Doutorado");
                                        System.out.println("Escolhido Curso do tipo doutorado!");
                                        opcao = 0;
                                        break;
                                    case 5:
                                        setTipo("Phd");
                                        System.out.println("Escolhido Curso do tipo PHD!");
                                        opcao = 0;
                                        break;
                                    default:
                                        System.out.println("Opcão Inválida");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida");
                            }
                        } while (opcao != 0);
                        break;
                    case 3:
                        InstituicaoEnsino ie = new InstituicaoEnsino();
                        ie.setId(getIdInstituicaoEnsino());
                        ie.alterar();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } while (opcao != 0);

            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE curso set nome = ?, tipo = ? WHERE id = ?");
                ps.setString(1, nome);
                ps.setString(2, tipo);
                ps.setInt(3, id);
                ps.execute();
                System.out.println("Alterado com sucesso");

            } catch (SQLException e) {
                System.out.println("Não foi possível execultar o comando sql de alterar" + e);
            }
        } else {
            System.out.println("Não encontrado curso do código informado");
        }

    }

    public void setCurso() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setNome(resultSet.getString("nome"));
            setTipo(resultSet.getString("tipo"));
            setIdInstituicaoEnsino(resultSet.getInt("id"));
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Não foi possível execultar o comando sql curso" + e);
        }
    }

    public void excluir() {
        imprimirComIE();
        System.out.println("Digite o código do curso a ser excluído");
        setId(scanner.nextInt());
        if (jaExisteId()) {
            try {
                ps = Persistencia.conexao().prepareStatement("DELETE from curso WHERE id = ?");
                ps.setInt(1, this.id);
                ps.execute();
                System.out.println("Curso excluido com sucesso");
            } catch (SQLException e) {
                System.out.println("Não foi possível executar o comando sql de exclusão" + e);
            }
        } else {
            System.out.println("Não encontrado curso do código informado");
        }
    }
    
    public void buscar(String tipo) {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM curso WHERE idInstituicaoEnsino = ? and nome like ?");
            ps.setInt(1, idInstituicaoEnsino);
            ps.setString(2, nome + "%");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código; ");
            saida.add("Nome; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id")+ "; ");
                saida.add(resultSet.getString("nome")+ "; ");
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

}
