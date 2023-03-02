package models;

import utils.Genero;

import java.time.LocalDate;

public abstract class Pessoa {
    private static int count = 1;
    private int id;
    private String nomeCompleto;
    private Genero genero;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;


    public Pessoa(String nomeCompleto, Genero genero, LocalDate dataNascimento, String cpf, String telefone) {
        this.id = count++;
        this.nomeCompleto = nomeCompleto;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
}
