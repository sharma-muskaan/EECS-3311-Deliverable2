import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class Requirement7Test {

	
	@Test
	void createLibraryManager() throws Exception {
		// create library manager
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*");
		assertTrue(leo.email.equals("leo@yorku.ca"));
		assertTrue(leo.password.equals("lEo442*"));
	}
	
	@Test
	void addPhysicalItemBook() throws Exception {
		// create library manager
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*");
		
		// create physical item
		
		Book newBook = new Book ("Book", "Fractured", "Karin Slaughter", "Third", 
				"MysteryBook Inc.", "33567411", "Mystery C3", 1, null, true, 24.99);
		
		leo.addPhysicalItem(newBook); // added to db
		LibraryDatabase db = LibraryDatabase.getInstance();
		assertTrue(db.physItemsDB.contains(newBook));
		
		// clear db for next test
		db.physItemsDB.clear();
	}
	
	@Test
	void addPhysicalItemCD() throws Exception {
		// create library manager
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*");
		
		// create physical item
		
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		
		leo.addPhysicalItem(newCD); // added to db
		LibraryDatabase db = LibraryDatabase.getInstance();
		assertTrue(db.physItemsDB.contains(newCD));
		
		// clear db for next test
		db.physItemsDB.clear();
	}
	
	@Test
	void addPhysicalItemDVD() throws Exception {
		// create library manager
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*");
		
		// create physical item
		
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		leo.addPhysicalItem(newDVD); // added to db
		LibraryDatabase db = LibraryDatabase.getInstance();
		assertTrue(db.physItemsDB.contains(newDVD));
		
		// clear db for next test
		db.physItemsDB.clear();
	}
	
	@Test
	void addPhysicalItemMagazine() throws Exception {
		// create library manager
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*");
		
		// create physical item
		
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", 
				"Magazine Central Inc.", "34562", "Magazines F5", 1, null, true, 20.99);
		
		leo.addPhysicalItem(newZine); // added to db
		LibraryDatabase db = LibraryDatabase.getInstance();
		assertTrue(db.physItemsDB.contains(newZine));
		
		// clear db for next test
		db.physItemsDB.clear();
	}
	
	// write more cases to check for each type of physical item
	
	@Test
	void addDigitalItem() throws Exception {
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*");
		
		// create physical item
		//String itemType, String genre, String name, String author, 
		//String edition, String publisherName
		
		DigitalItem newItem = new DigitalItem("Textbook", "Education", "Introduction to Grass 101", 
				"Lester Kibnob", "Third", "TextbookEducators Inc.");
		leo.addDigitalItem(newItem);
		LibraryDatabase db = LibraryDatabase.getInstance();
		assertTrue(db.digItemsDB.contains(newItem));
		
		//clear db for next tests
		db.digItemsDB.clear();
	}
	
	@Test
	// Test that you can add multiple copies
	void addDuplicate() throws Exception {
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		
		Book newBook = new Book ("Book", "Fractured", "Karin Slaughter", "Third", 
				"MysteryBook Inc.", "33567411", "Mystery C3", 1, null, true, 24.99);
		DigitalItem newItem = new DigitalItem("Textbook", "Education", "Introduction to Grass 101", 
				"Lester Kibnob", "Third", "TextbookEducators Inc.");
		// add to db
		leo.addPhysicalItem(newBook);
		leo.addDigitalItem(newItem);
		
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		assertTrue(db.physItemsDB.contains(newBook));
		assertTrue(db.digItemsDB.contains(newItem));
		
		// try and add them again
		
		leo.addPhysicalItem(newBook);
		leo.addDigitalItem(newItem);
		
		assertTrue(db.physItemsDB.size() == 2);
		assertTrue(db.digItemsDB.size() == 2);	
		
		// clear db for next test
		db.physItemsDB.clear();
		db.digItemsDB.clear();
	}
	
	@Test
	void getItemID() throws Exception{
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		Book newBook = new Book ("Book", "Fractured", "Karin Slaughter", "Third", 
				"MysteryBook Inc.", "33567411", "Mystery C3", 1, null, true, 24.99);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", 
				"Magazine Central Inc.", "34562", "Magazines F5", 1, null, true, 20.99);
		
		leo.addPhysicalItem(newBook);
		leo.addPhysicalItem(newCD);
		leo.addPhysicalItem(newDVD);
		leo.addPhysicalItem(newZine);
		
		assertTrue(db.physItemsDB.get(0).getItemID().equals(newBook.itemID));
		assertTrue(db.physItemsDB.get(1).getItemID().equals(newCD.itemID));
		assertTrue(db.physItemsDB.get(2).getItemID().equals(newDVD.itemID));
		assertTrue(db.physItemsDB.get(3).getItemID().equals(newZine.itemID));
		
		// clear db
		db.physItemsDB.clear();
		
	}
	
	@Test
	void checkLibraryLocation() throws Exception{
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		Book newBook = new Book ("Book", "Fractured", "Karin Slaughter", "Third", 
				"MysteryBook Inc.", "33567411", "Mystery C3", 1, null, true, 24.99);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", 
				"Magazine Central Inc.", "34562", "Magazines F5", 1, null, true, 20.99);
		
		leo.addPhysicalItem(newBook);
		leo.addPhysicalItem(newCD);
		leo.addPhysicalItem(newDVD);
		leo.addPhysicalItem(newZine);
		
		assertTrue(db.physItemsDB.get(0).getLibLocation().equals(newBook.libLocation));
		assertTrue(db.physItemsDB.get(1).getLibLocation().equals(newCD.libLocation));
		assertTrue(db.physItemsDB.get(2).getLibLocation().equals(newDVD.libLocation));
		assertTrue(db.physItemsDB.get(3).getLibLocation().equals(newZine.libLocation));
		
		// clear db
		db.physItemsDB.clear();
	}
	
	@Test
	void enablePhysicalItemAlreadyEnabled() throws Exception{
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		Book newBook = new Book ("Book", "Fractured", "Karin Slaughter", "Third", 
				"MysteryBook Inc.", "33567411", "Mystery C3", 1, null, true, 24.99);
		
		leo.addPhysicalItem(newBook);
		leo.enablePhysItem(newBook);
		
		assertTrue(newBook.rentalEnabled == true);
		
		// clear db
		db.physItemsDB.clear();
	}
	
	@Test
	void enablePhysicalItem() throws Exception{
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, false, 15.99);
		
		leo.addPhysicalItem(newCD);
		leo.enablePhysItem(newCD);
		
		assertTrue(newCD.rentalEnabled == true);
		
		// clear db
		db.physItemsDB.clear();
	}
	
	@Test
	void disablePhysicalItemAlreadyDisabled() throws Exception{
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		leo.addPhysicalItem(newDVD);
		leo.disablePhysItem(newDVD);
		
		assertTrue(newDVD.rentalEnabled == false);
		
		// clear db
		db.physItemsDB.clear();
	}
	
	@Test
	void disablePhysicalItem() throws Exception{
		LibraryManager leo = new LibraryManager("leo@yorku.ca", "lEo442*"); // create manager
		LibraryDatabase db = LibraryDatabase.getInstance();
		
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", 
				"Magazine Central Inc.", "34562", "Magazines F5", 1, null, true, 20.99);
		
		leo.addPhysicalItem(newZine);
		leo.disablePhysItem(newZine);
		
		assertTrue(newZine.rentalEnabled == false);
		
		// clear db
		db.physItemsDB.clear();
	}

}
