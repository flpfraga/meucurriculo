/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author Felipe Fraga
 */
public class CadastrarCurriculo {

    Scanner scanner = new Scanner(System.in);

    public void gerenciarDadosUsuario() throws Exception {
        int opcao = 0;
        Usuario usuario;
        do {
            try {
                Menu.painelInicialUsuario();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        usuario = new Usuario();
                        usuario.cadastrarLogin();
                        break;
                    case 2:
                        usuario = new Usuario();
                        if (!usuario.verificaLogin()) {
                            System.out.println("Dados inválidos!");
                        } else {
                            gerenciarPainelUsuario(usuario);
                        }
                        break;
                    case 3:
                        System.out.println("Calma! Sistema em construção");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada de inválida" + e);
            }
        } while (opcao != 0);
    }

    public void gerenciarCursoUsuario(Usuario usuario) throws Exception {
        int opcao = 0;
        Curso curso;
        usuario.setUsuario();
        CursoUsuario cursoUsuario;
        InstituicaoEnsino ie;
        do {
            try {
                Menu.painelFormacaoOutrosCursos();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        curso = new Curso();
                        cursoUsuario = new CursoUsuario();
                        ie = new InstituicaoEnsino();
                        System.out.println("Digite o nome da instituição de Ensino onde fez/faz o curso");
                        ie.setNome(scanner.next());
                        int opcao1 = 0;
                        do {
                            Menu.painelSelecaoTipoCurso();
                            opcao1 = scanner.nextInt();
                            switch (opcao) {
                                case 1:
                                    ie.buscar("Tecnico");
                                    opcao1 = 0;
                                    break;
                                case 2:
                                    ie.buscar("Superior");
                                    opcao1 = 0;
                                    break;
                                case 3:
                                    ie.buscar("Mestrado");
                                    opcao1 = 0;
                                    break;
                                case 4:
                                    ie.buscar("Doutorado");
                                    opcao1 = 0;
                                    break;
                                case 5:
                                    ie.buscar("Phd");
                                    opcao1 = 0;
                                    break;
                                default:
                                    break;
                            }
                            System.out.println("Digite o código da Instituição desejada");
                            curso.setIdInstituicaoEnsino(scanner.nextInt());
                            System.out.println("Digite o nome do curso");
                            curso.buscar(scanner.next());
                            System.out.println("Digite o codigo do Curso desejado");
                            cursoUsuario.setIdCurso(scanner.nextInt());
                            cursoUsuario.setIdUsuario(usuario.getId());
                            cursoUsuario.cadastrar();
                        } while (opcao1 != 0);
                        break;
                    case 2:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.imprimirAll();
                        System.out.println("Digite o codigo o curso");
                        cursoUsuario.setIdCurso(scanner.nextInt());
                        cursoUsuario.setCursoUsuario();
                        cursoUsuario.alterar();
                        
                        break;
                    case 3:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.imprimirAll();
                        System.out.println("Digite o codigo o curso");
                        cursoUsuario.setIdUsuario(scanner.nextInt());
                        cursoUsuario.setCursoUsuario();
                        cursoUsuario.excluir();
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        } while (opcao != 0);
    }

    public void gerenciarPainelUsuario(Usuario usuario) throws Exception {
        int opcao = 0;
        do {
            try {
                Menu.painelUsuario();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        gerenciarDadosPessoaisUsuario(usuario);
                        break;
                    case 2:
                        gerenciarFormacaoUsuario(usuario);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada de inválida" + e);
            }
        } while (opcao != 0);
    }

    public void gerenciarDadosPessoaisUsuario(Usuario usuario) throws Exception {
        int opcao = 0;
        do {
            try {
                Menu.painelDadosPessoasUsuario();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        usuario.cadastrarDadosPessoais();
                        break;
                    case 2:
                        usuario.alterar();
                        break;
                    case 3:
                        usuario.excluir();
                        break;
                    case 4:
                        usuario.imprimirComEndereco();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada de inválida" + e);
            }
        } while (opcao != 0);
    }

    public void gerenciarFormacaoUsuario(Usuario usuario) throws Exception {
        CursoUsuario cursoUsuario;
        int opcao = 0;
        do {
            try {
                Menu.painelFormacaoUsuario();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        gerenciarFormacaoEnsinoMedioUsuario(usuario);
                        break;
                    case 2:
                        gerenciarCursoUsuario(usuario);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada de inválida" + e);
            }
        } while (opcao != 0);
    }

    public void gerenciarFormacaoEnsinoMedioUsuario(Usuario usuario) throws Exception {
        CursoUsuario cursoUsuario;
        usuario.setUsuario();
        int opcao = 0;
        do {
            Menu.painelFormacaoEnsinoMedioUsuario();
            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        cursoUsuario = new CursoUsuario();

                        System.out.println("Digite o nome da Instituição onde Curso o Ensino Médio (ou sua maior parte)");
                        usuario.setNomeInstituicaoEM(scanner.next());
                        usuario.persistirNomeInstituicaoEM();
                        cursoUsuario.setIdCurso(0);
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.cadastrarCursoMédio();
                        break;
                    case 2:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.setIdCurso(0);
                        cursoUsuario.alterarEM(usuario);
                        break;
                    case 3:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.setIdCurso(0);
                        usuario.setNomeInstituicaoEM("");
                        System.out.println("ID curso" + cursoUsuario.getIdCurso());
                        System.out.println("ID usuario" + cursoUsuario.getIdUsuario());
                        cursoUsuario.excluirEM();
                        break;
                    case 4:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.setIdCurso(0);
                        cursoUsuario.imprimirEM(usuario.getNomeInstituicaoEM(), usuario.getNome());
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada de inválida" + e);
            }
        } while (opcao != 0);
    }

