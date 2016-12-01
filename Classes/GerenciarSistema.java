/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Model.Curso;
import java.util.Scanner;

/**
 *
 * @author Felipe Fraga
 */
public class GerenciarSistema {

    Scanner scanner = new Scanner(System.in);

    public void gerenciarCurso() throws Exception {
        int opcao = 0;
        Curso curso;
        do {
            Menu.painelCurso();

            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        curso = new Curso();
                        curso.cadastrar();
                        break;
                    case 2:
                        curso = new Curso();
                        curso.alterar();
                        break;
                    case 3:
                        curso = new Curso();
                        curso.excluir();
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida" + e);
            }
        } while (opcao != 0);
    }

    public void gerenciarProfissao() throws Exception {
        int opcao = 0;
        Curso curso;
        do {
            Menu.painelCurso();
            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        curso = new Curso();
                        curso.cadastrar();
                        break;
                    case 2:
                        curso = new Curso();
                        curso.alterar();
                        break;
                    case 3:
                        curso = new Curso();
                        curso.excluir();
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida" + e);
            }
        } while (opcao != 0);
    }
    public void gerenciarSistema() throws Exception {
        int opcao = 0;
        do {
            Menu.painelGerenciarSistema();
            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        gerenciarCurso();
                        break;
                    case 2:
                        gerenciarProfissao();
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida" + e);
            }
        } while (opcao != 0);
    }

}
