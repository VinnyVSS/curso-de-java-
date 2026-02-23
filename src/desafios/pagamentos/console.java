package desafios.pagamentos;
import java.util.Scanner;

public class console {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Caixa caixa = new Caixa();

        System.out.println("Digite o valor da compra:");
        double valor = scanner.nextDouble();

        System.out.println("Escolha o pagamento:");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Boleto");

        int opcao = scanner.nextInt();

        pagamento pagamento = null;

        switch (opcao) {
            case 1:
                pagamento = new Pix();
                break;
            case 2:
                pagamento = new CartaoCredito();
                break;
            case 3:
                System.out.println("Dias de atraso:");
                int dias = scanner.nextInt();
                pagamento = new Boleto(dias);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        caixa.realizarPagamento(pagamento, valor);
        caixa.mostrarHistorico();
    }
}

