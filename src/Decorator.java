import java.util.ArrayList;
import java.util.Date;

public class Decorator implements Account {
	
	protected Account wrappee;
	
	public Decorator(Account account) {
		wrappee = account;
	}

	@Override
	public void openOnlineBook(DigitalItem digItem) {
		wrappee.openOnlineBook(digItem);;
	}


	@Override
	public ArrayList<Item> search(String search) {
		return wrappee.search(search);
	}


	@Override
	public void subToNews(DigitalItem digItem) {
		wrappee.subToNews(digItem);
	}


	@Override
	public void rentBook(PhysicalItem physItem) {
		wrappee.rentBook(physItem);
	}


	@Override
	public void purchaseItem(Item item) {
		wrappee.purchaseItem(item);
	}


	@Override
	public Date getDueDate() {
		return wrappee.getDueDate();
	}


	@Override
	public void returnBook(PhysicalItem physItem) {
		wrappee.returnBook(physItem);
	}


	@Override
	public ArrayList<DigitalItem> getDigitalItemList() {
		return wrappee.getDigitalItemList();
	}


	@Override
	public ArrayList<PhysicalItem> getPhysicalItemList() {
		return wrappee.getPhysicalItemList();
	}


	@Override
	public String getEmail() {
		return wrappee.getEmail();
	}


	@Override
	public String getPass() {
		return wrappee.getPass();
	}


	@Override
	public String getAccType() {
		return wrappee.getAccType();
	}


	@Override
	public void setEmail(String email) {
		wrappee.setEmail(email);
	}


	@Override
	public void setPassword(String pass) {
		wrappee.setPassword(pass);
	}


	@Override
	public void setAccType(String type) {
		wrappee.setAccType(type);
	}


	@Override
	public void setApproved(boolean approved) {
		wrappee.setApproved(approved);
	}
}