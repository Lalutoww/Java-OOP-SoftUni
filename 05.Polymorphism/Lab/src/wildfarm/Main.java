package wildfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] animalInfo = input.split("\\s+");
            String type = animalInfo[0];
            String name = animalInfo[1];
            Double weight = Double.valueOf(animalInfo[2]);
            String livingRegion = animalInfo[3];

            Animal animal = getAnimal(type, name, weight, livingRegion, animalInfo);
            animals.add(animal);

            String[] foodInfo = sc.nextLine().split("\\s+");
            Food food = getFood(foodInfo);
            foodList.add(food);

            input = sc.nextLine();
        }
        printOutput(animals, foodList);
    }

    private static void printOutput(List<Animal> animals, List<Food> foodList) {
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).makeSound();

            animals.get(i).eat(foodList.get(i));
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Animal getAnimal(String type, String name, Double weight, String livingRegion, String[] animalInfo) {
        Animal animal;
        switch (type) {
            case "Cat": {
                animal = new Cat(name, type, weight, livingRegion, animalInfo[4]);
                break;
            }
            case "Mouse": {
                animal = new Mouse(name, type, weight, livingRegion);
                break;
            }
            case "Zebra": {
                animal = new Zebra(name, type, weight, livingRegion);
                break;
            }
            case "Tiger": {
                animal = new Tiger(name, type, weight, livingRegion);
                break;
            }
            default: {
                animal = null;
                break;
            }
        }
        return animal;
    }

    private static Food getFood(String[] foodInfo) {
        Food food = null;
        String type = foodInfo[0];
        Integer quantity = Integer.valueOf(foodInfo[1]);

        if (type.equals("Meat")) {
            food = new Meat(quantity);
        } else if (type.equals("Vegetable")) {
            food = new Vegetable(quantity);
        }

        return food;
    }
}
