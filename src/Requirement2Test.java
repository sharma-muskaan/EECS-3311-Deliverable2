import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class Requirement2Test {
	
	@Test
	void rentBookStudent() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
		
		Calendar calendar = Calendar.getInstance();
	    // Add one month to the current date
	    calendar.add(Calendar.MONTH, 1);
		
		System.out.println(max.getPhysicalItemList());
		 
		// this item is technically a clone of the original so, need to check based on attributes
		// copy number and calendar not checked bc variable and also hard coded to a value when copied
		assertTrue(max.getPhysicalItemList().get(0).getItemType().equals(newBook.getItemType()));
		assertTrue(max.getPhysicalItemList().get(0).getName().equals(newBook.getName()));
		assertTrue(max.getPhysicalItemList().get(0).getAuthor().equals(newBook.getAuthor()));
		assertTrue(max.getPhysicalItemList().get(0).getEdition().equals(newBook.getEdition()));
		assertTrue(max.getPhysicalItemList().get(0).getPublisherName().equals(newBook.getPublisherName()));
		assertTrue(max.getPhysicalItemList().get(0).getItemID().equals(newBook.getItemID()));
		assertTrue(max.getPhysicalItemList().get(0).getLibLocation().equals(newBook.getLibLocation()));
		assertTrue(max.getPhysicalItemList().get(0).isRentalEnabled() == newBook.rentalEnabled);
		assertTrue(max.getPhysicalItemList().get(0).getPrice() == newBook.getPrice());
		db.physItemsDB.clear();
		
	}
	
	@Test
	void rentCDFaculty() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newFaculty = new ConcreteAccountDecorator("jim@yorku.ca", "748hfy7Z*", 
				"Faculty", 0, 0, false);
		
		Faculty jim = new Faculty(newFaculty);
		
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		
		arthur.addPhysicalItem(newCD);
		
		newCD.rentCopy(jim);
		
		Calendar calendar = Calendar.getInstance();
	    // Add one month to the current date
	    calendar.add(Calendar.MONTH, 1);
		
		System.out.println(jim.getPhysicalItemList());
		 
		// this item is technically a clone of the original so, need to check based on attributes
		// copy number and calendar not checked bc variable and also hard coded to a value when copied
		assertTrue(jim.getPhysicalItemList().get(0).getItemType().equals(newCD.getItemType()));
		assertTrue(jim.getPhysicalItemList().get(0).getName().equals(newCD.getName()));
		assertTrue(jim.getPhysicalItemList().get(0).getAuthor().equals(newCD.getAuthor()));
		assertTrue(jim.getPhysicalItemList().get(0).getEdition().equals(newCD.getEdition()));
		assertTrue(jim.getPhysicalItemList().get(0).getPublisherName().equals(newCD.getPublisherName()));
		assertTrue(jim.getPhysicalItemList().get(0).getItemID().equals(newCD.getItemID()));
		assertTrue(jim.getPhysicalItemList().get(0).getLibLocation().equals(newCD.getLibLocation()));
		assertTrue(jim.getPhysicalItemList().get(0).isRentalEnabled() == newCD.rentalEnabled);
		assertTrue(jim.getPhysicalItemList().get(0).getPrice() == newCD.getPrice());
		db.physItemsDB.clear();
	}
	
	@Test
	void rentDVDVisitor() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newVisitor = new ConcreteAccountDecorator("emma@yorku.ca", "o875hfa76&*", 
				"Visitor", 0, 0, false);
		
		Visitor emma = new Visitor(newVisitor);
		
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		arthur.addPhysicalItem(newDVD);
		
		newDVD.rentCopy(emma);
		
		Calendar calendar = Calendar.getInstance();
	    // Add one month to the current date
	    calendar.add(Calendar.MONTH, 1);
		
		System.out.println(emma.getPhysicalItemList());
		 
		// this item is technically a clone of the original so, need to check based on attributes
		// copy number and calendar not checked bc variable and also hard coded to a value when copied
		assertTrue(emma.getPhysicalItemList().get(0).getItemType().equals(newDVD.getItemType()));
		assertTrue(emma.getPhysicalItemList().get(0).getName().equals(newDVD.getName()));
		assertTrue(emma.getPhysicalItemList().get(0).getAuthor().equals(newDVD.getAuthor()));
		assertTrue(emma.getPhysicalItemList().get(0).getEdition().equals(newDVD.getEdition()));
		assertTrue(emma.getPhysicalItemList().get(0).getPublisherName().equals(newDVD.getPublisherName()));
		assertTrue(emma.getPhysicalItemList().get(0).getItemID().equals(newDVD.getItemID()));
		assertTrue(emma.getPhysicalItemList().get(0).getLibLocation().equals(newDVD.getLibLocation()));
		assertTrue(emma.getPhysicalItemList().get(0).isRentalEnabled() == newDVD.rentalEnabled);
		assertTrue(emma.getPhysicalItemList().get(0).getPrice() == newDVD.getPrice());
		db.physItemsDB.clear();
	}
	
	@Test
	void rentMagazineNonFaculty() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newNonFaculty = new ConcreteAccountDecorator("Armen@yorku.ca", "o875hfa76&*", 
				"Visitor", 0, 0, false);
		
		Visitor armen = new Visitor(newNonFaculty);
		
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", 
				"Magazine Central Inc.", "34562", "Magazines F5", 1, null, true, 20.99);
		
		arthur.addPhysicalItem(newZine);
		
		newZine.rentCopy(armen);
		
		Calendar calendar = Calendar.getInstance();
	    // Add one month to the current date
	    calendar.add(Calendar.MONTH, 1);
		
		System.out.println(armen.getPhysicalItemList());
		 
		// this item is technically a clone of the original so, need to check based on attributes
		// copy number and calendar not checked bc variable and also hard coded to a value when copied
		assertTrue(armen.getPhysicalItemList().get(0).getItemType().equals(newZine.getItemType()) 
				&& armen.getPhysicalItemList().get(0).getName().equals(newZine.getName())
				&& armen.getPhysicalItemList().get(0).getAuthor().equals(newZine.getAuthor())
				&& armen.getPhysicalItemList().get(0).getEdition().equals(newZine.getEdition())
				&& armen.getPhysicalItemList().get(0).getPublisherName().equals(newZine.getPublisherName())
				&& armen.getPhysicalItemList().get(0).getItemID().equals(newZine.getItemID())
				&& armen.getPhysicalItemList().get(0).getLibLocation().equals(newZine.getLibLocation())
				&& armen.getPhysicalItemList().get(0).isRentalEnabled() == newZine.rentalEnabled
				&& armen.getPhysicalItemList().get(0).getPrice() == newZine.getPrice());
		db.physItemsDB.clear();
	}
	
	@Test
	void oneDayOverdue() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
		
		Calendar c = Calendar.getInstance();
		c.setTime(max.getPhysicalItemList().get(0).getDueDate());
		c.add(Calendar.MONTH, -1); // change to last month bc can't change current day real time
		c.add(Calendar.DAY_OF_MONTH, -1); // change num of days past due
		
		max.getPhysicalItemList().get(0).setDueDate(c.getTime());
		
		assertTrue(max.getPhysicalItemList().get(0).calculateFine() == 0.5);
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	void tenDaysOverdue() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
		
		Calendar c = Calendar.getInstance();
		c.setTime(max.getPhysicalItemList().get(0).getDueDate());
		c.add(Calendar.MONTH, -1); // change to last month bc can't change current day real time
		c.add(Calendar.DAY_OF_MONTH, -10); // change num of days past due
		
		max.getPhysicalItemList().get(0).setDueDate(c.getTime());
		
		assertTrue(max.getPhysicalItemList().get(0).calculateFine() == 5.0);
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	void fifteenDaysOverdue() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
		
		Calendar c = Calendar.getInstance();
		c.setTime(max.getPhysicalItemList().get(0).getDueDate());
		c.add(Calendar.MONTH, -1); // change to last month bc can't change current day real time
		c.add(Calendar.DAY_OF_MONTH, -15); // change num of days past due
		
		max.getPhysicalItemList().get(0).setDueDate(c.getTime());
		
		assertTrue(max.getPhysicalItemList().get(0).calculateFine() == 7.5);
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	void rentingLimitTest() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Faculty", 0, 0, false);
		
		Faculty max = new Faculty(newStudent);
		
		Book mauriceBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		Magazine newZine = new Magazine ("Magazine", "Computer Now", "Stephanie Coolier", "8th", 
				"Magazine Central Inc.", "34562", "Magazines F5", 1, null, true, 20.99);
		Book pkdBook = new Book ("Book", "Our Friends From Frolix 8",
				"Philip K Dick", "Second",  "Orion Book", "94854", 
				"SciFi T6", 4, null, true, 16.95);
		Book ngBook = new Book ("Book", "The Graveyard Book",
				"Neil Gaiman", "third",  "Morrow", "03645", 
				"Fantasy U8", 4, null, true, 16.95);
		Book cmqBook = new Book ("Book", "Red White and Royal Blue",
				"Casey McQuiston", "first",  "Harper Collins", "2316", 
				"Romance C4", 4, null, true, 16.95);
		Book khBook = new Book ("Book", "Hounded","Kevin Hearne", "First",  
				"Del Ray", "1234", "Fantasy T6", 4, null, true, 16.95);
		Book stBook = new Book ("Book", "Class Act",
				"Stuart Woods", "First",  "Putnam", "92382", 
				"Mystery S6", 4, null, true, 16.95);
		Book maBook = new Book ("Book", "The Handmaid's Tale",
				"Margaret Atwood", "Fourth",  "Harper Collins", "9262447", 
				"SciFi T6", 4, null, true, 16.95);
		Book notRentedBook = new Book ("Book", "Testing the Laws of Physics",
				"John Criston", "First",  "Harper Collins", "71253", 
				"Mystery T6", 4, null, true, 16.95);
		
		
		arthur.addPhysicalItem(mauriceBook);
		arthur.addPhysicalItem(newCD);
		arthur.addPhysicalItem(newDVD);
		arthur.addPhysicalItem(newZine);
		arthur.addPhysicalItem(pkdBook);
		arthur.addPhysicalItem(ngBook);
		arthur.addPhysicalItem(cmqBook);
		arthur.addPhysicalItem(khBook);
		arthur.addPhysicalItem(stBook);
		arthur.addPhysicalItem(maBook);
		arthur.addPhysicalItem(notRentedBook);
		
		mauriceBook.rentCopy(max);
		newCD.rentCopy(max);
		newDVD.rentCopy(max);
		newZine.rentCopy(max);
		pkdBook.rentCopy(max);
		ngBook.rentCopy(max);
		cmqBook.rentCopy(max);
		khBook.rentCopy(max);
		stBook.rentCopy(max);
		maBook.rentCopy(max);
		notRentedBook.rentCopy(max); // this shouldn't be added to the list of rented books
		
		assertTrue(max.getPhysicalItemList().size() == 10);
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	void accountLockedTest() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		arthur.addPhysicalItem(newBook);
		arthur.addPhysicalItem(newCD);
		arthur.addPhysicalItem(newDVD);
		
		newBook.rentCopy(max);
		newCD.rentCopy(max);
		newDVD.rentCopy(max);
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(max.getPhysicalItemList().get(0).getDueDate());
		c.add(Calendar.MONTH, -1); // change to last month bc can't change current day real time
		c.add(Calendar.DAY_OF_MONTH, -3); // change num of days past due
		
		for (int i = 0; i < max.getPhysicalItemList().size(); i++) {
			max.getPhysicalItemList().get(i).setDueDate(c.getTime());
			System.out.println(max.getPhysicalItemList().get(i).getDueDate());
		}
		
		max.getPhysicalItemList().get(0).warningString(max);
		
		assertTrue(max.isAccountLocked());
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	void accountNotLockedTest() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		arthur.addPhysicalItem(newBook);
		arthur.addPhysicalItem(newCD);
		arthur.addPhysicalItem(newDVD);
		
		newBook.rentCopy(max);
		newCD.rentCopy(max);
		newDVD.rentCopy(max);
		
		max.getPhysicalItemList().get(0).warningString(max);
		
		assertTrue(max.isAccountLocked() == false); // check by default not locked when has three
													// books out
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	void itemLostAt15Days() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		arthur.addPhysicalItem(newBook);
		arthur.addPhysicalItem(newCD);
		arthur.addPhysicalItem(newDVD);
		
		newBook.rentCopy(max);
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(max.getPhysicalItemList().get(0).getDueDate());
		c.add(Calendar.MONTH, -1); // change to last month bc can't change current day real time
		c.add(Calendar.DAY_OF_MONTH, -15); // change num of days past due
		
		max.getPhysicalItemList().get(0).setDueDate(c.getTime());
		
		max.getPhysicalItemList().get(0).warningString(max);
		
		assertTrue(max.getPhysicalItemList().get(0).getCopyNumber() == -3);
		// signifies lost item
		
		db.physItemsDB.clear();
		
	}
	
	@Test
	// checking edge cases for lost item
	void itemNotLostat14Days() throws Exception{
		LibraryDatabase db = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		CD newCD = new CD ("CD", "Lucky Break", "Jack Campbell", "First", 
				"Alt Music Inc.", "87594", "CD A1", 1, null, true, 15.99);
		DVD newDVD = new DVD ("DVD", "Cars", "Pixar", "2", 
				"Disney Inc.", "39583", "Children's Movies B4", 1, null, true, 30.99);
		
		arthur.addPhysicalItem(newBook);
		arthur.addPhysicalItem(newCD);
		arthur.addPhysicalItem(newDVD);
		
		newBook.rentCopy(max);
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(max.getPhysicalItemList().get(0).getDueDate());
		c.add(Calendar.MONTH, -1); // change to last month bc can't change current day real time
		c.add(Calendar.DAY_OF_MONTH, -14); // change num of days past due
		
		max.getPhysicalItemList().get(0).setDueDate(c.getTime());
		
		max.getPhysicalItemList().get(0).warningString(max);
		
		assertTrue(max.getPhysicalItemList().get(0).getCopyNumber() != -3);
		// signifies not lost
		
		db.physItemsDB.clear();
		
	}
	
	
	
	/**
	 * List of Test cases to be implemented:
	 * 
	 * 2. Open online book ** no implementation of this either
	 * 3. Subscribe to newsletter ** not sure I can do this
	 * 5. Check copies
	 * 	a) check that there are less copies once one's been rented
	 *	b) check no more copies? 
	 * 8. Check lost item
	 * 	a) overdue but not lost
	 * 	b) lost at 15
	 * 	c) lost past 15
	 * 9. check due date is 1 month
	 */

}
