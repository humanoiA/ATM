import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ministatement {
	{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
			Statement stmt=con.createStatement();  
			System.out.println("Enter Pin");
			Scanner sc = new Scanner(System.in);
			String pin = sc.next();
			ResultSet rs=stmt.executeQuery("select * from banking where pin="+pin);
			int id=1,bal=-1;
			if(rs.next()) {
				System.out.println("Welcome "+rs.getString(5)+" "+rs.getString(6));
			id=rs.getInt(1);
			bal=0;}
			if(bal==-1)
			{
				System.out.println("Wrong Pin");
				System.exit(0);
			}
			ResultSet rs1=stmt.executeQuery("select * from transactions where id="+id);
			System.out.println("Transaction ID\tCredit/Debit\tPortal\tDate\t\tTime\tBalance");
			while(rs1.next()) {
				System.out.println(rs1.getInt(1)+"\t\t"+rs1.getString(3)+"\t\t"+rs1.getString(4)+"\t"+rs1.getTimestamp(5)+"\t"+rs1.getInt(6));
				}
		//	sc.close();
			con.close();  
			}catch(Exception e){ System.out.println(e);}
	}
}
