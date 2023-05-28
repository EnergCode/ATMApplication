package bank;

/**
 * Lead Author(s):
 * 
 * @author David De La Toba; 5550015120
 * @author N/A
 *         N/A
 * 
 *         Other contributors:
 *         N/A
 * 
 *         References:
 *         Morelli, R., and Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         How to round up to 2 decimal places in Java? - Intellipaat community.
 *         (2019, October 23). Online Professional Training Courses and
 *         Certification - Intellipaat.
 *         https://intellipaat.com/community/35143/how-to-round-up-to-2-decimal-
 *         places-in-java
 * 
 *         Alex Lee. (2020, February 13). Java GUI Tutorial. YouTube.
 *         https://www.youtube.com/watch?v=xk4_1vDrzzo&t=13s&ab_channel=BroCode
 * 
 *         N/A
 * 
 *         Version/date: v.2 5/25/2023
 * 
 *         Responsibilities of class: stores information about BankAcounts and
 *         performs basic get / set operations;
 */
public class BankAccount
{
	// has a accountNumber
	private int accountNumber;
	// has a name
	private String name;
	// has a balance
	private double balance = 0.00;
	// has a password
	private String password;

	/**
	 * constructo
	 * 
	 * @param accountNumber of BankAccount
	 * @param name          of BankAccount
	 * @param password      of BankAccount
	 * @param balance       of BankAccount
	 */
	public BankAccount(int accountNumber, String name, String password,
			double balance)
	{
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	/**
	 * getter
	 * 
	 * @return accountNumber for BankAccount
	 */
	public int getAccountNumber()
	{
		return accountNumber;
	}

	/**
	 * setter
	 * 
	 * @param accountNumber for BankAccount
	 */
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	/**
	 * getter
	 * 
	 * @return name for BankAccount
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * setter
	 * 
	 * @param name for BankAccount
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * getter
	 * 
	 * @return balance for BankAccount
	 */
	public double getBalance()
	{
		return balance;
	}

	/**
	 * setter
	 * 
	 * @param balance for BankAccount
	 */
	public void setBalance(double balance)
	{
		this.balance = Math.round((balance) * 100.0) / 100.0;
		;
	}

	/**
	 * getter
	 * 
	 * @return password for BankAccount
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * setter
	 * 
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * converts BankAccount information to string
	 */
	@Override
	public String toString()
	{
		return accountNumber + "-" + name + "-" + password + "-" + balance
				+ "-";
	}
}
