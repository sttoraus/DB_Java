import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Benutzername: ");
        String username = scanner.nextLine();
        
        System.out.print("Passwort: ");
        String password = scanner.nextLine();
        User user=new User(username,password);
        DBService database=new DBService();
        if(database.checkCredentials(user)) {
        	System.out.println("geht");
        	System.out.println("User ID"+user.getId());
        }
        else {
        	System.out.println("geht nicht");
        }
        
    }
}