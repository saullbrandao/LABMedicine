package utils;

import java.util.Scanner;

public enum StatusAtendimento {
    AGUARDANDO_ATENDIMENTO("Aguardando atendimento"),
    EM_ATENDIMENTO("Em andamento"),
    ATENDIDO("Atendido"),
    NAO_ATENDIDO("Não atendido");

    private final String descricao;

    StatusAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusAtendimento getStatus(int count) {
        return StatusAtendimento.values()[count - 1];
    }

    public static StatusAtendimento selecionarStatus() {
        int i = 1;
        int opcaoEscolhida;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Status possíveis:");
        for (StatusAtendimento status : StatusAtendimento.values()) {
            System.out.format("%d - %s", i, status.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println("Selecione um dos status acima: ");
        opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        return StatusAtendimento.getStatus(opcaoEscolhida);
    }
}
