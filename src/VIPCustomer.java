import java.util.HashMap;
public class VIPCustomer extends Customer {
    private HashMap<String, String> vipNotes;

    public VIPCustomer(String fname, String lname, int pin){
        super(fname, lname, pin);
        this.vipNotes = new HashMap<>();
    }
    public void addVIPNote(String title, String noteMessage){
        vipNotes.put(title, noteMessage);
    }
    public void removeVIPNote(String title){
        vipNotes.remove(title);

    }

    public String getVIPNote(String title){
        return vipNotes.get(title);
    }

    public void displayVIPNotes(){
        System.out.println("All of your VIP notes: ");
        for(String title : vipNotes.keySet()){
            String note = vipNotes.get(title);
            System.out.println(title + ": " + note);
        }
    }
}
