package views.cadastro;

import models.Paciente;
import repositories.PacienteRepository;
import services.PacienteService;
import utils.Genero;
import utils.StatusAtendimento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

            Map<String, Object> dadosPessoa = getDadosPessoa();

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

            StatusAtendimento statusAtendimento = StatusAtendimento.selecionarStatus();

            Paciente paciente = new Paciente(
                    (String) dadosPessoa.get("nomeCompleto"),
                    (Genero) dadosPessoa.get("genero"),
                    (LocalDate) dadosPessoa.get("dataNascimento"),
                    (String) dadosPessoa.get("cpf"),
                    (String) dadosPessoa.get("telefone"),
                    contatoEmergencia,
                    alergias,
                    cuidadosEspecificos,
                    convenio,
                    numeroConvenio,
                    validadeConvenio,
                    statusAtendimento
            );

            pacienteService.addPaciente(paciente);
            System.out.println("Paciente cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar paciente. Tente novamente.\n");
        }

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
