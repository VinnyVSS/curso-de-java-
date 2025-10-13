import java.util.Locale;

public class Main {
    public static void main(String[] args) {
     String product1 = "Computer";
     String product2  = "Office desk";

     int age =  30;
     int code = 5290;
     char gender = 'f';

     double price1 = 2100.0;
     double price2 =  650.50;
     double measure = 53.234567;

     System.out.println ("Products:");
     System.out.printf(" computer,which price is %.2f %n", price1);
     System.out.printf("Office desk, which price is %.2f %n", price2);
     System.out.printf("%d years old, code %d and gender : %s %n", age , code, gender );
     System.out.printf(" Measue with eight decimal places : %f %n Rouded (three decimal places): %.3f%n  US decimal point:  %.3f%n ", measure, measure,measure);

    }
}