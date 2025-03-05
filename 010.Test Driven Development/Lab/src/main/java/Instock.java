//created by J.M.

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public Integer getCount() {
        return products.size();
    }

    @Override
    public Boolean contains(Product product) {
        return products.containsKey(product.label);
    }

    @Override
    public void add(Product product) {
        products.putIfAbsent(product.getLabel(), product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        Product product = products.get(label);
        if (product == null) {
            throw new IllegalArgumentException();
        }

        product.setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return this.products.values().stream().toList().get(index);

    }

    @Override
    public Product findByLabel(String label) {
        Product product = products.get(label);
        if (product == null) {
            throw new IllegalArgumentException();
        }

        return product;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > products.size() || count <= 0) {
            return new ArrayList<>();
        }

        return products.values().stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return null;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return null;
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
