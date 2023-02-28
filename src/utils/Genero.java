package utils;

public enum Genero {
    MASCULINO,
    FEMININO,
    OUTRO;

    public static Genero getGenero(int count) {
        return Genero.values()[count - 1];
    }

}
