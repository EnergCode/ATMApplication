package bank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
 *         Alex Lee. (2020, February 13). Java GUI Tutorial. YouTube.
 *         https://www.youtube.com/watch?v=xk4_1vDrzzo&t=13s&ab_channel=BroCode
 * 
 *         N/A
 * 
 *         Version/date: v.2 5/25/2023
 * 
 *         Responsibilities of class: this menu allows users to access options
 *         avaible to BankAccount users. This includes display balance,
 *         withdraw, deposit, and quit
 */
public class BankAccountMenu extends ATMMenu
{

	// has a title
	private JLabel title;
	// has a message
	private JTextField message;
	// has a displayBalance
	private JButton displayBalance;
	// has a deposit
	private JButton deposit;
	// has a withdraw
	private JButton withdraw;
	// has a quit
	private JButton quit;
	// has a depositText
	private JTextField depositText;
	// has a withdrawText
	private JTextField withdrawText;

	/**
	 * constructor
	 * 
	 * @param userBankAccount    this is the account that is being accessed
	 * @param informationStorage this allows object to send and recieve data
	 *                           from the informationStorage
	 */
	public BankAccountMenu(BankAccount userBankAccount,
			ATMInformationStorage informationStorage)
	{
		// creates the title label
		setStandardPanelSize();
		setLayout(null);
		title = new JLabel("Account Menu");
		title.setBounds(10, 20, 300, 25);
		title.setFont(new Font(Font.DIALOG, 1, 30));
		add(title);
		// creates the message below the title, this message displays
		// information about the account
		message = new JTextField();
		message.setText("Welcome");
		message.setBounds(10, 60, 200, 25);
		message.setEditable(false);
		add(message);
		// changes the label to display the current balance
		displayBalance = new JButton();
		displayBalance.setText("DisplayBalance");
		displayBalance.setBounds(10, 90, 200, 50);
		displayBalance.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// gets the balance and sets it as the next text for the message
				message.setText("Balance: $" + userBankAccount.getBalance());
			}
		});
		add(displayBalance);
		// this button is deposits whatever amount was in the depositTextfield
		deposit = new JButton();
		deposit.setText("Deposit");
		deposit.setBounds(10, 150, 200, 50);
		deposit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// stores the amount the user wishes to deposit
				double depositAmount;

				try
				{
					// ensures the user cant crash program with invalid text
					depositAmount = Double.parseDouble(depositText.getText());
				}
				catch (NumberFormatException e2)
				{
					depositText.setText("Must be double");
					return;
				}
				// sets the new balance of the account
				userBankAccount.setBalance(userBankAccount.getBalance()
						+ Double.parseDouble(depositText.getText()));
				// displays the new balance of the account
				message.setText(
						"New Balance: $" + userBankAccount.getBalance());
			}
		});
		add(deposit);
		// this it the JTextfield that recieves user input for deposit amount
		depositText = new JTextField("Enter Deposit Amount");
		depositText.setBounds(250, 150, 200, 50);
		add(depositText);

		// this button withdraws whatever amount was in the withdrawTextField
		withdraw = new JButton();
		withdraw.setText("Withdraw");
		withdraw.setBounds(10, 210, 200, 50);
		withdraw.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// amount to be withdrawn
				double withdrawAmount;
				// checks to see if there is anything to withdraw
				if (userBankAccount.getBalance() == 0)
				{
					withdrawText.setText("Account empty");
					return;
				}
				// ensures the user is trying to withdraw a valid amount
				try
				{
					withdrawAmount = Double.parseDouble(withdrawText.getText());
				}
				catch (Exception e2)
				{
					withdrawText.setText("Must be double");
					return;
				}
				// ensures withdrawAmount is positive
				if (withdrawAmount < 0)
				{
					withdrawText.setText("Must be positive");
					return;
				}
				// ensures the user is trying to withdraw an amount less than or
				// equal to what is in his balance
				if (withdrawAmount > userBankAccount.getBalance())
				{
					withdrawText.setText("More than you have in bank");
					return;
				}
				// sets the new balance
				userBankAccount.setBalance(
						userBankAccount.getBalance() - withdrawAmount);
				// updates the user about new balance
				message.setText(
						"New Balance: $" + userBankAccount.getBalance());

			}
		});
		add(withdraw);
		// this JTextField recieves the amount the user would like to withdraw
		withdrawText = new JTextField("Enter Withdraw Amount");
		withdrawText.setBounds(250, 210, 200, 50);
		add(withdrawText);
		// this button outputs the bank information and terminates program
		quit = new JButton();
		quit.setText("Quit");
		quit.setBounds(10, 270, 200, 50);
		quit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// outputs information
				informationStorage.outputBankData();
				// exits program
				System.exit(0);
			}
		});
		add(quit);
	}

}
