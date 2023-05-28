package bank;

import javax.swing.JFrame;

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
 *         Responsibilities of class: contains main method, initializes
 *         application by creating JFrame, ATMInformationstorage
 *         and inputing bank data from previous program states. Also creates
 *         Administrator for viewing information from console
 *         creates initial login menu
 */
public class Initialize
{
	// has a JFrame
	private static JFrame frame;
	// has a atmInformationStorage
	private static ATMInformationStorage atmInformationStorage;

	public static void main(String[] args)
	{
		// initializes atmInformationStorage
		atmInformationStorage = new ATMInformationStorage();
		// restores to state prior to termination
		atmInformationStorage.inputBankData();
		// creates JFrame to hold menu panels
		frame = new JFrame();
		frame.setSize(500, 500);
		// creates new LoginMenu and adds it the the frame
		frame.add(new LoginMenu(frame, atmInformationStorage));
		frame.setVisible(true);
		new Administrator(atmInformationStorage);

	}
}
