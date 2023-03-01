package views;

import models.Medico;
import models.Paciente;
import models.Pessoa;
import repositories.EnfermeiroRepository;
import repositories.MedicoRepository;
import repositories.PacienteRepository;
import services.EnfermeiroService;
import services.MedicoService;
import services.PacienteService;
import utils.EspecializacaoClinica;
import utils.StatusAtendimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Relatorio {
    PacienteRepository pacienteRepository = PacienteRepository.getInstance();
    MedicoRepository medicoRepository = MedicoRepository.getInstance();
    EnfermeiroRepository enfermeiroRepository = EnfermeiroRepository.getInstance();
    EnfermeiroService enfermeiroService = new EnfermeiroService(enfermeiroRepository);
    MedicoService medicoService = new MedicoService(medicoRepository);
    PacienteService pacienteService = new PacienteService(pacienteRepository);

    Scanner scanner = new Scanner(System.in);

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
            case 1 -> relatorioPacientes();
            case 2 -> relatorioMedicos();
            case 3 -> relatorioGeral();
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void relatorioGeral() {
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

    private void relatorioPacientes() {
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

    private void relatorioMedicos() {
        List<Medico> medicos = new ArrayList<>();
        int i = 1;

        System.out.println("Relatório de médicos");

        System.out.println("Especialização clínica:");
        for (EspecializacaoClinica especializacaoClinica : EspecializacaoClinica.values()) {
            System.out.format("%d - %s", i, especializacaoClinica.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println(i + " - Todos");
        System.out.println("Selecione uma das especializações acima: ");

        int opcaoEscolhida = Integer.parseInt(scanner.nextLine());
        EspecializacaoClinica especializacaoClinica;
        if (opcaoEscolhida == i) {
            medicos.addAll(medicoService.getMedicos());
            System.out.println("Todos");
        } else {
            especializacaoClinica = EspecializacaoClinica.getEspecializacaoClinica(opcaoEscolhida);
            medicos.addAll(medicoService
                    .getMedicos()
                    .stream()
                    .filter(medico -> medico.getEspecializacaoClinica().equals(especializacaoClinica))
                    .toList());
            System.out.println(especializacaoClinica.getDescricao());
        }

        for (Medico medico : medicos) {
            System.out.println("Código: " + medico.getId());
            System.out.println("Nome: " + medico.getNomeCompleto());
            System.out.println("Instituição de ensino: " + medico.getInstituicaoDeEnsino());
            System.out.println("CRM: " + medico.getCadastroCRM());
            System.out.println("Especialização clínica: " + medico.getEspecializacaoClinica().getDescricao());
            System.out.println();
        }
    }
}
