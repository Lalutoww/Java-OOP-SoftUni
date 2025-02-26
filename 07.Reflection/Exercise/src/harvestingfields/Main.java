package harvestingfields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Class<RichSoilLand> clazz = RichSoilLand.class;
        while (!input.equals("HARVEST")) {
            switch (input) {
                case "private": {
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                }
                case "protected": {
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                }
                case "public": {
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                }
                case "all": {
                    Arrays.stream(clazz.getDeclaredFields())
                            .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
                    break;
                }
                default:
                    throw new IllegalArgumentException("No such command " + input);
            }

            input = sc.nextLine();
        }
    }
}
