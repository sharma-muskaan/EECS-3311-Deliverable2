import java.util.ArrayList;
import java.util.Date;

public class Faculty extends Decorator{
	
	protected String courseName;
	private Originator originator;
	protected ArrayList<String> currentCourses;
	private ArrayList<Originator.Memento> textbookHistory;
	
	public Faculty(Account account) {
		super(account);
		this.courseName = courseName;
		this.currentCourses = currentCourses;
		
		currentCourses = new ArrayList<String>();
		textbookHistory = new ArrayList<Originator.Memento>();
	}
	
	public Faculty(Account account, ArrayList<String> currentCourses) {
		super(account);
		this.courseName = courseName;
		this.currentCourses = currentCourses;
		
		this.currentCourses = currentCourses;
		textbookHistory = new ArrayList<Originator.Memento>();
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
	
	public Faculty(Account account, ArrayList<String> currentCourses, ArrayList<Originator.Memento> textbookHistory) {
		super(account);
		this.courseName = courseName;
		this.currentCourses = currentCourses;
		
		this.currentCourses = currentCourses;
		this.textbookHistory = textbookHistory;
	}

	public void notifyManager() {
		//TODO - IMPLEMENT
	}
	
	public ArrayList<String> getCourses() {
		return currentCourses;
	}
	
	public void addCourse(String course) {
		currentCourses.add(course);
	}
	
	//Should this be arraylist?
	public String textbooksUsed() {
		return courseName;
	}
	
	public void saveTextbookState() {
		//TODO - IMPLEMENT
	}
	
	public void undoTextbookState() {
		//TODO - IMPLEMENT
	}
}
