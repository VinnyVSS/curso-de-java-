package atvd;

import java.util.Locale;
import java.util.Scanner;

class Metodo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // cria o objeto da classe Trabalho (com construtor vazio)
        Trabalho trabalho;
        trabalho = new Trabalho();

        System.out.println("Name:");
        trabalho.name = sc.nextLine();

        System.out.println("Salary:");
        trabalho.salary = sc.nextDouble();

        System.out.println("Tax:");
        trabalho.tax = sc.nextDouble();

        // mostra os dados e o salário líquido
        System.out.println();
        System.out.println("Employee: " + trabalho.name + ", $ " + String.format("%.2f", trabalho.calcularSalario()));

        System.out.println();
        System.out.print("Which percentage to increase salary? ");
        double percent = sc.nextDouble();
        trabalho.increaseSalary(percent);

        System.out.println();
        System.out.println("Updated data: " + trabalho);

        sc.close();
    }
}
