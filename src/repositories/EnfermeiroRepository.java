package repositories;

import models.Enfermeiro;

import java.util.ArrayList;
import java.util.List;

public class EnfermeiroRepository {
    private final List<Enfermeiro> enfermeiros = new ArrayList<>();

    public void addEnfermeiro(Enfermeiro enfermeiro) {
        enfermeiros.add(enfermeiro);
    }
}
