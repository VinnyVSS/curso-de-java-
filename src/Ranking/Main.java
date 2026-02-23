package Ranking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<Aluno> alunos = new HashSet<>();
    private static final RankingService service = new RankingService(alunos);

    public static void main(String[] args) {

        while (true) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    exibirRanking();
                    break;
                case 3:
                    exibirAprovados();
                    break;
                case 4:
                    exibirEstatisticas();
                    break;
                case 5:
                    buscarAluno();
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    scanner.close();
                    return;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Adicionar aluno");
        System.out.println("2 - Ver ranking");
        System.out.println("3 - Ver aprovados");
        System.out.println("4 - Ver estatísticas");
        System.out.println("5 - Buscar aluno");
        System.out.println("0 - Sair");
    }

    private static int lerOpcao() {
        while (true) {
            System.out.print("Escolha uma opção: ");
            String entrada = scanner.nextLine();

            try {
                int opcao = Integer.parseInt(entrada);

                if (opcao >= 0 && opcao <= 5) {
                    return opcao;
                } else {
                    System.out.println("Opção inválida. Digite um número entre 0 e 5.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }

    private static double lerNota() {
        while (true) {
            System.out.print("Nota do aluno: ");
            String entrada = scanner.nextLine();

            try {
                double nota = Double.parseDouble(entrada);

                if (nota >= 0 && nota <= 10) {
                    return nota;
                } else {
                    System.out.println("A nota deve estar entre 0 e 10.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static void adicionarAluno() {

        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        double nota = lerNota();

        try {
            Aluno aluno = new Aluno(nome, nota);

            if (alunos.add(aluno)) {
                System.out.println("Aluno adicionado com sucesso.");
            } else {
                System.out.println("Aluno já existe.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirRanking() {
        System.out.println("\n=== Ranking ===");
        service.obterRankingOrdenado()
                .forEach(System.out::println);
    }

    private static void exibirAprovados() {
        System.out.println("\n=== Aprovados ===");
        service.obterAprovados()
                .forEach(System.out::println);
    }

    private static void exibirEstatisticas() {
        var stats = service.obterEstatisticas();

        if (stats.getCount() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\nMédia: " + stats.getAverage());
        System.out.println("Maior nota: " + stats.getMax());
        System.out.println("Menor nota: " + stats.getMin());
    }

    private static void buscarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        service.buscarPorNome(nome)
                .ifPresentOrElse(
                        aluno -> System.out.println("Encontrado: " + aluno),
                        () -> System.out.println("Aluno não encontrado.")
                );
    }
}