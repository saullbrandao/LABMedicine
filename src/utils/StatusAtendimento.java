package utils;

public enum StatusAtendimento {
    AGUARDANDO_ATENDIMENTO,
    EM_ATENDIMENTO,
    ATENDIDO,
    NAO_ATENDIDO;

    public static StatusAtendimento getStatus(int count) {
        return StatusAtendimento.values()[count - 1];
    }
}
