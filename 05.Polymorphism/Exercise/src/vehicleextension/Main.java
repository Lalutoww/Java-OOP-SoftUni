package vehicleextension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] carData = sc.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));

        String[] truckData = sc.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]), Double.parseDouble(truckData[3]));

        String[] busData = sc.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]), Double.parseDouble(busData[3]));

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];

            try {
                switch (command) {
                    case "Drive": {
                        double kilometers = Double.parseDouble(input[2]);
                        switch (vehicleType) {
                            case "Car": {
                                driveVehicle(car, kilometers);
                                break;
                            }
                            case "Truck": {
                                driveVehicle(truck, kilometers);
                                break;
                            }
                            case "Bus": {
                                driveVehicle(bus, kilometers);
                                break;
                            }
                        }
                        break;
                    }
                    case "Refuel": {
                        double fuelQuantity = Double.parseDouble(input[2]);
                        switch (vehicleType) {
                            case "Car": {
                                refuelVehicle(car, fuelQuantity);
                                break;
                            }
                            case "Truck": {
                                refuelVehicle(truck, fuelQuantity);
                                break;
                            }
                            case "Bus": {
                                refuelVehicle(bus, fuelQuantity);
                                break;
                            }
                        }
                        break;
                    }
                    case "DriveEmpty": {
                        double kilometers = Double.parseDouble(input[2]);
                        bus.driveEmpty(kilometers);
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void driveVehicle(Vehicle vehicle, double kilometers) {
        vehicle.drive(kilometers);
    }

    private static void refuelVehicle(Vehicle vehicle, double kilometers) {
        vehicle.refuel(kilometers);
    }
}
