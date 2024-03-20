import java.util.ArrayList;
import java.util.Date;

public class Course {
	protected String courseName;
	protected DigitalItem currentCourseBook;
	protected ArrayList<DigitalItem> courseBookHistory;
	protected Date courseEndDate;
	
	public Course(String courseName, ArrayList<DigitalItem> courseBooks, Date courseEndDate) {
		this.courseName = courseName;
		this.courseBookHistory = courseBooks;
		this.courseEndDate = courseEndDate;
	}

	public String getCourseName() {
		return courseName;
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
	

	public ArrayList<DigitalItem> getCourseBookHistory() {
		return courseBookHistory;
	}

	public void setCourseBookHistory(ArrayList<DigitalItem> courseBookHistory) {
		this.courseBookHistory = courseBookHistory;
	}

	public Date getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	public void addCourseBook(DigitalItem courseBook) {
		courseBookHistory.add(courseBook);
		this.setCurrentCourseBook(courseBook);
	}
	
}
