package bank;

import java.awt.Panel;

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
 *         Responsibilities of class: allows for consistent ATMMenu sizing
 *         through methods.
 */
public abstract class ATMMenu extends Panel
{
	// has a width
	final int PANEL_WIDTH = 500;
	// has a height
	final int PANEL_HEIGHT = 500;

	/**
	 * ensures consistent sizing for all panels utilized by the GUI
	 */
	public void setStandardPanelSize()
	{
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
	}
}
