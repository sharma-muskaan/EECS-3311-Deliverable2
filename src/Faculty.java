import java.util.ArrayList;
import java.util.Date;

public class Faculty extends Decorator{
	protected String courseName;
	protected ArrayList<String> currentCourses;
	private Originator originator;
	private ArrayList<Originator.Memento> textbookHistory;
	
	public Faculty(String name, String email, String password, String accType) {
		super(name, email, password, accType);
	}
	
	public Faculty(Account account, String name, String email, String password, String accType,
			String courseName, ArrayList<String> currentCourses, ArrayList<Originator.Memento> textbookHistory) {
		super(account, name, email, password, accType);
		this.courseName = courseName;
		this.currentCourses = currentCourses;
		this.textbookHistory = textbookHistory;
	}
	
	public Faculty(Account account, String name, String email, String password, String accType, 
			ArrayList<DigitalItem> digitalItemList, ArrayList<PhysicalItem> physicalItemList, 
			String courseName, ArrayList<String> currentCourses, ArrayList<Originator.Memento> textbookHistory) {
		super(account, name, email, password, accType, digitalItemList, physicalItemList);
		this.courseName = courseName;
		this.currentCourses = currentCourses;
		this.textbookHistory = textbookHistory;
	}
	
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

	@Override
	protected void openOnlineBook(DigitalItem digItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Item> search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void subToNews(DigitalItem digItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void rentBook(PhysicalItem physItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void purchaseItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Date getDueDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void returnBook(PhysicalItem physItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<DigitalItem> getDigitalItemList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ArrayList<PhysicalItem> getPhysicalItemList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
