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

    public Paciente(String nomeCompleto, Genero genero, LocalDate dataNascimento, String cpf, String telefone, String contatoDeEmergencia, List<String> alergias, List<String> cuidadosEspecificos, String convenio, String numeroConvenio, String validadeConvenio, StatusAtendimento statusAtendimento) {
        super(nomeCompleto, genero, dataNascimento, cpf, telefone);
        this.contatoDeEmergencia = contatoDeEmergencia;
        this.alergias = alergias;
        this.cuidadosEspecificos = cuidadosEspecificos;
        this.convenio = convenio;
        this.numeroConvenio = numeroConvenio;
        this.validadeConvenio = validadeConvenio;
        this.statusAtendimento = statusAtendimento;
    }

    public StatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }

    public String getConvenio() {
        return convenio;
    }

    public int getTotalAtendimentos() {
        return totalAtendimentos;
    }

    public void setStatusAtendimento(StatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public void addAtendimento() {
        this.totalAtendimentos++;
    }
}
