package services;

import models.Medico;
import repositories.MedicoRepository;
import utils.EspecializacaoClinica;

import java.util.List;

public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getMedicosAtivos() {
        return medicoRepository.getMedicos().stream().filter(Medico::getAtivo).toList();
    }

    public List<Medico> getMedicos() {
        return medicoRepository.getMedicos();
    }

    public void addMedico(Medico medico) {
        medicoRepository.addMedico(medico);
    }

    public List<Medico> filtrarPorEspecializacao(EspecializacaoClinica especializacaoClinica) {
        return getMedicos()
                .stream()
                .filter(medico -> medico.getEspecializacaoClinica().equals(especializacaoClinica))
                .toList();
    }
}
