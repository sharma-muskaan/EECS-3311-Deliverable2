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
}


	
//	@Test
//    public void req3() throws Exception {
//        Date d = new Date();
//        LibraryDatabase database = LibraryDatabase.getInstance();
//        Account a = database.getUsers().get(0);
//        PhysicalItem b = new Book("Book","Harry Potter","JK Rowling","6th,Bloomsbury","123,York Stacy", null, null, 20,d,true,-1.0);
//        b.setCopyNumber(-1);
//        b.setDueDate(new Date(System.currentTimeMillis() - (24 * 60 * 60 * 1000)));
//        String result = b.warningString(a);
//        assertEquals("The book: " + b.getName() +" OVERDUE PLEASE RETURN IT", result);
//        b.setDueDate(new Date(System.currentTimeMillis() + (12 * 60 * 60 * 1000)));
//        String result2 = b.warningString(a);
//        assertEquals("The book: " + b.getName() +" is due in 12 hours", result2);
//        b.setDueDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000)));
//        String result3 = b.warningString(a);
//        assertEquals("1 Day till " + b.getName() +" is due for return", result3);
//        b.setDueDate(new Date(System.currentTimeMillis() + (3*24 * 60 * 60 * 1000))); 
//        String result4 = b.warningString(a);
//        assertEquals("3 Days till " + b.getName() +" is due for return", result4);
//        assertEquals(a.getOverdueItems(), 1);
//        a.setOverdueItems(0);
//        database.updateAccounts();
//    }

