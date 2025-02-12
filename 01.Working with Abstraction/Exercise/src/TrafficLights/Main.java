package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] colors = sc.nextLine().split("\\s+");

        List<TrafficLight> trafficLights = getTrafficLights(colors);

        int rotations = Integer.parseInt(sc.nextLine());

        rotateTrafficLightColors(rotations, trafficLights);
    }

    private static void rotateTrafficLightColors(int rotations, List<TrafficLight> trafficLights) {
        for (int i = 0; i < rotations; i++) {
            changeLightColor(trafficLights);
            System.out.println();
        }
    }

    private static void changeLightColor(List<TrafficLight> trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.changeColor(trafficLight.getColor());
            System.out.print(trafficLight.getColor() + " ");
        }
    }

    private static List<TrafficLight> getTrafficLights(String[] colors) {
        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String color : colors) {
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);
        }
        return trafficLights;
    }
}
