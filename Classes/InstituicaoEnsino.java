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
    private Scanner scanner = new Scanner(System.in);
    private PreparedStatement ps = null;

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

    }

    public void cadastrar() {
        System.out.println("Nome da Instituição");
        nome = scanner.next();
        System.out.println("");
        System.out.println("Instituição de Ensino Médio? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            tipoMedio = true;
        }
        System.out.println("Instituição de Ensino Técnico? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            tipoTecnico = true;
        }
        System.out.println("Instituição de Ensino Superior? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            tipoSuperior = true;
        }
        System.out.println("Instituição com Mestrado? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            tipoMestrado = true;
        }
        System.out.println("Instituição com Doutorado? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            tipoDoutorado = true;
        }
        System.out.println("Instituição com PHD? 1 sim 2 não");
        if (scanner.nextInt() == 1) {
            tipoPhd = true;
        }
        Endereco end = new Endereco();
        end.cadastrar();
        end.setEndereco();
        setIdEndereco(end.getId());
        persistir();
    }

    public boolean jaExiste() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome = ?");
            ps.setString(1, this.nome);
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
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE id = ?");
            ps.setInt(1, this.id);
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
                ps = Persistencia.conexao().prepareStatement("Insert into instituicaoensino (id, nome, idEndereco, tipoMedio, tipoTecnico, tipoSuperior, tipoMestrado, tipoDoutorado, tipoPhd) values (?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, getId());
                ps.setString(2, nome);
                ps.setInt(3, idEndereco);
                ps.setBoolean(4, tipoMedio);
                ps.setBoolean(5, tipoTecnico);
                ps.setBoolean(6, tipoSuperior);
                ps.setBoolean(7, tipoMestrado);
                ps.setBoolean(8, tipoDoutorado);
                ps.setBoolean(9, tipoPhd);
                ps.executeUpdate();
                System.out.println("Instituição de Ensino inserida com sucesso");
            } catch (SQLException e) {
                System.out.println("não foi possível execultar o comando sql para inserir" + e);
            }
        } else {
            try{
                ps = Persistencia.conexao().prepareStatement("UPDATE instituicaoensino set tipoMedio = ?, tipoTecnico = ?, tipoSuperior = ?, tipoMestrado = ?, tipoDoutorado = ?, idEndereco = ? WHERE id = ?");
                ps.setBoolean(1, tipoMedio);
                ps.setBoolean(2, tipoTecnico);
                ps.setBoolean(3, tipoSuperior);
                ps.setBoolean(4, tipoMestrado);
                ps.setBoolean(5, tipoDoutorado);
                ps.setBoolean(6, tipoPhd);
                ps.setInt(7, getId());
                ps.execute();
                System.out.println("Instituição cadastrada e atualizada");
            }catch(SQLException ex){
                System.out.println("Não foi possível execultar o comando sql de update" + ex);
            }         
        }
    }

    public void imprimirAll() {

        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código");
            saida.add("Nome");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id"));
                saida.add(resultSet.getString("nome"));
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

    public void imprimirPorId(int idIe) {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM idInstituicaoEnsino WHERE id = ?");
            ps.setInt(1, idIe);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código");
            saida.add("Nome");
            saida.add("\n");
            resultSet.next();
            saida.add(resultSet.getInt("id"));
            saida.add(resultSet.getString("nome"));
            saida.add("\n");

            resultSet.close();
            for (Object o : saida) {
                System.out.print(o);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível execultar o comando sql de busca" + e);
        }
    }

    public void imprimir() {

        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome like ?");
            ps.setString(1, nome + "%");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Object> saida = new ArrayList<Object>();
            saida.add("Código");
            saida.add("Nome");
            saida.add("\n");
            while (resultSet.next()) {
                saida.add(resultSet.getInt("id"));
                saida.add(resultSet.getString("nome"));
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

    public void buscar(String tipo) {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE tipo" + tipo + " = ? and nome like ?");
            ps.setBoolean(1, true);
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

    public void alterar() throws Exception {
        setInstituicaoEnsino();
        if (jaExisteId()) {
            int opcao = 0;
            do {
                Menu.alterarInstituicaoEnsino();
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        nome = scanner.next();

                        break;
                    case 2:
                        Menu.alterarTipoInstituicao();
                        int opcao2 = 0;
                        opcao2 = scanner.nextInt();
                        String opcao3;
                        switch (opcao2) {

                            case 1:
                                if (isTipoMedio()) {
                                    System.out.println("Atualmete instituição é do tipo Ensino Médio. Confirma alteração? Tecle: 11 Sim, 12 Não");
                                } else {
                                    System.out.println("Atualmete instituição não é do tipo Ensino Médio. Confirma alteração? Tecle: 11 Não, 12 Sim");
                                }
                                opcao3 = "";
                                opcao3 = scanner.next();
                                if (opcao3.equals("11")) {
                                    setTipoMedio(false);
                                } else if (opcao3.equals("12")) {
                                    setTipoMedio(true);
                                } else {
                                    System.out.println("Entrada inválida");
                                }
                                break;

                            case 2:
                                if (isTipoTecnico()) {
                                    System.out.println("Atualmete instituição é do tipo Ensino Técnico. Confirma alteração? Tecle: 11 Sim, 12 Não");
                                } else {
                                    System.out.println("Atualmete instituição não é do tipo Ensino Técnico. Confirma alteração? Tecle: 11 Não, 12 Sim");
                                }
                                opcao3 = "";
                                opcao3 = scanner.next();
                                if (opcao3.equals("11")) {
                                    setTipoTecnico(false);
                                } else if (opcao3.equals("12")) {
                                    setTipoTecnico(true);
                                } else {
                                    System.out.println("Entrada inválida");
                                }
                                break;

                            case 3:
                                if (isTipoSuperior()) {
                                    System.out.println("Atualmete instituição é do tipo Ensino Superior. Confirma alteração? Tecle: 11 Sim, 12 Não");
                                } else {
                                    System.out.println("Atualmete instituição não é do tipo Ensino Superior. Confirma alteração? Tecle: 11 Não, 12 Sim");
                                }
                                opcao3 = "";
                                opcao3 = scanner.next();
                                if (opcao3.equals("11")) {
                                    setTipoSuperior(false);
                                } else if (opcao3.equals("12")) {
                                    setTipoSuperior(true);
                                } else {
                                    System.out.println("Entrada inválida");
                                }
                                break;
                            case 4:
                                if (isTipoMestrado()) {
                                    System.out.println("Atualmete instituição é do tipo Mestrado. Confirma alteração? Tecle: 11 Sim, 12 Não");
                                } else {
                                    System.out.println("Atualmete instituição não é do tipo Mestrado. Confirma alteração? Tecle: 11 Não, 12 Sim");
                                }
                                opcao3 = "";
                                opcao3 = scanner.next();
                                if (opcao3.equals("11")) {
                                    setTipoMestrado(false);
                                } else if (opcao3.equals("12")) {
                                    setTipoMestrado(true);
                                } else {
                                    System.out.println("Entrada inválida");
                                }
                                break;
                            case 5:
                                if (isTipoDoutorado()) {
                                    System.out.println("Atualmete instituição é do tipo Doutorado. Confirma alteração? Tecle: 11 Sim, 12 Não");
                                } else {
                                    System.out.println("Atualmete instituição não é do tipo Doutorado. Confirma alteração? Tecle: 11 Não, 12 Sim");
                                }
                                opcao3 = "";
                                opcao3 = scanner.next();
                                if (opcao3.equals("11")) {
                                    setTipoDoutorado(false);
                                } else if (opcao3.equals("12")) {
                                    setTipoDoutorado(true);
                                } else {
                                    System.out.println("Entrada inválida");
                                }
                                break;
                            case 6:
                                if (isTipoPhd()) {
                                    System.out.println("Atualmete instituição é do tipo Phd. Confirma alteração? Tecle: 11 Sim, 12 Não");
                                } else {
                                    System.out.println("Atualmete instituição não é do tipo Phd. Confirma alteração? Tecle: 11 Não, 12 Sim");
                                }
                                opcao3 = "";
                                opcao3 = scanner.next();
                                if (opcao3.equals("11")) {
                                    setTipoPhd(false);
                                } else if (opcao3.equals("12")) {
                                    setTipoPhd(true);
                                } else {
                                    System.out.println("Entrada inválida");
                                }
                                break;

                            case 0:
                                break;
                            default:
                                System.out.println("Opção Inválida");
                                break;
                        }
                        break;

                    case 3:
                        Endereco end = new Endereco();
                        end.setId(getIdEndereco());
                        end.alterar();
                        break;

                    case 0:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } while (opcao != 0);
            try {
                ps = Persistencia.conexao().prepareStatement("UPDATE instituicaoensino set nome = ?, tipoMedio = ?, tipoTecnico = ?, tipoSuperior = ?, tipoMestrado = ?, tipoDoutorado = ?, idEndereco = ? WHERE id = ?");
                ps.setString(1, nome);
                ps.setBoolean(2, tipoMedio);
                ps.setBoolean(3, tipoTecnico);
                ps.setBoolean(4, tipoSuperior);
                ps.setBoolean(5, tipoMestrado);
                ps.setBoolean(6, tipoDoutorado);
                ps.setBoolean(7, tipoPhd);
                ps.setInt(8, idEndereco);
                ps.setInt(9, id);
                ps.execute();

                System.out.println("Alterado com sucesso");

            } catch (SQLException e) {
                System.out.println("Não foi possível execultar o comando sql de alterar" + e);
            }
        } else {
            System.out.println("Não encontrado cadastro do código informado");
        }

    }

    public void setInstituicaoEnsino() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setId(resultSet.getInt("id"));
            setNome(resultSet.getString("nome"));
            setTipoMedio(resultSet.getBoolean("tipoMedio"));
            setTipoTecnico(resultSet.getBoolean("tipoTecnico"));
            setTipoSuperior(resultSet.getBoolean("tipoSuperior"));
            setTipoMestrado(resultSet.getBoolean("tipoMestrado"));
            setTipoDoutorado(resultSet.getBoolean("tipoDoutorado"));
            setTipoPhd(resultSet.getBoolean("tipoPhd"));
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Não foi possível execultar o comando sql" + e);
        }
    }
    
    public void setInstituicaoEnsinoId() {
        try {
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM instituicaoensino WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setId(resultSet.getInt("id"));
            setNome(resultSet.getString("nome"));
            setTipoMedio(resultSet.getBoolean("tipoMedio"));
            setTipoTecnico(resultSet.getBoolean("tipoTecnico"));
            setTipoSuperior(resultSet.getBoolean("tipoSuperior"));
            setTipoMestrado(resultSet.getBoolean("tipoMestrado"));
            setTipoDoutorado(resultSet.getBoolean("tipoDoutorado"));
            setTipoPhd(resultSet.getBoolean("tipoPhd"));
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Não foi possível execultar o comando sql ie" + e);
        }
    }
    
    public void excluir() {
        imprimirAll();
        System.out.println("Digite o código da Instituição a ser excluída");
        setId(scanner.nextInt());
        if (jaExisteId()) {
            Endereco end = new Endereco();
            end.setId(getIdEndereco());
            
            try {
                ps = Persistencia.conexao().prepareStatement("DELETE from instituicaoensino WHERE id = ?");
                ps.setInt(1, this.id);
                ps.executeUpdate();
                System.out.println("Instituicao excluido com sucesso");
            } catch (SQLException e) {
                System.out.println("Não foi possível executar o comando sql de exclusão" + e);
            }
            end.excluir();
        } else {
            System.out.println("Não encontrada Instituição do código informado");
        }
    }
    
    public void buscaIdEndereco(){
        try{
            ps = Persistencia.conexao().prepareStatement("SELECT * FROM idInstituicaoEnsino WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            setIdEndereco(resultSet.getInt("idEndereco"));
            resultSet.close();
            
        }catch(Exception e){
            System.out.println("Não foi possível executar o comando sql de busca" + e);
        }
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

}
