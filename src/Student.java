import java.util.ArrayList;
import java.util.Date;

public class Student extends Decorator {
	
	public Student(String name, String email, String password, String accType) {
		super(name, email, password, accType);
	}
	
	public Student(Account account, String name, String email, String password, String accType) {
		super(account, name, email, password, accType);
		// TODO Auto-generated constructor stub
	}
	
	public Student(Account account, String name, String email, String password, String accType, 
			ArrayList<DigitalItem> digitalItemList, ArrayList<PhysicalItem> physicalItemList) {
		super(account, name, email, password, accType, digitalItemList, physicalItemList);

	}

	protected void makeCopy(Item textbook) {
		
	}
	
	protected void removeCopy(Item textbook) {
		
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
