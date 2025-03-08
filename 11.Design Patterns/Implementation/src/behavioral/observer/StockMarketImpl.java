package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarketImpl implements StockMarket {
    private final List<StockObserver> observers;

    public StockMarketImpl() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stockTicker, double stockPrice) {
        observers.forEach(o -> o.update(stockTicker, stockPrice));
    }
}
