package br.com.projetomedico.model;

public class Medico extends Pessoa {


        private Integer idMedico;
        private Integer crmMedico;
        private String especialidadeMedico;
        private Cidade cidadeMedico;

    public Medico() {
    }

    public Medico(Integer idMedico, String nomeMedico, String enderecoMedico, Integer crmMedico, String especialidadeMedico, Cidade cidadeMedico) {
        this.idMedico = idMedico;
        this.crmMedico = crmMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.cidadeMedico = cidadeMedico;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(Integer crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }

    public Cidade getCidadeMedico() {
        return cidadeMedico;
    }

    public void setCidadeMedico(Cidade cidadeMedico) {
        this.cidadeMedico = cidadeMedico;
    }

   

    
    




}
       

    

