package views;

import models.Medico;
import repositories.MedicoRepository;
import services.MedicoService;
import utils.EspecializacaoClinica;
import utils.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastroMedico {
    Scanner scanner = new Scanner(System.in);
    MedicoRepository medicoRepository = new MedicoRepository();
    MedicoService medicoService = new MedicoService(medicoRepository);

    public void show() {
        try {
            System.out.println("Cadastro de Médico");
            System.out.println("Nome completo: ");
            String nomeCompleto = scanner.nextLine();

            System.out.println("Gênero: ");
            System.out.println("1. Masculino");
            System.out.println("2. Feminino");
            System.out.println("3. Outro");

            // Tive que usar Integer.parseInt() porque o scanner.nextInt() tava causando um 'loop' infinito
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

            System.out.println("Especialização clínica?");
            System.out.println("1. Clínico Geral");
            System.out.println("2. Anestesista");
            System.out.println("3. Dermatologista");
            System.out.println("4. Ginecologista");
            System.out.println("5. Neurologia");
            System.out.println("6. Pediatria");
            System.out.println("7. Psiquiatria");
            System.out.println("8. Ortopedia");
            EspecializacaoClinica especializacaoClinica = EspecializacaoClinica.getEspecializacaoClinica(Integer.parseInt(scanner.nextLine()));

            Medico medico = new Medico(nomeCompleto, genero, dataNascimento, cpf, telefone, instituicaoEnsino, cadastroCRM, especializacaoClinica, ativo);

            medicoService.addMedico(medico);
            System.out.println("Médico cadastrado!\n");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar médico. Tente novamente.\n");
        }

    }
}
