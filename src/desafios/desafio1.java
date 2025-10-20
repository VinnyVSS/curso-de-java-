package desafios;

import java.util.Scanner;

public class desafio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite SAIR para encerrar ou pressione ENTER para continuar:");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("SAIR")) {
                System.out.println("Encerrando o programa...");
                break;
            }

            double somaMedias = 0;

            for (int i = 1; i <= 5; i++) {
                System.out.println("\nAluno " + i);

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                double nota1 = 0;
                double nota2 = 0;
                double nota3 = 0;

                while (true) {
                    System.out.print("Nota 1 (0 a 10): ");
                    nota1 = sc.nextDouble();
                    if (nota1 >= 0 && nota1 <= 10) {
                        break;
                    } else {
                        System.out.println("Digite um número entre 0 e 10.");
                    }
                }

                while (true) {
                    System.out.print("Nota 2 (0 a 10): ");
                    nota2 = sc.nextDouble();
                    if (nota2 >= 0 && nota2 <= 10) {
                        break;
                    } else {
                        System.out.println("Digite um número entre 0 e 10.");
                    }
                }

                while (true) {
                    System.out.print("Nota 3 (0 a 10): ");
                    nota3 = sc.nextDouble();
                    if (nota3 >= 0 && nota3 <= 10) {
                        break;
                    } else {
                        System.out.println("Digite um número entre 0 e 10.");
                    }
                }

                sc.nextLine();

                double media = (nota1 + nota2 + nota3) / 3;
                System.out.printf("Média de %s: %.2f%n", nome, media);

                if (media >= 6) {
                    System.out.println("aluno: APROVADO");
                } else {
                    System.out.println("aluno: REPROVADO");
                }

                somaMedias += media;
            }

            double mediaGeral = somaMedias / 5;
            System.out.printf("%nMÉDIA GERAL DA TURMA: %.2f%n", mediaGeral);
        }

        sc.close();
    }
}
