package desafios.estoque;

import java.util.*;

public class metodo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> lista= new ArrayList<>();
        Map<String, Integer> relatorioEstoque = new HashMap<>();

        int selecionar;

        do {
            System.out.println("\n---- MENU ESTOQUE ----");
            System.out.println("1 - Cadastrar produto. ");
            System.out.println("2 - Listar produtos. ");
            System.out.println("3 - Buscar produtos");
            System.out.println("4 - Editar quantidade");
            System.out.println("5 - Valor total em estoque");
            System.out.println("6 - Relatorio map");
            System.out.println("0 -  Sair");
            System.out.println(" Selecione uma opção: ");
            selecionar = sc.nextInt();
            sc.nextLine();

            switch (selecionar) {
                case 1:
                    System.out.println(" Nome do produto :");
                    String name = sc.nextLine();
                    System.out.println(" Valor : ");
                    double price = sc.nextDouble();
                    System.out.println(" Quantidade :");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    lista.add(new Produto(name, price, quantity));
                    System.out.println(" Produto adicionado");
                    break;

                case 2:
                    System.out.println(" Lista de produtos");
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado");
                    } else {
                        for (Produto p : lista) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do produto que deseja buscar: ");
                    String busca = sc.nextLine();
                    boolean encontrado = false;
                    for (Produto p : lista) {
                        if (p.getName().equalsIgnoreCase(busca)) {
                            System.out.println("  Produto encontrado: " + p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println(" Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do produto que deseja editar: ");
                    String nomeEditar = sc.nextLine();
                    boolean achou = false;

                    for (Produto p : lista) {
                        if (p.getName().equalsIgnoreCase(nomeEditar)) {
                            System.out.println("Produto atual: " + p);
                            System.out.print("Nova quantidade: ");
                            int novaQtd = sc.nextInt();
                            sc.nextLine();
                            p.setQuantity(novaQtd);
                            System.out.println(" Quantidade atualizada!");
                            achou = true;
                            break;
                        }
                    }
                    if (!achou) {
                        System.out.println(" Produto não encontrado.");
                    }
                    break;
                case 5:
                    double total = 0.0;
                    for (Produto p : lista) {
                        total+= p.totalEmEstoque();
                    }
                    System.out.println("Valor total em estoque: R$"+total);
                    break;

                case 6:
                    relatorioEstoque.clear();
                    for (Produto p : lista) {
                        relatorioEstoque.put(p.getName(), p.getQuantity());
                    }

                    System.out.println("\nRELATÓRIO DE QUANTIDADES:");
                    for (Map.Entry<String, Integer> item : relatorioEstoque.entrySet()) {
                        System.out.printf("%s → %d unidades%n", item.getKey(), item.getValue());
                    }
                    break;

                case 0:
                    System.out.println("Sair");
                    break;

            }

        } while (selecionar != 0);

        sc.close();
    }
}


