
package Model;

import java.util.Scanner;

public class ProfissaoUsuario {
    
    private int id;
    private int idProfissao;
    private int idUsuario;
    private String descricao;
    private String localAtuacao;
    private boolean emAtividade;
    private String dataInicio;
    private String dataTermino;
    
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getLocalAtuacao() {
        return localAtuacao;
    }

    public void setLocalAtuacao(String localAtuacao) {
        this.localAtuacao = localAtuacao;
    }
    
    
    
}
