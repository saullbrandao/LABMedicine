package services;

import models.Medico;
import repositories.MedicoRepository;

import java.util.List;

public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void addMedico(Medico medico) {
        medicoRepository.addMedico(medico);
    }

    public List<Medico> getMedicosAtivos() {
        return medicoRepository.getMedicos().stream().filter(Medico::getAtivo).toList();
    }

    public List<Medico> getMedicos() {
        return medicoRepository.getMedicos();
    }

}
