package views.relatorios;

import models.Medico;
import repositories.MedicoRepository;
import services.MedicoService;
import utils.EspecializacaoClinica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelatorioMedicos {
    private final MedicoService medicoService;
    private final Scanner scanner;

    public RelatorioMedicos() {
        MedicoRepository medicoRepository = MedicoRepository.getInstance();
        medicoService = new MedicoService(medicoRepository);
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("Relatório de médicos");

        List<Medico> medicos = filtrarMedicos();

        for (Medico medico : medicos) {
            System.out.println("Código: " + medico.getId());
            System.out.println("Nome: " + medico.getNomeCompleto());
            System.out.println("Instituição de ensino: " + medico.getInstituicaoDeEnsino());
            System.out.println("CRM: " + medico.getCadastroCRM());
            System.out.println("Especialização clínica: " + medico.getEspecializacaoClinica().getDescricao());
            System.out.println();
        }
    }

    private List<Medico> filtrarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        int i = 1;

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
            medicos.addAll(medicoService.filtrarPorEspecializacao(especializacaoClinica));
            System.out.println(especializacaoClinica.getDescricao());
        }

        return medicos;
    }
}
