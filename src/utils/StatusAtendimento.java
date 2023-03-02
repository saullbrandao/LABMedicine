package utils;

public enum StatusAtendimento {
    AGUARDANDO_ATENDIMENTO("Aguardando atendimento"),
    EM_ATENDIMENTO("Em andamento"),
    ATENDIDO("Atendido"),
    NAO_ATENDIDO("Não atendido");
    
    private final String descricao;

    StatusAtendimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusAtendimento getStatus(int count) {
        return StatusAtendimento.values()[count - 1];
    }
}
