import java.util.ArrayList;

public class Faculty extends Account{
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
