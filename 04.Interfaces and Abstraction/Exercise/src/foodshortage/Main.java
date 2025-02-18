package foodshortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Buyer> people = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] personData = sc.nextLine().split(" ");
            if (personData.length == 3) {
                String rebelName = personData[0];
                int rebelAge = Integer.parseInt(personData[1]);
                String rebelGroup = personData[2];

                Rebel rebel = new Rebel(rebelName, rebelAge, rebelGroup);
                people.put(rebelName, rebel);
            } else {
                String citizenName = personData[0];
                int citizenAge = Integer.parseInt(personData[1]);
                String citizenId = personData[2];
                String citizenBirthDate = personData[3];
                Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                people.put(citizenName, citizen);
            }
        }

        buyFood(sc, people);
        int totalFood = people.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }

    private static void buyFood(Scanner sc, Map<String, Buyer> people) {
        String command = sc.nextLine();
        while (!command.equals("End")) {
            String name = command;
            if (people.containsKey(name)) {
                people.get(name).buyFood();
            }

            command = sc.nextLine();
        }
    }
}
