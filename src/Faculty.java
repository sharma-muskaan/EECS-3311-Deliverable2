import java.util.ArrayList;
import java.util.Date;

public class Faculty extends AccountDecorator{
	
	protected ArrayList<Course> currentCourses;
	// courseBookHistory = faculty_digItem_data.csv
	protected ArrayList<DigitalItem> courseBookHistory;
	
	public Faculty(Account account) throws Exception {
		super(account);
		currentCourses = new ArrayList<Course>();
		courseBookHistory = new ArrayList<>();
	}
	
	public Faculty(Account account, ArrayList<Course> currentCourses, ArrayList<DigitalItem> courseBookHistory) throws Exception {
		super(account);
		this.currentCourses = currentCourses;
		this.courseBookHistory = courseBookHistory;
	}

	public void notifyManager() {
		//TODO - IMPLEMENT
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
}
