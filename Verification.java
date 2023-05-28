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
 *         N/A
 * 
 *         Version/date: v.2 5/25/2023
 * 
 *         Responsibilities of Interface: this inferface is used by Classes that
 *         perform verification on BankAccount information such as username and
 *         password
 */
public interface Verification
{
	/**
	 * used by accounts that need to verify access to an account
	 * 
	 * @param atmInformationStorage stores BankAccount information and allows
	 *                              for reading and modification
	 * @return account number of account to be accessed
	 */
	int verifyAccountAccess(ATMInformationStorage atmInformationStorage);
}
