import java.util.ArrayList;
import java.util.Date;

public class Course {
	protected String courseName;
	protected DigitalItem currentCourseBook;
	protected Date courseEndDate;
	private static LibraryDatabase database;
	
	public Course(String courseName, DigitalItem currentCourseBook, Date courseEndDate) throws Exception {
		this.courseName = courseName;
		this.currentCourseBook = currentCourseBook;
		this.courseEndDate = courseEndDate;
		database = LibraryDatabase.getInstance();
	}

	public String getCourseName() {
		return courseName;
	}
	
	//adds original course book to course book history, sets current course book to new course book
	public void updateCourseBook(Faculty user, DigitalItem newCourseBook) throws Exception {
		user.courseBookHistory.add(newCourseBook);
		currentCourseBook = newCourseBook;
		database.updateCourses(database.coursesDB, courseName);
		database.updateDigItems(user.getCourseBookHistory(), courseName);
	}

	public DigitalItem getCurrentCourseBook() {
		return currentCourseBook;
	}

	public void setCurrentCourseBook(DigitalItem currentCourseBook) {
		this.currentCourseBook = currentCourseBook;
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
}
