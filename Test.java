import java.sql.*;  
class Test{
public static void main(String args[]){  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from employees");
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDate(5));
con.close();  
}catch(Exception e){ System.out.println(e);}
}
}