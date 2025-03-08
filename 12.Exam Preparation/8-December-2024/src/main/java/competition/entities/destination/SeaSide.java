package competition.entities.destination;

public class SeaSide extends BaseDestination {
    private static final int DISTANCE_NEEDED = 80;

    public SeaSide(String name, int distance) {
        super(name, DISTANCE_NEEDED);
    }
}
