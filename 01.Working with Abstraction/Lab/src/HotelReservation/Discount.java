package HotelReservation;

public enum Discount {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private final double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public static Discount fromString(String discountAsString) {
        switch (discountAsString) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None": {
                return NONE;
            }
            default: {
                throw new IllegalArgumentException("Unknown discount type: " + discountAsString);
            }
        }
    }

    public double getPercentage() {
        return percentage;
    }
}
