import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit_Test {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
		database.loadPhysItems(database.physItemsDB, null);
		database.loadDigItems(database.digItemsDB, null);
		database.loadCourses(database.coursesDB, null);
		database.loadAccounts();
		database.purgeFinishedCourses();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
    public void req3() throws Exception {
        Date d = new Date();
        LibraryDatabase database = LibraryDatabase.getInstance();
        Account a = database.getUsers().get(0);
        PhysicalItem b = new Book("Book","Harry Potter","JK Rowling","6th,Bloomsbury","123,York Stacy", null, null, 20,d,true,-1.0);
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
        assertEquals(a.getOverdueItems(), 1);
        a.setOverdueItems(0);
        database.updateAccounts();
    }
	
	@Test
	public void req8() throws Exception {
		//Start Up + Initialization
		String email = "mgr@yorku.ca";
		String pass = "mgr_access";
		
		LibraryManager manager = new LibraryManager(email, pass);
		LibraryDatabase database = LibraryDatabase.getInstance();
				
		//Digital Item Creation Check
		DigitalItem newDigItem = new DigitalItem("Textbook", "Education", "Introduction to Grass 101", "Lester Kibnob", "Third", "TextbookEducators Inc.");
		manager.addDigitalItem(newDigItem);
		assertTrue(database.digItemsDB.contains(newDigItem));
		
		//Book Creation Check
		Book newBook = new Book ("Book", "Fractured", "Karin Slaughter", "Third", "MysteryBook Inc.", "33567411", "Mystery C3", 20, null, true, 24.99);
		manager.addPhysicalItem(newBook);
		assertTrue(database.physItemsDB.contains(newBook));
		
		//Magazine Creation Check
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", "Magazine Central Inc.", "34562", "Magazines F5", 20, null, true, 0.0);
		manager.addPhysicalItem(newZine);
		assertTrue(database.physItemsDB.contains(newZine));
		
		//Magazine Creation Check
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", "Alt Music Inc.", "87594", "CD A1", 20, null, true, 15.99);
		manager.addPhysicalItem(newCD);
		assertTrue(database.physItemsDB.contains(newCD));
		
		//Magazine Creation Check
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", "Disney Inc.", "39583", "Children's Movies B4", 20, null, true, 0.0);
		manager.addPhysicalItem(newDVD);
		assertTrue(database.physItemsDB.contains(newDVD));
		
		//Disable Item Testing
		manager.disablePhysItem(newBook);
		//check that newPhysItem has been updated
		assertFalse(newBook.isRentalEnabled());
		//check that ArrayList has been updated
		assertTrue(database.physItemsDB.contains(newBook));
		
		//Enable Item Testing
		manager.enablePhysItem(newBook);
		//check that newBook has been updated
		assertTrue(newBook.isRentalEnabled());
		//check that ArrayList has been updated
		assertTrue(database.physItemsDB.contains(newBook));
		
		database.digItemsDB.remove(newDigItem);
		database.physItemsDB.remove(newBook);
		database.physItemsDB.remove(newZine);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		
		database.updateDigItems(database.digItemsDB, "src/csv/digItem_database.csv");
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
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
