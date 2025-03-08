package behavioral.template;

public class StoreOrder extends PhoneOrderTemplate {
    @Override
    void selectProduct() {
        System.out.println("Selecting the product available in the store...");
    }

    @Override
    void makePayment() {
        System.out.println("Paying the store clerk...");
    }

    @Override
    void deliverProduct() {
        System.out.println("Getting the product and leaving the store...");
    }
}
