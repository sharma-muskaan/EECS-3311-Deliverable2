import static org.junit.Assert.*;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit_Test {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void req11() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
		database.loadPhysItems(database.physItemsDB, null);
		database.loadDigItems(database.digItemsDB, null);
		database.loadCourses(database.coursesDB, null);
		database.loadAccounts();
		database.purgeFinishedCourses();
	}
	
	@Test
	public void req8() throws Exception {
		String email = "mgr@yorku.ca";
		String pass = "mgr_access";
		
		LibraryManager manager = new LibraryManager(email, pass);
		LibraryDatabase database = LibraryDatabase.getInstance();
		
		database.loadPhysItems(database.physItemsDB, null);
		database.loadDigItems(database.digItemsDB, null);
		database.loadCourses(database.coursesDB, null);
		database.loadAccounts();
		database.purgeFinishedCourses();
		
		String itemType = "Book";
		String genre = "Young Adult";
		String name = "The Hunger Games";
		String author = "Suzanne Collins";
		String edition = "4th";
		String publisherName = "Scholastic";
		String itemID = "34256140";
		String libLocation = "Scott Library";
		int copyNumber = 20;
		Date dueDate = null;
		boolean rentalEnabled = true;
		double price = -1.0;
		
		DigitalItem newDigItem = new DigitalItem(itemType, genre, name, author, edition, publisherName);
		Book newPhysItem = new Book(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
		
		manager.addDigitalItem(newDigItem);
		assert (database.digItemsDB.contains(newDigItem));
		database.loadPhysItems(database.physItemsDB, null);
		assert (database.digItemsDB.contains(newDigItem));
		
		manager.addPhysicalItem(newPhysItem);
		assert (database.physItemsDB.contains(newPhysItem));
		database.loadDigItems(database.digItemsDB, null);
		assert (database.digItemsDB.contains(newDigItem));
		
		manager.disablePhysItem(newPhysItem);
		//check that newPhysItem has been updated
		assert (newPhysItem.isRentalEnabled() == false);
		//check that ArrayList has been updated
		assert (database.physItemsDB.contains(newPhysItem));
		//check that CSV has been updated
		database.loadPhysItems(database.physItemsDB, null);
		assert (database.physItemsDB.contains(newPhysItem));
		
		manager.enablePhysItem(newPhysItem);
		//check that newPhysItem has been updated
		assert (newPhysItem.isRentalEnabled() == true);
		//check that ArrayList has been updated
		assert (database.physItemsDB.contains(newPhysItem));
		//check that CSV has been updated
		database.loadPhysItems(database.physItemsDB, null);
		assert (database.physItemsDB.contains(newPhysItem));
	}
}
