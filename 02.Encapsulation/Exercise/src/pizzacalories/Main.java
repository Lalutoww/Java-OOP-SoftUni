package pizzacalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pizzaData = sc.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = sc.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        int doughWeightInGrams = Integer.parseInt(doughData[3]);

        Dough dough;
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
            dough = new Dough(flourType, bakingTechnique, doughWeightInGrams);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String[] toppingData = command.split("\\s+");
            String toppingType = toppingData[1];
            int toppingWeightInGrams = Integer.parseInt(toppingData[2]);

            try {
                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            command = sc.nextLine();
        }

        System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());
    }
}
