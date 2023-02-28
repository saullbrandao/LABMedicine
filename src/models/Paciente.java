package models;

import utils.Genero;
import utils.StatusAtendimento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    private String contatoDeEmergencia;
    private List<String> alergias = new ArrayList<>();
    private List<String> cuidadosEspecificos = new ArrayList<>();
    private String convenio;
    private String numeroConvenio;
    private String validadeConvenio;
    private StatusAtendimento statusAtendimento;
    private int totalAtendimentos;

    public Paciente(String nomeCompleto, Genero genero, LocalDate dataNascimento, String cpf, String telefone, String contatoDeEmergencia, StatusAtendimento statusAtendimento) {
        super(nomeCompleto, genero, dataNascimento, cpf, telefone);
        this.contatoDeEmergencia = contatoDeEmergencia;
        this.statusAtendimento = statusAtendimento;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias.addAll(alergias);
    }

    public void setCuidadosEspecificos(List<String> cuidadosEspecificos) {
        this.cuidadosEspecificos.addAll(cuidadosEspecificos);
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public void setValidadeConvenio(String validadeConvenio) {
        this.validadeConvenio = validadeConvenio;
    }
}