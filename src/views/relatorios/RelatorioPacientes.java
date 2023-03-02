package views.relatorios;

import models.Paciente;
import repositories.PacienteRepository;
import services.PacienteService;
import utils.StatusAtendimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelatorioPacientes {
    private final PacienteService pacienteService;
    private final Scanner scanner;

    public RelatorioPacientes() {
        PacienteRepository pacienteRepository = PacienteRepository.getInstance();
        pacienteService = new PacienteService(pacienteRepository);
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("Relatório de pacientes");

        List<Paciente> pacientes = filtrarPacientes();

        for (Paciente paciente : pacientes) {
            System.out.println("Código: " + paciente.getId());
            System.out.println("Nome: " + paciente.getNomeCompleto());
            System.out.println("Convênio: " + paciente.getConvenio());
            System.out.println("Total de atendimentos: " + paciente.getTotalAtendimentos());
            System.out.println();
        }
    }

    private List<Paciente> filtrarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        int i = 1;

        System.out.println("Status de atendimento:");
        for (StatusAtendimento status : StatusAtendimento.values()) {
            System.out.format("%d - %s", i, status.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println(i + " - Todos");
        System.out.println("Selecione um dos status acima: ");

        int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        if (opcaoEscolhida == i) {
            pacientes.addAll(pacienteService.getPacientes());
            System.out.println("Todos");
        } else {
            StatusAtendimento statusAtendimento = StatusAtendimento.getStatus(opcaoEscolhida);
            pacientes.addAll(pacienteService.filtrarPorStatus(statusAtendimento));
            System.out.println(statusAtendimento.getDescricao());
        }

        return pacientes;
    }

}
