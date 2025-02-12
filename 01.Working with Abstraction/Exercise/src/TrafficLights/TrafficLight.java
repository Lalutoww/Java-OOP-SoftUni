package TrafficLights;

public class TrafficLight {
    private String color;

    public TrafficLight(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void changeColor(String currentColor) {
        switch (Colors.valueOf(currentColor)) {
            case RED: {
                color = Colors.GREEN.getName();
                break;
            }
            case YELLOW: {
                color = Colors.RED.getName();
                break;
            }
            case GREEN: {
                color = Colors.YELLOW.getName();
                break;
            }
        }
    }
}
