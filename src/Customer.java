import java.util.ArrayList;
public class Customer {
    private String fname;
    private String lname;
    private int pin;

    private ArrayList<Account> accountArrayList = new ArrayList<>();
    public Customer(String fname, String lname, int pin){
        this.fname = fname;
        this.lname = lname;
        this.pin = pin;

    }

    public ArrayList<Account> getAccountArrayList(){
        return accountArrayList;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public int getPin(){
        return pin;
    }
    public void addAccount(Account account){
        accountArrayList.add(account);
    }
    public void removeAccount(Account account){
        accountArrayList.remove(account);
    }


    @Override
    public String toString() {
        return String.format("Name: %s%s\n" +
                        "PIN: %d\n\n",
                fname, lname, pin);
    }
    public StringBuilder getAllAccounts() {
        StringBuilder accountStringBuilder = new StringBuilder();
        for(Account account : accountArrayList){
            accountStringBuilder.append(account.toString());
        }
        return accountStringBuilder;
    }
    public Account getAccountByNumber(int accountNumber) {
        Account foundAccount = null;
//enhanced for loop
        for (Account account : accountArrayList) {
            if (account.getAccountNumber() == (accountNumber)) {
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }
}
