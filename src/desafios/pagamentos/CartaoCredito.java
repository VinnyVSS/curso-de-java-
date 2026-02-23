package desafios.pagamentos;

public class CartaoCredito implements pagamento {

    @Override
    public String processar(double valor) {
        double taxa = valor * 0.05;
        double total = valor + taxa;

        return "Pagamento no Cartão aprovado. Valor com taxa: R$ " + total;
    }
}
