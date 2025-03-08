package competition.entities.destination;

import competition.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;

import static competition.common.ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY;
import static competition.common.ExceptionMessages.NEGATIVE_DISTANCE_VALUE;

public class BaseDestination implements Destination {
    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        this.setName(name);
        this.setDistance(distance);
        this.cars = new ArrayList<>();
    }

    @Override
    public Collection<Car> getCars() {
        return this.cars;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(DESTINATION_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }
}
