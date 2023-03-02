package views;

import models.Medico;
import models.Paciente;
import repositories.MedicoRepository;
import repositories.PacienteRepository;
import services.MedicoService;
import services.PacienteService;
import utils.StatusAtendimento;

import java.util.List;
import java.util.Scanner;

public class AtendimentoMedico {
    private final MedicoRepository medicoRepository = MedicoRepository.getInstance();
    private final PacienteRepository pacienteRepository = PacienteRepository.getInstance();
    private final MedicoService medicoService = new MedicoService(medicoRepository);
    private final PacienteService pacienteService = new PacienteService(pacienteRepository);
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        try {
            List<Medico> medicosAtivos = medicoService.getMedicosAtivos();
            List<Paciente> pacientes = pacienteService.getPacientes();
            System.out.println("Atendimento médico iniciado.");
            System.out.println("Selecione o médico: ");

            int i = 1;
            for (Medico medico : medicosAtivos) {
                System.out.format("%d - %s", i, medico.getNomeCompleto());
                System.out.println();
                i++;
            }
            int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
            Medico medicoSelecionado = medicosAtivos.get(opcaoEscolhida - 1);

            i = 1;
            for (Paciente paciente : pacientes) {
                System.out.format("%d - %s", i, paciente.getNomeCompleto());
                System.out.println();
                i++;
            }
            opcaoEscolhida = Integer.parseInt(scanner.nextLine());
            Paciente pacienteSelecionado = pacientes.get(opcaoEscolhida - 1);

            System.out.println("Atendimento realizado com sucesso.");
            pacienteSelecionado.setStatusAtendimento(StatusAtendimento.EM_ATENDIMENTO);
            pacienteSelecionado.addAtendimento();
            medicoSelecionado.addAtendimento();
            System.out.println("O status de atendimento do paciente está com " + StatusAtendimento.EM_ATENDIMENTO);
        } catch (Exception e) {
            System.out.println("Erro ao realizar atendimento médico. Tente novamente.\n");
        }
    }
}
