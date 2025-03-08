package creational.factory;

import creational.factory.dishes.Dish;
import creational.factory.factories.DishFactory;
import creational.factory.factories.PizzaFactory;
import creational.factory.factories.SushiFactory;

public class Main {
    public static void main(String[] args) {
        DishFactory pizzaFactory = new PizzaFactory();
        Dish pizza = pizzaFactory.createdish();
        pizza.prepare();
        pizza.serve();

        DishFactory sushiFactory = new SushiFactory();
        Dish sushi = sushiFactory.createdish();
        sushi.prepare();
        sushi.serve();
    }
}