    public void gerenciarFormacaoOutrosCursos(Usuario usuario) throws Exception {
        CursoUsuario cursoUsuario;
        Curso curso;
        usuario.setUsuario();
        InstituicaoEnsino ie;
        int opcao = 0;
        do {
            Menu.painelFormacaoOutrosCursos();
            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        cursoUsuario = new CursoUsuario();
                        curso = new Curso();
                        ie = new InstituicaoEnsino();
                        int opcao1 = 0;
                        System.out.println("Digite o nome da Instituição de Ensino");
                        ie.setNome(scanner.next());
                        ie.buscar("tipoSuperior");
                        System.out.println("Digite o código da Instituição de Ensino de realização do curso");
                        curso.setIdInstituicaoEnsino(scanner.nextInt());
                        do {
                            Menu.painelSelecaoTipoCurso();
                            try {
                                opcao1 = scanner.nextInt();
                                switch (opcao1) {
                                    case 1:
                                        curso.setTipo("tecnico");
                                        opcao1 = 0;
                                        break;
                                    case 2:
                                        curso.setTipo("superior");
                                        opcao1 = 0;
                                        break;
                                    case 3:
                                        curso.setTipo("mestrado");
                                        opcao1 = 0;
                                        break;
                                    case 4:
                                        curso.setTipo("doutorado");
                                        opcao1 = 0;
                                        break;
                                    case 5:
                                        curso.setTipo("phd");
                                        opcao1 = 0;
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada Inválida");
                            }
                        } while (opcao1 != 0);
                        curso.imprimir();
                        System.out.println("Digite o código do curso desejado");
                        cursoUsuario.setIdCurso(scanner.nextInt());
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.cadastrar();
                        break;
                    case 2:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.setIdCurso(0);
                        cursoUsuario.alterarEM(usuario);
                        break;
                    case 3:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.setIdCurso(0);
                        usuario.setNomeInstituicaoEM("");
                        System.out.println("ID curso" + cursoUsuario.getIdCurso());
                        System.out.println("ID usuario" + cursoUsuario.getIdUsuario());
                        cursoUsuario.excluirEM();
                        break;
                    case 4:
                        cursoUsuario = new CursoUsuario();
                        cursoUsuario.setIdUsuario(usuario.getId());
                        cursoUsuario.setIdCurso(0);
                        cursoUsuario.imprimirEM(usuario.getNomeInstituicaoEM(), usuario.getNome());
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada de inválida" + e);
            }
        } while (opcao != 0);
    }
}
