package HotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int numberOfDays, String season, String discountType) {
        double totalPrice = pricePerDay * numberOfDays;
        totalPrice *= Season.fromString(season).getMultiplier();

        totalPrice *= Discount.fromString(discountType).getPercentage();

        return totalPrice;
    }
}
