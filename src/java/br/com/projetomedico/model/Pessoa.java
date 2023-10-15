package br.com.projetomedico.model;

public class Pessoa {
    
    private Integer idPessoa;
    private String nomePessoa;
    private String enderecoPessoa;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nomePessoa, String enderecoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.enderecoPessoa = enderecoPessoa;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }
    
    
    
}
