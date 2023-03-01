package repositories;

import models.Enfermeiro;

import java.util.ArrayList;
import java.util.List;

public class EnfermeiroRepository {
    private final List<Enfermeiro> enfermeiros = new ArrayList<>();
    private static EnfermeiroRepository single_instance = null;

    public static EnfermeiroRepository getInstance() {
        if (single_instance == null)
            single_instance = new EnfermeiroRepository();

        return single_instance;
    }

    public void addEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiros.add(enfermeiro);
    }

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }
}
