package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

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
 *         N/A
 * 
 *         Version/date: v.2 5/25/2023
 * 
 *         Responsibilities of class: creates an administrator that can view
 *         data about the application while it is running and terminate the
 *         program with proper output for persistence if necessary.
 */
public class Administrator
{
	/**
	 * constructor starts loop
	 * @param informationStorage
	 */
	public Administrator(ATMInformationStorage informationStorage)
	{
		// allows user to select options
		do
		{
			displayPrompt();
			switch (verifySelectedOption())
			{
				case 1:
					displayInformationStorageInfo(informationStorage);
					break;

				case 2:
					informationStorage.outputBankData();
					System.exit(0);
					break;
			}
			
		} while (true);
	}
	/**
	 * verifies the option selected by user
	 * @return selectedOption
	 */
	private int verifySelectedOption()
	{
		// remains valid until made invalid which causes loop to stop
		boolean valid = true;
		// option selected by user
		int selectedOption = 0;
		// scans for keyboard input from user
		Scanner keyboard = new Scanner(System.in);
		do
		{
			// valid is true at start of every loop
			valid = true;
			try
			{
				selectedOption = keyboard.nextInt();
			}
			// catches bad input
			catch (InputMismatchException e)
			{
				valid = false;
				keyboard.nextLine();
				System.out.println("Invalid Input");
			}
			// prevents bad input from causing further crashed
			if(!valid);
			// checks for certain inputs
			else if (selectedOption != 1 && selectedOption != 2) {
				valid = false;
				System.out.println("Please select 1 or 2");
			}
		} while (!valid);
		// returns validated selectedOption
		return selectedOption;
	}
	/**
	 * this prompt displays the options available to the admin
	 */
	private void displayPrompt()
	{
		System.out.println("Press 1 to display BankAccount information to console");
		System.out.println("Press 2 terminate program");
	}
	/**
	 * This method displays the account number and name of all the BankAccounts
	 * @param informationStorage used to read informationStorage
	 */
	private void displayInformationStorageInfo(ATMInformationStorage informationStorage)
	{
		// information temporarily stored in a multidimensional aray
		String[][] tempStorage = new String[100][2];
		// iterates through x component of multidimensional array
		for(BankAccount bankAccount: informationStorage.getBankAccountList())
		{
			// checks for existence of account
			if(bankAccount != null)
			{
				// assigns the values to temporary array
				tempStorage[bankAccount.getAccountNumber()][0] = Integer.toString(bankAccount.getAccountNumber());
				tempStorage[bankAccount.getAccountNumber()][1] = bankAccount.getName();	
			}
		}
		// prints information from temporary array
		for(int i = 0; i < tempStorage.length; i++)
		{
			// iterates through temporary array and prints the values
			for(int j = 0; j < 2 && tempStorage[i][j] != null; j++)
			{
				if(j == 0)
				{
					System.out.print("Account Number: ");
					System.out.print(tempStorage[i][j]);
				}
				else if(j == 1)
				{
					System.out.print(" Account Name: ");
					System.out.println(tempStorage[i][j]);
				}
			}
		}
		System.out.println();

	}
}
