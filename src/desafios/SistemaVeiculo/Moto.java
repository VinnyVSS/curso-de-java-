package desafios.SistemaVeiculo;

public class Moto extends Veiculo {

    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public String exibirInformacoes() {
        return "Moto: " + getMarca() + " " + getModelo() + " - Ano: " + getAno();
    }

    @Override
    public void acelerar() {
        System.out.println("Moto acelerando: BRÁÁÁÁÁÁÁÁP!");
    }
}
