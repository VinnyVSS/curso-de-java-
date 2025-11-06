package atvd;

public class Trabalho {

    public String name;
    public double salary;
    public double tax;

    public Trabalho() {
        this.name = name;
        this.salary = salary;
        this.tax = tax;
    }

    public double calcularSalario() {
        return salary - tax;
    }

    public void increaseSalary(double porcentagem) {
        double aumento = salary * (porcentagem / 100);
        salary += aumento;
    }

    @Override
    public String toString() {
        return name
                + ", $"
                + String.format("%.2f", calcularSalario());
    }
}
