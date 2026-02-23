package desafios.pagamentos;

import java.time.LocalDateTime;

public class Transacao {

    private String descricao;
    private double valor;
    private LocalDateTime data;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return data + " | " + descricao + " | R$ " + valor;
    }
}
