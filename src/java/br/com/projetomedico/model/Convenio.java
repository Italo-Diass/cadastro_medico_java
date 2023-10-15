package br.com.projetomedico.model;

public class Convenio {

    private Integer idConvenio;
    private String nomeConvenio;

    public Convenio() {
    }

    public Convenio(Integer idConvenio, String nomeConvenio) {
        this.idConvenio = idConvenio;
        this.nomeConvenio = nomeConvenio;
    }

    public Convenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Convenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    

}
