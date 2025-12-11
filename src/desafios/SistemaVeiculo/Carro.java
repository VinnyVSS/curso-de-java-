package desafios.SistemaVeiculo;

public class Carro extends Veiculo {

    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public String exibirInformacoes() {
        return "Carro: " + getMarca() + " " + getModelo() + " - Ano: " + getAno();
    }

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando: VRUUM VRUUM!");
    }
}
