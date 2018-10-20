  
class Screen{
private static java.util.Scanner sc1;

public static void main(String args[]) throws java.util.NoSuchElementException{  
while(true) {
System.out.println("Welcome to Bandhan Bank\nENTER CHOICE\n1.WITHDRAW MONEY\n2.TRANSFER FUNDS\n3.CHANGE PIN\n4.CHANGE PHONE NUMBER\n5.MINI STATEMENT\n6.CHECK BALANCE");
sc1 = new java.util.Scanner(System.in);
int choice = sc1.nextInt();
switch (choice) {
case 1:
	new Withdraw();
	break;
case 2:
	new Transfer();
	break;
case 3:
	new Pin();
	break;
case 4:
	new Phone();
	break;
case 5:
	new ministatement();
	break;
case 6:
	new GetBal();
	break;
default:
	System.out.println("Wrong Choice");
	break;
}
//sc1.close();
}
}
}