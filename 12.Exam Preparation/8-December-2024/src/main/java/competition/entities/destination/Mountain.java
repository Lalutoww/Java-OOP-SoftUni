package competition.entities.destination;

public class Mountain extends BaseDestination {
    private static final int DISTANCE_NEEDED = 60;

    public Mountain(String name) {
        super(name, DISTANCE_NEEDED);
    }
}
