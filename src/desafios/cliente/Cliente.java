package desafios.cliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private int idade;
    private String email;

    public Cliente(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println(" E-mail inválido!");
        }
    }
}


class CadastroCliente {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        if (cliente.getIdade() >= 18) {
            clientes.add(cliente);
            System.out.println(" Cliente adicionado: " + cliente.getNome());
        } else {
            System.out.println(" Cliente não adicionado. Idade mínima: 18 anos.");
        }
    }

    public void atualizarEmail(String nome, String novoEmail) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setEmail(novoEmail);
                System.out.println("E-mail de " + nome + " atualizado!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado ainda.");
            return;
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("| %-20s | %-25s | %-5s |\n", "NOME", "EMAIL", "IDADE");
        System.out.println("-------------------------------------------------------------");

        for (Cliente c : clientes) {
            System.out.printf("| %-20s | %-25s | %-5d |\n",
                    c.getNome(), c.getEmail(), c.getIdade());
        }

        System.out.println("-------------------------------------------------------------\n");
    }
}