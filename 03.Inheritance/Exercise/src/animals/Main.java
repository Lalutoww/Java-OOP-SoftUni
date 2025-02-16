package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        while (!command.equals("Beast!")) {
            String animalType = command;
            String[] animalInfo = sc.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            try {
                switch (animalType) {
                    case "Dog": {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    }
                    case "Cat": {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    }
                    case "Frog": {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    }
                    case "Kitten": {
                        Kitten kitten = new Kitten(name, age, gender);
                        System.out.println(kitten);
                        break;
                    }
                    case "Tomcat": {
                        Tomcat tomcat = new Tomcat(name, age, gender);
                        System.out.println(tomcat);
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = sc.nextLine();
        }
    }
}
