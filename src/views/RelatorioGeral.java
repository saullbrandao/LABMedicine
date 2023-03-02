package views;

import models.Pessoa;
import repositories.EnfermeiroRepository;
import repositories.MedicoRepository;
import repositories.PacienteRepository;
import services.EnfermeiroService;
import services.MedicoService;
import services.PacienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelatorioGeral {
    private final PacienteRepository pacienteRepository = PacienteRepository.getInstance();
    private final PacienteService pacienteService = new PacienteService(pacienteRepository);
    private final MedicoRepository medicoRepository = MedicoRepository.getInstance();
    private final MedicoService medicoService = new MedicoService(medicoRepository);
    private final EnfermeiroRepository enfermeiroRepository = EnfermeiroRepository.getInstance();
    private final EnfermeiroService enfermeiroService = new EnfermeiroService(enfermeiroRepository);

    private final Scanner scanner = new Scanner(System.in);
    
    public void show() {
        System.out.println("1. Pacientes");
        System.out.println("2. Enfermeiros");
        System.out.println("3. Médicos");
        System.out.println("4. Todos");
        System.out.println("Selecione qual categoria deseja exibir: ");
        int opcaoSelecionada = Integer.parseInt(scanner.nextLine());
        List<Pessoa> pessoas = new ArrayList<>();

        switch (opcaoSelecionada) {
            case 1 -> {
                System.out.println("Pacientes");
                pessoas.addAll(pacienteService.getPacientes());
            }
            case 2 -> {
                System.out.println("Enfermeiros");
                pessoas.addAll(enfermeiroService.getEnfermeiros());
            }
            case 3 -> {
                System.out.println("Médicos");
                pessoas.addAll(medicoService.getMedicos());
            }
            case 4 -> {
                System.out.println("Todos");
                pessoas.addAll(pacienteService.getPacientes());
                pessoas.addAll(enfermeiroService.getEnfermeiros());
                pessoas.addAll(medicoService.getMedicos());
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println("Código: " + pessoa.getId());
            System.out.println("Nome: " + pessoa.getNomeCompleto());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println();
        }
    }
}
