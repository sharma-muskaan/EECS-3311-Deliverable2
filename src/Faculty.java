import java.util.ArrayList;

public class Faculty extends Decorator{
	public Faculty(String email, String password, String accType) {
		super(email, password, accType);
		// TODO Auto-generated constructor stub
	}

	protected String courseName;
	protected ArrayList<String> currentCourses;
	private Originator originator;
	private ArrayList<Originator.Memento> textbookHistory;
	
	protected void notifyManager() {
		
	}
	
	public ArrayList<String> getCourses() {
		return currentCourses;
	}
	
	public void setCourses(ArrayList<String> currentCourses) {
		this.currentCourses = currentCourses;
	}
	
	public String textbooksUsed() {
		return null;
		
	}
	
	public void saveTextbookState() {
		
	}
	
	public void undoTextbookState() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
