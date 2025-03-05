import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstockTest {
    private ProductStock stock;
    private Product[] products;

    @BeforeEach
    void prepare() {
        this.stock = new Instock();
        this.products = prepareProducts();
    }

    private Product[] prepareProducts() {
        Product[] products = new Product[5];
        products[0] = new Product("Airqn", 2.00, 10);
        products[1] = new Product("Burger", 13.50, 5);
        products[2] = new Product("Kashkaval", 3.70, 22);
        products[3] = new Product("Hlqb", 2.99, 30);
        products[4] = new Product("Sirene", 7.56, 15);
        return products;
    }

    private List<Product> PutIterItemsInList(Iterable<Product> iterable) {
        List<Product> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Test
    void testContainsSuccess() {
        assertFalse(stock.contains(products[0]));

        stock.add(products[0]);
        assertTrue(stock.contains(products[0]));
    }

    @Test
    void testCountReturnsCorrectNumberOfProducts() {
        assertEquals(0, stock.getCount());

        stock.add(products[0]);
        assertEquals(1, stock.getCount());
        stock.add(products[1]);
        assertEquals(2, stock.getCount());
    }

    @Test
    void testFindReturnsTheCorrectProduct() {
        stock.add(products[0]);
        stock.add(products[1]);
        stock.add(products[2]);

        assertEquals(products[0], stock.find(0));
        assertEquals(products[1], stock.find(1));
        assertEquals(products[2], stock.find(2));
    }

    @Test
    void testFindThrowsExceptionWhenGivenInvalidIndex() {
        stock.add(products[0]);

        assertThrows(IndexOutOfBoundsException.class, () -> stock.find(1));
    }

    @Test
    void testChangeQuantityOfGivenProductSuccessfully() {
        stock.add(products[0]);
        assertEquals(10, stock.find(0).getQuantity());


        stock.changeQuantity("Airqn", 2);
        assertEquals(2, stock.find(0).getQuantity());
    }

    @Test
    void testChangeQuantityThrowsExceptionWhenProductIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> stock.changeQuantity("invalid_label", 2));
    }

    @Test
    void testFindByLabelReturnsTheCorrectProduct() {
        stock.add(products[0]);
        stock.add(products[1]);

        assertEquals(products[0], stock.findByLabel("Airqn"));
        assertEquals(products[1], stock.findByLabel("Burger"));
    }

    @Test
    void testFindByLabelThrowsExceptionWhenGivenInvalidLabel() {
        assertThrows(IllegalArgumentException.class, () -> stock.findByLabel("invalid_label"));
    }

    @Test
    void testFindFirstByAlphabeticalOrderReturnsNthElementsSorted() {
        stock.add(products[0]);
        stock.add(products[1]);
        stock.add(products[2]);
        stock.add(products[3]);

        List<Product> result = PutIterItemsInList(stock.findFirstByAlphabeticalOrder(3));
        Product[] expectedResult = {products[0], products[1], products[3]};

        assertArrayEquals(expectedResult, result.toArray(new Product[0]));
    }

    @Test
    void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionIfCountIsOutOfBounds() {
        List<Product> result = PutIterItemsInList(stock.findFirstByAlphabeticalOrder(3));
        assertArrayEquals(new Product[0], result.toArray(new Product[0]));
    }
}