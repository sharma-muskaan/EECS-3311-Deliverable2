import java.util.ArrayList;

public class Course {
	protected String courseName;
	protected DigitalItem currentCourseBook;
	protected ArrayList<DigitalItem> courseBookHistory;
	
	public Course(String courseName) {
		this.courseName = courseName;
		courseBookHistory = new ArrayList<DigitalItem>();
	}
	
	public Course(String courseName, ArrayList<DigitalItem> courseBooks) {
		this.courseName = courseName;
		this.courseBookHistory = courseBooks;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public ArrayList<DigitalItem> getCourseBooks() {
		return courseBookHistory;
	}

	public void setCourseBooks(ArrayList<DigitalItem> courseBooks) {
		this.courseBookHistory = courseBooks;
	}

	public DigitalItem getCurrentCourseBook() {
		return currentCourseBook;
	}

	public void setCurrentCourseBook(DigitalItem currentCourseBook) {
		this.currentCourseBook = currentCourseBook;
	}
	
	public void addCourseBook(DigitalItem courseBook) {
		courseBookHistory.add(courseBook);
		this.setCurrentCourseBook(courseBook);
	}
	
}
