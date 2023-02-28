package models;

import utils.Genero;

import java.time.LocalDate;

public abstract class Pessoa {
    private static int count = 1;
    int id;
    String nomeCompleto;
    Genero genero;
    LocalDate dataNascimento;
    String cpf;
    String telefone;


    public Pessoa(String nomeCompleto, Genero genero, LocalDate dataNascimento, String cpf, String telefone) {
        this.id = count++;
        this.nomeCompleto = nomeCompleto;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
