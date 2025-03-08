package behavioral.observer;

public interface StockMarket {
    void registerObserver(StockObserver observer);

    void removeObserver(StockObserver observer);

    void notifyObservers(String stockTicker, double stockPrice);
}
