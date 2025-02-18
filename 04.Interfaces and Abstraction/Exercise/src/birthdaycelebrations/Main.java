package birthdaycelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        List<Birthable> birthables = new ArrayList<>();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String classType = tokens[0];

            switch (classType) {
                case "Citizen":
                    String citizenName = tokens[1];
                    int citizenAge = Integer.parseInt(tokens[2]);
                    String citizenId = tokens[3];
                    String citizenBirthDate = tokens[4];
                    Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String model = tokens[1];
                    String id = tokens[2];
                    Robot robot = new Robot(model, id);
                    break;
            }
            command = sc.nextLine();
        }
        String yearToSearch = sc.nextLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(yearToSearch)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
