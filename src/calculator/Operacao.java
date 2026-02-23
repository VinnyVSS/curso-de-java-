package calculator;

import exception.OperacaoInvalidaException;

public enum Operacao {

    SOMA("+") {
        public double executar(double a, double b) {
            return a + b;
        }
    },
    SUBTRACAO("-") {
        public double executar(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICACAO("*") {
        public double executar(double a, double b) {
            return a * b;
        }
    },
    DIVISAO("/") {
        public double executar(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero não permitida.");
            }
            return a / b;
        }
    };

    private final String simbolo;

    Operacao(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract double executar(double a, double b);

    public static Operacao fromSimbolo(String input)
            throws OperacaoInvalidaException {

        for (Operacao op : values()) {
            if (op.simbolo.equals(input)) {
                return op;
            }
        }

        throw new OperacaoInvalidaException(
                "Operação inválida: " + input
        );
    }
}