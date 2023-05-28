package bank;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
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
 *         Responsibilities of class: creates components of the LoginMenu, and
 *         sets the format of the pane. It allows
 *         for logging into an account, creating a new account, and outputs
 *         informationStorage data upon termination.
 */
public class LoginMenu extends ATMMenu implements Verification
{

	// has a title
	private static JLabel title;
	// has a label
	private static JLabel label;
	// has a userNameText
	private static JTextField userNameText;
	// has a passwordLabel
	private static JLabel passwordlLabel;
	// has a passwordText
	private static JPasswordField passwordText;
	// has a submit
	private static JButton submit;
	// has a createAccount
	private static JButton createAccount;
	// has a instructions
	private static JTextArea instructions;
	// has a quit
	private JButton quit;

	/**
	 * constructor
	 * 
	 * @param frame                 used to update what is on the frame when the
	 *                              user needs to access BankAccountMenu
	 * @param atmInformationStorage used to send and recieve information
	 */
	public LoginMenu(JFrame frame, ATMInformationStorage atmInformationStorage)
	{
		setStandardPanelSize();
		// crates title label
		title = new JLabel("ATM");
		title.setFont(new Font(Font.DIALOG, 1, 30));
		title.setBounds(225, 20, 80, 25);
		setLayout(null);
		add(title);
		// creates username label
		label = new JLabel("Username");
		label.setBounds(80, 95, 80, 25);
		add(label);
		// creates textfield for username
		userNameText = new JTextField();
		userNameText.setBounds(180, 95, 165, 25);
		add(userNameText);
		// creates password label
		passwordlLabel = new JLabel("Password");
		passwordlLabel.setBounds(80, 125, 80, 25);
		add(passwordlLabel);
		// creates password text
		passwordText = new JPasswordField();
		passwordText.setBounds(180, 125, 165, 25);
		add(passwordText);
		// creates submit button
		submit = new JButton("Login");
		submit.setBounds(80, 155, 80, 25);
		// allows user to submit his Username and Password information when this
		// button is clicked
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// this will either be -1 if the user cant access an account or
				// it will return the account number
				int accountForAccess = verifyAccountAccess(
						atmInformationStorage);
				// checks to see if user cannot access account
				if (accountForAccess == -1)
				{
					userNameText.setText("Cannot access");
					passwordText.setText("");

				}
				// allows account access
				else
				{
					setVisible(false);
					// updates the frame with the BankAccountMenu for the
					// account being accessed
					frame.add(
							new BankAccountMenu(
									atmInformationStorage.getBankAccountList()
											.get(accountForAccess),
									atmInformationStorage));
				}
			}
		});
		add(submit);
		// creates new BankAccount
		createAccount = new JButton("Create Account");
		createAccount.setBounds(150, 205, 200, 25);
		createAccount.addActionListener(new ActionListener()
		{

			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// doesnt do anything if the user diddnt input anything
				if (userNameText.getText().equals("")
						|| passwordText.getText().equals(""))
				{
					userNameText.setText("Invalid");
					passwordText.setText("");
					return;
				}
				// ensures that a name is not being repeated
				for (int i = 0; i < atmInformationStorage.getBankAccountList()
						.size(); i++)
				{
					if (userNameText.equals(atmInformationStorage
							.getBankAccountList().get(i).getName()))
					{
						userNameText.setText("Invalid");
						return;
					}
				}
				// creates new BankAccount and adds it to the bankAccountList
				atmInformationStorage.bankAccountList.add(new BankAccount(
						atmInformationStorage.getBankAccountList().size(),
						userNameText.getText(), passwordText.getText(), 0.0));
				// informs user that BankAccount has been created
				userNameText.setText("New Account Created");
				passwordText.setText("");

			}
		});
		add(createAccount);

		// informs user about how to use this panel
		instructions = new JTextArea(
				"Whatever is in text field will be the Username \nand Password for a new bank account\nif you press \"createAccount\"");
		instructions.setBounds(130, 255, 250, 50);
		add(instructions);
		// exits program and outputs atmInformationStorage information
		quit = new JButton();
		quit.setText("Quit");
		quit.setBounds(150, 350, 200, 50);
		quit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				atmInformationStorage.outputBankData();
				System.exit(0);
			}
		});
		add(quit);
	}

	/**
	 * returns the account number the of the BankAccount the user is trying to
	 * access so long as the user name matches up with a password, and returns
	 * -1 if this is not the case
	 * 
	 * @param informationStorage used to verify user and password
	 * @return accountNumber or -1 if unable to access
	 */
	@Override
	public int verifyAccountAccess(ATMInformationStorage informationStorage)
	{
		// stored the status of whether or not the user inputed a valid username
		boolean validUsername;
		// stores the status of whether or not the user inputed a valid password
		boolean validPassword;
		// checks every element of the bankAccountList to see if the username
		// and password match up for any BankAccount
		for (int i = 0; i < informationStorage.getBankAccountList().size()
				&& !informationStorage.getBankAccountList().isEmpty(); i++)
		{
			// username and password are false by default
			validUsername = false;
			validPassword = false;
			// checks to see if username is equal
			if (informationStorage.getBankAccountList().get(i).getName()
					.equals(userNameText.getText()))
			{
				validUsername = true;
			}
			// checks to see if password is equal
			if (informationStorage.getBankAccountList().get(i).getPassword()
					.equals(passwordText.getText()))
			{
				validPassword = true;
			}
			// checks to see if both the username and password were valid for
			// this account and returns the accountNumber
			if (validUsername && validPassword)
			{
				return informationStorage.getBankAccountList().get(i)
						.getAccountNumber();
			}

		}
		// returns =1 if no matching username and password were found
		return -1;
	}

}
