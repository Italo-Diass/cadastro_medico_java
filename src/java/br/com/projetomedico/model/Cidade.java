package br.com.projetomedico.model;

public class Cidade {
    
    private Integer idCidade;
    private String nomeCidade;

    public Cidade() {
    }

    public Cidade(Integer idCidade, String nomeCidade) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
    }

    public Cidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Cidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    
    

 

   
    
    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    
    
}


