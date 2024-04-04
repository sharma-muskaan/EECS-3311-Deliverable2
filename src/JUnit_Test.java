import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
	
	@Test
    public void req3() throws Exception {
		
		LibraryDatabase database = LibraryDatabase.getInstance();
		database.loadPhysItems(database.physItemsDB, null);
		database.loadDigItems(database.digItemsDB, null);
		database.loadCourses(database.coursesDB, null);
		database.loadAccounts();
		database.purgeFinishedCourses();
		
        Date d = new Date();
        Account a = new ConcreteAccountDecorator("email", "email", "Student", 0, 0, false);
        PhysicalItem b = new Book("Book","Harry Potter","JK Rowling","6th,Bloomsbury","123,York Stacy",null, null, 20,d,true,-1.0);
        b.setCopyNumber(-1);
        b.setDueDate(new Date(System.currentTimeMillis() - (24 * 60 * 60 * 1000)));
        String result = b.warningString(a);
        assertEquals("The book: " + b.getName() +" OVERDUE PLEASE RETURN IT", result);
        b.setDueDate(new Date(System.currentTimeMillis() + (12 * 60 * 60 * 1000)));
        String result2 = b.warningString(a);
        assertEquals("The book: " + b.getName() +" is due in 12 hours", result2);
        b.setDueDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000)));
        String result3 = b.warningString(a);
        assertEquals("1 Day till " + b.getName() +" is due for return", result3);
        b.setDueDate(new Date(System.currentTimeMillis() + (3*24 * 60 * 60 * 1000))); 
        String result4 = b.warningString(a);
        assertEquals("3 Days till " + b.getName() +" is due for return", result4);
    }
	
	@Test
    public void req9() throws Exception {
        Account a = new ConcreteAccountDecorator("email", "email", "Student", 0, 0, false);
        DigitalItem b = new DigitalItem("Textbook", "Educational", "Science TextBook", "K", "3rd", "York");
        DigitalItem b2 = new DigitalItem("Textbook", "Self-Improvement", "Yoga TextBook", "K", "2nd", "York");
        DigitalItem b3 = new DigitalItem("Book", "Horror", "The Tide", "K", "1st", "York");

        assertEquals("Textbook Yoga TextBook 2nd has been requested",a.request(b2));
        assertEquals("Book The Tide has been requested",a.request(b3));
        assertEquals("Textbook Science TextBook 3rd has been requested",a.request(b));

        
        a.sort();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        a.printReqs();
        System.setOut(System.out);

        String printedOutput = outContent.toString();

        assertTrue(printedOutput.contains("Requested Items Queue (Educational Textbooks have higher priority):"));
        assertTrue(printedOutput.contains("1. Textbook Science TextBook"));
        assertTrue(printedOutput.contains("2. Book The Tide"));
        assertTrue(printedOutput.contains("3. Textbook Yoga TextBook"));
        
    }
}
