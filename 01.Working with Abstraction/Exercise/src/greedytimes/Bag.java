package greedytimes;

import java.util.*;
import java.util.stream.Collectors;

import static greedytimes.ItemType.*;

public class Bag {

    private final long capacity;
    private final List<Item> items;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        if (!isCapacityExceeded(item)) {
            items.add(item);
        }
    }

    private boolean isCapacityExceeded(Item item) {
        if (capacity < getBagValue() + item.getAmount()) {
            return true;
        }
        switch (item.getItemType()) {
            case GEM:
                if (getTypeAmount(GEM) + item.getAmount() > getTypeAmount(GOLD)) {
                    return true;
                }
                break;
            case CASH:
                if (getTypeAmount(CASH) + item.getAmount() > getTypeAmount(GEM)) {
                    return true;
                }
                break;
        }
        return false;
    }

    private long getBagValue() {
        return getTypeAmount(GOLD) + getTypeAmount(GEM) + getTypeAmount(CASH);
    }

    private long getTypeAmount(ItemType itemType) {
        return items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .mapToLong(Item::getAmount)
                .sum();
    }

    @Override
    public String toString() {
        return buildString();
    }

    private String buildString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values())
                .forEach(e -> {
                    long size = items.stream().filter(p -> p.getItemType().equals(e)).collect(Collectors.toList()).size();
                    if (size > 0) {
                        String itemName = e.toString().charAt(0) + e.toString().substring(1).toLowerCase();
                        sb.append(String.format("<%s> $%s", itemName, getTypeAmount(e))).append(System.lineSeparator());
                        sortValues(sb, e);
                    }
                });
        return sb.toString().trim();
    }

    private void sortValues(StringBuilder sb, ItemType itemType) {
        Map<String, Long> values = new TreeMap<>();
        items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .forEach(e -> {
                    String itemName = e.getItemName();
                    values.putIfAbsent(itemName, 0L);
                    values.put(itemName, values.get(itemName) + e.getAmount());
                });

        Map<String, Long> sortedValues = new TreeMap<>(Collections.reverseOrder());
        values.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> {
                    sortedValues.putIfAbsent(e.getKey(), 0L);
                    sortedValues.put(e.getKey(), sortedValues.get(e.getKey()) + e.getValue());
                });

        sortedValues
                .forEach((name, amount) ->
                        sb.append(String.format("##%s - %s", name, amount)).append(System.lineSeparator()));
    }
}