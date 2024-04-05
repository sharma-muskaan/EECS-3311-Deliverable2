import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit_Testing {
	@Before
	public void setUp() throws Exception {
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
    	
    	PhysicalItem p1 = new CD("CD", "cd1", "auth1", "2nd", "pub1", "id1", "cd", 1, new Date(124, 6, 23), false, 10.67);
    	PhysicalItem p2 = new DVD("DVD", "dvd1", "auth2", "2nd", "pub1", "id2", "dvd", 1, new Date(124, 6, 23), false, 13.67);
    	PhysicalItem p3 = new Book("Book", "book1", "auth3", "2nd", "pub1", "id3", "book", 1, new Date(124, 6, 23), false, 16.67);
    	PhysicalItem p4 = new Book("Book", "book1", "auth3", "2nd", "pub1", "id3", "book", 1, new Date(124, 6, 23), false, -1);
    	PhysicalItem p5 = new Book("Book", "book1", "auth3", "2nd", "pub1", "id3", "book", 1, new Date(124, 6, 23), false, -1);
    	PhysicalItem p6 = new Book("Book", "book1", "auth3", "2nd", "pub1", "id3", "book", 1, new Date(124, 6, 23), false, 0);
    	
    	ArrayList<PhysicalItem> newPhysDB = new ArrayList<PhysicalItem>();
    	ArrayList<PhysicalItem> physItemList = new ArrayList<PhysicalItem>();
    	ArrayList<PhysicalItem> expectedPhysItemList = new ArrayList<PhysicalItem>();
    	
    	database.physItemsDB.clear();
    	database.physItemsDB.add(p1);
    	database.physItemsDB.add(p2);
    	database.physItemsDB.add(p3);
    	database.physItemsDB.add(p4);
    	database.physItemsDB.add(p5);
    	database.physItemsDB.add(p6);
    	
    	expectedPhysItemList.add(p1);
    	expectedPhysItemList.add(p2);
    	expectedPhysItemList.add(p3);
    	
    	for (PhysicalItem p : database.physItemsDB) {
			if (p.price > 0) {
				physItemList.add(p);
			}
		}
    	
    	
    	for (int i = 0; i < physItemList.size(); i++) {
    		assertEquals(expectedPhysItemList.get(i), physItemList.get(i));
    	}
        
    }
    
    
}


