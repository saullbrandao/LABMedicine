package repositories;

import models.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {
    private final List<Medico> medicos = new ArrayList<>();

    public void addMedico(Medico medico) {
        medicos.add(medico);
    }
}
