package views;

import models.Enfermeiro;
import repositories.EnfermeiroRepository;
import services.EnfermeiroService;
import utils.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastroEnfermeiro {
    Scanner scanner = new Scanner(System.in);
    EnfermeiroRepository enfermeiroRepository = EnfermeiroRepository.getInstance();
    EnfermeiroService enfermeiroService = new EnfermeiroService(enfermeiroRepository);

    public void show() {
        try {
            System.out.println("Cadastro de Enfermeiro");
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
