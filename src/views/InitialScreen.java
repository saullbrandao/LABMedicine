package views;

import models.Screen;

import java.util.Scanner;

public class InitialScreen extends Screen {
    int selectedOption;

    @Override
    public void show() {
        while (true) {
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
                System.out.println("Número selecionado: ");

                selectedOption = scanner.nextInt();
                navigate(selectedOption);
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    @Override
    protected void navigate(int option) {
        switch (option) {
            case 1 -> System.out.println("Cadastro de Paciente");
            case 2 -> System.out.println("Cadastro de Enfermeiro");
            case 3 -> System.out.println("Cadastro de Médico");
            case 4 -> System.out.println("Realização de Atendimento Médico");
            case 5 -> System.out.println("Atualização do Status de Atendimento do Paciente");
            case 6 -> System.out.println("Relatórios");
            default -> System.out.println("Opção inválida. Tente novamente.");

        }
    }


}
