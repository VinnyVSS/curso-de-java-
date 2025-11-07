package desafios.cliente;
import java.util.Scanner;


public class Metodo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroCliente cadastro = new CadastroCliente();
        int select;

        do {
            System.out.println("\n---- MENU CLIENTES ----");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar e-mail");
            System.out.println("0 - Sair");
            System.out.print("Selecione uma opção: ");
            select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    Cliente novo = new Cliente(nome, idade, email);
                    cadastro.adicionarCliente(novo);
                    break;

                case 2:
                    cadastro.listarClientes();
                    break;

                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeBusca = sc.nextLine();

                    System.out.print("Novo e-mail: ");
                    String novoEmail = sc.nextLine();

                    cadastro.atualizarEmail(nomeBusca, novoEmail);
                    break;

                case 0:
                    System.out.println(" Encerrando o sistema...");
                    break;

            }
        } while (select != 0);

        sc.close();
    }
}