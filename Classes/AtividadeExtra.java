
package Classes;

import java.util.Scanner;

public class AtividadeExtra {
    
    private int id;
    private int idUsuario;
    private String nome;
    private String tipo;
    private String data;
    private int duracaoHoras;
  
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
        System.out.println("Data: ");
        data = ler.next();
        System.out.println("Horas Duracao: ");
        duracaoHoras = ler.nextInt();
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
        System.out.println("Horas Duracao: " +duracaoHoras);
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
    public int getDuracaoHoras() {
        return duracaoHoras;
    }
    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }
  
  
    
    
}
