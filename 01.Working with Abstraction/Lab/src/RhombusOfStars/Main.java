package RhombusOfStars;

import java.util.Scanner;

public class Main {
    private static final String STAR = "*";
    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        printTop(n);
        printMiddle(n);
        printBottom(n);

    }

    private static void printMiddle(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(STAR + SPACE);
        }
        System.out.println();
    }

    private static void printTop(int n) {
        for (int row = 1; row < n; row++) {
            printRow(n-row, row);
        }
    }

    private static void printBottom(int n) {
        for (int row = 1; row < n; row++) {
            printRow(row, n - row);
        }
    }

    private static void printRow(int spaces, int stars) {
        printSpaces(spaces);
        printStars(stars);
        System.out.println();
    }

    private static void printStars(int n) {
        for (int stars = 0; stars < n; stars++) {
            System.out.print(STAR + SPACE);
        }
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(SPACE);
        }
    }
}
