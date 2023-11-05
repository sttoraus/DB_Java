import java.util.ArrayList;

public class User {
    private int id;
    private boolean login=false;
    public boolean getLogin() {
		return login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
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
    
    public User() {
		// TODO Auto-generated constructor stub
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
    public void setWarenkorb(ArrayList<String> warenkorb) {
    	this.warenkorb=warenkorb;
    }
}
