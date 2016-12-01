
package Model;

import java.util.Scanner;


public class Evento {
    
    private int id;
    private int idUsuario;
    private String nome;
    private String tipo;
    private String duracaoHoras; 
    private String data;
    private String nomeTrabalho;
    private String local;
    
    public void Cadastrar(){
        Scanner ler = new Scanner(System.in); 
      
        System.out.println("Id: ");
        id = ler.nextInt();
        System.out.println("Id Usuario: ");
        idUsuario = ler.nextInt();
        System.out.println("Nome: ");
        nome = ler.next();
        System.out.println("Tipo: ");
        tipo = ler.next();
        System.out.println("Nacional: ");
        
        System.out.println("Id Endereco: ");
        
        System.out.println("Data: ");
        data = ler.next();
        
        System.out.println("Pais Estrangeiro: ");
        nomeTrabalho = ler.next();
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
        System.out.println("Id Usuario: " +idUsuario);
        System.out.println("Nome: " +nome);
        System.out.println("Tipo: " +tipo);
       
        System.out.println("Data: " +data);
        
        System.out.println("Nome Trabalho: " +getNomeTrabalho());
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
    
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
   
    public String nomeTrabalho() {
        return getNomeTrabalho();
    }
    public void setNomeTrabalho(String nomeTrabalho) {
        this.nomeTrabalho = nomeTrabalho;
    }

    public String getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(String duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public String getNomeTrabalho() {
        return nomeTrabalho;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

   
   
}
