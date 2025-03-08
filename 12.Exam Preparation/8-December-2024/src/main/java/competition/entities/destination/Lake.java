package competition.entities.destination;

public class Lake extends BaseDestination {
    private final static int DISTANCE_NEEDED = 25;

    public Lake(String name) {
        super(name, DISTANCE_NEEDED);
    }
}
