package enternumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final int END = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbersInRange = new ArrayList<>();


        int currentNumber = 1;

        while (numbersInRange.size() < 10) {
            try {
                currentNumber = readNumber(currentNumber, Integer.parseInt(sc.nextLine()));
                numbersInRange.add(currentNumber);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalDiapasonException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(numbersInRange.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }


    private static int readNumber(int lastNumber, int newNumber) throws IllegalDiapasonException {
        if (lastNumber >= newNumber || newNumber >= END) {
            throw new IllegalDiapasonException(String.format("Your number is not in range %d - 100!", lastNumber));
        }
        return newNumber;
    }

    private static class IllegalDiapasonException extends Exception {

        public IllegalDiapasonException(String message) {
            super(message);
        }
    }
}
