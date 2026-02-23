package calculator;

import exception.OperacaoInvalidaException;
import util.LoggerUtil;

import java.util.Scanner;

public class Console {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {
            System.out.println("\nDigite 1 para entrar na calculadora");
            System.out.println("Digite 0 para sair");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                iniciarCalculadora();
            } else if (opcao.equals("0")) {
                System.out.println("Programa encerrado.");
                break;
            } else {
                System.out.println("Comando inválido. Selecione 1 ou 0.");
            }
        }

        scanner.close();
    }

    private void iniciarCalculadora() {

        while (true) {
            try {
                System.out.println("\nDigite o primeiro número (ou 'sair'):");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("sair")) break;

                double a = Double.parseDouble(input);

                System.out.println("Digite a operação (+, -, *, /):");
                String inputOp = scanner.nextLine();

                Operacao operacao = Operacao.fromSimbolo(inputOp);

                System.out.println("Digite o segundo número:");
                double b = Double.parseDouble(scanner.nextLine());

                double resultado = operacao.executar(a, b);

                System.out.println("Resultado: " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números válidos.");
                LoggerUtil.logError("Erro de número inválido: " + e.getMessage());

            } catch (OperacaoInvalidaException e) {
                System.out.println(e.getMessage());
                LoggerUtil.logError(e.getMessage());

            } catch (ArithmeticException e) {
                System.out.println("Erro matemático: " + e.getMessage());
                LoggerUtil.logError(e.getMessage());

            } catch (Exception e) {
                System.out.println("Erro inesperado.");
                LoggerUtil.logError("Erro inesperado: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Console().start();
    }
}