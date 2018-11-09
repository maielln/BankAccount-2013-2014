//--------------------
//Nicole Maiello
//6/4/15
//--------------------
import java.util.Scanner;
import java.text.NumberFormat;


public class yourbank
{
	public static void main(String[] args)
	{
		Scanner ahri = new Scanner(System.in);
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		String name = "";
		do
		{
			System.out.println("Please enter your name.");
			name = ahri.nextLine();
		}
		while (checkname(name) == true);

		double amount = 0;
		System.out.println("Please enter an amount that you'd like to start with.");
		amount = ahri.nextDouble();
		BankAccount myaccount;

		if(amount == 0)
			myaccount = new BankAccount(name);
		else
			myaccount = new BankAccount(name, amount);

		System.out.println("Your account has been made under the name " + name + " with " + formatter.format(myaccount.getBalance()) + " in it.");

		for(int i = 0; i < 5; i++)
		{
			System.out.println("What transaction would you like to preform? \n1. Deposit \n2. Withdraw");
			int ans = ahri.nextInt();

			if (ans == 1)
			{
				System.out.println("How much would you like to deposit?");
				double depos = ahri.nextDouble();
				myaccount.deposit(depos);
			}
			else if (ans == 2)
			{
				System.out.println("How much would you like to withdraw?");
				double with = ahri.nextDouble();
				myaccount.withdraw(with);
			}

		}
		System.out.println("-------Last 5 Transactions-------");
		myaccount.printTransactions();
		System.out.println("---------------------------------");
	}

	public static boolean checkname(String name)
	{
		if("0123456789".indexOf(name) > 0 || name.equals(""))
			return true;
		else
			return false;
	}
}