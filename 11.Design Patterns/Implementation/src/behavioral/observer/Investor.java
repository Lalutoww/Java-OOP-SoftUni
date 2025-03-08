package behavioral.observer;

public class Investor extends Person implements StockObserver {

    public Investor(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }


    @Override
    public void update(String stockTicker, double stockPrice) {
        System.out.println(this.getFullName() + " received an update for " + stockTicker + ": $" + stockPrice);
    }
}
