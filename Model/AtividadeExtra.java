
package Model;

import java.util.Scanner;

public class AtividadeExtra {
    
    private int id;
    private int idUsuario;
    private String nome;
    private String tipo;
    private String data;
    private String duracaoHoras;
    
    public AtividadeExtra(){
        id = 0;
        idUsuario = 0;
        nome = "";
        tipo = "";
        data = "";
        duracaoHoras = "";
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
    public String getDuracaoHoras() {
        return duracaoHoras;
    }
    public void setDuracaoHoras(String duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }
  
  
    
    
}
