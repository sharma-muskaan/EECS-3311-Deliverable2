import java.util.ArrayList;
import java.util.Date;

public class Faculty extends AccountDecorator{
	
	protected ArrayList<String> currentCourses;
	// courseBookHistory = faculty_digItem_data.csv
	protected ArrayList<DigitalItem> courseBookHistory;
	
	public Faculty(Account account) {
		super(account);
		currentCourses = new ArrayList<String>();
		courseBookHistory = new ArrayList<>();
	}
	
	public Faculty(Account account, ArrayList<String> currentCourses, ArrayList<DigitalItem> courseBookHistory) {
		super(account);
		this.currentCourses = currentCourses;
		this.courseBookHistory = courseBookHistory;
	}
	
//	TODO - FIGURE OUT CONSTRUCTORS NEEDED	
//	public Faculty(Account account, ArrayList<Originator.Memento> textbookHistory) {
//		super(account);
//		this.courseName = courseName;
//		this.currentCourses = currentCourses;
//		
//		currentCourses = new ArrayList<String>();
//		this.textbookHistory = textbookHistory;
//	}

	public void notifyManager() {
		//TODO - IMPLEMENT
	}
	
	public ArrayList<String> getCourses() {
		return currentCourses;
	}
	
	public void addCourse(String course) {
		currentCourses.add(course);
	}
	
	public ArrayList<DigitalItem> courseBookHistory() {
		return courseBookHistory;
	}
	
	
}
