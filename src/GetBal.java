import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GetBal {

	 {
try{  		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
			Statement stmt=con.createStatement();  
			//Console c = System.console();
	    	System.out.println("Please Enter Your Pin");
	    	Scanner sc = new Scanner(System.in);
			String pin = sc.next();
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			int bal = -1;//,id=1;
			if(rs1.next()) {
				//System.out.println("Welcome "+rs.getString(5)+" "+rs.getString(6));
			bal=rs1.getInt(7);
			//id=rs.getInt(1);
			}
			if(bal==-1)
			{
				System.out.println("Wrong Pin");
				System.exit(0);
			}
			ResultSet rs=stmt.executeQuery("select * from banking where pin="+pin);
			if(rs.next())
			{System.out.println("Welcome "+rs.getString(5)+" "+rs.getString(6));
				System.out.println("Balance is = "+rs.getInt(7));
			}	con.close();  
				//sc.close();
				}catch(Exception e){ System.out.println(e);}
	}

}
