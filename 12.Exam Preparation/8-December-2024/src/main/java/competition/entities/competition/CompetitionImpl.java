package competition.entities.competition;

import competition.entities.car.Car;
import competition.entities.destination.Destination;

import java.util.Collection;

public class CompetitionImpl implements Competition {

    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {
        for (Car car : cars) {
            while (car.getMileage() < destination.getDistance()) {
                if (car.getBatteryCapacity() < 15 || car.getBatteryCapacity() <= 0) {
                    break;
                }
                car.drive();
            }
        }
    }
}
