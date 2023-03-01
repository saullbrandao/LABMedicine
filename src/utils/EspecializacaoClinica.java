package utils;

public enum EspecializacaoClinica {
    CLINICO_GERAL,
    ANESTESISTA,
    DERMATOLOGIA,
    GINECOLOGIA,
    NEUROLOGIA,
    PEDIATRIA,
    PSIQUIATRIA,
    ORTOPEDIA;

    public static EspecializacaoClinica getEspecializacaoClinica(int count) {
        return EspecializacaoClinica.values()[count - 1];
    }
}
