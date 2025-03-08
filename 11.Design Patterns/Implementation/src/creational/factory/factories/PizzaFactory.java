package creational.factory.factories;

import creational.factory.dishes.Dish;
import creational.factory.dishes.Pizza;

public class PizzaFactory implements DishFactory {
    @Override
    public Dish createdish() {
        return new Pizza();
    }
}
