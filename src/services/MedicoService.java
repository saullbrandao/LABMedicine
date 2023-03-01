package services;

import models.Medico;
import repositories.MedicoRepository;

public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void addMedico(Medico medico) {
        medicoRepository.addMedico(medico);
    }
}
