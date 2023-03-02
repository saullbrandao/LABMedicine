package views.cadastro;

import models.Enfermeiro;
import repositories.EnfermeiroRepository;
import services.EnfermeiroService;
import utils.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastroEnfermeiro extends CadastroPessoa {
    private final EnfermeiroService enfermeiroService;
    private final Scanner scanner;

    public CadastroEnfermeiro() {
        EnfermeiroRepository enfermeiroRepository = EnfermeiroRepository.getInstance();
        enfermeiroService = new EnfermeiroService(enfermeiroRepository);
        scanner = new Scanner(System.in);
    }

    public void show() {
        try {
            System.out.println("Cadastro de Enfermeiro");
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

            System.out.println("Cadastro do COFEN: ");
            String cadastroCOFEN = scanner.nextLine();

            Enfermeiro enfermeiro = new Enfermeiro(nomeCompleto, genero, dataNascimento, cpf, telefone, instituicaoEnsino, cadastroCOFEN);

            enfermeiroService.addEnfermeiro(enfermeiro);
            System.out.println("Enfermeiro cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar enfermeiro. Tente novamente.\n");
        }

    }
}
