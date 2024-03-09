import java.util.ArrayList;
import java.util.Date;

public class Account {
	protected ArrayList<DigitalItem> digitalItemList = new ArrayList<>();
	protected ArrayList<PhysicalItem> physicalItemList = new ArrayList<>();
	
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
