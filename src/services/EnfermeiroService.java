package services;


import models.Enfermeiro;
import repositories.EnfermeiroRepository;

public class EnfermeiroService {
    private final EnfermeiroRepository enfermeiroRepository;

    public EnfermeiroService(EnfermeiroRepository enfermeiroRepository) {
        this.enfermeiroRepository = enfermeiroRepository;
    }

    public void addEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiroRepository.addEnfermeiro(enfermeiro);
    }
}
