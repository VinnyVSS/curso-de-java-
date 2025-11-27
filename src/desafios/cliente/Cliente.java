
package desafios.cliente;

public class Cliente {
    private String nome;
    private int idade;
    private String email;

    public Cliente(String nome, int idade, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }

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
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.email = email.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return email.equalsIgnoreCase(cliente.email);
    }

    @Override
    public int hashCode() {
        return email.toLowerCase().hashCode();
    }

}
