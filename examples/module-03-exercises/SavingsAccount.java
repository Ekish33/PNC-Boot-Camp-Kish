
public class SavingsAccount extends Account {
    public SavingsAccount(String id, double balance) {
        super(id, balance);   // explicitly calls Account's real constructor
    }
    public void showInfo() {
    // accountNumber -> Not accessible (private)
    // balance -> Not accessible (default)
    // interestRate -> Accessible (protected)
    System.out.println(interestRate); // OK
    // bankName -> Accessible (public)
    System.out.println(bankName); // OK
    // System.out.println(accountNumber); // Error
    }
}