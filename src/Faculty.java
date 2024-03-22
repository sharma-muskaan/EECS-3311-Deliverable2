import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Faculty extends AccountDecorator{
	
	protected ArrayList<Course> currentCourses;
	// courseBookHistory = faculty_digItem_data.csv
	protected ArrayList<DigitalItem> courseBookHistory;
	protected ArrayList<DigitalItem> textbooks;
	
	private static LibraryDatabase database;
	
	public Faculty(Account account) throws Exception {
	    super(account);
	    currentCourses = new ArrayList<Course>();
	    courseBookHistory = new ArrayList<>();
	    textbooks = new ArrayList<>(); // Initialize textbooks ArrayList
	    database = LibraryDatabase.getInstance();
	}
	
	public Faculty(Account account, ArrayList<Course> currentCourses, ArrayList<DigitalItem> courseBookHistory) throws Exception {
		super(account);
		this.currentCourses = currentCourses;
		this.courseBookHistory = courseBookHistory;
	}
	
    public void notifyManager(DigitalItem requestedTextbook) {

    } 
	
	public ArrayList<Course> getCurrentCourses() {
		return currentCourses;
	}

	public void setCurrentCourses(ArrayList<Course> currentCourses) {
		this.currentCourses = currentCourses;
	}

	public ArrayList<DigitalItem> getCourseBookHistory() {
		return courseBookHistory;
	}

	public void setCourseBookHistory(ArrayList<DigitalItem> courseBookHistory) {
		this.courseBookHistory = courseBookHistory;
	}
	
    public void coursesAndTextbooks(Faculty user) {
        System.out.println("Courses taught by the " + user.getEmail() + ":" );
        for (Course course : user.currentCourses) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Textbook: " + course.getCurrentCourseBook().getName());
            System.out.println();
        }

        System.out.println("Textbooks previously used by the " + user.getEmail() + ":");
        for (DigitalItem textbook : user.courseBookHistory) {
            System.out.println("Textbook Name: " + textbook.getName());
        }
    }
    
//    public void notifyNewEdition(Faculty user, DigitalItem Textbook) throws Exception {
//    	String arr[] = new String[2];
//    	arr = user.getEmail().split("@");
//    	database.loadDigItems(textbooks, arr[0]);
//    	
//    	if()
//    } 
    public void notifyUserOfNewEditions() {
        for (DigitalItem textbook : textbooks) {
            for (DigitalItem historyItem : courseBookHistory) {
                if (textbook.getName().equals(historyItem.getName()) && 
                    Integer.parseInt(textbook.getEdition()) > Integer.parseInt(historyItem.getEdition())) {
                    System.out.println("Notification: Newer edition of " + textbook.getName() + " available.");
                    // now after getting new edition availability notify the user if a newer one is available
                }
            }
        }
    }
    
    public void loadTextbooksFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String edition = parts[1];
                // Assuming other attributes of DigitalItem are also stored in the file and read here
                DigitalItem textbook = new DigitalItem(name, edition, edition, edition, edition, edition); // Create DigitalItem object
                textbooks.add(textbook); // Add textbook to the textbooks ArrayList
            }
        }
    }
    
}
