package desafios.pagamentos;

public class Pix implements pagamento {

    @Override
    public String processar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        }

        return "PIX realizado com sucesso. Valor: R$ " + valor;
    }
}
