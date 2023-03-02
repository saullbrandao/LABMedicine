package views.cadastro;

import utils.Genero;

import java.util.Scanner;

public abstract class CadastroPessoa {
    Scanner scanner = new Scanner(System.in);

    public abstract void show();

    protected Genero selecionarGenero() {
        int i = 1;
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
