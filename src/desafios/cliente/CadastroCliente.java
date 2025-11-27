package desafios.cliente;

import java.util.*;

public class CadastroCliente {
    private Set<Cliente> clientes = new HashSet<>();

    public void adicionarCliente(Cliente cliente) {
        if (cliente.getIdade() >= 18) {
            clientes.add(cliente);
            System.out.println(" Cliente adicionado: " + cliente.getNome());
        } else {
            System.out.println(" Cliente não adicionado. Idade mínima:18 anos.");
        }
    }
    public Cliente buscarPorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
    public void atualizarEmail(String nome, String novoEmail) {
        Cliente c = buscarPorNome(nome);

        if (c == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        clientes.remove(c);

        try {
            c.setEmail(novoEmail);
        } catch (IllegalArgumentException e) {
            System.out.println("E-mail inválido!");
            clientes.add(c);
            return;
        }

        if (!clientes.add(c)) {
            System.out.println("Já existe outro cliente com esse e-mail!");
        } else {
            System.out.println("E-mail atualizado com sucesso!");
        }
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
