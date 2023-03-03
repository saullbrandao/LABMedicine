package views.cadastro;

import models.Medico;
import repositories.MedicoRepository;
import services.MedicoService;
import utils.EspecializacaoClinica;
import utils.Genero;

import java.time.LocalDate;
import java.util.Map;
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

            Map<String, Object> dadosPessoa = getDadosPessoa();

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

            EspecializacaoClinica especializacaoClinica = EspecializacaoClinica.selecionarEspecializacao();

            Medico medico = new Medico(
                    (String) dadosPessoa.get("nomeCompleto"),
                    (Genero) dadosPessoa.get("genero"),
                    (LocalDate) dadosPessoa.get("dataNascimento"),
                    (String) dadosPessoa.get("cpf"),
                    (String) dadosPessoa.get("telefone"),
                    instituicaoEnsino,
                    cadastroCRM,
                    especializacaoClinica,
                    ativo
            );

            medicoService.addMedico(medico);
            System.out.println("Médico cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar médico. Tente novamente.\n");
        }

    }
}
