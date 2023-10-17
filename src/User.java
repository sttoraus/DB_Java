import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<String> warenkorb=new ArrayList<>();
    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }
    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
    
    public String getPassword() {
    	return this.password;
    }
    // Getter und Setter für die Eigenschaften id und username
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void addProdukt(String produkt) {
    	warenkorb.add(produkt);
    }
    public void printWarenkorb() {
    	for(String i:warenkorb) {
    		System.out.println(i);
    	}
    }
}
