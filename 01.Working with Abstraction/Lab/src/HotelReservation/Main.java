package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        double price = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        String season = input[2];
        String discountType = input[3];

        System.out.printf("%.2f", PriceCalculator.calculatePrice(price, days, season, discountType));
    }
}
