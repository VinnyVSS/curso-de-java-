package desafios.SistemaVeiculo;

import java.util.Objects;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(String marca, String modelo, int ano) {

        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("A marca não pode estar vazia.");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo não pode estar vazio.");
        }

        if (ano <= 0) {
            throw new IllegalArgumentException("O ano deve ser positivo.");
        }

        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }

    public abstract String exibirInformacoes();
    public abstract void acelerar();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return ano == veiculo.ano &&
                marca.equalsIgnoreCase(veiculo.marca) &&
                modelo.equalsIgnoreCase(veiculo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca.toLowerCase(), modelo.toLowerCase(), ano);
    }
}
