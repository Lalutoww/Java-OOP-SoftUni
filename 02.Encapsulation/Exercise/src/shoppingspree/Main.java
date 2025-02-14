package shoppingspree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] peopleInput = sc.nextLine().split(";");
        String[] productsInput = sc.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        for (String person : peopleInput) {
            String[] data = person.split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);

            try {
                Person p = new Person(name, money);
                people.put(name, p);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        Map<String, Product> products = new HashMap<>();
        for (String product : productsInput) {
            String[] data = product.split("=");
            String name = data[0];
            double cost = Double.parseDouble(data[1]);

            try {
                Product p = new Product(name, cost);
                products.put(name, p);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String personName = command.split(" ")[0];
            String productName = command.split(" ")[1];

            Person person = people.get(personName);
            Product product = products.get(productName);

            person.buyProduct(product);
            command = sc.nextLine();
        }

        people.forEach((k, v) -> {
            if (v.getProducts().isEmpty()) {
                System.out.println(k + " - Nothing bought");
            } else {
                System.out.printf("%s - %s%n", k, String.join(", ", v.getProducts().stream().map(Product::getName).collect(Collectors.toList())));
            }
        });
    }
}
