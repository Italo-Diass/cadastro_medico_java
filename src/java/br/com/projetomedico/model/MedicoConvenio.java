package br.com.projetomedico.model;

public class MedicoConvenio {
    
    private Medico idMedico;
    private Convenio idConvenio;

    public MedicoConvenio() {
    }

    public MedicoConvenio(Medico idMedico, Convenio idConvenio) {
        this.idMedico = idMedico;
        this.idConvenio = idConvenio;
    }

    public MedicoConvenio(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public MedicoConvenio(Convenio idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public Convenio getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenio idConvenio) {
        this.idConvenio = idConvenio;
    }
    
    
    
}
