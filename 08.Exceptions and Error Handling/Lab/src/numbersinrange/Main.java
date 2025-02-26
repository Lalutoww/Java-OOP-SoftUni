package numbersinrange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int start = Integer.parseInt(sc.nextLine());
                int end = Integer.parseInt(sc.nextLine());

                printRange(start, end);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input should consist of numbers");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printRange(int start, int end) {
        try {
            checkIfValid(start, end);
            for (int i = start; i <= end; i++) {
                System.out.println(i);
            }
        } catch (IllegalDiapasonException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void checkIfValid(int start, int end) throws IllegalDiapasonException {
        if (start <= 1 || start >= end || end >= 100) {
            throw new IllegalDiapasonException("Numbers should be in the diapason: 1 < start < end < 100.");
        }
    }

    private static class IllegalDiapasonException extends Exception {

        public IllegalDiapasonException(String message) {
            super(message);
        }
    }
}
