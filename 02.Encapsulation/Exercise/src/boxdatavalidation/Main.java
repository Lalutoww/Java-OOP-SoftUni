package boxdatavalidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        double height = sc.nextDouble();

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
