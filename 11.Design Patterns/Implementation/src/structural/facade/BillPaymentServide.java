package structural.facade;

public class BillPaymentServide {
    public void payBill(String accountId, String billId, double amount) {
        System.out.println("Paying bill " + billId + " from account " + accountId + " with amount " + amount);
    }
}
