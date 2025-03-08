package behavioral.template;

public class Main {
    public static void main(String[] args) {
        PhoneOrderTemplate onlineStore = new OnlineOrder();
        onlineStore.createOrder();

        System.out.println();

        PhoneOrderTemplate physicalStore = new StoreOrder();
        physicalStore.createOrder();

    }
}
