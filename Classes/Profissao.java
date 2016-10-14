
package Classes;

import java.util.Scanner;

public class Profissao {
    
    private String tipo;
    private int id;
    
    public void Cadastrar(){
        Scanner ler = new Scanner(System.in); 
      
        System.out.println("Tipo: ");
        tipo = ler.next();
        System.out.println("Id: ");
        id = ler.nextInt();
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
        System.out.println("Tipo: " +tipo);
        System.out.println("Id: " +id);
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
   
   
}
