package behavioral.observer;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();

        StockObserver investor1 = new Investor("Martin", "Lalutov", 19);
        StockObserver investor2 = new Investor("Joe", "Johnson", 35);

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        stockMarket.notifyObservers("GOOGL", 173.86); // Both investors receive updates
        stockMarket.notifyObservers("AAPL", 239.07); // Both investors receive updates

        stockMarket.removeObserver(investor2);

        stockMarket.notifyObservers("AMZN", 199.25); // only investor1 receives the update
    }
}
