import java.util.Scanner;
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Bank record = new Bank();

    public void displayMenu() {
        while (true) {
            String selection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.print("Please make a selection:\n" +
                    "1) Access Account\n" +
                    "2) Open a New Account\n" +
                    "3) Close All Accounts\n" +
                    "4) Exit\n"
            );
            selection = scanner.nextLine();

            if (selection.equals("1")) {
                accessAccount();
            } else if (selection.equals("2")) {
                openAccount();
            } else if (selection.equals("3")) {
                closeAllAccounts();
            } else if (selection.equals("4")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid entry");
            }

        }
    }

    private void accessAccount() {

        int userPin;
        System.out.print("Enter the PIN of the Account: ");
        userPin = Integer.parseInt(scanner.nextLine());
        Customer customer = record.getCustomer(userPin);
        if (customer == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println(customer.getAllAccounts());
            System.out.println("Enter The Account Number: ");
            int accountNumber = Integer.parseInt(scanner.nextLine());
            Account account = customer.getAccountByNumber(accountNumber);
            if (account == null) {
                System.out.println("Account Number Invalid");
            } else {
                VIPCustomer vip = record.getVIPCustomer(userPin);
                if (account.getBalance() > 10000) {
                    vip = new VIPCustomer(customer.getFname(), customer.getLname(), customer.getPin());
                    System.out.println("You are now a VIP customer since your account has more than $10,000!");
                }
                accountMenu(customer, account, vip);

            }
        }
    }

    private void accountMenu(Customer customer, Account account, VIPCustomer vip) {
        while (true) {
            if(account.getBalance() > 10000){
                System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
                System.out.print("Please make a selection:\n" +
                        "1) Deposit\n" +
                        "2) Withdraw\n" +
                        "3) See Account Balance\n" +
                        "4) Close Account\n" +
                        "5) Add A VIP Note\n" +
                        "6) Remove VIP Note\n" +
                        "7) Display All Current VIP Notes\n" +
                        "8) Exit\n"
                );
                String selection = scanner.nextLine();
                if (selection.equals("1")) {
                    System.out.print("Enter deposit amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.Deposit(amount);
                } else if (selection.equals("2")) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.Withdraw(amount);
                } else if (selection.equals("3")) {
                    System.out.println("Account" + account.getAccountNumber() + "\nBalance: " + account.getBalance());
                } else if (selection.equals("4")) {
                    customer.removeAccount(account);
                } else if (selection.equals("5")) {
                    System.out.println("Enter your VIP note title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter the content of the note: ");
                    String content = scanner.nextLine();
                    vip.addVIPNote(title, content);
                    System.out.println("Note has been added.");
                }else if(selection.equals("6")){
                    System.out.println("Enter the title of the VIP note that you want to remove: ");
                    String title = scanner.nextLine();
                    if(vip.getVIPNote(title) == null){
                        System.out.println("Note not found.");
                    }else {
                        vip.removeVIPNote(title);
                        System.out.println("Note has been removed.");
                    }
                }else if(selection.equals("7")){
                    vip.displayVIPNotes();
                }else if(selection.equals("8")){
                    System.out.println("Exiting account menu");
                    break;
                }
            }else {
                System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
                System.out.print("Please make a selection:\n" +
                        "1) Deposit\n" +
                        "2) Withdraw\n" +
                        "3) See Account Balance\n" +
                        "4) Close Account\n" +
                        "5) Exit\n"
                );
                String selection = scanner.nextLine();
                if (selection.equals("1")) {
                    System.out.print("Enter deposit amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.Deposit(amount);
                } else if (selection.equals("2")) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.Withdraw(amount);
                } else if (selection.equals("3")) {
                    System.out.println("Account" + account.getAccountNumber() + "\nBalance: " + account.getBalance());
                } else if (selection.equals("4")) {
                    customer.removeAccount(account);
                } else if (selection.equals("5")) {
                    System.out.println("Exiting account menu");
                    break;
                }
            }
        }
    }
    private Customer createCustomer() {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Please enter a 4 digit PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = new Customer(firstName, lastName, pin);
        record.addCustomer(customer);
        return customer;
    }
    private void openAccount() {

        System.out.println("Are you a new customer?\n1) Yes\n2) No\n");
        String newCustomer = scanner.nextLine();
        if (newCustomer.equalsIgnoreCase("1")) {
            Customer customer = createCustomer();
            System.out.println("Enter a deposit amount: ");
            double newDeposit = Double.parseDouble(scanner.nextLine());
            Account account = new Account(newDeposit);
            customer.addAccount(account);
            record.addCustomer(customer);
            System.out.println("New Account Opened:" + account.getAccountNumber());
        } else if (newCustomer.equalsIgnoreCase("2")) {
            System.out.println("Please enter PIN: ");
            int pin = Integer.parseInt(scanner.nextLine());
            Customer customer1 = record.getCustomer(pin);
            if (customer1 == null) {
                System.out.println("Pin is invalid");
            } else {
                System.out.println("Enter deposit amount: ");
                double newDeposit = Double.parseDouble(scanner.nextLine());
                Account account1 = new Account(newDeposit);
                customer1.addAccount(account1);
                System.out.println("New Account Opened: " + account1.getAccountNumber());
            }
        } else {
            System.out.println("Invalid Entry");
        }

    }
    private void closeAllAccounts(){
        System.out.println("What is your PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customer = record.getCustomer(pin);
        if(customer == null){
            displayMenu();
        }else{
            record.removeCustomer(customer);
            System.out.println("Accounts closed");
        }

    }
}
