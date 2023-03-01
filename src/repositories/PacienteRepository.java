package repositories;

import models.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
    private final List<Paciente> pacientes = new ArrayList<>();
    private static PacienteRepository single_instance = null;

    public static PacienteRepository getInstance() {
        if (single_instance == null)
            single_instance = new PacienteRepository();

        return single_instance;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void addPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}
