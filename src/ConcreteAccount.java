
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class ConcreteAccount implements Account {
    protected String email;
    protected String password;
    protected String accType;
    
    protected int itemsBorrowed;
    protected int overdueItems;
    protected boolean accountLocked;
    
	protected ArrayList<DigitalItem> digitalItemList;
	protected ArrayList<PhysicalItem> physicalItemList;

	protected ArrayList<DigitalItem> reqs = new ArrayList<>();

	public ConcreteAccount(String email, String password, String accType,
			int itemsBorrowed, int overdueItems, boolean accountLocked) {
		this.email = email;
		this.password = password;
		this.accType = accType;
		
		this.accountLocked  = accountLocked;
		this.overdueItems = overdueItems;
		this.accountLocked = accountLocked;
		
		digitalItemList = new ArrayList<>();
		physicalItemList = new ArrayList<>();
	}


	@Override
	public void openOnlineBook(DigitalItem digItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Item> search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subToNews(DigitalItem digItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rentBook(PhysicalItem physItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void purchaseItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getDueDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void returnBook(PhysicalItem physItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<DigitalItem> getDigitalItemList() {
		return digitalItemList;
	}

	@Override
	public ArrayList<PhysicalItem> getPhysicalItemList() {
		return physicalItemList;
	}
	
	@Override
	public String getEmail(){
        return this.email;
    }
	@Override
	public String getPass(){
        return this.password;

    }
	@Override
	public String getAccType(){
        return this.accType;
    }
	@Override
	public void setEmail(String email){
        this.email = email;
    }
	@Override
	public void setPassword(String pass){
        this.password = pass;
    }
	@Override
	public void setAccType(String type){
        this.accType = type;
    }
	public int getItemsBorrowed() {
		return itemsBorrowed;
	}
	@Override
	public void setItemsBorrowed(int itemsBorrowed) {
		this.itemsBorrowed = itemsBorrowed;
	}
	@Override
	public int getOverdueItems() {
		return overdueItems;
	}
	@Override
	public void setOverdueItems(int overdueItems) {
		this.overdueItems = overdueItems;
	}
	@Override
	public boolean isAccountLocked() {
		return accountLocked;
	}
	@Override
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}


}

