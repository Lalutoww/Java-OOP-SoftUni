package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coordinates = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Point a = new Point(coordinates[0], coordinates[1]);
        Point b = new Point(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(a, b);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int[] currentPointCoords = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point p = new Point(currentPointCoords[0], currentPointCoords[1]);
            System.out.println(rectangle.contains(p));
        }
    }
}
