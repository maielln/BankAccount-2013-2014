/***********************************************************************
 * This program is a class. It is a class that creates a bank account  *
 * It can create a bank account 1 of two ways:						   *
 *		1) Create an account with a balance of 0.                      *
 *		2) Create an account with a balance given from a program.      *
 * There are 3 methods/fuctions that this class does:				   *
 *		1) Deposits money into an account							   *
 *		2) Withdrawls money from an account							   *
 * 		3) Gets the balance by just viewing how much there is		   *
 ***********************************************************************/
import java.util.ArrayList;
import java.text.NumberFormat;

// Name of the Class
public class BankAccount
{
	//A variable that is used only for this class.
   	private double balance;
   	private String name;
   	private int transactions;
   	private ArrayList<String> trans = new ArrayList<String>();
   	NumberFormat formatter = NumberFormat.getCurrencyInstance();

	//Default constructor of a bank account.
	//No parameters. So Balance is 0.
	public BankAccount(String aName)
	{
		name = aName;
		balance = 0;
   	}

   	//Constructor but with a balance passed in from program.
   	public BankAccount(String aName, double initialBalance)
   	{
		name = aName;
		balance = initialBalance;
    }


    //Function of BankAccount that will deposit money into account
   	public void deposit(double amount)
   	{
		balance = balance + amount;
		transactions++;
		trans.add("A deposit was made in the amount of " + formatter.format(amount) + ". Balance = " + formatter.format(balance));
		//Add to ArrayList trans a deposit notice indicating the amount and the current balance

		//YOUR CODE HERE
    }


    //Function of BankAccount that will withdrawl money from the account.
    //If the balance is negative after the withdraw, the transaction is cancelled
    //and the an error message is displayed
    public void withdraw(double amount)
  	{
		if (balance - amount < 0)
		{
			System.out.println("Not enough funds to withdraw");
			trans.add("Not enough funds to withdraw");
			return;
		}
		balance = balance - amount;
		transactions++;
		trans.add("A withdrawel was made with the amount of " + formatter.format(amount) + ". Balance = " + formatter.format(balance));
		//Add to ArrayList trans a witdrawal notice indicating the amount and the current balance

		//YOUR CODE HERE
    }


    //Function of BankAccount that will apply an interest to the current account.
    //@param amount value 0 < amount < 1
    public void interest(double amount)
  	{
		balance = balance + (balance * amount);
    }

   	//A function that simply gets the balance to look at and returns
   	//to the program
   	public double getBalance()
   	{
		return balance;
   	}

   	//A function that simply gets the name of the bank account holder and returns
   	//to the program
   	public String getName()
   	{
		return name;
   	}

   	//A function that simply returns the number of deposits and withdraw
   	public int getTransactions()
   	{
		return transactions;
	}







	//A function that prints out all the transactions of the bank account
	public void printTransactions()
	{
		for(int i = 0; i < transactions + 1; i++)
		{
			System.out.println(trans.get(i));
		}
		//The print out of the transactions should say the following
		//1.A deposit was made in the amount of $100. Balance = $200
		//2.A withdrawl was made in the amount of $50. Balance = $175
		//3.A withdrawl was made in the amount of $20. Balance = $155
		//4.A deposit was made in the amount of $324.92. Balance = $479.92

		//YOUR CODE HERE
	}
}
