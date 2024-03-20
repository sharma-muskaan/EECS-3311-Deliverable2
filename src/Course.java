import java.util.ArrayList;
import java.util.Date;

public class Course {
	protected String courseName;
	protected DigitalItem currentCourseBook;
	protected Date courseEndDate;
	
	public Course(String courseName, DigitalItem currentCourseBook, Date courseEndDate) {
		this.courseName = courseName;
		this.currentCourseBook = currentCourseBook;
		this.courseEndDate = courseEndDate;
	}

	public String getCourseName() {
		return courseName;
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
