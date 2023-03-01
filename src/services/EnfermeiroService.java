package services;


import models.Enfermeiro;
import repositories.EnfermeiroRepository;

import java.util.List;

public class EnfermeiroService {
    private final EnfermeiroRepository enfermeiroRepository;

    public EnfermeiroService(EnfermeiroRepository enfermeiroRepository) {
        this.enfermeiroRepository = enfermeiroRepository;
    }

    public void addEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiroRepository.addEnfermeiro(enfermeiro);
    }

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiroRepository.getEnfermeiros();
    }
}
