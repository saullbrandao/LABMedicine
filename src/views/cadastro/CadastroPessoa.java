package views.cadastro;

import utils.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class CadastroPessoa {
    Scanner scanner = new Scanner(System.in);

    public abstract void show();

    protected Map<String, Object> getDadosPessoa() {
        System.out.println("Nome completo: ");
        String nomeCompleto = scanner.nextLine();

        Genero genero = Genero.selecionarGenero();

        System.out.println("Data de Nascimento(Exemplo: 20/05/2002): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();

        return Map.of("nomeCompleto", nomeCompleto, "genero", genero, "dataNascimento", dataNascimento, "cpf", cpf, "telefone", telefone);
    }
}
