/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Felipe Fraga
 */
public class Menu {

    public static void cadastrarTipoCurso() {
        System.out.println("Selecione o tipo do Curso");
        System.out.println("Tecle: ");
        System.out.println("1 - Tecnico: ");
        System.out.println("2 - Superior: ");
        System.out.println("3 - Mestrado: ");
        System.out.println("4 - Doutorado: ");
        System.out.println("5 - PHD: ");

    }

    public static void alterarUsuario() {
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Alterar Nome: ");
        System.out.println("2 - Alterar CPF: ");
        System.out.println("3 - Alterar RG: ");
        System.out.println("4 - Alterar Nome do Pai: ");
        System.out.println("5 - Alterar Nome da Mae: ");
        System.out.println("6 - Alterar Data de Nascimento: ");
        System.out.println("7 - Alterar Endereço: ");
        System.out.println("8 - Alterar Senha: ");
        System.out.println("9 - Alterar Sexo: ");
        System.out.println("10 - Alterar Email: ");
        System.out.println("0 - Sair: ");
    }

    public static void alterarCurso() {
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Alterar Nome: ");
        System.out.println("2 - Alterar Tipo: ");
        System.out.println("3 - Alterar Instituição de Ensino: ");
        System.out.println("0 - Sair: ");
    }
    public static void alterarCursoUsuario() {
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Alterar Data Inicio: ");
        System.out.println("2 - Alterar Data Termino: ");
        System.out.println("3 - Alterar Instituição extra: ");
        System.out.println("0 - Sair: ");
    }
    public static void alterarCursoEM() {
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Alterar Instituição de Ensino: ");
        System.out.println("2 - Alterar Data Inicio: ");
        System.out.println("3 - Alterar Data Termino/Já concluido: ");
        System.out.println("0 - Sair: ");
    }

    public static void alterarInstituicaoEnsino() {
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Alterar Nome: ");
        System.out.println("2 - Alterar Tipo: ");
        System.out.println("3 - Alterar Endereço: ");
        System.out.println("0 - Sair: ");
    }

    public static void alterarEndereco() {
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Alterar Rua: ");
        System.out.println("2 - Alterar Bairro: ");
        System.out.println("3 - Alterar Numero: ");
        System.out.println("4 - Alterar Cidade: ");
        System.out.println("5 - Alterar CEP: ");
        System.out.println("6 - Alterar país: ");
        System.out.println("0 - Sair: ");
    }

    public static void alterarTipoInstituicao() {
        System.out.println("Escolha qual tipo deseja alterar:");
        System.out.println("1 - Médio: ");
        System.out.println("2 - Tecnico: ");
        System.out.println("3 - Superior: ");
        System.out.println("4 - Mestrado: ");
        System.out.println("5 - Doutorado: ");
        System.out.println("6 - PHD: ");
        System.out.println("0 - Sair: ");
    }

    public static void painelInicialUsuario() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Novo Cadastro");
        System.out.println("2 - Acessar Conta");
        System.out.println("0 - Sair");
    }
    public static void painelPrincipal() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Cadastrar Currículo");
        System.out.println("2 - Buscar Currículos");
        System.out.println("3 - Gerenciar Sistema");
        System.out.println("0 - Sair");
    }
    public static void painelUsuario() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Dados Pessoais");
        System.out.println("2 - Formação");
        System.out.println("3 - Profissão");
        System.out.println("0 - Sair");
    }
    public static void painelDadosPessoasUsuario() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Visualizar");
        System.out.println("0 - Sair");
    }
    public static void painelFormacaoUsuario() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Formação Ensino Médio");
        System.out.println("2 - Outros Cursos");
        System.out.println("0 - Sair");
    }
    public static void painelSelecaoTipoCurso() {
        System.out.println("Selecione o tipo de curso a ser cadastrado: ");
        System.out.println("1 - Técnico");
        System.out.println("2 - Superior");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");
        System.out.println("5 - PHD");
        System.out.println("0 - Sair");
    }
    public static void painelFormacaoEnsinoMedioUsuario() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Visualizar");
        System.out.println("0 - Sair");
    }    
    public static void painelFormacaoOutrosCursos() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Visualizar");
        System.out.println("0 - Sair");
    }    

    public static void painelCurso() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Novo Curso");
        System.out.println("2 - Alterar Curso");
        System.out.println("3 - Excluir Curso");
        System.out.println("0 - Sair");
    }
    public static void painelCursoUsuario() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Novo Curso");
        System.out.println("2 - Alterar Curso");
        System.out.println("3 - Excluir Curso");
        System.out.println("0 - Sair");
    }
    public static void painelGerenciarSistema() {
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Novo Curso");
        System.out.println("2 - Alterar Curso");
        System.out.println("3 - Excluir Curso");
        System.out.println("0 - Sair");
    }
}
