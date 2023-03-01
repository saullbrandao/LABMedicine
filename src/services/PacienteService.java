package services;

import models.Paciente;
import repositories.PacienteRepository;

import java.util.List;


public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void addPaciente(Paciente paciente) {
        pacienteRepository.addPaciente(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacienteRepository.getPacientes();
    }
}
