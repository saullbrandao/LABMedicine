package views;

import models.Paciente;
import repositories.PacienteRepository;
import services.PacienteService;
import utils.StatusAtendimento;

import java.util.List;
import java.util.Scanner;

public class AtualizacaoStatusPaciente {
    PacienteRepository pacienteRepository = PacienteRepository.getInstance();
    PacienteService pacienteService = new PacienteService(pacienteRepository);
    Scanner scanner = new Scanner(System.in);
    List<Paciente> pacientes = pacienteService.getPacientes();

    public void show() {
        try {
            System.out.println("Atualizar status do paciente.");

            int i = 1;
            for (Paciente paciente : pacientes) {
                System.out.format("%d - %s", i, paciente.getNomeCompleto());
                System.out.println();
                i++;
            }

            System.out.println("Selecione o paciente a ser atualizado: ");
            int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
            Paciente pacienteSelecionado = pacientes.get(opcaoEscolhida - 1);

            i = 1;
            System.out.println("Status possíveis:");
            for (StatusAtendimento status : StatusAtendimento.values()) {
                System.out.format("%d - %s", i, status);
                System.out.println();
                i++;
            }
            System.out.println("Selecione um dos status acima: ");
            opcaoEscolhida = Integer.parseInt(scanner.nextLine());
            StatusAtendimento statusAtendimento = StatusAtendimento.getStatus(opcaoEscolhida);

            pacienteSelecionado.setStatusAtendimento(statusAtendimento);

            System.out.println("O paciente " + pacienteSelecionado.getNomeCompleto() + " está com o status " + statusAtendimento);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar status do paciente. Tente novamente.");
        }
    }
}
