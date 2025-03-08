package behavioral.template;

public class OnlineOrder extends PhoneOrderTemplate {
    @Override
    void selectProduct() {
        System.out.println("selecting the product in online store...");
    }

    @Override
    void makePayment() {
        System.out.println("using card to pay for the product...");
    }

    @Override
    void deliverProduct() {
        System.out.println("product delivered to the client.");
    }
}
