package bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
 *         Responsibilities of class: stores ArrayList of bankAccounts in use
 *         and allows for operations such as output and input for persistence
 */
public class ATMInformationStorage
{
	// has a bankAccountList
	ArrayList<BankAccount> bankAccountList;

	/**
	 * constructor initializes bankAccountList
	 */
	public ATMInformationStorage()
	{
		bankAccountList = new ArrayList<BankAccount>();
	}

	/**
	 * getter
	 * 
	 * @return bankAccountList stores the created BankAccounts
	 */
	public ArrayList<BankAccount> getBankAccountList()
	{
		return bankAccountList;
	}

	/**
	 * setter
	 * 
	 * @param bankAccountList stores the created BankAccounts
	 */
	public void setBankAccountList(ArrayList<BankAccount> bankAccountList)
	{
		this.bankAccountList = bankAccountList;
	}

	/**
	 * outputs the accountNumber, Username, Password, and Balance to a text file
	 */
	public void outputBankData()
	{
		// name of file for output
		String fileName = "ArrayListOfBankAccountsData.txt";
		// file for output
		File file = new File(fileName);
		// writes to file
		PrintWriter writer;
		// stores information to be written to file in string format
		String text = "";
		// iterates through bankAccountList
		for (BankAccount bankAccount : bankAccountList)
		{
			// checks to make sure element is not null
			if (bankAccount != null)
			{
				// to string method converts BankAccount information to String,
				// this information is appended to text
				text = text + bankAccount.toString();

				text = text + "\n";
			}
		}
		try
		{
			// creates new FileWriter with designated file name
			PrintWriter outStream = new PrintWriter(fileName);
			// writes the text to the file
			outStream.write(text);
			// closes the stream
			outStream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * inputs converts Strings from file back into BankAccount objects and
	 * restores the state of the array of bankAccountList to what it was before
	 * program termination
	 */
	public void inputBankData()
	{
		// file to be read from
		File file = new File("ArrayListOfBankAccountsData.txt");
		// reads information from file
		Scanner fromFile = null;
		// creates scanner object with file as argument
		try
		{
			fromFile = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		// will hold line from file separated into elements
		String[] separatedInfo;
		// loops until there are no more lines
		while (fromFile.hasNextLine())
		{
			// splits information apart into an array and assigns that array to
			// separatedInfo
			separatedInfo = fromFile.nextLine().split("-");

			// first element of array is used for the account number
			// second element of the array is used for name
			// third elemnt of the array is used for password
			// fourth element of the array is used for balance

			bankAccountList.add(new BankAccount(
					Integer.parseInt(separatedInfo[0]), separatedInfo[1],
					separatedInfo[2], Double.parseDouble(separatedInfo[3])));

		}
	}
}
