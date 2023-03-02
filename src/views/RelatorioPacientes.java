package views;

import models.Paciente;
import repositories.PacienteRepository;
import services.PacienteService;
import utils.StatusAtendimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelatorioPacientes {
    private final PacienteRepository pacienteRepository = PacienteRepository.getInstance();
    private final PacienteService pacienteService = new PacienteService(pacienteRepository);
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        List<Paciente> pacientes = new ArrayList<>();
        int i = 1;

        System.out.println("Relatório de pacientes");

        System.out.println("Status de atendimento:");
        for (StatusAtendimento status : StatusAtendimento.values()) {
            System.out.format("%d - %s", i, status.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println(i + " - Todos");
        System.out.println("Selecione um dos status acima: ");

        int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        StatusAtendimento statusAtendimento;
        if (opcaoEscolhida == i) {
            pacientes.addAll(pacienteService.getPacientes());
            System.out.println("Todos");
        } else {
            statusAtendimento = StatusAtendimento.getStatus(opcaoEscolhida);
            pacientes.addAll(pacienteService
                    .getPacientes()
                    .stream()
                    .filter(paciente -> paciente.getStatusAtendimento().equals(statusAtendimento))
                    .toList());
            System.out.println(statusAtendimento.getDescricao());
        }

        for (Paciente paciente : pacientes) {
            System.out.println("Código: " + paciente.getId());
            System.out.println("Nome: " + paciente.getNomeCompleto());
            System.out.println("Convênio: " + paciente.getConvenio());
            System.out.println("Total de atendimentos: " + paciente.getTotalAtendimentos());
            System.out.println();
        }
    }

}
