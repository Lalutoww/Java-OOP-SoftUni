package HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public static Season fromString(String seasonAsString) {
        return Season.valueOf(seasonAsString.toUpperCase());
    }

    public int getMultiplier() {
        return multiplier;
    }
}
