package models;

import utils.EspecializacaoClinica;
import utils.Genero;

import java.time.LocalDate;

public class Medico extends Pessoa {
    private String instituicaoDeEnsino;
    private String cadastroCRM;
    private EspecializacaoClinica especializacaoClinica;
    private Boolean ativo;
    private int totalAtendimentos;

    public Medico(String nomeCompleto, Genero genero, LocalDate dataNascimento, String cpf, String telefone, String instituicaoDeEnsino, String cadastroCRM, EspecializacaoClinica especializacaoClinica, Boolean ativo) {
        super(nomeCompleto, genero, dataNascimento, cpf, telefone);
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.cadastroCRM = cadastroCRM;
        this.especializacaoClinica = especializacaoClinica;
        this.ativo = ativo;
    }
}