package models;

import utils.Genero;

import java.time.LocalDate;

public class Enfermeiro extends Pessoa {
    private String instituicaoDeEnsino;
    private String cadastroCOFEN;

    public Enfermeiro(String nomeCompleto, Genero genero, LocalDate dataNascimento, String cpf, String telefone, String instituicaoDeEnsino, String cadastroCOFEN) {
        super(nomeCompleto, genero, dataNascimento, cpf, telefone);
        if (instituicaoDeEnsino.isBlank() || cadastroCOFEN.isBlank()) throw new IllegalArgumentException();

        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.cadastroCOFEN = cadastroCOFEN;
    }
}
