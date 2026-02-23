package desafios.pagamentos;

public class Boleto implements pagamento {

    private int diasAtraso;

    public Boleto(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    @Override
    public String processar(double valor) {

        double juros = 0;

        if (diasAtraso > 0) {
            juros = valor * 0.02 * diasAtraso;
        }

        double total = valor + juros;

        return "Boleto pago. Valor final com juros: R$ " + total;
    }
}
