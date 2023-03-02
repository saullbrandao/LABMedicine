package views;

import models.Medico;
import models.Paciente;
import models.Pessoa;
import repositories.MedicoRepository;
import repositories.PacienteRepository;
import services.MedicoService;
import services.PacienteService;
import utils.StatusAtendimento;

import java.util.List;
import java.util.Scanner;

public class AtendimentoMedico {
    private final Scanner scanner;
    private final List<Medico> medicosAtivos;
    private final List<Paciente> pacientes;

    public AtendimentoMedico() {
        PacienteRepository pacienteRepository = PacienteRepository.getInstance();
        PacienteService pacienteService = new PacienteService(pacienteRepository);
        MedicoRepository medicoRepository = MedicoRepository.getInstance();
        MedicoService medicoService = new MedicoService(medicoRepository);
        medicosAtivos = medicoService.getMedicosAtivos();
        pacientes = pacienteService.getPacientes();
        scanner = new Scanner(System.in);
    }

    public void show() {
        try {
            System.out.println("Atendimento médico iniciado.");
            System.out.println("Selecione o médico: ");
            Medico medicoSelecionado = (Medico) selecionarPessoa(medicosAtivos);

            System.out.println("Selecione o Paciente: ");
            Paciente pacienteSelecionado = (Paciente) selecionarPessoa(pacientes);

            pacienteSelecionado.setStatusAtendimento(StatusAtendimento.EM_ATENDIMENTO);
            pacienteSelecionado.addAtendimento();
            medicoSelecionado.addAtendimento();
            System.out.println("Atendimento realizado com sucesso.");
            System.out.println("O status de atendimento do paciente está como " + StatusAtendimento.EM_ATENDIMENTO.getDescricao());
        } catch (Exception e) {
            System.out.println("Erro ao realizar atendimento médico. Tente novamente.\n");
        }
    }

    private Pessoa selecionarPessoa(List<? extends Pessoa> pessoas) {
        int i = 1;
        for (Pessoa pessoa : pessoas) {
            System.out.format("%d - %s", i, pessoa.getNomeCompleto());
            System.out.println();
            i++;
        }
        int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        return pessoas.get(opcaoEscolhida - 1);
    }
}
