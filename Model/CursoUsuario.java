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
        idUsuario = 0;
        idCurso = 0;
        concluido = true;
        dataInicio = "";
        dataTermino = "";
        tipoSanduiche = false;
        instituicaoExtra = "";
    }

    public void cadastrarCursoMédio() {
        System.out.println("Informações do curso");
        int opcao = 0;
        do {
            try {
                System.out.println("Curso já concluido? Tecle 1 sim 2 não");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        setConcluido(true);
                        System.out.println("Data Início: ");
                        setDataInicio(scanner.next());
                        System.out.println("Data Término: ");
                        setDataTermino(scanner.next());
                        opcao = 0;
                        break;
                    case 2:
                        setConcluido(false);
                        System.out.println("Data Início: ");
                        setDataInicio(scanner.next());
                        opcao = 0;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        } while (opcao != 0);
        persistir();
    }

    public void cadastrar() {
        System.out.println("Informações do curso");
        int opcao = 0;
        do {
            try {
                System.out.println("Curso já concluido? Tecle 1 sim 2 não");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        setConcluido(true);
                        System.out.println("Data Início: ");
                        setDataInicio(scanner.next());
                        System.out.println("Data Término: ");
                        setDataTermino(scanner.next());
                        opcao = 0;
                        break;
                    case 2:
                        setConcluido(false);
                        System.out.println("Data Início: ");
                        setDataInicio(scanner.next());
                        opcao = 0;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        } while (opcao != 0);
        opcao = 0;

        do {
            try {
                System.out.println("Parte do curso feito em outra Instituição de Ensino? Tecle: 1 Sim 2 Não");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        setTipoSanduiche(true);
                        System.out.println("Nome da Instituição extra");
                        setInstituicaoExtra(scanner.next());
                        opcao = 0;
                        break;
                    case 2:
                        setTipoSanduiche(false);
                        opcao = 0;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        } while (opcao != 0);
        persistir();
    }

    public void persistir() {
        try {
            ps = Persistencia.conexao().prepareStatement("INSERT into cursousuario (id, idUsuario, idCurso, concluido, dataInicio, dataTermino, tipoSanduiche, instituicaoExtra) values (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, getId());
            ps.setInt(2, getIdUsuario());
            ps.setInt(3, getIdCurso());
            ps.setBoolean(4, isConcluido());
            ps.setString(5, getDataInicio());
            ps.setString(6, getDataTermino());
            ps.setBoolean(7, isTipoSanduiche());
            ps.setString(8, getInstituicaoExtra());
            ps.executeUpdate();
            System.out.println("Curso cadastrado com sucesso");
        } catch (SQLException e) {

            System.out.println("não foi possível execultar o comando sql para inserir" + e);
        }
    }

    public void imprimirAll() {
        Curso curso = new Curso();
        InstituicaoEnsino ie = new InstituicaoEnsino();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ?");
            ps.setInt(1, idUsuario);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>();
            saida.add("Código; ");
            saida.add("Curso; ");
            saida.add("Código do Curso; ");
            saida.add("Instituição do Curso; ");
            saida.add("Data de Início; ");
            saida.add("Data de Término; ");
            saida.add("Instituição de Auxilio; ");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id")+"; ");
                curso.setId(resultSet.getInt("idCurso"));
                curso.setCurso();
                saida.add(curso.getNome()+"; ");
                saida.add(curso.getId());
                ie.setId(curso.getIdInstituicaoEnsino());
                System.out.println(ie.getId());
//                ie.setInstituicaoEnsinoId();
                saida.add(ie.getNome()+"; ");
                saida.add(resultSet.getString("dataInicio") + ";");
                if (resultSet.getBoolean("concluido")) {
                    saida.add(resultSet.getString("dataTermino") + ";");
                } else {
                    saida.add("Em curso; ");
                }
                if (resultSet.getBoolean("tipoSanduiche")) {
                    saida.add(resultSet.getString("instituicaoExtra") + ";");
                }
                saida.add("\n");
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca cursousuario" + e);
        }

    }

    public void excluirEM() {
        if (jaExiste()) {
            setCursoUsuarioEM();
            try {
                ps = Persistencia.conexao().prepareStatement("DELETE from cursousuario WHERE id = ?");
                ps.setInt(1, id);

                ps.executeUpdate();
                System.out.println("Curso excluido com sucesso");
            } catch (SQLException e) {
                System.out.println("Não foi possível executar o comando sql de exclusão" + e);
            }

        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }
    }
    
    public void excluir() {
        if (jaExiste()) {
            setCursoUsuario();
            try {
                ps = Persistencia.conexao().prepareStatement("DELETE from cursousuario WHERE id = ?");
                ps.setInt(1, id);

                ps.executeUpdate();
                System.out.println("Curso excluido com sucesso");
            } catch (SQLException e) {
                System.out.println("Não foi possível executar o comando sql de exclusão" + e);
            }

        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }
    }

    public void imprimirEM(String instituicao, String nome) {
        setCursoUsuarioEM();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ? and idCurso = ?");
            ps.setInt(1, idUsuario);
            ps.setInt(2, idCurso);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>();
            saida.add("Nome do Usuario; ");
            saida.add("Instituição de Ensino; ");
            saida.add("Data de Início");
            saida.add("Data de Término");
            saida.add("\n");
            while (resultSet.next()) {

                saida.add(nome + "; ");
                saida.add(instituicao + "; ");
                saida.add(resultSet.getString("dataInicio") + ";");
                if (resultSet.getBoolean("concluido")) {
                    saida.add(resultSet.getString("dataTermino") + ";");
                } else {
                    saida.add("Em curso; ");
                }
                if (resultSet.getBoolean("tipoSanduiche")) {
                    saida.add(resultSet.getString("instituicaoExtra") + ";");
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

    public void imprimir(String instituicao, String nome) {
        setCursoUsuarioEM();
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ? and idCurso = ?");
            ps.setInt(1, idUsuario);
            ps.setInt(2, idCurso);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<>();
            saida.add("Nome do Usuario; ");
            saida.add("Instituição de Ensino; ");
            saida.add("Data de Início");
            saida.add("Data de Término");
            saida.add("\n");
            while (resultSet.next()) {

                saida.add(nome + "; ");
                saida.add(instituicao + "; ");
                saida.add(resultSet.getString("dataInicio") + ";");
                if (resultSet.getBoolean("concluido")) {
                    saida.add(resultSet.getString("dataTermino") + ";");
                } else {
                    saida.add("Em curso; ");
                }
                if (resultSet.getBoolean("tipoSanduiche")) {
                    saida.add(resultSet.getString("instituicaoExtra") + ";");
                }
            }
            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }

    }

    public void alterarEM(Usuario usuario) throws Exception {
        imprimirEM(usuario.getNomeInstituicaoEM(), usuario.getNome());
        if (jaExiste()) {
            int opcao = 0;
            do {
                Menu.alterarCursoEM();
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome da Instituição onde Curso o Ensino Médio (ou sua maior parte)");
                        usuario.setNomeInstituicaoEM(scanner.next());
                        usuario.persistirNomeInstituicaoEM();
                        break;
                    case 2:
                        System.out.print("Novo Data de Início: ");
                        dataInicio = scanner.next();
                        break;
                    case 3:
                        int opcao1 = 0;
                        do {
                            try {
                                System.out.println("Curso já concluido? Tecle 1 sim 2 não");
                                opcao1 = scanner.nextInt();
                                switch (opcao1) {
                                    case 1:
                                        setConcluido(true);
                                        System.out.println("Data Término: ");
                                        setDataTermino(scanner.next());
                                        opcao1 = 0;
                                        break;
                                    case 2:
                                        setConcluido(false);
                                        opcao1 = 0;
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida");
                            }
                        } while (opcao1 != 0);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } while (opcao != 0);

            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE cursousuario set dataIncio = ?, dataTermino = ?, concluido = ?,WHERE id = ?");
                ps.setString(1, dataInicio);
                ps.setString(2, dataTermino);
                ps.setBoolean(3, concluido);
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

    public void alterar() throws Exception {
        if (jaExiste()) {
            int opcao = 0;
            do {
                Menu.alterarCursoUsuario();
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Novo Data de Início: ");
                        dataInicio = scanner.next();
                        break;
                    case 2:
                        int opcao1 = 0;
                        do {
                            try {
                                System.out.println("Curso já concluido? Tecle 1 sim 2 não");
                                opcao1 = scanner.nextInt();
                                switch (opcao1) {
                                    case 1:
                                        setConcluido(true);
                                        System.out.println("Data Término: ");
                                        setDataTermino(scanner.next());
                                        opcao1 = 0;
                                        break;
                                    case 2:
                                        setConcluido(false);
                                        opcao1 = 0;
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida");
                            }
                        } while (opcao1 != 0);
                        break;
                    case 3:
                        do {
                            try {
                                System.out.println("Parte do curso feito em outra Instituição de Ensino? Tecle: 1 Sim 2 Não");
                                opcao = scanner.nextInt();
                                switch (opcao) {
                                    case 1:
                                        setTipoSanduiche(true);
                                        System.out.println("Nome da Instituição extra");
                                        setInstituicaoExtra(scanner.next());
                                        break;
                                    case 2:
                                        setTipoSanduiche(false);
                                        setInstituicaoExtra("");
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida");
                            }
                        } while (opcao != 0);
                        break;
                }

            } while (opcao != 0);

            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE cursousuario set dataIncio = ?, dataTermino = ?, concluido = ?,WHERE id = ?");
                ps.setString(1, dataInicio);
                ps.setString(2, dataTermino);
                ps.setBoolean(3, concluido);
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

    public void setCursoUsuarioEM() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ? and idCurso = ?");
            ps.setInt(1, idUsuario);
            ps.setInt(2, 0);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setId(resultSet.getInt("id"));
            setConcluido(resultSet.getBoolean("concluido"));
            setDataInicio(resultSet.getString("dataInicio"));
            setDataTermino(resultSet.getString("dataTermino"));
            setTipoSanduiche(resultSet.getBoolean("tipoSanduiche"));
            setInstituicaoExtra(resultSet.getString("instituicaoExtra"));

        } catch (Exception e) {
            System.out.println("Não foi possível execultar o comando sql" + e);
        }
    }

    public void setCursoUsuario() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ? and idCurso = ?");
            ps.setInt(1, idUsuario);
            ps.setInt(2, idCurso);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setId(resultSet.getInt("id"));
            setConcluido(resultSet.getBoolean("concluido"));
            setDataInicio(resultSet.getString("dataInicio"));
            setDataTermino(resultSet.getString("dataTermino"));
            setTipoSanduiche(resultSet.getBoolean("tipoSanduiche"));
            setInstituicaoExtra(resultSet.getString("instituicaoExtra"));

        } catch (Exception e) {
            System.out.println("Não foi possível execultar o comando sql curso " + e);
        }
    }

    public boolean jaExiste() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM cursousuario WHERE idUsuario = ? and idCurso = ?");
            ps.setInt(1, idUsuario);
            ps.setInt(2, idCurso);
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
