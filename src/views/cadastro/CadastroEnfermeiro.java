package views.cadastro;

import models.Enfermeiro;
import repositories.EnfermeiroRepository;
import services.EnfermeiroService;
import utils.Genero;

import java.time.LocalDate;
import java.util.Map;
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
            Map<String, Object> dadosPessoa = getDadosPessoa();

            System.out.println("Instituição de ensino: ");
            String instituicaoEnsino = scanner.nextLine();

            System.out.println("Cadastro do COFEN: ");
            String cadastroCOFEN = scanner.nextLine();

            Enfermeiro enfermeiro = new Enfermeiro(
                    (String) dadosPessoa.get("nomeCompleto"),
                    (Genero) dadosPessoa.get("genero"),
                    (LocalDate) dadosPessoa.get("dataNascimento"),
                    (String) dadosPessoa.get("cpf"),
                    (String) dadosPessoa.get("telefone"),
                    instituicaoEnsino,
                    cadastroCOFEN
            );

            enfermeiroService.addEnfermeiro(enfermeiro);
            System.out.println("Enfermeiro cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar enfermeiro. Tente novamente.\n");
        }

    }
}
