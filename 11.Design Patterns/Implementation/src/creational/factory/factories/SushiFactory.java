package creational.factory.factories;

import creational.factory.dishes.Dish;
import creational.factory.dishes.Sushi;

public class SushiFactory implements DishFactory {
    @Override
    public Dish createdish() {
        return new Sushi();
    }
}
