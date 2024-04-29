public class Account {
    private double balance;
    private int accountNumber;
    static int numberOfAccounts = 1000;

    public Account(double initialDeposit){
        this.balance = initialDeposit;
        this.accountNumber = numberOfAccounts;
        numberOfAccounts = numberOfAccounts + 1;
    }
    public void Deposit(double depositAmount){
        balance += depositAmount;
        System.out.println("New Balance: " + balance);

    }
    public void Withdraw(double withdrawAmount){
        if(withdrawAmount >= balance){
            System.out.println("Insufficient funds");
        }else {
            balance -= withdrawAmount;
            System.out.println("New Balance: " + balance);
        }
    }
    @Override
    public String toString() {
        return String.format("Account Number: %s\n" +
                        "Balance: %.2f\n\n",
                accountNumber, balance);
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
}
