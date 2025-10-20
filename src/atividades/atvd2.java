package atividades;

import java.util.Locale;
import java.util.Scanner;

public class atvd2 {
    public static void main(String[] args){
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int id = sc.nextInt();
    int horas = sc.nextInt();
    Double  valor= sc.nextDouble();
    Double salary = horas * valor;

    System.out.printf("Usuario= %d%n Salary= U$ %.2f%n", id, salary);
    sc.close();
}
}
