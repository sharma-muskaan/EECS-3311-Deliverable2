import java.util.ArrayList;
import java.util.Date;

public class ConcreteAccount implements Account {
    protected String email;
    protected String password;
    protected String accType;
    public boolean approved;
	protected ArrayList<DigitalItem> digitalItemList;
	protected ArrayList<PhysicalItem> physicalItemList;
	
	public ConcreteAccount(String email, String password, String accType) {
		this.email = email;
		this.password = password;
		this.accType = accType;
		digitalItemList = new ArrayList<>();
		physicalItemList = new ArrayList<>();
		approved = false;
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
	@Override
	public void setApproved(boolean approved) {
    	this.approved = approved;
    }
}
