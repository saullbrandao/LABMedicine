package services;

import models.Paciente;
import repositories.PacienteRepository;
import utils.StatusAtendimento;

import java.util.List;


public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getPacientes() {
        return pacienteRepository.getPacientes();
    }

    public void addPaciente(Paciente paciente) {
        pacienteRepository.addPaciente(paciente);
    }

    public List<Paciente> filtrarPorStatus(StatusAtendimento status) {
        return getPacientes()
                .stream()
                .filter(paciente -> paciente.getStatusAtendimento().equals(status))
                .toList();
    }
}
