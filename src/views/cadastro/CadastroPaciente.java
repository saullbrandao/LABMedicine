package views.cadastro;

import models.Paciente;
import repositories.PacienteRepository;
import services.PacienteService;
import utils.Genero;
import utils.StatusAtendimento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroPaciente extends CadastroPessoa {
    private final PacienteService pacienteService;
    private final Scanner scanner;

    public CadastroPaciente() {
        PacienteRepository pacienteRepository = PacienteRepository.getInstance();
        pacienteService = new PacienteService(pacienteRepository);
        scanner = new Scanner(System.in);
    }

    public void show() {
        try {
            System.out.println("Cadastro de Paciente");
            System.out.println("Nome completo: ");
            String nomeCompleto = scanner.nextLine();

            Genero genero = selecionarGenero();

            System.out.println("Data de Nascimento(Exemplo: 20/05/2002): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Contato de Emergência: ");
            String contatoEmergencia = scanner.nextLine();

            System.out.println("Lista de Alergias: ");
            List<String> alergias = criarLista();

            System.out.println("Lista de Cuidados Específicos: ");
            List<String> cuidadosEspecificos = criarLista();

            System.out.println("Convênio ");
            String convenio = scanner.nextLine();

            System.out.println("Número do Convênio: ");
            String numeroConvenio = scanner.nextLine();

            System.out.println("Validade do Convênio ");
            String validadeConvenio = scanner.nextLine();

            StatusAtendimento statusAtendimento = selecionarStatus();

            Paciente paciente = new Paciente(nomeCompleto, genero, dataNascimento, cpf, telefone, contatoEmergencia, statusAtendimento);
            paciente.setAlergias(alergias);
            paciente.setCuidadosEspecificos(cuidadosEspecificos);
            paciente.setConvenio(convenio);
            paciente.setNumeroConvenio(numeroConvenio);
            paciente.setValidadeConvenio(validadeConvenio);

            pacienteService.addPaciente(paciente);
            System.out.println("Paciente cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar paciente. Tente novamente.\n");
        }

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

    private List<String> criarLista() {
        String resposta = "";
        List<String> list = new ArrayList<>();

        while (!resposta.equals("fim")) {
            System.out.println("Digite o item a ser adicionado ou 'fim' para sair: ");
            resposta = scanner.nextLine();

            if (resposta.equals("fim")) continue;

            list.add(resposta);

        }

        return list;
    }
}
