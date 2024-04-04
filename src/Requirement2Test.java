import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Requirement2Test {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void rentBookStudent() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		
		ConcreteAccountDecorator Max = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		
	}
	
	/**
	 * List of Test cases to be implemented:
	 * 
	 * 1. Attempt to rent physical item 
	 * 	a) rent book
	 * 	b) CD
	 * 	c) DVD
	 * 	d) Magazine
	 * 2. Open online book
	 * 3. Subscribe to newsletter
	 * 	a) NY Times
	 * 	b) other one
	 * 4. Check overdue
	 * 	a) 1 day price
	 * 	b) 10 day price
	 * 	c) 15 day
	 * 5. Check copies
	 * 	a) check that there are less copies once one's been rented
	 *	b) check no more copies? 
	 * 6. Borrow
	 * 	a) check can borrow
	 * 	b) check borrow limit
	 * 7. check borrow suspension
	 * 	a) check suspended
	 * 	b) check unsuspended
	 * 8. Check lost item
	 * 	a) overdue but not lost
	 * 	b) lost at 15
	 * 	c) lost past 15
	 */

}
