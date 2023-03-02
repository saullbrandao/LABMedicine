package repositories;

import models.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {
    private final List<Medico> medicos = new ArrayList<>();
    private static MedicoRepository single_instance = null;

    public static MedicoRepository getInstance() {
        if (single_instance == null)
            single_instance = new MedicoRepository();

        return single_instance;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void addMedico(Medico medico) {
        medicos.add(medico);
    }
}
