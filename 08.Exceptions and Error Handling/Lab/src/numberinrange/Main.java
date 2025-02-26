package numberinrange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = readArray(sc);

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        while (true) {

            String nextInput = sc.nextLine();

            int number;
            try {
                number = Integer.parseInt(nextInput);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid number: %s%n", nextInput);
                continue;
            }

            try {
                isInRange(range, number);
                System.out.printf("Valid number: %d%n", number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf("Invalid number: %s%n", nextInput);
            }
        }
    }

    private static int[] readArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void isInRange(int[] range, int number) {
        if (!(range[0] <= number && number <= range[1])) {
            throw new IllegalArgumentException("Number is not in range");
        }
    }
}
