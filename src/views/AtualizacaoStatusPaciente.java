package views;

import models.Paciente;
import repositories.PacienteRepository;
import services.PacienteService;
import utils.StatusAtendimento;

import java.util.List;
import java.util.Scanner;

public class AtualizacaoStatusPaciente {
    private final Scanner scanner;
    private final List<Paciente> pacientes;

    public AtualizacaoStatusPaciente() {
        PacienteRepository pacienteRepository = PacienteRepository.getInstance();
        PacienteService pacienteService = new PacienteService(pacienteRepository);
        pacientes = pacienteService.getPacientes();
        scanner = new Scanner(System.in);
    }

    public void show() {
        try {
            System.out.println("Atualizar status do paciente.");
            Paciente paciente = selecionarPaciente();
            StatusAtendimento statusAtendimento = selecionarStatus();

            paciente.setStatusAtendimento(statusAtendimento);
            System.out.println("O paciente " + paciente.getNomeCompleto() + " está com o status " + statusAtendimento.getDescricao());
        } catch (Exception e) {
            System.out.println("Erro ao atualizar status do paciente. Tente novamente.");
        }
    }

    private Paciente selecionarPaciente() {
        int i = 1;
        for (Paciente paciente : pacientes) {
            System.out.format("%d - %s", i, paciente.getNomeCompleto());
            System.out.println();
            i++;
        }

        System.out.println("Selecione o paciente a ser atualizado: ");
        int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        return pacientes.get(opcaoEscolhida - 1);
    }

    private StatusAtendimento selecionarStatus() {
        int i = 1;
        int opcaoEscolhida;

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
