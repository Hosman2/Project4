import java.util.ArrayList;
public class Bank {
    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    private ArrayList<VIPCustomer> vipCustomerArrayList = new ArrayList<>();
    public void addCustomer(Customer customer){
        customerArrayList.add(customer);
    }
    public void removeCustomer(Customer customer){
        customerArrayList.remove(customer);
    }
    public ArrayList<Customer> getCustomerArrayList(){
        return customerArrayList;
    }

    public Customer getCustomer(int pin){
        Customer foundCustomer = null;
        for(Customer customer : customerArrayList){
            if (customer.getPin() == (pin)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public VIPCustomer getVIPCustomer(int pin){
        VIPCustomer foundvipCustomer = null;
        for(VIPCustomer VIPCustomer : vipCustomerArrayList){
            if (VIPCustomer.getPin() == (pin)){
                foundvipCustomer = VIPCustomer;
                break;
            }
        }
        return foundvipCustomer;
    }
    public StringBuilder getAllCustomerInfo(){
        StringBuilder customerStringBuilder = new StringBuilder();
        for(Customer customer : customerArrayList){
            customerStringBuilder.append(customer.toString());
        }
        return customerStringBuilder;
    }
}
