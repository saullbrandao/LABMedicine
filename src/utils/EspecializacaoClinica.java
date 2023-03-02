package utils;

public enum EspecializacaoClinica {
    CLINICO_GERAL("Clínico geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");

    private final String descricao;

    EspecializacaoClinica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EspecializacaoClinica getEspecializacaoClinica(int count) {
        return EspecializacaoClinica.values()[count - 1];
    }
}
