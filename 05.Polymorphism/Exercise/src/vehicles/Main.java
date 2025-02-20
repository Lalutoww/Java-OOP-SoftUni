package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] carData = sc.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));

        String[] truckData = sc.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];

            switch (command) {
                case "Drive": {
                    if (vehicleType.equals("Car")) {
                        car.drive(Double.parseDouble(input[2]));
                    } else {
                        truck.drive(Double.parseDouble(input[2]));
                    }
                    break;
                }
                case "Refuel": {
                    if (vehicleType.equals("Car")) {
                        car.refuel(Double.parseDouble(input[2]));
                    } else {
                        truck.refuel(Double.parseDouble(input[2]));
                    }
                    break;
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);

    }
}
