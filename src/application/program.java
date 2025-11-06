package application;

import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc=new Scanner(System.in);

        Product product = new Product();
        System.out.println(" Enter product data:");
        System.out.println("Name:");
        product.name =sc.nextLine();
        System.out.println("price");
        product.price = sc.nextDouble();
        System.out.println("Quantity in stock:");
        product.quantity=sc.nextInt();

        System.out.println();
        System.out.println("Product data:"+ product);

        System.out.println();
        System.out.println(" enter the number of products to be add in stocks:");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println();
        System.out.println("update data: "+ product);

        System.out.println();
        System.out.println(" enter the number of products to be removed from stocks:");
        quantity = sc.nextInt();

        product.removeProducts(quantity);
        System.out.println();
        System.out.println("update data: "+ product);
    }
}
