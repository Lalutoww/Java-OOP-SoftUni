//created by J.M.

import java.util.*;

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
                .limit(count).toList();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return products.values().stream().filter(p -> p.getPrice() > lo && p.getPrice() <= hi).sorted(Comparator.comparing(Product::getLabel).reversed()).toList();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.values().stream().filter(p -> p.getPrice() == price).toList();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > products.size() || count <= 0) {
            throw new IllegalArgumentException();
        }

        return products.values().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .toList();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.values().stream().filter(p -> p.getQuantity() == quantity).toList();
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
