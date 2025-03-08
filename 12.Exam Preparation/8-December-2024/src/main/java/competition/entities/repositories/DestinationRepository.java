package competition.entities.repositories;

import competition.entities.destination.Destination;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DestinationRepository implements Repository<Destination> {
    private final Map<String, Destination> destinations;

    public DestinationRepository() {
        this.destinations = new LinkedHashMap<>();
    }


    @Override
    public Collection<Destination> getCollection() {
        return Collections.unmodifiableCollection(this.destinations.values());
    }

    @Override
    public void add(Destination destination) {
        this.destinations.put(destination.getName(), destination);
    }

    @Override
    public boolean remove(Destination destination) {
        Destination removed = this.destinations.remove(destination.getName());
        return removed != null;
    }

    @Override
    public Destination byName(String name) {
        return this.destinations.get(name);
    }
}
