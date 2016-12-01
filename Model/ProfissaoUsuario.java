
package Model;

import java.util.Scanner;

public class ProfissaoUsuario {
    
    private int id;
    private int idProfissao;
    private int idUsuario;
    private String localAtuacao;
    private boolean emAtividade;
    private String dataInicio;
    private String dataTermino;

    public void Cadastrar(){
        Scanner ler = new Scanner(System.in); 
      
        System.out.println("Id: ");
        id = ler.nextInt();
        System.out.println("Id Profissao: ");
        idProfissao = ler.nextInt();
        System.out.println("Id Usuario: ");
        idUsuario = ler.nextInt();
        System.out.println("Local Atuacao: ");
        localAtuacao = ler.nextLine();
        System.out.println("Em Atividade: ");
        emAtividade = ler.nextBoolean();
        System.out.println("Data Inicio: ");
        dataInicio = ler.nextLine();
        System.out.println("Data Termino: ");
        dataTermino = ler.nextLine();
    }
    public void Buscar(int idBuscado){
        if(idBuscado == id){
            System.out.println("Busca Encontrada!");
        }
        else{
            System.out.println("Busca Nao Encontrada!");
        }
    }
    public void Imprimir(){
        System.out.println("Id: " +id);
        System.out.println("Id Profissao: " +idProfissao);
        System.out.println("Id Usuario: " +idUsuario);
        System.out.println("Local Atuacao: " +localAtuacao);
        System.out.println("Em Atividade: " +emAtividade);
        System.out.println("Data Inicio: " +dataInicio);
        System.out.println("Data Termino: " +dataTermino);
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdProfissao() {
        return idProfissao;
    }
    public void setIdProfissao(int idProfissao) {
        this.idProfissao = idProfissao;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getLocalAtuacao() {
        return localAtuacao;
    }
    public void setLocalAtuacao(String localAtuacao) {
        this.localAtuacao = localAtuacao;
    }
    public boolean isEmAtividade() {
        return emAtividade;
    }
    public void setEmAtividade(boolean emAtividade) {
        this.emAtividade = emAtividade;
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
    
    
    
}
