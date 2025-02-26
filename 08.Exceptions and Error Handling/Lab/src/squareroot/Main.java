package squareroot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        try {
            double sqrt = checkSqrt(input);
            System.out.printf("%.2f\n", sqrt);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double checkSqrt(String input) {

        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(number);
    }
}
