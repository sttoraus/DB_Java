import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.xdevapi.Statement;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dbConnection.connect();
			stmt = con.prepareStatement("update konto set stand=stand+10 where userId=1");
			int x = stmt.executeUpdate();
			System.out.println("Done =)");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/** Schritt 6: Ressourcen freigeben */
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}