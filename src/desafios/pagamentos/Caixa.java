package desafios.pagamentos;
import java.util.ArrayList;
import java.util.List;

public class Caixa {

    private List<Transacao> historico = new ArrayList<>();

    public void realizarPagamento(pagamento pagamento, double valor) {

        String resultado = pagamento.processar(valor);
        System.out.println(resultado);

        historico.add(new Transacao(resultado, valor));
    }
    public void mostrarHistorico() {
        System.out.println("\n=== HISTÓRICO DE TRANSAÇÕES ===");
        for (Transacao t : historico) {
            System.out.println(t);
        }
    }
}
