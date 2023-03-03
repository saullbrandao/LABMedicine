package utils;

import java.util.Scanner;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Genero getGenero(int count) {
        return Genero.values()[count - 1];
    }

    public static Genero selecionarGenero() {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Gêneros possíveis:");
        for (Genero genero : Genero.values()) {
            System.out.format("%d - %s", i, genero.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println("Selecione um dos gêneros acima: ");
        int escolhaGenero = Integer.parseInt(scanner.nextLine());

        return Genero.getGenero(escolhaGenero);
    }

}
