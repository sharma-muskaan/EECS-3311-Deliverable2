import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit_Testing {
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
        assertEquals(expectedOutput, outContent.toString());
        
       
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
        assertEquals(expectedOutput, outContent.toString());
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
        assertEquals(expectedOutput, outContent.toString());
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
    
    
}


