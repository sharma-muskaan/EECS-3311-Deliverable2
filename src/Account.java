import java.util.ArrayList;
import java.util.Date;

public class Account extends Register {
	
	protected ArrayList<DigitalItem> digitalItemList = new ArrayList<>();
	protected ArrayList<PhysicalItem> physicalItemList = new ArrayList<>();
	
	public Account(String email, String password, String accType) {
		super(email, password, accType);
	}

	protected void openOnlineBook(DigitalItem digItem) {
		
	}
	
	public ArrayList<Item> search(String search) {
		return null;
	}
	
	protected void subToNews(DigitalItem digItem) {
		
	}
	
	protected void rentBook(PhysicalItem physItem) {
		
	}
	
	protected void purchaseItem(Item item) {
		
	}
	
	protected Date getDueDate() {
		return null;
	}
	
	protected void returnBook(PhysicalItem physItem) {
		
	}
		
}
