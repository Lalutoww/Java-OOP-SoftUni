package structural.facade;

public class Main {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade();
        bankingFacade.getAccountDetails("123");
        bankingFacade.transferFunds("123", "321", 10.0);
        bankingFacade.payBill("123", "BILL01", 25.0);
    }
}
