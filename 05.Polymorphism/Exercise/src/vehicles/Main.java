package vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();

        String[] carData = sc.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        vehicles.put("Car", car);

        String[] truckData = sc.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
        vehicles.put("Truck", truck);


        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            Vehicle vehicle = vehicles.get(vehicleType);

            switch (command) {
                case "Drive":
                    vehicle.drive(Double.parseDouble(input[2]));
                    break;
                case "Refuel":
                    vehicle.refuel(Double.parseDouble(input[2]));
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
