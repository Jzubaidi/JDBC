import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class second {

	public static void main(String[] args) throws Exception {
		Connection conn = null;

		try {
			
		    conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sys2", "root", "123456789");
			if(conn != null) {
				System.out.println("Created DB Connection....");
			}
			
		} catch (Exception e) {
			System.out.println("Created DB not Connection....");
			
	
		}
		Statement stmt= conn.createStatement(); 
		ResultSet rs= stmt.executeQuery("select * from person");
		String st= "insert into person(ID,FN) value(90,'Moh')";
		PreparedStatement ps= conn.prepareStatement(st);
		ps.execute(st);
		String st1= "insert into person(ID,FN) value(?,?)";
		//PreparedStatement ps2= conn.prepareStatement(st1);
//		Scanner Sc= new Scanner(System.in);
//		int x=Sc.nextInt();
//		String y=Sc.nextLine();
//		ps2.setInt(1, x);
//		ps2.setString(2, y);
//		ps2.execute();
		
		while (rs.next()) {
			
			System.out.println(rs.getString("FN")+','+ rs.getInt("ID"));
		}
		//ps2.close();

		conn.close();
	}

}
