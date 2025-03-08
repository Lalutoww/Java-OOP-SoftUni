package behavioral.template;

public abstract class PhoneOrderTemplate {
    final void createOrder() {
        selectProduct();
        packProduct();
        makePayment();
        deliverProduct();
    }

    abstract void selectProduct();

    abstract void makePayment();

    void packProduct() {
        System.out.println("packing the product...");
    }

    abstract void deliverProduct();
}
