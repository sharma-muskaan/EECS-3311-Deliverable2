public class NonFaculty extends ConcreteAccount {
	public NonFaculty(String email, String password, String accType, int itemsBorrowed, int overdueItems,
			boolean accountLocked) {
		super(email, password, accType, itemsBorrowed, overdueItems, accountLocked);
	}
}