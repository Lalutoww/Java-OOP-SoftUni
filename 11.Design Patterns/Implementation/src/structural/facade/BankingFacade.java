package structural.facade;

public class BankingFacade {
    private final AccountService accountService;
    private final TransferService transferService;
    private final BillPaymentServide billPaymentServide;

    public BankingFacade() {
        this.accountService = new AccountService();
        this.transferService = new TransferService();
        this.billPaymentServide = new BillPaymentServide();
    }

    public void getAccountDetails(String accountId) {
        accountService.getAccountDetails(accountId);
    }

    public void transferFunds(String fromAccount, String toAccount, double amount) {
        transferService.transferFunds(fromAccount, toAccount, amount);
    }

    public void payBill(String accountId, String billId, double amount) {
        billPaymentServide.payBill(accountId, billId, amount);
    }
}
