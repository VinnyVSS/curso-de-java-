package desafios.SistemaVeiculo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {

    private static Scanner sc = new Scanner(System.in);
    private static Set<Veiculo> veiculos = new HashSet<>();

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {
            try {
                System.out.println("\n---- MENU DE VEÍCULOS ----");
                System.out.println("1 - Cadastrar veículo");
                System.out.println("2 - Listar veículos");
                System.out.println("3 - Testar aceleração");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarVeiculo();
                    case 2 -> listarVeiculos();
                    case 3 -> testarAceleracao();
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida.");
            }
        }
    }

    private static void cadastrarVeiculo() {
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.print("Tipo: ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(sc.nextLine());

        Veiculo v = (tipo == 1)
                ? new Carro(marca, modelo, ano)
                : new Moto(marca, modelo, ano);

        if (veiculos.add(v)) {
            System.out.println("Veículo cadastrado!");
        } else {
            System.out.println("Veículo já existe no sistema.");
        }
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("\n---- VEÍCULOS ----");
        veiculos.forEach(v -> System.out.println(v.exibirInformacoes()));
    }

    private static void testarAceleracao() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("\n---- ACELERANDO ----");
        veiculos.forEach(v -> {
            System.out.print(v.exibirInformacoes() + ": ");
            v.acelerar();
        });
    }
}
