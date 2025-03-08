package behavioral.observer;

public interface StockObserver {
    void update(String stockTicker, double stockPrice);
}
