import java.util.ArrayList;
import java.util.Date;

public abstract class Account extends Register {
	
	protected ArrayList<DigitalItem> digitalItemList = new ArrayList<>();
	protected ArrayList<PhysicalItem> physicalItemList = new ArrayList<>();
	
	public Account(String name, String email, String password, String accType) {
		super(name, email, password, accType);
	}
	
	public Account(String name, String email, String password, String accType, 
			ArrayList<DigitalItem> digitalItemList, ArrayList<PhysicalItem> physicalItemList) {
		super(name, email, password, accType);
		this.digitalItemList = digitalItemList;
		this.physicalItemList = physicalItemList;
	}
	

	protected abstract void openOnlineBook(DigitalItem digItem);
	
	public abstract ArrayList<Item> search(String search);
	
	protected abstract void subToNews(DigitalItem digItem);
	
	protected abstract void rentBook(PhysicalItem physItem);
		
	protected abstract void purchaseItem(Item item);
	
	protected abstract Date getDueDate();
	
	protected abstract void returnBook(PhysicalItem physItem);
	
	protected abstract ArrayList<DigitalItem> getDigitalItemList();
	
	protected abstract ArrayList<PhysicalItem> getPhysicalItemList();
			
}
