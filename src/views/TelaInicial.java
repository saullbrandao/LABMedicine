package views;

import views.cadastro.CadastroEnfermeiro;
import views.cadastro.CadastroMedico;
import views.cadastro.CadastroPaciente;
import views.relatorios.Relatorios;

import java.util.Scanner;

public class TelaInicial {

    public void show() {
        int opcaoEscolhida = 0;

        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Bem vindo ao sistema LABMedicine");
                System.out.println("Selecione uma das opções abaixo: ");
                System.out.println("1. Cadastro de Paciente");
                System.out.println("2. Cadastro de Enfermeiro");
                System.out.println("3. Cadastro de Médico");
                System.out.println("4. Realização de Atendimento Médico");
                System.out.println("5. Atualização do Status de Atendimento do Paciente");
                System.out.println("6. Relatórios");
                System.out.println("0. Encerrar Programa");
                System.out.println("Número selecionado: ");

                opcaoEscolhida = scanner.nextInt();
                navigate(opcaoEscolhida);
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (opcaoEscolhida != 0);
    }

    private void navigate(int option) {
        switch (option) {
            case 1 -> new CadastroPaciente().show();
            case 2 -> new CadastroEnfermeiro().show();
            case 3 -> new CadastroMedico().show();
            case 4 -> new AtendimentoMedico().show();
            case 5 -> new AtualizacaoStatusPaciente().show();
            case 6 -> new Relatorios().show();
            case 0 -> System.out.println("Encerrando programa...");
            default -> System.out.println("Opção inválida. Tente novamente.\n");
        }
    }


}
