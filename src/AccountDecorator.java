import java.util.ArrayList;
import java.util.Date;

public class AccountDecorator implements Account {
	
	protected Account wrappee;
	
	public AccountDecorator(Account account) {
		wrappee = account;
	}

	@Override
	public void openOnlineBook(DigitalItem digItem) {
		wrappee.openOnlineBook(digItem);
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
	public int getItemsBorrowed() {
		return wrappee.getItemsBorrowed();
	}

	@Override
	public int getOverdueItems() {
		return wrappee.getOverdueItems();
	}

	@Override
	public boolean isAccountLocked() {
		return wrappee.isAccountLocked();
	}

	@Override
	public void setItemsBorrowed(int itemsBorrowed) {
		wrappee.setItemsBorrowed(itemsBorrowed);
	}

	@Override
	public void setOverdueItems(int overdueItems) {
		wrappee.setOverdueItems(overdueItems);
	}

	@Override
	public void setAccountLocked(boolean accountLocked) {
		wrappee.setAccountLocked(accountLocked);
	}
}