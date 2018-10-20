import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Withdraw {
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
			int bal = -1,id=1;
			if(rs.next()) {
				System.out.println("Welcome "+rs.getString(5)+" "+rs.getString(6));
			bal=rs.getInt(7);
			id=rs.getInt(1);}
			if(bal==-1)
			{
				System.out.println("Wrong Pin");
				System.exit(0);
			}
			System.out.println("Enter Amount to withdraw");
			int amount=sc.nextInt();
			if(amount>40000) {
				System.out.println("Limit is Rs.40000");
				System.exit(0);
			}
			else if(amount>bal) {
				System.out.println("Enough Fund Not Available");
				System.exit(0);
			}
			else if(amount%500==0)
			bal-=amount;
			else {
			System.out.println("Amount must be multiple of Rs.500");
			System.exit(0);	
			}
			stmt.executeUpdate("update banking set balance="+bal+" where pin="+pin);
			stmt.executeUpdate("insert into transactions(id,amount,portal,dateandtime,balance) values("+id+","+"-"+amount+","+"\'ATM\'"+","+"NOW()"+","+bal+")");
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			if(rs1.next())
			System.out.println("New Balance is = "+rs1.getInt(7));
			//sc.close();
			con.close();  
			}catch(Exception e){ System.out.println(e);}
	}

}
