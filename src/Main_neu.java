import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static DBService database = new DBService();
	public static void main(String[] args) {
		User user=new User();
		boolean repeat=true;
		while(repeat==true) {
			menu();
			switch(scanner.nextInt()){
	        case 1:
	            register();
	            break;
	        case 2:
	            user=login(user);
	            break;
	        case 3:
	            if(user.getLogin()) user.printWarenkorb();
	            break;
	        case 4:
	        	if(user.getLogin()) {
		        	System.out.println("Bitte Produkt eingeben");
		        	String produkt=scanner.next();
		        	user.addProdukt(produkt);
		        	database.addProduktToDB(user, produkt);
	        	}
	        	break;
	        case 5:
	        	repeat=false;
			}
		}
		System.out.println("Ende");

	}
	private static void register() {
		System.out.println("Benutzername: ");
		String username = scanner.next();
		System.out.println("Passwort: ");
		String password = scanner.next();
		database.registerUser(username,password);
		System.out.println("Benutzer wurde angelegt");
	}
	private static User login(User user) {
		System.out.println("Benutzername: ");
		String username = scanner.next();
		System.out.println("Passwort: ");
		String password = scanner.next();
		user.setUsername(username);
		user.setPassword(password);
		if (database.checkCredentials(user)) {
			database.setUserWarenkorb(user);
			user.setId(database.getUserId(user));
			user.setLogin(true);
			System.out.println("Login erfolgreich");
		} else {
			System.out.println("Login fehlgeschlagen");
		}
		return user;
	}
	public static void menu() {
		System.out.println("Was möchten Sie tun");
		System.out.println("1. User anlegen");
		System.out.println("2. Login");
		System.out.println("3. Warenkorb anzeigen");
		System.out.println("4. Produkt hinzufügen");
		System.out.println("5. Beenden");
	}
}
