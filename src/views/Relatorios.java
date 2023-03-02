package views;

import java.util.Scanner;

public class Relatorios {
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        try {
            System.out.println("Relatórios");
            System.out.println("1. Relatorio de pacientes");
            System.out.println("2. Relatorio de médicos");
            System.out.println("3. Relatorio geral");
            System.out.println("Selecione o relatório desejado: ");
            int opcaoSelecionada = Integer.parseInt(scanner.nextLine());
            selecionarRelatorio(opcaoSelecionada);
        } catch (Exception e) {
            System.out.println("Erro ao exibir relatórios. Tente novamente.");
        }
    }

    private void selecionarRelatorio(int option) {
        switch (option) {
            case 1 -> new RelatorioPacientes().show();
            case 2 -> new RelatorioMedicos().show();
            case 3 -> new RelatorioGeral().show();
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }


}
