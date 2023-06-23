package br.com.bruno.registersale.main;

import br.com.bruno.registersale.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client data");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Birth date (DD/MM/YYY): ");
        Date birthDate = sdf.parse(scanner.nextLine());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(scanner.nextLine());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order? ");
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            System.out.println("Enter #" + (i + 1) + " item data");
            System.out.println("Product name: ");
            scanner.nextLine(); //limpar buffer entrada
            String productName = scanner.nextLine();
            System.out.println("Product price: ");
            double productPrice = scanner.nextDouble();
            System.out.println("Quantity: ");
            int productQuantity = scanner.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println(order);

        scanner.close();
    }

}
