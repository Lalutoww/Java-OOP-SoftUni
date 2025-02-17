package ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dirverName = sc.nextLine();

        Car ferrari = new Ferrari(dirverName);
        System.out.println(ferrari);
    }
}
