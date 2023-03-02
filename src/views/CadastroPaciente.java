package views;

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

public class CadastroPaciente {
    private final PacienteRepository pacienteRepository = PacienteRepository.getInstance();
    private final PacienteService pacienteService = new PacienteService(pacienteRepository);
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        try {
            System.out.println("Cadastro de Paciente");
            System.out.println("Nome completo: ");
            String nomeCompleto = scanner.nextLine();

            System.out.println("Gênero: ");
            System.out.println("1 - Masculino");
            System.out.println("2 - Feminino");
            System.out.println("3 - Outro");
            // Tive que usar Integer.parseInt() porque o scanner.nextInt() tava causando um loop infinito
            int escolhaGenero = Integer.parseInt(scanner.nextLine());
            Genero genero = Genero.getGenero(escolhaGenero);

            System.out.println("Data de Nascimento(Exemplo: 20/05/2002): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

            LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Contato de Emergência: ");
            String contatoEmergencia = scanner.nextLine();

            System.out.println("Lista de Alergias: ");
            List<String> alergias = createList();

            System.out.println("Lista de Cuidados Específicos: ");
            List<String> cuidadosEspecificos = createList();

            System.out.println("Convênio ");
            String convenio = scanner.nextLine();

            System.out.println("Número do Convênio: ");
            String numeroConvenio = scanner.nextLine();

            System.out.println("Validade do Convênio ");
            String validadeConvenio = scanner.nextLine();

            System.out.println("Status de Atendimento: ");
            System.out.println("1 - Aguardando Atendimento");
            System.out.println("2 - Em Atendimento");
            System.out.println("3 - Atendido");
            System.out.println("4 - Não Atendido");
            StatusAtendimento statusAtendimento = StatusAtendimento.getStatus(Integer.parseInt(scanner.nextLine()));

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

    private List<String> createList() {
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
