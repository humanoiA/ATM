import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Transfer {

	 {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
		Statement stmt=con.createStatement();
		System.out.println("Enter Pin");
		Scanner sc = new Scanner(System.in);
		String pin = sc.next();
		ResultSet rs=stmt.executeQuery("select * from banking where pin="+pin);
		int bal=-1,bal2=0,id1=0,id2=0;
		if(rs.next()) {System.out.println("Welcome "+rs.getString(5)+" "+rs.getString(6));
			bal=rs.getInt(7);
			id1=rs.getInt(1);}
		if(bal==-1)
		{
			System.out.println("Wrong Pin");
			System.exit(0);
		}
		System.out.println("Enter account no to tranfer funds to");
		String accountno=sc.next();
		ResultSet rs1=stmt.executeQuery("select * from banking where accountnumber="+accountno);
		if(rs1.next())
			{
			System.out.println("Do You Want to transfer funds to "+rs1.getString(5)+" "+rs1.getString(6));
			bal2=rs1.getInt(7);
			id2=rs1.getInt(1);
			}
		System.out.println("Enter Amount to Transfer");
		int amount=sc.nextInt();
		if(amount>bal)
		{
			System.out.println("Insufficient Funds");
			System.exit(0);
		}
		bal-=amount;
		bal2+=amount;
		stmt.executeUpdate("update banking set balance="+bal+" where pin="+pin);
		stmt.executeUpdate("update banking set balance="+bal2+" where accountnumber="+accountno);
		stmt.executeUpdate("insert into transactions(id,amount,portal,dateandtime,balance) values("+id1+","+"-"+amount+","+"\'ATM\'"+","+"NOW()"+","+bal+")");
		stmt.executeUpdate("insert into transactions(id,amount,portal,dateandtime,balance) values("+id2+","+"+"+amount+","+"\'ATM\'"+","+"NOW()"+","+bal2+")");
		System.out.println("Fund Transfer Successfull");
			con.close();  
			//sc.close();
			}catch(Exception e){ System.out.println(e);}
	}
}

