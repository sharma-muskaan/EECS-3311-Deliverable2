package classes;

import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

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
	public void rentBookStudent() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void rentCDFaculty() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		assertTrue(jim.getPhysicalItemList().get(0).isEqualTo(newCD));
		
		database.physItemsDB.remove(newCD);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void rentMagazineNonFaculty() throws Exception {
		// String email, String password, String accType,
		//int itemsBorrowed, int overdueItems, boolean accountLocked
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		assertTrue(armen.getPhysicalItemList().get(0).isEqualTo(newZine));
		
		database.physItemsDB.remove(newZine);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void oneDayOverdue() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void tenDaysOverdue() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void fifteenDaysOverdue() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void rentingLimitTest() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		Book pkdatabaseook = new Book ("Book", "Our Friends From Frolix 8",
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
		Book notRentedatabaseook = new Book ("Book", "Testing the Laws of Physics",
				"John Criston", "First",  "Harper Collins", "71253", 
				"Mystery T6", 4, null, true, 16.95);
		
		
		arthur.addPhysicalItem(mauriceBook);
		arthur.addPhysicalItem(newCD);
		arthur.addPhysicalItem(newDVD);
		arthur.addPhysicalItem(newZine);
		arthur.addPhysicalItem(pkdatabaseook);
		arthur.addPhysicalItem(ngBook);
		arthur.addPhysicalItem(cmqBook);
		arthur.addPhysicalItem(khBook);
		arthur.addPhysicalItem(stBook);
		arthur.addPhysicalItem(maBook);
		arthur.addPhysicalItem(notRentedatabaseook);
		
		mauriceBook.rentCopy(max);
		newCD.rentCopy(max);
		newDVD.rentCopy(max);
		newZine.rentCopy(max);
		pkdatabaseook.rentCopy(max);
		ngBook.rentCopy(max);
		cmqBook.rentCopy(max);
		khBook.rentCopy(max);
		stBook.rentCopy(max);
		maBook.rentCopy(max);
		notRentedatabaseook.rentCopy(max); // this shouldn't be added to the list of rented books
		
		assertEquals(max.getPhysicalItemList().size(), 10);
		
		database.physItemsDB.remove(mauriceBook);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		database.physItemsDB.remove(newZine);
		database.physItemsDB.remove(pkdatabaseook);
		database.physItemsDB.remove(ngBook);
		database.physItemsDB.remove(cmqBook);
		database.physItemsDB.remove(khBook);
		database.physItemsDB.remove(stBook);
		database.physItemsDB.remove(maBook);
		database.physItemsDB.remove(notRentedatabaseook);
		
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void accountLockedTest() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void accountNotLockedTest() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void itemLostAt15Days() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	// checking edge cases for lost item
	public void itemNotLostat14Days() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		database.physItemsDB.remove(newBook);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void checkCopyNumChanged() throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 20, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
	
		assertTrue(newBook.getCopyNumber() < 20);
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
		
	}
	
	@Test
	public void returnCopy() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
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
		
		
		PhysicalItem copy = max.getPhysicalItemList().get(0);
		
		max.getPhysicalItemList().get(0).returnCopy(max);
		assertTrue(max.getPhysicalItemList().contains(copy) == false);
		
		database.physItemsDB.remove(newBook);
		database.physItemsDB.remove(newCD);
		database.physItemsDB.remove(newDVD);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void checkDueDate1Month() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		newBook.rentCopy(max);
		
		// Get current date
	    Calendar calendar = Calendar.getInstance();
	    // Add one month to the current date
	    calendar.add(Calendar.MONTH, 1);
	    
	    System.out.println(max.getPhysicalItemList().get(0).getDueDate());
	    System.out.println(calendar.getTime());
	    
	    assertTrue(max.getPhysicalItemList().get(0).getDueDate().toString().equals(calendar.getTime().toString()));
		// have to check as string since not same object exactly
		
	    database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void rentingWithLockedAccount() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, true);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "FIrst",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, true, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
		
		assertTrue(max.getPhysicalItemList().size() == 0);
		// if account locked then item will not be added to array
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void rentingDisabledItem() throws Exception {
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryManager arthur = new LibraryManager("alester@yorku.ca", "jdoighr^42");
		ConcreteAccountDecorator newStudent = new ConcreteAccountDecorator("max@yorku.ca", "748hfy7Z*", 
				"Student", 0, 0, false);
		
		Student max = new Student(newStudent);
		
		// create objects
		Book newBook = new Book ("Book", "The Amazing Maurice and his Educated Rodents",
				"Terry Pratchett", "First",  "Harper Collins", "29375", 
				"SciFi T6", 4, null, false, 16.95);
		
		arthur.addPhysicalItem(newBook);
		
		newBook.rentCopy(max);
		
		assertTrue(max.getPhysicalItemList().size() == 0);
		// if item disabled then item will not be added to array
		
		database.physItemsDB.remove(newBook);
		database.updatePhysItems(database.physItemsDB, "src/csv/physItem_database.csv");
	}
	
	@Test
	public void showCoursesAndTextBooks() throws Exception {
		// Create a Faculty object with mock data
		Account acc = new ConcreteAccountDecorator("randy@yorku.ca", "RPW", "Faculty", 0, 0, false);
        Faculty faculty = new Faculty(acc);
        
        DigitalItem item1 = new DigitalItem("Textbook", "Science", "Intro to Computer Science", "PFW", "2nd", "pub1");
        Date courseOneEndDate = new Date(124, 6, 23);
        
        DigitalItem item2 = new DigitalItem("Textbook", "Physics", "Physics Textbook", "PFW", "2nd", "pub1");
        DigitalItem item3 = new DigitalItem("Textbook", "Physics II", "Physics Textbook", "PFW", "2nd", "pub1");
        DigitalItem hist1 = new DigitalItem("Textbook", "Physics III", "Physics Textbook", "PFW", "2nd", "pub1");
        DigitalItem hist2 = new DigitalItem("Textbook", "Physics IV", "Physics Textbook", "PFW", "2nd", "pub1");
        
        Course cScience = new Course("Computer science", item1, courseOneEndDate);
        Course physics = new Course("Physics", item2, courseOneEndDate);

        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<DigitalItem> courseHist = new ArrayList<DigitalItem>();
        cScience.setCurrentCourseBook(item1);
        physics.setCurrentCourseBook(item3);
        
        courses.add(cScience);
        courses.add(physics);
        
        courseHist.add(hist1);
        courseHist.add(hist2);
        
        faculty.setCurrentCourses(courses);
        faculty.setCourseBookHistory(courseHist);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Call the method
        faculty.coursesAndTextbooks(faculty);
        
        // Restore normal System.out
        System.setOut(System.out);
        
        // Verify the output
        String expectedOutput = "Courses taught by the randy@yorku.ca:\n" +
                "Course Name: Computer science\n" +
                "Textbook: Intro to Computer Science\n" +
                "\n" +
                "Course Name: Physics\n" +
                "Textbook: Physics Textbook\n" +
                "\n" +
                "Textbooks previously used by the randy@yorku.ca:\n" +
                "Textbook Name: Physics Textbook\n" +
                "Textbook Name: Physics Textbook\n";
        String[] expectedLines = expectedOutput.split("\r?\n");
        String[] actualLines = outContent.toString().split("\r?\n");

        assertEquals(expectedLines.length, actualLines.length, "Number of lines does not match");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], actualLines[i], "Mismatch at line " + (i + 1));
        }
	}
	
	@Test
    public void testNotifyNewEdition_NewEditionAvailable() throws Exception {
		
		Account acc = new ConcreteAccountDecorator("mandy@yorku.ca", "RPW", "Student", 0, 0, false);
        // Mock data
		
        ArrayList<DigitalItem> digItemList = new ArrayList<>();
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 1", "author 1", "1st Edition", "PWS"));
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 2", "author 2", "2nd Edition", "PWS"));

        DigitalItem selectedItem = new DigitalItem("Textbook", "genre1", "Selected Book", "author 2", "1st Edition", "PWS");

        // Create NotificationService object

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call notifyNewEdition() method
        acc.notifyNewEdition(digItemList, selectedItem);

        // Restore normal System.out
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "New edition available!\n";
        
        String[] expectedLines = expectedOutput.split("\r?\n");
        String[] actualLines = outContent.toString().split("\r?\n");

        assertEquals(expectedLines.length, actualLines.length, "Number of lines does not match");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], actualLines[i], "Mismatch at line " + (i + 1));
        }
    }

    @Test
    public void testNotifyNewEdition_NoNewEditionAvailable() throws Exception {
    	Account acc = new ConcreteAccountDecorator("candy@yorku.ca", "RPW", "Student", 0, 0, false);
        // Mock data
        ArrayList<DigitalItem> digItemList = new ArrayList<>();
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 1", "author 1", "1st Edition", "PWS"));
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 2", "author 2", "2nd Edition", "PWS"));

        DigitalItem selectedItem = new DigitalItem("Textbook", "genre1", "Selected Book", "author 2", "3rd Edition", "PWS");

        // Create NotificationService object
        

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call notifyNewEdition() method
        acc.notifyNewEdition(digItemList, selectedItem);

        // Restore normal System.out
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = ""; // No notification expected
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void testNotifyManagement_TextbookNotAvailable() throws Exception {
    	Account acc = new ConcreteAccountDecorator("sandy@yorku.ca", "RPW", "Student", 0, 0, false);
        // Mock data
        ArrayList<DigitalItem> digItemList = new ArrayList<>();
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 1", "author 1", "1st Edition", "PWS"));
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 2", "author 2", "2nd Edition", "PWS"));

        String searchQuery = "Book 3"; // Textbook not available in the list

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call notifyManagement() method
        acc.notifyManagement(digItemList, searchQuery);

        // Restore normal System.out
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Management notfication: textbook not available!\n";
        
        String[] expectedLines = expectedOutput.split("\r?\n");
        String[] actualLines = outContent.toString().split("\r?\n");

        assertEquals(expectedLines.length, actualLines.length, "Number of lines does not match");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], actualLines[i], "Mismatch at line " + (i + 1));
        }
    }

    @Test
    public void testNotifyManagement_TextbookAvailable() throws Exception {
    	Account acc = new ConcreteAccountDecorator("landy@yorku.ca", "RPW", "Student", 0, 0, false);
        // Mock data
        ArrayList<DigitalItem> digItemList = new ArrayList<>();
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 1", "author 1", "1st Edition", "PWS"));
        digItemList.add(new DigitalItem("Textbook", "genre1", "Book 2", "author 2", "2nd Edition", "PWS"));

        String searchQuery = "Book 1"; // Textbook available in the list

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call notifyManagement() method
        acc.notifyManagement(digItemList, searchQuery);

        // Restore normal System.out
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = ""; // No notification expected
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void showPurchasableItems() throws Exception {
    	LibraryDatabase database = LibraryDatabase.getInstance();
    	
    	PhysicalItem p1 = new Magazine("Magazine", "People", "Rebecca Brown", "8th", "Dotdash Meredith", "876", "York Lanes", 20, null, false, 8.79);
    	PhysicalItem p2 = new Book("Book", "Titanic", "Filson Young", "5th", "Nimbus", "212", "York Scott Main Floor", 20, null, false, 10.16);
    	PhysicalItem p3 = new Magazine("Magazine", "National Geographic", "Various", "2023", "National Geographic", "321", "York Lanes", 20, null, false, 5.99);
    	PhysicalItem p4 = new Magazine("Magazine", "Wired", "Various", "June 2024", "Condao Nast", "678", "York Lanes", 20, null, false, 6.5);
    	
    
    	ArrayList<PhysicalItem> physItemList = new ArrayList<PhysicalItem>();
    	ArrayList<PhysicalItem> expectedPhysItemList = new ArrayList<PhysicalItem>();
    	
    	expectedPhysItemList.add(p1);
    	expectedPhysItemList.add(p2);
    	expectedPhysItemList.add(p3);
    	expectedPhysItemList.add(p4);
    	
    	database.loadPurchasableBooks(physItemList);
    	
    	for (int i = 0; i < physItemList.size(); i++) {
    		assertEquals(expectedPhysItemList.get(i).getName(), physItemList.get(i).getName());
    	}
        
    }
    
    @Test 
    public void testShowRecommendations_recommendationsShown() throws Exception {
    	LibraryDatabase database = LibraryDatabase.getInstance();
    	ArrayList<Item> expectedItemsList = new ArrayList<Item>();
    	ArrayList<Item> actualItemsList = new ArrayList<Item>();
    	
    	String searchQuery = "physics";
    	
    	Item p1 = new DigitalItem("Textbook", "Educational", "Physics", "Mark Smith", "2nd", "McGraw-Hill Education");
    	Item p2 = new DigitalItem("Textbook", "Educational", "Physics II", "Michael Johnson", "3rd", "HarperCollins");
    	
    	expectedItemsList.add(p1);
    	expectedItemsList.add(p2);
    	
    	actualItemsList = database.getRecommendations(searchQuery);
    	
    	for (int i = 0; i < actualItemsList.size(); i ++) {
    		assertEquals(expectedItemsList.get(i).getName(), actualItemsList.get(i).getName());
    	}
    }
    
    @Test
    public void testIsValidEmailTrue() throws Exception {
    	LibraryHomePage hp = new LibraryHomePage();
    	String email = "register@yorku.ca";
    	boolean actualValidation = false;
    	actualValidation = hp.isValidEmail(email);
    	assertTrue(actualValidation);
    }
    
    @Test
    public void testIsValidEmailFalse() throws Exception {
    	LibraryHomePage hp = new LibraryHomePage();
    	String email = "registeryorku.ca";
    	boolean actualValidation = false;
    	actualValidation = hp.isValidEmail(email);
    	assertFalse(actualValidation);
    }
    
    @Test
    public void testIsStrongPassword() throws Exception {
        LibraryHomePage testAccount = new LibraryHomePage();

        // Test with a strong password
        assertTrue(testAccount.isStrongPassword("Str0ng@123"));

        // less than 8 characters)
        assertFalse(testAccount.isStrongPassword("Weak!2"));

        // missing an uppercase letter
        assertFalse(testAccount.isStrongPassword("weak@1234"));

        // missing a lowercase letter
        assertFalse(testAccount.isStrongPassword("STRONG@123"));

        // missing a digit
        assertFalse(testAccount.isStrongPassword("Strong@password"));

        // missing a symbol
        assertFalse(testAccount.isStrongPassword("Strong1234"));
    }
    
    @Test
    public void testAdditionalValidationWithValidEmail() throws Exception {
        LibraryHomePage testAccount = new LibraryHomePage(); 

        // ends with "yorku.ca"
        assertTrue(testAccount.additionalValidation("user@yorku.ca"));
    }

    @Test
    public void testAdditionalValidationWithInvalidEmail() throws Exception {
        LibraryHomePage testAccount = new LibraryHomePage(); 

        // does not end with "yorku.ca"
        assertFalse(testAccount.additionalValidation("user@example.com"));
    }
	
	@Test
    public void warningMessageTest() throws Exception {
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
	public void managementTesting() throws Exception {
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
    public void makeAndListRequests() throws Exception {
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
