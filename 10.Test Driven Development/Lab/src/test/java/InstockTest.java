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
        return new Product[]{new Product("test_product_one", 2.00, 10),
                new Product("test_product_two", 13.50, 10),
                new Product("test_product_three", 3.70, 22),
                new Product("test_product_four", 2.99, 30),
                new Product("test_product_five", 7.56, 15),
                new Product("test_product_six", 2.00, 7)};
    }

    private void addProductsInStock() {
        stock.add(products[0]);
        stock.add(products[1]);
        stock.add(products[2]);
        stock.add(products[3]);
        stock.add(products[4]);
        stock.add(products[5]);
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
        addProductsInStock();

        assertEquals(products[0], stock.find(0));
        assertEquals(products[1], stock.find(1));
        assertEquals(products[2], stock.find(2));
    }

    @Test
    void testFindThrowsExceptionWhenGivenInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> stock.find(0));
    }

    @Test
    void testChangeQuantityOfGivenProductSuccessfully() {
        stock.add(products[0]);
        assertEquals(10, stock.find(0).getQuantity());


        stock.changeQuantity("test_product_one", 2);
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

        assertEquals(products[0], stock.findByLabel("test_product_one"));
        assertEquals(products[1], stock.findByLabel("test_product_two"));
    }

    @Test
    void testFindByLabelThrowsExceptionWhenGivenInvalidLabel() {
        assertThrows(IllegalArgumentException.class, () -> stock.findByLabel("invalid_label"));
    }

    @Test
    void testFindFirstByAlphabeticalOrderReturnsNthElementsSorted() {
        addProductsInStock();

        List<Product> result = PutIterItemsInList(stock.findFirstByAlphabeticalOrder(3));
        Product[] expectedResult = {products[4], products[3], products[0]};

        assertArrayEquals(expectedResult, result.toArray(new Product[0]));
    }

    @Test
    void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionIfCountIsOutOfBounds() {
        List<Product> result = PutIterItemsInList(stock.findFirstByAlphabeticalOrder(3));
        assertArrayEquals(new Product[0], result.toArray(new Product[0]));
    }

    @Test
    void testFindAllInRangeReturnsAllProductsWithinPriceRangeSortedInDescendingOrder() {
        addProductsInStock();

        List<Product> result = PutIterItemsInList(stock.findAllInRange(2.00, 3.70));
        Product[] expectedArr = new Product[]{products[2], products[3]};

        assertArrayEquals(expectedArr, result.toArray(new Product[0]));
    }

    @Test
    void testFindAllInRangeReturnsEmptyCollectionIfNoSuchProductsExist() {
        List<Product> result = PutIterItemsInList(stock.findAllInRange(15, 19.70));
        assertArrayEquals(new Product[0], result.toArray(new Product[0]));
    }

    @Test
    void testFindAllByPriceReturnsAllProductsInStockWithGivenPrice() {
        addProductsInStock();

        List<Product> result = PutIterItemsInList(stock.findAllByPrice(2.00));
        Product[] expectedArr = new Product[]{products[0], products[5]};

        assertArrayEquals(expectedArr, result.toArray(new Product[0]));
    }

    @Test
    void testFindAllByPriceReturnsEmptyCollectionIfNoProductsWereFound() {
        List<Product> result = PutIterItemsInList(stock.findAllByPrice(2.00));

        assertArrayEquals(new Product[0], result.toArray(new Product[0]));
    }

    @Test
    void findFirstMostExpensiveProductsReturnsTheFirstNProductsWithHighestPrice() {
        addProductsInStock();

        List<Product> result = PutIterItemsInList(stock.findFirstMostExpensiveProducts(3));
        Product[] expectedArr = new Product[]{products[1], products[4], products[2]};

        assertArrayEquals(expectedArr, result.toArray(new Product[0]));
    }

    @Test
    void findFirstMostExpensiveProductsThrowsExceptionIfArgumentsIsMoreThanTheExistingProducts() {
        int totalElementsInStock = stock.getCount();
        assertThrows(IllegalArgumentException.class, () -> stock.findFirstMostExpensiveProducts(totalElementsInStock + 1));
    }

    @Test
    void testFindAllByQuantityReturnsAllProductsInStockWithGivenQuantity() {
        addProductsInStock();

        List<Product> result = PutIterItemsInList(stock.findAllByQuantity(10));
        Product[] expectedArr = new Product[]{products[0], products[1]};

        assertArrayEquals(expectedArr, result.toArray(new Product[0]));
    }

    @Test
    void testFindAllByQuantityReturnsEmptyCollectionIfNoProductsWereFound() {
        List<Product> result = PutIterItemsInList(stock.findAllByQuantity(99));

        assertArrayEquals(new Product[0], result.toArray(new Product[0]));
    }
}