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
public class PainelPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            try {
                Menu.painelPrincipal();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:

                        CadastrarCurriculo cadCurriculo = new CadastrarCurriculo();
                        cadCurriculo.gerenciarDadosUsuario();
                        break;
                    case 2:
                        break;
                    case 3:
                        GerenciarSistema gerSist = new GerenciarSistema();
                        gerSist.gerenciarSistema();
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
