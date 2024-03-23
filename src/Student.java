import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Student extends AccountDecorator {
	
	protected ArrayList<Course> currentCourses;
	// digitalCourseBooks = student_digItem_data.csv
	protected ArrayList<DigitalItem> digitalCourseBooks;
	
	public Student(Account account) {
		super(account);
		currentCourses = new ArrayList<Course>();
		digitalCourseBooks = new ArrayList<DigitalItem>();
	}
	
	public ArrayList<Course> getCurrentCourses() {
		return currentCourses;
	}

	public void setCurrentCourses(ArrayList<Course> currentCourses) {
		this.currentCourses = currentCourses;
	}

	public ArrayList<DigitalItem> getDigitalCourseBooks() {
		return digitalCourseBooks;
	}

	public void setDigitalCourseBooks(ArrayList<DigitalItem> digitalCourseBooks) {
		this.digitalCourseBooks = digitalCourseBooks;
	}
	
	protected void makeCopy(Item textbook) {
		//TODO - IMPLEMENT
	}
	
	protected void removeCopy(Item textbook) {
		//TODO - IMPLEMENT
	}

	public static void main(String[] args) {
		
		Account a = new ConcreteAccount("billy@gmail.com","BPW","Student",0,0,false);
		
		DigitalItem b1 = new DigitalItem("RegBook", "horror", "Harry Potter", "Author", "Edition", "Publisher");
		DigitalItem b2 = new DigitalItem("TextBook", "Educational", "Discrete Math", "Author", "9th Edition", "Publisher");
		DigitalItem b3 = new DigitalItem("RegBook", "horror", "Percy Jackson", "Author", "Edition", "Publisher");
		DigitalItem b4 = new DigitalItem("RegBook", "horror", "Hunger Games", "Author", "Edition", "Publisher");
		DigitalItem b5 = new DigitalItem("TextBook", "Educational", "Biology", "Author", "9th Edition", "Publisher");
		DigitalItem b6 = new DigitalItem("TextBook", "Self Improvement", "Yoga", "Author", "9th Edition", "Publisher");

		a.request(b1);
		a.request(b3);
		a.request(b5);
		a.request(b4);
		a.request(b2);
		a.request(b6);
		a.sort();
		System.out.println();
		a.printReqs();

	}
}
