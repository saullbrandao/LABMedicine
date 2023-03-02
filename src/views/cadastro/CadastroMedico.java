package views.cadastro;

import models.Medico;
import repositories.MedicoRepository;
import services.MedicoService;
import utils.EspecializacaoClinica;
import utils.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastroMedico extends CadastroPessoa {
    private final MedicoService medicoService;
    private final Scanner scanner;

    public CadastroMedico() {
        MedicoRepository medicoRepository = MedicoRepository.getInstance();
        medicoService = new MedicoService(medicoRepository);
        scanner = new Scanner(System.in);
    }

    public void show() {
        try {
            System.out.println("Cadastro de Médico");
            System.out.println("Nome completo: ");
            String nomeCompleto = scanner.nextLine();


            Genero genero = selecionarGenero();

            System.out.println("Data de Nascimento(Exemplo: 20/05/2002): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

            LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Instituição de ensino: ");
            String instituicaoEnsino = scanner.nextLine();

            System.out.println("Cadastro do CRM: ");
            String cadastroCRM = scanner.nextLine();

            System.out.println("Está ativo?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            boolean ativo;

            String escolhaAtivo = scanner.nextLine();
            if (escolhaAtivo.equals("1")) {
                ativo = true;
            } else if (escolhaAtivo.equals("2")) {
                ativo = false;
            } else {
                throw new IllegalArgumentException();
            }

            EspecializacaoClinica especializacaoClinica = selecionarEspecializacao();

            Medico medico = new Medico(nomeCompleto, genero, dataNascimento, cpf, telefone, instituicaoEnsino, cadastroCRM, especializacaoClinica, ativo);

            medicoService.addMedico(medico);
            System.out.println("Médico cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar médico. Tente novamente.\n");
        }

    }

    private EspecializacaoClinica selecionarEspecializacao() {
        int i = 1;
        System.out.println("Especialização clínica:");
        for (EspecializacaoClinica especializacaoClinica : EspecializacaoClinica.values()) {
            System.out.format("%d - %s", i, especializacaoClinica.getDescricao());
            System.out.println();
            i++;
        }
        System.out.println("Selecione uma das especializações acima: ");

        int especializacaoEscolhida = Integer.parseInt(scanner.nextLine());
        return EspecializacaoClinica.getEspecializacaoClinica(especializacaoEscolhida);
    }


}
