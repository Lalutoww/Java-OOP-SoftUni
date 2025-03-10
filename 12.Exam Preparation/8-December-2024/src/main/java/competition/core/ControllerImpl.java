package competition.core;

import competition.common.ConstantMessages;
import competition.common.ExceptionMessages;
import competition.entities.car.*;
import competition.entities.competition.Competition;
import competition.entities.competition.CompetitionImpl;
import competition.entities.destination.Destination;
import competition.entities.destination.Lake;
import competition.entities.destination.Mountain;
import competition.entities.destination.SeaSide;
import competition.entities.repositories.DestinationRepository;

import java.util.Collection;
import java.util.List;

import static competition.common.ConstantMessages.CARS_TOOK_PART;
import static competition.common.ConstantMessages.FINAL_CAR_INFO;
import static competition.common.ExceptionMessages.EXISTING_CAR_BRAND_AND_MODEL;
import static competition.common.ExceptionMessages.NON_EXISTING_DESTINATION;

public class ControllerImpl implements Controller {
    private final DestinationRepository destinations;

    public ControllerImpl() {
        destinations = new DestinationRepository();
    }

    private static List<Car> getDroppedOutCars(Destination destination) {
        return destination.getCars().stream()
                .filter(car -> (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() <= 0)
                        || (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() < 15))
                .toList();
    }

    private static void extracted(Car car, StringBuilder build) {

        build.append(String.format(FINAL_CAR_INFO,
                car.getClass().getSimpleName(),
                car.getModel(),
                car.getBatteryCapacity(),
                car.getMileage())).append(System.lineSeparator());
    }

    @Override
    public String addDestination(String destinationType, String destinationName) {
        Destination destination;
        switch (destinationType) {
            case "Lake":
                destination = new Lake(destinationName);
                break;
            case "Mountain":
                destination = new Mountain(destinationName);
                break;
            case "SeaSide":
                destination = new SeaSide(destinationName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DESTINATION);
        }

        if (destinations.byName(destinationName) != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_DESTINATION);
        }

        destinations.add(destination);
        return String.format(ConstantMessages.DESTINATION_ADDED, destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {
        Car car;
        Destination destination = destinations.byName(destinationName);

        if (destination == null) {
            throw new NullPointerException(NON_EXISTING_DESTINATION);
        }

        Car carByModel = destination.getCars().stream().filter(c -> c.getModel().equals(carModel))
                .findFirst().orElse(null);

        if (carByModel != null) {
            throw new IllegalArgumentException(EXISTING_CAR_BRAND_AND_MODEL);
        }

        switch (carBrand) {
            case "VW":
                car = new VW(carModel);
                break;
            case "Hyundai":
                car = new Hyundai(carModel);
                break;
            case "Tesla":
                car = new Tesla(carModel);
                break;
            case "Dacia":
                car = new Dacia(carModel);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR);
        }

        destination.getCars().add(car);

        return String.format(ConstantMessages.CAR_ADDED, carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {
        Competition competition = new CompetitionImpl();
        Destination destination = destinations.byName(destinationName);

        competition.startVoyage(destination, destination.getCars());

        int droppedOutCars = getDroppedOutCars(destination).size();
        return String.format(ConstantMessages.VOYAGE_OVER, destinationName, droppedOutCars);
    }

    @Override
    public String getStatistics() {

        StringBuilder build = new StringBuilder();
        Collection<Destination> allDestinations = destinations.getCollection();

        for (Destination destination : allDestinations) {
            build.append(String.format(CARS_TOOK_PART, destination.getName())).append(System.lineSeparator());
            for (Car car : destination.getCars()) {
                extracted(car, build);
            }
        }
        return build.toString();
    }
}
