
package Classes;

import java.util.Scanner;


public class Evento {
    
    private int id;
    private int idUsuario;
    private String nome;
    private String tipo;
    private boolean nacional;
    private int idEndereco;
    private String data;
    private boolean apresentouTrabalho;
    private String nomeTrabalho;
    
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
        nacional = ler.nextBoolean();
        System.out.println("Id Endereco: ");
        idEndereco = ler.nextInt();
        System.out.println("Data: ");
        data = ler.next();
        System.out.println("Apresentou Trabalho: ");
        apresentouTrabalho = ler.nextBoolean();
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
        System.out.println("Nacional: " +nacional);
        System.out.println("Id Endereco: " +idEndereco);
        System.out.println("Data: " +data);
        System.out.println("Apresentou Trabalho: " +apresentouTrabalho);
        System.out.println("Nome Trabalho: " +nomeTrabalho);
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
    public boolean isNacional() {
        return nacional;
    }
    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }
    public int getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public boolean isApresentouTrabalho() {
        return apresentouTrabalho;
    }
    public void setApresentouTrabalho(boolean apresentouTrabalho) {
        this.apresentouTrabalho = apresentouTrabalho;
    }
    public String nomeTrabalho() {
        return nomeTrabalho;
    }
    public void setNomeTrabalho(String nomeTrabalho) {
        this.nomeTrabalho = nomeTrabalho;
    }

   
   
}
