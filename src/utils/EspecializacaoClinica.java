package utils;

import java.util.Scanner;

public enum EspecializacaoClinica {
    CLINICO_GERAL("Clínico geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");

    private final String descricao;

    EspecializacaoClinica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EspecializacaoClinica getEspecializacaoClinica(int count) {
        return EspecializacaoClinica.values()[count - 1];
    }

    public static EspecializacaoClinica selecionarEspecializacao() {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Especialização clínica:");
        for (EspecializacaoClinica especializacaoClinica : EspecializacaoClinica.values()) {
            System.out.format("%d - %s", i, especializacaoClinica.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println("Selecione uma das especializações acima: ");

        int especializacaoEscolhida = Integer.parseInt(scanner.nextLine());
        return EspecializacaoClinica.getEspecializacaoClinica(especializacaoEscolhida);
    }
}
