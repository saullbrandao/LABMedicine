package repositories;

import models.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
    private final List<Paciente> pacientes = new ArrayList<>();

    public void addPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}
